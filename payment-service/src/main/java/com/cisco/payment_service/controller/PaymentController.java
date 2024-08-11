package com.cisco.payment_service.controller;

import com.cisco.payment_service.dto.PaymentRequestDTO;
import com.cisco.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public void createPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        paymentService.createPayment(paymentRequestDTO);
    }
}
