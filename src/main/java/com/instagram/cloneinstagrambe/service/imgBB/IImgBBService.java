package com.instagram.cloneinstagrambe.service.imgBB;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImgBBService {
//    String save(String t);
    String save(MultipartFile file) throws IOException;

}
