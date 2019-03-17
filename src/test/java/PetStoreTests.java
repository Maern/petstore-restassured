import org.testng.annotations.Test;

import javax.xml.ws.Response;

public class PetStoreTests {

    final static PetEndpoint PET_ENDPOINT = new PetEndpoint(); //new constant variable from PetEndpoint

    @Test
    public void getPetById200() {
        PET_ENDPOINT
                .getPetById(206)
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
    public void getPetByStatus(){
        PET_ENDPOINT
                .getPetByStatus("available")
                .then()
                .statusCode(200);
    }

    @Test
    public void createPet(){
        PetEntity petEntity = new PetEntity(205,"kotya","available");
        PET_ENDPOINT
                .createPetInStore(petEntity)
                .then()
                .statusCode(200);
    }
}
