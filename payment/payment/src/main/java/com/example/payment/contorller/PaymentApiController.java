package com.example.payment.contorller;

import com.example.payment.dto.PaymentReqDto;
import com.example.payment.dto.PaymentRespDto;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@RequestMapping("/api/payment")
@RestController
public class PaymentApiController {

    @PostMapping("")
    public PaymentRespDto reqPayment(@RequestBody PaymentReqDto reqDto) {
        URI uri = UriComponentsBuilder
                .fromUriString("http://223.194.168.70:8888")
                .path("/api/payment/process")
                .encode()
                .build()
                .toUri();
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<PaymentRespDto> responseEntity = restTemplate.postForEntity(
//                uri, reqDto, PaymentRespDto.class
//        );
        RestClient restClient = RestClient.create();
        ResponseEntity<PaymentRespDto> responseEntity = restClient.post()
                .uri(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .body(reqDto)
                .retrieve()
                .toEntity(PaymentRespDto.class)
                ;
        PaymentRespDto respDto = responseEntity.getBody();
        return respDto;
    }



}
