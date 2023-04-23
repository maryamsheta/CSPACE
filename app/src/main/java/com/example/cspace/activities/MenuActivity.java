package com.example.cspace.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cspace.R;
import com.example.cspace.classes.GlossaryItem;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        GlossaryActivity glossaryActivity = new GlossaryActivity();

        new Thread(new Runnable() {
            @Override
            public void run() {
                glossaryActivity.populateGlossary();
            }
        }).start();

        Button getJoke = findViewById(R.id.jokeButton);
        getJoke.setOnClickListener(this);

        Button getRandom = findViewById(R.id.randomButton);
        getRandom.setOnClickListener(this);

        Button guessTheOutput = findViewById(R.id.guessTheOutputGame);
        guessTheOutput.setOnClickListener(this);

        Button guessTheLanguage = findViewById(R.id.guessTheLanguageGame);
        guessTheLanguage.setOnClickListener(this);

        Button unscramble = findViewById(R.id.unscrambleGame);
        unscramble.setOnClickListener(this);

        Button match = findViewById(R.id.matchGame);
        match.setOnClickListener(this);

        Button glossary = findViewById(R.id.glossaryButton);
        glossary.setOnClickListener(this);

        Button randomTerm = findViewById(R.id.randomTerm);
        randomTerm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.jokeButton:
                Intent joke = new Intent(this,JokeActivity.class);
                startActivity(joke);
                break;

            case R.id.randomButton:
                int randomIndex = (int) ((Math.random() * (4 - 1+1)) + 1);
                if(randomIndex==1) {
                    Intent game1 = new Intent(this,GuessTheOutputActivity.class);
                    startActivity(game1);
                } else if(randomIndex==2) {
                    Intent game2 = new Intent(this, GuessTheLanguageActivity.class);
                    startActivity(game2);
                }else if(randomIndex==3) {
                    Intent game3 = new Intent(this, UnscrambleActivity.class);
                    startActivity(game3);
                } else if(randomIndex==4) {
                    Intent game4 = new Intent(this, MatchActivity.class);
                    startActivity(game4);
                }
                break;

            case R.id.guessTheOutputGame:
                Intent guessTheOutput = new Intent(this,GuessTheOutputActivity.class);
                startActivity(guessTheOutput);
                break;

            case R.id.guessTheLanguageGame:
                Intent guessTheLanguage = new Intent(this,GuessTheLanguageActivity.class);
                startActivity(guessTheLanguage);
                break;

            case R.id.unscrambleGame:
                Intent unscramble = new Intent(this,UnscrambleActivity.class);
                startActivity(unscramble);
                break;

            case R.id.matchGame:
                Intent match = new Intent(this,MatchActivity.class);
                startActivity(match);
                break;

            case R.id.glossaryButton:
                Intent glossary = new Intent(this,GlossaryActivity.class);
                startActivity(glossary);
                break;

            case R.id.randomTerm:
                Intent glossaryDetail = new Intent(this, GlossaryDetailsActivity.class);
                GlossaryItem randomGlossaryItem = GlossaryActivity.getRandomGlossaryItem();
                String randTerm = randomGlossaryItem.getTerm();
                String randDef  = randomGlossaryItem.getDefinition();
                glossaryDetail.putExtra("randTerm", randTerm);
                glossaryDetail.putExtra("randDef", randDef);
                glossaryDetail.putExtra("fromMenu", true);
                startActivity(glossaryDetail);
                break;

        }
    }
}