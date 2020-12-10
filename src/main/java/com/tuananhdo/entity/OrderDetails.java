package com.tuananhdo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private OrderProduct orderProduct;
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
    private Long numberOrder;
    private Double total;
}
