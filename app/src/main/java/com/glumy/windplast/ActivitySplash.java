package com.glumy.windplast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.TimeUnit;

public class ActivitySplash extends AppCompatActivity {

    private Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initComponent();
        startActivityMainDelay();
    }

    private void initComponent(){
        anim = AnimationUtils.loadAnimation(this,R.anim.tv_animation);
    }

    private void startActivityMainDelay() {

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
            TextView tv_center = findViewById(R.id.windplast);
            tv_center.setVisibility(View.VISIBLE);
            tv_center.startAnimation(anim);
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


