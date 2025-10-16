package tests;

import common.models.login.LoginResponseModel;
import common.models.login.LoginUnSuccessModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static specs.LoginSpec.loginRequestSpec;
import static specs.LoginSpec.loginUnSuccessResponseSpec;
import static testData.LoginTestData.EMAIL_FOR_LOGIN_UNSUCCESS;
import static testData.LoginTestData.ERROR_MESSAGE_LOGIN_UNSUCCESS;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginUnsuccessfulTest {

    @Test
    @DisplayName("Неуспешный логин")
    void loginUnsuccessfulTest() {
        LoginUnSuccessModel authBody = new LoginUnSuccessModel();
        authBody.setEmail(EMAIL_FOR_LOGIN_UNSUCCESS);

        LoginResponseModel response = given(loginRequestSpec)
                .body(authBody)
                .when()
                .post()
                .then()
                .spec(loginUnSuccessResponseSpec)
                .extract().as(LoginResponseModel.class);

        assertEquals(ERROR_MESSAGE_LOGIN_UNSUCCESS, response.getError());

    }
}
