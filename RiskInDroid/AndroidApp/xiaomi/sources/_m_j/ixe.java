package _m_j;

import java.util.Arrays;
import java.util.List;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

public class ixe {
    public static int O000000o(int i) {
        if (i < 32) {
            return -1;
        }
        return i == 32 ? 0 : 1;
    }

    private ixe() {
    }

    public static String O000000o(String str, Object obj) {
        return str + obj;
    }

    public static void O000000o(Object obj) {
        if (obj == null) {
            O000000o();
        }
    }

    public static void O000000o() {
        throw ((KotlinNullPointerException) O000000o((Throwable) new KotlinNullPointerException()));
    }

    public static void O000000o(String str) {
        throw ((UninitializedPropertyAccessException) O000000o((Throwable) new UninitializedPropertyAccessException("lateinit property " + str + " has not been initialized")));
    }

    public static void O000000o(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) O000000o((Throwable) new IllegalStateException(str + " must not be null")));
        }
    }

    public static void O00000Oo(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) O000000o((Throwable) new IllegalStateException(str)));
        }
    }

    public static void O00000o(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalArgumentException) O000000o((Throwable) new IllegalArgumentException(str)));
        }
    }

    public static boolean O000000o(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
     arg types: [T, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T */
    private static <T extends Throwable> T O000000o(T t) {
        return O000000o((Throwable) t, ixe.class.getName());
    }

    static <T extends Throwable> T O000000o(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i + 1, length);
        th.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return th;
    }

    public static void O00000o0(Object obj, String str) {
        if (obj == null) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            throw ((IllegalArgumentException) O000000o((Throwable) new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str)));
        }
    }
}
