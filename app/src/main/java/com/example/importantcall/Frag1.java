package com.example.importantcall;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.telephony.PhoneNumberUtils;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.gun0912.tedpermission.PermissionListener;

import java.util.ArrayList;

import static android.content.Context.AUDIO_SERVICE;
import static com.example.importantcall.Frag3.SMS_PERMISSION;

public class Frag1 extends Fragment {
    ToggleButton toggleButton_start;
    private View view;
    Thread thread;
    boolean isThread = false;
    ImageView imageView;
    SwitchCompat switchCompat;
    private Intent intent;
    private Context context;
    Bundle bundle = this.getArguments();
    String str;
    String call_number;

    private void HiSendMessage(String phoneNo, String sms )
    {

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNo, null, sms, null, null);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        str = bundle.getString("phone_number");
        Bundle bundle = intent.getExtras();
        view = inflater.inflate(R.layout.frag1, container, false);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        //switchCompat = (SwitchCompat) view.findViewById(R.id.switchButton);
        toggleButton_start = (ToggleButton) view.findViewById(R.id.toggleButton_start);
        imageView.setImageResource(R.drawable.ic_baseline_blur_on_24);
        toggleButton_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleButton_start.isChecked()){
                    imageView.setImageResource(R.drawable.ic_baseline_blur_off_24);


                    Toast.makeText(getActivity(),str,Toast.LENGTH_SHORT).show();


                } else {
                    imageView.setImageResource(R.drawable.ic_baseline_blur_on_24);
                }


                }


        });
        /*switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if (switchCompat.isChecked()){
                    imageView.setImageResource(R.drawable.ic_baseline_blur_off_24);
                    telephonyManager=(TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE);
                    telephonyManager.listen(phoneStateListener,PhoneStateListener.LISTEN_CALL_STATE);
                } else {
                    imageView.setImageResource(R.drawable.ic_baseline_blur_on_24);
                }
            }
        });*/

        return  view;

    }
}
