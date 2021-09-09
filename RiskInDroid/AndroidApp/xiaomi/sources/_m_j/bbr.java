package _m_j;

import com.iheartradio.m3u8.ParseException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

abstract class bbr extends bbf {
    static final bbj O00000o = new bbr() {
        /* class _m_j.bbr.AnonymousClass1 */
        private final Map<String, bbb<bcl>> O0000O0o = new HashMap();

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return true;
        }

        public final String O00000Oo() {
            return "EXT-X-MEDIA";
        }

        {
            this.O0000O0o.put("TYPE", new bbb<bcl>() {
                /* class _m_j.bbr.AnonymousClass1.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return true;
                }

                public final /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return ((bcl) obj).f12858O000000o.getValue();
                }
            });
            this.O0000O0o.put("URI", new bbb<bcl>() {
                /* class _m_j.bbr.AnonymousClass1.AnonymousClass4 */

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(((bcl) obj).O00000Oo, "EXT-X-MEDIA");
                }

                public final /* synthetic */ boolean O00000Oo(Object obj) {
                    return ((bcl) obj).O000000o();
                }
            });
            this.O0000O0o.put("GROUP-ID", new bbb<bcl>() {
                /* class _m_j.bbr.AnonymousClass1.AnonymousClass5 */

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return true;
                }

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(((bcl) obj).O00000o0, "EXT-X-MEDIA");
                }
            });
            this.O0000O0o.put("LANGUAGE", new bbb<bcl>() {
                /* class _m_j.bbr.AnonymousClass1.AnonymousClass6 */

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(((bcl) obj).O00000o, "EXT-X-MEDIA");
                }

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return ((bcl) obj).O00000o != null;
                }
            });
            this.O0000O0o.put("ASSOC-LANGUAGE", new bbb<bcl>() {
                /* class _m_j.bbr.AnonymousClass1.AnonymousClass7 */

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(((bcl) obj).O00000oO, "EXT-X-MEDIA");
                }

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return ((bcl) obj).O00000oO != null;
                }
            });
            this.O0000O0o.put("NAME", new bbb<bcl>() {
                /* class _m_j.bbr.AnonymousClass1.AnonymousClass8 */

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return true;
                }

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(((bcl) obj).O00000oo, "EXT-X-MEDIA");
                }
            });
            this.O0000O0o.put("DEFAULT", new bbb<bcl>() {
                /* class _m_j.bbr.AnonymousClass1.AnonymousClass9 */

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return true;
                }

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(((bcl) obj).O0000O0o);
                }
            });
            this.O0000O0o.put("AUTOSELECT", new bbb<bcl>() {
                /* class _m_j.bbr.AnonymousClass1.AnonymousClass10 */

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return true;
                }

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(((bcl) obj).O0000OOo);
                }
            });
            this.O0000O0o.put("FORCED", new bbb<bcl>() {
                /* class _m_j.bbr.AnonymousClass1.AnonymousClass11 */

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return true;
                }

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(((bcl) obj).O0000Oo0);
                }
            });
            this.O0000O0o.put("INSTREAM-ID", new bbb<bcl>() {
                /* class _m_j.bbr.AnonymousClass1.AnonymousClass2 */

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(((bcl) obj).O0000Oo, "EXT-X-MEDIA");
                }

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return ((bcl) obj).O0000Oo != null;
                }
            });
            this.O0000O0o.put("CHARACTERISTICS", new bbb<bcl>() {
                /* class _m_j.bbr.AnonymousClass1.AnonymousClass3 */

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(bce.O000000o(((bcl) obj).O0000OoO, bbd.f12761O000000o), "EXT-X-MEDIA");
                }

                public final /* synthetic */ boolean O00000Oo(Object obj) {
                    return !((bcl) obj).O0000OoO.isEmpty();
                }
            });
        }

        public final void O000000o(bcc bcc, bck bck) throws IOException, ParseException {
            if (bck.O00000o0.size() > 0) {
                for (bcl O000000o2 : bck.O00000o0) {
                    O000000o(bcc, O000000o2, this.O0000O0o);
                }
            }
        }
    };
    static final bbj O00000oO = new O000000o<bci>() {
        /* class _m_j.bbr.AnonymousClass2 */

        public final String O00000Oo() {
            return "EXT-X-I-FRAME-STREAM-INF";
        }

        {
            this.O0000O0o.put("URI", new bbb<bci>() {
                /* class _m_j.bbr.AnonymousClass2.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return true;
                }

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(((bci) obj).O00000o0, "EXT-X-I-FRAME-STREAM-INF");
                }
            });
        }

        public final void O000000o(bcc bcc, bck bck) throws IOException, ParseException {
            for (bci O000000o2 : bck.O00000Oo) {
                O000000o(bcc, O000000o2, this.O0000O0o);
            }
        }
    };
    static final bbj O00000oo = new O000000o<bcr>() {
        /* class _m_j.bbr.AnonymousClass3 */

        public final String O00000Oo() {
            return "EXT-X-STREAM-INF";
        }

        {
            this.O0000O0o.put("AUDIO", new bbb<bcr>() {
                /* class _m_j.bbr.AnonymousClass3.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(((bcr) obj).O00000o0, "EXT-X-STREAM-INF");
                }

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return ((bcr) obj).O00000o0 != null;
                }
            });
            this.O0000O0o.put("SUBTITLES", new bbb<bcr>() {
                /* class _m_j.bbr.AnonymousClass3.AnonymousClass2 */

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(((bcr) obj).O00000o, "EXT-X-STREAM-INF");
                }

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return ((bcr) obj).O00000o != null;
                }
            });
            this.O0000O0o.put("CLOSED-CAPTIONS", new bbb<bcr>() {
                /* class _m_j.bbr.AnonymousClass3.AnonymousClass3 */

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(((bcr) obj).O00000oO, "EXT-X-STREAM-INF");
                }

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return ((bcr) obj).O00000oO != null;
                }
            });
        }

        public final void O000000o(bcc bcc, bck bck) throws IOException, ParseException {
            for (bco next : bck.f12856O000000o) {
                if (next.O000000o()) {
                    O000000o(bcc, next.O00000Oo, this.O0000O0o);
                    bcc.O000000o(next.f12864O000000o);
                }
            }
        }
    };

    bbr() {
    }

    public final void O000000o(bcc bcc, bcn bcn) throws IOException, ParseException {
        if (bcn.O000000o()) {
            O000000o(bcc, bcn.f12862O000000o);
        }
    }

    public void O000000o(bcc bcc, bck bck) throws IOException, ParseException {
        bcc.O00000Oo(O00000Oo());
    }

    static abstract class O000000o<T extends bcj> extends bbr {
        final Map<String, bbb<T>> O0000O0o = new HashMap();

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return true;
        }

        O000000o() {
            this.O0000O0o.put("BANDWIDTH", new bbb<T>() {
                /* class _m_j.bbr.O000000o.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return true;
                }

                public final /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return Integer.toString(((bcj) obj).O000000o());
                }
            });
            this.O0000O0o.put("AVERAGE-BANDWIDTH", new bbb<T>() {
                /* class _m_j.bbr.O000000o.AnonymousClass2 */

                public final /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return Integer.toString(((bcj) obj).O00000o0());
                }

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return ((bcj) obj).O00000Oo();
                }
            });
            this.O0000O0o.put("CODECS", new bbb<T>() {
                /* class _m_j.bbr.O000000o.AnonymousClass3 */

                public final /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(bce.O000000o(((bcj) obj).O00000oO(), bbd.f12761O000000o), O000000o.this.O00000Oo());
                }

                public final /* synthetic */ boolean O00000Oo(Object obj) {
                    return ((bcj) obj).O00000o();
                }
            });
            this.O0000O0o.put("RESOLUTION", new bbb<T>() {
                /* class _m_j.bbr.O000000o.AnonymousClass4 */

                public final /* synthetic */ String O000000o(Object obj) throws ParseException {
                    bcp O0000O0o = ((bcj) obj).O0000O0o();
                    return O0000O0o.f12866O000000o + "x" + O0000O0o.O00000Oo;
                }

                public final /* synthetic */ boolean O00000Oo(Object obj) {
                    return ((bcj) obj).O00000oo();
                }
            });
            this.O0000O0o.put("FRAME-RATE", new bbb<T>() {
                /* class _m_j.bbr.O000000o.AnonymousClass5 */

                public final /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return String.valueOf(((bcj) obj).O0000Oo0());
                }

                public final /* synthetic */ boolean O00000Oo(Object obj) {
                    return ((bcj) obj).O0000OOo();
                }
            });
            this.O0000O0o.put("VIDEO", new bbb<T>() {
                /* class _m_j.bbr.O000000o.AnonymousClass6 */

                public final /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return bce.O000000o(((bcj) obj).O0000OoO(), O000000o.this.O00000Oo());
                }

                public final /* synthetic */ boolean O00000Oo(Object obj) {
                    return ((bcj) obj).O0000Oo();
                }
            });
            this.O0000O0o.put("PROGRAM-ID", new bbb<T>() {
                /* class _m_j.bbr.O000000o.AnonymousClass7 */

                public final /* bridge */ /* synthetic */ String O000000o(Object obj) throws ParseException {
                    return "";
                }

                public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
                    return false;
                }
            });
        }
    }
}
