package com.example.android.examplequiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity {

    private Button start;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"Acephimere.ttf");
        Typeface customFontBold = Typeface.createFromAsset(getAssets(),"Acephimere_Bold.ttf");
        name = (EditText) findViewById(R.id.name_field);
        start = (Button) findViewById(R.id.start_button);
        TextView app = (TextView) findViewById(R.id.GeoQuiz);
        TextView placeHolder = (TextView) findViewById(R.id.placeHolder);
        start.setTypeface(customFont);
        app.setTypeface(customFontBold);
        name.setTypeface(customFont);
        placeHolder.setTypeface(customFont);
        setAllMenu();
    }

    public void setAllMenu(){
        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String playerName = name.getText().toString();
                if(TextUtils.isEmpty(playerName)){
                    name.setError("The name cannot be empty!");
                } else {
                    Intent intent = new Intent(MainMenuActivity.this, QuizActivity.class);
                    intent.putExtra("player_name", playerName);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
