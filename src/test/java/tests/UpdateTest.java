package tests;

import common.models.update.UpdateRequestModel;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.UpdateSpec.updateRequestSpec;
import static specs.UpdateSpec.updateResponseSpec;
import static testData.UpdateTestData.*;

/**
 * @author mateenkov
 */

public class UpdateTest {

    @Test
    @DisplayName("Изменение пользователя")
    void updateTest(){
        UpdateRequestModel updateBody = new UpdateRequestModel();
        updateBody.setName(UPDATE_NAME);
        updateBody.setJob(UPDATE_JOB);

        Response response = given(updateRequestSpec)
                .body(updateBody)
                .when()
                .put()
                .then()
                .spec(updateResponseSpec)
                .extract().response();

        assertEquals(UPDATE_NAME, response.jsonPath().getString("name"));
        assertEquals(UPDATE_JOB, response.jsonPath().getString("job"));

    }
}
