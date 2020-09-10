package pl.bitrack.messaging.handler;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import pl.bitrack.messaging.EventHandler;
import pl.bitrack.messaging.event.MqttUpdatePositionEvent;

import javax.inject.Inject;
import java.util.List;

@MicronautTest
class EventHandlerTest {

    @Inject
    EventHandler eventHandler;

    @Test
    void testComputePosition() {
        List<MqttUpdatePositionEvent> mqttUpdatePositionEventList = List.of(new MqttUpdatePositionEvent("#1", "#uuid#1", -25),
                new MqttUpdatePositionEvent("#1", "#uuid#2", -21),
                new MqttUpdatePositionEvent("#1", "#uuid#3", -25),
                new MqttUpdatePositionEvent("#1", "#uuid#4", -23));
        eventHandler.handle(mqttUpdatePositionEventList);
    }
}