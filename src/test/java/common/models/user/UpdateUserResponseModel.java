package common.models.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateUserResponseModel {
    private String name;
    private String job;
    private String updatedAt;
}
