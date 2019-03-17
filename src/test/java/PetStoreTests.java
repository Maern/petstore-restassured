import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PetStoreTests {
    @Test
    public void getPetById200(){
        RestAssured.given().baseUri(Config.PET_STORE_BASE_URI)
                .baseUri("/pet/1")
                .log().uri()
                .then().statusCode(200);


    }

    @Test
    public void getPetById404(){
        RestAssured.given().baseUri(Config.PET_STORE_BASE_URI)
                .baseUri("/pet/0")
                .log().uri()
                .then().statusCode(404);

    }
}
