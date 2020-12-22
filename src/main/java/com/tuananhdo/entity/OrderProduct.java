package com.tuananhdo.entity;

import com.tuananhdo.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct implements Serializable {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotFound(action = NotFoundAction.IGNORE)
    private Long id;
    private Date dateOrder;
    private String nameOrder;
    private String getImg;

    @NotBlank(message = "Vui lòng nhập Tên.")
    @Size(min = 2, max = 30, message = "Độ dài tối thiểu của Tên là 2")
    private String nameUserOrder;

    @NotBlank(message = "Vui lòng nhập Số điện thoại.")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Số điện thoại gồm 10 số và không có kí tự đặc biệt")
    @Size(min = 10, max = 10, message = "Vui lòng nhập đúng định dạng Số điện thoại")
    private String phoneNumber;

    @NotBlank(message = "Vui lòng nhập Địa chỉ.")
    @Size(min = 10, max = 100, message = "Độ dài tối thiểu của Địa chỉ là 15 (Số nhà ,Ngõ , Nghách , Tên đường)")
    private String addressOrder;

    private String noteOrder;
    private Integer shiping;
    private Integer vat;
    private Integer intoMoney;
    private Integer totalOrder;
    private Long orderNumber;
    private Integer totalNumberOrder;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @OneToMany(targetEntity = OrderDetails.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Set<OrderDetails> orderDetails = new HashSet<>();
}
