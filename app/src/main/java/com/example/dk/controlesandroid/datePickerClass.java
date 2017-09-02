package com.example.dk.controlesandroid;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.TimePicker;


public class datePickerClass extends AppCompatActivity {


    Button boton;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        boton = (Button) findViewById(R.id.botonPicker);
        datePicker = (DatePicker) findViewById(R.id.datePicker);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int d = datePicker.getDayOfMonth();
                int m = datePicker.getMonth() + 1;
                String mes = "";
                switch (m) {
                    case 1:
                        mes = "Enero";
                        break;
                    case 2:
                        mes = "Febrero";
                        break;
                    case 3:
                        mes = "Marzo";
                        break;
                    case 4:
                        mes = "Abril";
                        break;
                    case 5:
                        mes = "Mayo";
                        break;
                    case 6:
                        mes = "Junio";
                        break;
                    case 7:
                        mes = "Julio";
                        break;
                    case 8:
                        mes = "Agosto";
                        ;
                        break;
                    case 9:
                        mes = "Septiembre";
                        break;
                    case 10:
                        mes = "Octubre";
                        break;
                    case 11:
                        mes = "Noviembre";
                        break;
                    case 12:
                        mes = "Diciembre";
                        break;
                    default:
                        mes = "null";
                        break;
                }
                int y = datePicker.getYear();


                Toast.makeText(datePickerClass.this, d + " de " + mes + " del año " + y, Toast.LENGTH_LONG).show();
            }
        });
    }
}
