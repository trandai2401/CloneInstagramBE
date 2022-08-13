package com.instagram.cloneinstagrambe.api;

import com.instagram.cloneinstagrambe.configuration.security.UserPrinciple;
import com.instagram.cloneinstagrambe.entity.Profile;
import com.instagram.cloneinstagrambe.entity.User;
import com.instagram.cloneinstagrambe.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DemoApi {
    @Autowired
    private IUserService userService;

    @PostMapping("demo")
    ResponseEntity<?> demo(){
        String username="";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            username = authentication.getName();

        }
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        User user = userService.findById(userPrincipal.getId()).get();

        user.setEmail("1234");

        User user2 =  userService.save(user);
        Profile profile =  user2.getProfile();
        user2.setProfile(profile);
//        System.out.println(user.get());
        return ResponseEntity.ok(user2);
    }
}
