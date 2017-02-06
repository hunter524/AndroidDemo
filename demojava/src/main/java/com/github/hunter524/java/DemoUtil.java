package com.github.hunter524.java;

/**
 * Created by hunter on 2017/2/6.
 */

public class DemoUtil {

    /**
     * console print message
     * @param messages
     */
    public static void println(String... messages){
        StringBuilder stringBuilder = new StringBuilder();
        for (String message:messages){
            stringBuilder.append(message+"|\t");
        }
        System.out.println(stringBuilder.toString());
    }
}
