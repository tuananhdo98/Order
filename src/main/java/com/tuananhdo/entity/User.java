package com.tuananhdo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    private String fisrtname;
    private String lastname;
    private String email;
    private String password;
    private String oneTimePassword;
    private Date otpRequestTime;
    private Boolean enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles", joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();


    public boolean isOTPRequired() {
        if (this.oneTimePassword == null) {
            return false;
        }
        long otpRequestdTime = this.otpRequestTime.getTime();
        if (otpRequestdTime + OTP_VALID_DURATION < System.currentTimeMillis()) {
            return false;
        }
        return true;
    }

    private static final long OTP_VALID_DURATION = 5 * 60 * 1000;
}
