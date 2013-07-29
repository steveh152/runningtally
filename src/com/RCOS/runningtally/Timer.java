package com.RCOS.runningtally;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Chronometer;
import android.database.*;

/**
 * Created by steve on 5/31/13.
 */
public class Timer extends Activity {

    private Chronometer timer1;
    private long time1;
    private String event;
    private String name1;
    private EditText name1txt;
    private MySQLiteHelper myhelper = null;
    private DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dao = new DAO(this);
        Button start;
        Button stop;
        Button reset;
        Button store;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        event = extras.getString(Intent.EXTRA_TEXT);
        if (event != null) {
            Toast.makeText(getApplicationContext(), "event: " + event, Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "event not recognized", Toast.LENGTH_SHORT).show();
        }

        timer1 = (Chronometer)findViewById(R.id.timer_1);
        start = (Button)findViewById(R.id.start);
        start.setOnClickListener(startListener);
        stop = (Button)findViewById(R.id.stop);
        stop.setOnClickListener(stopListener);
        reset = (Button)findViewById(R.id.reset);
        reset.setOnClickListener(resetListener);
        store = (Button)findViewById(R.id.store);
        store.setOnClickListener(storeAthlete);
        name1txt = (EditText)findViewById(R.id.name1);

    }
    private void showElapsedTime(Chronometer timer, long time) {
        long elapsedMillis = SystemClock.elapsedRealtime() - timer.getBase();
        Toast.makeText(getApplicationContext(), "Elapsed milliseconds: " + elapsedMillis,
                Toast.LENGTH_SHORT).show();
        time = elapsedMillis;
    }

    View.OnClickListener startListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            timer1.setBase(SystemClock.elapsedRealtime());
            timer1.start();
        }
    };

    View.OnClickListener stopListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            timer1.stop();
            showElapsedTime(timer1, time1);
            name1 = name1txt.getText().toString();
            Toast.makeText(getApplicationContext(), "name:" + name1, Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener resetListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            timer1.setBase(SystemClock.elapsedRealtime());
        }
    };

    View.OnClickListener storeAthlete = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String athleteTextValue = name1txt.getText().toString();
            dao.createAthlete(athleteTextValue);
            Toast.makeText(getApplicationContext(), "athlete added", Toast.LENGTH_SHORT).show();
            //dao.close();
        }
    };

}
