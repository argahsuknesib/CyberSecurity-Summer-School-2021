package com.j256.ormlite.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ForeignCollectionField {
    String columnName() default "";

    boolean eager() default false;

    String foreignFieldName() default "";

    int maxEagerLevel() default 1;

    boolean orderAscending() default true;

    String orderColumnName() default "";
}
