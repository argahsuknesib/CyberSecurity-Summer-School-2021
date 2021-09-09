package _m_j;

import com.typesafe.config.ConfigException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public final class drz {
    private static dsj O000000o(dsj dsj, String str) {
        if (dsj.O00000Oo() != null) {
            return dsj;
        }
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            return dsj.O000000o(contextClassLoader);
        }
        throw new ConfigException.BugOrBroken("Context class loader is not set for the current thread; if Thread.currentThread().getContextClassLoader() returns null, you must pass a ClassLoader explicitly to ConfigFactory.".concat(String.valueOf(str)));
    }

    public static dry O000000o(dsj dsj, dsm dsm) {
        ClassLoader O00000Oo = dsj.O00000Oo();
        if (O00000Oo != null) {
            String property = System.getProperty("config.resource");
            int i = property != null ? 1 : 0;
            String property2 = System.getProperty("config.file");
            if (property2 != null) {
                i++;
            }
            String property3 = System.getProperty("config.url");
            if (property3 != null) {
                i++;
            }
            if (i == 0) {
                dsj O000000o2 = O000000o(dsj.O000000o(O00000Oo), "load");
                return O000000o(O000000o2.O00000Oo(), O000000o("application", O000000o2), dsm);
            } else if (i <= 1) {
                dsj O000000o3 = dsj.O000000o(false);
                if (property != null) {
                    if (property.startsWith("/")) {
                        property = property.substring(1);
                    }
                    return O000000o(O00000Oo, dsz.O000000o(property, O000000o(O000000o3.O000000o(O00000Oo), "parseResources")).O00000oO().O000000o(), dsm);
                } else if (property2 != null) {
                    return O000000o(O00000Oo, dsz.O000000o(new File(property2), O000000o3).O00000oO().O000000o(), dsm);
                } else {
                    try {
                        return O000000o(O00000Oo, O000000o(new URL(property3), O000000o3), dsm);
                    } catch (MalformedURLException e) {
                        throw new ConfigException.Generic("Bad URL in config.url system property: '" + property3 + "': " + e.getMessage(), e);
                    }
                }
            } else {
                throw new ConfigException.Generic("You set more than one of config.file='" + property2 + "', config.url='" + property3 + "', config.resource='" + property + "'; don't know which one to use!");
            }
        } else {
            throw new ConfigException.BugOrBroken("ClassLoader should have been set here; bug in ConfigFactory. (You can probably work around this bug by passing in a class loader or calling currentThread().setContextClassLoader() though.)");
        }
    }

    public static dry O000000o(URL url, dsj dsj) {
        return dsz.O000000o(url, dsj).O00000oO().O000000o();
    }

    public static dry O000000o(File file, dsj dsj) {
        return dss.O000000o(file, dsj).O000000o();
    }

    public static dry O000000o(String str, dsj dsj) {
        return dss.O000000o(str, dsj).O000000o();
    }

    private static dry O000000o(ClassLoader classLoader, dry dry, dsm dsm) {
        return dss.O00000o0().O000000o(dry).O000000o(dss.O000000o(classLoader)).O000000o(dsm);
    }
}
