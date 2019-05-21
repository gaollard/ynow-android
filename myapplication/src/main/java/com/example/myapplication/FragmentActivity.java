package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 学习Fragment的使用
 */
public class FragmentActivity extends AppCompatActivity implements ListFragment.OnTitleClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        // 绑定点击事件
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FragmentActivity.this, StaticLoadFragmentActivity.class));
            }
        });
        ListFragment l1 = ListFragment.newInstance("A");
        ListFragment l2 = ListFragment.newInstance("B");

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.listContainer1, l1)
                .commit();

        l1.setOnTitleClickListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.listContainer2, l2)
                .commit();

        l2.setOnTitleClickListener(this);
    }

    public void onClick (String title) {
        setTitle(title);
    }
}
