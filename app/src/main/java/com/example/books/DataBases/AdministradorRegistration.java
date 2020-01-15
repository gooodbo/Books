package com.example.books.DataBases;

import android.content.ContentValues;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.books.R;

public class AdministradorRegistration extends Fragment implements View.OnClickListener {

    private View view;
    private EditText loginET;
    private EditText emailEt;
    private EditText passwordFirstET;
    private EditText passwordSecondET;
    private Button asseptBtn;
    private Button canselBtn;
    private AdminsDB adminsDB;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user_admin_registration, container, false);
        loginET = view.findViewById(R.id.login);
        emailEt = view.findViewById(R.id.email);
        passwordFirstET = view.findViewById(R.id.password);
        passwordSecondET = view.findViewById(R.id.password1);
        asseptBtn = view.findViewById(R.id.assept);
        canselBtn = view.findViewById(R.id.cansel);

        adminsDB = new AdminsDB(view.getContext());
        return view;
    }

    @Override
    public void onClick(View v) {
        String login = loginET.getText().toString();
        String passwordFirst = passwordFirstET.getText().toString();
        String passwordSecond = passwordSecondET.getText().toString();
        String email = emailEt.getText().toString();

        SQLiteDatabase database = adminsDB.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        switch (v.getId()) {
            case R.id.cansel:
                getFragmentManager().popBackStack();
                break;
            case R.id.assept:

                if (passwordFirst.equals(passwordSecond)) {
                    contentValues.put(AdminsDB.KEY_LOGIN, login);
                    contentValues.put(AdminsDB.KEY_PASSWORD, passwordFirst);
                    contentValues.put(AdminsDB.KEY_EMAIL, email);
                    database.insert(AdminsDB.TABLE_MEMBERS, null, contentValues);
                    Cursor cursor = database.query(AdminsDB.TABLE_MEMBERS, null, null, null, null, null, null);
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
                        } while (cursor.moveToNext());
                    } else
                        Log.d("mLog", "0 rows");

                    cursor.close();
                } else {
                    Toast.makeText(getContext(),
                            "Пароли не совпадают",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
