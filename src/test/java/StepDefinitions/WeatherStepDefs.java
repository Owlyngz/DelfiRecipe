package StepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Response;

import java.math.BigDecimal;


import static junit.framework.TestCase.assertEquals;

public class WeatherStepDefs {

    private WeatherRequester weatherRequester = new WeatherRequester();
    private Response response;

    @When("we are getting weather from the server")
    public void get_weather() {
        response = weatherRequester.getWeather();
    }

    @Then("lon is (.*)")
    public void check_lon(BigDecimal lon) {
        assertEquals("Wrong LON", lon, response.getCoord().getLon());
    }

    @Then("lat is (.*)")
    public void check_lat(BigDecimal lat) {
        assertEquals("Wrong LAT", lat, response.getCoord().getLat());
    }

    @Then("weather id is (.*)")
    public void check_weatherId(Integer weatherId) { assertEquals("Wrong WeatherId", weatherId, response.getWeather().get(0).getId()); }

    @Then("main is (.*)")
    public void check_main(String main) { assertEquals("Wrong Main", main, response.getWeather().get(0).getMain()); }   // get (0) (pervij element iz Lista) TOLjko pri List ispoljzovalosj?  [ 1 ]

    @Then("description is (.*)")
    public void check_description(String description) { assertEquals("Wrong Description", description, response.getWeather().get(0).getDescription()); }

    @Then("icon is (.*)")
    public void check_icon(String icon) {
        assertEquals("Wrong Icon", icon, response.getWeather().get(0).getIcon());
    }

    @Then("base is (.*)")
    public void check_base(String base) {
        assertEquals("Wrong Base", base, response.getBase());
    }

    @Then("temp is (.*)")
    public void check_temp(BigDecimal temp) { assertEquals("Wrong Temp", temp, response.getMain().getTemp()); }

    @Then("pressure is (.*)")
    public void check_pressure(int pressure) { assertEquals("Wrong Pressure", pressure, response.getMain().getPressure()); }    // [ 2 ]

    @Then("humidity is (.*)")
    public void check_humidity(int humidity) { assertEquals("Wrong Humidity", humidity, response.getMain().getHumidity()); }    // [ 2 ]

    @Then("temp_min is (.*)")
    public void check_temp_min(BigDecimal temp_min) { assertEquals("Wrong Temp_Min", temp_min, response.getMain().getTemp_min()); }

    @Then("temp_max is (.*)")
    public void check_temp_max(BigDecimal temp_max) { assertEquals("Wrong Temp_Max", temp_max, response.getMain().getTemp_max()); }

    @Then("visibility is (.*)")
    public void check_visibility(String visibility) { assertEquals("Wrong Visibility", visibility, response.getVisibility()); }

    @Then("speed is (.*)")
    public void check_speed(BigDecimal speed) { assertEquals("Wrong Speed", speed, response.getWind().getSpeed()); }

    @Then("deg is (.*)")
    public void check_deg(int deg) { assertEquals("Wrong Deg", deg, response.getWind().getDeg()); }  // [ 2 ] prosit imenno malenjkij int zdesj, Integer kak-to svjazan s List?

    @Then("all is (.*)")
    public void check_all(int all) { assertEquals("Wrong All", all, response.getClouds().getAll()); }

    @Then("dt is (.*)")
    public void check_dt(String dt) { assertEquals("Wrong Dt", dt, response.getDt()); }

    @Then("type is (.*)")
    public void check_type(int type) { assertEquals("Wrong Type", type, response.getSys().getType()); }

    @Then("sysId is (.*)")
    public void check_sysId(int sysId) { assertEquals("Wrong SysId", sysId, response.getSys().getSysId()); }

    @Then("message is (.*)")
    public void check_message(BigDecimal message) { assertEquals("Wrong Message", message, response.getSys().getMessage()); }

    @Then("country is (.*)")
    public void check_country(String country) { assertEquals("Wrong Country", country, response.getSys().getCountry()); }

    @Then("sunrise is (.*)")
    public void check_sunrise(int sunrise) { assertEquals("Wrong Sunrise", sunrise, response.getSys().getSunrise()); }

    @Then("sunset is (.*)")
    public void check_sunset(int sunset)  { assertEquals("Wrong Sunset", sunset, response.getSys().getSunset()); }

    @Then("id is (.*)")
    public void check_id(String id) { assertEquals("Wrong last ID", id, response.getId()); }

    @Then("name is (.*)")
    public void check_name(String name) { assertEquals("Wrong Name", name, response.getName()); }

    @Then("cod is (.*)")
    public void check_cod(String cod) { assertEquals("Wrong Cod", cod, response.getCod()); }

}


// vsje,chto v azhurnih skobkah = objects, v [] skobkah = spisok/List, dlja List ispoljzuem String v papke Response.  Dlja String - (bez kakih libo skobok - klass ne sozdajetsja.
//[ 1 ] ?
//[ 2 ] ?
