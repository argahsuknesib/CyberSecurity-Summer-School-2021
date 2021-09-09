package _m_j;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

abstract class bqs extends HttpEntityWrapper implements bqu {

    /* renamed from: O000000o  reason: collision with root package name */
    private InputStream f13205O000000o;
    private long O00000Oo;
    private bqn O00000o = null;
    private long O00000o0 = 0;

    /* access modifiers changed from: package-private */
    public abstract InputStream O000000o(InputStream inputStream) throws IOException;

    public long getContentLength() {
        return -1;
    }

    public bqs(HttpEntity httpEntity) {
        super(httpEntity);
        this.O00000Oo = httpEntity.getContentLength();
    }

    private InputStream O000000o() throws IOException {
        try {
            return O000000o(this.wrappedEntity.getContent());
        } catch (IOException e) {
            brl.O000000o((Closeable) null);
            throw e;
        }
    }

    public InputStream getContent() throws IOException {
        if (!this.wrappedEntity.isStreaming()) {
            return O000000o();
        }
        if (this.f13205O000000o == null) {
            this.f13205O000000o = O000000o();
        }
        return this.f13205O000000o;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            InputStream inputStream = null;
            try {
                inputStream = getContent();
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        outputStream.flush();
                        if (this.O00000o != null) {
                            this.O00000o.O000000o(this.O00000Oo, this.O00000o0, true);
                        }
                        return;
                    }
                    outputStream.write(bArr, 0, read);
                    this.O00000o0 += (long) read;
                    if (this.O00000o != null) {
                        if (!this.O00000o.O000000o(this.O00000Oo, this.O00000o0, false)) {
                            throw new InterruptedIOException("cancel");
                        }
                    }
                }
            } finally {
                brl.O000000o(inputStream);
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }

    public void O000000o(bqn bqn) {
        this.O00000o = bqn;
    }
}
