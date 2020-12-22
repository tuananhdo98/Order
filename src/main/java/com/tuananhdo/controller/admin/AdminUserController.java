package com.tuananhdo.controller.admin;

import com.tuananhdo.entity.Role;
import com.tuananhdo.entity.User;
import com.tuananhdo.repository.RoleRepository;
import com.tuananhdo.service.RoleService;
import com.tuananhdo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class AdminUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;


    @GetMapping("/admin-user")
    public String adminUser(Model model) {
        List<Role> roleList = roleRepository.findAll();
        model.addAttribute("userList", userService.listUserAll());
        model.addAttribute("roles",roleList);
        return "admin/admin-user";
    }

    @GetMapping("/add-user")
    public String addUser(Model model) {
        List<Role> roleList = roleRepository.findAll();
        model.addAttribute("addUser", new User());
        model.addAttribute("roleList", roleList);
        return "admin/user/addUser";
    }

    @PostMapping("/add-user")
    public String addUser(Model model, @ModelAttribute("user")  User user, BCryptPasswordEncoder passwordEncoder) {
        String newPasswordUser = passwordEncoder.encode(user.getPassword());
        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        user.setPassword(newPasswordUser);
        user.setEnabled(true);
        model.addAttribute("addUser", userService.saveUser(user));
        return "redirect:/admin-user";
    }



    @GetMapping("/edit-user/{id}")
    public String editUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUserById(id));
        List<Role> roleList = roleRepository.findAll();
        model.addAttribute("roleList", roleList);
        return "admin/user/editUser";
    }

    @PostMapping("/edit-user")
    public String editUser(Model model, @ModelAttribute("user") User user, BCryptPasswordEncoder passwordEncoder) {
        String newPasswordUser = passwordEncoder.encode(user.getPassword());
            user.setUpdateDate(new Timestamp(System.currentTimeMillis()));
            user.setPassword(newPasswordUser);
            user.setEnabled(true);
            model.addAttribute("user", userService.saveUser(user));
        return "redirect:/admin-user";
    }


    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin-user";
    }


}
