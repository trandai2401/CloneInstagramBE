package com.instagram.cloneinstagrambe.service.user;

import com.instagram.cloneinstagrambe.configuration.security.UserPrinciple;
import com.instagram.cloneinstagrambe.dto.imgBB.Data;
import com.instagram.cloneinstagrambe.dto.imgBB.ResponseImgBB;
import com.instagram.cloneinstagrambe.entity.Image;
import com.instagram.cloneinstagrambe.entity.User;
import com.instagram.cloneinstagrambe.reponsitory.IUserRepository;
import com.instagram.cloneinstagrambe.service.imgBB.IImgBBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IImgBBService imgBBService;

    @Override
    public Iterable findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return userRepository.findById(id);

    }

    @Override
    public User save(User user) {

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);


    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        System.out.println(username);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return UserPrinciple.build(userOptional.get());
    }
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Image changeAvatar(MultipartFile file) throws IOException {

        ResponseImgBB reps= imgBBService.save(file);
        Data data = reps.getData();
        Image img = new Image();
        img.setFilename(data.getImage().getFilename());
        img.setName(data.getImage().getName());
        img.setMime(data.getImage().getMime());
        img.setExtension(data.getImage().getExtension());
        img.setUrl(data.getImage().getUrl());
        img.setThumb_url(data.getThumb().getUrl());
        img.setMedium_url(data.getMedium().getUrl());

        return img;
    }
}
