package com.tests;

import static org.junit.jupiter.api.Assertions.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FlyAwayTests {

    @Test
    public void validateStatusCode200() {
        given().
            baseUri("http://localhost:8081/FlyAway").
        when().
            get("/home").
        then().
            assertThat().
            statusCode(200);
    }

    @Test
    public void validateResponseTime() {
        given().
            baseUri("http://localhost:8081/FlyAway").
        when().
            get("/home").
        then().
            time(lessThan(200L)); // Response time in milliseconds
    }

    @Test
    public void validateBookingDetailsPresence() {
        Response response = given().
            baseUri("http://localhost:8081/FlyAway").
        when().
            get("/home").
        then().
            extract().response();

        String responseBody = response.asString();
        Assert.assertTrue(responseBody.contains("Source"));
        Assert.assertTrue(responseBody.contains("Destination"));
        Assert.assertTrue(responseBody.contains("Airline"));
        Assert.assertTrue(responseBody.contains("Duration"));
        Assert.assertTrue(responseBody.contains("Cost"));
    }

    @Test
    public void validateBookingLinks() {
        Response response = given().
            baseUri("http://localhost:8081/FlyAway").
        when().
            get("/home").
        then().
            extract().response();

        String responseBody = response.asString();
        Assert.assertTrue(responseBody.contains("<a href=\"bookflight?id=3\">Book Flight</a>"));
        Assert.assertTrue(responseBody.contains("<a href=\"bookflight?id=7\">Book Flight</a>"));
    }

    @Test
    public void validateCopyrightNotice() {
        Response response = given().
            baseUri("http://localhost:8081/FlyAway").
        when().
            get("/home").
        then().
            extract().response();

        String responseBody = response.asString();
        Assert.assertTrue(responseBody.contains("(C) FlyAway 2019"));
    }

    @Test
    public void validateLinksPresence() {
        Response response = given().
            baseUri("http://localhost:8081/FlyAway").
        when().
            get("/completepurchase").
        then().
            extract().response();

        String responseBody = response.asString();
        Assert.assertTrue(responseBody.contains("Home"));
        Assert.assertTrue(responseBody.contains("Login/Signup"));
        Assert.assertTrue(responseBody.contains("See Your Bookings"));
    }

    @Test
    public void validateStatusCode405() {
        given().
            baseUri("http://localhost:8080/FlyAway").
        when().
            post("/home").
        then().
            assertThat().
            statusCode(403);
    }


}
