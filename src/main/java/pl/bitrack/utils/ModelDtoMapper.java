package pl.bitrack.utils;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
public interface ModelDtoMapper<M, D> {

    M toModel(D d);
    D toDto(M m);

}
