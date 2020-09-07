package pl.bitrack.repository.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Data
@Builder
public class Coordinates {

    Long x;
    Long y;
    Floor floor;

}
