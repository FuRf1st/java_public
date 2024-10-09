package com;

public class WeatherComputer {
    // Метод для принятия решения
    public static boolean canPlayBadminton(int dayofweek, String temperature, String precipitation, String wind, String humidity) {
        // Можно играть только по воскресеньям (7 - это Воскресенье)
        if (dayofweek != 7) {
            return false;
        }

        // Проверяем погодные условия
        boolean isGoodTemperature = temperature.equals("жарко") || temperature.equals("тепло");
        boolean isGoodPrecipitation = precipitation.equals("ясно") || precipitation.equals("облачно");
        boolean isNoWind = wind.equals("нет");
        boolean isLowHumidity = humidity.equals("низкая");

        // Если все условия соблюдены, то можно играть
        return isGoodTemperature && isGoodPrecipitation && isNoWind && isLowHumidity;
    }
}