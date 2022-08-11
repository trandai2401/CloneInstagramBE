package com.instagram.cloneinstagrambe.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class User extends BaseEntity {
    @Column
    private String phone;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String website;
    private String bio;
    private String email;
    private String gender;
    private String avatar;
    private Integer posts;
    private Integer followers;
    private Integer following;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;
}
