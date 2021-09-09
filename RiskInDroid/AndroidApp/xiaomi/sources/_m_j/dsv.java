package _m_j;

import com.typesafe.config.ConfigValueType;
import com.typesafe.config.impl.AbstractConfigValue;
import com.typesafe.config.impl.ConfigBoolean;
import com.typesafe.config.impl.ConfigLong;
import com.typesafe.config.impl.ConfigNull;
import com.typesafe.config.impl.ConfigString;
import com.typesafe.config.impl.SimpleConfigList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class dsv {
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009a, code lost:
        return new com.typesafe.config.impl.ConfigDouble(r5.origin, java.lang.Double.valueOf(java.lang.Double.parseDouble(r0)).doubleValue(), r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0087 */
    static AbstractConfigValue O000000o(AbstractConfigValue abstractConfigValue, ConfigValueType configValueType) {
        if (abstractConfigValue.O00000o0() == ConfigValueType.STRING) {
            String str = (String) abstractConfigValue.O00000o();
            int i = AnonymousClass2.f14907O000000o[configValueType.ordinal()];
            if (i == 1) {
                return new ConfigLong(abstractConfigValue.origin, Long.valueOf(Long.parseLong(str)).longValue(), str);
            } else if (i != 2) {
                if (i == 3) {
                    if (str.equals("true") || str.equals("yes") || str.equals("on")) {
                        return new ConfigBoolean(abstractConfigValue.origin, true);
                    }
                    if (str.equals("false") || str.equals("no") || str.equals("off")) {
                        return new ConfigBoolean(abstractConfigValue.origin, false);
                    }
                }
            } else if (str.equals("null")) {
                return new ConfigNull(abstractConfigValue.origin);
            }
        } else if (configValueType == ConfigValueType.STRING) {
            int i2 = AnonymousClass2.f14907O000000o[abstractConfigValue.O00000o0().ordinal()];
            if (i2 == 1 || i2 == 3) {
                return new ConfigString(abstractConfigValue.origin, abstractConfigValue.O0000OoO());
            }
        } else if (configValueType == ConfigValueType.LIST && abstractConfigValue.O00000o0() == ConfigValueType.OBJECT) {
            dso dso = (dso) abstractConfigValue;
            HashMap hashMap = new HashMap();
            for (String str2 : dso.keySet()) {
                try {
                    int parseInt = Integer.parseInt(str2, 10);
                    if (parseInt >= 0) {
                        hashMap.put(Integer.valueOf(parseInt), dso.get((Object) str2));
                    }
                } catch (NumberFormatException unused) {
                }
            }
            if (!hashMap.isEmpty()) {
                ArrayList arrayList = new ArrayList(hashMap.entrySet());
                Collections.sort(arrayList, new Comparator<Map.Entry<Integer, AbstractConfigValue>>() {
                    /* class _m_j.dsv.AnonymousClass1 */

                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        return Integer.valueOf(((Integer) ((Map.Entry) obj).getKey()).intValue()).compareTo((Integer) ((Map.Entry) obj2).getKey());
                    }
                });
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((Map.Entry) it.next()).getValue());
                }
                return new SimpleConfigList(abstractConfigValue.origin, arrayList2);
            }
        }
        return abstractConfigValue;
    }

    /* renamed from: _m_j.dsv$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f14907O000000o = new int[ConfigValueType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|(3:11|12|14)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f14907O000000o[ConfigValueType.NUMBER.ordinal()] = 1;
            f14907O000000o[ConfigValueType.NULL.ordinal()] = 2;
            f14907O000000o[ConfigValueType.BOOLEAN.ordinal()] = 3;
            f14907O000000o[ConfigValueType.LIST.ordinal()] = 4;
            f14907O000000o[ConfigValueType.OBJECT.ordinal()] = 5;
            try {
                f14907O000000o[ConfigValueType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
