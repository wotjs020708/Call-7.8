package com.example.importantcall;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class Frag3 extends Fragment {

    Button btn_inp;
    EditText ed_inp;
    TextView text_meg;
    Button btn_nub_inp;
    EditText ed_nub_inp;
    private String str;
    private String str1,str2;
    static final int SMS_PERMISSION=1;
    private View view;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = this.getArguments();
        String myInt = bundle.getString("meg",str1);
        view = inflater.inflate(R.layout.frag3, container, false);
        btn_inp = (Button) view.findViewById(R.id.btn_inp);
        ed_inp = (EditText) view.findViewById(R.id.ed_inp);
        text_meg = (TextView) view.findViewById(R.id.text_meg);

        btn_nub_inp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn_inp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str = ed_inp.getText().toString();
                text_meg.setText(str);
                ed_inp.setText("");
                Frag1 fragment = new Frag1();
                Bundle bundle = new Bundle();
                bundle.putString("meg", str);
                fragment.setArguments(bundle);
            }
        });

        return  view;

    }
}
