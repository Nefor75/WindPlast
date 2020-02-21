package com.glumy.windplast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        }
        public void onClick(View view){
            Intent i = new Intent(ActivityMain.this, ActivityProductDetails.class);
            startActivity(i);
          }
}
