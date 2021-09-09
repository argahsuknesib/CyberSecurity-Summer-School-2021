package _m_j;

import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

public class jeo {

    /* renamed from: O000000o  reason: collision with root package name */
    static Class f1795O000000o = null;
    static Class O00000Oo = null;
    private static boolean O00000o = false;
    private static boolean O00000o0 = false;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jer.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.jer.O000000o(java.lang.String, java.util.Properties):java.lang.String
      _m_j.jer.O000000o(java.lang.String, org.apache.log4j.Level):org.apache.log4j.Level
      _m_j.jer.O000000o(java.lang.String, boolean):boolean */
    static {
        int indexOf;
        String O000000o2 = jer.O000000o("java.version");
        if (!(O000000o2 == null || (indexOf = O000000o2.indexOf(46)) == -1 || O000000o2.charAt(indexOf + 1) == '1')) {
        }
        String O000000o3 = jer.O000000o("log4j.ignoreTCL");
        if (O000000o3 != null) {
            O00000o = jer.O000000o(O000000o3, true);
        }
    }

    public static URL O000000o(String str) {
        Class cls;
        ClassLoader O00000Oo2;
        try {
            if (!O00000o0 && !O00000o && (O00000Oo2 = O00000Oo()) != null) {
                StringBuffer stringBuffer = new StringBuffer("Trying to find [");
                stringBuffer.append(str);
                stringBuffer.append("] using context classloader ");
                stringBuffer.append(O00000Oo2);
                stringBuffer.append(".");
                jep.O000000o(stringBuffer.toString());
                URL resource = O00000Oo2.getResource(str);
                if (resource != null) {
                    return resource;
                }
            }
            if (f1795O000000o == null) {
                cls = O00000o0("_m_j.jeo");
                f1795O000000o = cls;
            } else {
                cls = f1795O000000o;
            }
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null) {
                StringBuffer stringBuffer2 = new StringBuffer("Trying to find [");
                stringBuffer2.append(str);
                stringBuffer2.append("] using ");
                stringBuffer2.append(classLoader);
                stringBuffer2.append(" class loader.");
                jep.O000000o(stringBuffer2.toString());
                URL resource2 = classLoader.getResource(str);
                if (resource2 != null) {
                    return resource2;
                }
            }
        } catch (IllegalAccessException e) {
            jep.O00000o0("Caught Exception while in Loader.getResource. This may be innocuous.", e);
        } catch (InvocationTargetException e2) {
            if ((e2.getTargetException() instanceof InterruptedException) || (e2.getTargetException() instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            jep.O00000o0("Caught Exception while in Loader.getResource. This may be innocuous.", e2);
        } catch (Throwable th) {
            jep.O00000o0("Caught Exception while in Loader.getResource. This may be innocuous.", th);
        }
        StringBuffer stringBuffer3 = new StringBuffer("Trying to find [");
        stringBuffer3.append(str);
        stringBuffer3.append("] using ClassLoader.getSystemResource().");
        jep.O000000o(stringBuffer3.toString());
        return ClassLoader.getSystemResource(str);
    }

    private static Class O00000o0(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static boolean O000000o() {
        return O00000o0;
    }

    private static ClassLoader O00000Oo() throws IllegalAccessException, InvocationTargetException {
        Class cls;
        try {
            if (O00000Oo == null) {
                cls = O00000o0("java.lang.Thread");
                O00000Oo = cls;
            } else {
                cls = O00000Oo;
            }
            return (ClassLoader) cls.getMethod("getContextClassLoader", null).invoke(Thread.currentThread(), null);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Class O00000Oo(String str) throws ClassNotFoundException {
        if (O00000o0 || O00000o) {
            return Class.forName(str);
        }
        try {
            return O00000Oo().loadClass(str);
        } catch (InvocationTargetException e) {
            if ((e.getTargetException() instanceof InterruptedException) || (e.getTargetException() instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            return Class.forName(str);
        } catch (Throwable unused) {
            return Class.forName(str);
        }
    }
}
