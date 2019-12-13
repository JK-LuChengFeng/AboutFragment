package com.example.aboutfragment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.aboutfragment.R;
import com.example.aboutfragment.base.BaseActivity;
import com.example.aboutfragment.bean.NewsBean;
import com.example.aboutfragment.fragment.Fragment_NewsContent;

/**
 * 新闻详情页
 * Create By JK_Liu on 2019/12/12
 */
public class Activity_NewsDetails extends BaseActivity {

    public static void actionStart(Context context, NewsBean newsBean){
        Intent intent = new Intent(context,Activity_NewsDetails.class);
        intent.putExtra("newsBean",newsBean);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__newsdetails);

        NewsBean newsBean = (NewsBean) getIntent().getSerializableExtra("newsBean");
        if (newsBean != null){
            Fragment_NewsContent fragment_newsContent = (Fragment_NewsContent) getSupportFragmentManager().findFragmentById(R.id.fg_newsdetails);
            fragment_newsContent.Refresh(newsBean);
        }
    }




}
