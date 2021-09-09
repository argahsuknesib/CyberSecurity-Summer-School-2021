package _m_j;

import com.iheartradio.m3u8.ParseException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class bbu extends bbf {
    static final bbj O00000o = new bbu() {
        /* class _m_j.bbu.AnonymousClass1 */

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return false;
        }

        public final String O00000Oo() {
            return "EXT-X-ENDLIST";
        }

        public final void O000000o(bcc bcc, bcn bcn, bcm bcm) throws IOException {
            if (!bcm.O00000oo) {
                bcc.O00000Oo("EXT-X-ENDLIST");
            }
        }
    };
    static final bbj O00000oO = new bbu() {
        /* class _m_j.bbu.AnonymousClass2 */

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return false;
        }

        public final String O00000Oo() {
            return "EXT-X-I-FRAMES-ONLY";
        }

        public final void O000000o(bcc bcc, bcn bcn, bcm bcm) throws IOException {
            if (bcm.O00000oO) {
                bcc.O00000Oo("EXT-X-I-FRAMES-ONLY");
            }
        }
    };
    static final bbj O00000oo = new bbu() {
        /* class _m_j.bbu.AnonymousClass3 */

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return true;
        }

        public final String O00000Oo() {
            return "EXT-X-PLAYLIST-TYPE";
        }

        public final void O000000o(bcc bcc, bcn bcn, bcm bcm) throws IOException {
            if (bcm.O0000O0o != null) {
                bcc.O000000o("EXT-X-PLAYLIST-TYPE", bcm.O0000O0o.getValue());
            }
        }
    };
    static final bbj O0000O0o = new bbu() {
        /* class _m_j.bbu.AnonymousClass4 */
        private final Map<String, bbb<bcq>> O0000o00 = new HashMap();

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return true;
        }

        public final String O00000Oo() {
            return "EXT-X-START";
        }

        {
            this.O0000o00.put("TIME-OFFSET", new bbb<bcq>() {
                /* class _m_j.bbu.AnonymousClass4.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return true;
                }

                public final /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return Float.toString(((bcq) obj).f12867O000000o);
                }
            });
            this.O0000o00.put("PRECISE", new bbb<bcq>() {
                /* class _m_j.bbu.AnonymousClass4.AnonymousClass2 */

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return true;
                }

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return ((bcq) obj).O00000Oo ? "YES" : "NO";
                }
            });
        }

        public final void O000000o(bcc bcc, bcn bcn, bcm bcm) throws IOException, ParseException {
            if (bcm.O000000o()) {
                O000000o(bcc, bcm.O0000OOo, this.O0000o00);
            }
        }
    };
    static final bbj O0000OOo = new bbu() {
        /* class _m_j.bbu.AnonymousClass5 */

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return true;
        }

        public final String O00000Oo() {
            return "EXT-X-TARGETDURATION";
        }

        public final void O000000o(bcc bcc, bcn bcn, bcm bcm) throws IOException, ParseException {
            bcc.O000000o("EXT-X-TARGETDURATION", Integer.toString(bcm.O00000o0));
        }
    };
    static final bbj O0000Oo = new bbu() {
        /* class _m_j.bbu.AnonymousClass7 */

        public final void O000000o(bcc bcc, bcn bcn, bcm bcm) {
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return true;
        }

        public final String O00000Oo() {
            return "EXT-X-ALLOW-CACHE";
        }
    };
    static final bbj O0000Oo0 = new bbu() {
        /* class _m_j.bbu.AnonymousClass6 */

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return true;
        }

        public final String O00000Oo() {
            return "EXT-X-MEDIA-SEQUENCE";
        }

        public final void O000000o(bcc bcc, bcn bcn, bcm bcm) throws IOException, ParseException {
            bcc.O000000o("EXT-X-MEDIA-SEQUENCE", Integer.toString(bcm.O00000o));
        }
    };
    static final bbj O0000OoO = new bbu() {
        /* class _m_j.bbu.AnonymousClass8 */

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return true;
        }

        public final String O00000Oo() {
            return "EXTINF";
        }

        public final void O000000o(bcc bcc, bcn bcn, bcm bcm) throws IOException, ParseException {
            for (bct next : bcm.f12860O000000o) {
                StringBuilder sb = new StringBuilder();
                if (bcn.O00000o <= 3) {
                    sb.append(Integer.toString((int) next.O00000Oo.f12873O000000o));
                } else {
                    sb.append(Float.toString(next.O00000Oo.f12873O000000o));
                }
                if (next.O00000Oo.O00000Oo != null) {
                    sb.append(bbd.f12761O000000o);
                    sb.append(next.O00000Oo.O00000Oo);
                }
                if (next.O00000o) {
                    bcc.O00000Oo("EXT-X-DISCONTINUITY");
                }
                bcc.O000000o("EXTINF", sb.toString());
                bcc.O000000o(next.f12871O000000o);
            }
        }
    };
    static final bbf O0000Ooo = new bbu() {
        /* class _m_j.bbu.AnonymousClass9 */
        private final Map<String, bbb<bch>> O0000o00 = new HashMap();

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return true;
        }

        public final String O00000Oo() {
            return "EXT-X-KEY";
        }

        {
            this.O0000o00.put("METHOD", new bbb<bch>() {
                /* class _m_j.bbu.AnonymousClass9.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return true;
                }

                public final /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return ((bch) obj).f12852O000000o.getValue();
                }
            });
            this.O0000o00.put("URI", new bbb<bch>() {
                /* class _m_j.bbu.AnonymousClass9.AnonymousClass2 */

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return true;
                }

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(((bch) obj).O00000Oo, "EXT-X-KEY");
                }
            });
            this.O0000o00.put("IV", new bbb<bch>() {
                /* class _m_j.bbu.AnonymousClass9.AnonymousClass3 */

                public final /* synthetic */ String O000000o(Object obj) throws ParseException {
                    List<Byte> list = ((bch) obj).O00000o0;
                    if (list == null || list.size() == 0) {
                        throw new IllegalArgumentException("hex might not be null or empty!");
                    }
                    StringBuilder sb = new StringBuilder(list.size() + 2);
                    sb.append("0x");
                    for (Byte byteValue : list) {
                        sb.append(Integer.toHexString(byteValue.byteValue()));
                    }
                    return sb.toString();
                }

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return ((bch) obj).O00000o0 != null;
                }
            });
            this.O0000o00.put("KEYFORMAT", new bbb<bch>() {
                /* class _m_j.bbu.AnonymousClass9.AnonymousClass4 */

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return true;
                }

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(((bch) obj).O00000o, "EXT-X-KEY");
                }
            });
            this.O0000o00.put("KEYFORMATVERSIONS", new bbb<bch>() {
                /* class _m_j.bbu.AnonymousClass9.AnonymousClass5 */

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return true;
                }

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(bce.O000000o(((bch) obj).O00000oO, "/"), "EXT-X-KEY");
                }
            });
        }

        public final void O000000o(bcc bcc, bcn bcn, bcm bcm) throws IOException, ParseException {
            if (bcm.f12860O000000o.size() > 0) {
                bct bct = bcm.f12860O000000o.get(0);
                if (bct.O00000Oo()) {
                    O000000o(bcc, bct.O00000o0, this.O0000o00);
                }
            }
        }
    };

    bbu() {
    }

    public final void O000000o(bcc bcc, bcn bcn) throws IOException, ParseException {
        if (bcn.O00000Oo()) {
            O000000o(bcc, bcn, bcn.O00000Oo);
        }
    }

    public void O000000o(bcc bcc, bcn bcn, bcm bcm) throws IOException, ParseException {
        bcc.O00000Oo(O00000Oo());
    }
}
