package _m_j;

import android.util.ArrayMap;
import android.util.Pair;
import com.xiaomi.smarthome.device.api.spec.definitions.data.Access;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class her {
    private static final Pair<hep, Spec.SpecItem[][]> O00000oo = new Pair<>(null, null);

    /* renamed from: O000000o  reason: collision with root package name */
    private final ArrayList<hep> f18848O000000o;
    private final ArrayList<hep> O00000Oo;
    private final ArrayList<hep> O00000o;
    private final Map<Set<String>, hep> O00000o0;
    private final Map<Set<String>, hep> O00000oO;
    private final ArrayMap<SpecDevice, Pair<hep, Spec.SpecItem[][]>> O0000O0o = new ArrayMap<>();
    private final String[] O0000OOo;

    public her(ArrayList<hep> arrayList, ArrayList<hep> arrayList2, Map<Set<String>, hep> map, ArrayList<hep> arrayList3, Map<Set<String>, hep> map2, String[] strArr) {
        this.f18848O000000o = arrayList;
        this.O00000Oo = arrayList2;
        this.O00000o0 = map;
        this.O00000o = arrayList3;
        this.O00000oO = map2;
        this.O0000OOo = strArr;
    }

    public final Pair<hep, Spec.SpecItem[][]> O000000o(SpecDevice specDevice) {
        if (specDevice == null) {
            gsy.O000000o(6, "mijia-card", "MiotSpecCardManager.getGridCard specDevice is null");
            return null;
        }
        Pair<hep, Spec.SpecItem[][]> pair = this.O0000O0o.get(specDevice);
        String type = specDevice.getType();
        if (pair != null) {
            return pair;
        }
        String[] strArr = this.O0000OOo;
        if (strArr == null || Arrays.binarySearch(strArr, type) < 0) {
            Map<Set<String>, hep> map = this.O00000oO;
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    if (((Set) next.getKey()).contains(type)) {
                        hep hep = (hep) next.getValue();
                        Spec.SpecItem[][] O000000o2 = O000000o(hep, specDevice);
                        if (O000000o2 == null) {
                            gsy.O00000Oo("mijia-card", "MiotSpecCardManager.getGridCardPair not match. type:" + type + " card instance_type:6 layout_type:" + hep.O00000Oo + " layout:" + hep.O00000Oo());
                        } else {
                            gsy.O00000Oo("mijia-card", "MiotSpecCardManager.getGridCardPair matched. type:" + type + " card instance_type:6 layout_type:" + hep.O00000Oo + " layout:" + hep.O00000Oo());
                            Pair<hep, Spec.SpecItem[][]> pair2 = new Pair<>(hep, O000000o2);
                            this.O0000O0o.put(specDevice, pair2);
                            return pair2;
                        }
                    }
                }
            }
            if (this.O00000o != null) {
                gsy.O00000Oo("mijia-card", "MiotSpecCardManager.getGridCard prematch  urn:".concat(String.valueOf(type)));
                Iterator<hep> it = this.O00000o.iterator();
                while (it.hasNext()) {
                    hep next2 = it.next();
                    Spec.SpecItem[][] O000000o3 = O000000o(next2, specDevice);
                    if (O000000o3 != null) {
                        gsy.O00000Oo("mijia-card", "MiotSpecCardManager.getGridCard matched  urn:".concat(String.valueOf(type)));
                        Pair<hep, Spec.SpecItem[][]> pair3 = new Pair<>(next2, O000000o3);
                        this.O0000O0o.put(specDevice, pair3);
                        return pair3;
                    }
                }
            }
            gsy.O000000o(6, "mijia-card", "MiotSpecCardManager.getGridCard not match urn:".concat(String.valueOf(type)));
        } else {
            gsy.O00000Oo("mijia-card", "SpecCardSelector.disableType urn:".concat(String.valueOf(type)));
        }
        this.O0000O0o.put(specDevice, O00000oo);
        return O00000oo;
    }

    public final Pair<hep, Spec.SpecItem[][]> O000000o(SpecDevice specDevice, boolean z) {
        if (specDevice == null) {
            gsy.O000000o(6, "mijia-card", "MiotSpecCardManager.getActivityCard specInstance is null");
            return null;
        }
        String type = specDevice.getType();
        String[] strArr = this.O0000OOo;
        if (strArr == null || Arrays.binarySearch(strArr, type) < 0) {
            Map<Set<String>, hep> map = this.O00000o0;
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    if (((Set) next.getKey()).contains(type)) {
                        hep hep = (hep) next.getValue();
                        Spec.SpecItem[][] O000000o2 = O000000o(hep, specDevice);
                        if (O000000o2 == null) {
                            gsy.O00000Oo("mijia-card", "MiotSpecCardManager.chooseSpecCardInstance not match. card instance_type:2 layout_type:" + hep.O00000Oo + " layout:" + hep.O00000Oo());
                        } else {
                            gsy.O00000Oo("mijia-card", "MiotSpecCardManager.chooseSpecCardInstance find. card instance_type:2 layout_type:" + hep.O00000Oo + " layout:" + hep.O00000Oo());
                            return new Pair<>(hep, O000000o2);
                        }
                    }
                }
            }
            ArrayList<hep> arrayList = this.O00000Oo;
            if (arrayList != null && z) {
                Iterator<hep> it = arrayList.iterator();
                while (it.hasNext()) {
                    hep next2 = it.next();
                    gsy.O00000Oo("mijia-card", "MiotSpecCardManager.getActivityCard prematch instance_type:3 targetUrn:".concat(String.valueOf(type)));
                    Spec.SpecItem[][] O000000o3 = O000000o(next2, specDevice);
                    if (O000000o3 != null) {
                        gsy.O00000Oo("mijia-card", "MiotSpecCardManager.getActivityCard matched instance_type:3 targetUrn:" + type + " specCard:" + next2);
                        return new Pair<>(next2, O000000o3);
                    }
                }
                gsy.O00000Oo("mijia-card", "MiotSpecCardManager.getActivityCard not match instance_type:3 targetUrn:".concat(String.valueOf(type)));
            }
            ArrayList<hep> arrayList2 = this.f18848O000000o;
            if (arrayList2 != null) {
                Iterator<hep> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    hep next3 = it2.next();
                    gsy.O00000Oo("mijia-card", "MiotSpecCardManager.getActivityCard prematch  instance_type:1 targetUrn:".concat(String.valueOf(type)));
                    Spec.SpecItem[][] O000000o4 = O000000o(next3, specDevice);
                    if (O000000o4 != null) {
                        gsy.O00000Oo("mijia-card", "MiotSpecCardManager.getActivityCard matched  instance_type:1 targetUrn:" + type + " specCard:" + next3);
                        return new Pair<>(next3, O000000o4);
                    }
                }
                gsy.O00000Oo("mijia-card", "MiotSpecCardManager.getActivityCard not match  instance_type:1 targetUrn:".concat(String.valueOf(type)));
            } else {
                gsy.O00000Oo("mijia-card", "MiotSpecCardManager.getActivityCard not config instance_type:1 targetUrn:".concat(String.valueOf(type)));
            }
            return null;
        }
        gsy.O00000Oo("mijia-card", "SpecCardSelector.disableType urn:".concat(String.valueOf(type)));
        return null;
    }

    private static Spec.SpecItem[][] O000000o(hep hep, SpecDevice specDevice) {
        String type = specDevice.getType();
        List O00000Oo2 = hep.O00000Oo();
        if (hep.O00000o0 == null || Arrays.binarySearch(hep.O00000o0, type) < 0) {
            Spec.SpecItem[][] O000000o2 = O000000o(specDevice, O00000Oo2);
            if (O000000o2 == null) {
                gsy.O00000Oo("mijia-card", "MiotSpecCardManager.matchSpecCard not match spec instance. layout_type:" + hep.O00000Oo + " layout:" + O00000Oo2 + " targetUrn:" + type);
                return null;
            } else if (O000000o2.length == O00000Oo2.size()) {
                gsy.O00000Oo("mijia-card", "MiotSpecCardManager.matchSpecCard find. layout_type:" + hep.O00000Oo + " layout:" + O00000Oo2);
                return O000000o2;
            } else {
                gsy.O00000Oo("mijia-card", "MiotSpecCardManager.matchSpecCard not match layout size. layout_type:" + hep.O00000Oo + " layout:" + O00000Oo2 + " targetUrn:" + type);
                return null;
            }
        } else {
            gsy.O00000Oo("mijia-card", "MiotSpecCardManager.matchSpecCard not match. disable type contain urn:" + type + " layout_type:" + O00000Oo2 + " targetUrn:" + type);
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.xiaomi.smarthome.device.api.spec.instance.Spec$SpecItem} */
    /* JADX WARNING: Multi-variable type inference failed */
    private static Spec.SpecItem[][] O000000o(SpecDevice specDevice, List<hej> list) {
        Access access;
        List<hej> list2 = list;
        Map<String, ArrayList<Spec.SpecItem>> O000000o2 = fax.O000000o(specDevice);
        int size = list.size();
        Spec.SpecItem[][] specItemArr = new Spec.SpecItem[size][];
        ArrayMap arrayMap = new ArrayMap();
        for (int i = 0; i < size; i++) {
            hej hej = list2.get(i);
            ArrayList arrayList = (ArrayList) arrayMap.get(hej.O00000o0);
            if (arrayList == null) {
                arrayList = new ArrayList();
                arrayMap.put(hej.O00000o0, arrayList);
            }
            arrayList.add(Integer.valueOf(i));
        }
        Iterator it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String[] split = ((String) entry.getKey()).split(",");
            ArrayList arrayList2 = (ArrayList) entry.getValue();
            int size2 = arrayList2.size();
            int length = split.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    String str = split[i2];
                    ArrayList arrayList3 = O000000o2.get(str);
                    if (arrayList3 == null) {
                        gsy.O000000o(6, "mijia-card", "MiotSpecCardManager.getProperties notmatch " + str + " layouts:" + list2);
                        return null;
                    }
                    int i3 = 0;
                    while (i3 < arrayList3.size() && i3 < size2) {
                        Integer num = (Integer) arrayList2.get(i3);
                        Access access2 = list2.get(num.intValue()).O0000Oo0;
                        Map<String, ArrayList<Spec.SpecItem>> map = O000000o2;
                        Spec.SpecItem specItem = arrayList3.get(i3);
                        Iterator it2 = it;
                        if (!(specItem instanceof SpecProperty) || (access = ((SpecProperty) specItem).access()) == null || access.contain(access2)) {
                            if (specItemArr[num.intValue()] == null) {
                                specItemArr[num.intValue()] = new Spec.SpecItem[length];
                            }
                            specItemArr[num.intValue()][i2] = specItem;
                        } else {
                            gsy.O000000o(6, "mijia-card", "MiotSpecCardManager.getProperties access not contain " + str + " layouts:" + list2);
                            arrayList3.remove(i3);
                            i3 += -1;
                        }
                        i3++;
                        it = it2;
                        O000000o2 = map;
                    }
                    Map<String, ArrayList<Spec.SpecItem>> map2 = O000000o2;
                    Iterator it3 = it;
                    if (size2 != arrayList3.size()) {
                        gsy.O000000o(6, "mijia-card", "MiotSpecCardManager.getProperties size different " + str + " layouts:" + list2 + " config card_layout:" + size2 + " instance define:" + arrayList3.size());
                        return null;
                    }
                    i2++;
                    it = it3;
                    O000000o2 = map2;
                }
            }
        }
        return specItemArr;
    }
}
