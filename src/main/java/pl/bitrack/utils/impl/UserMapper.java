package pl.bitrack.utils.impl;

import pl.bitrack.api.dto.UserDto;
import pl.bitrack.repository.domain.User;
import pl.bitrack.utils.ModelDtoMapper;

/**
 * @author Tomasz Szymeczek
 * Date 07/09/2020
 */
public class UserMapper implements ModelDtoMapper<User, UserDto> {

    @Override
    public User toModel(UserDto userDto) {
        return User.builder()
                .uuid(userDto.getUuid())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .phone(userDto.getPhone())
                .coordinates(userDto.getCoordinates())
                .status(userDto.getStatus())
                .type(userDto.getType())
                .build();
    }

    @Override
    public UserDto toDto(User user) {
        return UserDto.builder()
                .uuid(user.getUuid())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .coordinates(user.getCoordinates())
                .status(user.getStatus())
                .type(user.getType())
                .build();
    }

}
