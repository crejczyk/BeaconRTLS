package pl.bitrack.service.impl;

import pl.bitrack.repository.domain.Sensor;
import pl.bitrack.repository.impl.SensorRepository;
import pl.bitrack.service.Service;

import javax.inject.Singleton;
import java.util.List;
import java.util.UUID;

@Singleton
public class SensorService implements Service<Sensor> {

    private final SensorRepository repository;

    public SensorService(SensorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Sensor getById(UUID uuid) {
        return repository.getById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Sensor with that UUID does not exist"));
    }

    public List<Sensor> getAll() {
        return repository.getAll();
    }

}
