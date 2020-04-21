package com.example.thefactory;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static int hscore;
    TextView tvhs;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout lay = (ConstraintLayout)findViewById(R.id.layout);
        final SharedPreferences pref = getSharedPreferences("The FACTORy", Context.MODE_PRIVATE);
        hscore=pref.getInt("highscore",0);

        tvhs = findViewById(R.id.hscore);
        tvhs.setText("High Score : "+hscore);

        lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt("hscore", hscore);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        hscore=savedInstanceState.getInt("hscore");
    tvhs.setText("High Score : "+hscore);
    }


}
