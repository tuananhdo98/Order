package com.tuananhdo.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderdetails_id",length = 10,precision = 0)
    private Long id;
    @ManyToOne()
    private OrderProduct order_id;
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
    private Long numberOrder;
    private Double priceOrder;

}
