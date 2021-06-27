package com.example.a0613;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class ledActivity extends AppCompatActivity {
    TextView back_ground;
    TextView movingText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();
        String str = intent.getExtras().getString("printText");
        String color = intent.getExtras().getString("textColor");
        String fontPath = intent.getExtras().getString("fontPath");


        movingText = findViewById(R.id.movingText);
        Typeface tf = Typeface.createFromAsset(getAssets(),fontPath);
        movingText.setTypeface(tf);

        View view = findViewById(R.id.led_layout);
        view.setSystemUiVisibility((View.SYSTEM_UI_FLAG_FULLSCREEN));
        view.setSystemUiVisibility((View.SYSTEM_UI_FLAG_HIDE_NAVIGATION));



        movingText.setText(str);
        movingText.setTextColor(Color.parseColor(color));
        Animation ggam = AnimationUtils.loadAnimation(this, R.anim.ggam);
        movingText.startAnimation(ggam);
    }
}