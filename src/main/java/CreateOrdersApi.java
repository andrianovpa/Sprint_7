import io.restassured.response.Response;

public class CreateOrdersApi extends BaseHttpClient{
    private final String apiPath = "/api/v1/orders";

    public Response createOrder(CreateOrders createOrders) {
        return doPostRequest(apiPath, createOrders);
    }
}
