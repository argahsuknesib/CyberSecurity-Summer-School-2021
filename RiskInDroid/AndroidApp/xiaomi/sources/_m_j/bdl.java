package _m_j;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface bdl {
    String[] O000000o() default {};

    String[] O00000Oo() default {};

    Class<?> O00000o0() default Void.class;
}
