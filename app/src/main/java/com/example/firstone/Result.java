package com.example.firstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView sc,hi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        sc = findViewById(R.id.score);
        hi = findViewById(R.id.high);

        int score = getIntent().getIntExtra("Score",0);
        sc.setText(score+"");

        SharedPreferences settings = getSharedPreferences("Game Data", Context.MODE_PRIVATE);
        int hg = settings.getInt("HighScore",0);

        if(score > hg)
        {
            hi.setText("High Score : "+score);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HighScore",score);
            editor.commit();
        }
        else {
            hi.setText("High Score : "+hg);
        }

    }
    public void again(View V)
    {
        startActivity(new Intent(getApplicationContext(),Game_Page.class));
    }
}
