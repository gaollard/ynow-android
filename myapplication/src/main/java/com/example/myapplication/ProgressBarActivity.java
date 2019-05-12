package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class ProgressBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        ProgressBar progressBar01 = findViewById(R.id.process_01);
        final ProgressBar progressBar02 = findViewById(R.id.process_02);
        progressBar01.setIndeterminate(true);

        new Thread() {
            @Override
            public void run() {
                for (int index = 0; index < 100; index++) {
                    progressBar02.setProgress(index);
                    try {
                        Thread.sleep(30);
                    } catch ( InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
