package com.github.hunter524.java.reflect;

import com.github.hunter524.java.DemoUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by hunter on 2017/3/1.
 * 泛型的擦除 父类的泛型不会被擦除
 * 因此可以使用{@link Class#getGenericSuperclass()}获得{@link ParameterizedType}
 */

public class GenericClass <T> {
    public T getData(){
        return (T) new Object();
    }

    public static class SubGenericClass extends GenericClass<String>{

    }

    public static void main(){
        GenericClass.SubGenericClass subGenericClass = new GenericClass.SubGenericClass();
        ParameterizedType genericClass = ((ParameterizedType) subGenericClass.getClass().getGenericSuperclass());
        DemoUtil.println(genericClass.toString());
        DemoUtil.println(genericClass.getActualTypeArguments()[0].toString());
        DemoUtil.println(genericClass.getRawType().toString());
        DemoUtil.println(""+(subGenericClass instanceof Type));
        Type type = new Type() {
            @Override
            public String getTypeName() {
                return "";
            }
        };
        DemoUtil.println(""+(type instanceof Object));
    }
}
