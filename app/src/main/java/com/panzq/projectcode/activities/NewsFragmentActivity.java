package com.panzq.projectcode.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.panzq.projectcode.R;
import com.panzq.projectcode.datas.Data;
import com.panzq.projectcode.newsfragments.NewListFragment;

import java.util.ArrayList;

public class NewsFragmentActivity extends Activity {

    private TextView tv_title;
    private FrameLayout fl_content;
    private Context mContext;
    private ArrayList<Data> datas = null;
    private FragmentManager fManager = null;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_fragment);
        mContext = NewsFragmentActivity.this;
        fManager = getFragmentManager();
        findViewsById();
        datas = new ArrayList<Data>();
        for (int i = 1; i <= 10; i++) {
            Data d = new Data("新闻标题" + i, i + "~~~新闻内容------");
            datas.add(d);
        }
        NewListFragment nlFragment = new NewListFragment(fManager, datas);
        FragmentTransaction ft = fManager.beginTransaction();
        ft.replace(R.id.fl_content, nlFragment);
        ft.commit();
    }

    private void findViewsById() {
        tv_title = (TextView) findViewById(R.id.txt_title);
        fl_content = (FrameLayout) findViewById(R.id.fl_content);
    }

    @Override
    public void onBackPressed() {

        if (fManager.getBackStackEntryCount() == 0) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(mContext, "在按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }
        } else {
            fManager.popBackStack();
            tv_title.setText("新闻列表");
        }
    }
}
