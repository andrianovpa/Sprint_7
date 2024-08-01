import io.qameta.allure.Step;
import io.restassured.response.Response;

public class CreateCourierApi extends BaseHttpClient {
    private final String apiPath = "/api/v1/courier";

    @Step("Отправляется запрос на создание пользователя")
    public Response createCourier(CreateCourier courier) {
        return doPostRequest(apiPath, courier);
    }
}
