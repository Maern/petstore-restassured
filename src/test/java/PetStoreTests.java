import org.testng.annotations.Test;

public class PetStoreTests {

    final PetEndpoint PET_ENDPOINT = new PetEndpoint(); //new static variable from PetEndpoint

    @Test
    public void getPetById200() {
        PET_ENDPOINT.getPetById(1)
                .then()
                .statusCode(200);


    }

    @Test
    public void getPetById404() {
        PET_ENDPOINT.getPetById(2)
                .then()
                .statusCode(404);

    }


}
