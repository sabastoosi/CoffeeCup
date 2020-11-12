package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Brew> myDataset = new ArrayList<Brew>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fab;
    ListOfBrews listOfBrews = new ListOfBrews();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        fab = (FloatingActionButton) findViewById(R.id.createBrewButton);
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
    }

    public void createBrew(View view) {
        Intent intent = new Intent(this, NewBrewActivity.class);
        startActivity(intent);
    }

}