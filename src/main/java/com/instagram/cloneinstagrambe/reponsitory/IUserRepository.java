package com.instagram.cloneinstagrambe.reponsitory;

import com.instagram.cloneinstagrambe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
