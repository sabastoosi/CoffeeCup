package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

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
    TextView notes;
    Button editButton;
    Button deleteButton;
    Button evaluateButton;
    Button backButton;
    ToggleButton favoriteButton;
    ListOfBrews listOfBrews = new ListOfBrews();
    Brew brew;
    String brewName;

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
        backButton = findViewById(R.id.backButton);
        notes = findViewById(R.id.viewNotes);
        favoriteButton = findViewById(R.id.favoriteButton);

        // get name
        Intent intent = getIntent();
        brewName = intent.getExtras().getString("name");

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
        notes.setText(String.valueOf("Notes: " + brew.getmNotes()));

        if (brew.getmFavoriteStatus() == true) {
            favoriteButton.setChecked(true);
        }
    }

    public void editButtonClicked(View view) {
        Intent intent = new Intent(this, EditBrew.class);
        intent.putExtra("name", name.getText().toString());
        startActivity(intent);
    }

    public void deleteButtonClicked(View view) {
        listOfBrews.deleteBrew(brewName);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void evaluateButtonClicked(View view) {

    }

    public void backButtonClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void favoriteButtonClicked(View view) {
        if (favoriteButton.isChecked()) {
            brew.setIsFavorite(true);
            favoriteButton.setChecked(true);
        } else {
            brew.setIsFavorite(false);
            favoriteButton.setChecked(false);
        }
    }
}