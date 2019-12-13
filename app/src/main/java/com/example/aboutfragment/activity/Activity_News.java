package com.example.aboutfragment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.aboutfragment.R;
import com.example.aboutfragment.base.BaseActivity;
import com.example.aboutfragment.utils.GetScreenWidth;
import com.example.aboutfragment.utils.SetScreenDirection;

/**
 * Create By JK_Liu on 2019/12/12
 */
public class Activity_News extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        int screenwidth = GetScreenWidth.getAndroiodScreenProperty(Activity_News.this);
        if (screenwidth > 500){
            SetScreenDirection.setHorizontalScreen(Activity_News.this);
        }
    }
}
