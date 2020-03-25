package com.glumy.windplast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.TimeUnit;

public class ActivitySplash extends AppCompatActivity {

    private Animation anim;
    private Animation slideInLeftAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startActivityMainDelay();
    }

        private void startActivityMainDelay() {
            anim = AnimationUtils.loadAnimation(this, R.anim.tv_animation);
            slideInLeftAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    runOnUiThread(run_tv_bottom);
                    TimeUnit.SECONDS.sleep(3);
                    runOnUiThread(run_iv_center);
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
            ImageView imageView = findViewById(R.id.image_top);
            tv_bottom.setVisibility(View.VISIBLE);
            tv_bottom.startAnimation(anim);
            imageView.setImageResource(R.drawable.image_top);
            imageView.setVisibility(View.VISIBLE);
            imageView.startAnimation(anim);
        }
    };

    Runnable run_iv_center = new Runnable() {
        public void run() {
            ImageView imageView = findViewById(R.id.image_slide_center);
            imageView.setImageResource(R.drawable.image_splash);
            imageView.startAnimation(slideInLeftAnimation);

        }
    };

    Runnable run_activity_main = new Runnable() {
        public void run() {
            Intent i = new Intent(ActivitySplash.this, ActivityMain.class);
                startActivity(i);
                finish();// kill current activity
        }
    };

 }


