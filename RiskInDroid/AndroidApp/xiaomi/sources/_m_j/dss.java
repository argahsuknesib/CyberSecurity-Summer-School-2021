package _m_j;

import _m_j.dtl;
import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.AbstractConfigValue;
import com.typesafe.config.impl.ConfigBoolean;
import com.typesafe.config.impl.ConfigDouble;
import com.typesafe.config.impl.ConfigImpl$1;
import com.typesafe.config.impl.ConfigInt;
import com.typesafe.config.impl.ConfigLong;
import com.typesafe.config.impl.ConfigNull;
import com.typesafe.config.impl.ConfigNumber;
import com.typesafe.config.impl.ConfigString;
import com.typesafe.config.impl.FromMapMode;
import com.typesafe.config.impl.ResolveStatus;
import com.typesafe.config.impl.SimpleConfigList;
import com.typesafe.config.impl.SimpleConfigObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;

public final class dss {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final dsi f14899O000000o = dtj.O000000o("hardcoded value");
    private static final ConfigBoolean O00000Oo = new ConfigBoolean(f14899O000000o, true);
    private static final ConfigNull O00000o = new ConfigNull(f14899O000000o);
    private static final ConfigBoolean O00000o0 = new ConfigBoolean(f14899O000000o, false);
    private static final SimpleConfigList O00000oO = new SimpleConfigList(f14899O000000o, Collections.emptyList());
    private static final SimpleConfigObject O00000oo = SimpleConfigObject.O00000o0(f14899O000000o);

    static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        static final dso f14901O000000o = dss.O00000o();
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final dsb f14902O000000o = new dtl(null);
    }

    static class O0000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        static volatile dso f14904O000000o = dss.O00000Oo();
    }

    static class O0000Oo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final O0000OOo f14905O000000o = new O0000OOo();
    }

    static class O0000OOo {

        /* renamed from: O000000o  reason: collision with root package name */
        private dry f14903O000000o = null;
        private ClassLoader O00000Oo = null;
        private Map<String, dry> O00000o0 = new HashMap();

        O0000OOo() {
        }

        /* access modifiers changed from: package-private */
        public final synchronized dry O000000o(ClassLoader classLoader, String str, Callable<dry> callable) {
            dry dry;
            if (classLoader != this.O00000Oo) {
                this.O00000o0.clear();
                this.O00000Oo = classLoader;
            }
            dry O00000o02 = dss.O00000o0();
            if (O00000o02 != this.f14903O000000o) {
                this.O00000o0.clear();
                this.f14903O000000o = O00000o02;
            }
            dry = this.O00000o0.get(str);
            if (dry == null) {
                try {
                    dry = callable.call();
                    if (dry != null) {
                        this.O00000o0.put(str, dry);
                    } else {
                        throw new ConfigException.BugOrBroken("null config from cache updater");
                    }
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new ConfigException.Generic(e2.getMessage(), e2);
                }
            }
            return dry;
        }
    }

    private static dry O000000o(ClassLoader classLoader, String str, Callable<dry> callable) {
        try {
            return O0000Oo0.f14905O000000o.O000000o(classLoader, str, callable);
        } catch (ExceptionInInitializerError e) {
            throw dst.O000000o(e);
        }
    }

    static class O0000O0o implements dtl.O000000o {
        O0000O0o() {
        }

        public final dsk O000000o(String str, dsj dsj) {
            return dsz.O000000o(new File(str), dsj);
        }
    }

    static class O000000o implements dtl.O000000o {
        O000000o() {
        }

        public final dsk O000000o(String str, dsj dsj) {
            return dsz.O000000o(str, dsj);
        }
    }

    public static dsh O000000o(String str, dsj dsj) {
        return dtl.O000000o(new O000000o(), str, dsj);
    }

    public static dsh O000000o(File file, dsj dsj) {
        return dtl.O000000o(new O0000O0o(), file.getPath(), dsj);
    }

    static AbstractConfigValue O000000o(Object obj, dsi dsi, FromMapMode fromMapMode) {
        if (dsi == null) {
            throw new ConfigException.BugOrBroken("origin not supposed to be null");
        } else if (obj == null) {
            if (dsi != f14899O000000o) {
                return new ConfigNull(dsi);
            }
            return O00000o;
        } else if (obj instanceof Boolean) {
            if (dsi != f14899O000000o) {
                return new ConfigBoolean(dsi, ((Boolean) obj).booleanValue());
            }
            if (((Boolean) obj).booleanValue()) {
                return O00000Oo;
            }
            return O00000o0;
        } else if (obj instanceof String) {
            return new ConfigString(dsi, (String) obj);
        } else {
            if (obj instanceof Number) {
                if (obj instanceof Double) {
                    return new ConfigDouble(dsi, ((Double) obj).doubleValue(), null);
                }
                if (obj instanceof Integer) {
                    return new ConfigInt(dsi, ((Integer) obj).intValue(), null);
                }
                if (obj instanceof Long) {
                    return new ConfigLong(dsi, ((Long) obj).longValue(), null);
                }
                return ConfigNumber.O000000o(dsi, ((Number) obj).doubleValue(), (String) null);
            } else if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.isEmpty()) {
                    if (dsi == f14899O000000o) {
                        return O00000oo;
                    }
                    return SimpleConfigObject.O00000o0(dsi);
                } else if (fromMapMode != FromMapMode.KEYS_ARE_KEYS) {
                    return dtd.O000000o(dsi, map);
                } else {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry entry : map.entrySet()) {
                        Object key = entry.getKey();
                        if (key instanceof String) {
                            hashMap.put((String) key, O000000o(entry.getValue(), dsi, fromMapMode));
                        } else {
                            throw new ConfigException.BugOrBroken("bug in method caller: not valid to create ConfigObject from map with non-String key: ".concat(String.valueOf(key)));
                        }
                    }
                    return new SimpleConfigObject(dsi, hashMap);
                }
            } else if (obj instanceof Iterable) {
                Iterator it = ((Iterable) obj).iterator();
                if (it.hasNext()) {
                    ArrayList arrayList = new ArrayList();
                    while (it.hasNext()) {
                        arrayList.add(O000000o(it.next(), dsi, fromMapMode));
                    }
                    return new SimpleConfigList(dsi, arrayList);
                } else if (dsi == null || dsi == f14899O000000o) {
                    return O00000oO;
                } else {
                    return new SimpleConfigList(dsi, Collections.emptyList());
                }
            } else {
                throw new ConfigException.BugOrBroken("bug in method caller: not valid to create ConfigValue from: ".concat(String.valueOf(obj)));
            }
        }
    }

    static dsb O000000o() {
        try {
            return O00000o0.f14902O000000o;
        } catch (ExceptionInInitializerError e) {
            throw dst.O000000o(e);
        }
    }

    private static Properties O0000O0o() {
        Properties properties = System.getProperties();
        Properties properties2 = new Properties();
        synchronized (properties) {
            properties2.putAll(properties);
        }
        return properties2;
    }

    public static dso O00000Oo() {
        return (dso) dsz.O000000o(O0000O0o(), dsj.O000000o().O000000o("system properties")).O00000oO();
    }

    private static dso O0000OOo() {
        try {
            return O0000Oo.f14904O000000o;
        } catch (ExceptionInInitializerError e) {
            throw dst.O000000o(e);
        }
    }

    public static dry O00000o0() {
        return O0000OOo().config;
    }

    public static dso O00000o() {
        Map<String, String> map = System.getenv();
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            hashMap.put(str, new ConfigString(dtj.O000000o("env var ".concat(String.valueOf(str))), (String) next.getValue()));
        }
        return new SimpleConfigObject(dtj.O000000o("env variables"), hashMap, ResolveStatus.RESOLVED, false);
    }

    static dso O00000oO() {
        try {
            return O00000o.f14901O000000o;
        } catch (ExceptionInInitializerError e) {
            throw dst.O000000o(e);
        }
    }

    public static dry O000000o(ClassLoader classLoader) {
        return O000000o(classLoader, "defaultReference", new ConfigImpl$1(classLoader));
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private static String f14900O000000o = "loads";
        private static final Map<String, Boolean> O00000Oo;
        private static final boolean O00000o0;

        static boolean O000000o() {
            return O00000o0;
        }

        static {
            HashMap hashMap = new HashMap();
            hashMap.put(f14900O000000o, Boolean.FALSE);
            String property = System.getProperty("config.trace");
            if (property != null) {
                for (String str : property.split(",")) {
                    if (str.equals(f14900O000000o)) {
                        hashMap.put(f14900O000000o, Boolean.TRUE);
                    } else {
                        System.err.println("config.trace property contains unknown trace topic '" + str + "'");
                    }
                }
            }
            O00000Oo = hashMap;
            O00000o0 = ((Boolean) hashMap.get(f14900O000000o)).booleanValue();
        }
    }

    public static boolean O00000oo() {
        try {
            return O00000Oo.O000000o();
        } catch (ExceptionInInitializerError e) {
            throw dst.O000000o(e);
        }
    }

    public static void O000000o(String str) {
        System.err.println(str);
    }

    static ConfigException.NotResolved O000000o(dtb dtb, ConfigException.NotResolved notResolved) {
        String str = dtb.O00000o() + " has not been resolved, you need to call Config#resolve(), see API docs for Config#resolve()";
        if (str.equals(notResolved.getMessage())) {
            return notResolved;
        }
        return new ConfigException.NotResolved(str, notResolved);
    }
}
