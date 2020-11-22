package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PostBrewActivity extends AppCompatActivity {

    Brew brew;
    ListOfBrews listOfBrews = new ListOfBrews();

    Button backButton;
    Button finishButton;
    TextView brewName;
    EditText strengthText;
    EditText extractionText;
    EditText notesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_brew);

        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("Brew name") != null) {
            brew = ListOfBrews.find(bundle.getString("Brew name"));
        }

        brewName = findViewById(R.id.post_brew_name);
        backButton = findViewById(R.id.post_back_button);
        finishButton = findViewById(R.id.post_finish_button);
        strengthText = findViewById(R.id.post_text_strength);
        extractionText = findViewById(R.id.post_text_extraction);
        notesText = findViewById(R.id.post_text_notes);
        brewName.setText(brew.getmName());
    }

    public void finishButtonClicked(View view) {
        brew.setmExtraction(Integer.parseInt(extractionText.getText().toString()));
        brew.setmStrength(Integer.parseInt(strengthText.getText().toString()));
        brew.setmNotes(notesText.getText().toString());

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void backButtonClicked(View view) {
        Intent intent = new Intent(this, NewBrewActivity.class);
        startActivity(intent);
    }
}