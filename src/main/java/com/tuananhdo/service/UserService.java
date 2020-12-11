package com.tuananhdo.service;

import com.tuananhdo.entity.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService {

    List<User> listUserAll();

    User getUserByEmail(String email);

//    void clearOTP( User user);
//
//    void generateOneTimePassword(User user) throws UnsupportedEncodingException, MessagingException;
}
