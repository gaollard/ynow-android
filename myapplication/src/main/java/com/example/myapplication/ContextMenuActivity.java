package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

//public class ContextMenuActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_context_menu);
//        // 第一步：注册事件触发器
//        registerForContextMenu(findViewById(R.id.button));
//
//        // 设置上下文操作
//        // 1. 实现 ActionMode Callback
//        // 2. 在view的长按住事件中去启动上下文操作模式
//    }
//
//    // 第二步：注册菜单布局
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        getMenuInflater().inflate(R.menu.context, menu);
//    }
//
//    // 第三步：注册菜单选中事件
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.delete:
//                Toast.makeText(this, "delete", Toast.LENGTH_LONG).show();
//                break;
//            case R.id.like:
//                Toast.makeText(this, "like", Toast.LENGTH_LONG).show();
//        }
//        return super.onContextItemSelected(item);
//    }
//}

public class ContextMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        // 设置上下文操作
        // 1. 实现 ActionMode Callback
        // 2. 在view的长按住事件中去启动上下文操作模式
        findViewById(R.id.button).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.e("tag", "ddd");
                startActionMode(cb);
                return false;
            }
        });
    }

    ActionMode.Callback cb = new ActionMode.Callback() {
        // 创建 在启动上下文操作模式方法时调用
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.context, menu);
            return true;
        }

        // 在创建方法后被调用
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return true;
        }

        // 菜单项被点击
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.delete:
                    Toast.makeText(ContextMenuActivity.this, "delete", Toast.LENGTH_LONG).show();
                    break;
                case R.id.like:
                    Toast.makeText(ContextMenuActivity.this, "like", Toast.LENGTH_LONG).show();
            }
            return true;
        }

        // 上下文操作模式结束后调用
        @Override
        public void onDestroyActionMode(ActionMode mode) {
        }
    };
}