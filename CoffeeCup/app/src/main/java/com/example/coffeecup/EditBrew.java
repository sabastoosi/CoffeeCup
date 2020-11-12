package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditBrew extends AppCompatActivity {

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
    Button doneButton;
    ListOfBrews listOfBrews = new ListOfBrews();
    Brew brew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_brew);

        // find views
        name = findViewById(R.id.editName);
        date = findViewById(R.id.editDate);
        waterTemp = findViewById(R.id.editWaterTemp);
        waterMass = findViewById(R.id.editWaterMass);
        beanRoastDate = findViewById(R.id.editBeanRoastDate);
        beanName = findViewById(R.id.editBeanName);
        beanDarkness = findViewById(R.id.editBeanDarkness);
        coffeeMass = findViewById(R.id.editCoffeeMass);
        grindSize = findViewById(R.id.editGrindSize);
        brewer = findViewById(R.id.editBrewer);
        brewTime = findViewById(R.id.editBrewTime);
        waterDilutionMass = findViewById(R.id.editWaterDilutionMass);
        doneButton = findViewById(R.id.doneButton);

        // get brew name from row clicked
        Intent intent = getIntent();
        String brewName = intent.getExtras().getString("name");

        // find brew with name
        brew = listOfBrews.find(brewName);

        // set text fields to already inputted brew values
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

    public void doneButtonClicked(View view) {
        // update brew object
        brew.setmName(name.getText().toString());
        brew.setmDate(date.getText().toString());
        brew.setmWaterTemp(Integer.parseInt(waterTemp.getText().toString()));
        brew.setmWaterMass(Integer.parseInt(waterMass.getText().toString()));
        brew.setmBeanRoastDate(beanRoastDate.getText().toString());
        brew.setmBeanName(beanName.getText().toString());
        brew.setmBeanDarkness(beanDarkness.getText().toString());
        brew.setmCoffeeMass(Integer.parseInt(coffeeMass.getText().toString()));
        brew.setmGrindSize(Integer.parseInt(grindSize.getText().toString()));
        brew.setmBrewer(brewer.getText().toString());
        brew.setmBrewTime(Integer.parseInt(brewTime.getText().toString()));
        brew.setmWaterDilutionMass(Integer.parseInt(waterDilutionMass.getText().toString()));

        // go back to previous screen
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}