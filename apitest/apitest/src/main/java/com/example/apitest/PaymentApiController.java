package com.example.apitest;


import com.example.apitest.dto.PaymentReqDto;
import com.example.apitest.dto.PaymentRespDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/payment")
@RestController
public class PaymentApiController {


    @PostMapping("")
    public PaymentRespDto process( PaymentReqDto paymentReqDto) {
        PaymentRespDto paymentRespDto = new PaymentRespDto();
        paymentRespDto.setResult("SUCCESS");
        paymentRespDto.setMsg("결제가 완료되었습니다.");
        return paymentRespDto;
    }


}
