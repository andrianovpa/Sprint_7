import io.restassured.response.ValidatableResponse;

public class CourierSteps {

    private CreateCourierApi createCourierApi = new CreateCourierApi();


    private ValidatableResponse response;
    public void createCourierApi(CreateCourier courier) {
        response = createCourierApi.createCourier(courier).then();
    }
}
