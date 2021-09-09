package pl.droidsonroids.gif;

import java.io.IOException;

public class GifIOException extends IOException {
    private static final long serialVersionUID = 13038402904505L;
    private final String mErrnoMessage;
    public final GifError reason;

    public String getMessage() {
        if (this.mErrnoMessage == null) {
            return this.reason.getFormattedDescription();
        }
        return this.reason.getFormattedDescription() + ": " + this.mErrnoMessage;
    }

    GifIOException(int i, String str) {
        this.reason = GifError.fromCode(i);
        this.mErrnoMessage = str;
    }

    static GifIOException O000000o(int i) {
        if (i == GifError.NO_ERROR.errorCode) {
            return null;
        }
        return new GifIOException(i, null);
    }
}
