package com.hotelrezervations.services;

import com.hotelrezervations.models.BookingResponse;

public class BookingIdService extends BaseTest{

    public int bookingId(){
        ReservationService reservationService = new ReservationService();
        BookingResponse bookingResponse = reservationService.createBooking();
        int bookingId = bookingResponse.getBookingid();
        return bookingId;
    }
}
