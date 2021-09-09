package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Descriptor {
    int objectTypeIndication() default -1;

    int[] tags();
}
