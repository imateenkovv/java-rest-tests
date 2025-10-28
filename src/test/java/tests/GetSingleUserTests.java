package tests;

import common.models.user.UserInfoResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static checkers.SingleUserCheckers.checkSingleUser;
import static common.api.ApiAllRequests.getSingleUserRequest;
import static common.specs.Spec.specRequest;
import static org.apache.http.HttpStatus.SC_OK;

@DisplayName("Тесты на получение одного пользователя")
public class GetSingleUserTests extends AbstractTest {

    @Test
    @DisplayName("Получение одного пользователя")
    void singleUserTest() {

        UserInfoResponseModel response = getSingleUserRequest(specRequest).checkStatusCode(SC_OK).successBody();
        checkSingleUser(response);
    }
}