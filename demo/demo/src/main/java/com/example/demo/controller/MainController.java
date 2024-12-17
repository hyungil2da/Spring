package com.example.demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/")
@Controller
public class MainController {


    @RequestMapping("main")
    public String viewMain(Model model) {
        model.addAttribute("message", "Hello World");

        return "main";
    }

//    @RequestMapping("main")
//    public ModelAndView viewMain(ModelAndView mv) {
//
//        mv.setViewName("main");
//        mv.getModel().put("message", "Hello World");
//        return mv;
//    }




}
