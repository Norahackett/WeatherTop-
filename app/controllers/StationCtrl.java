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


//import static utils.StationAnalytics.weatherIcon;


public class StationCtrl extends Controller {


    public static void main(String[] args) {
        StationCtrl c = new StationCtrl();
    }

    private static Object station;

    public static void index(Long id) {

        Station station = Station.findById(id);
        Logger.info("Station id = " + id);

        if (station.readings.size() > 0) {
            station.minTempReading = StationAnalytics.getminTemp(station.readings);
            station.maxTempReading = StationAnalytics.getmaxTemp(station.readings);
            station.latestTemperature = StationAnalytics.getlatestTemp(station.readings);
            station.latestTemperatureF = StationAnalytics.getlatestTempF(station.readings);
            station.latestPressure = StationAnalytics.getlatestPressure(station.readings).pressure;
            station.latestwindSpeed = StationAnalytics.getlatestwindSpeed(station.readings);
            station.minPressureReading = StationAnalytics.getminPressure(station.readings);
            station.maxPressureReading = StationAnalytics.getmaxPressure(station.readings);
           // station.latestWeather = weatherIcon(StationAnalytics.getlatestWeather(station.readings));
            station.minWindReading = StationAnalytics.getminWind(station.readings);
            station.maxWindReading = (StationAnalytics.getmaxWind(station.readings));
            station.windChill = Math.round((13.12 + 0.6215 * station.latestTemperature - 11.37 * Math.pow(station.latestwindSpeed, 0.16) + 0.3965 * station.latestTemperature * Math.pow(station.latestwindSpeed, 0.16))*100.00)/100.00;
            station.wind = convertwindText(StationAnalytics.getlatestwindSpeed(station.readings));
            station.windDirection = convertwindDirection(StationAnalytics.getlatestwindDirection(station.readings));
        }
        render("station.html", station);
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
}

