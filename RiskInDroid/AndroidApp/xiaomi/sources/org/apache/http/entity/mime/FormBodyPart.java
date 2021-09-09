package org.apache.http.entity.mime;

import _m_j.jdn;
import org.apache.http.entity.mime.content.ContentBody;

public class FormBodyPart {
    private final ContentBody body;
    private final Header header;
    private final String name;

    public FormBodyPart(String str, ContentBody contentBody) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        } else if (contentBody != null) {
            this.name = str;
            this.body = contentBody;
            this.header = new Header();
            generateContentDisp(contentBody);
            generateContentType(contentBody);
            generateTransferEncoding(contentBody);
        } else {
            throw new IllegalArgumentException("Body may not be null");
        }
    }

    public String getName() {
        return this.name;
    }

    public ContentBody getBody() {
        return this.body;
    }

    public Header getHeader() {
        return this.header;
    }

    public void addField(String str, String str2) {
        if (str != null) {
            this.header.addField(new MinimalField(str, str2));
            return;
        }
        throw new IllegalArgumentException("Field name may not be null");
    }

    /* access modifiers changed from: protected */
    public void generateContentDisp(ContentBody contentBody) {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(getName());
        sb.append(jdn.f1779O000000o);
        if (contentBody.getFilename() != null) {
            sb.append("; filename=\"");
            sb.append(contentBody.getFilename());
            sb.append(jdn.f1779O000000o);
        }
        addField("Content-Disposition", sb.toString());
    }

    /* access modifiers changed from: protected */
    public void generateContentType(ContentBody contentBody) {
        StringBuilder sb = new StringBuilder();
        sb.append(contentBody.getMimeType());
        if (contentBody.getCharset() != null) {
            sb.append("; charset=");
            sb.append(contentBody.getCharset());
        }
        addField("Content-Type", sb.toString());
    }

    /* access modifiers changed from: protected */
    public void generateTransferEncoding(ContentBody contentBody) {
        addField("Content-Transfer-Encoding", contentBody.getTransferEncoding());
    }
}
