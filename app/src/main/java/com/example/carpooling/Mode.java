package com.example.carpooling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mode extends AppCompatActivity {
    Button btn_driver;
    Button btn_passenger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);
        btn_driver = findViewById(R.id.selectDriverButton);
        btn_passenger = findViewById(R.id.selectPassengerButon);

        btn_driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mode.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_passenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mode.this, ViewRides.class);
                startActivity(intent);
                finish();
            }
        });

    }
}