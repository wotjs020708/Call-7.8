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
    private String str;
    private String str1,str2;
    static final int SMS_PERMISSION=1;
    private View view;


    private void HiSendMessage(String phoneNo, String sms )
    {

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNo, null, sms, null, null);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int permssionCheck = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.SEND_SMS);
        if(permssionCheck == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getActivity(), "SMS 수신권한 있음", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getActivity(), "SMS 수신권한 없음", Toast.LENGTH_SHORT).show();

            if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.SEND_SMS)){

                Toast.makeText(getActivity(), "SMS권한이 필요합니다", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(getActivity(), new String[]{ Manifest.permission.SEND_SMS}, SMS_PERMISSION);
            }
            else{ActivityCompat.requestPermissions(getActivity(), new String[]{ Manifest.permission.SEND_SMS}, SMS_PERMISSION);
            }
        }

        view = inflater.inflate(R.layout.frag3, container, false);
        btn_inp = (Button) view.findViewById(R.id.btn_inp);
        ed_inp = (EditText) view.findViewById(R.id.ed_inp);
        text_meg = (TextView) view.findViewById(R.id.text_meg);
        str1="01050135766"; //"전화번호"


        btn_inp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               str = ed_inp.getText().toString();
               text_meg.setText(str);
               ed_inp.setText("");
                str2 = str;
                HiSendMessage(str1,str2);

            }
        });

        return  view;

    }
}
