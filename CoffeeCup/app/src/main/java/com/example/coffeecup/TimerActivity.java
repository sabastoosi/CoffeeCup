package com.example.coffeecup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

// most of the code for the stopwatch was taken from this link
// https://www.geeksforgeeks.org/how-to-create-a-stopwatch-app-using-android-studio/

public class TimerActivity extends AppCompatActivity {

    Button start, stop, reset;
    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    Brew brew;
    ListOfBrews listOfBrews = new ListOfBrews();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("Brew name") != null) {
            brew = ListOfBrews.find(bundle.getString("Brew name"));
        }

        // find views
        start = findViewById(R.id.startButton);
        stop = findViewById(R.id.stopButton);
        reset = findViewById(R.id.resetButton);

        if (savedInstanceState != null) {
            seconds = savedInstanceState
                    .getInt("seconds");
            running = savedInstanceState
                    .getBoolean("running");
            wasRunning = savedInstanceState
                    .getBoolean("wasRunning");
        }
        runTimer();
    }

    // Save the state of the stopwatch
    // if it's about to be destroyed.
    @Override
    public void onSaveInstanceState(
            Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState
                .putInt("seconds", seconds);
        savedInstanceState
                .putBoolean("running", running);
        savedInstanceState
                .putBoolean("wasRunning", wasRunning);
    }

    // If the activity is paused,
    // stop the stopwatch.
    @Override
    protected void onPause()
    {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    // If the activity is resumed,
    // start the stopwatch
    // again if it was running previously.
    @Override
    protected void onResume()
    {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    private void runTimer()
    {
        // Get the text view.
        final TextView timeView
                = (TextView)findViewById(
                R.id.time_view);

        // Creates a new Handler
        final Handler handler
                = new Handler();

        // Call the post() method,
        // passing in a new Runnable.
        // The post() method processes
        // code without a delay,
        // so the code in the Runnable
        // will run almost immediately.
        handler.post(new Runnable() {
            @Override

            public void run()
            {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                // Format the seconds into hours, minutes,
                // and seconds.
                String time
                        = String
                        .format(Locale.getDefault(),
                                "%d:%02d:%02d", hours,
                                minutes, secs);

                // Set the text view text.
                timeView.setText(time);

                // If running is true, increment the
                // seconds variable.
                if (running) {
                    seconds++;
                }

                // Post the code again
                // with a delay of 1 second.
                handler.postDelayed(this, 1000);
            }
        });
    }

    public void startButtonClicked(View view) {
        running = true;
    }

    public void stopButtonClicked(View view) {
        running = false;
    }

    public void resetButtonClicked(View view) {
        running = false;
        seconds = 0;
    }

    public void timerBackButtonClicked(View view) {
        Intent intent = new Intent(this, PostBrewActivity.class);
        intent.putExtra("Brew name", brew.getmName());
        startActivity(intent);
    }
}