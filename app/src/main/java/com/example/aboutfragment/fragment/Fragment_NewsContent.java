package com.example.aboutfragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.aboutfragment.R;
import com.example.aboutfragment.bean.NewsBean;

/**
 * @author JK_Liu
 * @description:新闻内容页
 * @date :2019/12/12 16:00
 */
public class Fragment_NewsContent extends Fragment {

    private TextView tv_title,tv_content;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_newcontent,container,false);
        initView(view);
        return view;

    }

    /**
     * 实例化相关控件
     * @param view
     */
    private void initView(View view) {
        tv_title = view.findViewById(R.id.tv_newstitle);
        tv_content = view.findViewById(R.id.tv_newscontent);
    }

    /**
     * 刷新页面内容
     * @param newsBean
     */
    public void Refresh(NewsBean newsBean){
        tv_title.setText(newsBean.getTitle());
        tv_content.setText(newsBean.getContent());
    }

}
