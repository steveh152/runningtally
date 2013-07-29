package com.RCOS.runningtally;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by steve on 6/17/13.
 */
public class Results extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

    }

    public void byEvent(View view) {
        Intent by_event = new Intent(this, ResEvents.class);
        startActivity(by_event);
    }

    public void byAthlete(View view) {
        Intent by_athlete = new Intent(this, ResAthletes.class);
        startActivity(by_athlete);
    }
}
