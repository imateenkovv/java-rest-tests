package tests;

import common.models.login.LoginRequestModel;
import common.models.login.LoginResponseModel;
import common.models.login.LoginUnSuccessModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static common.endpoints.ConstantEndpoints.LOGIN_SUCCESS;
import static io.restassured.RestAssured.given;
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
        LoginRequestModel authBody = new LoginRequestModel();
        authBody.setEmail(EMAIL_FOR_LOGIN_SUCCESS);
        authBody.setPassword(PASSWORD_FOR_LOGIN_SUCCESS);

        LoginResponseModel response = given(requestSpec)
                .body(authBody)
                .when()
                .post(LOGIN_SUCCESS)
                .then()
                .spec(responseSpec)
                .statusCode(SC_OK)
                .extract().as(LoginResponseModel.class);

        assertEquals(TOKEN_FOR_LOGIN_SUCCESS, response.getToken());
    }

    @Test
    @DisplayName("Неуспешный логин")
    void loginUnsuccessfulTest() {
        LoginUnSuccessModel authBody = new LoginUnSuccessModel();
        authBody.setEmail(EMAIL_FOR_LOGIN_UNSUCCESS);

        LoginResponseModel response = given(requestSpec)
                .body(authBody)
                .when()
                .post(LOGIN_SUCCESS)
                .then()
                .spec(responseSpec)
                .statusCode(SC_BAD_REQUEST)
                .extract().as(LoginResponseModel.class);

        assertEquals(ERROR_MESSAGE_LOGIN_UNSUCCESS, response.getError());
    }
}