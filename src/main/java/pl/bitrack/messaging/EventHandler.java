package pl.bitrack.messaging;

import pl.bitrack.messaging.event.MqttUpdatePositionEvent;

import java.util.List;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
public interface EventHandler {

    void handle(List<MqttUpdatePositionEvent> event);

}
