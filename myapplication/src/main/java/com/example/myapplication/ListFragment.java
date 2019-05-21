package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * 列表Fragment
 */
public class ListFragment extends Fragment {

    public static final String TITLE = "title";
    private String title;

    public static ListFragment newInstance (String title) {
        ListFragment listFragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        listFragment.setArguments(bundle);
        return listFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(TITLE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(title);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnTitleClickListener != null) {
                    mOnTitleClickListener.onClick(title);
                }
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void setOnTitleClickListener(OnTitleClickListener onTitleClickListener){
        mOnTitleClickListener = onTitleClickListener;
    }

    private OnTitleClickListener mOnTitleClickListener;

    public interface OnTitleClickListener {
        void onClick(String title);
    }
}
