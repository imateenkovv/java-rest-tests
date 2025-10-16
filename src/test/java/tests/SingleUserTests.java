package tests;

import common.models.user.UserInfoResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static common.api.ApiAllRequests.getSingleUserRequest;
import static common.specs.Spec.specRequest;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static testData.SingleUserTestData.SINGLE_USER_AVATAR;
import static testData.SingleUserTestData.SINGLE_USER_EMAIL;
import static testData.SingleUserTestData.SINGLE_USER_FIRST_NAME;
import static testData.SingleUserTestData.SINGLE_USER_ID;
import static testData.SingleUserTestData.SINGLE_USER_LAST_NAME;

@DisplayName("Тесты на получение одного пользователя")
public class SingleUserTests extends AbstractTest {

    @Test
    @DisplayName("Получение одного пользователя")
    void singleUserTest() {

        UserInfoResponseModel response = getSingleUserRequest(specRequest).checkStatusCode(SC_OK).successBody();

        assertEquals(SINGLE_USER_ID, response.getData().getId());
        assertEquals(SINGLE_USER_EMAIL, response.getData().getEmail());
        assertEquals(SINGLE_USER_FIRST_NAME, response.getData().getFirst_name());
        assertEquals(SINGLE_USER_LAST_NAME, response.getData().getLast_name());
        assertEquals(SINGLE_USER_AVATAR, response.getData().getAvatar());
    }
}