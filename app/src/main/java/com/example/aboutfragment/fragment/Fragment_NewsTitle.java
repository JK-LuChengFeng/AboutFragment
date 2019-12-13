package com.example.aboutfragment.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aboutfragment.R;
import com.example.aboutfragment.activity.Activity_News;
import com.example.aboutfragment.activity.Activity_NewsDetails;
import com.example.aboutfragment.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author JK_Liu
 * @description:新闻标题页
 * @date :2019/12/12 16:00
 */
public class Fragment_NewsTitle extends Fragment {

    private List<NewsBean> data = new ArrayList<>();
    private RecyclerView rv_title;
    private RecyclerView.LayoutManager layoutManager;
    private RvAdapter adapter;
    private boolean isTwoPage;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_newstitle,container,false);

        initData();
        initView(view);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.fm_content) != null){
            //双页面
            Log.e("123","aaaaaaaaaaaaaaaaaaaaaaaa");
            isTwoPage = true;
        }else {
            //单页面
            Log.e("123", "bbbbbbbbbbbbbbbbbbbbbbbbbbb");
            isTwoPage = false;
        }

        adapter = new RvAdapter(data);
        rv_title.setAdapter(adapter);
    }

    private void initData() {

        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            NewsBean newsBean = new NewsBean();
            newsBean.setTitle("这是新闻标题" + i);
            for (int j = 0; j < i+1 ; j++) {
                stringBuilder.append("这是新闻内容");
            }
            newsBean.setContent(stringBuilder.toString());
            data.add(newsBean);
        }
    }

    private void initView(View view) {

        rv_title = view.findViewById(R.id.rv_newstitle);
        layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        rv_title.setLayoutManager(layoutManager);
    }



    class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder>{

        private List<NewsBean> data;

        public RvAdapter(List<NewsBean> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title,parent,false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

            holder.tv_title.setText(data.get(position).getTitle());
            holder.tv_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (isTwoPage){
                        //双页面
                        Log.e("123", "onClick: aaaaaaaa" );
                        Fragment_NewsContent fragment_newsContent = (Fragment_NewsContent) getActivity().getSupportFragmentManager().findFragmentById(R.id.fg_content);
                        fragment_newsContent.Refresh(data.get(position));
                    }else {
                        //单页面
                        Log.e("123", "onClick: bbbbbbbbb" );
                        Activity_NewsDetails.actionStart(getActivity(),data.get(position));
                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            return (data == null) ? 0: data.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            private TextView tv_title;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tv_title = itemView.findViewById(R.id.item_tv_title);
            }
        }


    }




}
