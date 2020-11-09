package Requests;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class TestRequestGet {
    public static void main(String[] args){
        Response responseGet = given().get("http://localhost:8080/contactanos/listar");
        responseGet.prettyPrint();
        System.out.println("Status code "+ responseGet.statusCode());

    }
}
