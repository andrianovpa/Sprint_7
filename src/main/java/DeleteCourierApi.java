import io.restassured.response.Response;

import javax.swing.*;

public class DeleteCourierApi extends BaseHttpClient {
    private final String apiPath = "/api/v1/courier";
    public static String id;
    public static String id2;


    public Response getCourierById(int id) {
        return doGetRequest(apiPath + ":" + id);
    }

    public Response deleteCourier(DeleteCourier deleteCourier, String id, String id2) {
        this.id = id;
        this.id2 = id2;
        return doPostRequest(apiPath, deleteCourier);
    }
}
