import io.restassured.response.Response;

public class DeleteCourierApi extends BaseHttpClient {
    private final String apiPath = "/api/v1/courier:id";
    public static String id;


    public Response getCourierById(int id) {
        return doGetRequest(apiPath + ":" + id);
    }

    public Response deleteCourier(DeleteCourier deleteCourier, String id) {
        this.id = id;
        return doPostRequest(apiPath, deleteCourier);
    }
}
