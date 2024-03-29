import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;


public class PetEndpoint {

    private RequestSpecification given() {
        return RestAssured.given()
                .baseUri(Config.PET_STORE_BASE_URI)
                .contentType("application/json") //adding header for sending json only
                .log().uri();

    }
@Step
    public Response getPetById(int petId) {
        return given()
                .basePath(Config.GET_PET_BY_ID)
                .pathParam("id", petId)
                .get()
                .then().extract().response();
    }
@Step
    public Response getPetByStatus(String status) {
        return given()
                .basePath(Config.GET_PET_BY_STATUS)
                .param("status","available")
                .get()
                .then().extract().response();

    }
@Step
    public Response createPetInStore(PetEntity petEntity){
        return given()
                .basePath(Config.CREATE_PET)
                .body(petEntity)
                .post()
                .then().extract().response();
    }
}
