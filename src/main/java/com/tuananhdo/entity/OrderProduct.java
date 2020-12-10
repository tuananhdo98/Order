package com.tuananhdo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@Entity
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;
    private String nameOrder;
    private String nameCustomer;
    private Date dateOrder;
    private String address;
    private String phoneNumber;
    private Double priceOrder;
    private Double shiping;
    private Double vat;
    private String note;
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<OrderDetails> orderDetails;


}
