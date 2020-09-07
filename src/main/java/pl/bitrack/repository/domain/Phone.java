package pl.bitrack.repository.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Builder
@Data
@AllArgsConstructor
public class Phone {

    UUID uuid;
    Long id;
    Long number;

}
