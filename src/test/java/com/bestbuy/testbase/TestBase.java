package com.bestbuy.testbase;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;


public class TestBase {

    @BeforeClass
    public  void inInt(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
       // RestAssured.basePath = "/stores";
    }

}