package com.panzq.projectcode.newsfragments;


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
public class NewsContentFragment extends Fragment {


    public NewsContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_content,container,false);
        TextView txt_content = (TextView)view.findViewById(R.id.txt_fg_content);
        //getArgument获取传递过来的Bundle对象
        String argument = getArguments().getString("newscontent");
        txt_content.setText(argument);
        return view;
    }

}
