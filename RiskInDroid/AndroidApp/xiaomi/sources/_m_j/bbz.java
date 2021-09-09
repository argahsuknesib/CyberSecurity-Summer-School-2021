package _m_j;

import com.iheartradio.m3u8.Encoding;
import com.iheartradio.m3u8.Format;
import com.iheartradio.m3u8.ParseException;
import com.iheartradio.m3u8.PlaylistException;
import java.io.IOException;
import java.io.InputStream;

public final class bbz implements bbk {

    /* renamed from: O000000o  reason: collision with root package name */
    private final bbk f12844O000000o;

    public bbz(InputStream inputStream, Format format, Encoding encoding, bbx bbx) {
        if (format == null) {
            throw new IllegalArgumentException("format is null");
        } else if (encoding == null) {
            throw new IllegalArgumentException("encoding is null");
        } else if (bbx != null || format == Format.M3U) {
            int i = AnonymousClass1.f12845O000000o[format.ordinal()];
            if (i == 1) {
                this.f12844O000000o = new bbm(inputStream, encoding);
            } else if (i == 2) {
                this.f12844O000000o = new bbg(inputStream, encoding, bbx);
            } else {
                throw new RuntimeException("unsupported format detected, this should be impossible: ".concat(String.valueOf(format)));
            }
        } else {
            throw new IllegalArgumentException("parsingMode is null");
        }
    }

    /* renamed from: _m_j.bbz$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12845O000000o = new int[Format.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f12845O000000o[Format.M3U.ordinal()] = 1;
            f12845O000000o[Format.EXT_M3U.ordinal()] = 2;
        }
    }

    public final bcn O00000Oo() throws IOException, ParseException, PlaylistException {
        return this.f12844O000000o.O00000Oo();
    }
}
