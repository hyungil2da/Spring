package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/main")
@Controller
public class MainController {

    // 1. Path 경로에 붙어오는경우
    // /member/view/{mem_id}
    // 2. GET: QueryString
    // /member/view?mem_id=hello@test.com
    // 3. POST: Class
    // Member

    // form-data
    // json

    @RequestMapping("")
    public String viewMain(Model model,
                           @RequestParam(value = "msg", required = false) String msg
                           ) {
        model.addAttribute("message", msg);
        
        
        List<String> arr = new ArrayList<String>();
        arr.add("홍길동");
        arr.add("이순신");
        arr.add("배트맨");
        model.addAttribute("list", arr);


        return "main.html";
    }

//    @RequestMapping("/")
//    public ModelAndView viewMain() {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("main.html");
//        mv.addObject("message", "Hello World");
//        return mv;
//    }


    @RequestMapping("/dashboard")
    public String viewDashboard() {

        return "dashboard.html";
    }


}
