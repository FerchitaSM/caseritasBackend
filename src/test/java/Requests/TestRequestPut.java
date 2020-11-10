package Requests;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;

import static io.restassured.RestAssured.given;

public class TestRequestPut {


    public static void main(String[] args){

        given().when()
                .body(new File("src/test/java/Requests/PutTest.json")).contentType(ContentType.JSON)
                .put("http://localhost:8080/contactanos/actualizar")
                .then().assertThat().statusCode(202)
                .toString();


    }




}
