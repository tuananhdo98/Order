package com.tuananhdo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Vui lòng nhập Họ.")
    @Size(min = 3,max = 30,message = "Độ dài tối thiểu của Họ là 3")
    private String fisrtname;

    @NotNull(message = "Vui lòng nhập Tên.")
    @Size(min = 3,max = 30,message = "Độ dài tối thiểu của Tên là 3")
    private String lastname;

    @NotNull(message = "Vui lòng nhập email.")
    @Email(message = "Phải sử dụng địa chỉ email hợp lệ.")
    private String email;

    @NotNull(message = "Vui lòng nhập mật khẩu.")
    @Size(min = 8, max = 64,message = "Độ dài tối thiểu của mật khẩu là 8")
    private String password;

    private Boolean enabled;
    private Date createdDate;
    private Date updateDate;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles", joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    //
//    public boolean isOTPRequired() {
//        if (this.oneTimePassword == null) {
//            return false;
//        }
//        long otpRequestdTime = this.otpRequestTime.getTime();
//        if (otpRequestdTime + OTP_VALID_DURATION < System.currentTimeMillis()) {
//            return false;
//        }
//        return true;
//    }
//
//    private static final long OTP_VALID_DURATION = 5 * 60 * 1000;
}
