import io.restassured.response.Response;

public class PostApi extends BaseHttpClient {
    private final String apiPath = "/api/v1/courier";

    public Response getCourierById(String id) {
        return doGetRequest(apiPath + id);
    }

    public Response createCourier(Courier courier) {
        return doPostRequest(apiPath, courier);
    }
}
