package SpringBoot.Library.converter;

import SpringBoot.Library.dto.UserGetDto;
import SpringBoot.Library.dto.UserPostDto;
import SpringBoot.Library.model.User;

public class UserConverter {

    public static UserGetDto fromModelToUserDto(User user) {
        return new UserGetDto(
                user.getId(),
                user.getName());
    }

    public static UserPostDto fromModelToUserPostDto(User user) {
        return new UserPostDto(
                user.getName());
    }

    public static User fromUserDtoToModel(UserPostDto userPostDto) {
        return User.builder()
                .name(userPostDto.name())
                .build();
    }

    public static User fromUserGetDtoToModel(UserGetDto userGetDto) {
        return User.builder()
                .name(userGetDto.name())
                .build();
    }
}
