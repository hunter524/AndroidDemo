package com.github.hunter524.java.reflect;

import com.github.hunter524.java.DemoUtil;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hunter on 2017/2/23.
 */

public class RefelectMain {

    public static void main(String[] args){
        Abean abean1 = new Abean();
        abean1.setName("abean1 name!");
        abean1.setSex("abean1 male!");

        Abean abean2 = new Abean();
        abean2.setSex("abean2 female!");
        abean2.setYear("abean2 year!");

        Field aBeanF[] = abean1.getClass().getDeclaredFields();
        for (Field field:aBeanF){
            try {
                field.setAccessible(true);
                Object abean1v = field.get(abean1);
                Object abean2v = field.get(abean2);
                if (abean2v != null){
                    field.set(abean1,abean2v);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        DemoUtil.println(abean1.toString());

    }
}
