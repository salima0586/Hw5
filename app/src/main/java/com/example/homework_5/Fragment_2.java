package com.example.homework_5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Fragment_2 extends Fragment {


    private TextView textView;
    private Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.txt_fr2);
        button = view.findViewById(R.id.btn_fr2);


        Bundle bundle = this.getArguments();
        String data = bundle.getString("key");
        textView.setText(data);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key1",textView.getText().toString());

                Fragment_3 fragment3 = new Fragment_3();
                fragment3.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fr_container,fragment3).commit();
            }
        });
    }
}