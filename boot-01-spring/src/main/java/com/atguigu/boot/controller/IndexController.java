package com.atguigu.boot.controller;


import com.atguigu.boot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String IndexLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session) {
        if(StringUtils.hasLength(user.getUsername()) && StringUtils.hasLength(user.getPassword())) {
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }
        return "login";
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null) {
            return "main";
        }else {
            model.addAttribute("msg","请重新登录");
            return "login";
        }
    }
}
