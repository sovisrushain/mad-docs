package com.cisco.payment_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestDTO {
    private String paymentId;
    private String bookingId;
    private Long amount;
    private Date paymentDate;
    private Boolean status;
}
