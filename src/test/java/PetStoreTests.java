import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
public class PetStoreTests {

    //final static PetEndpoint PET_ENDPOINT = new PetEndpoint(); //new constant variable from PetEndpoint

    @Steps
    protected PetEndpoint petEndpoint;

    @Test
    public void getPetById200() {
        petEndpoint
                .getPetById(207)
                .then()
                .statusCode(200);

    }

    @Test
    public void getPetById404() {
        petEndpoint
                .getPetById(0)
                .then()
                .statusCode(404);

    }

    @Test
    public void getPetByStatus() {
        petEndpoint
                .getPetByStatus("available")
                .then()
                .statusCode(200);
    }

    @Test
    public void createPet() {
        int petId = 208;
        PetEntity petEntity = new PetEntity(petId, "neko", "available");
        ValidatableResponse() = new petEndpoint
                .createPetInStore(petEntity)
                .then()
                .statusCode(200)
                .and().body("id", is(petId));
    }
}
