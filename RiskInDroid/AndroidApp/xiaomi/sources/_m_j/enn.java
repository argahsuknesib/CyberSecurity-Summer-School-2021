package _m_j;

import java.net.InetSocketAddress;

public final class enn {

    /* renamed from: O000000o  reason: collision with root package name */
    String f15655O000000o;
    int O00000Oo;

    private enn(String str, int i) {
        this.f15655O000000o = str;
        this.O00000Oo = i;
    }

    public static enn O000000o(String str, int i) {
        String str2;
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
        } else {
            str2 = str;
        }
        return new enn(str2, i);
    }

    public final String toString() {
        if (this.O00000Oo <= 0) {
            return this.f15655O000000o;
        }
        return this.f15655O000000o + ":" + this.O00000Oo;
    }

    public static InetSocketAddress O00000Oo(String str, int i) {
        enn O000000o2 = O000000o(str, i);
        return new InetSocketAddress(O000000o2.f15655O000000o, O000000o2.O00000Oo);
    }
}
