package com.cisco.payment_service.controller;

import com.cisco.payment_service.dto.PaymentRequestDTO;
import com.cisco.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public int createPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        return paymentService.createPayment(paymentRequestDTO);
    }

    @GetMapping("/{id}")
    public void cancelPayment(@PathVariable String id) {
        paymentService.cancelPayment(id);
    }
}
