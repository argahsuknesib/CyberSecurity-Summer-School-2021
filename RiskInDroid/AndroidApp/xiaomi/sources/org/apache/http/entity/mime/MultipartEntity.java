package org.apache.http.entity.mime;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.message.BasicHeader;

public class MultipartEntity implements HttpEntity {
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final Header contentType;
    private volatile boolean dirty;
    private long length;
    private final HttpMultipart multipart;

    public Header getContentEncoding() {
        return null;
    }

    public MultipartEntity(HttpMultipartMode httpMultipartMode, String str, Charset charset) {
        str = str == null ? generateBoundary() : str;
        this.multipart = new HttpMultipart("form-data", charset, str, httpMultipartMode == null ? HttpMultipartMode.STRICT : httpMultipartMode);
        this.contentType = new BasicHeader("Content-Type", generateContentType(str, charset));
        this.dirty = true;
    }

    public MultipartEntity(HttpMultipartMode httpMultipartMode) {
        this(httpMultipartMode, null, null);
    }

    public MultipartEntity() {
        this(HttpMultipartMode.STRICT, null, null);
    }

    /* access modifiers changed from: protected */
    public String generateContentType(String str, Charset charset) {
        StringBuilder sb = new StringBuilder();
        sb.append("multipart/form-data; boundary=");
        sb.append(str);
        if (charset != null) {
            sb.append("; charset=");
            sb.append(charset.name());
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String generateBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int nextInt = random.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            char[] cArr = MULTIPART_CHARS;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    public void addPart(FormBodyPart formBodyPart) {
        this.multipart.addBodyPart(formBodyPart);
        this.dirty = true;
    }

    public void addPart(String str, ContentBody contentBody) {
        addPart(new FormBodyPart(str, contentBody));
    }

    public boolean isRepeatable() {
        for (FormBodyPart body : this.multipart.getBodyParts()) {
            if (body.getBody().getContentLength() < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isChunked() {
        return !isRepeatable();
    }

    public boolean isStreaming() {
        return !isRepeatable();
    }

    public long getContentLength() {
        if (this.dirty) {
            this.length = this.multipart.getTotalLength();
            this.dirty = false;
        }
        return this.length;
    }

    public Header getContentType() {
        return this.contentType;
    }

    public void consumeContent() throws IOException, UnsupportedOperationException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public InputStream getContent() throws IOException, UnsupportedOperationException {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.multipart.writeTo(outputStream);
    }
}
