package tests;

import common.models.login.LoginRequestModel;
import common.models.login.LoginResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static specs.LoginSpec.loginRequestSpec;
import static specs.LoginSpec.loginResponseSpec;
import static testData.LoginTestData.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSuccessfulTest {

    @Test
    @DisplayName("Успешный логин")
    void loginSuccessfulTest() {
        LoginRequestModel authBody = new LoginRequestModel();
        authBody.setEmail(EMAIL_FOR_LOGIN_SUCCESS);
        authBody.setPassword(PASSWORD_FOR_LOGIN_SUCCESS);

        LoginResponseModel response = given(loginRequestSpec)
                .body(authBody)
                .when()
                .post()
                .then()
                .spec(loginResponseSpec)
                .extract().as(LoginResponseModel.class);

        assertEquals(TOKEN_FOR_LOGIN_SUCCESS, response.getToken());

    }
}
