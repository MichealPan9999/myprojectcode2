package com.panzq.projectcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.panzq.projectcode.activities.EditListenerActivity;
import com.panzq.projectcode.activities.MyFragmentActivity;
import com.panzq.projectcode.activities.NewsFragmentActivity;
import com.panzq.projectcode.activities.NumberPickerActivity;
import com.panzq.projectcode.activities.TestStartActivityByComponent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_number_picker,btn_startactivitybycomponentname,btn_fragmentActivity,btn_newFragment
            ,btn_edit_listener;
    private Intent intent= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView()
    {
        btn_number_picker = (Button)findViewById(R.id.number_picker);
        btn_startactivitybycomponentname = (Button)findViewById(R.id.startActivityByComponentName);
        btn_fragmentActivity = (Button) findViewById(R.id.startfragmentActivity);
        btn_newFragment = (Button)findViewById(R.id.startNewsFragment);
        btn_edit_listener = (Button)findViewById(R.id.edt_listener);
    }
    private void initListener()
    {
        btn_number_picker.setOnClickListener(this);
        btn_startactivitybycomponentname.setOnClickListener(this);
        btn_fragmentActivity.setOnClickListener(this);
        btn_newFragment.setOnClickListener(this);
        btn_edit_listener.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.number_picker:
                intent = new Intent(MainActivity.this, NumberPickerActivity.class);
                startActivity(intent);
                break;
            case R.id.startActivityByComponentName:
                intent = new Intent(MainActivity.this , TestStartActivityByComponent.class);
                startActivity(intent);
                break;
            case R.id.startfragmentActivity:
                intent = new Intent(MainActivity.this, MyFragmentActivity.class);
                startActivity(intent);
                break;
            case R.id.startNewsFragment:
                intent = new Intent(MainActivity.this, NewsFragmentActivity.class);
                startActivity(intent);
                break;
            case R.id.edt_listener:
                intent = new Intent(MainActivity.this, EditListenerActivity.class);
                startActivity(intent);;
                break;
        }
    }
}
