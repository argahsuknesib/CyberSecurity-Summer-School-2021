package _m_j;

import com.fasterxml.jackson.core.util.BufferRecycler;
import java.math.BigDecimal;
import java.util.ArrayList;

public final class ajo {

    /* renamed from: O000000o  reason: collision with root package name */
    static final char[] f12407O000000o = new char[0];
    public char[] O00000Oo;
    public int O00000o;
    public int O00000o0;
    public boolean O00000oO = false;
    public char[] O00000oo;
    public int O0000O0o;
    public String O0000OOo;
    private final BufferRecycler O0000Oo;
    public char[] O0000Oo0;
    private ArrayList<char[]> O0000OoO;
    private int O0000Ooo;

    public ajo(BufferRecycler bufferRecycler) {
        this.O0000Oo = bufferRecycler;
    }

    public final void O000000o() {
        if (this.O0000Oo == null) {
            O0000Ooo();
        } else if (this.O00000oo != null) {
            O0000Ooo();
            char[] cArr = this.O00000oo;
            this.O00000oo = null;
            this.O0000Oo.O000000o(BufferRecycler.CharBufferType.TEXT_BUFFER, cArr);
        }
    }

    private void O0000Ooo() {
        this.O00000o0 = -1;
        this.O0000O0o = 0;
        this.O00000o = 0;
        this.O00000Oo = null;
        this.O0000OOo = null;
        this.O0000Oo0 = null;
        if (this.O00000oO) {
            O00000Oo();
        }
    }

    public final void O000000o(char[] cArr, int i, int i2) {
        this.O0000OOo = null;
        this.O0000Oo0 = null;
        this.O00000Oo = cArr;
        this.O00000o0 = i;
        this.O00000o = i2;
        if (this.O00000oO) {
            O00000Oo();
        }
    }

    public final void O00000Oo(char[] cArr, int i, int i2) {
        this.O00000Oo = null;
        this.O00000o0 = -1;
        this.O00000o = 0;
        this.O0000OOo = null;
        this.O0000Oo0 = null;
        if (this.O00000oO) {
            O00000Oo();
        } else if (this.O00000oo == null) {
            this.O00000oo = O00000o0(i2);
        }
        this.O0000Ooo = 0;
        this.O0000O0o = 0;
        O00000o0(cArr, i, i2);
    }

    private final char[] O00000o0(int i) {
        BufferRecycler bufferRecycler = this.O0000Oo;
        if (bufferRecycler != null) {
            return bufferRecycler.O000000o(BufferRecycler.CharBufferType.TEXT_BUFFER, i);
        }
        return new char[Math.max(i, 1000)];
    }

    public final void O00000Oo() {
        this.O00000oO = false;
        this.O0000OoO.clear();
        this.O0000Ooo = 0;
        this.O0000O0o = 0;
    }

    public final int O00000o0() {
        if (this.O00000o0 >= 0) {
            return this.O00000o;
        }
        char[] cArr = this.O0000Oo0;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this.O0000OOo;
        if (str != null) {
            return str.length();
        }
        return this.O0000Ooo + this.O0000O0o;
    }

    public final int O00000o() {
        int i = this.O00000o0;
        if (i >= 0) {
            return i;
        }
        return 0;
    }

    public final char[] O00000oO() {
        if (this.O00000o0 >= 0) {
            return this.O00000Oo;
        }
        char[] cArr = this.O0000Oo0;
        if (cArr != null) {
            return cArr;
        }
        String str = this.O0000OOo;
        if (str != null) {
            char[] charArray = str.toCharArray();
            this.O0000Oo0 = charArray;
            return charArray;
        } else if (!this.O00000oO) {
            return this.O00000oo;
        } else {
            return O0000O0o();
        }
    }

    public final String O00000oo() {
        if (this.O0000OOo == null) {
            char[] cArr = this.O0000Oo0;
            if (cArr != null) {
                this.O0000OOo = new String(cArr);
            } else {
                int i = this.O00000o0;
                String str = "";
                if (i >= 0) {
                    int i2 = this.O00000o;
                    if (i2 <= 0) {
                        this.O0000OOo = str;
                        return str;
                    }
                    this.O0000OOo = new String(this.O00000Oo, i, i2);
                } else {
                    int i3 = this.O0000Ooo;
                    int i4 = this.O0000O0o;
                    if (i3 == 0) {
                        if (i4 != 0) {
                            str = new String(this.O00000oo, 0, i4);
                        }
                        this.O0000OOo = str;
                    } else {
                        StringBuilder sb = new StringBuilder(i3 + i4);
                        ArrayList<char[]> arrayList = this.O0000OoO;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i5 = 0; i5 < size; i5++) {
                                char[] cArr2 = this.O0000OoO.get(i5);
                                sb.append(cArr2, 0, cArr2.length);
                            }
                        }
                        sb.append(this.O00000oo, 0, this.O0000O0o);
                        this.O0000OOo = sb.toString();
                    }
                }
            }
        }
        return this.O0000OOo;
    }

    public final char[] O0000O0o() {
        char[] cArr = this.O0000Oo0;
        if (cArr != null) {
            return cArr;
        }
        char[] O0000o00 = O0000o00();
        this.O0000Oo0 = O0000o00;
        return O0000o00;
    }

    public final BigDecimal O0000OOo() throws NumberFormatException {
        char[] cArr = this.O0000Oo0;
        if (cArr != null) {
            return new BigDecimal(cArr);
        }
        int i = this.O00000o0;
        if (i >= 0) {
            return new BigDecimal(this.O00000Oo, i, this.O00000o);
        }
        if (this.O0000Ooo == 0) {
            return new BigDecimal(this.O00000oo, 0, this.O0000O0o);
        }
        return new BigDecimal(O0000O0o());
    }

    public final void O00000o0(char[] cArr, int i, int i2) {
        if (this.O00000o0 >= 0) {
            O000000o(i2);
        }
        this.O0000OOo = null;
        this.O0000Oo0 = null;
        char[] cArr2 = this.O00000oo;
        int length = cArr2.length;
        int i3 = this.O0000O0o;
        int i4 = length - i3;
        if (i4 >= i2) {
            System.arraycopy(cArr, i, cArr2, i3, i2);
            this.O0000O0o += i2;
            return;
        }
        if (i4 > 0) {
            System.arraycopy(cArr, i, cArr2, i3, i4);
            i += i4;
            i2 -= i4;
        }
        O00000Oo(i2);
        System.arraycopy(cArr, i, this.O00000oo, 0, i2);
        this.O0000O0o = i2;
    }

    public final void O000000o(String str, int i, int i2) {
        if (this.O00000o0 >= 0) {
            O000000o(i2);
        }
        this.O0000OOo = null;
        this.O0000Oo0 = null;
        char[] cArr = this.O00000oo;
        int length = cArr.length;
        int i3 = this.O0000O0o;
        int i4 = length - i3;
        if (i4 >= i2) {
            str.getChars(0, i2 + 0, cArr, i3);
            this.O0000O0o += i2;
            return;
        }
        if (i4 > 0) {
            i = i4 + 0;
            str.getChars(0, i, cArr, i3);
            i2 -= i4;
        }
        O00000Oo(i2);
        str.getChars(i, i + i2, this.O00000oo, 0);
        this.O0000O0o = i2;
    }

    public final char[] O0000Oo0() {
        if (this.O00000o0 >= 0) {
            O000000o(1);
        } else {
            char[] cArr = this.O00000oo;
            if (cArr == null) {
                this.O00000oo = O00000o0(0);
            } else if (this.O0000O0o >= cArr.length) {
                O00000Oo(1);
            }
        }
        return this.O00000oo;
    }

    public final char[] O0000Oo() {
        this.O00000o0 = -1;
        this.O0000O0o = 0;
        this.O00000o = 0;
        this.O00000Oo = null;
        this.O0000OOo = null;
        this.O0000Oo0 = null;
        if (this.O00000oO) {
            O00000Oo();
        }
        char[] cArr = this.O00000oo;
        if (cArr != null) {
            return cArr;
        }
        char[] O00000o02 = O00000o0(0);
        this.O00000oo = O00000o02;
        return O00000o02;
    }

    public final char[] O0000OoO() {
        if (this.O0000OoO == null) {
            this.O0000OoO = new ArrayList<>();
        }
        this.O00000oO = true;
        this.O0000OoO.add(this.O00000oo);
        int length = this.O00000oo.length;
        this.O0000Ooo += length;
        char[] cArr = new char[Math.min(length + (length >> 1), 262144)];
        this.O0000O0o = 0;
        this.O00000oo = cArr;
        return cArr;
    }

    public final String toString() {
        return O00000oo();
    }

    public final void O000000o(int i) {
        int i2 = this.O00000o;
        this.O00000o = 0;
        char[] cArr = this.O00000Oo;
        this.O00000Oo = null;
        int i3 = this.O00000o0;
        this.O00000o0 = -1;
        int i4 = i + i2;
        char[] cArr2 = this.O00000oo;
        if (cArr2 == null || i4 > cArr2.length) {
            this.O00000oo = O00000o0(i4);
        }
        if (i2 > 0) {
            System.arraycopy(cArr, i3, this.O00000oo, 0, i2);
        }
        this.O0000Ooo = 0;
        this.O0000O0o = i2;
    }

    public final void O00000Oo(int i) {
        if (this.O0000OoO == null) {
            this.O0000OoO = new ArrayList<>();
        }
        char[] cArr = this.O00000oo;
        this.O00000oO = true;
        this.O0000OoO.add(cArr);
        this.O0000Ooo += cArr.length;
        int length = cArr.length;
        int i2 = length >> 1;
        if (i2 >= i) {
            i = i2;
        }
        this.O0000O0o = 0;
        this.O00000oo = new char[Math.min(262144, length + i)];
    }

    private char[] O0000o00() {
        int i;
        String str = this.O0000OOo;
        if (str != null) {
            return str.toCharArray();
        }
        int i2 = this.O00000o0;
        if (i2 >= 0) {
            int i3 = this.O00000o;
            if (i3 <= 0) {
                return f12407O000000o;
            }
            char[] cArr = new char[i3];
            System.arraycopy(this.O00000Oo, i2, cArr, 0, i3);
            return cArr;
        }
        int O00000o02 = O00000o0();
        if (O00000o02 <= 0) {
            return f12407O000000o;
        }
        char[] cArr2 = new char[O00000o02];
        ArrayList<char[]> arrayList = this.O0000OoO;
        if (arrayList != null) {
            int size = arrayList.size();
            i = 0;
            for (int i4 = 0; i4 < size; i4++) {
                char[] cArr3 = this.O0000OoO.get(i4);
                int length = cArr3.length;
                System.arraycopy(cArr3, 0, cArr2, i, length);
                i += length;
            }
        } else {
            i = 0;
        }
        System.arraycopy(this.O00000oo, 0, cArr2, i, this.O0000O0o);
        return cArr2;
    }
}
