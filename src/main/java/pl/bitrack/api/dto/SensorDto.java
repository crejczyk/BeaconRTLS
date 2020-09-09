package pl.bitrack.api.dto;

import lombok.Builder;
import lombok.Data;
import pl.bitrack.repository.domain.Coordinates;

import java.util.UUID;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Data
@Builder
public class SensorDto {

    UUID uuid;
    Coordinates coordinates;

}
