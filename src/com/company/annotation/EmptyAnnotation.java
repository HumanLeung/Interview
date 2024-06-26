package com.company.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@MyAnnotation
@Target({ElementType.TYPE})
public @interface EmptyAnnotation {

    String value() default "";

}
