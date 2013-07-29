package com.RCOS.runningtally;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.database.sqlite.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toEvents(View view) {
        //Toast.makeText(getApplicationContext(), "going to activity...", Toast.LENGTH_SHORT).show();
        Intent to_event = new Intent(this, Events.class);
        startActivity(to_event);
    }

    public void toResults(View view) {
        Intent to_results = new Intent(this, Results.class);
        startActivity(to_results);
    }
}
