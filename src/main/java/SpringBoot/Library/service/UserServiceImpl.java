package SpringBoot.Library.service;

import SpringBoot.Library.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserGetDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserConverter::fromModelToUserDto)
                .toList();
    }
}
