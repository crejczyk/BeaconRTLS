package pl.bitrack.repository.impl;

import pl.bitrack.repository.Repository;
import pl.bitrack.repository.domain.User;

import java.util.*;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
public class UserRepository implements Repository<User> {

    private final Map<UUID, User> USERS = new HashMap<>();

    static {
    // here we gonna initialize some data
    }

    @Override
    public Optional<User> getById(UUID uuid) {
        return Optional.ofNullable(USERS.get(uuid));
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(USERS.values());
    }


}
