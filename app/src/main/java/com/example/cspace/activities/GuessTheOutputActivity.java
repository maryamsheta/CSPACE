package com.example.cspace.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cspace.R;
import com.example.cspace.SQLITEDB.GameDbHelper;

public class GuessTheOutputActivity extends AppCompatActivity implements View.OnClickListener {

    Button selected = null;
    Button optionA;
    Button optionB;
    Button menu;
    Button playAgain;
    Button submit;
    LinearLayout result;
    TextView languageText;
    TextView codeText;
    TextView resultText;
    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_output);

        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        submit = findViewById(R.id.submitButton);
        menu = findViewById(R.id.menu);
        playAgain = findViewById(R.id.playAgain);
        result = findViewById(R.id.result);
        languageText = findViewById(R.id.language);
        codeText = findViewById(R.id.question);
        resultText = findViewById(R.id.resultText);

        GameDbHelper dbHelper = new GameDbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM guessTheOutput ORDER BY RANDOM() LIMIT 1", null);
        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("question");
            int optionAIndex = cursor.getColumnIndex("optionA");
            int optionBIndex = cursor.getColumnIndex("optionB");
            int answerIndex = cursor.getColumnIndex("answer");
            int languageIndex = cursor.getColumnIndex("language");
            codeText.setText(cursor.getString(questionIndex));
            optionA.setText(cursor.getString(optionAIndex));
            optionB.setText(cursor.getString(optionBIndex));
            languageText.setText("Language: "+cursor.getString(languageIndex));
            answer = cursor.getString(answerIndex);
        }
        dbHelper.close();

        optionA.setOnClickListener(this);
        optionB.setOnClickListener(this);
        submit.setOnClickListener(this);
        menu.setOnClickListener(this);
        playAgain.setOnClickListener(this);
        result.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View view)
    {
        optionA.setBackgroundColor(getColor(R.color.green));
        optionA.setTextColor(getColor(R.color.grey));
        optionB.setBackgroundColor(getColor(R.color.green));
        optionB.setTextColor(getColor(R.color.grey));

        switch (view.getId()) {
            case R.id.optionA:
                optionA.setBackgroundColor(getColor(R.color.grey));
                optionA.setTextColor(getColor(R.color.green));
                selected = optionA;
                break;

            case R.id.optionB:
                optionB.setBackgroundColor(getColor(R.color.grey));
                optionB.setTextColor(getColor(R.color.green));
                selected = optionB;
                break;

            case R.id.submitButton:
                if(selected !=  null && selected.getText().equals(answer)) {
                    result.setVisibility(View.VISIBLE);
                    resultText.setText("CORRECT");
                    submit.setEnabled(false);
                    optionA.setEnabled(false);
                    optionB.setEnabled(false);
                } else if (selected !=  null && !selected.getText().equals(answer)) {
                    result.setVisibility(View.VISIBLE);
                    resultText.setText("WRONG");
                    submit.setEnabled(false);
                    optionA.setEnabled(false);
                    optionB.setEnabled(false);
                }
                break;

            case R.id.menu:
                Intent menu = new Intent(this,MenuActivity.class);
                startActivity(menu);
                break;

            case R.id.playAgain:
                Intent playAgain = new Intent(this,GuessTheOutputActivity.class);
                startActivity(playAgain);
                break;
        }
    }
}