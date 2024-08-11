package com.cisco.payment_service.service.impl;

import com.cisco.payment_service.dto.PaymentRequestDTO;
import com.cisco.payment_service.repository.PaymentRepository;
import com.cisco.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public int createPayment(PaymentRequestDTO paymentRequestDTO) {
        return paymentRepository.savePayment(paymentRequestDTO);
    }

    @Override
    public void cancelPayment(String paymentId) {
        paymentRepository.cancelPayment(paymentId);
    }
}
