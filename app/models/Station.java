package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


import play.db.jpa.Model;

@Entity

public class Station extends Model {


  public String name;
  public double latitude;
  public double longitude;

  @OneToMany(cascade = CascadeType.ALL)


  public List<Reading> readings = new ArrayList<Reading>();
  public double minTempReading;
  public double maxTempReading;
  public double latestTemperature;
  public double latestTemperatureF;
  public int latestPressure;
  public double minPressureReading;
  public double maxPressureReading;
  public double minWindReading;
  public double maxWindReading;
  public double latestwindSpeed;
  public double windChill;
  public double wind;
  public String windDirection;
  public String latestWeather;
  public String latestWeatherCode;

  public Station(String name, double latitude, double longitude) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public double getWindChill() {
    return windChill;
  }

  public void setWindChill(double windChill) {
    this.windChill = windChill;
  }

  public String getName() {
    return name;
  }


  public static double convertwindText(double windSpeed) {
    if (windSpeed <= 1) {
      return 0;
    } else if (windSpeed > 1 && windSpeed <= 5) {
      return 1;
    } else if (windSpeed >= 6 && windSpeed <= 11) {
      return 2;
    } else if (windSpeed >= 12 && windSpeed <= 19) {
      return 3;
    } else if (windSpeed >= 20 && windSpeed <= 28) {
      return 3;
    } else if (windSpeed >= 29 && windSpeed <= 38) {
      return 5;
    } else if (windSpeed >= 39 && windSpeed <= 49) {
      return 6;
    } else if (windSpeed >= 50 && windSpeed <= 61) {
      return 7;
    } else if (windSpeed >= 62 && windSpeed <= 74) {
      return 8;
    } else if (windSpeed >= 75 && windSpeed <= 88) {
      return 9;
    } else if (windSpeed >= 89 && windSpeed <= 102) {
      return 10;
    } else if (windSpeed >= 103 && windSpeed <= 117) {
      return 11;
    } else {
      return 0;
    }
  }

  public static String convertwindDirection(double windDirection) {
    if ((windDirection > 348.75 && windDirection <= 360) || (windDirection >= 0 && windDirection <= 11.25)) {
      return "North";
    } else if (windDirection >= 11.25 && windDirection <= 33.75) {
      return "North North East";
    } else if (windDirection >= 33.75 && windDirection <= 56.25) {
      return "North East";
    } else if (windDirection >= 56.25 && windDirection <= 78.75) {
      return "East North East";
    } else if (windDirection >= 78.75 && windDirection <= 101.25) {
      return "East";
    } else if (windDirection >= 101.25 && windDirection <= 123.75) {
      return "East South East";
    } else if (windDirection >= 123.75 && windDirection <= 146.25) {
      return "South East";
    } else if (windDirection >= 146.25 && windDirection <= 168.75) {
      return "South South East";
    } else if (windDirection >= 168.75 && windDirection <= 191.25) {
      return "South";
    } else if (windDirection >= 191.25 && windDirection <= 213.75) {
      return "South South West";
    } else if (windDirection >= 213.75 && windDirection <= 236.25) {
      return "South West";
    } else if (windDirection >= 236.25 && windDirection <= 258.75) {
      return "West South West";
    } else if (windDirection >= 258.75 && windDirection <= 281.25) {
      return "West";
    } else if (windDirection >= 281.25 && windDirection <= 303.75) {
      return "West North West";
    } else if (windDirection >= 303.75 && windDirection <= 326.25) {
      return "North West";
    } else if (windDirection >= 326.25 && windDirection <= 348.75) {
      return "North North West";
    } else {
      return "N/A";
    }
  }
}



