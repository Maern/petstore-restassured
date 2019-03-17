import org.testng.annotations.Test;

import javax.xml.ws.Response;

import static org.hamcrest.Matchers.is;

public class PetStoreTests {

    final static PetEndpoint PET_ENDPOINT = new PetEndpoint(); //new constant variable from PetEndpoint

    @Test
    public void getPetById200() {
        PET_ENDPOINT
                .getPetById(205)
                .then()
                .statusCode(200);

    }

    @Test
    public void getPetById404() {
        PET_ENDPOINT
                .getPetById(0)
                .then()
                .statusCode(404);

    }

    @Test
    public void getPetByStatus() {
        PET_ENDPOINT
                .getPetByStatus("available")
                .then()
                .statusCode(200);
    }

    @Test
    public void createPet() {
        int petId = 207;
        PetEntity petEntity = new PetEntity(petId, "kotya", "available");
        PET_ENDPOINT
                .createPetInStore(petEntity)
                .then()
                .statusCode(200)
                .and().body("id", is(petId));
    }
}
