package _m_j;

import android.util.SparseArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

public final class deq implements ded {

    /* renamed from: O000000o  reason: collision with root package name */
    public SparseArray<int[]> f14555O000000o = new SparseArray<>();
    public SparseArray<int[]> O00000Oo = new SparseArray<>();

    public final void O000000o(int i) {
        this.f14555O000000o.remove(i);
        this.O00000Oo.remove(i);
    }

    private static int[] O000000o(ReadableMap readableMap, String str) {
        ReadableArray array = readableMap.getArray(str);
        int[] iArr = new int[array.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = array.getInt(i);
        }
        return iArr;
    }

    public final boolean O000000o(dec dec, dec dec2) {
        int[] iArr = this.f14555O000000o.get(dec.O00000oO);
        if (iArr != null) {
            for (int i : iArr) {
                if (i == dec2.O00000oO) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean O00000Oo(dec dec, dec dec2) {
        int[] iArr = this.O00000Oo.get(dec.O00000oO);
        if (iArr != null) {
            for (int i : iArr) {
                if (i == dec2.O00000oO) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void O000000o(dec dec, ReadableMap readableMap) {
        dec.O0000o0o = this;
        if (readableMap.hasKey("waitFor")) {
            this.f14555O000000o.put(dec.O00000oO, O000000o(readableMap, "waitFor"));
        }
        if (readableMap.hasKey("simultaneousHandlers")) {
            this.O00000Oo.put(dec.O00000oO, O000000o(readableMap, "simultaneousHandlers"));
        }
    }
}
