package com.cisco.payment_service.repository.impl;

import com.cisco.payment_service.dto.PaymentRequestDTO;
import com.cisco.payment_service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {

    private static final Logger log = LoggerFactory.getLogger(PaymentRepositoryImpl.class);
    private final JdbcClient jdbcClient;

    @Override
    public void savePayment(PaymentRequestDTO paymentRequestDTO) {
        try {
            var sql = "";
            jdbcClient.sql(sql)
                    .update();
        } catch (Exception ex) {
            log.error("PaymentRepositoryImpl => savePayment: ", ex);
        }
    }

    @Override
    public void cancelPayment(String paymentId) {
        try {
            var sql = "";
            jdbcClient.sql(sql)
                    .update();
        } catch (Exception ex) {
            log.error("PaymentRepositoryImpl => cancelPayment: ", ex);
        }
    }
}
