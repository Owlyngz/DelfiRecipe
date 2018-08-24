package model;

import java.math.BigDecimal;

public class Sys {

    private int type;
    private int sysId;
    private BigDecimal message;
    private String country;
    private int sunrise;
    private int sunset;

    public int getType() { return type; }

    public void setType(int type) { this.type = type; }

    public int getSysId() { return sysId; }

    public void setSysId(int sysId) { this.sysId = sysId; }

    public BigDecimal getMessage() { return message; }

    public void setMessage(BigDecimal message) { this.message = message; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public int getSunrise() { return sunrise; }

    public void setSunrise(int sunrise) { this.sunrise = sunrise; }

    public int getSunset() { return sunset; }

    public void setSunset(int sunset) { this.sunset = sunset; }
}
