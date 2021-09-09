package _m_j;

import gK.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

final class jra {

    /* renamed from: O000000o  reason: collision with root package name */
    int f2082O000000o;
    final iqn O00000Oo = iqt.O000000o(this.O00000o0);
    private final iqs O00000o0;

    public jra(iqn iqn) {
        this.O00000o0 = new iqs(new iqp(iqn) {
            /* class _m_j.jra.AnonymousClass1 */

            public final long O000000o(iql iql, long j) throws IOException {
                if (jra.this.f2082O000000o == 0) {
                    return -1;
                }
                long O000000o2 = super.O000000o(iql, Math.min(j, (long) jra.this.f2082O000000o));
                if (O000000o2 == -1) {
                    return -1;
                }
                jra jra = jra.this;
                jra.f2082O000000o = (int) (((long) jra.f2082O000000o) - O000000o2);
                return O000000o2;
            }
        }, new Inflater() {
            /* class _m_j.jra.AnonymousClass2 */

            public final int inflate(byte[] bArr, int i, int i2) throws DataFormatException {
                int inflate = super.inflate(bArr, i, i2);
                if (inflate != 0 || !needsDictionary()) {
                    return inflate;
                }
                setDictionary(jre.f2088O000000o);
                return super.inflate(bArr, i, i2);
            }
        });
    }

    private f O000000o() throws IOException {
        return this.O00000Oo.O00000o0((long) this.O00000Oo.O0000OOo());
    }

    public final List<jqw> O000000o(int i) throws IOException {
        this.f2082O000000o += i;
        int O0000OOo = this.O00000Oo.O0000OOo();
        if (O0000OOo < 0) {
            throw new IOException("numberOfPairs < 0: ".concat(String.valueOf(O0000OOo)));
        } else if (O0000OOo <= 1024) {
            ArrayList arrayList = new ArrayList(O0000OOo);
            int i2 = 0;
            while (i2 < O0000OOo) {
                f O00000o02 = O000000o().O00000o0();
                f O000000o2 = O000000o();
                if (O00000o02.c.length != 0) {
                    arrayList.add(new jqw(O00000o02, O000000o2));
                    i2++;
                } else {
                    throw new IOException("name.size == 0");
                }
            }
            if (this.f2082O000000o > 0) {
                this.O00000o0.O00000Oo();
                if (this.f2082O000000o != 0) {
                    throw new IOException("compressedLimit > 0: " + this.f2082O000000o);
                }
            }
            return arrayList;
        } else {
            throw new IOException("numberOfPairs > 1024: ".concat(String.valueOf(O0000OOo)));
        }
    }
}
