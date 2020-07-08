package com.example.importantcall;

import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
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
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {
    ToggleButton toggleButton_start;
    private View view;
    private int Pyth;
    ImageView imageView;
    SwitchCompat switchCompat;
    TelephonyManager telephonyManager;
    private boolean set_btn = false;
    PhoneStateListener phoneStateListener = new PhoneStateListener(){
        @Override
        public void onCallStateChanged(int state, String phoneNumber) {
            switch(state)
            {
                case TelephonyManager.CALL_STATE_IDLE :
                    Toast.makeText(getActivity(),"통화x",Toast.LENGTH_SHORT).show();
                    break;
                case TelephonyManager.CALL_STATE_RINGING :
                    Toast.makeText(getActivity(),"폰이울림",Toast.LENGTH_SHORT).show();
                    break;

                case TelephonyManager.CALL_STATE_OFFHOOK :
                    Toast.makeText(getActivity(),"통화중",Toast.LENGTH_SHORT).show();
                    break;
                default:break;

            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.frag1, container, false);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        //switchCompat = (SwitchCompat) view.findViewById(R.id.switchButton);
        toggleButton_start = (ToggleButton) view.findViewById(R.id.toggleButton_start);
        imageView.setImageResource(R.drawable.ic_baseline_blur_on_24);
        toggleButton_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleButton_start.isChecked()){
                    set_btn = true;
                        if (set_btn == true){
                            imageView.setImageResource(R.drawable.ic_baseline_blur_off_24);
                            telephonyManager = (TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE);
                            telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
                        }
                } else {
                        set_btn = false;
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
