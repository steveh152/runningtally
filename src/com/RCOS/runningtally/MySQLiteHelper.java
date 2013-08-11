package com.RCOS.runningtally;

/**
 * Created by steve on 6/20/13.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class MySQLiteHelper extends SQLiteOpenHelper {

    public MySQLiteHelper(Context context) {
        super(context, "Athlete Table", null, 1);
    }

    /* Creates the table
     * layout:
     *
     *   _id        - key            - time
     *   athlete    - athlete text   - athlete time
     */
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("CREATE TABLE athletes (_id INTEGER PRIMARY KEY AUTOINCREMENT, athlete TEXT NOT NULL);");
//---------->------------>------------->------------>------------->------------->-------------->-------------->THIS^^^ (", time INTEGER")
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        Log.w(MySQLiteHelper.class.getName(), "Upgrading database from version " + oldVer
        + " to " + newVer + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS athletes");
        onCreate(db);
    }

}
