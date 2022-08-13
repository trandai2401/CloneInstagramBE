package com.instagram.cloneinstagrambe.entity.baseclass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public  class BaseEntity{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
//    @GenericGenerator(name = "native", strategy = "native")
//    private Long id;

    @JsonIgnore
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime modifiedAt;

    @CreatedBy
    @JsonIgnore
    @Column( nullable = false, updatable = false)
    public String createdBy;


    @LastModifiedBy
    @JsonIgnore
    @Column( nullable = false, updatable = false)
    private String modifiedBy;

}
