package edu.cityCompareApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class City {

    private String name;

    private String costofSaving;
    private String weather;

    private double salary;

    public City(String name, String costofSaving, String weather, double salary) {
        this.name = name;
        this.costofSaving = costofSaving;
        this.weather = weather;
        this.salary = salary;
    }

    public static void validCity(String name, String cost, String weather, double salary) throws Exception {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name Error");
        }

        if(cost == null || cost.isEmpty()){
            throw new IllegalArgumentException("Cost of living Error");
        }

        if(weather == null || weather.isEmpty()){
            throw new IllegalArgumentException("Weather Error");
        }

        if(salary == 0 || salary < 0){
            throw new IllegalArgumentException("Salary Error");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCostofSaving() {
        return costofSaving;
    }

    public void setCostofSaving(String costofSaving) {
        this.costofSaving = costofSaving;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}