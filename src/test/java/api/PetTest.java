package api;

import api.data_provider.EnumDataProvider;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.anton.api.object.Category;
import org.anton.api.object.ApiResponse;
import org.anton.api.object.Pet;
import org.anton.api.enums.Status;
import org.anton.api.object.Tag;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class PetTest extends BaseAPITest {
    private final String PET_ENDPOING = "pet/";

    @Test
    public void schemaGetPetByIdTest() {
        get(PET_ENDPOING + "2")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("pet.json"));
    }

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
                .get(PET_ENDPOING + "2")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().as(Pet.class);
        assertEquals(expected, actual);
    }

    @Test
    public void getPetByNegativeIdTest() {
        ApiResponse expected = new ApiResponse(1, "error", "Pet not found");
        ApiResponse actual = given()
                .contentType(ContentType.JSON)
                .when()
                .get(PET_ENDPOING + "-1")
                .then()
                .log().all()
                .statusCode(404)
                .extract().body().as(ApiResponse.class);
        assertEquals(expected, actual);
    }

    @Test
    public void getPetByLetterIdTest() {
        ApiResponse expected = new ApiResponse(1, "error", "Invalid ID supplied");
        ApiResponse actual = given()
                .contentType(ContentType.JSON)
                .when()
                .get(PET_ENDPOING + "a")
                .then()
                .log().all()
                .statusCode(400)
                .extract().body().as(ApiResponse.class);
        assertEquals(expected, actual);
    }

    @Test
    public void getPetByIdReturnsCorrectIdTest(){
        Integer expectedId = 1;
        Integer actualId = get(PET_ENDPOING + expectedId)
                .then()
                .assertThat()
                .log().all()
                .extract().path("id");
        assertEquals(expectedId, actualId);
    }

    @Test(dataProvider = "statusesData", dataProviderClass = EnumDataProvider.class)
    public void getPetByStatusVerifyStatusTest(Status status){
        JsonPath jsonPath = given()
                .param("status", status.name())
                .get(PET_ENDPOING + "findByStatus")
                .then()
                .log().all()
                .extract()
                .jsonPath();
        List<String> actualStringStatuses = jsonPath.get("status");
        List<Status> actualStatuses = actualStringStatuses.stream().map(Status::valueOf).toList();
        assertTrue(actualStatuses.stream().allMatch(s -> s.equals(status)));
    }

    @Test(dataProvider = "statusesData", dataProviderClass = EnumDataProvider.class)
    public void getPetByStatusSerializeTest(Status status){
        List<Pet> actualPets = given()
                .param("status", status.name())
                .get(PET_ENDPOING + "findByStatus")
                .then()
                .log().all()
                .extract()
                .body().jsonPath().getList(".",Pet.class);
        assertTrue(actualPets.stream().allMatch(s -> s.getStatus().equals(status)));
    }
}
