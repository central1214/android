package com.example.led;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
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

        Intent intent = getIntent();//MainActivity에서 데이터 가져오기
        String str = intent.getExtras().getString("printText"); //출력할 내용
        String color = intent.getExtras().getString("textColor");// 출력할 색
        String fontPath = intent.getExtras().getString("fontPath");// 출력할 폰트


        movingText = findViewById(R.id.movingText);
        Typeface tf = Typeface.createFromAsset(getAssets(),fontPath);
        movingText.setTypeface(tf); // Main에서 가져온 폰트 씌우기

        View view = findViewById(R.id.led_layout);
        view.setSystemUiVisibility((View.SYSTEM_UI_FLAG_FULLSCREEN)); // 풀스크린으로
        view.setSystemUiVisibility((View.SYSTEM_UI_FLAG_HIDE_NAVIGATION));// 네비게이션 바 숨기기



        movingText.setText(str);
        movingText.setTextColor(Color.parseColor(color));
        Animation ggam = AnimationUtils.loadAnimation(this, R.anim.ggam); // 에니메이션 효과 가져오기
        movingText.startAnimation(ggam); // movingText에 ggam 에니메이션 효과 주기
    }
}