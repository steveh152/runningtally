package com.RCOS.runningtally;

/**
 * Created by steve on 6/20/13.
 */

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CommentsDataSource {

    // database fields
    private SQLiteDatabase db;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.Col_ID, MySQLiteHelper.Col_Comment};

    // constructor
    public CommentsDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }
}
