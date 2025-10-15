package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


import static common.endpoints.ConstantEndpoints.BASE_URL;
import static common.endpoints.ConstantEndpoints.LOGIN_SUCCESS;
import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

/**
 * @author mateenkov
 */

public class LoginSpec {
    public static RequestSpecification loginRequestSpec = with()
            .filter(withCustomTemplates())
            .log().method()
            .log().uri()
            .log().body()
            .contentType(JSON)
            .baseUri(BASE_URL)
            .basePath(LOGIN_SUCCESS);

    public static ResponseSpecification loginResponseSpec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectStatusCode(200)
            .build();

    public static ResponseSpecification loginUnSuccessResponseSpec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectStatusCode(400)
            .build();
}
