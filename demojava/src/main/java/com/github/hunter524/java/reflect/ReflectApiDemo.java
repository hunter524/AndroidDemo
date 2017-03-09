package com.github.hunter524.java.reflect;

import java.lang.reflect.Field;

/**
 * Created by hunter on 2017/2/24.
 */

public class ReflectApiDemo {

    /**
     * copy src 2 des
     * @param src
     * @param des
     */
   private static Object copyBean(Object src, Object des) {
        Class desClass = des.getClass();
        String desClassName = desClass.getName();
        Class srcClass = src.getClass();
        String srcClassName = srcClass.getName();
        if (!srcClassName.equals(desClassName)) {
            throw new IllegalArgumentException("src and des must the same class!");
        }
        Field[] fields = desClass.getDeclaredFields();
        for (Field field : fields) {
            try {
                //                设置访问权限
                field.setAccessible(true);
                Object srcV = field.get(src);
                if (srcV != null) {
                    field.set(des, srcV);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return des;
    }

    public static Abean copyAbean(Abean src,Abean des){
        return (Abean)copyBean(src,des);
    }
}
