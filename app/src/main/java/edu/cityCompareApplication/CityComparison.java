package edu.cityCompareApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class CityComparison extends AppCompatActivity {

    private ArrayList<City> Cities = new ArrayList<>();
    private ArrayList<CheckBox> checkBoxList = new ArrayList<>();
    private ArrayList<City> cmpCities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_comparison);

        Cities = (ArrayList<City>) DataStorage.getCities().clone();

//        for (int j=0; j<10; j++)
//        {
//            Cities.add(new City("Shanghai"+ Integer.toString(j),"AWS"+Integer.toString(j),"LA"+Integer.toString(j),j));
//        }
        init();


    }

    public void init() {

        TableLayout ll = (TableLayout) findViewById(R.id.mainTable);

        TableRow.LayoutParams rowHeadParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT,1f);
        TableRow.LayoutParams rowDataParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 50,1f);
  //        tableParams.setMargins(0,15,0,15);

        TableRow tbrow0 = new TableRow(this);
        tbrow0.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.MATCH_PARENT));

        TextView tv = new TextView(this);
        tv.setText(" ID ");
        tbrow0.addView(tv);

        TextView tv0 = new TextView(this);
        tv0.setText(" Name ");
        tbrow0.addView(tv0);

        TextView tv1 = new TextView(this);
        tv1.setText(" Cost of Saving ");
        tbrow0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText(" Weather ");

        tbrow0.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText(" Salary ");
        tbrow0.addView(tv3);

        TextView tv4 = new TextView(this);
        tv3.setText(" Check ");
        tbrow0.addView(tv4);

        ll.addView(tbrow0);


        for (int i = 0; i < Cities.size(); i++) {
            TableRow tbrow = new TableRow(this);

            TextView t0v = new TextView(this);
            t0v.setText(Integer.toString(i));
            t0v.setGravity(Gravity.CENTER);
            tbrow.addView(t0v);

            TextView t1v = new TextView(this);
            t1v.setText(Cities.get(i).getName());
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);

            TextView t2v = new TextView(this);
            t2v.setText(Cities.get(i).getCostofSaving());
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);

            TextView t3v = new TextView(this);
            t3v.setText(Cities.get(i).getWeather());
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);

            TextView t4v = new TextView(this);
            t4v.setText(Double.toString(Cities.get(i).getSalary()));
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);

            CheckBox checkBox = new CheckBox(this);
            tbrow.addView(checkBox);

            checkBoxList.add(checkBox);

            ll.addView(tbrow);
        }

    }


    public void compareCityClcikHandler(View view) {

        for (int i = 0; i < checkBoxList.size(); i++) {
            CheckBox cb = checkBoxList.get(i);
            if (cb.isChecked()) {
                cmpCities.add(Cities.get(i));
            }
        }
        DataStorage.setCityCmp(cmpCities.get(0), cmpCities.get(1));
        startActivity(new Intent(CityComparison.this, ComparisonResult.class));
    }
}