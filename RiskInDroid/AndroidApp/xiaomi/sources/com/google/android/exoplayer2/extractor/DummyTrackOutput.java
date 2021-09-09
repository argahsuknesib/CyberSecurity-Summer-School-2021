package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;

public final class DummyTrackOutput implements TrackOutput {
    private final byte[] readBuffer = new byte[4096];

    public final void format(Format format) {
    }

    public final void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
    }

    public final int sampleData(DataReader dataReader, int i, boolean z) throws IOException {
        int read = dataReader.read(this.readBuffer, 0, Math.min(this.readBuffer.length, i));
        if (read != -1) {
            return read;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final void sampleData(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(i);
    }
}
