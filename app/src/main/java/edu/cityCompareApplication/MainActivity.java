package edu.cityCompareApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void cityofResidenceClickHandler(View view) {
        startActivity(new Intent(MainActivity.this, ResidenceCity.class));
    }

    public void enterAnotherCityClickHandler(View view) {
        startActivity(new Intent(MainActivity.this, AnotherCity.class));
    }

    public void cityComparisonClickHandler(View view) {
        startActivity(new Intent(MainActivity.this, CityComparison.class));
    }

    public void weightingFactorClickHandler(View view) {
        startActivity(new Intent(MainActivity.this, SetWeights.class));
    }
}