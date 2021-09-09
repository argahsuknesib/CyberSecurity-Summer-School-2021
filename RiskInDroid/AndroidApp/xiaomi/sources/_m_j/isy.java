package _m_j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class isy {
    public int O00000o;
    public boolean O00000oO;
    public int O00000oo;
    protected final List<ita> O0000O0o = Collections.synchronizedList(new LinkedList());
    protected final List<itb> O0000OOo = Collections.synchronizedList(new LinkedList());
    protected final List<itb> O0000Oo = Collections.synchronizedList(new LinkedList());
    protected final List<itb> O0000Oo0 = Collections.synchronizedList(new LinkedList());

    protected isy(int i, int i2, boolean z) {
        this.O00000oo = i;
        this.O00000o = i2;
        this.O00000oO = z;
    }

    public final int O00000o0() {
        if (this.O00000oO) {
            return 0;
        }
        return this.O00000o;
    }

    public final Collection<? extends ita> O00000o() {
        return this.O0000O0o;
    }

    public final Collection<? extends itb> O00000oo() {
        ArrayList arrayList = new ArrayList(this.O0000OOo.size() + this.O0000Oo0.size() + this.O0000Oo.size());
        arrayList.addAll(this.O0000OOo);
        arrayList.addAll(this.O0000Oo0);
        arrayList.addAll(this.O0000Oo);
        return arrayList;
    }

    public final Collection<? extends itb> O0000O0o() {
        return this.O0000OOo;
    }

    public final Collection<? extends itb> O0000Oo0() {
        return this.O0000Oo0;
    }

    public final Collection<? extends itb> O0000OoO() {
        return this.O0000Oo;
    }

    public final boolean O0000o00() {
        return (this.O00000oo & 512) != 0;
    }

    public boolean O0000o0() {
        return (this.O00000oo & 32768) == 0;
    }

    public final boolean O0000o0O() {
        return ((O00000oO() + O0000OOo()) + O0000Oo()) + O0000Ooo() == 0;
    }

    /* access modifiers changed from: package-private */
    public final String O0000o0o() {
        StringBuilder sb = new StringBuilder(200);
        sb.append(toString());
        sb.append("\n");
        for (ita append : this.O0000O0o) {
            sb.append("\tquestion:      ");
            sb.append(append);
            sb.append("\n");
        }
        for (itb append2 : this.O0000OOo) {
            sb.append("\tanswer:        ");
            sb.append(append2);
            sb.append("\n");
        }
        for (itb append3 : this.O0000Oo0) {
            sb.append("\tauthoritative: ");
            sb.append(append3);
            sb.append("\n");
        }
        for (itb append4 : this.O0000Oo) {
            sb.append("\tadditional:    ");
            sb.append(append4);
            sb.append("\n");
        }
        return sb.toString();
    }

    protected static String O000000o(byte[] bArr) {
        StringBuilder sb = new StringBuilder(4000);
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int min = Math.min(32, length - i);
            if (i < 16) {
                sb.append(' ');
            }
            if (i < 256) {
                sb.append(' ');
            }
            if (i < 4096) {
                sb.append(' ');
            }
            sb.append(Integer.toHexString(i));
            sb.append(':');
            int i2 = 0;
            while (i2 < min) {
                if (i2 % 8 == 0) {
                    sb.append(' ');
                }
                int i3 = i + i2;
                sb.append(Integer.toHexString((bArr[i3] & 240) >> 4));
                sb.append(Integer.toHexString((bArr[i3] & 15) >> 0));
                i2++;
            }
            if (i2 < 32) {
                while (i2 < 32) {
                    if (i2 % 8 == 0) {
                        sb.append(' ');
                    }
                    sb.append("  ");
                    i2++;
                }
            }
            sb.append("    ");
            for (int i4 = 0; i4 < min; i4++) {
                if (i4 % 8 == 0) {
                    sb.append(' ');
                }
                byte b = bArr[i + i4] & 255;
                sb.append((b <= 32 || b >= Byte.MAX_VALUE) ? '.' : (char) b);
            }
            sb.append("\n");
            i += 32;
            if (i >= 2048) {
                sb.append("....\n");
                break;
            }
        }
        return sb.toString();
    }

    public final int O00000oO() {
        return this.O0000O0o.size();
    }

    public final int O0000OOo() {
        return this.O0000OOo.size();
    }

    public final int O0000Oo() {
        return this.O0000Oo0.size();
    }

    public final int O0000Ooo() {
        return this.O0000Oo.size();
    }
}
