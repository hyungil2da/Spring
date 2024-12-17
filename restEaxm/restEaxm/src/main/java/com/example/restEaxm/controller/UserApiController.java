package com.example.restEaxm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/user")
@RestController
public class UserApiController {

    @GetMapping("/chk-id")
    public String checkId(@RequestParam(name = "id") String id) {
        if(id.equals("user") || id.equals("admin")) {
            return "FAIL";
        }else{
            return "SUCCESS";
        }
    }


}
