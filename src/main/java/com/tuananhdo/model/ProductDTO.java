package com.tuananhdo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Setter
@Getter
public class ProductDTO {

    private int id;
    private String name;
    private String imageUrl;
    private String desciption;
    private int sale;
    private int price;
    private MultipartFile file;
}
