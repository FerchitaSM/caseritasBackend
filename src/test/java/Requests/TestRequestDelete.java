package Requests;


import io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TestRequestDelete {


    public static void main(String[] args){
        Response response = given().when()
                .delete("http://localhost:8080/contactanos/borrar/23");

        assertEquals("Borrado", response.prettyPrint());

    }

}
