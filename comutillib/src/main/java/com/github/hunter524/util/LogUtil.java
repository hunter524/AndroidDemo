package com.github.hunter524.util;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by hunter on 2017/2/8.
 */

public class LogUtil {

    public static void i(String tag,String... messages){
        if (null ==messages)
            return;
        StringBuilder messageBuilder = new StringBuilder();
        for (String message:messages){
            messageBuilder.append(message+"|");
        }
        Log.i(tag,messageBuilder.toString());
    }
}
