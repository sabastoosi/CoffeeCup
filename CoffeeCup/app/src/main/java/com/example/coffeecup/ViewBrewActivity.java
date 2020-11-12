package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ViewBrewActivity extends AppCompatActivity {

    TextView name;
    TextView date;
    TextView waterTemp;
    TextView waterMass;
    TextView beanRoastDate;
    TextView beanName;
    TextView beanDarkness;
    TextView coffeeMass;
    TextView grindSize;
    TextView brewer;
    TextView brewTime;
    TextView waterDilutionMass;
    Button editButton;
    Button deleteButton;
    Button evaluateButton;
    ListOfBrews listOfBrews = new ListOfBrews();
    Brew brew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_brew);

        // find views
        name = findViewById(R.id.viewName);
        date = findViewById(R.id.viewDate);
        waterTemp = findViewById(R.id.viewWaterTemp);
        waterMass = findViewById(R.id.viewWaterMass);
        beanRoastDate = findViewById(R.id.viewBeanRoastDate);
        beanName = findViewById(R.id.viewBeanName);
        beanDarkness = findViewById(R.id.viewBeanDarkness);
        coffeeMass = findViewById(R.id.viewCoffeeMass);
        grindSize = findViewById(R.id.viewGrindSize);
        brewer = findViewById(R.id.viewBrewer);
        brewTime = findViewById(R.id.viewBrewTime);
        waterDilutionMass = findViewById(R.id.viewWaterDilutionMass);
        editButton = findViewById(R.id.editButton);
        deleteButton = findViewById(R.id.editButton);
        evaluateButton = findViewById(R.id.evaluateButton);

        // get brew name from row clicked
        Intent intent = getIntent();
        String brewName = intent.getExtras().getString("brewName");
        Log.d("row", "row: " + brewName);

        // find brew with name
        brew = listOfBrews.find(brewName);

        // set text
        name.setText(brew.getmName());
        date.setText(brew.getmDate());
        waterTemp.setText(String.valueOf(brew.getmWaterTemp()));
        waterMass.setText(String.valueOf(brew.getmWaterMass()));
        beanRoastDate.setText(brew.getmBeanRoastDate());
        beanName.setText(brew.getmBeanName());
        beanDarkness.setText(brew.getmBeanDarkness());
        coffeeMass.setText(String.valueOf(brew.getmCoffeeMass()));
        grindSize.setText(String.valueOf(brew.getmGrindSize()));
        brewer.setText(brew.getmBrewer());
        brewTime.setText(String.valueOf(brew.getmBrewTime()));
        waterDilutionMass.setText(String.valueOf(brew.getmWaterDilutionMass()));
    }

    public void editButtonClicked(View view) {

    }

    public void deleteButtonClicked(View view) {

    }

    public void evaluateButtonClicked(View view) {

    }
}