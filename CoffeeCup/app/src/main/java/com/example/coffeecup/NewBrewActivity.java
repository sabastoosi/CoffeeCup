package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewBrewActivity extends AppCompatActivity {

    EditText name;
    EditText date;
    EditText waterTemp;
    EditText waterMass;
    EditText beanRoastDate;
    EditText beanName;
    EditText beanDarkness;
    EditText coffeeMass;
    EditText grindSize;
    EditText brewer;
    EditText brewTime;
    EditText waterDilutionMass;
    Button createButton;
    ListOfBrews listOfBrews = new ListOfBrews();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_brew);

        // find views
        name = findViewById(R.id.name);
        date = findViewById(R.id.date);
        waterTemp = findViewById(R.id.waterTemp);
        waterMass = findViewById(R.id.waterMass);
        beanRoastDate = findViewById(R.id.beanRoastDate);
        beanName = findViewById(R.id.beanName);
        beanDarkness = findViewById(R.id.beanDarkness);
        coffeeMass = findViewById(R.id.coffeeMass);
        grindSize = findViewById(R.id.grindSize);
        brewer = findViewById(R.id.brewer);
        brewTime = findViewById(R.id.brewTime);
        waterDilutionMass = findViewById(R.id.waterDilutionMass);
        createButton = findViewById(R.id.editButton);
    }

    public void createButtonClicked(View view) {
        Bean bean = new Bean(beanName.getText().toString(), beanDarkness.getText().toString(), beanRoastDate.getText().toString());

        Brew brew = new Brew(name.getText().toString(), date.getText().toString(),
                Integer.parseInt(waterTemp.getText().toString()),
                Integer.parseInt(waterMass.getText().toString()),
                bean,
                Integer.parseInt(coffeeMass.getText().toString()),
                Integer.parseInt(grindSize.getText().toString()),
                brewer.getText().toString(),
                Integer.parseInt(brewTime.getText().toString()),
                Integer.parseInt(waterDilutionMass.getText().toString()));

        listOfBrews.addBrew(brew);

        // go to main list of brews
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}