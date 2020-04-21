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
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    EditText ev;
    Button btn;
    static int fact=1,stat=0,lk;
    int ra2,ra3,ra4,num,r1,status,n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        final SharedPreferences pref = getSharedPreferences("The FACTORy", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = pref.edit();

        ev= findViewById(R.id.evNum);
        btn= findViewById(R.id.btn);
        status = 0;

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                stat=1;


                int a=0 , b=0, c=0;
                if (!(TextUtils.isEmpty(ev.getText().toString()))) {
                    num=Integer.parseInt(ev.getText().toString().trim());
                }
                else {
                    lk = 1;
                }
                if(lk==0) {
                    Random rand = new Random();

                    n = pref.getInt("prev", -1);
                    if (n != num) {

                        if (num > 4) {
                            r1 = rand.nextInt(num / 2 - 1);
                            r1++;
                            do {
                                ra2 = rand.nextInt(num - 1);
                                ra3 = rand.nextInt(num - 1);
                                ra2++;
                                ra3++;

                            } while (num % ra2 == 0 || num % ra3 == 0 || ra2 == ra3);
                            for (int i = r1; i <= num; i++) {
                                if (num % i == 0) {
                                    fact = i;
                                    break;
                                }
                            }
                        } else if (num == 1) {
                            fact = 1;
                            ra3 = 0;
                            ra2 = 0;
                        } else if (num == 2) {
                            fact = 2;
                            ra2 = 0;
                            ra3 = 0;
                        } else if (num == 3) {
                            fact = 3;
                            ra2 = 2;
                            ra3 = 0;
                        } else if (num == 4) {
                            fact = 2;
                            ra2 = 3;
                            ra3 = 0;
                        }
                        edit.putInt("ra2", ra2);
                        edit.putInt("ra3", ra3);
                        edit.putInt("fact", fact);
                        edit.apply();
                    } else {
                        ra2 = pref.getInt("ra2", -1);
                        ra3 = pref.getInt("ra3", -1);
                        fact = pref.getInt("fact", -1);

                    }


                    ra4 = rand.nextInt(3);


                    if (ra4 == 0) {
                        a = ra2;
                        b = fact;
                        c = ra3;
                        status = 1;
                    }
                    if (ra4 == 1) {
                        a = fact;
                        b = ra3;
                        c = ra2;
                        status = 2;
                    }
                    if (ra4 == 2) {
                        a = ra3;
                        b = ra2;
                        c = fact;
                        status = 3;
                    }




                }
                if(lk==0&&num>0) {
                    Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                    intent.putExtra("a", a);
                    intent.putExtra("b", b);
                    intent.putExtra("c", c);
                    intent.putExtra("num", num);
                    intent.putExtra("status", status);
                    intent.putExtra("n", n);
                    intent.putExtra("fact", fact);
                    startActivity(intent);
                }
                else if(lk==1){
                    Toast t = Toast.makeText(Main2Activity.this,"Enter a Number!",Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
                    t.show();
                    lk=0;
                }
                else if(num<1){
                    Toast t = Toast.makeText(Main2Activity.this,"Enter a Positive Number!",Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
                    t.show();
                }

            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt("fact", fact);
        outState.putInt("ra2", ra2);
        outState.putInt("ra3", ra3);
        outState.putInt("ra4", ra4);
        outState.putInt("status", status);
        outState.putInt("num", num);
        outState.putInt("r1", r1);
        outState.putInt("n", n);
        outState.putInt("stat", stat);
        outState.putInt("lk", lk);

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int a=0,b=0,c=0;
        fact=savedInstanceState.getInt("fact");
        stat=savedInstanceState.getInt("stat");
        ra2=savedInstanceState.getInt("ra2");
        ra3=savedInstanceState.getInt("ra3");
        ra4=savedInstanceState.getInt("ra4");
        status=savedInstanceState.getInt("status");
        num=savedInstanceState.getInt("num");
        r1=savedInstanceState.getInt("r1");
        n=savedInstanceState.getInt("n");
        lk=savedInstanceState.getInt("lk");


        if(ra4==0&&stat==1) {
            a=ra2;
            b=fact;
            c=ra3;
            status=1;
        }
        if(ra4==1) {
            a=fact;
            b=ra3;
            c=ra2;
            status=2;
        }
        if(ra4==2) {
            a=ra3;
            b=ra2;
            c=fact;
            status=3;
        }

ConstraintLayout lay = (ConstraintLayout)findViewById(R.id.layout2);
        lay.setBackgroundColor(0x6288D100);
    }
}
