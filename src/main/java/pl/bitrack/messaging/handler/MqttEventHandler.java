package pl.bitrack.messaging.handler;

import pl.bitrack.messaging.EventHandler;
import pl.bitrack.messaging.event.MqttUpdatePositionEvent;
import pl.bitrack.repository.domain.User;
import pl.bitrack.service.impl.UserService;

import javax.inject.Singleton;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Singleton
public class MqttEventHandler implements EventHandler {

    private final UserService userService;

    public MqttEventHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void handle(MqttUpdatePositionEvent event) {
        User updatedUser = userService.update(event.getUuid(), event.getCoordinates());
        // next step -> push to websocket
    }

}
