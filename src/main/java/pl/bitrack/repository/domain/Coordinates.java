package pl.bitrack.repository.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Data
@Builder
public class Coordinates {

    BigDecimal lng;
    BigDecimal lat;
    Long zLevel;

}
