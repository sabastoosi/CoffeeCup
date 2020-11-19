package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PostBrewActivity extends AppCompatActivity {

    Brew brew;
    ListOfBrews listOfBrews = new ListOfBrews();

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
    }
}