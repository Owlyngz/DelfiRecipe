package StepDefinitions;

import model.Response;
import org.springframework.web.client.RestTemplate;

public class WeatherRequester {

    private final String URL = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";

    public Response getWeather() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(URL, Response.class).getBody();
    }

}


