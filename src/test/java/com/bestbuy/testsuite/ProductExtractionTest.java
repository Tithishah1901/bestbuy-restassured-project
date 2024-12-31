package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductExtractionTest extends TestBase {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);

    }

    //    Write the following test inside ProductsExtractionTest class.
//    Extraction Example
//21. Extract the limit
    @Test
    public void test01() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    //22. Extract the total
    @Test
    public void test02() {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");

    }

    //23. Extract the name of 5th product
    @Test
    public void test03() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    //24. Extract the names of all the products
    @Test
    public void test04() {
        String productName = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of product is : " + productName);
        System.out.println("------------------End of Test---------------------------");

    }

    //25. Extract the productId of all the products
    @Test
    public void test05() {
        List<Integer> productId = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of product id is : " + productId);
        System.out.println("------------------End of Test---------------------------");
    }

    //26. Print the size of the data list
    @Test
    public void test06() {
        List<Integer> productSize = response.extract().path("data");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of product id is : " + productSize.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void test07() {
        List<HashMap> values = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of product name is : " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void test08() {
        List<HashMap<String, Object>> product = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of product name is : " + product);
        System.out.println("------------------End of Test---------------------------");
    }

    //29. Get all the categories of 8th products
    @Test
    public void test09() {
        List<String> categories = response.extract().path("data[7].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of categories of 8th product : " + categories);
        System.out.println("------------------End of Test---------------------------");
    }

    //30. Get categories of the store where product id = 150115
    @Test
    public void test10() {
        List<String> categoriesOfStores = response.extract().path("data[3].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of categories of the stores : " + categoriesOfStores);
        System.out.println("------------------End of Test---------------------------");
    }

    //31. Get all the descriptions of all the products
    @Test
    public void test11() {
        List<String> allDescription = response.extract().path("data.description");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value all the descriptions of all the products : " + allDescription);
        System.out.println("------------------End of Test---------------------------");
    }

    //32. Get id of all the all categories of all the products
    @Test
    public void test12() {
        List<String> allCategories = response.extract().path("data.categories.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value all the descriptions of all the products : " + allCategories);
        System.out.println("------------------End of Test---------------------------");
    }

    //33. Find the product names Where type = HardGood
    @Test
    public void test13() {
        List<String> productNames = response.extract().path("data.findAll{it.type == 'HardGood'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value all the descriptions of all the products : " + productNames);
        System.out.println("------------------End of Test---------------------------");
    }

    //34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test14() {
        List<String> categoriesProductNames = response.extract().path("data[1].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value all the descriptions of all the products : " + categoriesProductNames.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test15() {
        List<String> productName = response.extract().path("data.findAll{it.price < 5.49}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of products that price is less than 5.49 are: " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    //36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”
    @Test
    public void test16() {
        List<String> categories = response.extract().path("data.findAll{it.name =='Energizer - MAX Batteries AA (4-Pack)'}.categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack) : " + categories);
        System.out.println("------------------End of Test---------------------------");
    }

    //37. Find the manufacturer of all the products
    @Test
    public void test17() {
        List<String> manufacturer = response.extract().path("data.manufacturer");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the manufacturer of all the products : " + manufacturer);
        System.out.println("------------------End of Test---------------------------");
    }

    //38. Find the imge of products whose manufacturer is = Energizer
    @Test
    public void test18() {
        List<String> manufacturerImage = response.extract().path("data.findAll{it.manufacture == 'Energizer'}.image");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the imge of products whose manufacturer is = Energizer : " + manufacturerImage);
        System.out.println("------------------End of Test---------------------------");
    }

    //39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test19() {
        List<String> productName = response.extract().path("data.findAll{it.price > 5.99}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of products that price is greater than 5.99 are: " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    //40. Find the uri of all the products
    @Test
    public void test20() {
        List<String> url = response.extract().path("data.url");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the url of all the products : " + url);
        System.out.println("------------------End of Test---------------------------");
    }
}
