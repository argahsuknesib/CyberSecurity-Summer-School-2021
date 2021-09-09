package com.drew.metadata.jpeg;

import _m_j.acr;
import _m_j.xr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HuffmanTablesDirectory extends xr {
    protected static final byte[] O0000O0o = {0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
    protected static final byte[] O0000OOo = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    protected static final byte[] O0000Oo = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    protected static final byte[] O0000Oo0 = {0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0};
    protected static final byte[] O0000OoO = {0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125};
    protected static final byte[] O0000Ooo = {1, 2, 3, 0, 4, 17, 5, 18, 33, 49, 65, 6, 19, 81, 97, 7, 34, 113, 20, 50, -127, -111, -95, 8, 35, 66, -79, -63, 21, 82, -47, -16, 36, 51, 98, 114, -126, 9, 10, 22, 23, 24, 25, 26, 37, 38, 39, 40, 41, 42, 52, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6};
    protected static final byte[] O0000o0 = {0, 1, 2, 3, 17, 4, 5, 33, 49, 6, 18, 65, 81, 7, 97, 113, 19, 34, 50, -127, 8, 20, 66, -111, -95, -79, -63, 9, 35, 51, 82, -16, 21, 98, 114, -47, 10, 22, 36, 52, -31, 37, -15, 23, 24, 25, 26, 38, 39, 40, 41, 42, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -126, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -30, -29, -28, -27, -26, -25, -24, -23, -22, -14, -13, -12, -11, -10, -9, -8, -7, -6};
    protected static final byte[] O0000o00 = {0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119};
    protected static final HashMap<Integer, String> O0000o0o;
    protected final List<HuffmanTable> O0000o0O = new ArrayList(4);

    public final String O000000o() {
        return "Huffman";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        O0000o0o = hashMap;
        hashMap.put(1, "Number of Tables");
    }

    public HuffmanTablesDirectory() {
        O000000o(new acr(this));
    }

    public final HashMap<Integer, String> O00000Oo() {
        return O0000o0o;
    }

    public final List<HuffmanTable> O00000oo() {
        return this.O0000o0O;
    }

    public static class HuffmanTable {

        /* renamed from: O000000o  reason: collision with root package name */
        private final int f3583O000000o;
        private final HuffmanTableClass O00000Oo;
        private final byte[] O00000o;
        private final int O00000o0;
        private final byte[] O00000oO;

        public HuffmanTable(HuffmanTableClass huffmanTableClass, int i, byte[] bArr, byte[] bArr2) {
            if (bArr == null) {
                throw new IllegalArgumentException("lengthBytes cannot be null.");
            } else if (bArr2 != null) {
                this.O00000Oo = huffmanTableClass;
                this.O00000o0 = i;
                this.O00000o = bArr;
                this.O00000oO = bArr2;
                this.f3583O000000o = this.O00000oO.length + 17;
            } else {
                throw new IllegalArgumentException("valueBytes cannot be null.");
            }
        }

        public enum HuffmanTableClass {
            DC,
            AC,
            UNKNOWN;

            public static HuffmanTableClass typeOf(int i) {
                if (i == 0) {
                    return DC;
                }
                if (i != 1) {
                    return UNKNOWN;
                }
                return AC;
            }
        }
    }
}
