package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Math;

public class EvaluateActivity extends AppCompatActivity {

    Brew brew;
    String notes;
    TextView brewName;
    TextView brewDate;
    TextView message;
    Button backButton;
    Button finishButton;

    ListOfBrews listOfBrews = new ListOfBrews();

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

                decExtIncStr((extraction + strength) / 2);
            }
            else {  // only increase strength
                incStr(5 - strength);
            }
        }
        else if (strength > 5) { // strength dec
            if (extraction < 5) { // + extraction inc
                incExtDecStr((extraction + strength) / 2);
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

            }
        }
    }

    /**
     * N coffee compass.
     * @param magnitude brew change intensity
     */
    private void incStr(int magnitude) {

    }

    /**
     * S coffee compass.
     * @param magnitude brew change intensity
     */
    private void decStr(int magnitude) {

    }

    /**
     * NE coffee compass
     * @param magnitude brew change intensity
     */
    private void incExt(int magnitude) {

    }

    /**
     * SW coffee compass.
     * @param magnitude brew change intensity
     */
    private void decExt(int magnitude) {

    }

    /**
     * NW + W coffee compass.
     * @param magnitude brew change intensity
     */
    private void decExtIncStr(int magnitude) {

    }

    /**
     * SE + E coffee compass.
     * @param magnitude brew change intensity
     */
    private void incExtDecStr(int magnitude) {

    }
}