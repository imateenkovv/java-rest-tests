package common.api;

import common.models.errors.ErrorResponseModel;
import common.models.login.LoginRequestModel;
import common.models.login.LoginResponseModel;
import common.models.register.RegisterRequestModel;
import common.models.register.RegisterResponseModel;
import common.models.update.UpdateRequestModel;
import common.models.user.ListUsers;
import common.models.user.UpdateUserResponseModel;
import common.models.user.UserInfoResponseModel;
import common.specs.ApiResponses;
import common.specs.TestRequest;
import io.qameta.allure.Step;
import io.restassured.specification.FilterableRequestSpecification;

import static common.endpoints.ConstantEndpoints.BASE_URL;

public class ApiAllRequests {

    @Step("Вызов метода получения списка пользователей")
    public static ApiResponses<ListUsers, Void> getListUsersRequest(FilterableRequestSpecification requestSpec) {
        return new ApiResponses<>(
                new TestRequest(requestSpec)
                        .baseUri(BASE_URL)
                        .get("/api/users?page=2"),
                ListUsers.class, Void.class);
    }

    @Step("Вызов метода логина пользователя")
    public static ApiResponses<LoginResponseModel, ErrorResponseModel> loginSuccessRequest(LoginRequestModel requestBody,
                                                                                           FilterableRequestSpecification requestSpec) {
        return new ApiResponses<>(
                new TestRequest(requestSpec)
                        .baseUri(BASE_URL)
                        .body(requestBody)
                        .post("/api/login"),
                LoginResponseModel.class, ErrorResponseModel.class);
    }

    @Step("Вызов метода регистрации нового пользователя")
    public static ApiResponses<RegisterResponseModel, ErrorResponseModel> registerUserRequest(RegisterRequestModel requestBody,
                                                                                              FilterableRequestSpecification requestSpec) {
        return new ApiResponses<>(
                new TestRequest(requestSpec)
                        .baseUri(BASE_URL)
                        .body(requestBody)
                        .post("/api/register"),
                RegisterResponseModel.class, ErrorResponseModel.class);

    }

    @Step("Вызов метода получения одного пользователя")
    public static ApiResponses<UserInfoResponseModel, Void> getSingleUserRequest(FilterableRequestSpecification requestSpec) {
        return new ApiResponses<>(
                new TestRequest(requestSpec)
                        .baseUri(BASE_URL)
                        .get("/api/users/2"),
                UserInfoResponseModel.class, Void.class);
    }

    @Step("Вызов метода изменения сущности пользователя")
    public static ApiResponses<UpdateUserResponseModel, Void> putUserRequest(UpdateRequestModel requestBody,
                                                                             FilterableRequestSpecification requestSpec) {
        return new ApiResponses<>(
                new TestRequest(requestSpec)
                        .baseUri(BASE_URL)
                        .body(requestBody)
                        .put("/api/users/2"),
                UpdateUserResponseModel.class, Void.class);
    }
}