package _m_j;

import com.google.android.exoplayer2.C;
import com.tencent.mmkv.MMKVRecoverStrategic;
import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.OriginType;
import com.typesafe.config.impl.SerializedConfigValue;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class dtj implements dsi {

    /* renamed from: O000000o  reason: collision with root package name */
    final String f14922O000000o;
    final int O00000Oo;
    final OriginType O00000o;
    final int O00000o0;
    final List<String> O00000oO;
    private final String O00000oo;

    public dtj(String str, int i, int i2, OriginType originType, String str2, List<String> list) {
        if (str != null) {
            this.f14922O000000o = str;
            this.O00000Oo = i;
            this.O00000o0 = i2;
            this.O00000o = originType;
            this.O00000oo = str2;
            this.O00000oO = list;
            return;
        }
        throw new ConfigException.BugOrBroken("description may not be null");
    }

    public static dtj O000000o(String str) {
        return new dtj(str, -1, -1, OriginType.GENERIC, null, null);
    }

    static dtj O00000Oo(String str) {
        String str2;
        try {
            str2 = new File(str).toURI().toURL().toExternalForm();
        } catch (MalformedURLException unused) {
            str2 = null;
        }
        return new dtj(str, -1, -1, OriginType.FILE, str2, null);
    }

    public final dtj O000000o(int i) {
        if (i == this.O00000Oo && i == this.O00000o0) {
            return this;
        }
        return new dtj(this.f14922O000000o, i, i, this.O00000o, this.O00000oo, this.O00000oO);
    }

    /* access modifiers changed from: package-private */
    public final dtj O000000o(List<String> list) {
        if (dst.O000000o(list, this.O00000oO)) {
            return this;
        }
        return new dtj(this.f14922O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oo, list);
    }

    /* access modifiers changed from: package-private */
    public final dtj O00000Oo(List<String> list) {
        if (dst.O000000o(list, this.O00000oO)) {
            return this;
        }
        if (this.O00000oO == null) {
            return O000000o(list);
        }
        ArrayList arrayList = new ArrayList(list.size() + this.O00000oO.size());
        arrayList.addAll(this.O00000oO);
        arrayList.addAll(list);
        return O000000o((List<String>) arrayList);
    }

    public final String O000000o() {
        int i = this.O00000Oo;
        if (i < 0) {
            return this.f14922O000000o;
        }
        if (this.O00000o0 == i) {
            return this.f14922O000000o + ": " + this.O00000Oo;
        }
        return this.f14922O000000o + ": " + this.O00000Oo + "-" + this.O00000o0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof dtj) {
            dtj dtj = (dtj) obj;
            if (this.f14922O000000o.equals(dtj.f14922O000000o) && this.O00000Oo == dtj.O00000Oo && this.O00000o0 == dtj.O00000o0 && this.O00000o == dtj.O00000o && dst.O000000o(this.O00000oo, dtj.O00000oo)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((((((this.f14922O000000o.hashCode() + 41) * 41) + this.O00000Oo) * 41) + this.O00000o0) * 41) + this.O00000o.hashCode()) * 41;
        String str = this.O00000oo;
        return str != null ? (hashCode + str.hashCode()) * 41 : hashCode;
    }

    public final String toString() {
        if (this.O00000o != OriginType.RESOURCE || this.O00000oo == null) {
            return "ConfigOrigin(" + this.f14922O000000o + ")";
        }
        return "ConfigOrigin(" + this.f14922O000000o + "," + this.O00000oo + ")";
    }

    public final int O00000Oo() {
        return this.O00000Oo;
    }

    public final List<String> O00000o0() {
        List<String> list = this.O00000oO;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    private static dtj O000000o(dtj dtj, dtj dtj2) {
        int i;
        String str;
        List<String> list;
        OriginType originType = dtj.O00000o;
        if (originType != dtj2.O00000o) {
            originType = OriginType.GENERIC;
        }
        OriginType originType2 = originType;
        String str2 = dtj.f14922O000000o;
        String str3 = dtj2.f14922O000000o;
        if (str2.startsWith("merge of ")) {
            str2 = str2.substring(9);
        }
        if (str3.startsWith("merge of ")) {
            str3 = str3.substring(9);
        }
        int i2 = -1;
        if (str2.equals(str3)) {
            int i3 = dtj.O00000Oo;
            if (i3 < 0) {
                i3 = dtj2.O00000Oo;
            } else {
                int i4 = dtj2.O00000Oo;
                if (i4 >= 0) {
                    i3 = Math.min(i3, i4);
                }
            }
            i2 = i3;
            i = Math.max(dtj.O00000o0, dtj2.O00000o0);
            str = str2;
        } else {
            String O000000o2 = dtj.O000000o();
            String O000000o3 = dtj2.O000000o();
            if (O000000o2.startsWith("merge of ")) {
                O000000o2 = O000000o2.substring(9);
            }
            if (O000000o3.startsWith("merge of ")) {
                O000000o3 = O000000o3.substring(9);
            }
            str = "merge of " + O000000o2 + "," + O000000o3;
            i = -1;
        }
        String str4 = dst.O000000o(dtj.O00000oo, dtj2.O00000oo) ? dtj.O00000oo : null;
        if (dst.O000000o(dtj.O00000oO, dtj2.O00000oO)) {
            list = dtj.O00000oO;
        } else {
            ArrayList arrayList = new ArrayList();
            List<String> list2 = dtj.O00000oO;
            if (list2 != null) {
                arrayList.addAll(list2);
            }
            List<String> list3 = dtj2.O00000oO;
            if (list3 != null) {
                arrayList.addAll(list3);
            }
            list = arrayList;
        }
        return new dtj(str, i2, i, originType2, str4, list);
    }

    private static int O00000Oo(dtj dtj, dtj dtj2) {
        int i = dtj.O00000o == dtj2.O00000o ? 1 : 0;
        if (!dtj.f14922O000000o.equals(dtj2.f14922O000000o)) {
            return i;
        }
        int i2 = i + 1;
        if (dtj.O00000Oo == dtj2.O00000Oo) {
            i2++;
        }
        if (dtj.O00000o0 == dtj2.O00000o0) {
            i2++;
        }
        return dst.O000000o(dtj.O00000oo, dtj2.O00000oo) ? i2 + 1 : i2;
    }

    static dsi O000000o(dsi dsi, dsi dsi2) {
        return O000000o((dtj) dsi, (dtj) dsi2);
    }

    static dsi O000000o(Collection<? extends dsi> collection) {
        dtj dtj;
        while (!collection.isEmpty()) {
            if (collection.size() == 1) {
                return (dsi) collection.iterator().next();
            }
            if (collection.size() == 2) {
                Iterator<? extends dsi> it = collection.iterator();
                return O000000o((dtj) it.next(), (dtj) it.next());
            }
            ArrayList arrayList = new ArrayList();
            for (dsi dsi : collection) {
                arrayList.add((dtj) dsi);
            }
            while (arrayList.size() > 2) {
                dtj dtj2 = (dtj) arrayList.get(arrayList.size() - 1);
                arrayList.remove(arrayList.size() - 1);
                dtj dtj3 = (dtj) arrayList.get(arrayList.size() - 1);
                arrayList.remove(arrayList.size() - 1);
                dtj dtj4 = (dtj) arrayList.get(arrayList.size() - 1);
                arrayList.remove(arrayList.size() - 1);
                if (O00000Oo(dtj4, dtj3) >= O00000Oo(dtj3, dtj2)) {
                    dtj = O000000o(O000000o(dtj4, dtj3), dtj2);
                } else {
                    dtj = O000000o(dtj4, O000000o(dtj3, dtj2));
                }
                arrayList.add(dtj);
            }
            collection = arrayList;
        }
        throw new ConfigException.BugOrBroken("can't merge empty list of origins");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [com.typesafe.config.impl.SerializedConfigValue$SerializedField, java.lang.String]
     candidates:
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [com.typesafe.config.impl.SerializedConfigValue$SerializedField, java.lang.Integer]
     candidates:
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [com.typesafe.config.impl.SerializedConfigValue$SerializedField, java.util.List<java.lang.String>]
     candidates:
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    public final Map<SerializedConfigValue.SerializedField, Object> O00000o() {
        EnumMap enumMap = new EnumMap(SerializedConfigValue.SerializedField.class);
        enumMap.put((MMKVRecoverStrategic) SerializedConfigValue.SerializedField.ORIGIN_DESCRIPTION, (Integer) this.f14922O000000o);
        if (this.O00000Oo >= 0) {
            enumMap.put((MMKVRecoverStrategic) SerializedConfigValue.SerializedField.ORIGIN_LINE_NUMBER, Integer.valueOf(this.O00000Oo));
        }
        if (this.O00000o0 >= 0) {
            enumMap.put((MMKVRecoverStrategic) SerializedConfigValue.SerializedField.ORIGIN_END_LINE_NUMBER, Integer.valueOf(this.O00000o0));
        }
        enumMap.put((MMKVRecoverStrategic) SerializedConfigValue.SerializedField.ORIGIN_TYPE, Integer.valueOf(this.O00000o.ordinal()));
        if (this.O00000oo != null) {
            enumMap.put((MMKVRecoverStrategic) SerializedConfigValue.SerializedField.ORIGIN_URL, (Integer) this.O00000oo);
        }
        if (this.O00000oO != null) {
            enumMap.put((MMKVRecoverStrategic) SerializedConfigValue.SerializedField.ORIGIN_COMMENTS, (Integer) this.O00000oO);
        }
        return enumMap;
    }

    /* renamed from: _m_j.dtj$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final /* synthetic */ int[] f14923O000000o = new int[SerializedConfigValue.SerializedField.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f14923O000000o[SerializedConfigValue.SerializedField.ORIGIN_DESCRIPTION.ordinal()] = 1;
            f14923O000000o[SerializedConfigValue.SerializedField.ORIGIN_LINE_NUMBER.ordinal()] = 2;
            f14923O000000o[SerializedConfigValue.SerializedField.ORIGIN_END_LINE_NUMBER.ordinal()] = 3;
            f14923O000000o[SerializedConfigValue.SerializedField.ORIGIN_TYPE.ordinal()] = 4;
            f14923O000000o[SerializedConfigValue.SerializedField.ORIGIN_URL.ordinal()] = 5;
            f14923O000000o[SerializedConfigValue.SerializedField.ORIGIN_COMMENTS.ordinal()] = 6;
            f14923O000000o[SerializedConfigValue.SerializedField.ORIGIN_NULL_URL.ordinal()] = 7;
            f14923O000000o[SerializedConfigValue.SerializedField.ORIGIN_NULL_COMMENTS.ordinal()] = 8;
            f14923O000000o[SerializedConfigValue.SerializedField.END_MARKER.ordinal()] = 9;
            f14923O000000o[SerializedConfigValue.SerializedField.ROOT_VALUE.ordinal()] = 10;
            f14923O000000o[SerializedConfigValue.SerializedField.ROOT_WAS_CONFIG.ordinal()] = 11;
            f14923O000000o[SerializedConfigValue.SerializedField.UNKNOWN.ordinal()] = 12;
            f14923O000000o[SerializedConfigValue.SerializedField.VALUE_DATA.ordinal()] = 13;
            f14923O000000o[SerializedConfigValue.SerializedField.VALUE_ORIGIN.ordinal()] = 14;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [com.typesafe.config.impl.SerializedConfigValue$SerializedField, java.lang.Object]
     candidates:
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    public static Map<SerializedConfigValue.SerializedField, Object> O000000o(Map<SerializedConfigValue.SerializedField, Object> map, Map<SerializedConfigValue.SerializedField, Object> map2) throws IOException {
        EnumMap enumMap = new EnumMap(map2);
        for (Map.Entry<SerializedConfigValue.SerializedField, Object> key : map.entrySet()) {
            SerializedConfigValue.SerializedField serializedField = (SerializedConfigValue.SerializedField) key.getKey();
            if (!map2.containsKey(serializedField)) {
                switch (AnonymousClass1.f14923O000000o[serializedField.ordinal()]) {
                    case 1:
                        enumMap.put((MMKVRecoverStrategic) serializedField, (Integer) map.get(serializedField));
                        continue;
                    case 2:
                    case 3:
                    case 4:
                        enumMap.put((MMKVRecoverStrategic) serializedField, (Integer) map.get(serializedField));
                        continue;
                    case 5:
                        if (!map2.containsKey(SerializedConfigValue.SerializedField.ORIGIN_NULL_URL)) {
                            enumMap.put((MMKVRecoverStrategic) serializedField, (Integer) map.get(serializedField));
                            break;
                        } else {
                            enumMap.remove(SerializedConfigValue.SerializedField.ORIGIN_NULL_URL);
                            continue;
                        }
                    case 6:
                        if (!map2.containsKey(SerializedConfigValue.SerializedField.ORIGIN_NULL_COMMENTS)) {
                            enumMap.put((MMKVRecoverStrategic) serializedField, (Integer) map.get(serializedField));
                            break;
                        } else {
                            enumMap.remove(SerializedConfigValue.SerializedField.ORIGIN_NULL_COMMENTS);
                            continue;
                        }
                    case 7:
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        throw new ConfigException.BugOrBroken("applying fields, base object should not contain " + serializedField + " " + map);
                    case 9:
                    case 10:
                    case 11:
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    case 13:
                    case 14:
                        throw new ConfigException.BugOrBroken("should not appear here: ".concat(String.valueOf(serializedField)));
                }
            }
        }
        return enumMap;
    }
}
