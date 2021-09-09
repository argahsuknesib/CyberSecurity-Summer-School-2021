package _m_j;

import _m_j.bch;
import _m_j.bcq;
import com.iheartradio.m3u8.ParseException;
import com.iheartradio.m3u8.ParseExceptionType;
import com.iheartradio.m3u8.data.EncryptionMethod;
import com.iheartradio.m3u8.data.PlaylistType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;

final class bbt implements bbl {

    /* renamed from: O000000o  reason: collision with root package name */
    static final bbi f12815O000000o = new bbi() {
        /* class _m_j.bbt.AnonymousClass1 */

        /* renamed from: O000000o  reason: collision with root package name */
        private final bbl f12816O000000o = new bbt(this);

        public final String O000000o() {
            return "EXT-X-ENDLIST";
        }

        public final boolean O00000Oo() {
            return false;
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            this.f12816O000000o.O000000o(str, bbv);
            bbw.O000000o(bbd.O0000Ooo, str, "EXT-X-ENDLIST");
            bbv.O00000o0.O0000OoO = true;
        }
    };
    static final bbi O00000Oo = new bbi() {
        /* class _m_j.bbt.AnonymousClass4 */

        /* renamed from: O000000o  reason: collision with root package name */
        private final bbl f12826O000000o = new bbt(this);

        public final String O000000o() {
            return "EXT-X-I-FRAMES-ONLY";
        }

        public final boolean O00000Oo() {
            return false;
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            this.f12826O000000o.O000000o(str, bbv);
            bbw.O000000o(bbd.O0000o00, str, "EXT-X-I-FRAMES-ONLY");
            if (bbv.O00000oO < 4) {
                throw ParseException.O000000o(ParseExceptionType.REQUIRES_PROTOCOL_VERSION_4_OR_HIGHER, "EXT-X-I-FRAMES-ONLY");
            } else if (!bbv.O000000o()) {
                bbv.O00000o0.O00000oO = Boolean.TRUE;
            } else {
                throw new ParseException(ParseExceptionType.MEDIA_IN_MASTER);
            }
        }
    };
    static final bbi O00000o = new bbi() {
        /* class _m_j.bbt.AnonymousClass6 */

        /* renamed from: O000000o  reason: collision with root package name */
        private final bbl f12828O000000o = new bbt(this);

        public final String O000000o() {
            return "EXT-X-PROGRAM-DATE-TIME";
        }

        public final boolean O00000Oo() {
            return true;
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            this.f12828O000000o.O000000o(str, bbv);
            bbw.O000000o(bbd.O0000Oo0, str, "EXT-X-PROGRAM-DATE-TIME");
            if (bbv.O00000o0.O0000Oo == null) {
                bbs bbs = bbv.O00000o0;
                Matcher matcher = bbd.O0000Oo0.matcher(str);
                if (matcher.matches()) {
                    bbs.O0000Oo = matcher.group(1);
                    return;
                }
                throw new ParseException(ParseExceptionType.INVALID_DATE_TIME_FORMAT, "EXT-X-PROGRAM-DATE-TIME");
            }
            throw ParseException.O000000o(ParseExceptionType.MULTIPLE_EXT_TAG_INSTANCES, "EXT-X-PROGRAM-DATE-TIME", str);
        }
    };
    static final bbi O00000o0 = new bbi() {
        /* class _m_j.bbt.AnonymousClass5 */

        /* renamed from: O000000o  reason: collision with root package name */
        private final bbl f12827O000000o = new bbt(this);

        public final String O000000o() {
            return "EXT-X-PLAYLIST-TYPE";
        }

        public final boolean O00000Oo() {
            return true;
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            this.f12827O000000o.O000000o(str, bbv);
            Matcher O000000o2 = bbw.O000000o(bbd.O0000OOo, str, "EXT-X-PLAYLIST-TYPE");
            if (bbv.O00000o0.O00000oo == null) {
                bbv.O00000o0.O00000oo = (PlaylistType) bbw.O000000o(O000000o2.group(1), PlaylistType.class, "EXT-X-PLAYLIST-TYPE");
                return;
            }
            throw ParseException.O000000o(ParseExceptionType.MULTIPLE_EXT_TAG_INSTANCES, "EXT-X-PLAYLIST-TYPE", str);
        }
    };
    static final bbi O00000oO = new bbi() {
        /* class _m_j.bbt.AnonymousClass7 */

        /* renamed from: O000000o  reason: collision with root package name */
        private final bbl f12829O000000o = new bbt(this);
        private final Map<String, bba<bcq.O000000o>> O00000Oo = new HashMap();

        public final String O000000o() {
            return "EXT-X-START";
        }

        public final boolean O00000Oo() {
            return true;
        }

        {
            this.O00000Oo.put("TIME-OFFSET", new bba<bcq.O000000o>() {
                /* class _m_j.bbt.AnonymousClass7.AnonymousClass1 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    ((bcq.O000000o) obj).f12868O000000o = bbw.O00000Oo(baz.O00000Oo, "EXT-X-START");
                }
            });
            this.O00000Oo.put("PRECISE", new bba<bcq.O000000o>() {
                /* class _m_j.bbt.AnonymousClass7.AnonymousClass2 */

                public final /* bridge */ /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    ((bcq.O000000o) obj).O00000Oo = bbw.O000000o(baz, "EXT-X-START");
                }
            });
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            this.f12829O000000o.O000000o(str, bbv);
            bcq.O000000o o000000o = new bcq.O000000o();
            bbw.O000000o(str, o000000o, bbv, this.O00000Oo, "EXT-X-START");
            bbv.O00000o0.O0000Oo0 = new bcq(o000000o.f12868O000000o, o000000o.O00000Oo);
        }
    };
    static final bbi O00000oo = new bbi() {
        /* class _m_j.bbt.AnonymousClass8 */

        /* renamed from: O000000o  reason: collision with root package name */
        private final bbl f12832O000000o = new bbt(this);

        public final String O000000o() {
            return "EXT-X-TARGETDURATION";
        }

        public final boolean O00000Oo() {
            return true;
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            this.f12832O000000o.O000000o(str, bbv);
            Matcher O000000o2 = bbw.O000000o(bbd.O00000oo, str, "EXT-X-TARGETDURATION");
            if (bbv.O00000o0.O00000o0 == null) {
                bbv.O00000o0.O00000o0 = Integer.valueOf(bbw.O000000o(O000000o2.group(1), "EXT-X-TARGETDURATION"));
                return;
            }
            throw ParseException.O000000o(ParseExceptionType.MULTIPLE_EXT_TAG_INSTANCES, "EXT-X-TARGETDURATION", str);
        }
    };
    static final bbi O0000O0o = new bbi() {
        /* class _m_j.bbt.AnonymousClass9 */

        /* renamed from: O000000o  reason: collision with root package name */
        private final bbl f12833O000000o = new bbt(this);

        public final String O000000o() {
            return "EXT-X-MEDIA-SEQUENCE";
        }

        public final boolean O00000Oo() {
            return true;
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            this.f12833O000000o.O000000o(str, bbv);
            Matcher O000000o2 = bbw.O000000o(bbd.O0000O0o, str, "EXT-X-MEDIA-SEQUENCE");
            if (bbv.O00000o0.O00000o == null) {
                bbv.O00000o0.O00000o = Integer.valueOf(bbw.O000000o(O000000o2.group(1), "EXT-X-MEDIA-SEQUENCE"));
                return;
            }
            throw ParseException.O000000o(ParseExceptionType.MULTIPLE_EXT_TAG_INSTANCES, "EXT-X-MEDIA-SEQUENCE", str);
        }
    };
    static final bbi O0000OOo = new bbi() {
        /* class _m_j.bbt.AnonymousClass10 */

        /* renamed from: O000000o  reason: collision with root package name */
        private final bbl f12817O000000o = new bbt(this);

        public final String O000000o() {
            return "EXT-X-ALLOW-CACHE";
        }

        public final boolean O00000Oo() {
            return true;
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            this.f12817O000000o.O000000o(str, bbv);
        }
    };
    static final bbi O0000Oo = new bbi() {
        /* class _m_j.bbt.AnonymousClass2 */

        /* renamed from: O000000o  reason: collision with root package name */
        private final bbl f12819O000000o = new bbt(this);

        public final String O000000o() {
            return "EXT-X-DISCONTINUITY";
        }

        public final boolean O00000Oo() {
            return false;
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            this.f12819O000000o.O000000o(str, bbv);
            bbw.O000000o(bbd.O0000o0, str, "EXT-X-DISCONTINUITY");
            bbv.O00000o0.O0000Ooo = true;
        }
    };
    static final bbi O0000Oo0 = new bbi() {
        /* class _m_j.bbt.AnonymousClass11 */

        /* renamed from: O000000o  reason: collision with root package name */
        private final bbl f12818O000000o = new bbt(this);

        public final String O000000o() {
            return "EXTINF";
        }

        public final boolean O00000Oo() {
            return true;
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            this.f12818O000000o.O000000o(str, bbv);
            Matcher O000000o2 = bbw.O000000o(bbd.O0000OoO, str, "EXTINF");
            bbv.O00000o0.O0000O0o = new bcu(bbw.O00000Oo(O000000o2.group(1), "EXTINF"), O000000o2.group(2));
        }
    };
    static final bbi O0000OoO = new bbi() {
        /* class _m_j.bbt.AnonymousClass3 */

        /* renamed from: O000000o  reason: collision with root package name */
        private final bbl f12820O000000o = new bbt(this);
        private final Map<String, bba<bch.O000000o>> O00000Oo = new HashMap();

        public final String O000000o() {
            return "EXT-X-KEY";
        }

        public final boolean O00000Oo() {
            return true;
        }

        {
            this.O00000Oo.put("METHOD", new bba<bch.O000000o>() {
                /* class _m_j.bbt.AnonymousClass3.AnonymousClass1 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    bch.O000000o o000000o = (bch.O000000o) obj;
                    EncryptionMethod fromValue = EncryptionMethod.fromValue(baz.O00000Oo);
                    if (fromValue != null) {
                        o000000o.f12853O000000o = fromValue;
                        return;
                    }
                    throw ParseException.O000000o(ParseExceptionType.INVALID_ENCRYPTION_METHOD, "EXT-X-KEY", baz.toString());
                }
            });
            this.O00000Oo.put("URI", new bba<bch.O000000o>() {
                /* class _m_j.bbt.AnonymousClass3.AnonymousClass2 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    ((bch.O000000o) obj).O00000Oo = bbw.O000000o(bbw.O00000o0(baz.O00000Oo, "EXT-X-KEY"), bbv.f12841O000000o);
                }
            });
            this.O00000Oo.put("IV", new bba<bch.O000000o>() {
                /* class _m_j.bbt.AnonymousClass3.AnonymousClass3 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    bch.O000000o o000000o = (bch.O000000o) obj;
                    String str = baz.O00000Oo;
                    ArrayList arrayList = new ArrayList();
                    Matcher matcher = bbd.O00000o0.matcher(str.toUpperCase(Locale.US));
                    if (matcher.matches()) {
                        char[] charArray = matcher.group(1).toCharArray();
                        int length = charArray.length;
                        for (int i = 0; i < length; i++) {
                            char c = charArray[i];
                            arrayList.add(Byte.valueOf((byte) (c >= 'A' ? (c & 15) + 9 : c & 15)));
                        }
                        if (arrayList.size() == 16 || arrayList.size() == 32) {
                            o000000o.O00000o0 = arrayList;
                            return;
                        }
                        throw ParseException.O000000o(ParseExceptionType.INVALID_IV_SIZE, "EXT-X-KEY", baz.toString());
                    }
                    throw ParseException.O000000o(ParseExceptionType.INVALID_HEXADECIMAL_STRING, "EXT-X-KEY", str);
                }
            });
            this.O00000Oo.put("KEYFORMAT", new bba<bch.O000000o>() {
                /* class _m_j.bbt.AnonymousClass3.AnonymousClass4 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    ((bch.O000000o) obj).O00000o = bbw.O00000o0(baz.O00000Oo, "EXT-X-KEY");
                }
            });
            this.O00000Oo.put("KEYFORMATVERSIONS", new bba<bch.O000000o>() {
                /* class _m_j.bbt.AnonymousClass3.AnonymousClass5 */

                public final /* synthetic */ void O000000o(baz baz, Object obj, bbv bbv) throws ParseException {
                    bch.O000000o o000000o = (bch.O000000o) obj;
                    String[] split = bbw.O00000o0(baz.O00000Oo, "EXT-X-KEY").split("/");
                    ArrayList arrayList = new ArrayList();
                    int length = split.length;
                    int i = 0;
                    while (i < length) {
                        try {
                            arrayList.add(Integer.valueOf(Integer.parseInt(split[i])));
                            i++;
                        } catch (NumberFormatException unused) {
                            throw ParseException.O000000o(ParseExceptionType.INVALID_KEY_FORMAT_VERSIONS, "EXT-X-KEY", baz.toString());
                        }
                    }
                    o000000o.O00000oO = arrayList;
                }
            });
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            this.f12820O000000o.O000000o(str, bbv);
            bch.O000000o o000000o = new bch.O000000o();
            o000000o.O00000o = "identity";
            o000000o.O00000oO = bbd.O0000o0o;
            bbw.O000000o(str, o000000o, bbv, this.O00000Oo, "EXT-X-KEY");
            bch bch = new bch(o000000o.f12853O000000o, o000000o.O00000Oo, o000000o.O00000o0, o000000o.O00000o, o000000o.O00000oO, (byte) 0);
            if (bch.f12852O000000o == EncryptionMethod.NONE || bch.O00000Oo != null) {
                bbv.O00000o0.O0000OOo = bch;
                return;
            }
            throw ParseException.O000000o(ParseExceptionType.MISSING_ENCRYPTION_URI, "EXT-X-KEY", str);
        }
    };
    private final bbi O0000Ooo;
    private final bbl O0000o00;

    bbt(bbi bbi) {
        this(bbi, new bbe(bbi));
    }

    private bbt(bbi bbi, bbl bbl) {
        this.O0000Ooo = bbi;
        this.O0000o00 = bbl;
    }

    public final void O000000o(String str, bbv bbv) throws ParseException {
        if (!bbv.O000000o()) {
            bbv.O00000o0();
            this.O0000o00.O000000o(str, bbv);
            return;
        }
        throw ParseException.O000000o(ParseExceptionType.MEDIA_IN_MASTER, this.O0000Ooo.O000000o());
    }
}
