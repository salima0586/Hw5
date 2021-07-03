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

import org.w3c.dom.Text;


public class Fragment_3 extends Fragment {

    private TextView textView;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.txt_fr3);
        button = view.findViewById(R.id.btn_fr3);

        Bundle bundle = this.getArguments();
        String data = bundle.getString("key1");
        textView.setText(data);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key2",textView.getText().toString());

                Fragment_4 fragment3 = new Fragment_4();
                fragment3.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fr_container,fragment3).commit();
            }
        });

    }
}