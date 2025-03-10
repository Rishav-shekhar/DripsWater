package UserService.controller;

import UserService.Model.UserModel;
import UserService.Service.UserService;

import UserService.utility.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")  // Base URL for this controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/details")
    public ResponseEntity<?> getUser(HttpServletRequest request) {
        // Extract JWT from Authorization Header
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("Unauthorized: No token provided");
        }

        // Extract Token
        String token = authHeader.substring(7);
        String username = jwtUtil.extractUsername(token);

        // Fetch User Details
        UserModel user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }
}
