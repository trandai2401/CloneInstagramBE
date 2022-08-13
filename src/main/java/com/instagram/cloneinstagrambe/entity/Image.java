package com.instagram.cloneinstagrambe.entity;

import lombok.Data;

@Data
public class Image {
    private String filename;
    private String name;
    private String mime;
    private String extension;

    private String url;
    private String thumb_url;
    private String medium_url;

}
