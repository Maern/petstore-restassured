import org.testng.annotations.Test;

public class PetStoreTests {

    final static PetEndpoint PET_ENDPOINT = new PetEndpoint(); //new constant variable from PetEndpoint

    @Test
    public void getPetById200() {
        PET_ENDPOINT
                .getPetById(1)
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

}
