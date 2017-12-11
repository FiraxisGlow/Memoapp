package com.example.anton.memoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anton on 06-Dec-17.
 */

/*
Class was created using tutorials from ProgrammingKnowledge
https://www.youtube.com/channel/UCs6nmQViDpUw0nuIx9c_WvA
*/
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "memos.db";
    public static final String TABLE_NAME = "memo_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "MEMO";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    // Creates database instance
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, MEMO TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Method queries database to insert user written memos
    public boolean insertMemo(String memo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, memo);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    // Method queries database for memos
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor memos = db.rawQuery("select MEMO from " + TABLE_NAME, null);
        return memos;
    }
}
