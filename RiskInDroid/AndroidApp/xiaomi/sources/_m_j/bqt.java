package _m_j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public final class bqt extends bqs {
    public final /* bridge */ /* synthetic */ void O000000o(bqn bqn) {
        super.O000000o(bqn);
    }

    public final /* bridge */ /* synthetic */ InputStream getContent() throws IOException {
        return super.getContent();
    }

    public final Header getContentEncoding() {
        return null;
    }

    public final /* bridge */ /* synthetic */ long getContentLength() {
        return super.getContentLength();
    }

    public final /* bridge */ /* synthetic */ void writeTo(OutputStream outputStream) throws IOException {
        super.writeTo(outputStream);
    }

    public bqt(HttpEntity httpEntity) {
        super(httpEntity);
    }

    /* access modifiers changed from: package-private */
    public final InputStream O000000o(InputStream inputStream) throws IOException {
        return new GZIPInputStream(inputStream);
    }
}
