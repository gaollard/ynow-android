package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopupMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);

        final Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 实例化 PopupMenu 对象
                // 加载菜单资源
                // 为 PopupMenu 设置点击监听器
                //
                PopupMenu menu = new PopupMenu(PopupMenuActivity.this, button);
                menu.getMenuInflater().inflate(R.menu.popup, menu.getMenu());

                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.delete:
                                Toast.makeText(PopupMenuActivity.this, "delete", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.like:
                                Toast.makeText(PopupMenuActivity.this, "like", Toast.LENGTH_LONG).show();
                        }
                        return false;
                    }
                });
                menu.show();
            }
        });
    }
}
