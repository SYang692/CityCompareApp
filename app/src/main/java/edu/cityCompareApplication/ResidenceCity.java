package edu.cityCompareApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ResidenceCity extends AppCompatActivity {

    private EditText currentCityName, currentCityCost, currentCityWeather,currentCitySalary;
    private City curCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residence_city);

        curCity = DataStorage.getCurCity();

        currentCityName = (EditText) findViewById(R.id.currentCityName);
        currentCityCost = (EditText) findViewById(R.id.currentCityCost);
        currentCityWeather = (EditText) findViewById(R.id.currentCityWeather);
        currentCitySalary = (EditText) findViewById(R.id.currentCitySalary);

        if(curCity != null){
            currentCityName.setText(curCity.getName());
            currentCityCost.setText(curCity.getCostofSaving());
            currentCityWeather.setText(curCity.getWeather());
            currentCitySalary.setText(String.valueOf(curCity.getSalary()));
        }
    }

    public void saveClickHandler(View view) {


        String name = currentCityName.getText().toString();
        String cost = currentCityCost.getText().toString();
        String weather = currentCityWeather.getText().toString();
        double salary = Double.parseDouble(currentCitySalary.getText().toString());

        try {
            City.validCity(name, cost, weather, salary);
            curCity = new City(name, cost, weather, salary);
            DataStorage.setCurCity(curCity);
            Toast.makeText(ResidenceCity.this, "Successfuly", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ResidenceCity.this, MainActivity.class));
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
        startActivity(new Intent(ResidenceCity.this, MainActivity.class));
    }
}