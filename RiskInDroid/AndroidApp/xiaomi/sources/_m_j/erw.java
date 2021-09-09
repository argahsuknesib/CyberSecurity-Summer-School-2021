package _m_j;

import android.support.v4.app.NotificationCompat;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public final class erw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Comparator f15758O000000o = new O000000o((byte) 0);

    static class O000000o implements Comparator {
        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            return obj instanceof List ? erw.O000000o((List) obj, (List) obj2) : obj instanceof Set ? erw.O000000o((Set) obj, (Set) obj2) : obj instanceof Map ? erw.O000000o((Map) obj, (Map) obj2) : obj instanceof byte[] ? erw.O000000o((byte[]) obj, (byte[]) obj2) : erw.O000000o((Comparable) obj, (Comparable) obj2);
        }
    }

    public static int O000000o(byte b, byte b2) {
        if (b < b2) {
            return -1;
        }
        return b2 < b ? 1 : 0;
    }

    public static int O000000o(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i2 < i ? 1 : 0;
    }

    public static int O000000o(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j2 < j ? 1 : 0;
    }

    public static int O000000o(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static int O000000o(String str, String str2) {
        return str.compareTo(str2);
    }

    public static int O000000o(List list, List list2) {
        int O000000o2 = O000000o(list.size(), list2.size());
        if (O000000o2 != 0) {
            return O000000o2;
        }
        for (int i = 0; i < list.size(); i++) {
            int compare = f15758O000000o.compare(list.get(i), list2.get(i));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int O000000o(Map map, Map map2) {
        int O000000o2 = O000000o(map.size(), map2.size());
        if (O000000o2 != 0) {
            return O000000o2;
        }
        TreeMap treeMap = new TreeMap(f15758O000000o);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(f15758O000000o);
        treeMap2.putAll(map2);
        Iterator it2 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            int compare = f15758O000000o.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            int compare2 = f15758O000000o.compare(entry.getValue(), entry2.getValue());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return 0;
    }

    public static int O000000o(Set set, Set set2) {
        int O000000o2 = O000000o(set.size(), set2.size());
        if (O000000o2 != 0) {
            return O000000o2;
        }
        TreeSet treeSet = new TreeSet(f15758O000000o);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(f15758O000000o);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compare = f15758O000000o.compare(it.next(), it2.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int O000000o(short s, short s2) {
        if (s < s2) {
            return -1;
        }
        return s2 < s ? 1 : 0;
    }

    public static int O000000o(boolean z, boolean z2) {
        return Boolean.valueOf(z).compareTo(Boolean.valueOf(z2));
    }

    public static int O000000o(byte[] bArr, byte[] bArr2) {
        int O000000o2 = O000000o(bArr.length, bArr2.length);
        if (O000000o2 != 0) {
            return O000000o2;
        }
        for (int i = 0; i < bArr.length; i++) {
            int O000000o3 = O000000o(bArr[i], bArr2[i]);
            if (O000000o3 != 0) {
                return O000000o3;
            }
        }
        return 0;
    }

    private static boolean O00000Oo(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    public static void O000000o(ByteBuffer byteBuffer, StringBuilder sb) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int limit = byteBuffer.limit();
        int i = limit - arrayOffset > 128 ? arrayOffset + NotificationCompat.FLAG_HIGH_PRIORITY : limit;
        for (int i2 = arrayOffset; i2 < i; i2++) {
            if (i2 > arrayOffset) {
                sb.append(" ");
            }
            sb.append(Integer.toHexString((array[i2] | 256) & 511).toUpperCase().substring(1));
        }
        if (limit != i) {
            sb.append("...");
        }
    }

    public static ByteBuffer O000000o(ByteBuffer byteBuffer) {
        byte[] bArr;
        if (O00000Oo(byteBuffer)) {
            return byteBuffer;
        }
        if (O00000Oo(byteBuffer)) {
            bArr = byteBuffer.array();
        } else {
            byte[] bArr2 = new byte[byteBuffer.remaining()];
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr2, 0, byteBuffer.remaining());
            bArr = bArr2;
        }
        return ByteBuffer.wrap(bArr);
    }
}
