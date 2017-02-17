package com.github.hunter524.java;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;

import sun.misc.Unsafe;

/**
 * Created by hunter on 2016/9/7.
 */
public class Main {

    public static void main(String[] arg) throws UnsupportedEncodingException {
        Unsafe.getUnsafe().addressSize();
        String original = "%u7ED9%u6211%u65F6%u5149%u673A93";
        String urldecode = EscapeUnescape.unescape(original);
        System.out.println(urldecode);
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i=0;i<50;i++){
            stringArrayList.add(""+i);
        }
//        for (String string:stringArrayList){
//            if (string.contains("1")||string.contains("3")){
//                stringArrayList.remove(string);
//            }
//        }
        Iterator<String> stringIterator = stringArrayList.iterator();
        while (stringIterator.hasNext()){
            String string = stringIterator.next();
            if (string.contains("1")||string.contains("3")){
                stringIterator.remove();
            }
        }
        System.out.println(stringArrayList.toString());
//        Class clazz = AnnotationBean.class;
//        try {
//            Field field = clazz.getDeclaredField("fieldAnnotationValue");
//            field.setAccessible(true);
//            field.set(AnnotationBean.class,"111");
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        AnnotationMain.main();
//        ThreadMain.main();
//        JavaBaseMain.main();
//        RxJava.main();
//        PatternMain.main();
    }

    public static class EscapeUnescape {

        public static String escape(String src) {
            int i;
            char j;
            StringBuffer tmp = new StringBuffer();
            tmp.ensureCapacity(src.length() * 6);
            for (i = 0; i < src.length(); i++) {
                j = src.charAt(i);
                if (Character.isDigit(j) || Character.isLowerCase(j)
                        || Character.isUpperCase(j))
                    tmp.append(j);
                else if (j < 256) {
                    tmp.append("%");
                    if (j < 16)
                        tmp.append("0");
                    tmp.append(Integer.toString(j, 16));
                } else {
                    tmp.append("%u");
                    tmp.append(Integer.toString(j, 16));
                }
            }
            return tmp.toString();
        }
   //中文为%u 加四个十六进制数据
        public static String unescape(String src) {
            StringBuffer tmp = new StringBuffer();
            tmp.ensureCapacity(src.length());
            int lastPos = 0, pos = 0;
            char ch;
            while (lastPos < src.length()) {
                pos = src.indexOf("%", lastPos);
                if (pos == lastPos) {
                    if (src.charAt(pos + 1) == 'u') {
                        ch = (char) Integer.parseInt(src
                                .substring(pos + 2, pos + 6), 16);
                        tmp.append(ch);
                        lastPos = pos + 6;
                    } else {
                        ch = (char) Integer.parseInt(src
                                .substring(pos + 1, pos + 3), 16);
                        tmp.append(ch);
                        lastPos = pos + 3;
                    }
                } else {
                    if (pos == -1) {
                        tmp.append(src.substring(lastPos));
                        lastPos = src.length();
                    } else {
                        tmp.append(src.substring(lastPos, pos));
                        lastPos = pos;
                    }
                }
            }
            return tmp.toString();
        }
    }
}





