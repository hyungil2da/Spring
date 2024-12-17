package com.example.reviewExam;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

@RequestMapping("/main")
@Controller
public class MainController {
    @Autowired
    private MemberService memberService;
    @GetMapping("")
    public String viewMain(
            Model model,
            HttpSession session,
            @RequestParam(value = "msg", required = false) String msg) {
     //   session.invalidate();




        model.addAttribute("msg", memberService);
        return "main";
    }

    @PostMapping("")
    public String postMain(
            Model model,
            @RequestParam("inp-name") String name) {
        model.addAttribute("msg", "이름은 " + name);

        return "main";
    }


}
