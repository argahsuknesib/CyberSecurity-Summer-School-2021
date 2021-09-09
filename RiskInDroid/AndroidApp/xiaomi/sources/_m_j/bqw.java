package _m_j;

import _m_j.bra;
import com.lidroid.xutils.http.client.multipart.HttpMultipartMode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;

final class bqw {
    private static final ByteArrayBuffer O00000o = O000000o(bqx.f13208O000000o, "\r\n");
    private static final ByteArrayBuffer O00000o0 = O000000o(bqx.f13208O000000o, ": ");
    private static final ByteArrayBuffer O00000oO = O000000o(bqx.f13208O000000o, "--");
    private static /* synthetic */ int[] O0000Oo0;

    /* renamed from: O000000o  reason: collision with root package name */
    final List<bqv> f13207O000000o;
    final HttpMultipartMode O00000Oo;
    private String O00000oo;
    private final Charset O0000O0o;
    private final String O0000OOo;

    /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|5|6|7|8|10) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    private static /* synthetic */ int[] O00000Oo() {
        int[] iArr = O0000Oo0;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[HttpMultipartMode.values().length];
        iArr2[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 2;
        iArr2[HttpMultipartMode.STRICT.ordinal()] = 1;
        O0000Oo0 = iArr2;
        return iArr2;
    }

    private static ByteArrayBuffer O000000o(Charset charset, String str) {
        ByteBuffer encode = charset.encode(CharBuffer.wrap(str));
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(encode.remaining());
        byteArrayBuffer.append(encode.array(), encode.position(), encode.remaining());
        return byteArrayBuffer;
    }

    private static void O000000o(ByteArrayBuffer byteArrayBuffer, OutputStream outputStream) throws IOException {
        outputStream.write(byteArrayBuffer.buffer(), 0, byteArrayBuffer.length());
        outputStream.flush();
    }

    private static void O000000o(String str, Charset charset, OutputStream outputStream) throws IOException {
        O000000o(O000000o(charset, str), outputStream);
    }

    private static void O000000o(String str, OutputStream outputStream) throws IOException {
        O000000o(O000000o(bqx.f13208O000000o, str), outputStream);
    }

    public bqw(String str, Charset charset, String str2, HttpMultipartMode httpMultipartMode) {
        if (str == null) {
            throw new IllegalArgumentException("Multipart subtype may not be null");
        } else if (str2 != null) {
            this.O00000oo = str;
            this.O0000O0o = charset == null ? bqx.f13208O000000o : charset;
            this.O0000OOo = str2;
            this.f13207O000000o = new ArrayList();
            this.O00000Oo = httpMultipartMode;
        } else {
            throw new IllegalArgumentException("Multipart boundary may not be null");
        }
    }

    private void O000000o(HttpMultipartMode httpMultipartMode, OutputStream outputStream) throws IOException {
        O000000o(httpMultipartMode, outputStream, bra.O000000o.f13213O000000o, false);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(HttpMultipartMode httpMultipartMode, OutputStream outputStream, bra.O000000o o000000o, boolean z) throws IOException {
        o000000o.O00000o = 0;
        ByteArrayBuffer O000000o2 = O000000o(this.O0000O0o, this.O0000OOo);
        for (bqv next : this.f13207O000000o) {
            if (o000000o.O000000o(true)) {
                O000000o(O00000oO, outputStream);
                o000000o.O00000o += (long) O00000oO.length();
                O000000o(O000000o2, outputStream);
                o000000o.O00000o += (long) O000000o2.length();
                O000000o(O00000o, outputStream);
                o000000o.O00000o += (long) O00000o.length();
                bqz bqz = next.f13206O000000o;
                int i = O00000Oo()[httpMultipartMode.ordinal()];
                if (i == 1) {
                    Iterator<bqy> it = bqz.iterator();
                    while (it.hasNext()) {
                        bqy next2 = it.next();
                        O000000o(next2, outputStream);
                        o000000o.O00000o = o000000o.O00000o + ((long) (O000000o(bqx.f13208O000000o, String.valueOf(next2.f13209O000000o) + next2.O00000Oo).length() + O00000o0.length() + O00000o.length()));
                    }
                } else if (i == 2) {
                    bqy O000000o3 = bqz.O000000o("Content-Disposition");
                    O000000o(O000000o3, this.O0000O0o, outputStream);
                    o000000o.O00000o = o000000o.O00000o + ((long) (O000000o(this.O0000O0o, String.valueOf(O000000o3.f13209O000000o) + O000000o3.O00000Oo).length() + O00000o0.length() + O00000o.length()));
                }
                O000000o(O00000o, outputStream);
                o000000o.O00000o += (long) O00000o.length();
                if (z) {
                    brc brc = next.O00000Oo;
                    brc.O000000o(o000000o);
                    brc.O000000o(outputStream);
                }
                O000000o(O00000o, outputStream);
                o000000o.O00000o += (long) O00000o.length();
            } else {
                throw new InterruptedIOException("cancel");
            }
        }
        O000000o(O00000oO, outputStream);
        o000000o.O00000o += (long) O00000oO.length();
        O000000o(O000000o2, outputStream);
        o000000o.O00000o += (long) O000000o2.length();
        O000000o(O00000oO, outputStream);
        o000000o.O00000o += (long) O00000oO.length();
        O000000o(O00000o, outputStream);
        o000000o.O00000o += (long) O00000o.length();
        o000000o.O000000o(true);
    }

    public final long O000000o() {
        long j = 0;
        for (bqv bqv : this.f13207O000000o) {
            long O00000o2 = bqv.O00000Oo.O00000o();
            if (O00000o2 < 0) {
                return -1;
            }
            j += O00000o2;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            O000000o(this.O00000Oo, byteArrayOutputStream);
            return j + ((long) byteArrayOutputStream.toByteArray().length);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static void O000000o(bqy bqy, OutputStream outputStream) throws IOException {
        O000000o(bqy.f13209O000000o, outputStream);
        O000000o(O00000o0, outputStream);
        O000000o(bqy.O00000Oo, outputStream);
        O000000o(O00000o, outputStream);
    }

    private static void O000000o(bqy bqy, Charset charset, OutputStream outputStream) throws IOException {
        O000000o(bqy.f13209O000000o, charset, outputStream);
        O000000o(O00000o0, outputStream);
        O000000o(bqy.O00000Oo, charset, outputStream);
        O000000o(O00000o, outputStream);
    }
}
