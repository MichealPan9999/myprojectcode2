package com.panzq.projectcode.activities;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.NumberPicker;

import com.panzq.projectcode.R;
import com.panzq.projectcode.widget.CustomNumberPicker;

import java.util.ArrayList;
import java.util.Locale;

public class NumberPickerActivity extends AppCompatActivity {

    private CustomNumberPicker mLanguagePicker = null;
    private Button mStartButton;
    private ArrayList<Locale> mLocaleList = new ArrayList<Locale>();
    private Locale[] mSupportedLocales = {Locale.getDefault(),Locale.getDefault(),Locale.getDefault(),Locale.getDefault()};
    private String[][] sSupportedLocales = {{"en","US"},{"zh","CN"},{"zh","TW"},{"fr","FR"}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_number_picker);
        Locale[] locales = Locale.getAvailableLocales();
        mStartButton = (Button) findViewById(R.id.id_start);
        int i =0 ;
        for (String[]s:sSupportedLocales)
        {
            for (Locale l : locales)
            {
                if (s[0].equals(l.getLanguage())&&s[1].equals(l.getCountry()))
                {
                    mSupportedLocales[i++] = l;
                    break;
                }
            }
        }
        for (Locale locale : mSupportedLocales)
        {
            mLocaleList.add(locale);
        }
        mLanguagePicker = (CustomNumberPicker)findViewById(R.id.language_picker);
        mLanguagePicker.setMaxValue(mLocaleList.size() - 1);
        mLanguagePicker.setMinValue(0);
        mLanguagePicker.setDisplayedValues(getResources().getStringArray(R.array.str_arr_language_vals));
        mLanguagePicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);//是的数字不可手动输入
        mLanguagePicker.setWrapSelectorWheel(true);//为TRUE循环滚动，FALSE不循环滚动。
        mLanguagePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int olcValue, int newValue) {
                changeApplicationLocale();
            }
        });
        Locale current = getResources().getConfiguration().locale;
        mLanguagePicker.setValue(mLocaleList.indexOf(current));
    }
    private void changeApplicationLocale()
    {
        Configuration config = new Configuration();
        config.locale = mLocaleList.get(mLanguagePicker.getValue());
        Locale.setDefault(config.locale);
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        mStartButton.setText(R.string.btn_start);
        mLanguagePicker.setDisplayedValues(getResources().getStringArray(R.array.str_arr_language_vals));
    }
}
