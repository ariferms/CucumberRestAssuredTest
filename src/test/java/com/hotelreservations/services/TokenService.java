package com.hotelreservations.services;

import com.hotelreservations.models.Auth;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TokenService extends BaseTest {
    public String generateToken() {
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
}
