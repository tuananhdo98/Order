package com.tuananhdo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
public class OrderProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateOrder;
    private String nameOrder;
    private String getImg;
    private String nameUserOrder;
    private String phoneNumber;
    private String addressOrder;
    private String noteOrder;
    private Double shiping;
    private Double vat;
    private Boolean status;
    private Integer intoMoney;
    private Integer totalOrder;
    private Long totalNumber;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetails;
}
