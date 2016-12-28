package com.panzq.projectcode.newsfragments;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.panzq.projectcode.R;
import com.panzq.projectcode.adapters.NewsAdapter;
import com.panzq.projectcode.datas.Data;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewListFragment extends Fragment implements AdapterView.OnItemClickListener{

    private FragmentManager fManager;
    private ArrayList<Data> datas;
    private ListView listView;
    public NewListFragment(FragmentManager fManager, ArrayList<Data> datas) {
        // Required empty public constructor
        this.fManager = fManager;
        this.datas = datas;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.news_list,container,false);
        listView = (ListView) view.findViewById(R.id.list_news);
        NewsAdapter newsAdapter = new NewsAdapter(datas,getActivity());
        listView.setAdapter(newsAdapter);
        listView.setOnItemClickListener(this);
        return view;
}

    private TextView txt_title;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        txt_title = (TextView) getActivity().findViewById(R.id.txt_title);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        FragmentTransaction fragmentTransaction = fManager.beginTransaction();
        NewsContentFragment ncFragment = new NewsContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("newscontent",datas.get(position).getNew_content());
        ncFragment.setArguments(bundle);
        //获取Activity的控件
        txt_title.setText(datas.get(position).getNew_content());
        //加上Fragment替换动画
        fragmentTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter,R.anim.fragment_slide_left_exit);
        fragmentTransaction.replace(R.id.fl_content,ncFragment);
        //调用addToBackStack将Fragment添加到栈中
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
