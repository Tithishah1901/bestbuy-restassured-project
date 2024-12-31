package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest extends TestBase {

    static ValidatableResponse response;

    @BeforeClass
    public void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);

    }

//    Extraction Example
//1. Extract the limit
@Test
public void test01() {
    int limit = response.extract().path("limit");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of limit is : "+ limit);
    System.out.println("------------------End of Test---------------------------");

}
//2. Extract the total
@Test
public void test02() {
    int total = response.extract().path("total");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of total is : "+ total);
    System.out.println("------------------End of Test---------------------------");

}
//3. Extract the name of 5th store
    @Test
        public void test03() {
        String storeName = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of storeName is : " + storeName);
        System.out.println("------------------End of Test---------------------------");
    }
//4. Extract the names of all the store
@Test
public void test04() {
   List<String> storeName = response.extract().path("data.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of allStore is : " + storeName);
    System.out.println("------------------End of Test---------------------------");
}
//5. Extract the storeId of all the store
@Test
public void test05() {
    List<Integer> storeId = response.extract().path("data.id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of storeId is : " + storeId);
    System.out.println("------------------End of Test---------------------------");
}

//6. Print the size of the data list
@Test
public void test06() {
    List<String> data = response.extract().path("data");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of size of list is : " + data.size());
    System.out.println("------------------End of Test---------------------------");
}
//7. Get all the value of the store where store name = St Cloud
@Test
public void test07() {
    List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'St Cloud'}");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value for store name 'St Cloud' is : " + values);
    System.out.println("------------------End of Test---------------------------");
}
//8. Get the address of the store where store name = Rochester
@Test
public void test08() {
    String storeAddress = response.extract().path("data[8].address");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The get the address of Rochester : " + storeAddress);
    System.out.println("------------------End of Test---------------------------");
}
//9. Get all the services of 8th store
@Test
public void test09() {
    List<?> allServicesOfStore8 = response.extract().path("data[7].services");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The get the service of 8 number store : " + allServicesOfStore8);
    System.out.println("------------------End of Test---------------------------");
}
//10. Get storeservices of the store where service name = Windows Store
@Test
public void test10() {
    List<Object> storeServicesOfWindowStore = response.extract().path("data.findAll{it.name == 'Windows Store'}.services");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The get the store Services Of Window Store : " + storeServicesOfWindowStore);
    System.out.println("------------------End of Test---------------------------");
}
//11. Get all the storeId of all the store
@Test
public void test11() {
    List<Integer> storeId = response.extract().path("data.services.storeservices.storeId");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value for all storeId : " + storeId);
    System.out.println("------------------End of Test---------------------------");
}
//

//12. Get id of all the store
@Test
public void test12() {
    List<Integer> allStoreIds = response.extract().path("data.id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value for store name 'St Cloud' is : " + allStoreIds);
    System.out.println("------------------End of Test---------------------------");
}
//13. Find the store names Where state = ND
@Test
public void test13() {
    List<String> stateName = response.extract().path("data.findAll{it.state == 'ND'}.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value for state name : " + stateName);
    System.out.println("------------------End of Test---------------------------");
}

//14. Find the Total number of services for the store where store name = Rochester
@Test
public void test14() {
List<Integer> totalNumberOfServices = response.extract().path("data[8].services");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of total number of services : " + totalNumberOfServices.size());
    System.out.println("------------------End of Test---------------------------");
}
//15. Find the createdAt for all services whose name = “Windows Store”
@Test
public void test15() {
    List<String> allServices = response.extract().path("data.services.findAll{it.name. == 'Windows Store'}.createdAt");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of all services whose name = “Windows Store”  : " + allServices);
    System.out.println("------------------End of Test---------------------------");
}
//            16. Find the name of all services Where store name = “Fargo”
@Test
public void test16() {
    List<?> serviceName = response.extract().path("data.findAll{it.name == 'Fargo'}.services");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of all services whose name = “Windows Store”  : " + serviceName);
    System.out.println("------------------End of Test---------------------------");
}

//            17. Find the zip of all the store
@Test
public void test17() {
    List<String> zipOfAll = response.extract().path("data.zip");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of zip of all the store   : " + zipOfAll);
    System.out.println("------------------End of Test---------------------------");
}
//18. Find the zip of store name = Roseville
@Test
public void test18() {
    List<String> zipOfStore = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value ofzip of store name = Roseville  : " + zipOfStore);
    System.out.println("------------------End of Test---------------------------");
}
//19. Find the storeservices details of the service name = Magnolia Home Theater
@Test
public void test19() {
    List<String> serviceName = response.extract().path("data.findAll{it.name == 'Magnolia Home Theater'}.services");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value ofzip of store name = Roseville  : " + serviceName);
    System.out.println("------------------End of Test---------------------------");
}
//20. Find the lat of all the stores
@Test
public void test20() {
    List<String> latStores = response.extract().path("data.lat");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of the lat of all the stores : " + latStores);
    System.out.println("------------------End of Test---------------------------");
}
}
