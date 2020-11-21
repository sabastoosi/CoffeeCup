package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PostBrewActivity extends AppCompatActivity {

    Brew brew;
    ListOfBrews listOfBrews = new ListOfBrews();

    Button backButton;
    Button finishButton;
    TextView brewName;

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
    }

    public void finishButtonClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void backButtonClicked(View view) {
        Intent intent = new Intent(this, NewBrewActivity.class);
        startActivity(intent);
    }
}