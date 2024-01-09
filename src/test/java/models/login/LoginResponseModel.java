package models.login;

import lombok.Data;

/**
 * @author mateenkov
 */
@Data
public class LoginResponseModel {
    String token;
    String error;
}
