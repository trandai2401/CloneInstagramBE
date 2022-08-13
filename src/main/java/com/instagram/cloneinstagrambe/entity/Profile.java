package com.instagram.cloneinstagrambe.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

@Data
@Entity
public class Profile extends BaseEntity {

    private String website;
    private String bio;

    private String gender;
    private String avatar;

    @Column(columnDefinition="Integer default '100.00'")
    private Integer posts;
    private Integer followers;
    private Integer following;
    @OneToOne(mappedBy = "profile")
    private User user;

    @PrePersist
    void preInsert() {
        if (this.posts == null)
            this.posts = 0;
    }
}
