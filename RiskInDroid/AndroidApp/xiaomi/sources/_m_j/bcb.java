package _m_j;

import com.iheartradio.m3u8.Encoding;
import com.iheartradio.m3u8.Format;
import com.iheartradio.m3u8.ParseException;
import com.iheartradio.m3u8.PlaylistException;
import java.io.IOException;
import java.io.OutputStream;

public final class bcb {

    /* renamed from: O000000o  reason: collision with root package name */
    private final bcf f12848O000000o;
    private final OutputStream O00000Oo;
    private boolean O00000o;
    private final boolean O00000o0;

    public bcb(OutputStream outputStream, Format format, Encoding encoding) {
        this(outputStream, format, encoding, (byte) 0);
    }

    private bcb(OutputStream outputStream, Format format, Encoding encoding, byte b) {
        this.O00000o = true;
        if (outputStream == null) {
            throw new IllegalArgumentException("outputStream is null");
        } else if (format == null) {
            throw new IllegalArgumentException("format is null");
        } else if (encoding != null) {
            this.O00000Oo = outputStream;
            this.O00000o0 = false;
            int i = AnonymousClass1.f12849O000000o[format.ordinal()];
            if (i == 1) {
                this.f12848O000000o = new bbo(outputStream, encoding);
            } else if (i == 2) {
                this.f12848O000000o = new bbh(outputStream, encoding);
            } else {
                throw new RuntimeException("unsupported format detected, this should be impossible: ".concat(String.valueOf(format)));
            }
        } else {
            throw new IllegalArgumentException("encoding is null");
        }
    }

    /* renamed from: _m_j.bcb$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12849O000000o = new int[Format.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f12849O000000o[Format.M3U.ordinal()] = 1;
            f12849O000000o[Format.EXT_M3U.ordinal()] = 2;
        }
    }

    public final void O000000o(bcn bcn) throws IOException, ParseException, PlaylistException {
        bca O000000o2 = bca.O000000o(bcn, bbx.f12842O000000o);
        if (O000000o2.O000000o()) {
            if (this.O00000o0 && this.O00000o) {
                for (int write : bbd.O0000o0O) {
                    this.O00000Oo.write(write);
                }
            }
            bcf bcf = this.f12848O000000o;
            bcf.O000000o(bcn);
            bcf.f12851O000000o.f12850O000000o.flush();
            this.O00000o = false;
            return;
        }
        throw new PlaylistException("", O000000o2.f12847O000000o);
    }
}
