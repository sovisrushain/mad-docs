package com.cisco.payment_service.repository;

import com.cisco.payment_service.dto.PaymentRequestDTO;

public interface PaymentRepository {
    int savePayment(PaymentRequestDTO paymentRequestDTO);
    void cancelPayment(String paymentId);
}
