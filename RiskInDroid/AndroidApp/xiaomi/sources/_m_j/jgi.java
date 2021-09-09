package _m_j;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.greenrobot.eventbus.ThreadMode;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface jgi {
    ThreadMode O000000o() default ThreadMode.POSTING;

    boolean O00000Oo() default false;

    int O00000o0() default 0;
}
