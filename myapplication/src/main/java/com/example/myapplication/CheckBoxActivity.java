package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;

public class CheckBoxActivity extends AppCompatActivity {
    public static final String TAG = "CheckBoxActivity";
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "checked" + isChecked);
            }
        });

        ToggleButton toggleButton = findViewById(R.id.toggleButton2);
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//        toggleButton.setOnCheckedChangeListener();
    }

    public void myClick (View v) {
//        if (checkBox.isChecked()) {
//            Log.e(TAG, "checked");
//        } else {
//            Log.e(TAG, "unchecked");
//        }
//        checkBox.setChecked(true);
    }
}
