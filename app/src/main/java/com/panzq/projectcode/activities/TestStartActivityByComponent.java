package com.panzq.projectcode.activities;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.panzq.projectcode.R;

public class TestStartActivityByComponent extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_start_by_component);

    }

    public void gotoNumberPicker(View v) {
        System.out.println("===========gotoNumberPicker======");
        ComponentName componentName = new ComponentName("com.panzq.projectcode", "com.panzq.projectcode.activities.OpenGLES20Complete");
        Intent intentComPonent = new Intent();
        //Intent intent = new Intent(Intent.ACTION_MAIN);
        //intent.addCategory(Intent.CATEGORY_LAUNCHER);
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        intentComPonent.setComponent(componentName);
        this.startActivity(intentComPonent);
    }



}
