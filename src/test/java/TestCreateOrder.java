import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class TestCreateOrder {
    private static String login = "Pavel_Sprint_7";
    private static String password = "12345678";
    private static String firstName = "Pavel";
    private static String lastName = "Pavlov";
    private static String address = "Tambovskaya 16/19";
    private static String metroStation = "Tambovskaya";
    private static String phone = "+79999999999";
    private static int rentTime = 4;
    private static String deliveryDate = "2024-10-10";
    private static String comment = "Pasha will drive";
    private static String color1;
    private static String color2;
    private final String[] color = {color1, color2};
    public TestCreateOrder(String color1, String color2) {
        this.color1 = color1;
        this.color2 = color2;

    }


    @BeforeClass
    public static void regCourier() {
        CreateCourierApi createCourierApi = new CreateCourierApi();
        CreateCourier courier = new CreateCourier(login, password, firstName);
        createCourierApi.createCourier(courier);
    }

    @Parameterized.Parameters
    public  static  Object[][] getCredentials() {
        return new Object[][] {
                {"BLACK", null},
                {null, "GREY"},
                {"BLACK", "GREY"},
                {null, null}

        };
    }

    @Test
    @DisplayName("Позитивная проверка создания заказа") // имя теста
    @Description("Направляется запрос на ") // описание теста
    public void positiveLoginCourierTest() {
        CreateOrdersApi createOrdersApi = new CreateOrdersApi();
        CreateOrders createOrders = new CreateOrders(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
        createOrdersApi.createOrder(createOrders).then().statusCode(201).assertThat().body("track", notNullValue());
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
}

