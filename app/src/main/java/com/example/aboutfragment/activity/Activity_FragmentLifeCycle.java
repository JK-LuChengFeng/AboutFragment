package com.example.aboutfragment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aboutfragment.R;
import com.example.aboutfragment.base.BaseActivity;
import com.example.aboutfragment.fragment.Fragment_LifeCycle;
import com.example.aboutfragment.fragment.Fragment_Right;

/**
 * Create By JK_Liu on 2019/12/12
 */
public class Activity_FragmentLifeCycle extends BaseActivity implements View.OnClickListener {

    private Button btn_lifetest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentlifecycle);

        initView();
        replace(new Fragment_LifeCycle());

    }

    private void initView() {
        btn_lifetest = findViewById(R.id.btn_lifetest);
        btn_lifetest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_lifetest:
                //生命周期测试
                replace(new Fragment_Right());
                break;
            default:
                break;
        }
    }

    private void replace(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.ll_bottom,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
