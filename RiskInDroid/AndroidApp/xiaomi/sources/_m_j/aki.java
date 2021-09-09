package _m_j;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface aki {
    String O000000o() default "build";

    String O00000Oo() default "with";

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f12418O000000o;
        public final String O00000Oo;

        public O000000o(aki aki) {
            this.f12418O000000o = aki.O000000o();
            this.O00000Oo = aki.O00000Oo();
        }
    }
}
