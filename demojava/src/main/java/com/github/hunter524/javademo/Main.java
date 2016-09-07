package com.github.hunter524.javademo;

/**
 * Created by hunter on 2016/9/7.
 */
public class Main {
    public static void main(String[] arg){
        System.out.println("just Demo 2");
        DaggerMainComponent.builder().build().inject(Main.class);
    }
}

