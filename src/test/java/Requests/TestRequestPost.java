package Requests;


import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.File;
import static io.restassured.RestAssured.given;

public class TestRequestPost {

    public static void main(String[] args){

        Response responsePost = given()
                .body(new File("C:/Users/Fernanda/Desktop/DESARROLLO DE SOFTWARE/caseritas/src/test/java/Requests/PostTest.json")).contentType(ContentType.JSON)
                .post("http://localhost:8080/contactanos/guardar");

        responsePost.prettyPrint();
    }

}
