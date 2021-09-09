package org.apache.commons.compress.archivers.dump;

public class ShortFileException extends DumpArchiveException {
    private static final long serialVersionUID = 1;

    public ShortFileException() {
        super("unexpected EOF");
    }
}
