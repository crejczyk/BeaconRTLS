package pl.bitrack.repository.impl;

import pl.bitrack.repository.Repository;
import pl.bitrack.repository.domain.*;

import javax.inject.Singleton;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Singleton
public class SensorRepository implements Repository<Sensor> {

    private static final Map<UUID, Sensor> SENSOR_DB_MOCK = new HashMap<>();

    static {
        UUID sensor1 = UUID.randomUUID();
        SENSOR_DB_MOCK.put(sensor1, Sensor.builder()
                .uuid(sensor1)
                .coordinates(Coordinates.builder()
                        .lat(BigDecimal.ONE)
                        .lng(BigDecimal.TEN)
                        .zLevel(0L)
                        .build())
                .build());
    }

    @Override
    public Optional<Sensor> getById(UUID uuid) {
        return Optional.ofNullable(SENSOR_DB_MOCK.get(uuid));
    }

    @Override
    public List<Sensor> getAll() {
        return new ArrayList<>(SENSOR_DB_MOCK.values());
    }

    @Override
    public Sensor update(Sensor sensor) {
        return SENSOR_DB_MOCK.put(sensor.getUuid(), sensor);
    }

}
