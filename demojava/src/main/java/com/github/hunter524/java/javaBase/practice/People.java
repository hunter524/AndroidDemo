package com.github.hunter524.java.javaBase.practice;

import java.io.Serializable;

/**
 * Created by hunter on 2016/10/11.
 */
//接口可以继承
public interface People extends Serializable {
    public String getName();
}
class Students implements People {
    public static int staticI = 2;
    public String name = "students";

    public transient int  sex = 0;
    @Override
    public String getName() {
        return "Students";
    }
}

class Teachers implements People{
    @Override
    public String getName() {
        return "Teachers";
    }
}
