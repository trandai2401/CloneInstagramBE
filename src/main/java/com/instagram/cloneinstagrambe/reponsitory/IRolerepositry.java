package com.instagram.cloneinstagrambe.reponsitory;

import com.instagram.cloneinstagrambe.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolerepositry extends JpaRepository<Role,Long> {
}
