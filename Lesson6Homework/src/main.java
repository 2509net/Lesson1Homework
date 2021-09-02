import HttpUrl.HttpUrl;
import client.OkHttpClient;

import javax.print.attribute.standard.RequestingUserName;
import java.io.IOException;
import java.util.Objects;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import repository.WeatherForecastRepository;

public class Main {


    public static final String HOST = "dataservice.accuweather.com";
    public static final String FORECAST_URL = "forecasts";
    public static final String DAILY_URL = "daily";
public static final String FIVE_DAYS_URL = "5day";
public static final String API_VERSION = "v1";
public static final String CITY_ID = "294021";
public static final String API_KEY = "vBieqe928WkxErQBXbsBWBFtd7MJfNKt";
public static final String LANGUAGE = "ru-RU";
public static final String METRIC = "true";


    public static void main(String[] args) throws IOException {

    OkHttpClient client = new OkHttpClient();

    HttpUrl url = new HttpUrl.Builder()
            .scheme("http")
            .host(HOST)
            .addPathSegment(FORECAST_URL)
            .addPathSegment(API_VERSION)
            .addPathSegment(DAILY_URL)
            .addPathSegment(FIVE_DAYS_URL)
            .addPathSegment(CITY_ID)
            .addQueryParameter(name:"apikey", API_KEY)
              .addQueryParameter(name:"language", LANGUAGE)
             .addQueryParameter(name:"metric", METRIC)
        .build();

    Request request = new Request.Builder()
            .url(url)
            .build();

    Response response = client.newCall(request).execute();
ObjectMapper objectMapper = new ObjectMapper();
WeatherResponse weatherResponse = objectMapper.readValue(response.body().byteStream(), WeatherResponse.class);
        WeatherForecastRepository repository = new WeatherWeatherForecastRepository();

        for (DailyForecast forecast : weatherResponse.getDailyForecasts()) {
    System.out.println(
            "Погода в Москве на %s\n" +
                    "%s, температура от %1f до %.1f %s\n\n",
            forecast.getData(),
            forecast.getDay().getIconPhrase(),
            forecast.getTemperature().getMinimum().getVaue(),
            forecast.getTemperature().getMaximum().getVaue(),
            forecast.getTemperature().getMinimum().getUnit();

            repository.save(
                    CITY_ID, forecast.getDate(),
                    forecast.getDay().getIconPhrase(),
                    forecast.getTemperature().getMaximum().getValue()
            );

}
           repository.read();
    }
}



