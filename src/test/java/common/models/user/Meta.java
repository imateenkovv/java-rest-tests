package common.models.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Meta {
    private String powered_by;
    private String upgrade_url;
    private String docs_url;
    private String template_gallery;
    private String message;
    private List<String> features;
    private String upgrade_cta;
}