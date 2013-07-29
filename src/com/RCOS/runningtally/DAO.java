package com.RCOS.runningtally;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steve on 7/13/13.
 */
public class DAO {

    private SQLiteDatabase db;
    private MySQLiteHelper dbHelper;

    public DAO(Context context) {
        dbHelper = new MySQLiteHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public void createAthlete(String name) {
        ContentValues values = new ContentValues();
        values.put("athlete", name);
        db.insert("athletes", null, values);
    }

    public void deleteAthlete(int id) {
        db.delete("athletes", "_id = " + id, null);
    }

    public List getAthletes() {
        List athleteList = new ArrayList();

        // name of columns we want to select:
        String[] tableColumns = new String[] {"_id", "athlete"};

        // query database
        Cursor cursor = db.query("athletes", tableColumns, null, null, null, null, null);
        cursor.moveToFirst();

        // iterate the results
        while (!cursor.isAfterLast()) {
            Athlete athlete = new Athlete();
            // take values from db
            athlete.setId(cursor.getInt(0));
            athlete.setName(cursor.getString(1));
            // add to db
            athleteList.add(athlete);
            // move to next result
            cursor.moveToNext();
        }
        return athleteList;
    }
}
