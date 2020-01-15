package com.example.books.DataBases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsersDB extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "users";
    public static final String TABLE_MEMBERS = "members";

    public static final String KEY_ID = "_id";
    public static final String LOGIN = "login";
    public static final String KEY_EMAIL = "email";
    public static final String PASSWORD = "password";

    public UsersDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_MEMBERS + "(" + KEY_ID
                + " integer primary key," + LOGIN + " text,"
                + " text," + KEY_EMAIL + " text,"
                + " text," + PASSWORD + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_MEMBERS);
        onCreate(db);
    }
}
