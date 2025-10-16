package common.models.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserData {
    private Long id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}