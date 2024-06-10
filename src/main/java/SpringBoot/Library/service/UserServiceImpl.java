package SpringBoot.Library.service;

import SpringBoot.Library.converter.UserConverter;
import SpringBoot.Library.dto.UserGetDto;
import SpringBoot.Library.dto.UserPostDto;
import SpringBoot.Library.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserGetDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserConverter::fromModelToUserDto)
                .toList();
    }

    public UserGetDto getUserById(Long id) {
        return UserConverter.fromModelToUserDto(userRepository.findById(id).orElseThrow());
    }

    public UserGetDto saveUser(UserPostDto userPostDto) {
        return UserConverter.fromModelToUserDto(userRepository.save(UserConverter.fromUserDtoToModel(userPostDto)));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
