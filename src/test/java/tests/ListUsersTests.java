package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static common.endpoints.ConstantEndpoints.LIST_USERS;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;
import static testData.ListUsersTestData.SUPPORT_TEXT;
import static testData.ListUsersTestData.SUPPORT_TEXT_VALUE;
import static testData.ListUsersTestData.SUPPORT_URL;
import static testData.ListUsersTestData.SUPPORT_URL_VALUE;

@DisplayName("Тесты на проверку получения списка пользователей")
public class ListUsersTests extends AbstractTest {

    @Test
    @DisplayName("Получение списка пользователей")
    void listUsersTest() {

        given(requestSpec)
                .when()
                .get(LIST_USERS)
                .then()
                .spec(responseSpec)
                .statusCode(SC_OK)
                .body(SUPPORT_URL, is(SUPPORT_URL_VALUE))
                .body(SUPPORT_TEXT, is(SUPPORT_TEXT_VALUE));
    }
}