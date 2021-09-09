package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface bdk {
    String O000000o() default "";

    String O00000Oo() default "";

    boolean O00000o() default true;

    boolean O00000o0() default true;

    SerializerFeature[] O00000oO() default {};
}
