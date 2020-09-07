package pl.bitrack.service;

import java.util.UUID;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
public interface Service<E>{

    E getById(UUID uuid);

}
