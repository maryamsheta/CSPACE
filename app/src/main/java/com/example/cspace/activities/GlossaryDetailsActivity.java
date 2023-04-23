package com.example.cspace.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cspace.R;
import com.example.cspace.classes.GlossaryItem;

public class GlossaryDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glossary_details);

        TextView termTextView = findViewById(R.id.termTextView);
        TextView definitionTextView = findViewById(R.id.definitionTextView);

        Intent intent = getIntent();
        boolean fromMenu = intent.getBooleanExtra("fromMenu", false);

        if (fromMenu) {
            String term = intent.getStringExtra("randTerm");
            String definition = intent.getStringExtra("randDef");

            termTextView.setText(term);
            definitionTextView.setText(definition);
        } else {
            String term = intent.getStringExtra("term");
            String definition = intent.getStringExtra("definition");

            termTextView.setText(term);
            definitionTextView.setText(definition);
        }

    }
}