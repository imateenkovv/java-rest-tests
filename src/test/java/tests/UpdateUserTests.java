package tests;

import common.models.update.UpdateRequestModel;
import common.models.user.UpdateUserResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static common.api.ApiAllRequests.getSingleUserRequest;
import static common.specs.Spec.specRequest;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static testData.UpdateTestData.UPDATE_JOB;
import static testData.UpdateTestData.UPDATE_NAME;

@DisplayName("Тесты на изменение пользователя")
public class UpdateUserTests extends AbstractTest {

    @Test
    @DisplayName("Изменение пользователя")
    void updateTest() {
        UpdateRequestModel updateBody = new UpdateRequestModel()
                .setName(UPDATE_NAME)
                .setJob(UPDATE_JOB);

        UpdateUserResponseModel response = getSingleUserRequest(updateBody, specRequest).checkStatusCode(SC_OK).successBody();

        assertEquals(updateBody.getName(), response.getName());
        assertEquals(updateBody.getJob(), response.getJob());
    }
}