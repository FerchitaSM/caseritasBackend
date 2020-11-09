package Requests;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class TestRequestPut {


    public static void main(String[] args){

        Response responsePut = given()
                .body(new File("C:/Users/Fernanda/Desktop/DESARROLLO DE SOFTWARE/caseritas/src/test/java/Requests/PutTest.json")).contentType(ContentType.JSON)
                .put("http://localhost:8080/contactanos/actualizar");

        System.out.println("Respuesta "+ responsePut.asString() );

    }




}
