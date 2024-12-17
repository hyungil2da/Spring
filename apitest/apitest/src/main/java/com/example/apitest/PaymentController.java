package com.example.apitest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/payment")
@Controller
public class PaymentController {

    @GetMapping("")
    public String viewPayment() {
        return "payment";
    }

}
