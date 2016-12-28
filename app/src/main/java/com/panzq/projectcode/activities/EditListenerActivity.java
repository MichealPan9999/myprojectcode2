package com.panzq.projectcode.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.panzq.projectcode.R;

/**
 * 监听EditText字符输入的，当检测到输入字符可数超过8位时就是的按键可以响应，否则不响应。
 */
public class EditListenerActivity extends Activity {

    private EditText edt_pwd ;
    private Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_editlistener);
        edt_pwd = (EditText)findViewById(R.id.edit_content);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setFocusable(false);
        btn_login.setEnabled(false);
        btn_login.setClickable(false);
        edt_pwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()<8|| TextUtils.isEmpty(s))
                {
                    btn_login.setFocusable(false);
                    btn_login.setEnabled(false);
                    btn_login.setClickable(false);
                }
                else
                {
                    btn_login.setFocusable(true);
                    btn_login.setEnabled(true);
                    btn_login.setClickable(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("..........longin............");
            }
        });

    }
}
