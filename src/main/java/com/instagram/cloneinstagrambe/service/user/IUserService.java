package com.instagram.cloneinstagrambe.service.user;

import com.instagram.cloneinstagrambe.entity.Image;
import com.instagram.cloneinstagrambe.entity.User;
import com.instagram.cloneinstagrambe.service.IGenerateService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface IUserService extends IGenerateService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    Image changeAvatar(MultipartFile file) throws IOException;
}
