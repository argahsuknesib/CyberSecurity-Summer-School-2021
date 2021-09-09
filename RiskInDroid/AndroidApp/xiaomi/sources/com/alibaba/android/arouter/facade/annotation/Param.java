package com.alibaba.android.arouter.facade.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Deprecated
@Retention(RetentionPolicy.CLASS)
public @interface Param {
    String desc() default "No desc.";

    String name() default "";
}
