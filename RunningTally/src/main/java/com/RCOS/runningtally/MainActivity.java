package com.RCOS.runningtally;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button bt100, bt100h, bt110h, bt200, bt300h, bt400, bt400h,
    bt800, bt1500, bt3000, bt3000s, bt5000, bt10000, bt4x100, bt4x400;
    private String event_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt100 = (Button)findViewById(R.id.t100);
        bt100h = (Button)findViewById(R.id.t100h);
        bt110h = (Button)findViewById(R.id.t110h);
        bt200 = (Button)findViewById(R.id.t200);
        bt300h = (Button)findViewById(R.id.t300h);
        bt400 = (Button)findViewById(R.id.t400);
        bt400h = (Button)findViewById(R.id.t400h);
        bt800 = (Button)findViewById(R.id.t800);
        bt1500 = (Button)findViewById(R.id.t1500);
        bt3000 = (Button)findViewById(R.id.t3000);
        bt3000s = (Button)findViewById(R.id.t3000s);
        bt5000 = (Button)findViewById(R.id.t5000);
        bt10000 = (Button)findViewById(R.id.t10000);
        bt4x100 = (Button)findViewById(R.id.t4x100);
        bt4x400 = (Button)findViewById(R.id.t4x400);

        bt100.setOnClickListener(this);
        bt100h.setOnClickListener(this);
        bt110h.setOnClickListener(this);
        bt200.setOnClickListener(this);
        bt300h.setOnClickListener(this);
        bt400.setOnClickListener(this);
        bt400h.setOnClickListener(this);
        bt800.setOnClickListener(this);
        bt1500.setOnClickListener(this);
        bt3000.setOnClickListener(this);
        bt3000s.setOnClickListener(this);
        bt5000.setOnClickListener(this);
        bt10000.setOnClickListener(this);
        bt4x100.setOnClickListener(this);
        bt4x400.setOnClickListener(this);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onClick(View view) {

        if (view == bt100)
            event_name = "t100";
        else if (view == bt100h)
            event_name = "t100h";
        else if (view == bt110h)
            event_name = "t110h";
        else if (view == bt200)
            event_name = "t200";
        else if (view == bt300h)
            event_name = "t300h";
        else if (view == bt400)
            event_name = "t400";
        else if (view == bt400h)
            event_name = "t400h";
        else if (view == bt800)
            event_name = "t800";
        else if (view == bt1500)
            event_name = "t1500";
        else if (view == bt3000)
            event_name = "t3000";
        else if (view == bt3000s)
            event_name = "t3000s";
        else if (view == bt5000)
            event_name = "t5000";
        else if (view == bt10000)
            event_name = "t10000";
        else if (view == bt4x100)
            event_name = "t4x100";
        else if (view == bt4x400)
            event_name = "t4x400";
        else
            event_name = "null";
        Intent event = new Intent(this, Timer.class);
        event.setType("text/plain");
        event.putExtra(android.content.Intent.EXTRA_TEXT, event_name);
        startActivity(event);
    }
    /*
    public void startTimer(View view) {
        Intent event = new Intent(this, Timer.class);
        event.setType("text/plain");
        event.putExtra(android.content.Intent.EXTRA_TEXT, "test");
        Toast.makeText(getApplicationContext(), "timer act", Toast.LENGTH_SHORT).show();
        startActivity(event);
    }
    */
    
}
