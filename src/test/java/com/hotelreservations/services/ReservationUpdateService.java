package com.hotelreservations.services;

import com.hotelreservations.models.Booking;
import com.hotelreservations.models.BookingDates;
import com.hotelreservations.models.BookingUpdateResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ReservationUpdateService extends BaseTest {

    public BookingUpdateResponse updateBooking(String token, int bookingId) {
        BookingDates bookingDates = new BookingDates("2024-01-01", "2024-04-04");
        Booking booking = new Booking("Ayşe","Ermiş",100,true, bookingDates, "Sigara içilmeyen ve kahvaltılı oda.");

        Response response = given(spec)
                .when()
                .contentType(ContentType.JSON)
                .body(booking)
                .header("Cookie", "token=" + token)
                .put("/booking/" + bookingId);
        response
                .then()
                .statusCode(200);
        return response.as(BookingUpdateResponse.class);
    }
}
