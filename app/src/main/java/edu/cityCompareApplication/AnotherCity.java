package edu.cityCompareApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AnotherCity extends AppCompatActivity {

    private EditText currentCityName, currentCityCost, currentCityWeather,currentCitySalary;
    private City newCity;

    private ArrayList<City> Cities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_city);

        Cities = (ArrayList<City>) DataStorage.getCities().clone();

        currentCityName = (EditText) findViewById(R.id.currentCityName);
        currentCityCost = (EditText) findViewById(R.id.currentCityCost);
        currentCityWeather = (EditText) findViewById(R.id.currentCityWeather);
        currentCitySalary = (EditText) findViewById(R.id.currentCitySalary);


    }

    public void saveCityClcikHandler(View view) {

        String name = currentCityName.getText().toString();
        String cost = currentCityCost.getText().toString();
        String weather = currentCityWeather.getText().toString();
        double salary = Double.parseDouble(currentCitySalary.getText().toString());

        try {
            City.validCity(name, cost, weather, salary);
            newCity = new City(name, cost, weather, salary);
            Cities.add(newCity);
            DataStorage.setCities(Cities);
            Toast.makeText(AnotherCity.this, "Successfully saved city to list", Toast.LENGTH_SHORT).show();
            reset();
        }
        catch (Exception e){
            if(e.getMessage().contains("Name")){
                currentCityName.setError(e.getMessage());
            }
            if(e.getMessage().contains("Cost")){
                currentCityCost.setError(e.getMessage());
            }
            if(e.getMessage().contains("Weather")){
                currentCityWeather.setError(e.getMessage());
            }
            if(e.getMessage().contains("Salary")){
                currentCitySalary.setError(e.getMessage());
            }
        }
    }

    public void cancelClickHandler(View view) {
        startActivity(new Intent(AnotherCity.this, MainActivity.class));
    }

    public void reset(){

        currentCityName.setText("");
        currentCityCost.setText("");
        currentCitySalary.setText("");
        currentCityWeather.setText("");

    }

    public void addAnotherCityClickHandle(View view) {
        reset();
//        newCity = null;

    }
}