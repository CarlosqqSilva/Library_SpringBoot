package SpringBoot.Library.service;

import SpringBoot.Library.dto.user.UserGetDto;
import SpringBoot.Library.dto.user.UserPatchDto;
import SpringBoot.Library.dto.user.UserPostDto;
import SpringBoot.Library.dto.user.UserPutDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserGetDto> getAllUsers();

    UserGetDto getUserById(Long id);

    UserPostDto saveUser(UserPostDto userPostDto);

    UserPutDto updateUser(Long id, UserPutDto userPutDto);

    UserPatchDto patchUser(Long id, UserPatchDto userPatchDto);

    void deleteUserById(Long id);
}
