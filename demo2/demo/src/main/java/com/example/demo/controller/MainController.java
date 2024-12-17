package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/main")
@Controller
public class MainController {

    @RequestMapping("")
    public String viewMain(Model model) {
//        model.addAttribute("message", "안녕하세요");
        List<String> str = new ArrayList<String>();
        str.add("이순신");
        str.add("홍길동");
        str.add("슈퍼맨");
        str.add("배트맨");
        model.addAttribute("list", str);

        return "main";
    }


//    @RequestMapping("")
//    public ModelAndView viewMain(ModelAndView model) {
//        model.setViewName("main.html");
//
//        return model;
//    }

    @RequestMapping("/dashboard")
    public String viewDashboard() {

        return "dashboard.html";
    }


}
