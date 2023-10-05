import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class Pet {
  @BeforeTest
  public  void init() {
    RestAssured.baseURI = "https://petstore.swagger.io/";
    RestAssured.basePath = "v2/";
  }


  @Test
  public void createPet() {
    String body="{\n"
        + "  \"id\": 0,\n"
        + "  \"category\": {\n"
        + "    \"id\": 0,\n"
        + "    \"name\": \"string\"\n"
        + "  },\n"
        + "  \"name\": \"brenda\",\n"
        + "  \"photoUrls\": [\n"
        + "    \"string\"\n"
        + "  ],\n"
        + "  \"tags\": [\n"
        + "    {\n"
        + "      \"id\": 0,\n"
        + "      \"name\": \"string\"\n"
        + "    }\n"
        + "  ],\n"
        + "  \"status\": \"available\"\n"
        + "}";

         RestAssured.given()
        .header("Content-Type", "application/json")
        .body(body)
        .when()
        .post("pet").
        then().
        assertThat().
        statusCode(200).
        body("status", equalTo("available")).
        body("name", equalTo("brenda"));
  }

  @Test
  public void getOrder() {
    int orderId = 6;

         RestAssured.given().
         pathParam("orderId",orderId)
        .header("Content-Type", "application/json")
        .when()
        .get("store/order/{orderId}").
        then().
        assertThat().
        statusCode(200).
        body("id", equalTo(orderId)).
        body("quantity", equalTo(7)).
        body("status",equalTo("placed"));
  }

  @Test
  public void updatePet() {
    String body="{\n"
        + "  \"id\": 0,\n"
        + "  \"category\": {\n"
        + "    \"id\": 0,\n"
        + "    \"name\": \"string\"\n"
        + "  },\n"
        + "  \"name\": \"doggie\",\n"
        + "  \"photoUrls\": [\n"
        + "    \"string\"\n"
        + "  ],\n"
        + "  \"tags\": [\n"
        + "    {\n"
        + "      \"id\": 0,\n"
        + "      \"name\": \"string\"\n"
        + "    }\n"
        + "  ],\n"
        + "  \"status\": \"available\"\n"
        + "}";

         RestAssured.given()
        .header("Content-Type", "application/json")
        .body(body)
        .when()
        .put("pet").
        then().
        assertThat().
        statusCode(200).
        body("status", equalTo("available")).
        body("name", equalTo("doggie"));;;
  }
}
