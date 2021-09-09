package _m_j;

import android.support.v4.app.NotificationCompat;
import gK.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class jqx {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public static final jqw[] f2072O000000o = {new jqw(jqw.O00000oO, ""), new jqw(jqw.O00000Oo, "GET"), new jqw(jqw.O00000Oo, "POST"), new jqw(jqw.O00000o0, "/"), new jqw(jqw.O00000o0, "/index.html"), new jqw(jqw.O00000o, "http"), new jqw(jqw.O00000o, "https"), new jqw(jqw.f2071O000000o, "200"), new jqw(jqw.f2071O000000o, "204"), new jqw(jqw.f2071O000000o, "206"), new jqw(jqw.f2071O000000o, "304"), new jqw(jqw.f2071O000000o, "400"), new jqw(jqw.f2071O000000o, "404"), new jqw(jqw.f2071O000000o, "500"), new jqw("accept-charset", ""), new jqw("accept-encoding", "gzip, deflate"), new jqw("accept-language", ""), new jqw("accept-ranges", ""), new jqw("accept", ""), new jqw("access-control-allow-origin", ""), new jqw("age", ""), new jqw("allow", ""), new jqw("authorization", ""), new jqw("cache-control", ""), new jqw("content-disposition", ""), new jqw("content-encoding", ""), new jqw("content-language", ""), new jqw("content-length", ""), new jqw("content-location", ""), new jqw("content-range", ""), new jqw("content-type", ""), new jqw("cookie", ""), new jqw("date", ""), new jqw("etag", ""), new jqw("expect", ""), new jqw("expires", ""), new jqw("from", ""), new jqw("host", ""), new jqw("if-match", ""), new jqw("if-modified-since", ""), new jqw("if-none-match", ""), new jqw("if-range", ""), new jqw("if-unmodified-since", ""), new jqw("last-modified", ""), new jqw("link", ""), new jqw("location", ""), new jqw("max-forwards", ""), new jqw("proxy-authenticate", ""), new jqw("proxy-authorization", ""), new jqw("range", ""), new jqw("referer", ""), new jqw("refresh", ""), new jqw("retry-after", ""), new jqw("server", ""), new jqw("set-cookie", ""), new jqw("strict-transport-security", ""), new jqw("transfer-encoding", ""), new jqw("user-agent", ""), new jqw("vary", ""), new jqw("via", ""), new jqw("www-authenticate", "")};
    /* access modifiers changed from: private */
    public static final Map<f, Integer> O00000Oo;

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2073O000000o = 4096;
        int O00000Oo = 4096;
        int O00000o = (this.O00000o0.length - 1);
        jqw[] O00000o0 = new jqw[8];
        int O00000oO = 0;
        int O00000oo = 0;
        private final List<jqw> O0000O0o = new ArrayList();
        private final iqn O0000OOo;

        O000000o(int i, iqz iqz) {
            this.O0000OOo = iqt.O000000o(iqz);
        }

        private int O000000o(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.O00000o0.length;
                while (true) {
                    length--;
                    if (length < this.O00000o || i <= 0) {
                        jqw[] jqwArr = this.O00000o0;
                        int i3 = this.O00000o;
                        System.arraycopy(jqwArr, i3 + 1, jqwArr, i3 + 1 + i2, this.O00000oO);
                        this.O00000o += i2;
                    } else {
                        i -= this.O00000o0[length].O0000Oo;
                        this.O00000oo -= this.O00000o0[length].O0000Oo;
                        this.O00000oO--;
                        i2++;
                    }
                }
                jqw[] jqwArr2 = this.O00000o0;
                int i32 = this.O00000o;
                System.arraycopy(jqwArr2, i32 + 1, jqwArr2, i32 + 1 + i2, this.O00000oO);
                this.O00000o += i2;
            }
            return i2;
        }

        private int O000000o(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int O00000oO2 = O00000oO();
                if ((O00000oO2 & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                    return i2 + (O00000oO2 << i4);
                }
                i2 += (O00000oO2 & 127) << i4;
                i4 += 7;
            }
        }

        private void O000000o(jqw jqw) {
            this.O0000O0o.add(jqw);
            int i = jqw.O0000Oo;
            int i2 = this.O00000Oo;
            if (i > i2) {
                O00000o();
                return;
            }
            O000000o((this.O00000oo + i) - i2);
            int i3 = this.O00000oO + 1;
            jqw[] jqwArr = this.O00000o0;
            if (i3 > jqwArr.length) {
                jqw[] jqwArr2 = new jqw[(jqwArr.length * 2)];
                System.arraycopy(jqwArr, 0, jqwArr2, jqwArr.length, jqwArr.length);
                this.O00000o = this.O00000o0.length - 1;
                this.O00000o0 = jqwArr2;
            }
            int i4 = this.O00000o;
            this.O00000o = i4 - 1;
            this.O00000o0[i4] = jqw;
            this.O00000oO++;
            this.O00000oo += i;
        }

        private int O00000Oo(int i) {
            return this.O00000o + 1 + i;
        }

        private void O00000o() {
            this.O0000O0o.clear();
            Arrays.fill(this.O00000o0, (Object) null);
            this.O00000o = this.O00000o0.length - 1;
            this.O00000oO = 0;
            this.O00000oo = 0;
        }

        private static boolean O00000o(int i) {
            return i >= 0 && i <= jqx.f2072O000000o.length - 1;
        }

        private f O00000o0(int i) {
            return (O00000o(i) ? jqx.f2072O000000o[i] : this.O00000o0[O00000Oo(i - jqx.f2072O000000o.length)]).O0000OOo;
        }

        private int O00000oO() throws IOException {
            return this.O0000OOo.O00000oo() & 255;
        }

        private f O00000oo() throws IOException {
            int O00000oO2 = O00000oO();
            boolean z = (O00000oO2 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128;
            int O000000o2 = O000000o(O00000oO2, 127);
            return z ? f.O000000o(jqz.O000000o().O000000o(this.O0000OOo.O00000oO((long) O000000o2))) : this.O0000OOo.O00000o0((long) O000000o2);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            int i = this.O00000Oo;
            int i2 = this.O00000oo;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                O00000o();
            } else {
                O000000o(i2 - i);
            }
        }

        public final List<jqw> O00000o0() {
            ArrayList arrayList = new ArrayList(this.O0000O0o);
            this.O0000O0o.clear();
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo() throws IOException {
            while (!this.O0000OOo.O00000o()) {
                byte O00000oo2 = this.O0000OOo.O00000oo() & 255;
                if (O00000oo2 == 128) {
                    throw new IOException("index == 0");
                } else if ((O00000oo2 & 128) == 128) {
                    int O000000o2 = O000000o(O00000oo2, 127) - 1;
                    if (O00000o(O000000o2)) {
                        this.O0000O0o.add(jqx.f2072O000000o[O000000o2]);
                    } else {
                        int O00000Oo2 = O00000Oo(O000000o2 - jqx.f2072O000000o.length);
                        if (O00000Oo2 >= 0) {
                            jqw[] jqwArr = this.O00000o0;
                            if (O00000Oo2 <= jqwArr.length - 1) {
                                this.O0000O0o.add(jqwArr[O00000Oo2]);
                            }
                        }
                        throw new IOException("Header index too large " + (O000000o2 + 1));
                    }
                } else if (O00000oo2 == 64) {
                    O000000o(new jqw(jqx.O000000o(O00000oo()), O00000oo()));
                } else if ((O00000oo2 & 64) == 64) {
                    O000000o(new jqw(O00000o0(O000000o(O00000oo2, 63) - 1), O00000oo()));
                } else if ((O00000oo2 & 32) == 32) {
                    this.O00000Oo = O000000o(O00000oo2, 31);
                    int i = this.O00000Oo;
                    if (i < 0 || i > this.f2073O000000o) {
                        throw new IOException("Invalid dynamic table size update " + this.O00000Oo);
                    }
                    O000000o();
                } else if (O00000oo2 == 16 || O00000oo2 == 0) {
                    this.O0000O0o.add(new jqw(jqx.O000000o(O00000oo()), O00000oo()));
                } else {
                    this.O0000O0o.add(new jqw(O00000o0(O000000o(O00000oo2, 15) - 1), O00000oo()));
                }
            }
        }
    }

    static final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private final iql f2074O000000o;

        O00000Oo(iql iql) {
            this.f2074O000000o = iql;
        }

        private void O000000o(int i, int i2) throws IOException {
            int i3;
            iql iql;
            if (i < i2) {
                iql = this.f2074O000000o;
                i3 = i | 0;
            } else {
                this.f2074O000000o.O0000OOo(i2 | 0);
                i3 = i - i2;
                while (i3 >= 128) {
                    this.f2074O000000o.O0000OOo(128 | (i3 & 127));
                    i3 >>>= 7;
                }
                iql = this.f2074O000000o;
            }
            iql.O0000OOo(i3);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(List<jqw> list) throws IOException {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                f O00000o0 = list.get(i).O0000OOo.O00000o0();
                Integer num = (Integer) jqx.O00000Oo.get(O00000o0);
                if (num != null) {
                    O000000o(num.intValue() + 1, 15);
                } else {
                    this.f2074O000000o.O0000OOo(0);
                    O000000o(O00000o0);
                }
                O000000o(list.get(i).O0000Oo0);
            }
        }

        private void O000000o(f fVar) throws IOException {
            O000000o(fVar.c.length, 127);
            this.f2074O000000o.O00000Oo(fVar);
        }
    }

    static /* synthetic */ f O000000o(f fVar) throws IOException {
        int length = fVar.c.length;
        int i = 0;
        while (i < length) {
            byte b = fVar.c[i];
            if (b < 65 || b > 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.O000000o());
            }
        }
        return fVar;
    }

    static {
        int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap(f2072O000000o.length);
        while (true) {
            jqw[] jqwArr = f2072O000000o;
            if (i < jqwArr.length) {
                if (!linkedHashMap.containsKey(jqwArr[i].O0000OOo)) {
                    linkedHashMap.put(f2072O000000o[i].O0000OOo, Integer.valueOf(i));
                }
                i++;
            } else {
                O00000Oo = Collections.unmodifiableMap(linkedHashMap);
                return;
            }
        }
    }
}
