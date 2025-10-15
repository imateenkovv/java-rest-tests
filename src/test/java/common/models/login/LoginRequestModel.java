package common.models.login;

import lombok.Data;

/**
 * @author mateenkov
 */
@Data
public class LoginRequestModel {
    String email;
    String password;
}
