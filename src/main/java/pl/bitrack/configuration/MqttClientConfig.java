package pl.bitrack.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;
import com.hivemq.client.mqtt.mqtt5.Mqtt5Client;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import lombok.extern.slf4j.Slf4j;
import pl.bitrack.messaging.EventHandler;
import pl.bitrack.messaging.event.MqttUpdatePositionEvent;

import javax.inject.Singleton;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Singleton
@Slf4j
public class MqttClientConfig implements ApplicationEventListener<ServerStartupEvent> {

    private static final int BATCH_SIZE = 5;
    private static final String TOPIC = "test/topic";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private EventHandler eventHandler;

    public MqttClientConfig(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        final Mqtt5BlockingClient client = Mqtt5Client.builder()
                .identifier(UUID.randomUUID().toString())
                .serverHost("localhost")
                .buildBlocking();
        client.connect();
        log.info("MqttClient was connected...");

        List<MqttUpdatePositionEvent> mqttUpdatePositionEvent = new ArrayList<>();
        client.toAsync().subscribeWith()
                .topicFilter(TOPIC)
                .qos(MqttQos.AT_LEAST_ONCE)
                .callback(data -> {
                    synchronized (this) {
                        try {
                            mqttUpdatePositionEvent.add(getMqttUpdatePosition(data));
                            if (mqttUpdatePositionEvent.size() == BATCH_SIZE) {
                                eventHandler.handle(mqttUpdatePositionEvent);
                                mqttUpdatePositionEvent.clear();
                            }
                        } catch (IOException e) {
                            log.warn(e.getMessage(), e);
                        }
                    }
                })
                .send();
    }

    private MqttUpdatePositionEvent getMqttUpdatePosition(com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish data) throws IOException {
        return OBJECT_MAPPER.readValue(data.getPayloadAsBytes(), MqttUpdatePositionEvent.class);
    }

}
