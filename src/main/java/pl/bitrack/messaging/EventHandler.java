package pl.bitrack.messaging;

import pl.bitrack.messaging.event.MqttUpdatePositionEvent;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
public interface EventHandler {

    void handle(MqttUpdatePositionEvent event);

}
