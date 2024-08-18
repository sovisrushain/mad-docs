package com.cisco.booking_service.service;

import com.cisco.booking_service.dto.BookingDTO;

public interface BookingService {
    void createBooking(BookingDTO bookingDTO);
}
