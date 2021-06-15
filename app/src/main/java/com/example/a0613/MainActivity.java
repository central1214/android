package com.example.a0613;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startBtn;
    TextView title;
    TextView back_ground;
    TextView movingText;
    EditText eText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pan);
        startBtn = findViewById(R.id.start_btn);
        title = findViewById(R.id.title_led);
        back_ground = findViewById(R.id.background);
        movingText = findViewById(R.id.movingText);
        eText = findViewById(R.id.sacntext);
        startBtn.setOnClickListener(this);
        Typeface tf = Typeface.createFromAsset(getAssets(),"tf_font.ttf");
        movingText.setTypeface(tf);
        title.setTypeface(tf);

        eText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                switch (i){
                    case KeyEvent.KEYCODE_ENTER:
                        startBtn.callOnClick();
                        hidekeyboard(eText);
                }
                return true;
            }
        });
    }

    private void hidekeyboard(EditText et){
        InputMethodManager imm= (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
    }
    @Override
    public void onClick(View v) {
        if(v==startBtn){
                movingText.setText(eText.getText());
                back_ground.setVisibility(View.VISIBLE);
                movingText.setVisibility(View.VISIBLE);
                Animation ggam = AnimationUtils.loadAnimation(this, R.anim.ggam);
                movingText.startAnimation(ggam);

        }
    }
}