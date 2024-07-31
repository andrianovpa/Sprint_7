import io.restassured.response.Response;

public class CreateCourierApi extends BaseHttpClient {
    private final String apiPath = "/api/v1/courier";

    public Response getCourierById(String id) {
        return doGetRequest(apiPath + id);
    }

    public Response createCourier(CreateCourier courier) {
        return doPostRequest(apiPath, courier);
    }
}
