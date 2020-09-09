package pl.bitrack.api.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.extern.slf4j.Slf4j;
import pl.bitrack.api.dto.SensorDto;
import pl.bitrack.service.impl.SensorService;
import pl.bitrack.utils.impl.SensorMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Slf4j
@Controller("/api/sensors")
public class SensorController {

    private final SensorService sensorService;
    private final SensorMapper mapper;

    public SensorController(SensorService sensorService, SensorMapper mapper) {
        this.sensorService = sensorService;
        this.mapper = mapper;
    }

    @Get(value = "/{uuid}", produces = MediaType.APPLICATION_JSON)
    public Mono<SensorDto> getByUuid(UUID uuid) {
        return Mono.just(sensorService.getById(uuid))
                .doOnNext(sensor -> log.info("Returning sensor with UUID: {}", sensor.getUuid()))
                .map(mapper::toDto)
                .doOnError(error ->
                        log.error("Sensor with UUID {} cannot be returned, error occurred: {}",
                                uuid,
                                error.getMessage()));
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public Flux<SensorDto> getAllSensors() {
        return Flux.fromIterable(sensorService.getAll())
                .map(mapper::toDto)
                .doOnError(error ->
                        log.error("Sensors cannot be returned, error occurred: {}", error.getMessage()));
    }

}
