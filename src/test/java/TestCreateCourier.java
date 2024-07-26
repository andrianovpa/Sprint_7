import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class TestCreateCourier {
    @Before
    public void setUp() {

        RestAssured.baseURI= "https://qa-scooter.praktikum-services.ru/";
    }
    @Test
    @DisplayName("Check status code of /users/me") // имя теста
    @Description("Basic test for /users/me endpoint") // описание теста
    public void positiveCreateCourierTest() {
        File json = new File("src/test/resources/CourierCreate.json");
        given()
                .header("Content-type", "application/json")
                .auth().oauth2("")
                .and()
                .body(json)
                .when()
                .post("/api/v1/courier")
                .then().statusCode(201);
    }
}
