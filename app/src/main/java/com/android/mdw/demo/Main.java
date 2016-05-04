package com.android.mdw.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnIniSound = (Button) findViewById(R.id.btnInicio);
        Button btnIniMusic = (Button) findViewById(R.id.btnIniMusic);
        Button btnFin = (Button) findViewById(R.id.btnFin);

        btnIniSound.setOnClickListener(this);
        btnIniMusic.setOnClickListener(this);
        btnFin.setOnClickListener(this);
    }

    public void onClick(View src) {

        switch (src.getId()) {
            case R.id.btnInicio:
                Toast.makeText(this, R.string.iniSound, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, BroadcastService.class);
                intent.putExtra("btnini", R.id.btnInicio);
                //startService(intent);
                sendBroadcast(intent);
                break;
            case R.id.btnIniMusic:
                Toast.makeText(this, R.string.iniMusic, Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, BroadcastService.class);
                intent1.putExtra("btnini", R.id.btnIniMusic);
                //startService(intent1);
                sendBroadcast(intent1);
                break;
            case R.id.btnFin:
                sendBroadcast(new Intent(this, BroadcastService.class));
                //stopService(new Intent(this, ElServicio.class));
                break;
        }
    }
}