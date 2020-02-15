package com.glumy.windplast;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.TimeUnit;

public class ActivitySplash extends AppCompatActivity {

    private Animation anim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startActivityMainDelay();
    }

        private void startActivityMainDelay() {
            anim = AnimationUtils.loadAnimation(this, R.anim.tv_animation);

        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    runOnUiThread(run_tv_bottom);
                    TimeUnit.SECONDS.sleep(3);
                    runOnUiThread(run_tv_center);
                    TimeUnit.SECONDS.sleep(3);
                    runOnUiThread(run_activity_main);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    Runnable run_tv_bottom = new Runnable() {
        public void run() {
           TextView tv_bottom = findViewById(R.id.tv_as_bottom_line);
            tv_bottom.setVisibility(View.VISIBLE);
            tv_bottom.startAnimation(anim);
        }
    };

    Runnable run_tv_center = new Runnable() {
        public void run() {
            makeTextSwitcher();
        }
    };

    Runnable run_activity_main = new Runnable() {
        public void run() {
            Intent i = new Intent(ActivitySplash.this, ActivityMain.class);
                startActivity(i);
                finish();// kill current activity
        }
    };

    private void makeTextSwitcher(){
        Animation slideInLeftAnimation = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);

        TextSwitcher mTextSwitcher = findViewById(R.id.txt_switcher);
        mTextSwitcher.setInAnimation(slideInLeftAnimation);

        mTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(ActivitySplash.this);
                textView.setTextSize(60);
                textView.setTextColor(Color.RED);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
                textView.setShadowLayer(10, 10, 10, Color.BLACK);
                return textView;
            }
        });
        mTextSwitcher.setText(getText(R.string.app_name));
    }

}


