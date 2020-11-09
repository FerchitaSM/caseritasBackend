package Requests;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class TestRequestPatch {

    public static void main(String[] args){

        Response responsePatch = given()
                .body(new File("C:/Users/Fernanda/Desktop/DESARROLLO DE SOFTWARE/caseritas/src/test/java/Requests/PatchTest.json")).contentType(ContentType.JSON)
                .patch("http://localhost:8080/contactanos/actualizar/21");

        System.out.println("Respuesta "+ responsePatch.asString() );

    }




}
