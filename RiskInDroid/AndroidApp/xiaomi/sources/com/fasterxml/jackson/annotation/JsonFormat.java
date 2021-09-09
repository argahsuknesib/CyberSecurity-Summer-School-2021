package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Locale;
import java.util.TimeZone;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonFormat {
    String O000000o() default "";

    Shape O00000Oo() default Shape.ANY;

    String O00000o() default "##default";

    String O00000o0() default "##default";

    public enum Shape {
        ANY,
        SCALAR,
        ARRAY,
        OBJECT,
        NUMBER,
        NUMBER_FLOAT,
        NUMBER_INT,
        STRING,
        BOOLEAN;

        public final boolean isNumeric() {
            return this == NUMBER || this == NUMBER_INT || this == NUMBER_FLOAT;
        }

        public final boolean isStructured() {
            return this == OBJECT || this == ARRAY;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f3593O000000o;
        public final Shape O00000Oo;
        public final TimeZone O00000o;
        public final Locale O00000o0;

        public O000000o(JsonFormat jsonFormat) {
            this(jsonFormat.O000000o(), jsonFormat.O00000Oo(), jsonFormat.O00000o0(), jsonFormat.O00000o());
        }

        private O000000o(String str, Shape shape, String str2, String str3) {
            this.f3593O000000o = str;
            this.O00000Oo = shape;
            if (str2 == null || str2.length() == 0 || "##default".equals(str2)) {
                this.O00000o0 = null;
            } else {
                this.O00000o0 = new Locale(str2);
            }
            if (str3 == null || str3.length() == 0 || "##default".equals(str3)) {
                this.O00000o = null;
            } else {
                this.O00000o = TimeZone.getTimeZone(str3);
            }
        }
    }
}
