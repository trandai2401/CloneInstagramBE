package com.instagram.cloneinstagrambe.api;

import com.instagram.cloneinstagrambe.entity.User;
import com.instagram.cloneinstagrambe.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
public class UserAPI {
    @Autowired
    private IUserService userService;


    @PostMapping
    ResponseEntity<?> createUser(@RequestBody User user) {
//        return ResponseEntity.ok((userService));

        return ResponseEntity.ok(userService.save(user));
    }
}
