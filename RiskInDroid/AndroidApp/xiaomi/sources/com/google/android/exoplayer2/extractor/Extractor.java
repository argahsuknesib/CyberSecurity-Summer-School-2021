package com.google.android.exoplayer2.extractor;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Extractor {

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ReadResult {
    }

    void init(ExtractorOutput extractorOutput);

    int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException;

    void release();

    void seek(long j, long j2);

    boolean sniff(ExtractorInput extractorInput) throws IOException;
}
