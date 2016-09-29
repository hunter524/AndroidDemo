package com.github.hunter524.java.javaBase.practice;

import java.util.ArrayList;

/**
 * Created by hunter on 2016/9/26.
 */

public class X {
    public class Y{

    }
    public static Y newY(X x){
        ArrayList<Object> objectArrayList = new ArrayList<>();
        return x.new Y();
    }
}
