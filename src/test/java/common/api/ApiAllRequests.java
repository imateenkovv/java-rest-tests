package common.api;

import common.models.login.LoginErrorResponseModel;
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
import io.restassured.specification.FilterableRequestSpecification;

import static common.endpoints.ConstantEndpoints.BASE_URL;

public class ApiAllRequests {

    public static ApiResponses<ListUsers, Void> getListUsersRequest(FilterableRequestSpecification requestSpec) {
        return new ApiResponses<>(
                new TestRequest(requestSpec)
                        .baseUri(BASE_URL)
                        .get("/api/users?page=2"),
                ListUsers.class, Void.class);
    }

    public static ApiResponses<LoginResponseModel, LoginErrorResponseModel> loginSuccessRequest(LoginRequestModel requestBody,
                                                                                                FilterableRequestSpecification requestSpec) {
        return new ApiResponses<>(
                new TestRequest(requestSpec)
                        .baseUri(BASE_URL)
                        .body(requestBody)
                        .post("/api/login"),
                LoginResponseModel.class, LoginErrorResponseModel.class);
    }

    public static ApiResponses<RegisterResponseModel, Void> registerUserRequest(RegisterRequestModel requestBody,
                                                                                FilterableRequestSpecification requestSpec) {
        return new ApiResponses<>(
                new TestRequest(requestSpec)
                        .baseUri(BASE_URL)
                        .body(requestBody)
                        .post("/api/register"),
                RegisterResponseModel.class, Void.class);

    }

    public static ApiResponses<UserInfoResponseModel, Void> getSingleUserRequest(FilterableRequestSpecification requestSpec) {
        return new ApiResponses<>(
                new TestRequest(requestSpec)
                        .baseUri(BASE_URL)
                        .get("/api/users/2"),
                UserInfoResponseModel.class, Void.class);
    }

    public static ApiResponses<UpdateUserResponseModel, Void> putSingleUserRequest(UpdateRequestModel requestBody,
                                                                                   FilterableRequestSpecification requestSpec) {
        return new ApiResponses<>(
                new TestRequest(requestSpec)
                        .baseUri(BASE_URL)
                        .body(requestBody)
                        .put("/api/users/2"),
                UpdateUserResponseModel.class, Void.class);
    }

}