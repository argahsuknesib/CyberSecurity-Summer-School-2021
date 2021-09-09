package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public interface LoaderErrorThrower {

    public static final class Dummy implements LoaderErrorThrower {
        public final void maybeThrowError() {
        }

        public final void maybeThrowError(int i) {
        }
    }

    void maybeThrowError() throws IOException;

    void maybeThrowError(int i) throws IOException;
}
