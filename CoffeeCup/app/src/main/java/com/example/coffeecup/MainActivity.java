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
        Bean myBean = new Bean("bean", "dark", "10/1/2020" );
        Brew firstBrew = new Brew("BrewOne", "10/8/2020", 95, myBean, 10, 10, "aeropress", 10, 10 );
        Brew secondBrew = new Brew("BrewTwo", "10/8/2020", 96, myBean, 15, 8, "aeropress", 10, 0);
        listOfBrews.addBrew(firstBrew);
        listOfBrews.addBrew(secondBrew);
        myDataset = listOfBrews.getAllBrews();
    }

    public void createBrew(View view) {
        Intent intent = new Intent(this, NewBrewActivity.class);
        startActivity(intent);
    }

}