package com.instagram.cloneinstagrambe;

import com.instagram.cloneinstagrambe.entity.Role;
import com.instagram.cloneinstagrambe.entity.User;
import com.instagram.cloneinstagrambe.service.role.IRoleService;
import com.instagram.cloneinstagrambe.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (users.isEmpty()) {


//            cartService.save(cart);




            User admin = new User();
            Set<Role> roles = new HashSet<>();
            Role roleAdmin = new Role();
            roleAdmin.setId(1L);
            roleAdmin.setName("ROLE_ADMIN");
            roles.add(roleAdmin);

            admin.setUsername("thuhoatang");
            admin.setPassword("12345");
            admin.setPhone("84 905 589 210");
            admin.setFullName("Tăng Thu Hòa");

            admin.setRoles(roles);
            userService.save(admin);





        }
    }
}
