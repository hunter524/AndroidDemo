package com.github.hunter524.java.Clone;

/**
 * Created by hunter on 2017/3/14.
 */

public class CloneMain {
    public static void main(){
        String string ="str";
        String string2 = string;
        string = string +"1";
        System.out.println(string);
        System.out.println(string2);
    }
}
