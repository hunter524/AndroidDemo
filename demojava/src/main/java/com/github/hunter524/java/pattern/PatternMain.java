package com.github.hunter524.java.pattern;

import com.github.hunter524.java.pattern.proxy.DynamicPrxyed;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by hunter on 2016/10/12.
 */

public class PatternMain {
    public static void main(){
        DynamicPrxyed dynamicPrxyed = (DynamicPrxyed) Proxy.newProxyInstance(DynamicPrxyed.class.getClassLoader(),
                new Class<?>[]{DynamicPrxyed.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("methode :"+ method.getName());
                for (Object objec:args) {
                    System.out.println(objec);
                }

                return method.invoke(this,args);
            }
        });
        System.out.println(""+dynamicPrxyed.getName("name"));
    }
}
