package pl.bitrack.messaging.websocket;

import io.micronaut.scheduling.annotation.Scheduled;
import io.micronaut.websocket.WebSocketBroadcaster;

import javax.inject.Singleton;

/**
 * @author Tomasz Szymeczek
 * Date 09/09/2020
 */
@Singleton
public class WebsocketMessageScheduler {

    private static final String SCHEDULER_INTERVAL_VALUE = "1s";

    private final WebSocketBroadcaster broadcaster;

    public WebsocketMessageScheduler(WebSocketBroadcaster broadcaster) {
        this.broadcaster = broadcaster;
    }

    @Scheduled(fixedDelay = SCHEDULER_INTERVAL_VALUE)
    public void scheduleMockedPositions() {

        // TODO here we can publish mocked users positions into websocket
        broadcaster.broadcastSync("message");
    }

}
