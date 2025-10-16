package tests;

import common.models.user.ListUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static common.api.ApiAllRequests.getListUsersRequest;
import static common.specs.Spec.specRequest;
import static org.apache.http.HttpStatus.SC_OK;

@DisplayName("Тесты на проверку получения списка пользователей")
public class ListUsersTests {


    @Test
    @DisplayName("Получение списка пользователей")
    void listUsersTest() {
        ListUsers response = getListUsersRequest(specRequest).checkStatusCode(SC_OK).successBody();
    }
}