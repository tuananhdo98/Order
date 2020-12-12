package com.tuananhdo.service.impl;

import com.tuananhdo.entity.User;
import com.tuananhdo.repository.UserRepository;
import com.tuananhdo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceimpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

//    @Override
//    public void generateOneTimePassword(User user) throws UnsupportedEncodingException, MessagingException {
//        String OTP = RandomString.make(8);
//        System.out.println("OTP :" +OTP);
//
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encodeOTP = bCryptPasswordEncoder.encode(OTP);
//        user.setOneTimePassword(encodeOTP);
//        user.setOtpRequestTime(new Date());
//        userRepository.save(user);
//        sendOTPEmail(user,OTP);
//    }


    @Override
    public void deleteUser(long id) {
         userRepository.deleteById(id);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

//    private void sendOTPEmail(User user, String otp) throws UnsupportedEncodingException, MessagingException {
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//        helper.setFrom("slodierqwe@gmail.com","Admin Tuan Anh Do Support");
//        helper.setTo(user.getEmail());
//        String subject = "Chúng tôi gửi cho bạn mã OTP - Có hiệu lực trong 5 phút";
//
//        String content = "<p> Hello " + user.getEmail() + "</p>"
//                + "<p><b>" + otp + "</b></p>"
//                + "<br>"
//                + "<p> Mã có hiệu lực trong vòng 5 phút ! </p>"
//                ;
//        helper.setSubject(subject);
//        helper.setText(content,true);
//        mailSender.send(message);
//        System.out.println("Đã gửi qua Email");
//    }
//    @Autowired
//    JavaMailSender mailSender;
//
//    @Override
//    public void clearOTP(User user) {
//        user.setOneTimePassword(null);
//        user.setOtpRequestTime(null);
//        userRepository.save(user);
//        System.out.println("Đã xoá OTP");
//    }

    @Override
    public List<User> listUserAll() {
        return userRepository.findAll();
    }
}
