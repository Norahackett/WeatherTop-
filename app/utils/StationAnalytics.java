package utils;

import models.Reading;

import java.util.HashMap;
import java.util.List;

public class StationAnalytics {

  private static int WeatherIcon;

  public static double getminTemp(List<Reading> readings) {
    Reading minTempReading = null;
    if (readings.size() > 0) {
      minTempReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.temperature < minTempReading.temperature) {
          minTempReading = reading;
          System.out.println(minTempReading);
        }
      }
    }
    return minTempReading.temperature;
  }

  public static double getmaxTemp(List<Reading> readings) {
    Reading maxTempReading = null;
    if (readings.size() > 0) {
      maxTempReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.temperature > maxTempReading.temperature) {
          maxTempReading = reading;
        }
      }
    }
    return maxTempReading.temperature;
  }

  public static Double getlatestTemp(List<Reading> readings) {
    Double latestTemp = null;

    if (readings.size() > 0) {
      latestTemp = readings.get(readings.size() - 1).temperature;
    }
    return latestTemp;
  }

  public static double getlatestTempF(List<Reading> readings) {
    Double latestTempF = null;

    if (readings.size() > 0) {
      latestTempF = ((readings.get(readings.size() - 1).temperature * 9 / 5) + 32);
    }
    return latestTempF;
  }

  public static double getlatestwindSpeed(List<Reading> readings) {
    Double latestwindSpeed = null;

    if (readings.size() > 0) {
      latestwindSpeed = readings.get(readings.size() - 1).windSpeed;
    }
    return latestwindSpeed;
  }

  public static double getlatestwindDirection(List<Reading> readings) {
    Double latestwindDirection = null;

    if (readings.size() > 0) {
      latestwindDirection = readings.get(readings.size() - 1).windDirection;
    }
    return latestwindDirection;
  }

  public static Reading getlatestPressure(List<Reading> readings) {
    Reading latestPressure = null;

    if (readings.size() > 0) {
      latestPressure = readings.get(readings.size() - 1);
    }
    return latestPressure;
  }

  public static double getminPressure(List<Reading> readings) {
    Reading minPressureReading = null;
    if (readings.size() > 0) {
      minPressureReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.pressure < minPressureReading.pressure) {
          minPressureReading = reading;
        }
      }
    }
    return minPressureReading.pressure;
  }

  public static double getmaxPressure(List<Reading> readings) {
    Reading maxPressureReading = null;
    if (readings.size() > 0) {
      maxPressureReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.pressure > maxPressureReading.pressure) {
          maxPressureReading = reading;
        }
      }
    }
    return maxPressureReading.pressure;
  }

  public static int getlatestWeather(List<Reading> readings) {
    Integer latestWeather = null;

    if (readings.size() > 0) {
      for (Reading reading : readings)
        latestWeather = readings.get(readings.size() - 1).code;
    }
    return latestWeather;
  }

  public static Double latestwindSpeed(List<Reading> readings) {
    double latestwindSpeed = 0;

    if (readings.size() > 0) {
      for (Reading reading : readings)
        latestwindSpeed = readings.get(readings.size() - 1).windSpeed;
    }
    return latestwindSpeed;
  }

  public static double getminWind(List<Reading> readings) {
    Reading minWindReading = null;
    if (readings.size() > 0) {
      minWindReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.windSpeed < minWindReading.windSpeed) {
          minWindReading = reading;
        }
      }
    }
    return minWindReading.windSpeed;
  }

  public static double getmaxWind(List<Reading> readings) {
    Reading maxWindReading = null;
    if (readings.size() > 0) {
      maxWindReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.windSpeed > maxWindReading.windSpeed) {
          maxWindReading = reading;
        }
      }
    }
    return maxWindReading.windSpeed;
  }

  public static String weatherIcon(int code) {
    HashMap<Integer, String> weatherIcons;
    weatherIcons = new HashMap<Integer, String>();
    weatherIcons.put(100, "Clear");
    weatherIcons.put(200, "Partial Clouds");
    weatherIcons.put(300, "Cloudy ");
    weatherIcons.put(400, "Light Showers");
    weatherIcons.put(500, "Heavy Showers");
    weatherIcons.put(500, "Heavy Rain ");
    weatherIcons.put(600, "Rain");
    weatherIcons.put(700, "snow");
    weatherIcons.put(800, "Thunder");
    return weatherIcons.get(code);
  }

}