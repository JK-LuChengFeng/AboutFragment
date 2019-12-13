package com.example.aboutfragment.activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.aboutfragment.R;
import com.example.aboutfragment.base.BaseActivity;
import com.example.aboutfragment.fragment.Fragment_Another;
import com.example.aboutfragment.fragment.Fragment_Left;

/**
 * Create By JK_Liu on 2019/12/11
 */
public class Activity_FragmentDynamic extends BaseActivity implements View.OnClickListener {

    private Button btn_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentdynamic);

        //1.直接实例化获取
//        btn_click = findViewById(R.id.btn_click);

        //2.先获取Fragment实例，然后再获取控件信息
        Fragment_Left fragment_left = (Fragment_Left) getSupportFragmentManager().findFragmentById(R.id.fg_top);
        btn_click = fragment_left.getView().findViewById(R.id.btn_click);
        btn_click.setOnClickListener(this);
        replaceFragement(new Fragment_Another());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_click:
//                replaceFragement(new Fragment_Another());

                Fragment_Another fragment_another = (Fragment_Another) getSupportFragmentManager().findFragmentByTag("21");
                if (fragment_another != null){
                    fragment_another.testMethod();
                }else {
                    Toast.makeText(Activity_FragmentDynamic.this,"空空如也",Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                break;
        }
    }

    private void replaceFragement(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.ll_bottom,fragment,"21");
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
