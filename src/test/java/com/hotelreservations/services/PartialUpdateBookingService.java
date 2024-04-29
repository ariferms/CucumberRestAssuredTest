package com.hotelreservations.services;

import com.hotelreservations.models.BookingUpdateResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PartialUpdateBookingService extends BaseTest {

    public String generateToken() {
        // Token olustur
        TokenService generateToken = new TokenService();
        String token = generateToken.generateToken();
        return token;
    }

    public int bookingId(){
        // bookingid olusturma
        BookingIdService bookingIdService = new BookingIdService();
        int bookingid = bookingIdService.bookingId();
        return bookingid;
    }

    public JSONObject partialBody(){
        // Parse edilecek body

        JSONObject partialObject = new JSONObject();
        partialObject.put("firstname", "Ayşe");
        partialObject.put("bookingdates.checkin", "2024-04-27");

        return partialObject;
    }

    // Partial guncelleme islemi yapılmaktadır
    public BookingUpdateResponse partialUpdate(String token, int bookingid, String partialBody) {
        Response response = given(spec)
                .when()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .body(partialBody)
                .patch("/booking/" + bookingid);
        response
                .then()
                .statusCode(200);
        return response.as(BookingUpdateResponse.class);
    }
}
