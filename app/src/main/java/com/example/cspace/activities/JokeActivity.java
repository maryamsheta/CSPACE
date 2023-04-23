package com.example.cspace.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cspace.workers.JokeWorker;
import com.example.cspace.R;

import java.util.concurrent.TimeUnit;


public class JokeActivity extends AppCompatActivity {

    TextView jokeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();
        PeriodicWorkRequest request = new PeriodicWorkRequest.Builder(JokeWorker.class, 1, TimeUnit.DAYS)
                .setInitialDelay(1,TimeUnit.DAYS)
                .setConstraints(constraints)
                .build();
        WorkManager.getInstance(JokeActivity.this).enqueue(request);

        jokeText = findViewById(R.id.jokeText);
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("joke_prefs", Context.MODE_PRIVATE);
        String joke = prefs.getString("joke_text", "why do python programmers wear glasses? Because they can't C.");
        jokeText.setText(joke);
        prefs.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                if (key.equals("joke_text")) {
                    String joke = sharedPreferences.getString(key, "");
                    jokeText.setText(joke);
                }
            }
        });
    }

}