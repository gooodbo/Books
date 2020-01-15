package com.example.books.DataBases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BooksDB extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "books";
    public static final String TABLE_MEMBERS = "books";

    public static final String KEY_ID = "_id";
    public static final String BOOK_NAME = "name";
    public static final String BOOK_AUTHOR = "email";

    public BooksDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_MEMBERS + "(" + KEY_ID
                + " integer primary key," + BOOK_NAME + " text,"
                + " text," + BOOK_AUTHOR + " text,"
                + " text," + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_MEMBERS);
        onCreate(db);
    }
}
