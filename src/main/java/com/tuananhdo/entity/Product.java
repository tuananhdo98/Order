package com.tuananhdo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
public class Product implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String imageUrl;
    private String desciption;
    private Integer price;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<OrderDetails> orderDetails;

}
