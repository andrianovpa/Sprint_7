package api.client;

import api.base.BaseHttpClient;
import api.model.DeleteCourier;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class DeleteCourierApi extends BaseHttpClient {
    private final String apiPath = "/api/v1/courier/";

    @Step("Отправляется запрос на удаление пользователя")
    public Response deleteCourier(DeleteCourier deleteCourier, int id) {
        return doDeleteRequest(apiPath + id, deleteCourier);
    }
}