package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public interface DataReader {
    int read(byte[] bArr, int i, int i2) throws IOException;
}
