package com.example.dk.controlesandroid;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Random;

public class timePicker extends AppCompatActivity {


    Button boton;
    TimePicker reloj1;
    TimePicker reloj2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        boton = (Button) findViewById(R.id.btnHora);
        reloj1 = (TimePicker) findViewById(R.id.txtTime);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                boton.setBackgroundColor(color);
                String hora  = reloj1.getCurrentHour()+"";
                String minutos = reloj1.getCurrentMinute()+ "";

                Toast.makeText(timePicker.this, hora + ":"+minutos ,Toast.LENGTH_LONG).show();
            }
        });

    }
}
