package com.example.books.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.books.R;

public class MainFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button adminBtn;
    private Button userBtn;
    private AdminFragment adminFragment;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        adminBtn = view.findViewById(R.id.adminBtn);
        userBtn = view.findViewById(R.id.userBtn);
        adminBtn.setOnClickListener(this);
        userBtn.setOnClickListener(this);
        adminFragment = new AdminFragment();


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.adminBtn:
                getFragmentManager().beginTransaction().replace(R.id.frameMain, adminFragment).addToBackStack(null).commit();
                break;
            case R.id.userBtn:
                break;
        }
    }
}
