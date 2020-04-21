package com.example.thefactory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Main3Activity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tvs,tvc;
    final long FULL = 10000;
    CountDownTimer countdowntimer;
    private long timeleftinmillis;
    Vibrator vibrator;
    static int score,hscore ;
    static int a,b,c,num,status,n,fact,ko=0,ol=0;
    Button next ;
    Boolean tim=false;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final SharedPreferences pref = getSharedPreferences("The FACTORy", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = pref.edit();
        score=pref.getInt("score",0);

        tv1= findViewById(R.id.tv1);
        tv2= findViewById(R.id.tv2);
        tv3= findViewById(R.id.tv3);
        tvs = findViewById(R.id.score);
        tvc = findViewById(R.id.tvcountdown);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        next = findViewById(R.id.next);


        Intent intent = getIntent();
        a=intent.getIntExtra("a",0);
        b=intent.getIntExtra("b",0);
        c=intent.getIntExtra("c",0);
        num=intent.getIntExtra("num",0);
        status=intent.getIntExtra("status",9);
        n=intent.getIntExtra("n",-1);
        fact=intent.getIntExtra("fact",1);


        tv1.setText( "a) "+a);
        tv2.setText("b) "+b);
        tv3.setText("c) "+c);


        if(ol==0){
            timeleftinmillis = FULL+100;
            startCountDown();
            ol=1;
        }


        tv1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                next.setVisibility(View.VISIBLE);
                tim = true;

                ConstraintLayout lay = (ConstraintLayout)findViewById(R.id.layout3);

                    if(countdowntimer != null){
                        countdowntimer.cancel();
                    }

                            if(status==2) {
                                if(ko!=3){
                                    ko=1;
                                }
                    lay.setBackgroundColor(Color.GREEN);

                    Toast t = Toast.makeText(Main3Activity.this, "Correct! +1", Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
                    t.show();
                    if(num!=n) {
                        score++;
                        n=num;
                        edit.putInt("prev",n);
                        edit.putInt("score",score);
                        edit.apply();

                    }

                }

                else {
                   ko=2;
                    lay.setBackgroundColor(0xFFED4747);
                    vibrator.vibrate(500);
                    Toast t = Toast.makeText(Main3Activity.this, "Wrong! The right answer is "+fact, Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
                    t.show();
                    if(n!=num) {
                        if(ko!=3){
                            ko=3;
                        }
                        tvs.setText("Your Score = " + score);
                        hscore=pref.getInt("highscore",0);
                        if(hscore<score){
                            hscore=score;

                        }

                        edit.putInt("highscore",hscore);
                        edit.putInt("score",0);
                        edit.putInt("prev",-1);
                        edit.apply();
                        score = 0;
                        n=-1;
                        next.setText("Try Again ?");

                    }




                }


            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                next.setVisibility(View.VISIBLE);
                tim = true;

                ConstraintLayout lay = (ConstraintLayout)findViewById(R.id.layout3);

                if(countdowntimer != null){
                    countdowntimer.cancel();
                }

                if(status==1) {
                    if(ko!=3){
                        ko=1;
                    }
                    lay.setBackgroundColor(Color.GREEN);

                    Toast t = Toast.makeText(Main3Activity.this, "Correct! +1", Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
                    t.show();
                    if(num!=n) {
                        score++;
                        n=num;
                        edit.putInt("prev",n);
                        edit.putInt("score",score);
                        edit.apply();

                    }

                }

                else {
                    if(ko!=3){
                        ko=2;
                    }
                    lay.setBackgroundColor(0xFFED4747);
                    vibrator.vibrate(500);
                    Toast t = Toast.makeText(Main3Activity.this, "Wrong! The right answer is "+fact, Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
                    t.show();
                    if(n!=num) {
                        ko=3;
                        tvs.setText("Your Score = " + score);
                        hscore=pref.getInt("highscore",0);
                        if(hscore<score){
                            hscore=score;

                        }

                        edit.putInt("highscore",hscore);
                        edit.putInt("score",0);
                        edit.putInt("prev",-1);
                        edit.apply();
                        score = 0;
                        n=-1;
                        next.setText("Try Again ?");
                    }




                }

            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                next.setVisibility(View.VISIBLE);
                tim = true;

                ConstraintLayout lay = (ConstraintLayout)findViewById(R.id.layout3);

                if(countdowntimer != null){
                    countdowntimer.cancel();
                }

                if(status==3) {
                    if(ko!=3){
                        ko=1;
                    }
                    lay.setBackgroundColor(Color.GREEN);

                    Toast t = Toast.makeText(Main3Activity.this, "Correct! +1", Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
                    t.show();
                    if(num!=n) {
                        score++;
                        n=num;
                        edit.putInt("prev",n);
                        edit.putInt("score",score);
                        edit.apply();

                    }

                }

                else {
                    if(ko!=3){
                        ko=2;
                    }
                    lay.setBackgroundColor(0xFFED4747);
                    vibrator.vibrate(500);
                    Toast t = Toast.makeText(Main3Activity.this, "Wrong! The right answer is "+fact, Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
                    t.show();
                    if(n!=num) {
                        ko=3;
                        tvs.setText("Your Score = " + score);
                        hscore=pref.getInt("highscore",0);
                        if(hscore<score){
                            hscore=score;

                        }

                        edit.putInt("highscore",hscore);
                        edit.putInt("score",0);
                        edit.putInt("prev",-1);
                        edit.apply();
                        score = 0;
                        n=-1;
                        next.setText("Try Again ?");
                    }



                }

            }
        });
    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ol=0;

            if(ko!=3) {
                Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                startActivity(intent);
            }
            else{
                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(intent);
            }
            ko=0;
            }
    });
    }
    private void startCountDown() {
        countdowntimer = new CountDownTimer(timeleftinmillis, 1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long millisUntilFinished) {
                timeleftinmillis=millisUntilFinished/1000;

                String timeFormatted = String.format(Locale.getDefault(),"%02d",timeleftinmillis);
                tvc.setText("Time Left : " + timeFormatted);


            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                ko=3;
                next.setVisibility(View.VISIBLE);
                tim = true;
                next.setText("Try Again?");
                timeleftinmillis=0;
                String timeFormatted = String.format(Locale.getDefault(),"%02d",timeleftinmillis);
                tvc.setText("Time Left : " + timeFormatted);
                ConstraintLayout lay = (ConstraintLayout)findViewById(R.id.layout3);
                lay.setBackgroundColor(0xFFED4747);
                vibrator.vibrate(500);
                Toast t = Toast.makeText(Main3Activity.this, "Time Up! The right answer is "+fact, Toast.LENGTH_SHORT);
                t.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
                t.show();
                n=num;
                final SharedPreferences pref = getSharedPreferences("The FACTORy", Context.MODE_PRIVATE);
                final SharedPreferences.Editor edit = pref.edit();
                tvs.setText("Your Score = " + score);
                hscore=pref.getInt("highscore",0);
                if(hscore<score){
                    hscore=score;
                    }
                edit.putInt("highscore",hscore);
                edit.putInt("score",0);
                edit.apply();
                score = 0;

            }
        }.start();


    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt("score", score);
        outState.putInt("hscore", hscore);
        outState.putInt("fact", fact);
        outState.putInt("status", status);
        outState.putInt("num", num);
        outState.putInt("n", n);
        outState.putInt("ko",ko);
        outState.putInt("a", a);
        outState.putInt("b", b);
        outState.putInt("c", c);
        outState.putBoolean("tim",tim);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int a=0,b=0,c=0;
        score=savedInstanceState.getInt("score");
        hscore=savedInstanceState.getInt("hscore");
        fact=savedInstanceState.getInt("fact");
        status=savedInstanceState.getInt("status");
        num=savedInstanceState.getInt("num");
        n=savedInstanceState.getInt("n");
        ko=savedInstanceState.getInt("ko");
        a=savedInstanceState.getInt("a");
        b=savedInstanceState.getInt("b");
        c=savedInstanceState.getInt("c");
        tim = savedInstanceState.getBoolean("tim");
        ol=1;
        timeleftinmillis=6200;
        if(ko==0){
            startCountDown();
        }



        ConstraintLayout lay = (ConstraintLayout)findViewById(R.id.layout3);
        if(ko==2||ko==3){
            lay.setBackgroundColor(0xFFED4747);

        }
        else if(ko==1){
            lay.setBackgroundColor(Color.GREEN);
        }
        else{
            lay.setBackgroundColor(Color.WHITE);
        }


            tv1.setText("a) " + a);
            tv2.setText("b) " + b);
            tv3.setText("c) " + c);
if(tim) {
    next.setVisibility(View.VISIBLE);
}
else {
        next.setVisibility(View.INVISIBLE);
    }






    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countdowntimer != null) {
            countdowntimer.cancel();
        }

    }
}
