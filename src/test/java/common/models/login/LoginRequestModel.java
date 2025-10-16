package common.models.login;

import lombok.Data;

@Data
public class LoginRequestModel {
    String email;
    String password;
}
