package com.example.baitapnhom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.baitapnhom.entity.User;
import com.example.baitapnhom.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Thymeleaf sẽ tìm login.html
    }
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute User user) {
        user.setRole("ROLE_USER"); // mặc định là USER
        userService.register(user); // lưu và mã hóa mật khẩu
        return "redirect:/login?registered";
    }
}