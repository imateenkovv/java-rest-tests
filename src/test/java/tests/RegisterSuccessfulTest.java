package tests;

import common.models.register.RegisterRequestModel;
import common.models.register.RegisterResponseModel;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.RegisterSuccessfulSpec.registerSuccessfulRequestSpec;
import static specs.RegisterSuccessfulSpec.registerSuccessfulResponseSpec;
import static testData.RegisterTestData.*;

/**
 * @author mateenkov
 */

public class RegisterSuccessfulTest {

    @Test
    void registerSuccessfulTest(){
        RegisterRequestModel registerBody = new RegisterRequestModel();
        registerBody.setEmail(REGISTER_EMAIL_SUCCESS);
        registerBody.setPassword(REGISTER_PASSWORD_SUCCESS);

        RegisterResponseModel response = given(registerSuccessfulRequestSpec)
                .body(registerBody)
                .when()
                .post()
                .then()
                .spec(registerSuccessfulResponseSpec)
                .extract().as(RegisterResponseModel.class);

        assertEquals(REGISTER_TOKEN, response.getToken());
        assertEquals(REGISTER_ID, response.getId());


    }
}
