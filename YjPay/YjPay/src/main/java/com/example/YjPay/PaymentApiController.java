package com.example.YjPay;

import com.example.YjPay.dto.YjPaymentReqDto;
import com.example.YjPay.dto.YjPaymentRespDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RequestMapping("/api/payment")
@RestController
public class PaymentApiController {
    private static final Logger logger = Logger.getLogger(PaymentApiController.class.getName());

    @PostMapping("/process")
    public YjPaymentRespDto process(@RequestBody YjPaymentReqDto reqDto) {
        logger.info(reqDto.getName()+ "," + reqDto.getAmount());
        YjPaymentRespDto respDto = new YjPaymentRespDto();
        respDto.setResult("SUCCESS");
        respDto.setMsg("[결제서버]"
                + reqDto.getName() + "님의 "
                + reqDto.getAmount() + "원 결제가 완료되었습니다.");

        logger.info(respDto.toString());

        return respDto;
    }




}
