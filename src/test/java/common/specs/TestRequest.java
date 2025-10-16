package common.specs;

import io.restassured.builder.ResponseBuilder;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestRequest {
    public RequestSpecification spec;

    public TestRequest(FilterableRequestSpecification requestSpec) {
        this.spec = given()
                .header("x-api-key", "reqres-free-v1")
                .spec(requestSpec);
//                .log().all();
        //todo - надо это логирование вообще тут или нет
    }

    public TestRequest pathParameter(String nameParam, Object valueParam) {
        this.spec.pathParam(nameParam, valueParam);
        return this;
    }

    public TestRequest queryParameter(String nameParameter, Object valueParameter) {
        if (valueParameter != null && nameParameter != null) {
            spec.queryParam(nameParameter, valueParameter);
        }
        return this;
    }

    public TestRequest queryParameter(Map<String, String> queryParameter) {
        spec.queryParams(queryParameter);
        return this;
    }

    public TestRequest body(Object body) {
        spec.body(body);
        return this;
    }

    public TestRequest baseUri(String uri) {
        spec.baseUri(uri);
        return this;
    }

    public TestRequest headers(String nameHeader, Object valueHeader) {
        if (valueHeader != null && nameHeader != null) {
            spec.headers(nameHeader, valueHeader);
        }
        return this;
    }

    public TestRequest cookies(Map<String, String> cookies) {
        spec.cookies(cookies);
        return this;
    }

    public Response post(String postEndpoint) {
        return executingRequest(spec.when().log().all().post(postEndpoint));
    }

    public Response get(String getEndpoint) {
        return executingRequest(spec.when().log().all().get(getEndpoint));
    }

    public Response put(String putEndpoint) {
        return executingRequest(spec.when().log().all().put(putEndpoint));
    }

    public Response delete(String deleteEndpoint) {
        return executingRequest(spec.when().log().all().delete(deleteEndpoint));
    }

    public Response patch(String patchEndpoint) {
        return executingRequest(spec.when().log().all().patch(patchEndpoint));
    }

    public Response options(String optionsEndpoint) {
        return executingRequest(spec.when().log().all().options(optionsEndpoint));
    }

    public Response head(String headEndpoint) {
        return executingRequest(spec.when().log().all().head(headEndpoint));
    }

    private Response executingRequest(Response response) {
        String limitBody = StringUtils.truncate(response.getBody().asString(), 1000);
        Response response2 = new ResponseBuilder().clone(response).setBody(limitBody).build();
        response2.then().log().all();
        return response.then().extract().response();
    }
}
