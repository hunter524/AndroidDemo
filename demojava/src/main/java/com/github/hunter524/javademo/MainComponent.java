package com.github.hunter524.javademo;

import dagger.Component;

/**
 * Created by hunter on 2016/9/7.
 */
@Component(modules = {},dependencies = {})
public interface MainComponent {

    public void inject(Class T);
}
