package com.tuananhdo.entity;

import com.tuananhdo.model.SizeCake;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {


    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "Vui lòng nhập Tên sản phẩm.")
//    @Size(min = 5, max = 30, message = "Độ dài tối thiểu của Tên sản phẩm là 5")
    private String name;

    private String imageUrl;

//    @NotBlank(message = "Vui lòng nhập Mô tả.")
//    @Size(min = 8, max = 30, message = "Độ dài tối thiểu của Mô tả là 8")
    private String desciption;

//    @NotNull(message = "Vui lòng nhập Giá.")
    private Integer price;

    private Date createdDate;
    private Date updateDate;

    @Enumerated(EnumType.STRING)
    private SizeCake size;
    @OneToMany(targetEntity = OrderDetails.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Set<OrderDetails> orderDetails = new HashSet<>();

}
