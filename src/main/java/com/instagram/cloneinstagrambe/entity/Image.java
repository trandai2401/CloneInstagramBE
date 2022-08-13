package com.instagram.cloneinstagrambe.entity;

import com.instagram.cloneinstagrambe.entity.baseclass.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Image  extends  BaseEntity{

    @Id
    private String id;

    private String filename;
    private String name;
    private String mime;
    private String extension;

    private String url;
    private String thumb_url;
    private String medium_url;
    @OneToOne(mappedBy = "avatar")
    private User user;
}
