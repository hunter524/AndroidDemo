package com.github.hunter524.java;


import com.github.hunter524.java.Collections.ComparatorDemo;
import com.github.hunter524.java.javaBase.practice.JavaBaseMain;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;

/**
 * Created by hunter on 2016/9/7.
 */
public class Main {
//    对象内部变量会被赋予初始值
    static int a[] =new  int[]{0};
    public static void main(String[] arg) throws UnsupportedEncodingException {
//        AnnotationMain.main();
//        ThreadMain.main();
        JavaBaseMain.main(new String[]{"c","a"});
//        RxJava.main();
//        PatternMain.main();
//        Votatile.main();
//        ThreadMain.main();
//        CloneMain.main();
        ComparatorDemo.demo();
//        局部变量未被赋值则不可以使用
//        int a;
//        System.out.println(a);
//        int i=0;
//        while (true){
//            a[i]=i;
//            i++;
//            System.out.println(i);
//        }
//        new Main().println();
    }

    public void println(){
        System.out.println(a);
    }


}





