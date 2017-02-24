package com.github.hunter524.java.reflect;

import com.github.hunter524.java.DemoUtil;

/**
 * Created by hunter on 2017/2/24.
 */

public class PerformaceCmp {

    public static void newInstance(){
        long startTime = 0;
        long endTiem = 0;
// 除以 1000 000 000 纳秒 微妙 毫秒 相差十多倍 但是new 10000 个对象也只是毫秒级别 使用clasforname又差10倍
        startTime = System.nanoTime();
        for (int i = 0;i<10000;i++){
            try {
                Class.forName("java.lang.String").newInstance();
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        endTiem = System.nanoTime();
        DemoUtil.println("End reflect"+(endTiem-startTime)+"");

        startTime = System.nanoTime();
        for (int i = 0;i<10000;i++){
            new String();
        }
        endTiem = System.nanoTime();
        DemoUtil.println("End New"+(endTiem-startTime)+"");
    }
}
