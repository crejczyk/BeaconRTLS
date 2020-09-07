package pl.bitrack.service.impl;

import pl.bitrack.repository.domain.Status;
import pl.bitrack.repository.impl.UserRepository;
import pl.bitrack.repository.domain.User;
import pl.bitrack.service.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
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

    public List<User> getAllByStatus(Status status) {
        return userRepository.getAll().stream()
                .filter(user -> user.getStatus() == status)
                .collect(Collectors.toList());
    }

}
