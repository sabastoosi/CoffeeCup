package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> myDataset = new ArrayList<String>();

    private FloatingActionButton fab;
    ListOfBrews listOfBrews = new ListOfBrews();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        loadData();

        Bean myBean = new Bean("bean", "dark", "10/1/2020" );
        Brew firstBrew = new Brew("BrewOne", "10/8/2020", 95, myBean, 10, 10, "aeropress", 10, 10 );
        listOfBrews.addBrew(firstBrew);
        myDataset = listOfBrews.getAllBrewNames();

        // set adapter for list of lists view
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, myDataset);
        listView.setAdapter(adapter);


        fab = (FloatingActionButton) findViewById(R.id.createBrewButton);


    }

    /**
     * loads data from previous entries
     */
    private void loadData() {

    }

}