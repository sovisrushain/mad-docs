package com.cisco.payment_service.service.impl;

import com.cisco.payment_service.dto.PaymentRequestDTO;
import com.cisco.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void createPayment(PaymentRequestDTO paymentRequestDTO) {

    }
}
