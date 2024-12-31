package com.bestbuy.crudtest;

import com.bestbuy.constant.EndPoints;
import com.bestbuy.model.StorePojo;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class StoresCURDTest extends TestBase {

    static int storeId = 0;

    static String name = "Kartik" + TestUtils.getRandomValue();
    static String type = "Bigboxe";
    static String address = "King Street";
    static String address2 = "";
    static String city = "london";
    static String state = "uk";
    static String zip = "665445";


    @Test(priority = 1)
    public void createStore() {

        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);


        ValidatableResponse response = given().log().ifValidationFails()
                .header("Content-Type", "application/json")
                .when()
                .body(storePojo)
                .post(EndPoints.GET_STORES)
                .then().log().ifValidationFails().statusCode(201);

        storeId = response.extract().path("id");
        System.out.println("store id is : " + storeId);

    }

    @Test(priority = 2)
    public void readStoreDataById() {

        ValidatableResponse response = given().log().ifValidationFails()
                .pathParam("StoreId", storeId)
                .when()
                .get(EndPoints.GET_STORES_BY_ID)
                .then().log().ifValidationFails().statusCode(200);

        storeId = response.extract().path("id");
        System.out.println("store id is : " + storeId);

    }

    @Test(priority = 3)
    public void UpdateStoreDataById() {

        StorePojo storePojo = new StorePojo();
        storePojo.setName(name + "UpdatedName" + TestUtils.getRandomValue());
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);


        ValidatableResponse response = given().log().ifValidationFails()
                .header("Content-Type", "application/json")
                .pathParam("StoreId", storeId)
                .when()
                .body(storePojo)
                .put(EndPoints.UPDATE_STORE_BY_ID)
                .then().log().ifValidationFails().statusCode(200);
    }

    @Test(priority = 4)
    public void deleteStoreById() {

        given().log().ifValidationFails()
                .pathParam("StoreId", storeId)
                .when()
                .delete(EndPoints.DELETE_STORE_BY_ID)
                .then()
                .statusCode(200);

        given()
                .log()
                .ifValidationFails()
                .pathParam("StoreId", storeId)
                .when()
                .get(EndPoints.GET_STORES_BY_ID)
                .then().log().ifValidationFails().statusCode(404);
    }


}

