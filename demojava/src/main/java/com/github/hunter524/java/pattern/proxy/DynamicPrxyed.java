package com.github.hunter524.java.pattern.proxy;

import com.github.hunter524.java.dagger2.annotation.FirstAnnotation;

/**
 * Created by hunter on 2016/10/12.
 */

public interface DynamicPrxyed {
    @FirstAnnotation
    public String getName(String name);
}
