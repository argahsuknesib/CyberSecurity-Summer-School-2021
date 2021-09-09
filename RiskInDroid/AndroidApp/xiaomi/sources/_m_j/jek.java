package _m_j;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.log4j.Level;

public final class jek implements jew {
    static Class O00000o;
    static Class O00000o0;
    static Class O00000oO;
    static Class O00000oo;
    static Class O0000O0o;
    static Class O0000OOo;

    /* renamed from: O000000o  reason: collision with root package name */
    protected Hashtable f1791O000000o = new Hashtable(11);
    protected jfa O00000Oo = new jea();
    private jfb O0000Oo0;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jer.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.jer.O000000o(java.lang.String, java.util.Properties):java.lang.String
      _m_j.jer.O000000o(java.lang.String, org.apache.log4j.Level):org.apache.log4j.Level
      _m_j.jer.O000000o(java.lang.String, boolean):boolean */
    public final void O000000o(URL url, jfb jfb) {
        Properties properties = new Properties();
        jep.O000000o("Reading configuration from URL ".concat(String.valueOf(url)));
        InputStream inputStream = null;
        try {
            URLConnection openConnection = url.openConnection();
            openConnection.setUseCaches(false);
            inputStream = openConnection.getInputStream();
            properties.load(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (InterruptedIOException unused) {
                    Thread.currentThread().interrupt();
                } catch (IOException | RuntimeException unused2) {
                }
            }
            this.O0000Oo0 = jfb;
            String property = properties.getProperty("log4j.debug");
            if (property == null && (property = properties.getProperty("log4j.configDebug")) != null) {
                jep.O00000o0("[log4j.configDebug] is deprecated. Use [log4j.debug] instead.");
            }
            if (property != null) {
                jep.O000000o(jer.O000000o(property, true));
            }
            String property2 = properties.getProperty("log4j.reset");
            if (property2 != null && jer.O000000o(property2, false)) {
                jfb.O00000oO();
            }
            String O000000o2 = jer.O000000o("log4j.threshold", properties);
            if (O000000o2 != null) {
                jfb.O000000o(jer.O000000o(O000000o2, Level.O0000OOo));
                StringBuffer stringBuffer = new StringBuffer("Hierarchy threshold set to [");
                stringBuffer.append(jfb.O00000Oo());
                stringBuffer.append("].");
                jep.O000000o(stringBuffer.toString());
            }
            String O000000o3 = jer.O000000o("log4j.rootLogger", properties);
            if (O000000o3 == null) {
                O000000o3 = jer.O000000o("log4j.rootCategory", properties);
            }
            if (O000000o3 == null) {
                jep.O000000o("Could not find root logger information. Is this OK?");
            } else {
                jef O00000o2 = jfb.O00000o();
                synchronized (O00000o2) {
                    O000000o(properties, O00000o2, "root", O000000o3);
                }
            }
            String O000000o4 = jer.O000000o("log4j.loggerFactory", properties);
            if (O000000o4 != null) {
                StringBuffer stringBuffer2 = new StringBuffer("Setting category factory to [");
                stringBuffer2.append(O000000o4);
                stringBuffer2.append("].");
                jep.O000000o(stringBuffer2.toString());
                Class cls = O00000o0;
                if (cls == null) {
                    cls = O000000o("_m_j.jfa");
                    O00000o0 = cls;
                }
                this.O00000Oo = (jfa) jer.O000000o(O000000o4, cls, this.O00000Oo);
                jem.O000000o(this.O00000Oo, properties, "log4j.factory.");
            }
            O000000o(properties, jfb);
            jep.O000000o("Finished configuring.");
            this.f1791O000000o.clear();
        } catch (Exception e) {
            if ((e instanceof InterruptedIOException) || (e instanceof InterruptedException)) {
                Thread.currentThread().interrupt();
            }
            StringBuffer stringBuffer3 = new StringBuffer("Could not read configuration file from URL [");
            stringBuffer3.append(url);
            stringBuffer3.append("].");
            jep.O00000Oo(stringBuffer3.toString(), e);
            StringBuffer stringBuffer4 = new StringBuffer("Ignoring configuration file [");
            stringBuffer4.append(url);
            stringBuffer4.append("].");
            jep.O00000Oo(stringBuffer4.toString());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (InterruptedIOException unused3) {
                    Thread.currentThread().interrupt();
                } catch (IOException unused4) {
                } catch (RuntimeException unused5) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (InterruptedIOException unused6) {
                    Thread.currentThread().interrupt();
                } catch (IOException | RuntimeException unused7) {
                }
            }
            throw th;
        }
    }

    private static Class O000000o(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jer.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.jer.O000000o(java.lang.String, java.util.Properties):java.lang.String
      _m_j.jer.O000000o(java.lang.String, org.apache.log4j.Level):org.apache.log4j.Level
      _m_j.jer.O000000o(java.lang.String, boolean):boolean */
    private void O000000o(Properties properties, jfb jfb) {
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            if (str.startsWith("log4j.category.") || str.startsWith("log4j.logger.")) {
                String str2 = null;
                if (str.startsWith("log4j.category.")) {
                    str2 = str.substring(15);
                } else if (str.startsWith("log4j.logger.")) {
                    str2 = str.substring(13);
                }
                String O000000o2 = jer.O000000o(str, properties);
                jef O000000o3 = jfb.O000000o(str2, this.O00000Oo);
                synchronized (O000000o3) {
                    O000000o(properties, O000000o3, str2, O000000o2);
                    String O000000o4 = jer.O000000o("log4j.additivity.".concat(String.valueOf(str2)), properties);
                    StringBuffer stringBuffer = new StringBuffer("Handling log4j.additivity.");
                    stringBuffer.append(str2);
                    stringBuffer.append("=[");
                    stringBuffer.append(O000000o4);
                    stringBuffer.append("]");
                    jep.O000000o(stringBuffer.toString());
                    if (O000000o4 != null && !O000000o4.equals("")) {
                        boolean O000000o5 = jer.O000000o(O000000o4, true);
                        StringBuffer stringBuffer2 = new StringBuffer("Setting additivity for \"");
                        stringBuffer2.append(str2);
                        stringBuffer2.append("\" to ");
                        stringBuffer2.append(O000000o5);
                        jep.O000000o(stringBuffer2.toString());
                        O000000o3.O000000o(O000000o5);
                    }
                }
            } else if (str.startsWith("log4j.renderer.")) {
                String substring = str.substring(15);
                String O000000o6 = jer.O000000o(str, properties);
                if (jfb instanceof jff) {
                    jev.O000000o((jff) jfb, substring, O000000o6);
                }
            } else if (str.equals("log4j.throwableRenderer") && (jfb instanceof jfj)) {
                Class cls = O00000o;
                if (cls == null) {
                    cls = O000000o("_m_j.jfi");
                    O00000o = cls;
                }
                jfi jfi = (jfi) jer.O000000o(properties, "log4j.throwableRenderer", cls);
                if (jfi == null) {
                    jep.O00000Oo("Could not instantiate throwableRenderer.");
                } else {
                    new jem(jfi).O000000o(properties, "log4j.throwableRenderer.");
                    ((jfj) jfb).O000000o(jfi);
                }
            }
        }
    }

    private void O000000o(Properties properties, jef jef, String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer("Parsing for [");
        stringBuffer.append(str);
        stringBuffer.append("] with value=[");
        stringBuffer.append(str2);
        stringBuffer.append("].");
        jep.O000000o(stringBuffer.toString());
        StringTokenizer stringTokenizer = new StringTokenizer(str2, ",");
        if (!str2.startsWith(",") && !str2.equals("")) {
            if (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                StringBuffer stringBuffer2 = new StringBuffer("Level token is [");
                stringBuffer2.append(nextToken);
                stringBuffer2.append("].");
                jep.O000000o(stringBuffer2.toString());
                if (!"inherited".equalsIgnoreCase(nextToken) && !"null".equalsIgnoreCase(nextToken)) {
                    jef.O000000o(jer.O000000o(nextToken, Level.O00000oo));
                } else if (str.equals("root")) {
                    jep.O00000o0("The root logger cannot be set to null.");
                } else {
                    jef.O000000o((Level) null);
                }
                StringBuffer stringBuffer3 = new StringBuffer("Category ");
                stringBuffer3.append(str);
                stringBuffer3.append(" set to ");
                stringBuffer3.append(jef.O00000oo());
                jep.O000000o(stringBuffer3.toString());
            } else {
                return;
            }
        }
        jef.O0000Oo0();
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if (trim != null && !trim.equals(",")) {
                StringBuffer stringBuffer4 = new StringBuffer("Parsing appender named \"");
                stringBuffer4.append(trim);
                stringBuffer4.append("\".");
                jep.O000000o(stringBuffer4.toString());
                jdx O000000o2 = O000000o(properties, trim);
                if (O000000o2 != null) {
                    jef.O000000o(O000000o2);
                }
            }
        }
    }

    private static void O000000o(Properties properties, String str, jdx jdx) {
        String str2;
        String str3;
        StringBuffer stringBuffer = new StringBuffer("log4j.appender.");
        stringBuffer.append(str);
        stringBuffer.append(".filter.");
        String stringBuffer2 = stringBuffer.toString();
        int length = stringBuffer2.length();
        Hashtable hashtable = new Hashtable();
        Enumeration keys = properties.keys();
        String str4 = "";
        while (keys.hasMoreElements()) {
            String str5 = (String) keys.nextElement();
            if (str5.startsWith(stringBuffer2)) {
                int indexOf = str5.indexOf(46, length);
                if (indexOf != -1) {
                    str3 = str5.substring(0, indexOf);
                    str2 = str5.substring(indexOf + 1);
                } else {
                    str2 = str4;
                    str3 = str5;
                }
                Vector vector = (Vector) hashtable.get(str3);
                if (vector == null) {
                    vector = new Vector();
                    hashtable.put(str3, vector);
                }
                if (indexOf != -1) {
                    vector.add(new jei(str2, jer.O000000o(str5, properties)));
                }
                str4 = str2;
            }
        }
        jel jel = new jel(hashtable);
        while (jel.hasMoreElements()) {
            String str6 = (String) jel.nextElement();
            String property = properties.getProperty(str6);
            if (property != null) {
                StringBuffer stringBuffer3 = new StringBuffer("Filter key: [");
                stringBuffer3.append(str6);
                stringBuffer3.append("] class: [");
                stringBuffer3.append(properties.getProperty(str6));
                stringBuffer3.append("] props: ");
                stringBuffer3.append(hashtable.get(str6));
                jep.O000000o(stringBuffer3.toString());
                Class cls = O0000OOo;
                if (cls == null) {
                    cls = O000000o("_m_j.jez");
                    O0000OOo = cls;
                }
                jez jez = (jez) jer.O000000o(property, cls, (Object) null);
                if (jez != null) {
                    jem jem = new jem(jez);
                    Enumeration elements = ((Vector) hashtable.get(str6)).elements();
                    while (elements.hasMoreElements()) {
                        jei jei = (jei) elements.nextElement();
                        jem.O000000o(jei.f1790O000000o, jei.O00000Oo);
                    }
                    StringBuffer stringBuffer4 = new StringBuffer("Adding filter of type [");
                    stringBuffer4.append(jez.getClass());
                    stringBuffer4.append("] to appender named [");
                    stringBuffer4.append(jdx.O000000o());
                    stringBuffer4.append("].");
                    jep.O000000o(stringBuffer4.toString());
                }
            } else {
                StringBuffer stringBuffer5 = new StringBuffer("Missing class definition for filter: [");
                stringBuffer5.append(str6);
                stringBuffer5.append("]");
                jep.O00000o0(stringBuffer5.toString());
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jer.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.jer.O000000o(java.lang.String, java.util.Properties):java.lang.String
      _m_j.jer.O000000o(java.lang.String, org.apache.log4j.Level):org.apache.log4j.Level
      _m_j.jer.O000000o(java.lang.String, boolean):boolean */
    private jdx O000000o(Properties properties, String str) {
        Properties properties2 = properties;
        String str2 = str;
        jdx jdx = (jdx) this.f1791O000000o.get(str2);
        if (jdx != null) {
            StringBuffer stringBuffer = new StringBuffer("Appender \"");
            stringBuffer.append(str2);
            stringBuffer.append("\" was already parsed.");
            jep.O000000o(stringBuffer.toString());
            return jdx;
        }
        String concat = "log4j.appender.".concat(String.valueOf(str));
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(concat);
        stringBuffer2.append(".layout");
        String stringBuffer3 = stringBuffer2.toString();
        Class cls = O00000oO;
        if (cls == null) {
            cls = O000000o("_m_j.jdx");
            O00000oO = cls;
        }
        jdx jdx2 = (jdx) jer.O000000o(properties2, concat, cls);
        if (jdx2 == null) {
            StringBuffer stringBuffer4 = new StringBuffer("Could not instantiate appender named \"");
            stringBuffer4.append(str2);
            stringBuffer4.append("\".");
            jep.O00000Oo(stringBuffer4.toString());
            return null;
        }
        if (jdx2 instanceof jfe) {
            if (jdx2.O00000Oo()) {
                Class cls2 = O00000oo;
                if (cls2 == null) {
                    cls2 = O000000o("_m_j.jed");
                    O00000oo = cls2;
                }
                jed jed = (jed) jer.O000000o(properties2, stringBuffer3, cls2);
                if (jed != null) {
                    StringBuffer stringBuffer5 = new StringBuffer("Parsing layout options for \"");
                    stringBuffer5.append(str2);
                    stringBuffer5.append("\".");
                    jep.O000000o(stringBuffer5.toString());
                    StringBuffer stringBuffer6 = new StringBuffer();
                    stringBuffer6.append(stringBuffer3);
                    stringBuffer6.append(".");
                    jem.O000000o(jed, properties2, stringBuffer6.toString());
                    StringBuffer stringBuffer7 = new StringBuffer("End of parsing for \"");
                    stringBuffer7.append(str2);
                    stringBuffer7.append("\".");
                    jep.O000000o(stringBuffer7.toString());
                }
            }
            StringBuffer stringBuffer8 = new StringBuffer();
            stringBuffer8.append(concat);
            stringBuffer8.append(".errorhandler");
            String stringBuffer9 = stringBuffer8.toString();
            if (jer.O000000o(stringBuffer9, properties2) != null) {
                Class cls3 = O0000O0o;
                if (cls3 == null) {
                    cls3 = O000000o("_m_j.jey");
                    O0000O0o = cls3;
                }
                jey jey = (jey) jer.O000000o(properties2, stringBuffer9, cls3);
                if (jey != null) {
                    StringBuffer stringBuffer10 = new StringBuffer("Parsing errorhandler options for \"");
                    stringBuffer10.append(str2);
                    stringBuffer10.append("\".");
                    jep.O000000o(stringBuffer10.toString());
                    jfb jfb = this.O0000Oo0;
                    StringBuffer stringBuffer11 = new StringBuffer();
                    stringBuffer11.append(stringBuffer9);
                    stringBuffer11.append("root-ref");
                    if (jer.O000000o(jer.O000000o(stringBuffer11.toString(), properties2), false)) {
                        jfb.O00000o();
                    }
                    StringBuffer stringBuffer12 = new StringBuffer();
                    stringBuffer12.append(stringBuffer9);
                    stringBuffer12.append("logger-ref");
                    String O000000o2 = jer.O000000o(stringBuffer12.toString(), properties2);
                    if (O000000o2 != null) {
                        jfa jfa = this.O00000Oo;
                        if (jfa == null) {
                            jfb.O000000o(O000000o2);
                        } else {
                            jfb.O000000o(O000000o2, jfa);
                        }
                    }
                    StringBuffer stringBuffer13 = new StringBuffer();
                    stringBuffer13.append(stringBuffer9);
                    stringBuffer13.append("appender-ref");
                    String O000000o3 = jer.O000000o(stringBuffer13.toString(), properties2);
                    if (O000000o3 != null) {
                        O000000o(properties2, O000000o3);
                    }
                    Properties properties3 = new Properties();
                    int i = 3;
                    StringBuffer stringBuffer14 = new StringBuffer();
                    stringBuffer14.append(stringBuffer9);
                    stringBuffer14.append(".root-ref");
                    StringBuffer stringBuffer15 = new StringBuffer();
                    stringBuffer15.append(stringBuffer9);
                    stringBuffer15.append(".logger-ref");
                    StringBuffer stringBuffer16 = new StringBuffer();
                    stringBuffer16.append(stringBuffer9);
                    stringBuffer16.append(".appender-ref");
                    String[] strArr = {stringBuffer14.toString(), stringBuffer15.toString(), stringBuffer16.toString()};
                    for (Map.Entry entry : properties.entrySet()) {
                        int i2 = 0;
                        while (true) {
                            if (i2 < i) {
                                if (strArr[i2].equals(entry.getKey())) {
                                    i = 3;
                                    break;
                                }
                                i2++;
                                i = 3;
                            } else {
                                break;
                            }
                        }
                        if (i2 == i) {
                            properties3.put(entry.getKey(), entry.getValue());
                        }
                    }
                    StringBuffer stringBuffer17 = new StringBuffer();
                    stringBuffer17.append(stringBuffer9);
                    stringBuffer17.append(".");
                    jem.O000000o(jey, properties3, stringBuffer17.toString());
                    StringBuffer stringBuffer18 = new StringBuffer("End of errorhandler parsing for \"");
                    stringBuffer18.append(str2);
                    stringBuffer18.append("\".");
                    jep.O000000o(stringBuffer18.toString());
                }
            }
            StringBuffer stringBuffer19 = new StringBuffer();
            stringBuffer19.append(concat);
            stringBuffer19.append(".");
            jem.O000000o(jdx2, properties2, stringBuffer19.toString());
            StringBuffer stringBuffer20 = new StringBuffer("Parsed \"");
            stringBuffer20.append(str2);
            stringBuffer20.append("\" options.");
            jep.O000000o(stringBuffer20.toString());
        }
        O000000o(properties2, str2, jdx2);
        this.f1791O000000o.put(jdx2.O000000o(), jdx2);
        return jdx2;
    }
}
