package pl.bitrack.messaging.event;

import lombok.Value;
import pl.bitrack.repository.domain.Coordinates;

import java.util.UUID;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Value
public class MqttUpdatePositionEvent {

    UUID uuid;
    Coordinates coordinates;

}
