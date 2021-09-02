import java.util.List;

public class WeatherResponse {

    @JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
        @JsonProperty("DailyForecasts")
        private List<DailyForecast> dailyForecasts;

        public WeatherResponse() {

        }
public WeatherResponse(List<DailyForecast> dailyForecasts) { this.dailyForecasts = dailyForecasts};
        public List<DailyForecast> getDailyForecasts() { return dailyForecasts};
        public void setDailyForecasts(List<DailyForecast> dailyForecasts) {this.dailyForecasts = dailyForecasts};


        @Override
        public String toString() {
            return "WeatherResponse{" +
                    "dailyForecasts" + dailyForecasts +'}';


        }
    }


}
