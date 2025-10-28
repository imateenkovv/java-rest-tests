package checkers;

import common.models.user.UserInfoResponseModel;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static testData.SingleUserTestData.SINGLE_USER_AVATAR;
import static testData.SingleUserTestData.SINGLE_USER_EMAIL;
import static testData.SingleUserTestData.SINGLE_USER_FIRST_NAME;
import static testData.SingleUserTestData.SINGLE_USER_ID;
import static testData.SingleUserTestData.SINGLE_USER_LAST_NAME;

public class SingleUserCheckers {

    @Step("Проверка одного полученного пользователя")
    public static void checkSingleUser(UserInfoResponseModel response) {
        assertAll(
                () -> assertEquals(SINGLE_USER_ID, response.getData().getId()),
                () -> assertEquals(SINGLE_USER_EMAIL, response.getData().getEmail()),
                () -> assertEquals(SINGLE_USER_FIRST_NAME, response.getData().getFirst_name()),
                () -> assertEquals(SINGLE_USER_LAST_NAME, response.getData().getLast_name()),
                () -> assertEquals(SINGLE_USER_AVATAR, response.getData().getAvatar())
        );
    }
}
