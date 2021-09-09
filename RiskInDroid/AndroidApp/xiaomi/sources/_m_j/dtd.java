package _m_j;

import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.ConfigString;
import com.typesafe.config.impl.FromMapMode;
import com.typesafe.config.impl.ResolveStatus;
import com.typesafe.config.impl.SimpleConfigObject;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

final class dtd {
    static dso O000000o(Reader reader, dsi dsi) throws IOException {
        Properties properties = new Properties();
        properties.load(reader);
        return O000000o(dsi, properties);
    }

    private static String O000000o(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }

    private static String O00000Oo(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    private static dtb O00000o0(String str) {
        String O000000o2 = O000000o(str);
        String O00000Oo = O00000Oo(str);
        dtb dtb = new dtb(O000000o2, null);
        while (O00000Oo != null) {
            String O000000o3 = O000000o(O00000Oo);
            O00000Oo = O00000Oo(O00000Oo);
            dtb = new dtb(O000000o3, dtb);
        }
        return dtb;
    }

    static dso O000000o(dsi dsi, Properties properties) {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : properties.entrySet()) {
            Object key = entry.getKey();
            if (key instanceof String) {
                hashMap.put(O00000o0((String) key), entry.getValue());
            }
        }
        return O000000o(dsi, hashMap, true);
    }

    static dso O000000o(dsi dsi, Map<?, ?> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            if (key instanceof String) {
                hashMap.put(dta.O000000o((String) key), next.getValue());
            } else {
                throw new ConfigException.BugOrBroken("Map has a non-string as a key, expecting a path expression as a String");
            }
        }
        return O000000o(dsi, hashMap, false);
    }

    private static dso O000000o(dsi dsi, Map<dtb, Object> map, boolean z) {
        Object obj;
        HashSet<dtb> hashSet = new HashSet<>();
        HashSet<dtb> hashSet2 = new HashSet<>();
        for (dtb next : map.keySet()) {
            hashSet2.add(next);
            for (dtb O000000o2 = next.O000000o(); O000000o2 != null; O000000o2 = O000000o2.O000000o()) {
                hashSet.add(O000000o2);
            }
        }
        if (z) {
            hashSet2.removeAll(hashSet);
        } else {
            for (dtb dtb : hashSet2) {
                if (hashSet.contains(dtb)) {
                    throw new ConfigException.BugOrBroken("In the map, path '" + dtb.O00000o() + "' occurs as both the parent object of a value and as a value. Because Map has no defined ordering, this is a broken situation.");
                }
            }
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (dtb put : hashSet) {
            hashMap2.put(put, new HashMap());
        }
        for (dtb dtb2 : hashSet2) {
            dtb O000000o3 = dtb2.O000000o();
            Map map2 = O000000o3 != null ? (Map) hashMap2.get(O000000o3) : hashMap;
            String O00000Oo = dtb2.O00000Oo();
            Object obj2 = map.get(dtb2);
            if (z) {
                obj = obj2 instanceof String ? new ConfigString(dsi, (String) obj2) : null;
            } else {
                obj = dss.O000000o(map.get(dtb2), dsi, FromMapMode.KEYS_ARE_PATHS);
            }
            if (obj != null) {
                map2.put(O00000Oo, obj);
            }
        }
        ArrayList<dtb> arrayList = new ArrayList<>();
        arrayList.addAll(hashSet);
        Collections.sort(arrayList, new Comparator<dtb>() {
            /* class _m_j.dtd.AnonymousClass1 */

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return ((dtb) obj2).O00000o0() - ((dtb) obj).O00000o0();
            }
        });
        for (dtb dtb3 : arrayList) {
            Map map3 = (Map) hashMap2.get(dtb3);
            dtb O000000o4 = dtb3.O000000o();
            (O000000o4 != null ? (Map) hashMap2.get(O000000o4) : hashMap).put(dtb3.O00000Oo(), new SimpleConfigObject(dsi, map3, ResolveStatus.RESOLVED, false));
        }
        return new SimpleConfigObject(dsi, hashMap, ResolveStatus.RESOLVED, false);
    }
}
