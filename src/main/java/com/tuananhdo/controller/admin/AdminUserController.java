package com.tuananhdo.controller.admin;

import com.tuananhdo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminUserController {

    @Autowired
    private UserService userService;


    @GetMapping("/admin-user")
    public String adminUser(Model model) {
        model.addAttribute("userList", userService.listUserAll());
        return "admin/admin-user";
    }


    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin-user";
    }


}
