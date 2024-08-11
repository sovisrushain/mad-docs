package com.cisco.payment_service.service;

import com.cisco.payment_service.dto.PaymentRequestDTO;

public interface PaymentService {
    void createPayment(PaymentRequestDTO paymentRequestDTO);
}
