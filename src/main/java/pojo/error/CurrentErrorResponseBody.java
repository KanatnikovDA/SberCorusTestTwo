package pojo.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class CurrentErrorResponseBody {

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("error")
    private Error error;
}