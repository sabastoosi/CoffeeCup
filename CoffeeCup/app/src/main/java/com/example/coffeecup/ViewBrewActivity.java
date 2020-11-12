package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        
    }

    public void editButtonClicked(View view) {

    }

    public void deleteButtonClicked(View view) {

    }

    public void evaluateButtonClicked(View view) {

    }
}