package com.instagram.cloneinstagrambe;

import com.instagram.cloneinstagrambe.entity.Role;
import com.instagram.cloneinstagrambe.entity.User;
import com.instagram.cloneinstagrambe.service.role.IRoleService;
import com.instagram.cloneinstagrambe.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class CloneinstagrambeApplication {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(CloneinstagrambeApplication.class, args);
    }
    @PostConstruct
    public void init() {
        List<User> users = (List<User>) userService.findAll();
        List<Role> roleList = (List<Role>) roleService.findAll();
        if (roleList.isEmpty()) {
            Role roleAdmin = new Role();
            roleAdmin.setId(1L);
            roleAdmin.setName("ROLE_ADMIN");
            roleService.save(roleAdmin);
            Role roleUser = new Role();
            roleUser.setId(2L);
            roleUser.setName("ROLE_USER");
            roleService.save(roleUser);
        }
//        if (users.isEmpty()) {
//
//            Cart cart = new Cart();
////            cartService.save(cart);
//
//
//
//
//            User admin = new User();
//            Set<Role> roles = new HashSet<>();
//            Role roleAdmin = new Role();
//            roleAdmin.setId(1L);
//            roleAdmin.setName("ROLE_ADMIN");
//            roles.add(roleAdmin);
//            admin.setUsername("admin");
//            admin.setPassword("123456");
//            admin.setRoles(roles);admin.setFullName("Hoa bu dic");
//            admin.setCart(cart);
//            userService.save(admin);
//
//
//            admin = new User();
//            roleAdmin.setId(1L);
//            roleAdmin.setName("ROLE_ADMIN");
//            roles.add(roleAdmin);
//            admin.setUsername("admin2");
//            admin.setPassword("123456");
//            admin.setRoles(roles);admin.setFullName("Hoa bu dic");
//
//            userService.save(admin);
//
//
//        }
    }
}
