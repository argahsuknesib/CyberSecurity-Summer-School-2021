package _m_j;

import android.support.v4.app.NotificationCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class isz extends isy {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f1614O000000o = true;
    Map<String, Integer> O00000Oo;
    public int O00000o0;
    private final O000000o O0000OoO;
    private final O000000o O0000Ooo;
    private final O000000o O0000o0;
    private final O000000o O0000o00;

    public static class O000000o extends ByteArrayOutputStream {

        /* renamed from: O000000o  reason: collision with root package name */
        private final isz f1615O000000o;
        private final int O00000Oo;

        O000000o(int i, isz isz) {
            this(i, isz, 0);
        }

        private O000000o(int i, isz isz, int i2) {
            super(i);
            this.f1615O000000o = isz;
            this.O00000Oo = i2;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(int i) {
            write(i & 255);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(byte[] bArr, int i) {
            for (int i2 = 0; i2 < i; i2++) {
                O000000o(bArr[i2 + 0]);
            }
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo(int i) {
            O000000o(i >> 8);
            O000000o(i);
        }

        private void O00000o0(int i) {
            O00000Oo(i >> 16);
            O00000Oo(i);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(String str, int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                char charAt = str.charAt(i3 + 0);
                i2 = (charAt <= 0 || charAt > 127) ? charAt > 2047 ? i2 + 3 : i2 + 2 : i2 + 1;
            }
            O000000o(i2);
            for (int i4 = 0; i4 < i; i4++) {
                char charAt2 = str.charAt(i4 + 0);
                if (charAt2 > 0 && charAt2 <= 127) {
                    O000000o(charAt2);
                } else if (charAt2 > 2047) {
                    O000000o(((charAt2 >> 12) & 15) | 224);
                    O000000o(((charAt2 >> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                    O000000o(((charAt2 >> 0) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                } else {
                    O000000o(((charAt2 >> 6) & 31) | 192);
                    O000000o(((charAt2 >> 0) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(ita ita) {
            O000000o(ita.O00000Oo());
            O00000Oo(ita.O00000oO().indexValue());
            O00000Oo(ita.O00000oo().indexValue());
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(itb itb, long j) {
            int i;
            O000000o(itb.O00000Oo());
            O00000Oo(itb.O00000oO().indexValue());
            O00000Oo(itb.O00000oo().indexValue() | ((!itb.f1610O000000o || !this.f1615O000000o.O00000oO) ? 0 : 32768));
            if (j == 0) {
                i = itb.O00000o0;
            } else {
                i = itb.O00000Oo(j);
            }
            O00000o0(i);
            O000000o o000000o = new O000000o(512, this.f1615O000000o, this.O00000Oo + size() + 2);
            itb.O000000o(o000000o);
            byte[] byteArray = o000000o.toByteArray();
            O00000Oo(byteArray.length);
            write(byteArray, 0, byteArray.length);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(String str) {
            while (true) {
                int indexOf = str.indexOf(46);
                if (indexOf < 0) {
                    indexOf = str.length();
                }
                if (indexOf <= 0) {
                    O000000o(0);
                    return;
                }
                String substring = str.substring(0, indexOf);
                if (isz.f1614O000000o) {
                    Integer num = this.f1615O000000o.O00000Oo.get(str);
                    if (num != null) {
                        int intValue = num.intValue();
                        O000000o((intValue >> 8) | 192);
                        O000000o(intValue & 255);
                        return;
                    }
                    this.f1615O000000o.O00000Oo.put(str, Integer.valueOf(size() + this.O00000Oo));
                }
                O000000o(substring, substring.length());
                str = str.substring(indexOf);
                if (str.startsWith(".")) {
                    str = str.substring(1);
                }
            }
        }
    }

    public isz(int i) {
        this(i, true, 1460);
    }

    public isz(int i, boolean z, int i2) {
        super(i, 0, z);
        this.O00000Oo = new HashMap();
        this.O00000o0 = i2 > 0 ? i2 : 1460;
        this.O0000OoO = new O000000o(i2, this);
        this.O0000Ooo = new O000000o(i2, this);
        this.O0000o00 = new O000000o(i2, this);
        this.O0000o0 = new O000000o(i2, this);
    }

    private int O00000Oo() {
        return ((((this.O00000o0 - 12) - this.O0000OoO.size()) - this.O0000Ooo.size()) - this.O0000o00.size()) - this.O0000o0.size();
    }

    public final void O000000o(ita ita) throws IOException {
        O000000o o000000o = new O000000o(512, this);
        o000000o.O000000o(ita);
        byte[] byteArray = o000000o.toByteArray();
        if (byteArray.length < O00000Oo()) {
            this.O0000O0o.add(ita);
            this.O0000OoO.write(byteArray, 0, byteArray.length);
            return;
        }
        throw new IOException("message full");
    }

    public final void O000000o(isw isw, itb itb) throws IOException {
        if (isw == null || !itb.O000000o(isw)) {
            O000000o(itb, 0);
        }
    }

    public final void O000000o(itb itb, long j) throws IOException {
        if (itb == null) {
            return;
        }
        if (j == 0 || !itb.O000000o(j)) {
            O000000o o000000o = new O000000o(512, this);
            o000000o.O000000o(itb, j);
            byte[] byteArray = o000000o.toByteArray();
            if (byteArray.length < O00000Oo()) {
                this.O0000OOo.add(itb);
                this.O0000Ooo.write(byteArray, 0, byteArray.length);
                return;
            }
            throw new IOException("message full");
        }
    }

    public final void O000000o(itb itb) throws IOException {
        O000000o o000000o = new O000000o(512, this);
        o000000o.O000000o(itb, 0);
        byte[] byteArray = o000000o.toByteArray();
        if (byteArray.length < O00000Oo()) {
            this.O0000Oo0.add(itb);
            this.O0000o00.write(byteArray, 0, byteArray.length);
            return;
        }
        throw new IOException("message full");
    }

    public final byte[] O000000o() {
        long currentTimeMillis = System.currentTimeMillis();
        this.O00000Oo.clear();
        O000000o o000000o = new O000000o(this.O00000o0, this);
        o000000o.O00000Oo(this.O00000oO ? 0 : O00000o0());
        o000000o.O00000Oo(this.O00000oo);
        o000000o.O00000Oo(O00000oO());
        o000000o.O00000Oo(O0000OOo());
        o000000o.O00000Oo(O0000Oo());
        o000000o.O00000Oo(O0000Ooo());
        for (ita O000000o2 : this.O0000O0o) {
            o000000o.O000000o(O000000o2);
        }
        for (itb O000000o3 : this.O0000OOo) {
            o000000o.O000000o(O000000o3, currentTimeMillis);
        }
        for (itb O000000o4 : this.O0000Oo0) {
            o000000o.O000000o(O000000o4, currentTimeMillis);
        }
        for (itb O000000o5 : this.O0000Oo) {
            o000000o.O000000o(O000000o5, currentTimeMillis);
        }
        return o000000o.toByteArray();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(O0000o0() ? "dns[query:" : "dns[response:");
        sb.append(" id=0x");
        sb.append(Integer.toHexString(O00000o0()));
        if (this.O00000oo != 0) {
            sb.append(", flags=0x");
            sb.append(Integer.toHexString(this.O00000oo));
            if ((this.O00000oo & 32768) != 0) {
                sb.append(":r");
            }
            if ((this.O00000oo & 1024) != 0) {
                sb.append(":aa");
            }
            if ((this.O00000oo & 512) != 0) {
                sb.append(":tc");
            }
        }
        if (O00000oO() > 0) {
            sb.append(", questions=");
            sb.append(O00000oO());
        }
        if (O0000OOo() > 0) {
            sb.append(", answers=");
            sb.append(O0000OOo());
        }
        if (O0000Oo() > 0) {
            sb.append(", authorities=");
            sb.append(O0000Oo());
        }
        if (O0000Ooo() > 0) {
            sb.append(", additionals=");
            sb.append(O0000Ooo());
        }
        if (O00000oO() > 0) {
            sb.append("\nquestions:");
            for (ita append : this.O0000O0o) {
                sb.append("\n\t");
                sb.append(append);
            }
        }
        if (O0000OOo() > 0) {
            sb.append("\nanswers:");
            for (itb append2 : this.O0000OOo) {
                sb.append("\n\t");
                sb.append(append2);
            }
        }
        if (O0000Oo() > 0) {
            sb.append("\nauthorities:");
            for (itb append3 : this.O0000Oo0) {
                sb.append("\n\t");
                sb.append(append3);
            }
        }
        if (O0000Ooo() > 0) {
            sb.append("\nadditionals:");
            for (itb append4 : this.O0000Oo) {
                sb.append("\n\t");
                sb.append(append4);
            }
        }
        sb.append("\nnames=");
        sb.append(this.O00000Oo);
        sb.append("]");
        return sb.toString();
    }

    public final boolean O0000o0() {
        return (this.O00000oo & 32768) == 0;
    }
}
