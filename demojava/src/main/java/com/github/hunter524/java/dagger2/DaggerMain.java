package com.github.hunter524.java.dagger2;


import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by hunter on 2016/9/22.
 */

public class DaggerMain {
    @Inject
    @Named("first")
    String firstString;
    @Inject
    @Named("default")
    String defaultStr;

    public static void main(){
        DaggerMain  daggerMain = new DaggerMain();

    }
}
