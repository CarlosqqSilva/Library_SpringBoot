package SpringBoot.Library.controller;

import SpringBoot.Library.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;

        @GetMapping("/")
        public ResponseEntity<List<UserGetDto>> getAllUsers() {
            return ResponseEntity.ok(userService.getAllUsers());
        }
    }
}
