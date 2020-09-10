package pl.bitrack.messaging.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import pl.bitrack.repository.domain.Coordinates;

import java.util.UUID;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Data
@AllArgsConstructor
public class MqttUpdatePositionEvent {

    String sensorId;
    String uuid;
    int rssi;

}
