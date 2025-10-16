package common.api;

import common.specs.ApiResponses;
import common.specs.TestRequest;
import io.restassured.specification.FilterableRequestSpecification;

import static common.endpoints.ConstantEndpoints.BASE_URL;
import static common.endpoints.ConstantEndpoints.LIST_USERS;

public class ApiAllRequests {

    public static ApiResponses<Void, Void> getListUsers(FilterableRequestSpecification requestSpec) {
        return new ApiResponses<>(
                new TestRequest(requestSpec)
                        .baseUri(BASE_URL)
                        .get(LIST_USERS),
                Void.class, Void.class);
    }
}
