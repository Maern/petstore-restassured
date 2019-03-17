import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PetStoreTests {
    @Test
    public void getPetById200(){
        RestAssured.given().baseUri(Config.PET_STORE_BASE_URI).get().then().statusCode(200);
                //.and().extract().body();

    }

    @Test
    public void getPetById404(){
        RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet/0").get().then().statusCode(404);

    }
}
