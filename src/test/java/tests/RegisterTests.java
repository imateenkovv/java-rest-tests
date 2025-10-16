package tests;

import common.models.register.RegisterRequestModel;
import common.models.register.RegisterResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static common.endpoints.ConstantEndpoints.REGISTER_SUCCESS;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.RegisterSuccessfulSpec.registerSuccessfulResponseSpec;
import static testData.RegisterTestData.REGISTER_EMAIL_SUCCESS;
import static testData.RegisterTestData.REGISTER_ID;
import static testData.RegisterTestData.REGISTER_PASSWORD_SUCCESS;
import static testData.RegisterTestData.REGISTER_TOKEN;

@DisplayName("Тесты на проверку регистрации пользователя")
public class RegisterTests extends AbstractTest {

    @Test
    @DisplayName("Успешная регистрация")
    void registerSuccessfulTest() {
        RegisterRequestModel registerBody = new RegisterRequestModel();
        registerBody.setEmail(REGISTER_EMAIL_SUCCESS);
        registerBody.setPassword(REGISTER_PASSWORD_SUCCESS);

        RegisterResponseModel response = given(requestSpec)
                .body(registerBody)
                .when()
                .post(REGISTER_SUCCESS)
                .then()
                .spec(registerSuccessfulResponseSpec)
                .extract().as(RegisterResponseModel.class);

        assertEquals(REGISTER_TOKEN, response.getToken());
        assertEquals(REGISTER_ID, response.getId());
    }
}