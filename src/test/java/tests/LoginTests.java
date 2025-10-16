package tests;

import common.models.login.LoginErrorResponseModel;
import common.models.login.LoginRequestModel;
import common.models.login.LoginResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static common.api.ApiAllRequests.loginSuccessRequest;
import static common.specs.Spec.specRequest;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static testData.LoginTestData.EMAIL_FOR_LOGIN_SUCCESS;
import static testData.LoginTestData.EMAIL_FOR_LOGIN_UNSUCCESS;
import static testData.LoginTestData.ERROR_MESSAGE_LOGIN_UNSUCCESS;
import static testData.LoginTestData.PASSWORD_FOR_LOGIN_SUCCESS;
import static testData.LoginTestData.TOKEN_FOR_LOGIN_SUCCESS;

@DisplayName("Тесты на проверку логина пользователя")
public class LoginTests extends AbstractTest {

    @Test
    @DisplayName("Успешный логин")
    void loginSuccessfulTest() {
        LoginRequestModel authBody = new LoginRequestModel()
                .setEmail(EMAIL_FOR_LOGIN_SUCCESS)
                .setPassword(PASSWORD_FOR_LOGIN_SUCCESS);

        LoginResponseModel response = loginSuccessRequest(authBody, specRequest).checkStatusCode(SC_OK).successBody();

        assertEquals(TOKEN_FOR_LOGIN_SUCCESS, response.getToken());
    }

    @Test
    @DisplayName("Неуспешный логин")
    void loginUnsuccessfulTest() {
        LoginRequestModel authBody = new LoginRequestModel().setEmail(EMAIL_FOR_LOGIN_UNSUCCESS);

        LoginErrorResponseModel response = loginSuccessRequest(authBody, specRequest).checkStatusCode(SC_BAD_REQUEST).errorBody();

        assertEquals(ERROR_MESSAGE_LOGIN_UNSUCCESS, response.getError());
    }
}