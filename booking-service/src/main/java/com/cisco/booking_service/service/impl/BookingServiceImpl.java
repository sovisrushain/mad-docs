package com.cisco.booking_service.service.impl;

import com.cisco.booking_service.dto.BookingDTO;
import com.cisco.booking_service.repository.BookingRepository;
import com.cisco.booking_service.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public void createBooking(BookingDTO bookingDTO) {
        bookingRepository.createBooking(bookingDTO);
    }
}
