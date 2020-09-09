package pl.bitrack.repository.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Sensor {

    UUID uuid;
    Coordinates coordinates;

}
