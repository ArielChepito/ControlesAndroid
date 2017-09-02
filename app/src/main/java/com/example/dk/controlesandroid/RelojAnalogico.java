package com.example.dk.controlesandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class RelojAnalogico extends AppCompatActivity {

    Button btnDameHora;
    TimePicker hora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reloj_analogico);
        btnDameHora = (Button)findViewById(R.id.btnReloj);
        hora = (TimePicker) findViewById(R.id.timePickeranal                                                                                                                                                                                                                                                                                                                               );

        btnDameHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hora.clearFocus();
                String horax  = hora.getCurrentHour()+"";
                String minutos = hora.getCurrentMinute()+ "";

                Toast.makeText(RelojAnalogico.this, horax + ":"+minutos,Toast.LENGTH_LONG).show();

            }
        });
    }
}
