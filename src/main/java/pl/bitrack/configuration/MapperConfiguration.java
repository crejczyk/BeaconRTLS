package pl.bitrack.configuration;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import pl.bitrack.utils.impl.UserMapper;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
@Factory
public class MapperConfiguration {

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }

}
