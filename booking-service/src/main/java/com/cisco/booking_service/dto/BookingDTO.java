package com.cisco.booking_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private String bookingId;
    private String userId;
    private String doctorId;
    private String hospitalId;
    private Date bookingDate;
    private String timeSlot;
    private String paymentStatus;
}
