package common.specs;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.FilterableRequestSpecification;

public interface Spec {
    RequestSpecBuilder specBuild = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setRelaxedHTTPSValidation();

    FilterableRequestSpecification specRequest = (FilterableRequestSpecification)
            specBuild.build().filter(new AllureRestAssured());
}
