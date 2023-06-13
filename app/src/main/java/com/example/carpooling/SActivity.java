package com.example.carpooling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SActivity extends AppCompatActivity {

    private TextView animatingText;
    Animation animateNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

        init();
    }
    private void init(){
        animatingText = (TextView)findViewById(R.id.textView);
        animateNow = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up_animation);
        animatingText.setAnimation(animateNow);
    }
}