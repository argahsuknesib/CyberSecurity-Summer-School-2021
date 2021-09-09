package _m_j;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.Level;

public final class jee {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Object f1786O000000o;
    private static jfg O00000Oo = new jex(new jec(new jfh(Level.O00000oo)));

    static {
        URL url;
        String O000000o2 = jer.O000000o("log4j.defaultInitOverride");
        if (O000000o2 == null || "false".equalsIgnoreCase(O000000o2)) {
            String O000000o3 = jer.O000000o("log4j.configuration");
            String O000000o4 = jer.O000000o("log4j.configuratorClass");
            if (O000000o3 == null) {
                url = jeo.O000000o("log4j.xml");
                if (url == null) {
                    url = jeo.O000000o("log4j.properties");
                }
            } else {
                try {
                    url = new URL(O000000o3);
                } catch (MalformedURLException unused) {
                    url = jeo.O000000o(O000000o3);
                }
            }
            if (url != null) {
                StringBuffer stringBuffer = new StringBuffer("Using URL [");
                stringBuffer.append(url);
                stringBuffer.append("] for automatic log4j configuration.");
                jep.O000000o(stringBuffer.toString());
                try {
                    jer.O000000o(url, O000000o4, O00000Oo());
                } catch (NoClassDefFoundError e) {
                    jep.O00000o0("Error during default initialization", e);
                }
            } else {
                StringBuffer stringBuffer2 = new StringBuffer("Could not find resource: [");
                stringBuffer2.append(O000000o3);
                stringBuffer2.append("].");
                jep.O000000o(stringBuffer2.toString());
            }
        } else {
            jep.O000000o("Default initialization of overridden by log4j.defaultInitOverrideproperty.");
        }
    }

    private static jfb O00000Oo() {
        if (O00000Oo == null) {
            O00000Oo = new jex(new jfd());
            f1786O000000o = null;
            IllegalStateException illegalStateException = new IllegalStateException("Class invariant violation");
            StringWriter stringWriter = new StringWriter();
            illegalStateException.printStackTrace(new PrintWriter(stringWriter));
            if (stringWriter.toString().indexOf("org.apache.catalina.loader.WebappClassLoader.stop") != -1) {
                jep.O000000o("log4j called after unloading, see http://logging.apache.org/log4j/1.2/faq.html#unload.", illegalStateException);
            } else {
                jep.O00000Oo("log4j called after unloading, see http://logging.apache.org/log4j/1.2/faq.html#unload.", illegalStateException);
            }
        }
        return O00000Oo.O000000o();
    }

    public static jef O000000o() {
        return O00000Oo().O00000o();
    }

    public static jef O000000o(String str) {
        return O00000Oo().O000000o(str);
    }
}
