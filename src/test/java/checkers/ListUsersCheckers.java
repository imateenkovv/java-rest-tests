package checkers;

import common.models.user.ListUsers;
import common.models.user.UserData;
import io.qameta.allure.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ListUsersCheckers {

    @Step("Проверка объекта data")
    public static void checkUserData(ListUsers response) {
        UserData data = response.getData().stream().filter(d -> d.getId().equals(7L)).findFirst().orElse(null);
        assertAll(
                () -> assertThat(data.getEmail(), is("michael.lawson@reqres.in")),
                () -> assertThat(data.getAvatar(), is("https://reqres.in/img/faces/7-image.jpg"))
        );
    }

    @Step("Проверка pages")
    public static void checkUserPage(ListUsers response) {
        assertAll(
                () -> assertThat(response.getPage(), is(2)),
                () -> assertThat(response.getTotal(), is(12))
        );
    }
}
