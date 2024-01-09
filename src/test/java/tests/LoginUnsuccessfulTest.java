package tests;

import models.login.LoginResponseModel;
import models.login.LoginUnSuccessModel;
import org.junit.jupiter.api.Test;

import static helpers.ConstantsEndpoints.LOGIN_SUCCESS;
import static specs.LoginSpec.loginRequestSpec;
import static specs.LoginSpec.loginUnSuccessResponseSpec;
import static testData.LoginTestData.EMAIL_FOR_LOGIN_UNSUCCESS;
import static testData.LoginTestData.ERROR_MESSAGE_LOGIN_UNSUCCESS;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author mateenkov
 */

public class LoginUnsuccessfulTest {

    @Test
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
