package SpringBoot.Library.service;

import SpringBoot.Library.dto.UserGetDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserGetDto> getAllUsers();
}
