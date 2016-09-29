package com.github.hunter524.java;

import com.github.hunter524.java.Thread.ThreadMain;

/**
 * Created by hunter on 2016/9/7.
 */
public class Main {
    public static void main(String[] arg){
//        AnnotationMain.main();
        ThreadMain.main();
    }
}
class Y {
    public class X {}
    public X foo() {
        return new X();
    }
    public static X createX(Y y) {
        return y.new X();
    }
}
