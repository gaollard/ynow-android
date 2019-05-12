package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * 当前Activity去实现事件接口
 */
public class ButtonActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        // 使用内部类的方式添加事件侦听器
        Button btn1 = findViewById(R.id.btn1);
        MyClickListener mcl = new MyClickListener();
        btn1.setOnClickListener(mcl);

        /**
         * 使用匿名的内部类
         */
        final Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Tag", "使用匿名的内部类的方式添加事件侦听器");
                btn2.setText("btn2");
            }
        });

        /**
         * 使用当前Activity去实现事件接口
         */
        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.e("Tag", "使用当前Activity去实现事件接口");
    }

    /**
     * 内部类
     */
    class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // 在控制台输出一条语句
            Log.e("Tag", "使用内部类的方式添加事件侦听器");
        }
    }

    /**
     * XML按钮绑定方法
     */
    public void myClick (View v){
        switch (v.getId()) {
            case R.id.btn4:
                Log.e("Tag", "btn4");
                break;
            case R.id.btn5:
                Log.e("Tag", "btn5");
        }
        Log.e("Tag", "在布局文件中添加点击事件属性");
    }
}
