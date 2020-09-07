package pl.bitrack.repository.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Builder
@Data
public class PhoneNumber {

    UUID uuid;
    Long id;
    Long number;

}
