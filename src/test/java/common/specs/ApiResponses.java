package common.specs;

import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.hamcrest.core.Is.is;

public class ApiResponses<SUCCESS_DTO, ERROR_DTO> {

    private final Response response;
    private SUCCESS_DTO successBody;
    private ERROR_DTO errorBody;
    private Integer statusCode;

    public ApiResponses(SUCCESS_DTO successBody, ERROR_DTO errorBody, Integer statusCode, Response response) {
        this.successBody = successBody;
        this.errorBody = errorBody;
        this.statusCode = statusCode;
        this.response = response;
    }

    public ApiResponses(Response testResponse, Class<SUCCESS_DTO> successTypeResponse, Class<ERROR_DTO> errorTypeResponse) {
        response = testResponse;
        statusCode = response.getStatusCode();

        try {
            if (isStatusCodeSuccess()) {
                successBody = parseSuccessResponse(testResponse, successTypeResponse);
            } else errorBody = parseErrorResponse(testResponse, errorTypeResponse);
        } catch (Exception e) {
            processingExceptions(e);
        }
    }

    private SUCCESS_DTO parseSuccessResponse(Response testResponse, Class<SUCCESS_DTO> successTypeResponse) {
        if (successTypeResponse.getName().equals("java.lang.Void") || testResponse.getStatusCode() == 204) {
            return null;
        }
        if (testResponse.getContentType().equals("image/png")) {
            return (SUCCESS_DTO) testResponse.getBody().asString();
        }
        if (testResponse.getContentType().equals("text/html;charset=UTF-8")) {
            return (SUCCESS_DTO) testResponse.getBody().asString();
        }
        return testResponse.getBody().as(successTypeResponse);
    }

    private ERROR_DTO parseErrorResponse(Response testResponse, Class<ERROR_DTO> errorTypeResponse) {
        if (testResponse.getStatusCode() == 401 && testResponse.getContentType().equals("text/html;charset=iso-8859-1")) {
            return null;
        }
        return testResponse.getBody().as(errorTypeResponse);
    }

    private void processingExceptions(Exception e) {
        String message = e.getMessage();
        if (message.contains("Unrecognized field")) {
            String errorMessage = message.substring(19).substring(0, message.indexOf("),"));
            throw new RuntimeException("Ошибка при десериализации. В ответе есть поле, отсутствующие в модели." +
                    "Поле : " + errorMessage.substring(0, errorMessage.length() - 18) + ". Остальные поля проигнорированы.");
        } else if (message.contains("START_OBJECT")) {
            String errorMessage = message.substring(34);
            throw new RuntimeException("Ошибка при десериализаци. В ответе содержится объект, а ожидали " +
                    " массив объектов. Ожидаемоя модель: " + errorMessage.substring(0, errorMessage.indexOf(";")) + "[]");
        } else if (message.contains("START_ARRAY")) {
            String errorMessage = message.substring(32);
            throw new RuntimeException("Ошибка при десериализации. В ответе содержится массив объектов, " +
                    " а ожидали объект. Ожидаемая модель: " + errorMessage.substring(0, errorMessage.indexOf("`")));
        } else {
            throw new RuntimeException("Ошибка при десериализации в объект: " + message);
        }
    }

    public ApiResponses<SUCCESS_DTO, ERROR_DTO> checkStatusCode(int expectedStatusCode) {
        assertThat("HTTP reason status code", response.getStatusCode(), is(expectedStatusCode));
        return this;
    }

    public Boolean isStatusCodeSuccess() {
        return statusCode >= 200 && statusCode < 400;
    }

    public SUCCESS_DTO successBody() {
        assertThat("HTTP response status code", statusCode,
                is(both(greaterThanOrEqualTo(200)).and(lessThanOrEqualTo(399))));
        return successBody;
    }

    public ERROR_DTO errorBody() {
        assertThat("HTTP response status code", statusCode,
                is(both(greaterThanOrEqualTo(400)).and(lessThanOrEqualTo(599))));
        return errorBody;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}