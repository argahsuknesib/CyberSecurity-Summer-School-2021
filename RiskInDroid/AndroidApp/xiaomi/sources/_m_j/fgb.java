package _m_j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class fgb {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<fga> f16254O000000o = new ArrayList();
    private byte[] O00000Oo;

    public fgb(byte[] bArr) {
        if (!got.O00000o(bArr)) {
            this.O00000Oo = bArr;
            try {
                List<fga> O000000o2 = O000000o(this.O00000Oo);
                if (!gpn.O000000o(O000000o2)) {
                    this.f16254O000000o.addAll(O000000o2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static List<fga> O000000o(byte[] bArr) {
        byte b;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < bArr.length) {
            fga fga = null;
            if (bArr.length - i >= 2 && (b = bArr[i]) > 0) {
                byte b2 = bArr[i + 1];
                int i2 = i + 2;
                if (i2 < bArr.length) {
                    fga = new fga();
                    int i3 = (i2 + b) - 2;
                    if (i3 >= bArr.length) {
                        i3 = bArr.length - 1;
                    }
                    fga.O00000Oo = b2 & 255;
                    fga.f16253O000000o = b;
                    fga.O00000o0 = got.O000000o(bArr, i2, i3);
                }
            }
            if (fga == null) {
                break;
            }
            arrayList.add(fga);
            i += fga.f16253O000000o + 1;
        }
        return arrayList;
    }

    public final String O000000o() {
        if (gpn.O000000o(this.f16254O000000o)) {
            return "";
        }
        Iterator<fga> it = this.f16254O000000o.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            fga next = it.next();
            if (next.O00000Oo == 9) {
                if (!got.O00000o(next.O00000o0)) {
                    return new String(next.O00000o0);
                }
            }
        }
        return "";
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (fga fga : this.f16254O000000o) {
            sb.append(fga.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
