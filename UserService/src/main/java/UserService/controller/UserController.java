package UserService.controller;


import UserService.Model.UserModel;
import UserService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")  // Base URL for this controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/details")
    public ResponseEntity<UserModel> getUser(@RequestParam String username) {
        UserModel user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }
}
