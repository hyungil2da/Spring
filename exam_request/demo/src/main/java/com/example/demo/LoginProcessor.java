package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class LoginProcessor {

    public boolean Check(LoginReq req) {
        if("user".equals(req.id) && "1234".equals(req.pwd)) {
            // 로그인 완료
            return true;
        }else{
            // 로그인 실패
            return false;
        }
    }


}
