package com.instagram.cloneinstagrambe.reponsitory;

import com.instagram.cloneinstagrambe.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageReponsitory extends JpaRepository<Image, String> {
}
