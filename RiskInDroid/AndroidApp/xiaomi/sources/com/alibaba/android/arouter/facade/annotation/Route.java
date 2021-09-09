package com.alibaba.android.arouter.facade.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Route {
    int extras() default Integer.MIN_VALUE;

    String group() default "";

    String name() default "";

    String path();

    int priority() default -1;
}
