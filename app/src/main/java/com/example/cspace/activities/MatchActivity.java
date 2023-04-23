package com.example.cspace.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cspace.adapters.ImageAdapter;
import com.example.cspace.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchActivity extends AppCompatActivity implements View.OnClickListener {
    Button menu;
    Button playAgain;
    LinearLayout result;
    TextView resultText;
    ImageView currentImage;
    int pairs = 0;
    final int[] drawable = new int[] {R.drawable.java,R.drawable.js,R.drawable.html,R.drawable.php,R.drawable.css,R.drawable.java,R.drawable.js,R.drawable.html,R.drawable.php,R.drawable.css};
    int[] positions = {0,1,2,3,4,0,1,2,3,4};

    public int[] Shuffle(int[] positions) {
        List<Integer> positionList = new ArrayList<Integer>();
        for (int i = 0; i < positions.length; i++) {
            positionList.add(positions[i]);
        }

        Collections.shuffle(positionList);

        for (int i = 0; i < positionList.size(); i++) {
            positions[i] = positionList.get(i);
        }
        return positions;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        menu = findViewById(R.id.menu);
        playAgain = findViewById(R.id.playAgain);
        result = findViewById(R.id.result);
        resultText = findViewById(R.id.resultText);

        result.setVisibility(View.INVISIBLE);
        menu.setOnClickListener(this);
        playAgain.setOnClickListener(this);

        Shuffle(positions);
        GridView gridView = findViewById(R.id.gridview);
        ImageAdapter imageAdapter = new ImageAdapter(MatchActivity.this);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            int[] clickedIndices = {-1, -1};
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                ImageView imageView = (ImageView) view;
                imageView.setImageResource(drawable[positions[position]]);
                if (imageView.getTag() == "matched" || currentImage != null && currentImage.getTag() == "matched") {
                    return;
                }
                if (currentImage == null) {
                    currentImage = imageView;
                    clickedIndices[0] = position;
                } else {
                    clickedIndices[1] = position;
                    if (drawable[positions[clickedIndices[0]]] == drawable[positions[clickedIndices[1]]]) {
                        pairs++;
                        if (pairs == drawable.length / 2) {
                            result.setVisibility(View.VISIBLE);
                            resultText.setText("YOU WON!");
                        }
                        currentImage.setTag("matched");
                        imageView.setTag("matched");
                        currentImage = null;
                    } else {
                        gridView.setEnabled(false);
                        imageView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                currentImage.setImageResource(R.drawable.hidden);
                                imageView.setImageResource(R.drawable.hidden);
                                gridView.setEnabled(true);
                                currentImage = null;
                            }
                        }, 500);
                    }
                    clickedIndices[0] = -1;
                    clickedIndices[1] = -1;
                }
            }
        });


    }

    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.menu:
                Intent menu = new Intent(this,MenuActivity.class);
                startActivity(menu);
                break;

            case R.id.playAgain:
                Intent playAgain = new Intent(this,MatchActivity.class);
                startActivity(playAgain);
                break;
        }
    }
}