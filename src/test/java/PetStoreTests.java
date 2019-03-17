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
        String body = "{\n" +
                "  \"id\": 206,\n" +
                "  \"category\": {\n" +
                "    \"id\": 206,\n" +
                "    \"name\": \"cat\"\n" +
                "  },\n" +
                "  \"name\": \"hello_kitty\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 13,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        PET_ENDPOINT
                .createPetInStore(body)
                .then()
                .statusCode(200);
    }
}
