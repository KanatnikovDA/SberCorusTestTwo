package pojo.responce;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class Location{

	@JsonProperty("localtime")
	private String localtime;

	@JsonProperty("utc_offset")
	private String utcOffset;

	@JsonProperty("country")
	private String country;

	@JsonProperty("localtime_epoch")
	private int localtimeEpoch;

	@JsonProperty("name")
	private String name;

	@JsonProperty("timezone_id")
	private String timezoneId;

	@JsonProperty("lon")
	private String lon;

	@JsonProperty("region")
	private String region;

	@JsonProperty("lat")
	private String lat;
}