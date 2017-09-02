package com.example.dk.controlesandroid;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleButtons extends AppCompatActivity {
    static ImageView imageView;
    View root;

    public static Camera cam = null;// has to be static, otherwise onDestroy() destroys it

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_buttons);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[] {Manifest.permission.CAMERA}, 1);
            }
        }

        View someView = findViewById(R.id.layoutToggle);// get Any child View
        // Find the root view
         root = someView.getRootView();
        imageView =  (ImageView) findViewById(R.id.imageView);
        imageView.setImageDrawable(null);
        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    imageView.setImageResource(R.drawable.onlamp);
                    // Set the color
                    root.setBackgroundColor(getResources().getColor(android.R.color.black));
                    flashLightOn(root);
                    turnOnNotification();



                } else {
                    imageView.setImageResource(R.drawable.offlamp);
                    root.setBackgroundColor(getResources().getColor(android.R.color.white));
                    flashLightOff(root);
                    turnOffNotification();
                }
            }
        });

    }


    private void turnOnNotification() {

        /*bibliografica*/
        /*http://androcode.es/2012/09/notificaciones-metodo-tradicional-notification-builder-y-jelly-bean/*/
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.drawable.onlamp)
                .setPriority(Notification.PRIORITY_LOW)
                .setContentTitle("Luces encendidas!!")
                .setContentText("La mejor fuente de luz ")
                .setContentInfo("Info")
                .setOngoing(false);

        Notification.InboxStyle n = new Notification.InboxStyle(builder)
                .setBigContentTitle("Luces encendidas")
                .setSummaryText("La bombilla que va a romper todos los esquemas esta funcionando.");

            /*verde 0xff00ff00*/
            /*rojo 0xFFFF0000*/
        builder.setLights(0xff00ff00, 300, 100); /*Hexadecimal es verde creo...0xFFFF0000 es rojo*/
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());
    }
    private void turnOffNotification() {


    }


    public void flashLightOn(View view) {

        try {
            if (getPackageManager().hasSystemFeature(
                    PackageManager.FEATURE_CAMERA_FLASH)) {
                cam = Camera.open();
                Camera.Parameters p = cam.getParameters();
                p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                cam.setParameters(p);
                cam.startPreview();
            }
        } catch (Exception e) {
            e.printStackTrace();
            ///Toast.makeText(getBaseContext(), "Exception flashLightOn():"+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    public void flashLightOff(View view) {
        try {
            if (getPackageManager().hasSystemFeature(
                    PackageManager.FEATURE_CAMERA_FLASH)) {
                cam.stopPreview();
                cam.release();
                cam = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //Toast.makeText(getBaseContext(), "Exception flashLightOff"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
