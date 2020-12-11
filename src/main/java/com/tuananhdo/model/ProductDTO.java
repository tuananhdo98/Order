package com.tuananhdo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Setter
@Getter
public class ProductDTO {

    private Long id;
    private String name;
    private String imageUrl;
    private String desciption;
    private Integer price;
    private MultipartFile file;
}
