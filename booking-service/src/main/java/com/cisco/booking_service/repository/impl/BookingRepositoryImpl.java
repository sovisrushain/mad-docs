package com.cisco.booking_service.repository.impl;

import com.cisco.booking_service.dto.BookingDTO;
import com.cisco.booking_service.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookingRepositoryImpl implements BookingRepository {

    @Override
    public void createBooking(BookingDTO bookingDTO) {

    }
}
