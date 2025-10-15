package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static common.endpoints.ConstantEndpoints.SINGLE_USER;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.SingleUserSpec.singleUserRequestSpec;
import static specs.SingleUserSpec.singleUserResponseSpec;
import static testData.SingleUserTestData.*;

/**
 * @author mateenkov
 */

public class SingleUserTest {

    @Test
    @DisplayName("Получение одного пользователя")
    void singleUserTest() {

        Response response = given(singleUserRequestSpec)
                .when()
                .get(SINGLE_USER)
                .then()
                .spec(singleUserResponseSpec)
                .extract().response();

        assertEquals(SINGLE_USER_ID, response.jsonPath().getString("data.id"));
        assertEquals(SINGLE_USER_EMAIL, response.jsonPath().getString("data.email"));
        assertEquals(SINGLE_USER_FIRST_NAME, response.jsonPath().getString("data.first_name"));
        assertEquals(SINGLE_USER_LAST_NAME, response.jsonPath().getString("data.last_name"));
        assertEquals(SINGLE_USER_AVATAR, response.jsonPath().getString("data.avatar"));

    }

}
