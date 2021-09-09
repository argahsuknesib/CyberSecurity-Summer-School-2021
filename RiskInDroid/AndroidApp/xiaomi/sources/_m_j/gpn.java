package _m_j;

import java.util.ArrayList;
import java.util.List;

public final class gpn {
    public static boolean O000000o(List<?> list) {
        return list == null || list.size() <= 0;
    }

    public static <E> List<E> O000000o() {
        return new ArrayList();
    }

    public static int O00000Oo(List<?> list) {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public static <E> List<List<E>> O000000o(List<E> list, int i) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (list.size() > i) {
            int i2 = 0;
            while (i2 < list.size()) {
                int i3 = i2 + i;
                arrayList.add(list.subList(i2, Math.min(i3, list.size())));
                i2 = i3;
            }
        } else {
            arrayList.add(list);
        }
        return arrayList;
    }
}
