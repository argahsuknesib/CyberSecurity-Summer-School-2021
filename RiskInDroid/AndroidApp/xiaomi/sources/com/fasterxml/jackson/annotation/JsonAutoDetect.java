package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonAutoDetect {
    Visibility O000000o() default Visibility.DEFAULT;

    Visibility O00000Oo() default Visibility.DEFAULT;

    Visibility O00000o() default Visibility.DEFAULT;

    Visibility O00000o0() default Visibility.DEFAULT;

    Visibility O00000oO() default Visibility.DEFAULT;

    /* renamed from: com.fasterxml.jackson.annotation.JsonAutoDetect$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f3592O000000o = new int[Visibility.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f3592O000000o[Visibility.ANY.ordinal()] = 1;
            f3592O000000o[Visibility.NONE.ordinal()] = 2;
            f3592O000000o[Visibility.NON_PRIVATE.ordinal()] = 3;
            f3592O000000o[Visibility.PROTECTED_AND_PUBLIC.ordinal()] = 4;
            f3592O000000o[Visibility.PUBLIC_ONLY.ordinal()] = 5;
        }
    }

    public enum Visibility {
        ANY,
        NON_PRIVATE,
        PROTECTED_AND_PUBLIC,
        PUBLIC_ONLY,
        NONE,
        DEFAULT;

        public final boolean isVisible(Member member) {
            int i = AnonymousClass1.f3592O000000o[ordinal()];
            if (i == 1) {
                return true;
            }
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return false;
                        }
                    } else if (Modifier.isProtected(member.getModifiers())) {
                        return true;
                    }
                    return Modifier.isPublic(member.getModifiers());
                } else if (!Modifier.isPrivate(member.getModifiers())) {
                    return true;
                }
            }
            return false;
        }
    }
}
