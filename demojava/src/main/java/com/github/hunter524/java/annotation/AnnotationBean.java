package com.github.hunter524.java.annotation;

/**
 * Created by hunter on 2016/9/7.
 */
@ClassAnnotation(value = AnnotationBean.fieldAnnotationValue)
public class AnnotationBean {
    static final String fieldAnnotationValue = "fieldAnnotationValue";
    @FieldAnnotation(value =AnnotationBean.fieldAnnotationValue)
    public String field = "field value";
}
