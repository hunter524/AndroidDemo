package com.github.hunter524.java.annotation;

/**
 * Created by hunter on 2016/9/18.
 */
public class AnnotationMain {

    public static void main(){
        AnnotationBean annotationBean = new AnnotationBean();
        ClassAnnotation classAnnotation = annotationBean.getClass().getAnnotation(ClassAnnotation.class);
        System.out.println(classAnnotation.value());
    }
}
