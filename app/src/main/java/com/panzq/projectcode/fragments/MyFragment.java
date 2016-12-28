package com.panzq.projectcode.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.panzq.projectcode.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    private String content;
    public MyFragment(String content) {
        // Required empty public constructor
        this.content = content;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my,container,false);
        TextView tv_content = (TextView)view.findViewById(R.id.tv_content);
        tv_content.setText(content);
        return view;
    }

}
