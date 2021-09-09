package org.apache.commons.compress.archivers;

public class StreamingNotSupportedException extends ArchiveException {
    private static final long serialVersionUID = 1;
    private final String format;

    public StreamingNotSupportedException(String str) {
        super("The " + str + " doesn't support streaming.");
        this.format = str;
    }

    public String getFormat() {
        return this.format;
    }
}
