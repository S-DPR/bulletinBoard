package org.example.bulletinboard.restController;

import org.example.bulletinboard.model.User;
import org.example.bulletinboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/login")
public class UserRestController extends GenericRestController {
    private final UserService userService;

    @Autowired
    UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/validate")
    public ResponseEntity login(@ModelAttribute User user) {
        return response(userService.login(user));
    }

    @PostMapping("/")
    public ResponseEntity save(@ModelAttribute User user) {
        return response(userService.save(user));
    }
}
