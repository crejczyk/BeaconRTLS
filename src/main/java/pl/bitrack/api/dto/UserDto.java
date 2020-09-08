package pl.bitrack.api.dto;

import lombok.Builder;
import lombok.Data;
import pl.bitrack.repository.domain.Coordinates;
import pl.bitrack.repository.domain.Phone;
import pl.bitrack.repository.domain.Status;
import pl.bitrack.repository.domain.Type;

import java.util.UUID;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Builder
@Data
public class UserDto {

    UUID uuid;
    String firstName;
    String lastName;
    Phone phone;
    Status status;
    Coordinates coordinates;
    Type type;

}
