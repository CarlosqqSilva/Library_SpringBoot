package SpringBoot.Library.service;

import SpringBoot.Library.converter.UserConverter;
import SpringBoot.Library.dto.user.UserGetDto;
import SpringBoot.Library.dto.user.UserPatchDto;
import SpringBoot.Library.dto.user.UserPostDto;
import SpringBoot.Library.dto.user.UserPutDto;
import SpringBoot.Library.model.User;
import SpringBoot.Library.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public UserPostDto saveUser(UserPostDto userPostDto) {
        return UserConverter.fromModelToUserPostDto(userRepository.save(UserConverter.fromUserDtoToModel(userPostDto)));
    }

    public UserPutDto updateUser(Long id, UserPutDto userPutDto) {
        return UserConverter.fromModelToUserPutDto(userRepository.save(UserConverter.fromUserPutDtoToModel(id, userPutDto)));
    }

    public UserPatchDto patchUser(Long id, UserPatchDto userPatchDto) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("id does not exist!");
        }
        User userToUpdate = userOptional.get();

        if (userPatchDto.userName() != null && !userPatchDto.userName().isEmpty() && !userPatchDto.userName().equals(userToUpdate.getUserName())) {
            userToUpdate.setUserName(userPatchDto.userName());
        }

        if (userPatchDto.firstName() != null && !userPatchDto.firstName().isEmpty() && !userPatchDto.firstName().equals(userToUpdate.getFirstName())) {
            userToUpdate.setFirstName(userPatchDto.firstName());
        }

        if (userPatchDto.lastName() != null && !userPatchDto.lastName().isEmpty() && !userPatchDto.lastName().equals(userToUpdate.getLastName())) {
            userToUpdate.setLastName(userPatchDto.lastName());
        }

        if (userPatchDto.email() != null && !userPatchDto.email().isEmpty() && !userPatchDto.email().equals(userToUpdate.getEmail())) {
            userToUpdate.setEmail(userPatchDto.email());
        }

        return UserConverter.fromModelToUserPatchDto(userRepository.save(userToUpdate));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
