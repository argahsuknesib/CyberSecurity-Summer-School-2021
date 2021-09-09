package _m_j;

import _m_j.bci;
import _m_j.bcl;
import _m_j.bcr;
import com.iheartradio.m3u8.ParseException;
import com.iheartradio.m3u8.ParseExceptionType;
import com.iheartradio.m3u8.data.MediaType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

final class bbq implements bbl {

    /* renamed from: O000000o  reason: collision with root package name */
    static final bbi f12767O000000o = new bbi() {
        /* class _m_j.bbq.AnonymousClass1 */

        /* renamed from: O000000o  reason: collision with root package name */
        private final bbl f12768O000000o = new bbq(this);
        private final Map<String, bba<bcl.O000000o>> O00000Oo = new HashMap();

        public final String O000000o() {
            return "EXT-X-MEDIA";
        }

        public final boolean O00000Oo() {
            return true;
        }

        {
            this.O00000Oo.put("TYPE", new bba<bcl.O000000o>() {
                /* class _m_j.bbq.AnonymousClass1.AnonymousClass1 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    bcl.O000000o o000000o = (bcl.O000000o) obj;
                    MediaType fromValue = MediaType.fromValue(baz.O00000Oo);
                    if (fromValue != null) {
                        o000000o.f12859O000000o = fromValue;
                        return;
                    }
                    throw ParseException.O000000o(ParseExceptionType.INVALID_MEDIA_TYPE, "EXT-X-MEDIA", baz.toString());
                }
            });
            this.O00000Oo.put("URI", new bba<bcl.O000000o>() {
                /* class _m_j.bbq.AnonymousClass1.AnonymousClass4 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    ((bcl.O000000o) obj).O00000Oo = bbw.O000000o(bbw.O00000o0(baz.O00000Oo, "EXT-X-MEDIA"), bbv.f12841O000000o);
                }
            });
            this.O00000Oo.put("GROUP-ID", new bba<bcl.O000000o>() {
                /* class _m_j.bbq.AnonymousClass1.AnonymousClass5 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    bcl.O000000o o000000o = (bcl.O000000o) obj;
                    String O00000o0 = bbw.O00000o0(baz.O00000Oo, "EXT-X-MEDIA");
                    if (!O00000o0.isEmpty()) {
                        o000000o.O00000o0 = O00000o0;
                        return;
                    }
                    throw ParseException.O000000o(ParseExceptionType.EMPTY_MEDIA_GROUP_ID, "EXT-X-MEDIA", baz.toString());
                }
            });
            this.O00000Oo.put("LANGUAGE", new bba<bcl.O000000o>() {
                /* class _m_j.bbq.AnonymousClass1.AnonymousClass6 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    ((bcl.O000000o) obj).O00000o = bbw.O00000o0(baz.O00000Oo, "EXT-X-MEDIA");
                }
            });
            this.O00000Oo.put("ASSOC-LANGUAGE", new bba<bcl.O000000o>() {
                /* class _m_j.bbq.AnonymousClass1.AnonymousClass7 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    ((bcl.O000000o) obj).O00000oO = bbw.O00000o0(baz.O00000Oo, "EXT-X-MEDIA");
                }
            });
            this.O00000Oo.put("NAME", new bba<bcl.O000000o>() {
                /* class _m_j.bbq.AnonymousClass1.AnonymousClass8 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    bcl.O000000o o000000o = (bcl.O000000o) obj;
                    String O00000o0 = bbw.O00000o0(baz.O00000Oo, "EXT-X-MEDIA");
                    if (!O00000o0.isEmpty()) {
                        o000000o.O00000oo = O00000o0;
                        return;
                    }
                    throw ParseException.O000000o(ParseExceptionType.EMPTY_MEDIA_NAME, "EXT-X-MEDIA", baz.toString());
                }
            });
            this.O00000Oo.put("DEFAULT", new bba<bcl.O000000o>() {
                /* class _m_j.bbq.AnonymousClass1.AnonymousClass9 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    bcl.O000000o o000000o = (bcl.O000000o) obj;
                    boolean O000000o2 = bbw.O000000o(baz, "EXT-X-MEDIA");
                    o000000o.O0000O0o = O000000o2;
                    bbv.O00000Oo.O00000oo = O000000o2;
                    if (!O000000o2) {
                        return;
                    }
                    if (!bbv.O00000Oo.O0000O0o) {
                        o000000o.O0000OOo = true;
                        return;
                    }
                    throw ParseException.O000000o(ParseExceptionType.AUTO_SELECT_DISABLED_FOR_DEFAULT, "EXT-X-MEDIA", baz.toString());
                }
            });
            this.O00000Oo.put("AUTOSELECT", new bba<bcl.O000000o>() {
                /* class _m_j.bbq.AnonymousClass1.AnonymousClass10 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    boolean O000000o2 = bbw.O000000o(baz, "EXT-X-MEDIA");
                    ((bcl.O000000o) obj).O0000OOo = O000000o2;
                    bbv.O00000Oo.O0000O0o = !O000000o2;
                    if (bbv.O00000Oo.O00000oo && !O000000o2) {
                        throw ParseException.O000000o(ParseExceptionType.AUTO_SELECT_DISABLED_FOR_DEFAULT, "EXT-X-MEDIA", baz.toString());
                    }
                }
            });
            this.O00000Oo.put("FORCED", new bba<bcl.O000000o>() {
                /* class _m_j.bbq.AnonymousClass1.AnonymousClass11 */

                public final /* bridge */ /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    ((bcl.O000000o) obj).O0000Oo0 = bbw.O000000o(baz, "EXT-X-MEDIA");
                }
            });
            this.O00000Oo.put("INSTREAM-ID", new bba<bcl.O000000o>() {
                /* class _m_j.bbq.AnonymousClass1.AnonymousClass2 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    bcl.O000000o o000000o = (bcl.O000000o) obj;
                    String O00000o0 = bbw.O00000o0(baz.O00000Oo, "EXT-X-MEDIA");
                    if (bbd.O0000Oo.matcher(O00000o0).matches()) {
                        o000000o.O0000Oo = O00000o0;
                        return;
                    }
                    throw ParseException.O000000o(ParseExceptionType.INVALID_MEDIA_IN_STREAM_ID, "EXT-X-MEDIA", baz.toString());
                }
            });
            this.O00000Oo.put("CHARACTERISTICS", new bba<bcl.O000000o>() {
                /* class _m_j.bbq.AnonymousClass1.AnonymousClass3 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    bcl.O000000o o000000o = (bcl.O000000o) obj;
                    String[] split = bbw.O00000o0(baz.O00000Oo, "EXT-X-MEDIA").split(bbd.f12761O000000o);
                    if (split.length != 0) {
                        o000000o.O0000OoO = Arrays.asList(split);
                        return;
                    }
                    throw ParseException.O000000o(ParseExceptionType.EMPTY_MEDIA_CHARACTERISTICS, "EXT-X-MEDIA", baz.toString());
                }
            });
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            String str2 = str;
            bbv bbv2 = bbv;
            this.f12768O000000o.O000000o(str2, bbv2);
            bcl.O000000o o000000o = new bcl.O000000o();
            bbp bbp = bbv2.O00000Oo;
            bbp.O00000oo = false;
            bbp.O0000O0o = false;
            bbw.O000000o(str2, o000000o, bbv2, this.O00000Oo, "EXT-X-MEDIA");
            bbv2.O00000Oo.O00000o0.add(new bcl(o000000o.f12859O000000o, o000000o.O00000Oo, o000000o.O00000o0, o000000o.O00000o, o000000o.O00000oO, o000000o.O00000oo, o000000o.O0000O0o, o000000o.O0000OOo, o000000o.O0000Oo0, o000000o.O0000Oo, o000000o.O0000OoO, (byte) 0));
        }
    };
    static final bbi O00000Oo = new bbi() {
        /* class _m_j.bbq.AnonymousClass3 */

        /* renamed from: O000000o  reason: collision with root package name */
        private final bbl f12781O000000o = new bbq(this);
        private final Map<String, bba<bci.O000000o>> O00000Oo = bbq.O000000o("EXT-X-I-FRAME-STREAM-INF");

        public final String O000000o() {
            return "EXT-X-I-FRAME-STREAM-INF";
        }

        public final boolean O00000Oo() {
            return true;
        }

        {
            this.O00000Oo.put("URI", new bba<bci.O000000o>() {
                /* class _m_j.bbq.AnonymousClass3.AnonymousClass1 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    ((bci.O000000o) obj).O0000O0o = bbw.O00000o0(baz.O00000Oo, "EXT-X-I-FRAME-STREAM-INF");
                }
            });
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            this.f12781O000000o.O000000o(str, bbv);
            bci.O000000o o000000o = new bci.O000000o();
            bbw.O000000o(str, o000000o, bbv, this.O00000Oo, "EXT-X-I-FRAME-STREAM-INF");
            bbv.O00000Oo.O00000Oo.add(new bci(o000000o.f12855O000000o, o000000o.O00000Oo, o000000o.O00000o0, o000000o.O00000o, o000000o.O00000oO, o000000o.O00000oo, o000000o.O0000O0o, (byte) 0));
        }
    };
    static final bbi O00000o0 = new bbi() {
        /* class _m_j.bbq.AnonymousClass4 */

        /* renamed from: O000000o  reason: collision with root package name */
        private final bbl f12783O000000o = new bbq(this);
        private final Map<String, bba<bcr.O000000o>> O00000Oo = bbq.O000000o("EXT-X-STREAM-INF");

        public final String O000000o() {
            return "EXT-X-STREAM-INF";
        }

        public final boolean O00000Oo() {
            return true;
        }

        {
            this.O00000Oo.put("AUDIO", new bba<bcr.O000000o>() {
                /* class _m_j.bbq.AnonymousClass4.AnonymousClass1 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    ((bcr.O000000o) obj).O00000oo = bbw.O00000o0(baz.O00000Oo, "EXT-X-STREAM-INF");
                }
            });
            this.O00000Oo.put("SUBTITLES", new bba<bcr.O000000o>() {
                /* class _m_j.bbq.AnonymousClass4.AnonymousClass2 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    ((bcr.O000000o) obj).O0000OOo = bbw.O00000o0(baz.O00000Oo, "EXT-X-STREAM-INF");
                }
            });
            this.O00000Oo.put("CLOSED-CAPTIONS", new bba<bcr.O000000o>() {
                /* class _m_j.bbq.AnonymousClass4.AnonymousClass3 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    bcr.O000000o o000000o = (bcr.O000000o) obj;
                    if (!baz.O00000Oo.equals("NONE")) {
                        o000000o.O0000Oo0 = bbw.O00000o0(baz.O00000Oo, "EXT-X-STREAM-INF");
                    }
                }
            });
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            this.f12783O000000o.O000000o(str, bbv);
            bcr.O000000o o000000o = new bcr.O000000o();
            bbw.O000000o(str, o000000o, bbv, this.O00000Oo, "EXT-X-STREAM-INF");
            bbv.O00000Oo.O00000oO = new bcr(o000000o.f12870O000000o, o000000o.O00000Oo, o000000o.O00000o0, o000000o.O00000o, o000000o.O00000oO, o000000o.O00000oo, o000000o.O0000O0o, o000000o.O0000OOo, o000000o.O0000Oo0, (byte) 0);
        }
    };
    private final bbi O00000o;
    private final bbl O00000oO;

    bbq(bbi bbi) {
        this(bbi, new bbe(bbi));
    }

    private bbq(bbi bbi, bbl bbl) {
        this.O00000o = bbi;
        this.O00000oO = bbl;
    }

    public final void O000000o(String str, bbv bbv) throws ParseException {
        if (bbv.O00000Oo()) {
            throw ParseException.O000000o(ParseExceptionType.MASTER_IN_MEDIA, this.O00000o.O000000o());
        } else if (!bbv.O00000Oo()) {
            if (bbv.O00000Oo == null) {
                bbv.O00000Oo = new bbp();
            }
            this.O00000oO.O000000o(str, bbv);
        } else {
            throw new ParseException(ParseExceptionType.MASTER_IN_MEDIA);
        }
    }

    static <T extends bcs> Map<String, bba<T>> O000000o(final String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("BANDWIDTH", new bba<T>() {
            /* class _m_j.bbq.AnonymousClass5 */

            public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                ((bcs) obj).O00000Oo(bbw.O000000o(baz.O00000Oo, str));
            }
        });
        hashMap.put("AVERAGE-BANDWIDTH", new bba<T>() {
            /* class _m_j.bbq.AnonymousClass6 */

            public final /* bridge */ /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                ((bcs) obj).O000000o(bbw.O000000o(baz.O00000Oo, str));
            }
        });
        hashMap.put("CODECS", new bba<T>() {
            /* class _m_j.bbq.AnonymousClass7 */

            public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                bcs bcs = (bcs) obj;
                String[] split = bbw.O00000o0(baz.O00000Oo, str).split(bbd.f12761O000000o);
                if (split.length > 0) {
                    bcs.O000000o(Arrays.asList(split));
                }
            }
        });
        hashMap.put("RESOLUTION", new bba<T>() {
            /* class _m_j.bbq.AnonymousClass8 */

            public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                bcs bcs = (bcs) obj;
                String str = baz.O00000Oo;
                String str2 = str;
                Matcher matcher = bbd.O00000o.matcher(str);
                if (matcher.matches()) {
                    bcs.O000000o(new bcp(bbw.O000000o(matcher.group(1), str2), bbw.O000000o(matcher.group(2), str2)));
                    return;
                }
                throw new ParseException(ParseExceptionType.INVALID_RESOLUTION_FORMAT, str2);
            }
        });
        hashMap.put("FRAME-RATE", new bba<T>() {
            /* class _m_j.bbq.AnonymousClass9 */

            public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                ((bcs) obj).O000000o(bbw.O00000Oo(baz.O00000Oo, str));
            }
        });
        hashMap.put("VIDEO", new bba<T>() {
            /* class _m_j.bbq.AnonymousClass10 */

            public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                ((bcs) obj).O000000o(bbw.O00000o0(baz.O00000Oo, str));
            }
        });
        hashMap.put("PROGRAM-ID", new bba<T>() {
            /* class _m_j.bbq.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
            }
        });
        return hashMap;
    }
}
