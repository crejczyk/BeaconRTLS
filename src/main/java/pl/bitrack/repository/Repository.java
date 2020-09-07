package pl.bitrack.repository;

import pl.bitrack.repository.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
public interface Repository<E> {

    Optional<E> getById(UUID uuid);

    List<E> getAll();

    E update(E e);

}
