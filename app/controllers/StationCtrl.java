package controllers;
import java.util.Scanner;

import models.Reading;
import models.Station;
import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;

import java.security.Timestamp;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


import static models.Station.convertwindDirection;
import static models.Station.convertwindText;
import static utils.StationAnalytics.weatherCode;
import static utils.StationAnalytics.weatherIcons;

public class StationCtrl extends Controller {

  //  public static void main(String[] args) {
      //''  StationCtrl c = new StationCtrl();
  //''  }

    private static Object station;

    public static void index(Long id) {

        Station station = Station.findById(id);
        Logger.info("Station id = " + id);

        if (station.readings.size() > 0) {
            station.minTempReading = StationAnalytics.getminTemp(station.readings);
            station.maxTempReading = StationAnalytics.getmaxTemp(station.readings);
            station.latestTemperature =(StationAnalytics.getlatestTemp(station.readings);
            station.latestTemperatureF = (StationAnalytics.getlatestTempF(station.readings);
            station.latestPressure = StationAnalytics.getlatestPressure(station.readings);
            station.latestwindSpeed = StationAnalytics.getlatestwindSpeed(station.readings);
            station.minPressureReading = StationAnalytics.getminPressure(station.readings);
            station.maxPressureReading = StationAnalytics.getmaxPressure(station.readings);
            station.latestWeather = weatherIcons(StationAnalytics.getlatestWeather(station.readings));
            station.latestWeatherCode= weatherCode(StationAnalytics.getlatestWeather(station.readings));
            station.minWindReading = StationAnalytics.getminWind(station.readings);
            station.maxWindReading = (StationAnalytics.getmaxWind(station.readings));
            station.windChill = Math.round((13.12 + 0.6215 * station.latestTemperature - 11.37 * Math.pow(station.latestwindSpeed, 0.16) + 0.3965 * station.latestTemperature * Math.pow(station.latestwindSpeed, 0.16))*100.00)/100.00;
            station.wind = convertwindText(StationAnalytics.getlatestwindSpeed(station.readings));
            station.windDirection = convertwindDirection(StationAnalytics.getlatestwindDirection(station.readings));
        }
        render("station.html", station);
    }

    public static void addReading(Long id, int code, double temperature, double windSpeed, int pressure, int windDirection) {
        Date date = new Date (System.currentTimeMillis());
        Reading reading = new Reading(code, temperature, windSpeed, pressure, windDirection,date);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect("/stations/" + id);
    }

    public static void deletereading(Long id, Long readingid) {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        station.readings.remove(reading);
        station.save();
        reading.delete();
        Logger.info("Removing" + reading.code);

        redirect("/stations/" + id);
    }

    public static void addlatestReading(Long id, int code, double temperature, double windSpeed, int pressure, int windDirection) {
        Date date = new Date(System.currentTimeMillis());
        Reading reading = new Reading(code, temperature, windSpeed, pressure, windDirection, date);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        reading.delete();
        redirect("/stations/" + id);

    }

    private static double toTwoDecimalPlaces(double num){
        return (int) (num *100 ) /100.0;
    }

}


