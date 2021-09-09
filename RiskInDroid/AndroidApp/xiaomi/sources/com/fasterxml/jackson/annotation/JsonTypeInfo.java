package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonTypeInfo {

    public enum As {
        PROPERTY,
        WRAPPER_OBJECT,
        WRAPPER_ARRAY,
        EXTERNAL_PROPERTY
    }

    public static abstract class O000000o {
    }

    Id O000000o();

    As O00000Oo() default As.PROPERTY;

    Class<?> O00000o() default O000000o.class;

    String O00000o0() default "";

    boolean O00000oO() default false;

    public enum Id {
        NONE(null),
        CLASS("@class"),
        MINIMAL_CLASS("@c"),
        NAME("@type"),
        CUSTOM(null);
        
        private final String _defaultPropertyName;

        private Id(String str) {
            this._defaultPropertyName = str;
        }

        public final String getDefaultPropertyName() {
            return this._defaultPropertyName;
        }
    }
}
