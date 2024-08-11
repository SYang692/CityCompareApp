package edu.cityCompareApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ComparisonResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison_result);

        ArrayList<City> cmpCities = DataStorage.getCmpCities();

        TextView tvCity1Name = (TextView) findViewById(R.id.textCity1Name);
        tvCity1Name.setText(cmpCities.get(0).getName());

        TextView tvCity1Cost = (TextView) findViewById(R.id.textCity1Cost);
        tvCity1Cost.setText(cmpCities.get(0).getCostofSaving());

        TextView tvCity1Weat = (TextView) findViewById(R.id.textCity1Wea);
        tvCity1Weat.setText(cmpCities.get(0).getWeather());

        TextView tvCity1Sal = (TextView) findViewById(R.id.textCity1Sal);
        tvCity1Sal.setText(String.valueOf(cmpCities.get(0).getSalary()));



        TextView tvCity2Name = (TextView) findViewById(R.id.textCity2Name);
        tvCity2Name.setText(cmpCities.get(1).getName());

        TextView tvCity2Cost = (TextView) findViewById(R.id.textCity2Cost);
        tvCity2Cost.setText(cmpCities.get(1).getCostofSaving());

        TextView tvCity2Weat = (TextView) findViewById(R.id.textCity2Wea);
        tvCity2Weat.setText(cmpCities.get(1).getWeather());

        TextView tvCity2Sal = (TextView) findViewById(R.id.textCity2Sal);
        tvCity2Sal.setText(String.valueOf(cmpCities.get(1).getSalary()));

    }

    public void cancelClickHandler(View view) {
        startActivity(new Intent(ComparisonResult.this, MainActivity.class));
    }
}