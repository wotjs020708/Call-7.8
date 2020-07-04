package com.example.importantcall;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {

    private View view;
    ImageView imageView;
    SwitchCompat switchCompat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.frag1, container, false);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        switchCompat = (SwitchCompat) view.findViewById(R.id.switchButton);

        imageView.setImageResource(R.drawable.ic_baseline_blur_on_24);
        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchCompat.isChecked()){
                    imageView.setImageResource(R.drawable.ic_baseline_blur_off_24);
                } else {
                    imageView.setImageResource(R.drawable.ic_baseline_blur_on_24);
                }
            }
        });

        return  view;

    }
}
