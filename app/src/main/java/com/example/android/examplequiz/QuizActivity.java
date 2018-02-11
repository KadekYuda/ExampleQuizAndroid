package com.example.android.examplequiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private String[] questionList = {"What is the capital city of Japan?", "What is the capital city of USA", "What is the capital city of Indonesia?"};
    private String[] correctAnswer = {"Tokyo", "Washington D.C", "Jakarta"};
    private String[] Answer1 = {"Tokyo", "California", "Bandung"};
    private String[] Answer2 = {"Idaho", "Washington D.C", "Surabaya"};
    private String[] Answer3 = {"Tokugawa", "Silicon Valley", "Palangkarya"};
    private String[] Answer4 = {"Nishikata", "Miami", "Jakarta"};
    private int scoreCount = 0;
    private TextView playerNameDisplay;
    private TextView questionNum, question, score;
    private Button answer_1, answer_2, answer_3, answer_4;
    private Button quit;
    int index = 0;
    int questionNumber = 0;
    int countCorrect = 0;
    private int totalQuestion;
    String player_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"Acephimere.ttf");
        Intent intent = getIntent();
        player_name = intent.getStringExtra("player_name");
        playerNameDisplay = (TextView) findViewById(R.id.player_name);
        playerNameDisplay.setText("Name: " + player_name);
        question = (TextView) findViewById(R.id.question);
        questionNum = (TextView) findViewById(R.id.questionNumber);
        score = (TextView) findViewById(R.id.player_score);
        answer_1 = (Button) findViewById(R.id.answer_1);
        answer_2 = (Button) findViewById(R.id.answer_2);
        answer_3 = (Button) findViewById(R.id.answer_3);
        answer_4 = (Button) findViewById(R.id.answer_4);
        quit     = (Button) findViewById(R.id.quit_button);
        playerNameDisplay.setTypeface(customFont);
        score.setTypeface(customFont);
        answer_1.setTypeface(customFont);
        answer_2.setTypeface(customFont);
        answer_3.setTypeface(customFont);
        answer_4.setTypeface(customFont);
        quit.setTypeface(customFont);
        question.setTypeface(customFont);
        setButton();
    }

    @Override
    protected void onResume(){
        super.onResume();

        totalQuestion = questionList.length;
        showQuestion(index);

    }

    private void showQuestion(int index){
        if(index < totalQuestion){
            questionNumber++;
            String currentQuestion = questionList[index];
            questionNum.setText("Question " + Integer.toString(questionNumber));
            question.setText(currentQuestion);
            answer_1.setText(Answer1[index]);
            answer_2.setText(Answer2[index]);
            answer_3.setText(Answer3[index]);
            answer_4.setText(Answer4[index]);
        } else {
            Intent intent  = new Intent(QuizActivity.this,FinishedActivity.class);
            String name = playerNameDisplay.getText().toString();
            intent.putExtra("SCORE",scoreCount);
            intent.putExtra("NAME",player_name);
            intent.putExtra("CORRECTANS",countCorrect);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("WARNING")
                .setMessage("Are you sure you want to close and quit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    public void setButton(){
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(QuizActivity.this)
                        .setTitle("WARNING")
                        .setMessage("Are you sure you want quit?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(QuizActivity.this, MainMenuActivity.class);
                                    startActivity(intent);
                                    finish();
                                }

                            })
                        .setNegativeButton("No", null)
                        .show();
                }
        });

        answer_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(answer_1.getText().equals(correctAnswer[index])){
                    scoreCount += 10;
                    countCorrect++;
                    Toast.makeText(getApplicationContext(),"CORRECT!",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"WRONG!",Toast.LENGTH_SHORT).show();
                }
                showQuestion(++index);
                score.setText("Score: " + Integer.toString(scoreCount));
            }
        });

        answer_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(answer_2.getText().equals(correctAnswer[index])){
                    scoreCount += 10;
                    countCorrect++;
                    Toast.makeText(getApplicationContext(),"CORRECT!",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"WRONG!",Toast.LENGTH_SHORT).show();
                }
                showQuestion(++index);
                score.setText("Score: " + Integer.toString(scoreCount));
            }
        });

        answer_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(answer_3.getText().equals(correctAnswer[index])){
                    scoreCount += 10;
                    countCorrect++;
                    Toast.makeText(getApplicationContext(),"CORRECT!",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"WRONG!",Toast.LENGTH_SHORT).show();
                }
                showQuestion(++index);
                score.setText("Score: " + Integer.toString(scoreCount));
            }
        });

        answer_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(answer_4.getText().equals(correctAnswer[index])){
                    scoreCount += 10;
                    countCorrect++;
                    Toast.makeText(getApplicationContext(),"CORRECT!",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"WRONG!",Toast.LENGTH_SHORT).show();
                }
                showQuestion(++index);
                score.setText("Score: " + Integer.toString(scoreCount));
            }
        });
    }
}
