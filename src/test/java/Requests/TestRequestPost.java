package Requests;


import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.File;
import static io.restassured.RestAssured.given;

public class TestRequestPost {

    public static void main(String[] args){

        given().when()
                .body(new File("src/test/java/Requests/PostTest.json")).contentType(ContentType.JSON)
                .post("http://localhost:8080/contactanos/guardar")
                .then().assertThat()
                    .statusCode(201)
                .toString();
    }


}
