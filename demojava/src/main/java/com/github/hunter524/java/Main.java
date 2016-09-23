package com.github.hunter524.java;

import com.github.hunter524.java.annotation.AnnotationMain;

/**
 * Created by hunter on 2016/9/7.
 */
public class Main {
    public static void main(String[] arg){
        AnnotationMain.main();
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
