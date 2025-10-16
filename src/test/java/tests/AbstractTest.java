package tests;

import io.restassured.specification.RequestSpecification;

import static common.endpoints.ConstantEndpoints.BASE_URL;
import static common.endpoints.ConstantEndpoints.FREE_API_KEY;
import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class AbstractTest {

    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .log().method()
            .log().uri()
            .log().headers()
            .log().parameters()
            .log().cookies()
            .log().body()
            .baseUri(BASE_URL)
            .contentType(JSON)
            .header("x-api-key", FREE_API_KEY);
}
