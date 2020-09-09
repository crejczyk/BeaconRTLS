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
public class UserRepository implements Repository<User> {

    private static final Map<UUID, User> USERS_DB_MOCK = new HashMap<>();

    static {
        UUID TSuuid = UUID.randomUUID();
        USERS_DB_MOCK.put(TSuuid, User.builder()
                .uuid(TSuuid)
                .firstName("Tomasz")
                .lastName("Szymeczek")
                .id(1L)
                .phone("123456789")
                .status(Status.OUTSIDE)
                .type(Type.EMPLOYEE)
                .coordinates(Coordinates.builder()
                        .lng(BigDecimal.ZERO)
                        .lat(BigDecimal.ZERO)
                        .zLevel(0L)
                        .build())
                .build()
        );
        UUID CRuuid = UUID.randomUUID();
        USERS_DB_MOCK.put(CRuuid, User.builder()
                .uuid(CRuuid)
                .firstName("Cezary")
                .lastName("Rejczyk")
                .id(2L)
                .phone("123456789L")
                .status(Status.OUTSIDE)
                .type(Type.COMPANY_GUEST)
                .coordinates(Coordinates.builder()
                        .lng(BigDecimal.TEN)
                        .lat(BigDecimal.TEN)
                        .zLevel(1L)
                        .build())
                .build()
        );
        UUID KBuuid = UUID.randomUUID();
        USERS_DB_MOCK.put(KBuuid, User.builder()
                .uuid(KBuuid)
                .firstName("Korneliusz")
                .lastName("Buczkowski")
                .id(3L)
                .phone("987654321L")
                .status(Status.INSIDE)
                .type(Type.GUEST)
                .coordinates(Coordinates.builder()
                        .lng(BigDecimal.ONE)
                        .lat(BigDecimal.ONE)
                        .zLevel(2L)
                        .build())
                .build()
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
