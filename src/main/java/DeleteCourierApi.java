import io.restassured.response.Response;

import javax.swing.*;
import java.util.Map;

public class DeleteCourierApi extends BaseHttpClient {
    private final String apiPath = "/api/v1/courier/";
    public static Map<String, Integer> bodyId;


    public Response getCourierById(int id) {
        return doGetRequest(apiPath + ":" + id);
    }

    public Response deleteCourier(DeleteCourier deleteCourier, int id) {
        return doDeleteRequest(apiPath+id, deleteCourier);
    }
}
