package pl.bitrack.messaging.listener;

import pl.bitrack.messaging.Listener;
import pl.bitrack.messaging.handler.MqttEventHandler;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
public class MqttListener implements Listener {

    private final MqttEventHandler eventHandler;

    public MqttListener(MqttEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }


    // here we should listen to events from MQTT and handle them with MqttEventHandler

}
