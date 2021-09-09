package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;

final class BundledExtractorsAdapter implements ProgressiveMediaExtractor {
    private Extractor extractor;
    private ExtractorInput extractorInput;
    private final Extractor[] extractors;

    public BundledExtractorsAdapter(Extractor[] extractorArr) {
        this.extractors = extractorArr;
    }

    public final void init(DataReader dataReader, Uri uri, long j, long j2, ExtractorOutput extractorOutput) throws IOException {
        this.extractorInput = new DefaultExtractorInput(dataReader, j, j2);
        if (this.extractor == null) {
            Extractor[] extractorArr = this.extractors;
            int i = 0;
            if (extractorArr.length == 1) {
                this.extractor = extractorArr[0];
            } else {
                int length = extractorArr.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Extractor extractor2 = extractorArr[i];
                    try {
                        if (extractor2.sniff(this.extractorInput)) {
                            this.extractor = extractor2;
                            this.extractorInput.resetPeekPosition();
                            break;
                        }
                        this.extractorInput.resetPeekPosition();
                        i++;
                    } catch (EOFException unused) {
                    } catch (Throwable th) {
                        this.extractorInput.resetPeekPosition();
                        throw th;
                    }
                }
                if (this.extractor == null) {
                    throw new UnrecognizedInputFormatException("None of the available extractors (" + Util.getCommaDelimitedSimpleClassNames(this.extractors) + ") could read the stream.", (Uri) Assertions.checkNotNull(uri));
                }
            }
            this.extractor.init(extractorOutput);
        }
    }

    public final void release() {
        Extractor extractor2 = this.extractor;
        if (extractor2 != null) {
            extractor2.release();
            this.extractor = null;
        }
        this.extractorInput = null;
    }

    public final void disableSeekingOnMp3Streams() {
        Extractor extractor2 = this.extractor;
        if (extractor2 instanceof Mp3Extractor) {
            ((Mp3Extractor) extractor2).disableSeeking();
        }
    }

    public final long getCurrentInputPosition() {
        ExtractorInput extractorInput2 = this.extractorInput;
        if (extractorInput2 != null) {
            return extractorInput2.getPosition();
        }
        return -1;
    }

    public final void seek(long j, long j2) {
        ((Extractor) Assertions.checkNotNull(this.extractor)).seek(j, j2);
    }

    public final int read(PositionHolder positionHolder) throws IOException {
        return ((Extractor) Assertions.checkNotNull(this.extractor)).read((ExtractorInput) Assertions.checkNotNull(this.extractorInput), positionHolder);
    }
}
