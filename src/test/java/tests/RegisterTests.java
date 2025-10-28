package tests;

import common.models.register.RegisterRequestModel;
import common.models.register.RegisterResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static common.api.ApiAllRequests.registerUserRequest;
import static common.specs.Spec.specRequest;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static testData.RegisterTestData.REGISTER_EMAIL_SUCCESS;
import static testData.RegisterTestData.REGISTER_ID;
import static testData.RegisterTestData.REGISTER_PASSWORD_SUCCESS;
import static testData.RegisterTestData.REGISTER_TOKEN;

@DisplayName("Тесты на проверку регистрации пользователя")
public class RegisterTests extends AbstractTest {

    @Test
    @DisplayName("Успешная регистрация")
    void registerSuccessfulTest() {
        RegisterRequestModel registerBody = new RegisterRequestModel()
                .setEmail(REGISTER_EMAIL_SUCCESS)
                .setPassword(REGISTER_PASSWORD_SUCCESS);

        RegisterResponseModel response = registerUserRequest(registerBody, specRequest).checkStatusCode(SC_OK).successBody();

        assertEquals(REGISTER_TOKEN, response.getToken());
        assertEquals(REGISTER_ID, response.getId());
    }

    @Test
    @DisplayName("Попытка регистрации пользователя без email")
    void registerWithoutEmailTest() {
        RegisterRequestModel registerBody = new RegisterRequestModel()
                .setPassword(REGISTER_PASSWORD_SUCCESS);

        RegisterResponseModel response = registerUserRequest(registerBody, specRequest).checkStatusCode(SC_OK).errorBody();

        assertEquals(REGISTER_TOKEN, response.getToken());
        assertEquals(REGISTER_ID, response.getId());
    }

    @Test
    @DisplayName("Попытка регистрации пользователя без password")
    void registerWithoutPasswordTest() {
        RegisterRequestModel registerBody = new RegisterRequestModel()
                .setEmail(REGISTER_EMAIL_SUCCESS);

        RegisterResponseModel response = registerUserRequest(registerBody, specRequest).checkStatusCode(SC_OK).successBody();

        assertEquals(REGISTER_TOKEN, response.getToken());
        assertEquals(REGISTER_ID, response.getId());
    }


}