package com.cisco.payment_service.repository.impl;

import com.cisco.payment_service.dto.PaymentRequestDTO;
import com.cisco.payment_service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {

    private static final Logger log = LoggerFactory.getLogger(PaymentRepositoryImpl.class);
    private final JdbcClient jdbcClient;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public int savePayment(PaymentRequestDTO paymentRequestDTO) {
        try {
            var sql = "INSERT INTO payment (payment_id, booking_id, amount, payment_date, status) " +
                    "VALUES (?, ?, ?, ?, ?);";
            return jdbcClient.sql(sql)
                    .param(1, paymentRequestDTO.getPaymentId())
                    .param(2, paymentRequestDTO.getBookingId())
                    .param(3, paymentRequestDTO.getAmount())
                    .param(4, new Date())
                    .param(5, true)
                    .update();
        } catch (Exception ex) {
            log.error("PaymentRepositoryImpl => savePayment: ", ex);
        }
        return 0;
    }

    @Override
    public String cancelPayment(String paymentId) {
        try {
            var sql1 = "SELECT EXISTS (SELECT 1 FROM payment WHERE payment_id = ?);";
            var sql2 = "UPDATE payment SET status = ? WHERE payment_id = ?;";
            Boolean exists = jdbcTemplate.queryForObject(sql1, Boolean.class, paymentId);
            if (Boolean.FALSE.equals(exists)) {
                return "Payment not found";
            } else {
                jdbcClient.sql(sql2)
                        .param(1, false)
                        .param(2, paymentId)
                        .update();
                return "Done";
            }
        } catch (Exception ex) {
            log.error("PaymentRepositoryImpl => cancelPayment: ", ex);
            return "FAILED";
        }
    }
}
