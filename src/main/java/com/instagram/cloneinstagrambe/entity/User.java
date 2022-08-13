package com.instagram.cloneinstagrambe.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.instagram.cloneinstagrambe.entity.baseclass.BaseClassLong;
import com.instagram.cloneinstagrambe.entity.baseclass.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class User extends BaseClassLong {
    //    @Column(unique = true)
    private String phone;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column()
    private Boolean verify = false;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
//    @JsonIgnore
    private Profile profile;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id", referencedColumnName = "id",nullable = true)
    private Image avatar;


    @PrePersist
    void preInsert() {
        if (this.profile == null)
            this.profile = new Profile();
    }


    @Override
    public String toString() {
        return "id : " + this.getId();
    }
}
