package com.hotelreservations.steps;

import com.hotelreservations.models.BookingResponse;
import com.hotelreservations.services.ReservationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class ReservationSteps {
    ReservationService reservationService;
    String authKey;
    BookingResponse bookingResponse;
    @Given("Kullanici yeni bir rezervasyon olusturuyor")
    public void callStart() {
        reservationService = new ReservationService();
    }

    @Given("Kullanici rezervasyon icin gereken bilgileri veriyor")
    public void createAuth() {
        authKey = reservationService.generateToken();
    }

    @When("Kullanici otel rezervasyonu yaratiyor")
    public void createReservation() {
        bookingResponse = reservationService.createBooking();
    }

    @Then("Rezervasyon basarili bir sekilde olusturuldu")
    public void reservationAssertions() {
        Assert.assertNotNull(bookingResponse.getBookingid());
        Assertions.assertEquals("Arif", bookingResponse.getBooking().getFirstname());
        Assertions.assertEquals("Ermiş", bookingResponse.getBooking().getLastname());
        Assertions.assertEquals(100, bookingResponse.getBooking().getTotalprice());
        Assertions.assertTrue(bookingResponse.getBooking().isDepositpaid());
        Assertions.assertEquals("2024-01-01", bookingResponse.getBooking().getBookingdates().getCheckin());
        Assertions.assertEquals("2024-04-04", bookingResponse.getBooking().getBookingdates().getCheckout());
        Assertions.assertEquals("Sigara içilemez oda.", bookingResponse.getBooking().getAdditionalneeds());
    }

    @Then("Kullanici olusturulan rezervasyonu iptal ediyor")
    public void deleteReservation() {
        reservationService.deleteRezervation(authKey, bookingResponse.getBookingid());
    }
}
