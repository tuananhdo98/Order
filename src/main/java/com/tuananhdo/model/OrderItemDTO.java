package com.tuananhdo.model;

import com.tuananhdo.entity.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
public class OrderItemDTO {
    private Long number;
    private Product productDTO;
}
