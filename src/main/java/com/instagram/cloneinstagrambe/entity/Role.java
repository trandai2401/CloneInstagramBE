package com.instagram.cloneinstagrambe.entity;


import com.instagram.cloneinstagrambe.entity.baseclass.BaseClassLong;
import com.instagram.cloneinstagrambe.entity.baseclass.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Role extends BaseClassLong {
    private String name;
}
