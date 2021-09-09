package org.apache.commons.compress.archivers.dump;

import java.io.IOException;

public class DumpArchiveException extends IOException {
    private static final long serialVersionUID = 1;

    public DumpArchiveException() {
    }

    public DumpArchiveException(String str) {
        super(str);
    }

    public DumpArchiveException(Throwable th) {
        initCause(th);
    }

    public DumpArchiveException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
