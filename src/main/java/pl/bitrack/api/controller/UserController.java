package pl.bitrack.api.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.extern.slf4j.Slf4j;
import pl.bitrack.api.dto.UserDto;
import pl.bitrack.repository.domain.Status;
import pl.bitrack.service.impl.UserService;
import pl.bitrack.utils.UserModelDtoMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Slf4j
@Controller("/users")
public class UserController {

    private final UserService userService;
    private final UserModelDtoMapper mapper;

    public UserController(UserService userService, UserModelDtoMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Get(value = "/{uuid}", produces = MediaType.APPLICATION_JSON)
    public Mono<UserDto> getByUuid(UUID uuid) {
        return Mono.just(userService.getById(uuid))
                .doOnNext(user -> log.info("Returning user with UUID: {}", user.getUuid()))
                .map(mapper::toDto)
                .doOnError(error -> log.error("User with cannot be returned, error occured: {}", error.getMessage()));
    }

    @Get(value = "/status/{status}", produces = MediaType.APPLICATION_JSON)
    public Flux<UserDto> getAllUsersInside(Status status) {
        return Flux.fromIterable(userService.getAllByStatus(status))
                .map(mapper::toDto);
    }

}
