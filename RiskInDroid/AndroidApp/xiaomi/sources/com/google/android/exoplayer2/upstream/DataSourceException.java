package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public final class DataSourceException extends IOException {
    public final int reason;

    public DataSourceException(int i) {
        this.reason = i;
    }
}
