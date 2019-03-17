import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PetStoreTests {
    @Test
    public void getPetById200() {
        baseSpecification()
                .basePath(Config.GET_PET_ENDPOINT)
                .pathParam("id", 1)
                .get()
                .then()
                .statusCode(200);


    }

    @Test
    public void getPetById404() {
        baseSpecification()
                .basePath(Config.GET_PET_ENDPOINT)
                .pathParam("id", 0)
                .get()
                .then()
                .statusCode(404);

    }

    private RequestSpecification baseSpecification() {
        return RestAssured.given()
                .baseUri(Config.PET_STORE_BASE_URI)
                .log().uri();

    }
}
