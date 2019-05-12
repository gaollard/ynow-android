package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickSubmit (View v) {
        Button btnSubmit = findViewById(R.id.btnSubmit);
        EditText editName = findViewById(R.id.edtName);
        EditText editPwd = findViewById(R.id.edtPwd);
        final ProgressBar process_01 = findViewById(R.id.process_01);

        String name = editName.getText().toString();
        String pwd = editPwd.getText().toString();
        if (name.equals("") || pwd.equals("")) {
            Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_LONG).show();
        } else {
            process_01.setVisibility(View.VISIBLE);
            new Thread() {
                @Override
                public void run() {
                    for (int index = 0; index < 100; index++) {
                        try {
                            process_01.setProgress(index);
                            Thread.sleep(30);
                        } catch ( InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }
}
