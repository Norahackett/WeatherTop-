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
  //public String latestWeather;


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
}







