package pl.bitrack.messaging.handler;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import pl.bitrack.messaging.EventHandler;
import pl.bitrack.messaging.event.MqttUpdatePositionEvent;
import pl.bitrack.service.impl.UserService;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Singleton
@Slf4j
public class MqttEventHandler implements EventHandler {

    private static double[][] POSITIONS = new double[][]{{5.0, -6.0}, {13.0, -15.0}, {21.0, -3.0}, {12.4, -21.2}};
    private static double ENVIRONMENTAL_FACTOR = 2;
    private static int MEASURED_POWER = -69;

    private final UserService userService;

    public MqttEventHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void handle(List<MqttUpdatePositionEvent> event) {
        getMapOfSensors(event, MqttUpdatePositionEvent::getSensorId).forEach((sensor, listBySensors) ->
                getMapOfSensors(listBySensors, MqttUpdatePositionEvent::getUuid).forEach((uuid, listByUuid) -> {
                    double[] distances = listByUuid.stream().mapToDouble(data -> getDistance(data.getRssi())).toArray();
                    NonLinearLeastSquaresSolver solver = new NonLinearLeastSquaresSolver(new TrilaterationFunction(POSITIONS, distances), new LevenbergMarquardtOptimizer());
                    LeastSquaresOptimizer.Optimum optimum = solver.solve();
                    double[] centroid = optimum.getPoint().toArray();
                    log.info("Centroid: {}-{} :{}", sensor, uuid, centroid);
                }));
    }

    private Map<String, List<MqttUpdatePositionEvent>> getMapOfSensors(List<MqttUpdatePositionEvent> event, Function<MqttUpdatePositionEvent, String> groupBy) {
        return event.stream().collect(groupingBy(groupBy));
    }

    private double getDistance(int rssi) {
        return Math.pow(10, (MEASURED_POWER - rssi) / (10 * ENVIRONMENTAL_FACTOR));
    }


}
