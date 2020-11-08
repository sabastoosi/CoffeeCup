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

    private ArrayList<String> myDataset = new ArrayList<String>();
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
        fab.setOnClickListener();

        loadData();

        // linear layout init
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Bean myBean = new Bean("bean", "dark", "10/1/2020" );
        Brew firstBrew = new Brew("BrewOne", "10/8/2020", 95, myBean, 10, 10, "aeropress", 10, 10 );
        listOfBrews.addBrew(firstBrew);
        myDataset = listOfBrews.getAllBrewNames();

        // set adapter
        mAdapter = new RecyclerAdapter(this, myDataset);
        recyclerView.setAdapter(mAdapter);
    }

    /**
     * loads data from previous entries
     */
    private void loadData() {

    }

    public void createBrew() {
        Intent intent = new Intent(this, BrewActivity.class);
        startActivity(intent);
    }

}