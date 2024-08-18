package com.cisco.booking_service.repository;

import com.cisco.booking_service.dto.BookingDTO;

public interface BookingRepository {
    void createBooking(BookingDTO bookingDTO);
}
