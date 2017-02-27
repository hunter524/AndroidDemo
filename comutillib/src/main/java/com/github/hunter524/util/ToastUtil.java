package com.github.hunter524.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by hunter on 2017/2/27.
 */

public class ToastUtil {
    public static void show(String msg, Context context){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
