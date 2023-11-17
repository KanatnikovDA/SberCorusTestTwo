package pojo.responce;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Current{

	@JsonProperty("weather_descriptions")
	private List<String> weatherDescriptions;

	@JsonProperty("observation_time")
	private String observationTime;

	@JsonProperty("wind_degree")
	private int windDegree;

	@JsonProperty("visibility")
	private int visibility;

	@JsonProperty("weather_icons")
	private List<String> weatherIcons;

	@JsonProperty("feelslike")
	private int feelslike;

	@JsonProperty("is_day")
	private String isDay;

	@JsonProperty("wind_dir")
	private String windDir;

	@JsonProperty("pressure")
	private int pressure;

	@JsonProperty("cloudcover")
	private int cloudcover;

	@JsonProperty("precip")
	private int precip;

	@JsonProperty("uv_index")
	private int uvIndex;

	@JsonProperty("temperature")
	private int temperature;

	@JsonProperty("humidity")
	private int humidity;

	@JsonProperty("wind_speed")
	private int windSpeed;

	@JsonProperty("weather_code")
	private int weatherCode;
}