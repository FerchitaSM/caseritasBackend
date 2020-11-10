package Requests;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TestRequestPatch {

    public static void main(String[] args){

        given().when()
                .body(new File("src/test/java/Requests/PatchTest.json")).contentType(ContentType.JSON)
                .patch("http://localhost:8080/contactanos/actualizar/24")
                .then().assertThat()
                        .statusCode(202)
                        .contentType(ContentType.TEXT)
                .toString();

    }




}
