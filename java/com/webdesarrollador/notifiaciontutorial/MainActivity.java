package com.webdesarrollador.notifiaciontutorial;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button botonJuan = (Button) findViewById(R.id.botonJuan);
        final Button botonEva = (Button) findViewById(R.id.botonEva);

        botonJuan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enviarNotificacion("Juan");
            }
        });

        botonEva.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enviarNotificacion("Eva");
            }
        });
    }

    private void enviarNotificacion (String nombre){

        NotificationCompat.Builder builder =
            new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                //.setLargeIcon((((BitmapDrawable)getResources().getDrawable(R.drawable.wordpress)).getBitmap()))
                .setContentTitle("Llamada")
                .setContentText("llamada de "+nombre)
                .setAutoCancel(true);

        int notifyID =1;

        Intent notificationIntent = new Intent(this, NotificationActivity.class);
        //Pasamos el nombre de la persona como extra
        notificationIntent.putExtra("nombre", nombre);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        //Emitiemos la notificación
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notifyID, builder.build());
    }
}


