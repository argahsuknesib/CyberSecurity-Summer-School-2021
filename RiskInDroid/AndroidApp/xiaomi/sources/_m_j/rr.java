package _m_j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class rr {

    /* renamed from: O000000o  reason: collision with root package name */
    public byte f2442O000000o;
    public int O00000Oo;
    public List<String> O00000o;
    public List<Long> O00000o0;
    public HashMap<String, String> O00000oO;
    public byte[] O00000oo;

    public rr(byte b, List<Long> list, List<String> list2) {
        this.f2442O000000o = b;
        this.O00000o0 = list;
        this.O00000o = list2;
    }

    public final String toString() {
        return "OfflineRequest{mType=" + ((int) this.f2442O000000o) + ", mWifiList=" + this.O00000o0 + ", mCellList=" + this.O00000o + ", mHeaders=" + this.O00000oO + ", mBody=" + Arrays.toString(this.O00000oo) + '}';
    }
}
