package com.github.hunter524.java.dagger2.components;

import com.github.hunter524.java.dagger2.DaggerMain;
import com.github.hunter524.java.dagger2.annotation.FirstAnnotation;
import com.github.hunter524.java.dagger2.annotation.MainAnnotation;
import com.github.hunter524.java.dagger2.annotation.SencondAnnotation;
import com.github.hunter524.java.dagger2.modules.MainModule;

import dagger.Component;

/**
 * Created by hunter on 2016/9/22.
 */
@FirstAnnotation
@MainAnnotation
@SencondAnnotation
@Component(modules = {MainModule.class})
public interface MainComponent{
    public void inject(DaggerMain daggerMain);
}
