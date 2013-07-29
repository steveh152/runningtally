package com.RCOS.runningtally;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.RCOS.runningtally.DAO;
import com.RCOS.runningtally.Athlete;
import com.RCOS.runningtally.ListAdapter;

/**
 * Created by steve on 6/17/13.
 */
public class ResAthletes extends ListActivity {

    private DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_athletes);
        dao = new DAO(this);
        setListAdapter(new com.RCOS.runningtally.ListAdapter(this, dao.getAthletes()));
    }

    protected void onListItemClick(ListView l, View v, int pos, long id) {
    	Athlete athlete = (Athlete)getListAdapter().getItem(pos);
    	dao.deleteAthlete(athlete.getId());
    	setListAdapter(new ListAdapter(this, dao.getAthletes()));
    	Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();
    }
    /*
    public void onClick(ListView l, View v, int position, long id) {
        // athlete that was clicked
        Toast.makeText(getApplicationContext(), "do stuff", Toast.LENGTH_SHORT).show();
    }
    */

}

