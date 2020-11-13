package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Brew> myDataset = new ArrayList<Brew>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fab;
    TextView noBrewsView;
    ListOfBrews listOfBrews = new ListOfBrews();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        fab = (FloatingActionButton) findViewById(R.id.createBrewButton);
        noBrewsView = findViewById(R.id.noBrewsView);

        // if there are no brews, we will display a message that says no brews. In the on create however,
        // this will initially be invisible until we check if there are brews or not in loadData
        noBrewsView.setVisibility(View.INVISIBLE);

        // get brews
        loadData();

        // linear layout init
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // set adapter
        mAdapter = new MyAdapter(this, myDataset);
        recyclerView.setAdapter(mAdapter);
    }

    /**
     * loads data from previous entries
     */
    private void loadData() {
        myDataset = listOfBrews.getAllBrews();

        // if there are no brews, show the message that says "no brews" instead of an empty recycler view
        if (myDataset.size() == 0) {
            noBrewsView.setVisibility(View.VISIBLE);
        }
    }

    public void createBrew(View view) {
        Intent intent = new Intent(this, NewBrewActivity.class);
        startActivity(intent);
    }

}