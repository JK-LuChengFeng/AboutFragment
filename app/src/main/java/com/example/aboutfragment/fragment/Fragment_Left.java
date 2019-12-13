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
import com.example.aboutfragment.activity.Activity_FragmentDynamic;

/**
 * @author JK_Liu
 * @description:
 * @date :2019/12/10 16:48
 */
public class Fragment_Left extends Fragment implements View.OnClickListener {

    private Button btn_testmethod;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_left, container, false);
        initView(view);
        return view;

    }

    private void initView(View view) {
        btn_testmethod = view.findViewById(R.id.btn_testmethod);
        btn_testmethod.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_testmethod:
                Activity_FragmentDynamic activityFragmentDynamic = (Activity_FragmentDynamic) getActivity();
                Fragment_Another fragment_another = (Fragment_Another)activityFragmentDynamic.getSupportFragmentManager().findFragmentByTag("21");
                if (fragment_another != null){
                    fragment_another.testMethod();
                }else {
                    Toast.makeText(getActivity(),"空空如也2",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
