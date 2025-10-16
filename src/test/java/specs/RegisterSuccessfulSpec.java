package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static common.endpoints.ConstantEndpoints.BASE_URL;
import static common.endpoints.ConstantEndpoints.REGISTER_SUCCESS;
import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class RegisterSuccessfulSpec {
    public static RequestSpecification registerSuccessfulRequestSpec = with()
            .filter(withCustomTemplates())
            .log().method()
            .log().uri()
            .log().body()
            .contentType(JSON)
            .baseUri(BASE_URL)
            .basePath(REGISTER_SUCCESS);

    public static ResponseSpecification registerSuccessfulResponseSpec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectStatusCode(200)
            .build();

}
