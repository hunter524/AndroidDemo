package com.github.hunter524.java.dagger2.modules;

import com.github.hunter524.java.dagger2.annotation.FirstAnnotation;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hunter on 2016/9/22.
 */
@Module
public class MainModule {

    @Named(value = "default")
    @Provides @FirstAnnotation String proviDedefaultString (){
       return new String("default");
    }
    @Named(value = "first")
    @Provides @FirstAnnotation String provideFirstString (){
        return new String("first");
    }
}
