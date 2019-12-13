package com.example.aboutfragment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aboutfragment.R;
import com.example.aboutfragment.base.BaseActivity;

/**
 * Create By JK_Liu on 2019/12/10
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button btn_staticreference,btn_dynamicreference,btn_lifecycle,btn_loadinglayout,btn_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {

        btn_staticreference = findViewById(R.id.btn_staticrefrence);
        btn_staticreference.setOnClickListener(this);

        btn_dynamicreference = findViewById(R.id.btn_dynamicreference);
        btn_dynamicreference.setOnClickListener(this);


        btn_lifecycle = findViewById(R.id.btn_lifecycle);
        btn_lifecycle.setOnClickListener(this);

        btn_loadinglayout = findViewById(R.id.btn_loadinglayout);
        btn_loadinglayout.setOnClickListener(this);

        btn_news = findViewById(R.id.btn_news);
        btn_news.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.btn_staticrefrence:
                //静态引用
                intent.setClass(MainActivity.this,Activity_FragmentStatic.class);
                this.startActivity(intent);
                break;
            case R.id.btn_dynamicreference:
                //动态引用
                intent.setClass(MainActivity.this,Activity_FragmentDynamic.class);
                this.startActivity(intent);
                break;
            case R.id.btn_lifecycle:
                //生命周期
                intent.setClass(MainActivity.this,Activity_FragmentLifeCycle.class);
                startActivity(intent);
                break;
            case R.id.btn_loadinglayout:
                intent.setClass(MainActivity.this,Activity_LoadingLayout.class);
                startActivity(intent);
                break;
            case R.id.btn_news:
                intent.setClass(MainActivity.this,Activity_News.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
