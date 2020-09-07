package pl.bitrack.configuration;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.websocket.WebSocketBroadcaster;
import pl.bitrack.messaging.websocket.WebsocketMessageServer;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Factory
public class WebsocketServerConfiguration {

    @Bean
    public WebsocketMessageServer websocketServer(WebSocketBroadcaster broadcaster) {
        return new WebsocketMessageServer(broadcaster);
    }

}
