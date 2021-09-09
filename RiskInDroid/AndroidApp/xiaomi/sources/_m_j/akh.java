package _m_j;

import _m_j.ajw;
import _m_j.aka;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface akh {
    Class<? extends ajw<?>> O000000o() default ajw.O000000o.class;

    Class<? extends ajw<?>> O00000Oo() default ajw.O000000o.class;

    Class<?> O00000o() default akm.class;

    Class<? extends aka> O00000o0() default aka.O000000o.class;

    Class<?> O00000oO() default akm.class;

    Class<?> O00000oo() default akm.class;

    Class<?> O0000O0o() default akm.class;
}
