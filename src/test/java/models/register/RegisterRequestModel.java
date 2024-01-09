package models.register;

import lombok.Data;

/**
 * @author mateenkov
 */
@Data
public class RegisterRequestModel {
    String email;
    String password;
}
