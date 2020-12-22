package com.tuananhdo.controller.web;

import com.tuananhdo.entity.Role;
import com.tuananhdo.entity.User;
import com.tuananhdo.repository.RoleRepository;
import com.tuananhdo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "web/register";
    }

    @PostMapping("/registerPost")
    public String registerPost(@Valid User user, BindingResult bindingResult,String email) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String newPassword = bCryptPasswordEncoder.encode(user.getPassword());
        if (bindingResult.hasErrors()) {
            return "web/register";
        } else if (user == userRepository.getUserByEmail(email)) {
            throw new Exception("User with " + email + " is already exist");
        } else {
            Role role = roleRepository.findRoleByName("USER");
            Set<Role> roles = Stream.of(role)
                    .collect(Collectors.toCollection(HashSet::new));
            user.setRoles(roles);
            user.setPassword(newPassword);
            user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            user.setEnabled(true);
            userRepository.save(user);
        }
        return "web/success";
    }

}
