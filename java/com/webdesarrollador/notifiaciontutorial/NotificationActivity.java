package com.webdesarrollador.notifiaciontutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Hashtable;

/**
 * Created by raulrevillas on 13/01/2017.
 */

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Hashtable<String, String> agenda = new Hashtable<String, String>();
        agenda.put("Juan","665 555 555");
        agenda.put("Eva","667 777 777");

        String name="";
        Bundle extras = getIntent().getExtras();

        if(extras != null)
            name = extras.getString("nombre");

        TextView mensaje = (TextView) findViewById(R.id.mensaje);
        TextView telefono = (TextView) findViewById(R.id.telefono);

        mensaje.setText("Te ha llamado "+name);
        telefono.setText("Tlf: "+agenda.get(name));
    }
}
