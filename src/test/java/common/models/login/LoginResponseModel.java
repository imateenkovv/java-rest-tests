package common.models.login;

import lombok.Data;

@Data
public class LoginResponseModel {
    String token;
    String error;
}
