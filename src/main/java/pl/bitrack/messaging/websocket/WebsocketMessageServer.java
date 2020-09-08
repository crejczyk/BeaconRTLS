package pl.bitrack.messaging.websocket;

import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Slf4j
@Singleton
@ServerWebSocket("/ws/users")
public class WebsocketMessageServer {

    private final WebSocketBroadcaster broadcaster;

    public WebsocketMessageServer(WebSocketBroadcaster broadcaster) {
        this.broadcaster = broadcaster;
    }

    @OnOpen
    public Publisher<String> onOpen(WebSocketSession session) {
        return broadcaster.broadcast("Connected to websocket: " + session.getRequestURI());
    }

    @OnClose
    public Publisher<String> onClose(WebSocketSession session) {
        return broadcaster.broadcast("Disconnected from websocket");
    }

}
