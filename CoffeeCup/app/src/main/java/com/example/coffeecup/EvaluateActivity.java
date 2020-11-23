package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Math;
import java.util.Random;

public class EvaluateActivity extends AppCompatActivity {

    private final int DOSE_RATE = 2;
    private final int WATER_RATE = 4;
    private final int BREW_RATE = 5;

    Brew brew;
    String notes;
    TextView brewName;
    TextView brewDate;
    TextView message;
    Button backButton;
    Button finishButton;

    ListOfBrews listOfBrews = new ListOfBrews();
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("name") != null) {
            brew = ListOfBrews.find(bundle.getString("name"));
        }

        brewName = findViewById(R.id.eval_brew_name);
        brewDate = findViewById(R.id.eval_brew_date);
        backButton = findViewById(R.id.eval_back_button);
        message = findViewById(R.id.eval_message);

        brewName.setText(brew.getmName());
        brewDate.setText(brew.getmDate());

        evaluateBrew();

    }

    public void evalBackButtonClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Helper method to evaluate the passed in brew. Parses the
     * extraction and the strength rating
     */
    private void evaluateBrew() {
        int extraction = brew.getmExtraction();
        int strength = brew.getmStrength();

        // test strength then test extraction
        if (strength < 5) { // strength inc
            if (extraction < 5) {   // + extraction inc
                // test which magnitude is greater
                if (extraction <= strength) {
                    incExt(5 - extraction);
                } else if (extraction > strength) {
                    incStr(5 - strength);
                }
            }
            else if (extraction > 5) { // + extraction dec
                decExtIncStr(5 - strength, extraction - 5);
            }
            else {  // only increase strength
                incStr(5 - strength);
            }
        }
        else if (strength > 5) { // strength dec
            if (extraction < 5) { // + extraction inc
                incExtDecStr(strength - 5, 5 - extraction);
            }
            else if (extraction > 5) {  // + extraction dec
                // test which magnitude is greater
                if (extraction < strength) {
                    decStr(strength - 5);
                } else if (extraction >= strength) {
                    decExt(extraction - 5);
                }
            }
            else { // only decrease strength
                decStr(strength - 5);
            }
        }
        else { // no change in strength
            if (extraction < 5) { // extraction increase
                incExt(5 - extraction);
            }
            else if (extraction > 5) { // extraction decrease
                decExt(extraction - 5);
            }
            else { // perfectly balanced cup
                message.setText("No changes necessary to balance this brew.");
            }
        }
    }

    /**
     * N coffee compass.
     * @param magnitude brew change intensity
     */
    private void incStr(int magnitude) {
        int water = brew.getmWaterMass();
        int dose = brew.getmCoffeeMass();

        if (r.nextInt(101) < 50) {
            int newWater = water - (magnitude * WATER_RATE);
            message.setText("For the next brew, it is recommended that the water weight be lowered from "
                    + water + "g to " + newWater + "g.");
        } else {
            int newDose = dose + (magnitude * DOSE_RATE);
            message.setText("For the next brew, it is recommended that the coffee weight be increased from "
                    + dose + "g to " + newDose + "g.");
        }
    }

    /**
     * S coffee compass.
     * @param magnitude brew change intensity
     */
    private void decStr(int magnitude) {
        int water = brew.getmWaterMass();
        int dose = brew.getmCoffeeMass();

        if (r.nextInt(101) < 50) {
            int newWater = water + (magnitude * WATER_RATE);
            message.setText("For the next brew, it is recommended that the water weight be increased from "
                    + water + "g to " + newWater + "g.");
        } else {
            int newDose = dose - (magnitude * DOSE_RATE);
            message.setText("For the next brew, it is recommended that the coffee weight be lowered from "
                    + dose + "g to " + newDose + "g.");
        }
    }

    /**
     * NE coffee compass
     * @param magnitude brew change intensity
     */
    private void incExt(int magnitude) {
        int time = brew.getmBrewTime();
        int grind = brew.getmGrindSize();

        if (magnitude < 4) {
            int newTime = time + (magnitude * BREW_RATE);
            message.setText("For the next brew, it is recommended that the brew time be increased from "
                    + time + " seconds to " + newTime + "seconds.");
        } else {
            int newGrind;
            if (magnitude == 4)
                newGrind = grind - 1;
            else
                newGrind = grind - 2;
            message.setText("For the next brew, it is recommended that the grind size be lowered from a "
                    + grind + " to a " + newGrind + ".");
        }
    }

    /**
     * SW coffee compass.
     * @param magnitude brew change intensity
     */
    private void decExt(int magnitude) {
        int time = brew.getmBrewTime();
        int grind = brew.getmGrindSize();

        if (r.nextInt(101) < 50) {
            int newTime = time - (magnitude * BREW_RATE);
            message.setText("For the next brew, it is recommended that the brew time be decreased from "
                    + time + " seconds to " + newTime + "seconds.");
        } else {
            int newGrind;
            if (magnitude == 4)
                newGrind = grind + 1;
            else
                newGrind = grind + 2;
            message.setText("For the next brew, it is recommended that the grind size be increased from a "
                    + grind + " to a " + newGrind + ".");
        }
    }

    /**
     * NW + W coffee compass.
     * @param magS brew strength change intensity
     * @param magE brew extraction change intensity
     */
    private void decExtIncStr(int magS, int magE) {
        int time = brew.getmBrewTime();
        int grind = brew.getmGrindSize();
        int water = brew.getmWaterMass();
        int dose = brew.getmCoffeeMass();

        if (magS > magE) {  // focus more on strength
            if (r.nextInt(101) < 50) {
                int newWater = water - (magS * WATER_RATE);
                int newTime = time - (magE * (BREW_RATE - 2));
                message.setText("For the next brew, it is recommended that the water weight be lowered from "
                        + water + "g to " + newWater + "g, and that the brew time be decreased from "
                        + time + " seconds to " + newTime + " seconds.");
            } else {
                int newDose = dose + (magS * DOSE_RATE);
                int newTime = time - (magE * (BREW_RATE - 2));
                message.setText("For the next brew, it is recommended that the coffee weight be increased from "
                        + dose + "g to " + newDose + "g, and that the brew time be shortened from "
                        + time + " seconds to " + newTime + " seconds.");
            }
        } else if (magS < magE) { // focus more on extraction
            if (magE < 4) {
                int newTime = time - (magE * BREW_RATE);
                message.setText("For the next brew, it is recommended that the brew time be decreased from "
                        + time + " seconds to " + newTime + "seconds.");
            } else {
                int newGrind;
                if (magE == 4)
                    newGrind = grind + 1;
                else
                    newGrind = grind + 2;
                message.setText("For the next brew, it is recommended that the grind size be increased from a "
                        + grind + " to a " + newGrind + ".");
            }
        } else {    // equal focus
            if (r.nextInt(101) < 50) {
                int newWater = water - (magS * WATER_RATE);
                int newTime = time - (magE * BREW_RATE);
                message.setText("For the next brew, it is recommended that the water weight be lowered from "
                        + water + "g to " + newWater + "g, and that the brew time be decreased from "
                        + time + " seconds to " + newTime + " seconds.");
            } else {
                int newDose = dose + (magS * DOSE_RATE);
                int newTime = time - (magE * BREW_RATE);
                message.setText("For the next brew, it is recommended that the coffee weight be increased from "
                        + dose + "g to " + newDose + "g, and that the brew time be shortened from "
                        + time + " seconds to " + newTime + " seconds.");
            }
        }
    }

    /**
     * SE + E coffee compass.
     * @param magS brew strength change intensity
     * @param magE brew extraction change intensity
     */
    private void incExtDecStr(int magS, int magE) {
        int time = brew.getmBrewTime();
        int grind = brew.getmGrindSize();
        int water = brew.getmWaterMass();
        int dose = brew.getmCoffeeMass();

        if (magS > magE) {  // focus more on strength
            if (r.nextInt(101) < 50) {
                int newWater = water + (magS * WATER_RATE);
                int newTime = time + (magE * (BREW_RATE - 2));
                message.setText("For the next brew, it is recommended that the water weight be raised from "
                        + water + "g to " + newWater + "g, and that the brew time be increased from "
                        + time + " seconds to " + newTime + " seconds.");
            } else {
                int newDose = dose - (magS * DOSE_RATE);
                int newTime = time + (magE * (BREW_RATE - 2));
                message.setText("For the next brew, it is recommended that the coffee weight be lowered from "
                        + dose + "g to " + newDose + "g, and that the brew time be lengthened from "
                        + time + " seconds to " + newTime + " seconds.");
            }
        } else if (magS < magE) { // focus more on extraction
            if (magE < 4) {
                int newTime = time + (magE * BREW_RATE);
                message.setText("For the next brew, it is recommended that the brew time be lengthened from "
                        + time + " seconds to " + newTime + "seconds.");
            } else {
                int newGrind;
                if (magE == 4)
                    newGrind = grind - 1;
                else
                    newGrind = grind - 2;
                message.setText("For the next brew, it is recommended that the grind size be decreased from a "
                        + grind + " to a " + newGrind + ".");
            }
        } else {    // equal focus
            if (r.nextInt(101) < 50) {
                int newWater = water + (magS * WATER_RATE);
                int newTime = time + (magE * BREW_RATE);
                message.setText("For the next brew, it is recommended that the water weight be increased from "
                        + water + "g to " + newWater + "g, and that the brew time be increased from "
                        + time + " seconds to " + newTime + " seconds.");
            } else {
                int newDose = dose - (magS * DOSE_RATE);
                int newTime = time + (magE * BREW_RATE);
                message.setText("For the next brew, it is recommended that the coffee weight be lowered from "
                        + dose + "g to " + newDose + "g, and that the brew time be increased from "
                        + time + " seconds to " + newTime + " seconds.");
            }
        }
    }
}