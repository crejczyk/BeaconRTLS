package pl.bitrack.utils.impl;

import pl.bitrack.api.dto.SensorDto;
import pl.bitrack.repository.domain.Sensor;
import pl.bitrack.utils.ModelDtoMapper;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
public class SensorMapper implements ModelDtoMapper<Sensor, SensorDto> {

    @Override
    public Sensor toModel(SensorDto sensorDto) {
        return Sensor.builder()
                .uuid(sensorDto.getUuid())
                .coordinates(sensorDto.getCoordinates())
                .build();
    }

    @Override
    public SensorDto toDto(Sensor sensor) {
        return SensorDto.builder()
                .uuid(sensor.getUuid())
                .coordinates(sensor.getCoordinates())
                .build();
    }

}
