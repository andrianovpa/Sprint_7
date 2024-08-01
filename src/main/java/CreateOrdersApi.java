import io.qameta.allure.Step;
import io.restassured.response.Response;

public class CreateOrdersApi extends BaseHttpClient{
    private final String apiPath = "/api/v1/orders";
    @Step("Отправляется запрос на создание заказа")
    public Response createOrder(CreateOrders createOrders) {
        return doPostRequest(apiPath, createOrders);
    }
}
