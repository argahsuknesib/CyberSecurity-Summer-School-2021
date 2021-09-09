package _m_j;

import android.os.AsyncTask;
import com.xiaomi.zxing.NotFoundException;

public final class jmf extends AsyncTask<Void, Void, idf> {

    /* renamed from: O000000o  reason: collision with root package name */
    private byte[] f1956O000000o;
    private int O00000Oo;
    private jmg O00000o;
    private int O00000o0;
    private final idb O00000oO;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return O000000o();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        idf idf = (idf) obj;
        super.onPostExecute(idf);
        if (idf != null) {
            this.O00000o.O000000o(idf, this.O00000Oo, this.O00000o0);
        }
        this.O00000o.O000000o();
    }

    public jmf(jmg jmg, idb idb, byte[] bArr, int i, int i2) {
        this.f1956O000000o = bArr;
        this.O00000Oo = i;
        this.O00000o0 = i2;
        this.O00000o = jmg;
        this.O00000oO = idb;
    }

    private idf O000000o() {
        if (isCancelled() || this.O00000o == null) {
            return null;
        }
        try {
            return this.O00000oO.O000000o(O000000o(this.f1956O000000o, this.O00000Oo, this.O00000o0, false));
        } catch (NotFoundException unused) {
            try {
                return this.O00000oO.O000000o(O000000o(O000000o(this.f1956O000000o, this.O00000Oo, this.O00000o0), this.O00000o0, this.O00000Oo, false));
            } catch (NotFoundException unused2) {
                try {
                    return this.O00000oO.O000000o(O000000o(this.f1956O000000o, this.O00000Oo, this.O00000o0, true));
                } catch (NotFoundException unused3) {
                    try {
                        return this.O00000oO.O000000o(O000000o(O000000o(this.f1956O000000o, this.O00000Oo, this.O00000o0), this.O00000o0, this.O00000Oo, true));
                    } catch (NotFoundException unused4) {
                        return null;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] O000000o(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        return bArr2;
    }

    private static icy O000000o(byte[] bArr, int i, int i2, boolean z) {
        idc idc = new idc(bArr, i, i2, 0, 0, i, i2, false);
        if (z) {
            return new icy(new idt(idc.O00000o0()));
        }
        return new icy(new idt(idc));
    }
}
