package pl.bitrack.api.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.extern.slf4j.Slf4j;
import pl.bitrack.api.dto.UserDto;
import pl.bitrack.repository.domain.Status;
import pl.bitrack.service.impl.UserService;
import pl.bitrack.utils.impl.UserMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Slf4j
@Controller("/api/users")
public class UserController {

    private final UserService userService;
    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Get(value = "/{uuid}", produces = MediaType.APPLICATION_JSON)
    public Mono<UserDto> getByUuid(UUID uuid) {
        return Mono.just(userService.getById(uuid))
                .doOnNext(user -> log.info("Returning user with UUID: {}", user.getUuid()))
                .map(mapper::toDto)
                .doOnError(error ->
                        log.error("User with UUDI {} cannot be returned, error occurred: {}",
                                uuid,
                                error.getMessage()));
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public Flux<UserDto> getAllUsers() {
        return Flux.fromIterable(userService.getAll())
                .map(mapper::toDto)
                .doOnError(error ->
                        log.error("Users cannot be returned, error occurred: {}", error.getMessage()));
    }

    @Get(value = "/status/{status}", produces = MediaType.APPLICATION_JSON)
    public Flux<UserDto> getAllUsersByStatus(Status status) {
        return Flux.fromIterable(userService.getAllByStatus(status))
                .map(mapper::toDto)
                .doOnError(error ->
                        log.error("Users with status {} cannot be returned, error occurred: {}",
                                status,
                                error.getMessage()));
    }

}
