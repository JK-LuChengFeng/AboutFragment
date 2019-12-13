package com.example.aboutfragment.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

/**
 * @author JK_Liu
 * @description:
 * @date :2019/12/13 9:42
 */
public class SetScreenDirection {

    //设置横屏
    public static void setHorizontalScreen(Activity activity){
        int orientation = activity.getResources().getConfiguration().orientation;
        if (orientation != Configuration.ORIENTATION_LANDSCAPE){
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//横屏
        }
    }


}
