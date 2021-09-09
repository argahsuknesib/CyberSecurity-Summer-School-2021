package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.upstream.DataReader;
import java.io.IOException;

interface ProgressiveMediaExtractor {
    void disableSeekingOnMp3Streams();

    long getCurrentInputPosition();

    void init(DataReader dataReader, Uri uri, long j, long j2, ExtractorOutput extractorOutput) throws IOException;

    int read(PositionHolder positionHolder) throws IOException;

    void release();

    void seek(long j, long j2);
}
