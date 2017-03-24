package com.github.hunter524.java.clazzLoader;

/**
 * Created by hunter on 2017/3/21.
 */

public class clazzLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
