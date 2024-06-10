package SpringBoot.Library.controller;

import SpringBoot.Library.dto.UserGetDto;
import SpringBoot.Library.dto.UserPostDto;
import SpringBoot.Library.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserGetDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/")
    public ResponseEntity<UserGetDto> saveUser(UserPostDto userPostDto) {
        return ResponseEntity.ok(userService.saveUser(userPostDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGetDto> getUserById(Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(Long id) {
        userService.deleteUserById(id);
    }
}
