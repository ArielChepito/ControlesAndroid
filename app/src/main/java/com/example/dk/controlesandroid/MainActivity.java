package com.example.dk.controlesandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btnCalendario);
        btn2 = (Button)findViewById(R.id.btnRelojDigital);
        btn3 = (Button)findViewById(R.id.btnDatePicker);
        btn4 = (Button)findViewById(R.id.btnSpinner);
        btn5 = (Button)findViewById(R.id.btnToggleButtons);
        btn6 = (Button)findViewById(R.id.btnTimePicker);
        btn7 = (Button)findViewById(R.id.btnRelojAnalogico);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btn1 = new Intent(MainActivity.this, Calendario.class);
                startActivity(btn1);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btn2 = new Intent(MainActivity.this, RelojDigital.class);
                startActivity(btn2);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btn3 = new Intent(MainActivity.this, datePickerClass.class);
                startActivity(btn3);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btn4 = new Intent(MainActivity.this, spinner.class);
                startActivity(btn4);

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btn5 = new Intent(MainActivity.this, ToggleButtons.class);
                startActivity(btn5);

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btn6 = new Intent(MainActivity.this, timePicker.class);
                startActivity(btn6);

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btn7 = new Intent(MainActivity.this, RelojAnalogico.class);
                startActivity(btn7);

            }
        });

    }
}
