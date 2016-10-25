package com.github.hunter524.java.javaBase.practice;

/**
 * Created by hunter on 2016/10/11.
 */

public interface People {
    public String getName();
}
class Students implements People {
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
