package com.example.firstone;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.concurrent.TimeUnit;

public class Chess extends AppCompatActivity{

    ConstraintLayout p1,p2;
    TextView t1,t2;
    int min;
    long millis1,millis2;
    CountDownTimer countDownTimer1,countDownTimer2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.chess_timer);
        t1=findViewById(R.id.p1);
        t2=findViewById(R.id.p2);

        Bundle extras = getIntent().getExtras();
        String s = extras.getString("Time");
        t1.setText(s);
        min = Integer.parseInt(s);
        startTimer_For_Player1(min*1000);

        p1=(ConstraintLayout) findViewById(R.id.c1);
        p2=(ConstraintLayout) findViewById(R.id.c2);
    }
    public void startTimer_For_Player1(int min) {
            countDownTimer1 = new CountDownTimer(min, 1000) {
            public void onTick(long millisUntilFinished) {
                millis1 =millisUntilFinished;
                //Convert milliseconds into hour,minute and seconds
                String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis2),
                        TimeUnit.MILLISECONDS.toMinutes(millis1) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis1)),
                        TimeUnit.MILLISECONDS.toSeconds(millis1) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis1)));
                t1.setText(hms);//set text

            }
            public void onFinish() {
                t1.setText("TIME'S UP!!"); //On finish change timer text
            }
        }.start();


    }
    public void startTimer_For_Player2(int min) {
        countDownTimer2 = new CountDownTimer(min, 1000) {
            public void onTick(long millisUntilFinished) {
                millis2 = millisUntilFinished;
                //Convert milliseconds into hour,minute and seconds
                String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis2),
                        TimeUnit.MILLISECONDS.toMinutes(millis2) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis2)),
                        TimeUnit.MILLISECONDS.toSeconds(millis2) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis2)));
                t2.setText(hms);
            }
            public void onFinish() {
                t2.setText("TIME'S UP!!");
            }
        }.start();
    }
    public void timer1(View v)
    {
        countDownTimer1.cancel();
        startTimer_For_Player2(min*1000);

    }
    public void timer2(View v) {

        countDownTimer2.cancel();
        startTimer_For_Player1(min*1000);

    }
}

