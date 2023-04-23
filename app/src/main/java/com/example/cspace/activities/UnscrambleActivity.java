package com.example.cspace.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cspace.R;
import com.example.cspace.SQLITEDB.GameDbHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnscrambleActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView scrambledTextView;
    private EditText inputEditText;
    private TextView resultTextView;
    private Button submitButton;
    private Button playAgainButton;
    private Button tryAgainButton;
    private Button menuButton;
    private LinearLayout resultLayout;
    private String answer;
    private String scrambledText;


    private String[] scrambleWord(String word) {
        List<String> characters = Arrays.asList(word.split(""));
        Collections.shuffle(characters);
        String wordAfterShuffle = "";
        for (String character : characters) {
            wordAfterShuffle += (character + " ");
        }
        return new String[] {word, wordAfterShuffle};
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unscramble);

        scrambledTextView = findViewById(R.id.scrambled);
        inputEditText = findViewById(R.id.input);
        resultTextView = findViewById(R.id.resultText);
        submitButton = findViewById(R.id.submitButton);
        tryAgainButton = findViewById(R.id.tryAgain);
        playAgainButton = findViewById(R.id.anotherWord);
        menuButton = findViewById(R.id.menu);
        resultLayout = findViewById(R.id.result);

        submitButton.setOnClickListener(this);
        playAgainButton.setOnClickListener(this);
        tryAgainButton.setOnClickListener(this);
        menuButton.setOnClickListener(this);
        resultLayout.setVisibility(View.INVISIBLE);

        GameDbHelper dbHelper = new GameDbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM unscramble ORDER BY RANDOM() LIMIT 1", null);
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("word");
            String word = cursor.getString(columnIndex);
            String[] arr = scrambleWord(word);
            answer = arr[0];
            scrambledText = arr[1];
            scrambledTextView.setText(scrambledText);
        }
        dbHelper.close();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.submitButton:
                resultLayout.setVisibility(View.VISIBLE);
                String inputText = inputEditText.getText().toString().toLowerCase();
                if(inputText.equals(answer.toLowerCase())) {
                    resultTextView.setText("CORRECT");
                    tryAgainButton.setVisibility(View.INVISIBLE);
                } else {
                    resultTextView.setText("WRONG");
                }
                submitButton.setEnabled(false);
                inputEditText.setEnabled(false);
                break;

            case R.id.menu:
                Intent menu = new Intent(this, MenuActivity.class);
                startActivity(menu);
                break;

            case R.id.anotherWord:
                Intent playAgain = new Intent(this, UnscrambleActivity.class);
                startActivity(playAgain);
                break;

            case R.id.tryAgain:
                resultLayout.setVisibility(View.INVISIBLE);
                submitButton.setEnabled(true);
                inputEditText.setEnabled(true);
                break;
        }
    }
}
