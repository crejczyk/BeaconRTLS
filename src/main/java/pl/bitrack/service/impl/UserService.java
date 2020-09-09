package pl.bitrack.service.impl;

import pl.bitrack.repository.domain.Coordinates;
import pl.bitrack.repository.domain.Status;
import pl.bitrack.repository.domain.User;
import pl.bitrack.repository.impl.UserRepository;
import pl.bitrack.service.Service;

import javax.inject.Singleton;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Singleton
public class UserService implements Service<User> {

    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    @Override
    public User getById(UUID uuid) {
        return userRepository.getById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("User with that UUID does not exist"));
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public List<User> getAllByStatus(Status status) {
        return userRepository.getAll().stream()
                .filter(user -> user.getStatus() == status)
                .collect(Collectors.toList());
    }

    public User update(UUID uuid, Coordinates coordinates) {
        User user = getById(uuid);
        // TODO probably here we gonna make some calculations for current position
        user.setCoordinates(coordinates);
        return userRepository.update(user);
    }

}
