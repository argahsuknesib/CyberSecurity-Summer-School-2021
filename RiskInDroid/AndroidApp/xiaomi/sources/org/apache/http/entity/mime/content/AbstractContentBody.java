package org.apache.http.entity.mime.content;

public abstract class AbstractContentBody implements ContentBody {
    private final String mediaType;
    private final String mimeType;
    private final String subType;

    public AbstractContentBody(String str) {
        if (str != null) {
            this.mimeType = str;
            int indexOf = str.indexOf(47);
            if (indexOf != -1) {
                this.mediaType = str.substring(0, indexOf);
                this.subType = str.substring(indexOf + 1);
                return;
            }
            this.mediaType = str;
            this.subType = null;
            return;
        }
        throw new IllegalArgumentException("MIME type may not be null");
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public String getSubType() {
        return this.subType;
    }
}
