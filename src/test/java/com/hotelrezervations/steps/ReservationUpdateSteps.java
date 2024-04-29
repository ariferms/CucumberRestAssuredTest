package com.hotelrezervations.steps;

import com.hotelrezervations.models.BookingUpdateResponse;
import com.hotelrezervations.services.BookingIdService;
import com.hotelrezervations.services.ReservationUpdateService;
import com.hotelrezervations.services.TokenService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.*;

public class ReservationUpdateSteps {
    ReservationUpdateService reservationUpdateService;
    String token;
    BookingUpdateResponse bookingUpdateResponse;
    int bookingId;
    @Given("Guncellenencek bir bookingid olusturulur")
    public void generateBookingId(){
        BookingIdService generateId = new BookingIdService();
        bookingId = generateId.bookingId();
    }

    @Given("Kullanici rezervasyon guncelleme icin gerekli bilgileri aliyor")
    public void callInfo() {
        reservationUpdateService = new ReservationUpdateService();
        TokenService generateToken = new TokenService();
        token = generateToken.generateToken();
    }

    @When("Kullanici rezervasyon guncelleme islemini gerceklestiriyor")
    public void updateBooking() {
        bookingUpdateResponse = reservationUpdateService.updateBooking(token, bookingId);
    }

    @Then("Kullanici rezervasyonun guncel halini kontrol ediyor")
    public void updateKontrol() {
        Assertions.assertEquals("Ayşe", bookingUpdateResponse.getFirstname());
        Assertions.assertEquals("Sigara içilmeyen ve kahvaltılı oda.", bookingUpdateResponse.getAdditionalneeds());
    }
}
