package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EvaluateActivity extends AppCompatActivity {

    Brew brew;
    String notes;
    TextView brewName;
    TextView brewNotes;
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
        brewNotes = findViewById(R.id.eval_brew_notes);
        backButton = findViewById(R.id.eval_back_button);

        brewName.setText(brew.getmName());
        brewNotes.setText(brew.getmNotes());

    }

    public void evalBackButtonClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}