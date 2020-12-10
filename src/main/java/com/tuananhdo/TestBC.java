package com.tuananhdo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBC {


    public static void main(String[] args) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String newPass = "admin";
        String getNewPass = bCryptPasswordEncoder.encode(newPass);
        System.out.println(getNewPass);
    }
}
