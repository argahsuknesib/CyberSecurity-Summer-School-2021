package _m_j;

import com.lidroid.xutils.http.client.multipart.HttpMultipartMode;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

public final class bra implements bqu, HttpEntity {
    private static final char[] O00000Oo = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f13212O000000o;
    private Header O00000o;
    private final bqw O00000o0;
    private long O00000oO;
    private volatile boolean O00000oo;
    private final String O0000O0o;
    private final Charset O0000OOo;
    private String O0000Oo0;

    public final Header getContentEncoding() {
        return null;
    }

    public final void O000000o(bqn bqn) {
        this.f13212O000000o.O00000Oo = bqn;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O000000o f13213O000000o = new O000000o();
        public bqn O00000Oo = null;
        public long O00000o = 0;
        public long O00000o0 = 0;

        public final boolean O000000o(boolean z) {
            bqn bqn = this.O00000Oo;
            if (bqn != null) {
                return bqn.O000000o(this.O00000o0, this.O00000o, z);
            }
            return true;
        }
    }

    public bra(HttpMultipartMode httpMultipartMode, Charset charset) {
        this.f13212O000000o = new O000000o();
        this.O0000Oo0 = "form-data";
        this.O0000O0o = O000000o();
        httpMultipartMode = httpMultipartMode == null ? HttpMultipartMode.STRICT : httpMultipartMode;
        this.O0000OOo = charset == null ? bqx.f13208O000000o : charset;
        this.O00000o0 = new bqw(this.O0000Oo0, this.O0000OOo, this.O0000O0o, httpMultipartMode);
        String str = this.O0000O0o;
        StringBuilder sb = new StringBuilder();
        sb.append("multipart/" + this.O0000Oo0 + "; boundary=");
        sb.append(str);
        this.O00000o = new BasicHeader("Content-Type", sb.toString());
        this.O00000oo = true;
    }

    public bra() {
        this(HttpMultipartMode.STRICT, null);
    }

    private static String O000000o() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int nextInt = random.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            char[] cArr = O00000Oo;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    private void O000000o(bqv bqv) {
        this.O00000o0.f13207O000000o.add(bqv);
        this.O00000oo = true;
    }

    public final void O000000o(String str, brc brc) {
        O000000o(new bqv(str, brc));
    }

    public final boolean isRepeatable() {
        for (bqv bqv : this.O00000o0.f13207O000000o) {
            if (bqv.O00000Oo.O00000o() < 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean isChunked() {
        return !isRepeatable();
    }

    public final boolean isStreaming() {
        return !isRepeatable();
    }

    public final long getContentLength() {
        if (this.O00000oo) {
            this.O00000oO = this.O00000o0.O000000o();
            this.O00000oo = false;
        }
        return this.O00000oO;
    }

    public final Header getContentType() {
        return this.O00000o;
    }

    public final void consumeContent() throws IOException, UnsupportedOperationException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public final InputStream getContent() throws IOException, UnsupportedOperationException {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        this.f13212O000000o.O00000o0 = getContentLength();
        bqw bqw = this.O00000o0;
        bqw.O000000o(bqw.O00000Oo, outputStream, this.f13212O000000o, true);
    }
}
