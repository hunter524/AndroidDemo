package com.github.hunter524.java.reflect;

import com.github.hunter524.java.DemoUtil;
import com.github.hunter524.java.annotation.FieldAnnotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hunter on 2017/2/23.
 */

public class RefelectMain {

    public static void main(String[] args){
//        Abean abean1 = new Abean();
//        abean1.setName("abean1 name!");
//        abean1.setSex("abean1 male!");
//
//        Abean abean2 = new Abean();
//        abean2.setSex("abean2 female!");
//        abean2.setYear("abean2 year!");
//
//        ReflectApiDemo.copyAbean(abean2,abean1);
//
//        DemoUtil.println(abean1.toString());
//        GenericClass.main();
        System.out.println(Abean.SubClass.A);
    }
}
