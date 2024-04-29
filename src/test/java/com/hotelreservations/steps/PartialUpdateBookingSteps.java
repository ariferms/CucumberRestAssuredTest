package com.hotelreservations.steps;

import com.hotelreservations.models.BookingUpdateResponse;
import com.hotelreservations.services.PartialUpdateBookingService;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;

public class PartialUpdateBookingSteps {
    String token;
    PartialUpdateBookingService partialUpdateBookingService = new PartialUpdateBookingService();
    String partialBody;
    BookingUpdateResponse bookingUpdateResponse;
    int bookingid;

    @Given("bookingid olusturulur")
    public void reservationId() {
        bookingid = partialUpdateBookingService.bookingId();
    }

    @Given("Kullanici rezervasyon icin gereken bilgileri topluyor")
    public void callInfo() {
        // Token
        token = partialUpdateBookingService.generateToken();

        // Partial Body
        partialBody = partialUpdateBookingService.partialBody().toString();
    }

    @Given("Kullanici rezervasyonu parselleyerek guncelleme islemini gerceklestirir")
    public void partialUpdateTest() {
        bookingUpdateResponse = partialUpdateBookingService.partialUpdate(token, bookingid, partialBody);
    }

    @Given("Guncellenen parsel kontrol edilir")
    public void partialUpdateKontrol() {
        // Guncelleme kontrol
        Assertions.assertEquals("Ayşe", bookingUpdateResponse.getFirstname());
        Assertions.assertEquals("2024-04-27", bookingUpdateResponse.getBookingdates().getCheckin());

    }
}
