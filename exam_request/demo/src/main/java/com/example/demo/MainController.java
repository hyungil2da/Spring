package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@RequestMapping("/main")
@Controller
public class MainController {
    private static final Logger logger = Logger.getLogger(MainController.class.getName());

//    @Autowired
    private final LoginProcessor loginProcessor;
    private final LoginSessionProcessor loginSessionProcessor;

    public MainController(LoginProcessor loginProcessor,
                          LoginSessionProcessor loginSessionProcessor) {
        this.loginProcessor = loginProcessor;
        this.loginSessionProcessor = loginSessionProcessor;
    }






//  쿼리스트링 파라메터
    @GetMapping("/view")
    public String viewMain(Model model) {
        if(loginSessionProcessor.getId() == null || loginSessionProcessor.getId().isEmpty()) {
            return "redirect:/main/login";
        }

        // 로그아웃 처리
        loginSessionProcessor.setId(null);
        loginSessionProcessor.setPwd(null);

        model.addAttribute("msg", "로그인을 환영합니다.");
        return "main";
    }
    @GetMapping("/login")
    public String viewLogin(Model model) {
        return "login";
    }
//    @PostMapping("/login")
//    public String doLogin(
//        @RequestParam("id") String id,
//        @RequestParam("pwd") String pwd,
//        Model model
//    ) {
//        if("user".equals(id) && "1234".equals(pwd)) {
//            // 로그인 완료
//            return "redirect:/main/view";
//        }else{
//            // 로그인 실패
//            return "redirect:/main/login";
//        }
//    }

    @PostMapping("/login")
    public String doLogin(LoginReq req, Model model) {
        logger.info("######### LoginProcess Val : " + loginProcessor);

        if(loginProcessor.Check(req)) {
            // 세션에 저장
            loginSessionProcessor.setId(req.id);
            loginSessionProcessor.setPwd(req.pwd);

            // 로그인 완료
            return "redirect:/main/view";
        }else{
            // 로그인 실패
            return "redirect:/main/login";
        }
    }



}
