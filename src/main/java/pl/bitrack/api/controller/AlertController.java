package pl.bitrack.api.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Slf4j
@Controller("/alert")
public class AlertController {

    @Get(value = "/fire")
    public void fire() {
        log.info("Alert has been fired at: {}", LocalDateTime.now());
        // here we should call some scheduler service that gonna run evacuation
    }

    @Get(value = "/stop")
    public void stop() {
        log.info("Alert has been stopped at: {}", LocalDateTime.now());
        // here we should call some scheduler service that gonna stop evacuation
    }

}
