import io.restassured.response.Response;

public class LoginCourierApi extends BaseHttpClient {
        private final String apiPath = "/api/v1/courier/login";

        public Response getCourierById(String id) {
            return doGetRequest(apiPath + id);
        }

        public Response loginCourier(LoginCourier courier) {
            return doPostRequest(apiPath, courier);
        }
    }
