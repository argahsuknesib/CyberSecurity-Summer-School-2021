package _m_j;

import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.Level;

public final class jer {

    /* renamed from: O000000o  reason: collision with root package name */
    static String f1798O000000o = "${";
    static char O00000Oo = '}';
    static int O00000o = 1;
    static int O00000o0 = 2;
    static Class O00000oO;
    static Class O00000oo;
    static Class O0000O0o;

    public static String O000000o(String str) {
        try {
            return System.getProperty(str, null);
        } catch (Throwable unused) {
            StringBuffer stringBuffer = new StringBuffer("Was not allowed to read system property \"");
            stringBuffer.append(str);
            stringBuffer.append("\".");
            jep.O000000o(stringBuffer.toString());
            return null;
        }
    }

    public static Object O000000o(Properties properties, String str, Class cls) {
        String O000000o2 = O000000o(str, properties);
        if (O000000o2 != null) {
            return O000000o(O000000o2.trim(), cls, (Object) null);
        }
        jep.O00000Oo("Could not find value for key ".concat(String.valueOf(str)));
        return null;
    }

    public static boolean O000000o(String str, boolean z) {
        if (str == null) {
            return z;
        }
        String trim = str.trim();
        if ("true".equalsIgnoreCase(trim)) {
            return true;
        }
        if ("false".equalsIgnoreCase(trim)) {
            return false;
        }
        return z;
    }

    public static Level O000000o(String str, Level level) {
        Class cls;
        Class cls2;
        if (str == null) {
            return level;
        }
        String trim = str.trim();
        int indexOf = trim.indexOf(35);
        if (indexOf != -1) {
            String substring = trim.substring(indexOf + 1);
            String substring2 = trim.substring(0, indexOf);
            if ("NULL".equalsIgnoreCase(substring2)) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer("toLevel:class=[");
            stringBuffer.append(substring);
            stringBuffer.append("]:pri=[");
            stringBuffer.append(substring2);
            stringBuffer.append("]");
            jep.O000000o(stringBuffer.toString());
            try {
                Class O00000Oo2 = jeo.O00000Oo(substring);
                Class[] clsArr = new Class[2];
                if (O00000oO == null) {
                    cls = O00000Oo("java.lang.String");
                    O00000oO = cls;
                } else {
                    cls = O00000oO;
                }
                clsArr[0] = cls;
                if (O00000oo == null) {
                    cls2 = O00000Oo("org.apache.log4j.Level");
                    O00000oo = cls2;
                } else {
                    cls2 = O00000oo;
                }
                clsArr[1] = cls2;
                return (Level) O00000Oo2.getMethod("toLevel", clsArr).invoke(null, substring2, level);
            } catch (ClassNotFoundException unused) {
                StringBuffer stringBuffer2 = new StringBuffer("custom level class [");
                stringBuffer2.append(substring);
                stringBuffer2.append("] not found.");
                jep.O00000o0(stringBuffer2.toString());
                return level;
            } catch (NoSuchMethodException e) {
                StringBuffer stringBuffer3 = new StringBuffer("custom level class [");
                stringBuffer3.append(substring);
                stringBuffer3.append("] does not have a class function toLevel(String, Level)");
                jep.O00000o0(stringBuffer3.toString(), e);
                return level;
            } catch (InvocationTargetException e2) {
                if ((e2.getTargetException() instanceof InterruptedException) || (e2.getTargetException() instanceof InterruptedIOException)) {
                    Thread.currentThread().interrupt();
                }
                StringBuffer stringBuffer4 = new StringBuffer("custom level class [");
                stringBuffer4.append(substring);
                stringBuffer4.append("] could not be instantiated");
                jep.O00000o0(stringBuffer4.toString(), e2);
                return level;
            } catch (ClassCastException e3) {
                StringBuffer stringBuffer5 = new StringBuffer("class [");
                stringBuffer5.append(substring);
                stringBuffer5.append("] is not a subclass of org.apache.log4j.Level");
                jep.O00000o0(stringBuffer5.toString(), e3);
                return level;
            } catch (IllegalAccessException e4) {
                StringBuffer stringBuffer6 = new StringBuffer("class [");
                stringBuffer6.append(substring);
                stringBuffer6.append("] cannot be instantiated due to access restrictions");
                jep.O00000o0(stringBuffer6.toString(), e4);
                return level;
            } catch (RuntimeException e5) {
                StringBuffer stringBuffer7 = new StringBuffer("class [");
                stringBuffer7.append(substring);
                stringBuffer7.append("], level [");
                stringBuffer7.append(substring2);
                stringBuffer7.append("] conversion failed.");
                jep.O00000o0(stringBuffer7.toString(), e5);
                return level;
            }
        } else if ("NULL".equalsIgnoreCase(trim)) {
            return null;
        } else {
            return Level.O000000o(trim, level);
        }
    }

    private static Class O00000Oo(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static String O000000o(String str, Properties properties) {
        String property = properties.getProperty(str);
        if (property == null) {
            return null;
        }
        try {
            return O00000Oo(property, properties);
        } catch (IllegalArgumentException e) {
            StringBuffer stringBuffer = new StringBuffer("Bad option value [");
            stringBuffer.append(property);
            stringBuffer.append("].");
            jep.O00000Oo(stringBuffer.toString(), e);
            return property;
        }
    }

    public static Object O000000o(String str, Class cls, Object obj) {
        if (str != null) {
            try {
                Class O00000Oo2 = jeo.O00000Oo(str);
                if (cls.isAssignableFrom(O00000Oo2)) {
                    return O00000Oo2.newInstance();
                }
                StringBuffer stringBuffer = new StringBuffer("A \"");
                stringBuffer.append(str);
                stringBuffer.append("\" object is not assignable to a \"");
                stringBuffer.append(cls.getName());
                stringBuffer.append("\" variable.");
                jep.O00000Oo(stringBuffer.toString());
                StringBuffer stringBuffer2 = new StringBuffer("The class \"");
                stringBuffer2.append(cls.getName());
                stringBuffer2.append("\" was loaded by ");
                jep.O00000Oo(stringBuffer2.toString());
                StringBuffer stringBuffer3 = new StringBuffer("[");
                stringBuffer3.append(cls.getClassLoader());
                stringBuffer3.append("] whereas object of type ");
                jep.O00000Oo(stringBuffer3.toString());
                StringBuffer stringBuffer4 = new StringBuffer(jdn.f1779O000000o);
                stringBuffer4.append(O00000Oo2.getName());
                stringBuffer4.append("\" was loaded by [");
                stringBuffer4.append(O00000Oo2.getClassLoader());
                stringBuffer4.append("].");
                jep.O00000Oo(stringBuffer4.toString());
                return obj;
            } catch (ClassNotFoundException e) {
                StringBuffer stringBuffer5 = new StringBuffer("Could not instantiate class [");
                stringBuffer5.append(str);
                stringBuffer5.append("].");
                jep.O00000Oo(stringBuffer5.toString(), e);
            } catch (IllegalAccessException e2) {
                StringBuffer stringBuffer6 = new StringBuffer("Could not instantiate class [");
                stringBuffer6.append(str);
                stringBuffer6.append("].");
                jep.O00000Oo(stringBuffer6.toString(), e2);
            } catch (InstantiationException e3) {
                StringBuffer stringBuffer7 = new StringBuffer("Could not instantiate class [");
                stringBuffer7.append(str);
                stringBuffer7.append("].");
                jep.O00000Oo(stringBuffer7.toString(), e3);
            } catch (RuntimeException e4) {
                StringBuffer stringBuffer8 = new StringBuffer("Could not instantiate class [");
                stringBuffer8.append(str);
                stringBuffer8.append("].");
                jep.O00000Oo(stringBuffer8.toString(), e4);
            }
        }
        return obj;
    }

    private static String O00000Oo(String str, Properties properties) throws IllegalArgumentException {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int indexOf = str.indexOf(f1798O000000o, i);
            if (indexOf != -1) {
                stringBuffer.append(str.substring(i, indexOf));
                int indexOf2 = str.indexOf(O00000Oo, indexOf);
                if (indexOf2 != -1) {
                    String substring = str.substring(indexOf + O00000o0, indexOf2);
                    String O000000o2 = O000000o(substring);
                    if (O000000o2 == null && properties != null) {
                        O000000o2 = properties.getProperty(substring);
                    }
                    if (O000000o2 != null) {
                        stringBuffer.append(O00000Oo(O000000o2, properties));
                    }
                    i = indexOf2 + O00000o;
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer(jdn.f1779O000000o);
                    stringBuffer2.append(str);
                    stringBuffer2.append("\" has no closing brace. Opening brace at position ");
                    stringBuffer2.append(indexOf);
                    stringBuffer2.append('.');
                    throw new IllegalArgumentException(stringBuffer2.toString());
                }
            } else if (i == 0) {
                return str;
            } else {
                stringBuffer.append(str.substring(i, str.length()));
                return stringBuffer.toString();
            }
        }
    }

    public static void O000000o(URL url, String str, jfb jfb) {
        jew jew;
        String file = url.getFile();
        if (str == null && file != null && file.endsWith(".xml")) {
            str = "org.apache.log4j.xml.DOMConfigurator";
        }
        if (str != null) {
            jep.O000000o("Preferred configurator class: ".concat(String.valueOf(str)));
            Class cls = O0000O0o;
            if (cls == null) {
                cls = O00000Oo("_m_j.jew");
                O0000O0o = cls;
            }
            jew = (jew) O000000o(str, cls, (Object) null);
            if (jew == null) {
                StringBuffer stringBuffer = new StringBuffer("Could not instantiate configurator [");
                stringBuffer.append(str);
                stringBuffer.append("].");
                jep.O00000Oo(stringBuffer.toString());
                return;
            }
        } else {
            jew = new jek();
        }
        jew.O000000o(url, jfb);
    }
}
