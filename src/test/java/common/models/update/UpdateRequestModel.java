package common.models.update;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UpdateRequestModel {
    private String name;
    private String job;
}
