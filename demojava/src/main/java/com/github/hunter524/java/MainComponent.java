package com.github.hunter524.java;

import dagger.Component;

/**
 * Created by hunter on 2016/9/7.
 */
@Component(modules = {},dependencies = {})
public interface MainComponent {

    public void inject(Main main);
}
