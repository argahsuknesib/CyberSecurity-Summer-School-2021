package org.apache.http.entity.mime.content;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamBody extends AbstractContentBody {
    private final String filename;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f15434in;

    public String getCharset() {
        return null;
    }

    public long getContentLength() {
        return -1;
    }

    public String getTransferEncoding() {
        return "binary";
    }

    public InputStreamBody(InputStream inputStream, String str, String str2) {
        super(str);
        if (inputStream != null) {
            this.f15434in = inputStream;
            this.filename = str2;
            return;
        }
        throw new IllegalArgumentException("Input stream may not be null");
    }

    public InputStreamBody(InputStream inputStream, String str) {
        this(inputStream, "application/octet-stream", str);
    }

    public InputStream getInputStream() {
        return this.f15434in;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = this.f15434in.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        return;
                    }
                }
            } finally {
                this.f15434in.close();
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }

    public String getFilename() {
        return this.filename;
    }
}
