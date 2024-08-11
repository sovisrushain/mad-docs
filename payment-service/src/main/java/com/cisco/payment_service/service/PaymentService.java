package com.cisco.payment_service.service;

import com.cisco.payment_service.dto.PaymentRequestDTO;

public interface PaymentService {
    int createPayment(PaymentRequestDTO paymentRequestDTO);
    String cancelPayment(String paymentId);
}
