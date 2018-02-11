package com.example.android.examplequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class FinishedActivity extends AppCompatActivity {

    private int finalScore, correctAnsCount;
    private String finalName;
    private TextView nameText, scoreText, correctText;
    private Button playAgainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished);
        Intent intent = getIntent();
        finalName = intent.getStringExtra("NAME");
        correctAnsCount = intent.getIntExtra("CORRECTANS", 0);
        finalScore = intent.getIntExtra("SCORE", 0);
        playAgainButton = (Button) findViewById(R.id.playAgain);
        nameText = (TextView) findViewById(R.id.playerName);
        scoreText = (TextView) findViewById(R.id.finalScore);
        correctText = (TextView) findViewById(R.id.correctAnswer);
        nameText.setText(finalName);
        scoreText.setText(Integer.toString(finalScore));
        correctText.setText("Correct Answer: "+Integer.toString(correctAnsCount));
        setPlayAgainButton();
    }

    public void setPlayAgainButton() {
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishedActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
