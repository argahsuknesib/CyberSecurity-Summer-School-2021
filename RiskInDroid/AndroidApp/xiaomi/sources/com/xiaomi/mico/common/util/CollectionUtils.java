package com.xiaomi.mico.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CollectionUtils {

    public interface BelongTo<T> {
        boolean belongTo(T t);
    }

    public static <T> List<T> filter(List<T> list, BelongTo<T> belongTo) {
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (belongTo.belongTo(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static <T1, T2> List<T2> convert(List<T1> list, List<T2> list2) {
        for (T1 add : list) {
            list2.add(add);
        }
        return list2;
    }

    public static <K, V> K findKeyByValue(Map<K, V> map, V v) {
        for (Map.Entry next : map.entrySet()) {
            if (next.getValue().equals(v)) {
                return next.getKey();
            }
        }
        return null;
    }
}
