package edu.cityCompareApplication;

import java.util.ArrayList;
import java.util.List;

public class DataStorage {

    private static ArrayList<City> Cities = new ArrayList<>();

    private static City city = null;

    public static City getCurCity() {
        return city;
    }

    public static void setCurCity(City curCity) {
        city = curCity;
    }

    public static ArrayList<City> getCities() {
        return Cities;
    }

    public static void setCities(ArrayList<City> cities) {
        Cities = cities;
    }
}
