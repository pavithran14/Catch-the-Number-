package com.example.firstone;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class Game_Page extends AppCompatActivity {

    private TextView score,start;
    private ImageView pacman,one,two,three,zero;
    private int pacY;
    private boolean action_flag=false;
    private boolean start_flag=false;
    private int frameheight;
    private int boxsize;
    private int screenWidth;
    private int screenHeight;

    private int zeroX;
    private int zeroY;

    private int oneX;
    private int oneY;

    private int twoX;
    private int twoY;

    private int threeX;
    private int threeY;

    private int sc;

    private Handler handler= new Handler();
    private Timer timer=new Timer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        score=findViewById(R.id.score_board);
        start=findViewById(R.id.ttp);
        pacman=findViewById(R.id.pacman);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        zero = findViewById(R.id.zero);

        one.setX(-80);
        one.setY(-80);
        two.setX(-80);
        two.setY(-80);
        three.setX(-80);
        three.setY(-80);
        zero.setX(-80);
        zero.setY(-80);
        WindowManager wm=getWindowManager();
        Display dip=wm.getDefaultDisplay();
        Point size =new Point();
        dip.getSize(size);

        screenWidth=size.x;
        screenHeight=size.y;
        score.setText("Score : 0");
    }
    public void changePos()
    {
        hitcheck();
        zeroX-=17;
        if(zeroX <0)
        {
            zeroX=screenWidth+110;
            zeroY=(int)Math.floor(Math.random()*frameheight-one.getHeight());
        }
        zero.setX(zeroX);
        zero.setY(zeroY);
        oneX-=8;
        if(oneX <0)
        {
            oneX=screenWidth+20;
            oneY=(int)Math.floor(Math.random()*frameheight-one.getHeight());
        }
        one.setX(oneX);
        one.setY(oneY);

        twoX-=12;
        if(twoX <0)
        {
            twoX=screenWidth+20;
            twoY=(int)Math.floor(Math.random()*frameheight-one.getHeight());
        }
        two.setX(twoX);
        two.setY(twoY);

        threeX-=16;
        if(threeX <0)
        {
            threeX=screenWidth+110;
            threeY=(int)Math.floor(Math.random()*frameheight-one.getHeight());
        }
        three.setX(threeX);
        three.setY(threeY);

        if(action_flag == true)
        {
            pacY -= 15;
        }
        else {
            pacY += 15;
        }
        if(pacY <0)
            pacY=0;
        if(pacY>frameheight-boxsize)
            pacY=frameheight-boxsize;
        pacman.setY(pacY) ;
        score.setText("Score : "+sc);
    }
    public void hitcheck()
    {
        // For One
        int one_centerx = oneX + one.getWidth() / 2;
        int one_centery = oneY + one.getHeight() / 2;

        if(0<=one_centerx && one_centerx <= boxsize &&
                pacY<= one_centery && one_centery <= pacY +boxsize){
            oneX =-10;
            sc = sc + 1;
        }

        //for two
        int two_centerx = twoX + two.getWidth() / 2;
        int two_centery = twoY + two.getHeight() / 2;

        if(0<=two_centerx && two_centerx <= boxsize &&
                pacY<= two_centery && two_centery <= pacY +boxsize){
            twoX =-10;
            sc = sc + 2;
        }

        // for three
        int three_centerx = threeX + three.getWidth() / 2;
        int three_centery = threeY + three.getHeight() / 2;

        if(0<=three_centerx && three_centerx <= boxsize &&
                pacY<= three_centery && three_centery <= pacY +boxsize){
            threeX =-10;
            sc = sc + 3;
        }
        int zero_centerx = zeroX + zero.getWidth() / 2;
        int zero_centery = zeroY + zero.getHeight() / 2;

        if(0<=zero_centerx && zero_centerx <= boxsize &&
                pacY<= zero_centery && zero_centery <= pacY +boxsize){
            timer.cancel();
            timer = null;

            Intent i = new Intent(getApplicationContext(),Result.class);
            i.putExtra("Score", sc);
            startActivity(i);
        }
    }
    public boolean onTouchEvent(MotionEvent me)
    {
        if(start_flag == false)
        {
            start_flag=true;
            start.setVisibility(View.GONE);
            FrameLayout frameLayout=findViewById(R.id.frame);
            frameheight=frameLayout.getHeight();
            pacY = (int) pacman.getY();
            boxsize=pacman.getHeight();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            changePos();
                        }
                    });
                }
            },0,20);

        }
        else
        {
            if(me.getAction() == MotionEvent.ACTION_DOWN)
            {
                action_flag=true;
            }
            else if(me.getAction() == MotionEvent.ACTION_UP)
            {
                action_flag=false;
            }
        }
        return true;
    }
}
