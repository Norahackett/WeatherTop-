package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

import java.util.Date;

@Entity
public class Reading extends Model {
  public Date date;
  public int code;
  public double temperature;
  public double windSpeed;
  public int pressure;
  public double windDirection;


  public Reading(int code, double temperature, double windSpeed, int pressure, double windDirection, Date date) {
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.pressure = pressure;
    this.windDirection = windDirection;
    this.date = date;
  }
  //-------
  //getters
  //-----
  public int getCode() {
    return code;
  }

  public double getTemperature() {
    return temperature;
  }

  public double getWindSpeed() {
    return windSpeed;
  }

  public int getPressure() {
    return pressure;
  }

  public double getWindDirection() {
    return windDirection;
  }

  public Date getDate() {
    return date;
  }
  //-------
  //setters
  //-------
  public void setCode(int code) {
    this.code = code;
  }


  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }

  public void setWindSpeed(double windSpeed) {
    this.windSpeed = windSpeed;
  }

  public void setPressure(int pressure) {
    this.pressure = pressure;
  }


  public void setwindDirection(double windDirection) {
    this.windDirection = windDirection;
  }
}



