import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestLoginCourier {

    private static String login = "Pavel_Sprint_7";
    private static String password = "12345678";
    private static String firstName = "Павел";


//@Before
//        public void regCourier() {
//    CreateCourierApi createCourierApi = new CreateCourierApi();
//    CreateCourier courier = new CreateCourier(login, password, firstName);
//    CreateCourierApi.createCourier(courier);
//}
    @Test
    @DisplayName("Позитивная проверка авторизации курьера 1") // имя теста
    @Description("Направляется запрос на авторизацию курьера с валидными данными") // описание теста
    public void positiveLoginCourierTest() {
        LoginCourierApi loginCourierApi = new LoginCourierApi();
        LoginCourier loginCourier = new LoginCourier(login,password);
        LoginCourierApi.loginCourier(loginCourier).then().statusCode(200).assertThat().body("id", notNullValue());
    }

}
