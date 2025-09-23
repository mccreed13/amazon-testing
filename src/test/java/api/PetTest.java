package api;

import io.restassured.http.ContentType;
import org.anton.api.object.Category;
import org.anton.api.object.Pet;
import org.anton.api.object.Status;
import org.anton.api.object.Tag;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class PetTest extends BaseAPITest {
    private final String PET_ENDPOING = "/pet";

    @Test
    public void getPetById2Test() {
        Pet expected = Pet.builder()
                .id(2)
                .name("FluffyUpdated")
                .category(new Category(1, "Dog"))
                .tags(List.of(new Tag(1, "cute")))
                .photoUrls(List.of("http://example.com/photo.jpg"))
                .status(Status.sold)
                .build();
        Pet actual = given()
                .contentType(ContentType.JSON)
                .when()
                .get(PET_ENDPOING+"/2")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().as(Pet.class);
        assertEquals(expected, actual);
    }
}
