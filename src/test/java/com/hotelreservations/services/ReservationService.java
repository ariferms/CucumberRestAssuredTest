package com.hotelreservations.services;

import com.hotelreservations.models.Auth;
import com.hotelreservations.models.Booking;
import com.hotelreservations.models.BookingDates;
import com.hotelreservations.models.BookingResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ReservationService extends BaseTest {
    // token olustur

    public String generateToken(){
        Auth authBody = new Auth("admin", "password123");

        Response response = given(spec)
                .when()
                .contentType(ContentType.JSON)
                .body(authBody)
                .post("/auth");
        response
                .then()
                .statusCode(200);
        return response.jsonPath().getJsonObject("token");
    }

    // rezervasyon olustur

    public BookingResponse createBooking(){
        BookingDates bookingDates = new BookingDates("2024-01-01", "2024-04-04");
        Booking booking = new Booking("Arif","Ermiş",100,true, bookingDates, "Sigara içilemez oda.");

        Response response = given(spec)
                .when()
                .contentType(ContentType.JSON)
                .body(booking)
                .post("/booking");
        response
                .then()
                .statusCode(200);
        return response.as(BookingResponse.class);
    }

    // rezervasyon silme

    public void deleteRezervation(String token, int bookingId){
        Response response = given(spec)
                .when()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .delete("/booking/" + bookingId);
        response
                .then()
                .statusCode(201);

    }
}
