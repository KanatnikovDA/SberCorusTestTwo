package pojo.responce;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class CurrentResponseBody {

	@JsonProperty("request")
	private Request request;

	@JsonProperty("current")
	private Current current;

	@JsonProperty("location")
	private Location location;
}