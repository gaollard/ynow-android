package com.example.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void myClick(View v){
        switch (v.getId()) {
            case R.id.button3:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示");
                builder.setMessage("您确定退出程序吗");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();
                break;
            case R.id.button4:
                MyDialog myDialog = new MyDialog(this, R.style.myDialog);
                myDialog.show();
                break;
            case R.id.popup_btn:
                showPopupWindow(v);
                break;
        }
    }

    public void showPopupWindow(View v) {
        // 准备视图对象
        View view = LayoutInflater.from(this).inflate(R.layout.popup_window_layout, null);
        // 设置宽高
        PopupWindow popupWindow = new PopupWindow(view, 200, 400, true);
        // 设置动画
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(v);
    }
}
