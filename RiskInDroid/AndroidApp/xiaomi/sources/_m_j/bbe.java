package _m_j;

import com.iheartradio.m3u8.ParseException;
import com.iheartradio.m3u8.ParseExceptionType;
import java.util.regex.Matcher;

final class bbe implements bbl {

    /* renamed from: O000000o  reason: collision with root package name */
    static final bbi f12762O000000o = new bbi() {
        /* class _m_j.bbe.AnonymousClass1 */

        public final String O000000o() {
            return "EXTM3U";
        }

        public final boolean O00000Oo() {
            return false;
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            if (!bbv.O00000o) {
                bbv.O00000o = true;
                return;
            }
            throw ParseException.O000000o(ParseExceptionType.MULTIPLE_EXT_TAG_INSTANCES, "EXTM3U", str);
        }
    };
    static final bbi O00000Oo = new bbi() {
        /* class _m_j.bbe.AnonymousClass2 */

        public final String O000000o() {
            return null;
        }

        public final boolean O00000Oo() {
            return false;
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            if (bbv.O000000o()) {
                bbv.O00000Oo.O00000o.add(str);
            } else if (bbv.O00000Oo()) {
                bbv.O00000o0.O00000Oo.add(str);
            }
        }
    };
    static final bbi O00000o0 = new bbi() {
        /* class _m_j.bbe.AnonymousClass3 */

        /* renamed from: O000000o  reason: collision with root package name */
        private final bbe f12763O000000o = new bbe(this);

        public final String O000000o() {
            return "EXT-X-VERSION";
        }

        public final boolean O00000Oo() {
            return true;
        }

        public final void O000000o(String str, bbv bbv) throws ParseException {
            this.f12763O000000o.O000000o(str, bbv);
            Matcher O000000o2 = bbw.O000000o(bbd.O00000oO, str, "EXT-X-VERSION");
            if (bbv.O00000oO == -1) {
                int O000000o3 = bbw.O000000o(O000000o2.group(1), "EXT-X-VERSION");
                if (O000000o3 <= 0) {
                    throw ParseException.O000000o(ParseExceptionType.INVALID_COMPATIBILITY_VERSION, "EXT-X-VERSION", str);
                } else if (O000000o3 <= 5) {
                    bbv.O00000oO = O000000o3;
                } else {
                    throw ParseException.O000000o(ParseExceptionType.UNSUPPORTED_COMPATIBILITY_VERSION, "EXT-X-VERSION", str);
                }
            } else {
                throw ParseException.O000000o(ParseExceptionType.MULTIPLE_EXT_TAG_INSTANCES, "EXT-X-VERSION", str);
            }
        }
    };
    private final bbi O00000o;

    bbe(bbi bbi) {
        this.O00000o = bbi;
    }

    public final void O000000o(String str, bbv bbv) throws ParseException {
        if (this.O00000o.O00000Oo() && str.indexOf(":") != this.O00000o.O000000o().length() + 1) {
            throw ParseException.O000000o(ParseExceptionType.MISSING_EXT_TAG_SEPARATOR, this.O00000o.O000000o(), str);
        }
    }
}
