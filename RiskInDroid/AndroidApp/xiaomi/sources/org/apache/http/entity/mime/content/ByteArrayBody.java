package org.apache.http.entity.mime.content;

import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayBody extends AbstractContentBody {
    private final byte[] data;
    private final String filename;

    public String getCharset() {
        return null;
    }

    public String getTransferEncoding() {
        return "binary";
    }

    public ByteArrayBody(byte[] bArr, String str, String str2) {
        super(str);
        if (bArr != null) {
            this.data = bArr;
            this.filename = str2;
            return;
        }
        throw new IllegalArgumentException("byte[] may not be null");
    }

    public ByteArrayBody(byte[] bArr, String str) {
        this(bArr, "application/octet-stream", str);
    }

    public String getFilename() {
        return this.filename;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.data);
    }

    public long getContentLength() {
        return (long) this.data.length;
    }
}
