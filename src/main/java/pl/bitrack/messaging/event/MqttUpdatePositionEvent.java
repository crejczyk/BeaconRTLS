package pl.bitrack.messaging.event;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Value
@RequiredArgsConstructor
@AllArgsConstructor
public class MqttUpdatePositionEvent {

    String sensorId;
    String uuid;
    int rssi;

}
