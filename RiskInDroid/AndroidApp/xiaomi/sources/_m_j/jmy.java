package _m_j;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class jmy {

    /* renamed from: O000000o  reason: collision with root package name */
    static int f1966O000000o;
    static jna O00000Oo = new jna();
    private static final String[] O00000o = {"1.6", "1.7"};
    static jmz O00000o0 = new jmz();
    private static String O00000oO = "org/slf4j/impl/StaticLoggerBinder.class";

    private jmy() {
    }

    private static void O000000o(Throwable th) {
        f1966O000000o = 2;
        jnb.O000000o("Failed to instantiate SLF4J LoggerFactory", th);
    }

    private static final void O000000o() {
        List O000000o2 = O00000Oo.O000000o();
        if (O000000o2.size() != 0) {
            jnb.O000000o("The following loggers will not work because they were created");
            jnb.O000000o("during the default configuration phase of the underlying logging system.");
            jnb.O000000o("See also http://www.slf4j.org/codes.html#substituteLogger");
            for (int i = 0; i < O000000o2.size(); i++) {
                jnb.O000000o((String) O000000o2.get(i));
            }
        }
    }

    private static final void O00000Oo() {
        try {
            String str = jnd.f1969O000000o;
            boolean z = false;
            for (String startsWith : O00000o) {
                if (str.startsWith(startsWith)) {
                    z = true;
                }
            }
            if (!z) {
                jnb.O000000o("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(O00000o).toString());
                jnb.O000000o("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            }
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            jnb.O000000o("Unexpected problem occured during version sanity check", th);
        }
    }

    private static Set O00000o0() {
        Enumeration<URL> enumeration;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = jmy.class.getClassLoader();
            if (classLoader == null) {
                enumeration = ClassLoader.getSystemResources(O00000oO);
            } else {
                enumeration = classLoader.getResources(O00000oO);
            }
            while (enumeration.hasMoreElements()) {
                linkedHashSet.add((URL) enumeration.nextElement());
            }
        } catch (IOException e) {
            jnb.O000000o("Error getting resources from path", e);
        }
        return linkedHashSet;
    }

    private static boolean O000000o(Set set) {
        return set.size() > 1;
    }

    public static jmx O000000o(String str) {
        jmw jmw;
        boolean z;
        if (f1966O000000o == 0) {
            f1966O000000o = 1;
            try {
                Set<URL> O00000o02 = O00000o0();
                if (O000000o(O00000o02)) {
                    jnb.O000000o("Class path contains multiple SLF4J bindings.");
                    for (URL url : O00000o02) {
                        jnb.O000000o("Found binding in [" + url + "]");
                    }
                    jnb.O000000o("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
                }
                jnd.O000000o();
                f1966O000000o = 3;
                if (O000000o(O00000o02)) {
                    StringBuilder sb = new StringBuilder("Actual binding is of type [");
                    jnd.O000000o();
                    sb.append(jnd.O00000Oo());
                    sb.append("]");
                    jnb.O000000o(sb.toString());
                }
                O000000o();
            } catch (NoClassDefFoundError e) {
                String message = e.getMessage();
                if (message == null || (message.indexOf("org/slf4j/impl/StaticLoggerBinder") == -1 && message.indexOf("org.slf4j.impl.StaticLoggerBinder") == -1)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    f1966O000000o = 4;
                    jnb.O000000o("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                    jnb.O000000o("Defaulting to no-operation (NOP) logger implementation");
                    jnb.O000000o("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                } else {
                    O000000o(e);
                    throw e;
                }
            } catch (NoSuchMethodError e2) {
                String message2 = e2.getMessage();
                if (!(message2 == null || message2.indexOf("org.slf4j.impl.StaticLoggerBinder.getSingleton()") == -1)) {
                    f1966O000000o = 2;
                    jnb.O000000o("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                    jnb.O000000o("Your binding is version 1.5.5 or earlier.");
                    jnb.O000000o("Upgrade your binding to version 1.6.x.");
                }
                throw e2;
            } catch (Exception e3) {
                O000000o(e3);
                throw new IllegalStateException("Unexpected initialization failure", e3);
            }
            if (f1966O000000o == 3) {
                O00000Oo();
            }
        }
        int i = f1966O000000o;
        if (i == 1) {
            jmw = O00000Oo;
        } else if (i == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        } else if (i == 3) {
            jmw = jnd.O000000o().O00000Oo;
        } else if (i == 4) {
            jmw = O00000o0;
        } else {
            throw new IllegalStateException("Unreachable code");
        }
        return jmw.O000000o(str);
    }
}
