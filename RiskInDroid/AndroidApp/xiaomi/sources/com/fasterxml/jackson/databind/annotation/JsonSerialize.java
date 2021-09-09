package com.fasterxml.jackson.databind.annotation;

import _m_j.ajz;
import _m_j.akm;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonSerialize {

    public enum Inclusion {
        ALWAYS,
        NON_NULL,
        NON_DEFAULT,
        NON_EMPTY
    }

    public enum Typing {
        DYNAMIC,
        STATIC
    }

    Class<? extends ajz<?>> O000000o() default ajz.O000000o.class;

    Class<? extends ajz<?>> O00000Oo() default ajz.O000000o.class;

    Class<?> O00000o() default akm.class;

    Class<? extends ajz<?>> O00000o0() default ajz.O000000o.class;

    Class<?> O00000oO() default akm.class;

    Class<?> O00000oo() default akm.class;

    Typing O0000O0o() default Typing.DYNAMIC;

    @Deprecated
    Inclusion O0000OOo() default Inclusion.ALWAYS;
}
