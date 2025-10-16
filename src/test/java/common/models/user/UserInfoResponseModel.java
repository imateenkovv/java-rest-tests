package common.models.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoResponseModel {

    private UserData data;
    private Support support;
    @JsonProperty("_meta")
    private Meta meta;

    @lombok.Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class UserData {
        private Long id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;
    }

    @lombok.Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Support {
        private String url;
        private String text;
    }

    @lombok.Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Meta {
        private String powered_by;
        private String upgrade_url;
        private String docs_url;
        private String template_gallery;
        private String message;
        private List<String> features;
        private String upgrade_cta;
    }
}