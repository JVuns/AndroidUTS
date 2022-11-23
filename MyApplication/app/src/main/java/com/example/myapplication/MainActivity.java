package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button goToOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goToOne = (Button) findViewById(R.id.goToOne);

        goToOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondActivity = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(secondActivity);
            }
        });
    }
}