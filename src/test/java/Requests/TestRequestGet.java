package Requests;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

public class TestRequestGet {

    @Test
    public static void main(String[] args){

        ResponseEntity responseEntity =  new ResponseEntity(null, HttpStatus.ACCEPTED);

        Response response =given().when()
                .get("http://localhost:8080/contactanos/listar");

        assertEquals(true, response.equals(responseEntity));




    }
}
