package tests;

import common.models.update.UpdateRequestModel;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static common.endpoints.ConstantEndpoints.UPDATE;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static testData.UpdateTestData.UPDATE_JOB;
import static testData.UpdateTestData.UPDATE_NAME;

@DisplayName("Тесты на изменение пользователя")
public class UpdateUserTests extends AbstractTest {

    @Test
    @DisplayName("Изменение пользователя")
    void updateTest() {
        UpdateRequestModel updateBody = new UpdateRequestModel();
        updateBody.setName(UPDATE_NAME);
        updateBody.setJob(UPDATE_JOB);

        Response response = given(requestSpec)
                .body(updateBody)
                .when()
                .put(UPDATE)
                .then()
                .spec(responseSpec)
                .statusCode(SC_OK)
                .extract().response();

        assertEquals(UPDATE_NAME, response.jsonPath().getString("name"));
        assertEquals(UPDATE_JOB, response.jsonPath().getString("job"));
    }
}