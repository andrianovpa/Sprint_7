import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(Parameterized.class)
public class TestCreateCourier {
    private final String login;
    private final String password;
    private final String firstName;
    private final String result;
    private final int responseCode;
    private final String responseField;
//    public static String id;

    public TestCreateCourier(String login, String password, String firstName, String result, int responseCode, String responseField) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.result = result;
        this.responseCode = responseCode;
        this.responseField = responseField;
    }

    @Before
    public void setUp() {

        RestAssured.baseURI= "https://qa-scooter.praktikum-services.ru/";
    }
    @Parameterized.Parameters
    public  static  Object[][] getCredentials() {
        return new Object[][] {
                {"Pavel_Sprint_7_4", "12345678", "Павел", null, 201, "ok"},
                {"Pavel_Sprint_7_4", "12345678", "Павел", "Этот логин уже используется", 409, "message"},
                {"", "12345678", "Павел", "Недостаточно данных для создания учетной записи", 400, "message"},
                {"Pavel_Sprint_7_5", "", "Павел", "Недостаточно данных для создания учетной записи", 400, "message"},

        };
    }
    @Test
    @DisplayName("Check status code of /users/me") // имя теста
    @Description("Basic test for /users/me endpoint") // описание теста
    public void positiveCreateCourierTest() {
        PostApi postApi = new PostApi();
        Courier courier = new Courier(login, password, firstName);
        postApi.createCourier(courier).then().statusCode(responseCode).assertThat().body(responseField, equalTo(result != null ? result : true));
    }
//    @After
//    public void deleteCourier() {
//
//    }
//        File json = new File("C:\\Users\\Pavel-PC\\Sprint_7\\src\\main\\resources\\CourierCreate.json");
//        given()
//                .header("Content-type", "application/json")
//                .auth().oauth2("")
//                .and()
//                .body(json)
//                .when()
//                .post("/api/v1/courier")
//                .then().statusCode(201)
//                .assertThat()
//                .body("ok", equalTo(true));
//    }
}
