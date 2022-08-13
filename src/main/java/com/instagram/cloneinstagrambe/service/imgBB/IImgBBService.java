package com.instagram.cloneinstagrambe.service.imgBB;

import com.instagram.cloneinstagrambe.dto.imgBB.ResponseImgBB;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImgBBService {
//    String save(String t);
ResponseImgBB save(MultipartFile file) throws IOException;

}
