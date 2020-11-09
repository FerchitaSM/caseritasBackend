package Requests;


import io.restassured.RestAssured.*;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class TestRequestDelete {


    public static void main(String[] args){
        Response responseDelete = given()
                .delete("http://localhost:8080/contactanos/borrar/25");
        System.out.println("Respuesta "+ responseDelete.asString() );
    }

}
