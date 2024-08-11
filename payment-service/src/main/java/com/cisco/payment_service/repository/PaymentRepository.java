package com.cisco.payment_service.repository;

import com.cisco.payment_service.dto.PaymentRequestDTO;

public interface PaymentRepository {
    void savePayment(PaymentRequestDTO paymentRequestDTO);
}
