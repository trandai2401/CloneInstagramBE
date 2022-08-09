package com.instagram.cloneinstagrambe.service.user;

import com.instagram.cloneinstagrambe.entity.User;
import com.instagram.cloneinstagrambe.service.IGenerateService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGenerateService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);

}
