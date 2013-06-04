package com.RCOS.runningtally;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Chronometer;


/**
 * Created by steve on 5/31/13.
 */
public class Timer extends Activity {

    private Chronometer timer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button start;
        Button stop;
        Button reset;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        String event = extras.getString(Intent.EXTRA_TEXT);
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
        }
    };

    View.OnClickListener resetListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            timer1.setBase(SystemClock.elapsedRealtime());
        }
    };
}
