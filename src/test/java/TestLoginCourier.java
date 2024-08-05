import api.client.CreateCourierApi;
import api.client.DeleteCourierApi;
import api.client.LoginCourierApi;
import api.model.CreateCourier;
import api.model.DeleteCourier;
import api.model.LoginCourier;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestLoginCourier {

    private static String login = "Pavel_Sprint_7";
    private static String password = "12345678";
    private static String firstName = "Павел";
    private static String negativeLogin = "Pavel_Sprint_1";
    private static String negativePassword = "1234567";


    @BeforeClass
    public static void regCourier() {
        CreateCourierApi createCourierApi = new CreateCourierApi();
        CreateCourier courier = new CreateCourier(login, password, firstName);
        createCourierApi.createCourier(courier);
    }

    @AfterClass
    public static void deleteCourier() {
        LoginCourierApi loginCourierApi = new LoginCourierApi();
        LoginCourier loginCourier = new LoginCourier(login, password);
        int id = loginCourierApi.loginCourier(loginCourier).then().extract().path("id");

        DeleteCourierApi deleteCourierApi = new DeleteCourierApi();
        DeleteCourier deleteCourier = new DeleteCourier(id);
        deleteCourierApi.deleteCourier(deleteCourier, id);
    }

    @Test
    @DisplayName("Позитивная проверка авторизации курьера") // имя теста
    @Description("Направляется запрос на авторизацию курьера с валидными данными") // описание теста
    public void positiveLoginCourierTest() {
        LoginCourierApi loginCourierApi = new LoginCourierApi();
        LoginCourier loginCourier = new LoginCourier(login, password);
        loginCourierApi.loginCourier(loginCourier).then().statusCode(200).assertThat().body("id", notNullValue());
    }

    @Test
    @DisplayName("Негативная проверка авторизации курьера 1") // имя теста
    @Description("Направляется запрос на авторизацию курьера без логина") // описание теста
    public void negativeLoginCourierTest_1() {
        LoginCourierApi loginCourierApi = new LoginCourierApi();
        LoginCourier loginCourier = new LoginCourier(null, password);
        loginCourierApi.loginCourier(loginCourier).then().statusCode(400).assertThat().body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Негативная проверка авторизации курьера 2") // имя теста
    @Description("Направляется запрос на авторизацию курьера без пароля") // описание теста
    public void negativeLoginCourierTest_2() {
        LoginCourierApi loginCourierApi = new LoginCourierApi();
        LoginCourier loginCourier = new LoginCourier(login, "");
        loginCourierApi.loginCourier(loginCourier).then().statusCode(400).assertThat().body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Негативная проверка авторизации курьера 3") // имя теста
    @Description("Направляется запрос на авторизацию курьера c неверным логином") // описание теста
    public void negativeLoginCourierTest_3() {
        LoginCourierApi loginCourierApi = new LoginCourierApi();
        LoginCourier loginCourier = new LoginCourier(negativeLogin, password);
        loginCourierApi.loginCourier(loginCourier).then().statusCode(404).assertThat().body("message", equalTo("Учетная запись не найдена"));
    }

    @Test
    @DisplayName("Негативная проверка авторизации курьера 4") // имя теста
    @Description("Направляется запрос на авторизацию курьера с неверным паролем") // описание теста
    public void negativeLoginCourierTest_4() {
        LoginCourierApi loginCourierApi = new LoginCourierApi();
        LoginCourier loginCourier = new LoginCourier(login, negativePassword);
        loginCourierApi.loginCourier(loginCourier).then().statusCode(404).assertThat().body("message", equalTo("Учетная запись не найдена"));
    }

    @Test
    @DisplayName("Негативная проверка авторизации курьера 5") // имя теста
    @Description("Направляется запрос на авторизацию курьера с логином и неверным паролем") // описание теста
    public void negativeLoginCourierTest_5() {
        LoginCourierApi loginCourierApi = new LoginCourierApi();
        LoginCourier loginCourier = new LoginCourier(negativeLogin, negativePassword);
        loginCourierApi.loginCourier(loginCourier).then().statusCode(404).assertThat().body("message", equalTo("Учетная запись не найдена"));
    }
}
