package pl.bitrack.repository.impl;

import pl.bitrack.repository.Repository;
import pl.bitrack.repository.domain.*;

import javax.inject.Singleton;
import java.util.*;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Singleton
public class UserRepository implements Repository<User> {

    private static final Map<UUID, User> USERS_DB_MOCK = new HashMap<>();

    static {
        UUID TSuuid = UUID.randomUUID();
        USERS_DB_MOCK.put(TSuuid, User.builder()
                .uuid(TSuuid)
                .firstName("Tomasz")
                .lastName("Szymeczek")
                .id(1L)
                .phone(new Phone(UUID.randomUUID(), 1L, 504745944L))
                .status(Status.OUTSIDE)
                .coordinates(Coordinates.builder()
                        .x(0L)
                        .y(0L)
                        .floor(Floor.builder()
                                .value(0L)
                                .build())
                        .build())
                .build()
        );
        UUID CRuuid = UUID.randomUUID();
        USERS_DB_MOCK.put(CRuuid, User.builder()
                .uuid(CRuuid)
                .firstName("Cezary")
                .lastName("Rejczyk")
                .id(2L)
                .phone(new Phone(UUID.randomUUID(), 2L, 123456789L))
                .status(Status.OUTSIDE)
                .coordinates(Coordinates.builder()
                        .x(20L)
                        .y(20L)
                        .floor(Floor.builder()
                                .value(1L)
                                .build())
                        .build()).build()
        );
        UUID KBuuid = UUID.randomUUID();
        USERS_DB_MOCK.put(KBuuid, User.builder()
                .uuid(KBuuid)
                .firstName("Korneliusz")
                .lastName("Buczkowski")
                .id(3L)
                .phone(new Phone(UUID.randomUUID(), 1L, 987654321L))
                .status(Status.INSIDE)
                .coordinates(Coordinates.builder()
                        .x(10L)
                        .y(10L)
                        .floor(Floor.builder()
                                .value(2L)
                                .build())
                        .build()).build()
        );
    }

    @Override
    public Optional<User> getById(UUID uuid) {
        return Optional.ofNullable(USERS_DB_MOCK.get(uuid));
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(USERS_DB_MOCK.values());
    }

    @Override
    public User update(User user) {
        return USERS_DB_MOCK.put(user.getUuid(), user);
    }

}
