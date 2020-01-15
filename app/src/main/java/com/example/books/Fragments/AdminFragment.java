package com.example.books.Fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;


import com.example.books.DataBases.Administrator;
import com.example.books.DataBases.AdminsDB;
import com.example.books.R;

import java.util.LinkedList;
import java.util.List;

public class AdminFragment extends Fragment {
    private View view;
    private EditText loginET;
    private EditText passwordET;
    private AdminsDB adminsDB;

    public AdminFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_administrator, container, false);
        loginET = view.findViewById(R.id.login);
        passwordET = view.findViewById(R.id.password);
        adminsDB = new AdminsDB(view.getContext());

        final SQLiteDatabase database = adminsDB.getWritableDatabase();
        final Cursor cursor = database.query(adminsDB.TABLE_MEMBERS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(AdminsDB.KEY_ID);
            int loginIndex = cursor.getColumnIndex(AdminsDB.KEY_LOGIN);
            int passwordIndex = cursor.getColumnIndex(AdminsDB.KEY_PASSWORD);
            int emailIndex = cursor.getColumnIndex(AdminsDB.KEY_EMAIL);
            do {
                Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                        ", login = " + cursor.getString(loginIndex) +
                        ", password = " + cursor.getString(passwordIndex) +
                        ", email = " + cursor.getString(emailIndex));
                Administrator administrator = new Administrator();
                administrator.setLogin(cursor.getString(loginIndex));
                administrator.setPassword(cursor.getString(passwordIndex));
                administrator.setEmail(cursor.getString(emailIndex));


            } while (cursor.moveToNext());
        } else
            Log.d("mLog", "0 rows");
        database.close();
        cursor.close();


        return view;
    }
}
