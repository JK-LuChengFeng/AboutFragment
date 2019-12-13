package com.example.aboutfragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.aboutfragment.R;

/**
 * @author JK_Liu
 * @description:
 * @date :2019/12/11 10:34
 */
public class Fragment_Another extends Fragment implements View.OnClickListener {

    private Button btn_test,btn_testmethod;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_another, container, false);
        initView(view);
        return view;

    }

    private void initView(View view) {
        btn_test = view.findViewById(R.id.btn_test);
        btn_test.setOnClickListener(this);
    }

    public void testMethod(){
        Toast.makeText(getActivity(),"this is test method",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                //测试点击
                Toast.makeText(getActivity(),"this is test click",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
