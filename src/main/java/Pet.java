import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;1
public class Pet {
String baseurl="https://petstore.swagger.io/v2/";
  @Test
  public void createPet() {
    String endpoint = baseurl+"pet";
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

    given()
        .header("Content-Type", "application/json")
        .body(body)
        .when()
        .post(endpoint).
        then().
        assertThat().
        statusCode(200).
        body("status", equalTo("available")).
        body("name", equalTo("brenda"));
  }

  @Test
  public void getOrder() {
    String endpoint = baseurl+"store/order/";
    int orderId = 6;

    given().
        queryParam("orderId",orderId)
        .header("Content-Type", "application/json")
        .when()
        .get(endpoint+orderId).
        then().
        assertThat().
        statusCode(200).
        body("id", equalTo(orderId)).
        body("quantity", equalTo(5)).
        body("status",equalTo("placed"));
  }

  @Test
  public void updatePet() {
    String endpoint = baseurl+"pet";
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

    given()
        .header("Content-Type", "application/json")
        .body(body)
        .when()
        .put(endpoint).
        then().
        assertThat().
        statusCode(200).
        body("status", equalTo("available")).
        body("name", equalTo("doggie"));;;
  }
}
