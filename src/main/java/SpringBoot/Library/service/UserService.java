package SpringBoot.Library.service;

import SpringBoot.Library.dto.UserGetDto;
import SpringBoot.Library.dto.UserPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserGetDto> getAllUsers();

    UserGetDto getUserById(Long id);

    UserGetDto saveUser(UserPostDto userPostDto);

    void deleteUserById(Long id);
}
