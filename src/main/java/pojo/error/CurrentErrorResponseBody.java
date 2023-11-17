package pojo.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrentErrorResponseBody {

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("error")
    private Error error;
}