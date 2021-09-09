package com.squareup.wire;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WireField {
    String adapter();

    Label label() default Label.OPTIONAL;

    boolean redacted() default false;

    int tag();

    public enum Label {
        REQUIRED,
        OPTIONAL,
        REPEATED,
        ONE_OF,
        PACKED;

        /* access modifiers changed from: package-private */
        public final boolean isRepeated() {
            return this == REPEATED || this == PACKED;
        }

        /* access modifiers changed from: package-private */
        public final boolean isPacked() {
            return this == PACKED;
        }

        /* access modifiers changed from: package-private */
        public final boolean isOneOf() {
            return this == ONE_OF;
        }
    }
}
