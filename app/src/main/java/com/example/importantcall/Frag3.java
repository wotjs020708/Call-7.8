package com.example.importantcall;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag3 extends Fragment {

    Button btn_inp;
    EditText ed_inp;
    TextView text_meg;
    private String str;

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);
        btn_inp = (Button) view.findViewById(R.id.btn_inp);
        ed_inp = (EditText) view.findViewById(R.id.ed_inp);
        text_meg = (TextView) view.findViewById(R.id.text_meg);

        btn_inp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               str = ed_inp.getText().toString();
               text_meg.setText(str);
               ed_inp.setText("");


            }
        });

        return  view;

    }
}
