package com.instagram.cloneinstagrambe.api;

import com.instagram.cloneinstagrambe.dto.JwtResponse;
import com.instagram.cloneinstagrambe.entity.User;
import com.instagram.cloneinstagrambe.service.JwtService;
import com.instagram.cloneinstagrambe.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
public class UserAPI {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IUserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    ResponseEntity<?> createUser(@RequestBody User user) {
//        return ResponseEntity.ok((userService));

        return ResponseEntity.ok(userService.save(user));
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
//        System.out.println("token la : "+jwtService.getUserNameFromJwtToken(jwt));
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername()).get();

//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // Trả về jwt cho người dùng.
//        String jwt = tokenProvider.generateToken((User) authentication.getPrincipal());
//
//
//        String username = jwtService.getUserNameFromJwtToken(jwt);

        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), currentUser.getFullName(), userDetails.getAuthorities()));
    }
}
