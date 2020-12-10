package com.tuananhdo.controller.web;

import com.tuananhdo.entity.User;
import com.tuananhdo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "web/register";
    }

    @PostMapping("/registerPost")
    public String registerPost(User user){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String newPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(newPassword);
        user.setEnabled(true);
        userRepository.save(user);
        return "web/success";
    }
}
