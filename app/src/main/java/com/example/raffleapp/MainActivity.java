package com.example.raffleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    public void doRaffle(View view) {
        TextView textResult = findViewById(R.id.textResult);
        EditText range1 = findViewById(R.id.editRange1);
        EditText range2 = findViewById(R.id.editRange2);
        int randomMin = Integer.parseInt(range1.getText().toString());
        int randomMax = Integer.parseInt(range2.getText().toString()) - randomMin + 1;
        if(randomMin >= (randomMax + randomMin) || randomMax < 0 || randomMin < 0)
            textResult.setText("Invalid values");
        else {
            int random = new Random().nextInt(randomMax) + randomMin;
            Log.d("msg", Integer.toString(randomMax));
            textResult.setText(Integer.toString(random));
        }
    }
}