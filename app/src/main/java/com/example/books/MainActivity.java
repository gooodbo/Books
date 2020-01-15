package com.example.books;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.books.Fragments.MainFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentTransaction transaction;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        MainFragment homeFragmet = new MainFragment();
        transaction.add(R.id.frameMain, homeFragmet);
        transaction.commit();

    }
}
