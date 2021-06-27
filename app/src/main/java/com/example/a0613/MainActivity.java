package com.example.a0613;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startBtn;
    Button colorBtn;
    Button fontBtn;
    TextView title;
    EditText eText;
    View main;
    String color;
    String fontPath;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pan);
        main = findViewById(R.id.pan);
        startBtn = findViewById(R.id.start_btn);
        colorBtn = findViewById(R.id.color_btn);
        fontBtn = findViewById(R.id.font_btn);
        title = findViewById(R.id.title_led);
        eText = findViewById(R.id.scantext);
        startBtn.setOnClickListener(this);
        color = "#FF6200EE";
        fontPath = "tf_font.ttf";
        Typeface amatics = Typeface.createFromAsset(getAssets(),"amatics2.ttf");
        Typeface bear = Typeface.createFromAsset(getAssets(),"bear_rabbit.ttf");
        Typeface drfont = Typeface.createFromAsset(getAssets(),"drfont.ttf");
        Typeface helloPop = Typeface.createFromAsset(getAssets(),"helloPop.ttf");
        Typeface tf_font = Typeface.createFromAsset(getAssets(),"tf_font.ttf");
        Typeface puddingP = Typeface.createFromAsset(getAssets(),"THEpuddingP.otf");
        Typeface pudiingW = Typeface.createFromAsset(getAssets(),"THEpuddingW.otf");



        title.setTypeface(amatics);

        colorBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                View dialogView = getLayoutInflater().inflate(R.layout.color_dialog, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                Button btn1 = alertDialog.findViewById(R.id.btn1);
                Button btn2 = alertDialog.findViewById(R.id.btn2);
                Button btn3 = alertDialog.findViewById(R.id.btn3);
                Button btn4 = alertDialog.findViewById(R.id.btn4);

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        color = "#FF6200EE";
                        alertDialog.dismiss();
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        color = "#D600EE";
                        alertDialog.dismiss();
                    }
                });
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        color = "#18EE00";
                        alertDialog.dismiss();
                    }
                });
                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        color = "#00EED2";
                        alertDialog.dismiss();
                    }
                });

            }
        });
        fontBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View fontDialog = getLayoutInflater().inflate(R.layout.font_dialog, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(fontDialog);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                Button fBtn1 = alertDialog.findViewById(R.id.font_btn1);
                Button fBtn2 = alertDialog.findViewById(R.id.font_btn2);
                Button fBtn3 = alertDialog.findViewById(R.id.font_btn3);
                Button fBtn4 = alertDialog.findViewById(R.id.font_btn4);
                Button fBtn5 = alertDialog.findViewById(R.id.font_btn5);
                Button fBtn6 = alertDialog.findViewById(R.id.font_btn6);
                Button fBtn7 = alertDialog.findViewById(R.id.font_btn7);

                fBtn1.setTypeface(bear);
                fBtn2.setTypeface(drfont);
                fBtn3.setTypeface(amatics);
                fBtn4.setTypeface(helloPop);
                fBtn5.setTypeface(tf_font);
                fBtn6.setTypeface(puddingP);
                fBtn7.setTypeface(pudiingW);


                fBtn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fontPath = "bear_rabbit.ttf";
                        alertDialog.dismiss();
                    }
                });
                fBtn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fontPath = "drfont.ttf";
                        alertDialog.dismiss();
                    }
                });
                fBtn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fontPath = "amatics2.ttf";
                        alertDialog.dismiss();
                    }
                });
                fBtn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fontPath = "helloPop.ttf";
                        alertDialog.dismiss();
                    }
                });
                fBtn5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fontPath = "tf_font.ttf";
                        alertDialog.dismiss();
                    }
                });
                fBtn6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fontPath = "THEpuddingP.otf";
                        alertDialog.dismiss();
                    }
                });
                fBtn7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fontPath = "THEpuddingW.otf";
                        alertDialog.dismiss();
                    }
                });


            }
        });




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
            Intent intent = new Intent(MainActivity.this, ledActivity.class);
            intent.putExtra("printText",eText.getText().toString());
            intent.putExtra("textColor",color);
            intent.putExtra("fontPath", fontPath);
            startActivity(intent);
        }
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

}