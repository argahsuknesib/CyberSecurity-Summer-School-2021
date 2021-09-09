package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;

final class DefaultOggSeeker implements OggSeeker {
    private long end;
    private long endGranule;
    private final OggPageHeader pageHeader;
    public final long payloadEndPosition;
    public final long payloadStartPosition;
    private long positionBeforeSeekToEnd;
    private long start;
    private long startGranule;
    private int state;
    public final StreamReader streamReader;
    private long targetGranule;
    public long totalGranules;

    public DefaultOggSeeker(StreamReader streamReader2, long j, long j2, long j3, long j4, boolean z) {
        Assertions.checkArgument(j >= 0 && j2 > j);
        this.streamReader = streamReader2;
        this.payloadStartPosition = j;
        this.payloadEndPosition = j2;
        if (j3 == j2 - j || z) {
            this.totalGranules = j4;
            this.state = 4;
        } else {
            this.state = 0;
        }
        this.pageHeader = new OggPageHeader();
    }

    public final long read(ExtractorInput extractorInput) throws IOException {
        int i = this.state;
        if (i == 0) {
            this.positionBeforeSeekToEnd = extractorInput.getPosition();
            this.state = 1;
            long j = this.payloadEndPosition - 65307;
            if (j > this.positionBeforeSeekToEnd) {
                return j;
            }
        } else if (i != 1) {
            if (i == 2) {
                long nextSeekPosition = getNextSeekPosition(extractorInput);
                if (nextSeekPosition != -1) {
                    return nextSeekPosition;
                }
                this.state = 3;
            } else if (i != 3) {
                if (i == 4) {
                    return -1;
                }
                throw new IllegalStateException();
            }
            skipToPageOfTargetGranule(extractorInput);
            this.state = 4;
            return -(this.startGranule + 2);
        }
        this.totalGranules = readGranuleOfLastPage(extractorInput);
        this.state = 4;
        return this.positionBeforeSeekToEnd;
    }

    public final OggSeekMap createSeekMap() {
        if (this.totalGranules != 0) {
            return new OggSeekMap();
        }
        return null;
    }

    public final void startSeek(long j) {
        this.targetGranule = Util.constrainValue(j, 0, this.totalGranules - 1);
        this.state = 2;
        this.start = this.payloadStartPosition;
        this.end = this.payloadEndPosition;
        this.startGranule = 0;
        this.endGranule = this.totalGranules;
    }

    private long getNextSeekPosition(ExtractorInput extractorInput) throws IOException {
        if (this.start == this.end) {
            return -1;
        }
        long position = extractorInput.getPosition();
        if (!skipToNextPage(extractorInput, this.end)) {
            long j = this.start;
            if (j != position) {
                return j;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.pageHeader.populate(extractorInput, false);
        extractorInput.resetPeekPosition();
        long j2 = this.targetGranule - this.pageHeader.granulePosition;
        int i = this.pageHeader.headerSize + this.pageHeader.bodySize;
        if (0 <= j2 && j2 < 72000) {
            return -1;
        }
        if (j2 < 0) {
            this.end = position;
            this.endGranule = this.pageHeader.granulePosition;
        } else {
            this.start = extractorInput.getPosition() + ((long) i);
            this.startGranule = this.pageHeader.granulePosition;
        }
        long j3 = this.end;
        long j4 = this.start;
        if (j3 - j4 < 100000) {
            this.end = j4;
            return j4;
        }
        long position2 = extractorInput.getPosition() - (((long) i) * (j2 <= 0 ? 2 : 1));
        long j5 = this.end;
        long j6 = this.start;
        return Util.constrainValue(position2 + ((j2 * (j5 - j6)) / (this.endGranule - this.startGranule)), j6, j5 - 1);
    }

    private void skipToPageOfTargetGranule(ExtractorInput extractorInput) throws IOException {
        this.pageHeader.populate(extractorInput, false);
        while (this.pageHeader.granulePosition <= this.targetGranule) {
            extractorInput.skipFully(this.pageHeader.headerSize + this.pageHeader.bodySize);
            this.start = extractorInput.getPosition();
            this.startGranule = this.pageHeader.granulePosition;
            this.pageHeader.populate(extractorInput, false);
        }
        extractorInput.resetPeekPosition();
    }

    /* access modifiers changed from: package-private */
    public final void skipToNextPage(ExtractorInput extractorInput) throws IOException {
        if (!skipToNextPage(extractorInput, this.payloadEndPosition)) {
            throw new EOFException();
        }
    }

    private boolean skipToNextPage(ExtractorInput extractorInput, long j) throws IOException {
        int i;
        long min = Math.min(j + 3, this.payloadEndPosition);
        int i2 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            int i3 = 0;
            if (extractorInput.getPosition() + ((long) i2) <= min || (i2 = (int) (min - extractorInput.getPosition())) >= 4) {
                extractorInput.peekFully(bArr, 0, i2, false);
                while (true) {
                    i = i2 - 3;
                    if (i3 >= i) {
                        break;
                    } else if (bArr[i3] == 79 && bArr[i3 + 1] == 103 && bArr[i3 + 2] == 103 && bArr[i3 + 3] == 83) {
                        extractorInput.skipFully(i3);
                        return true;
                    } else {
                        i3++;
                    }
                }
            } else {
                return false;
            }
            extractorInput.skipFully(i);
        }
    }

    /* access modifiers changed from: package-private */
    public final long readGranuleOfLastPage(ExtractorInput extractorInput) throws IOException {
        skipToNextPage(extractorInput);
        this.pageHeader.reset();
        while ((this.pageHeader.type & 4) != 4 && extractorInput.getPosition() < this.payloadEndPosition) {
            this.pageHeader.populate(extractorInput, false);
            extractorInput.skipFully(this.pageHeader.headerSize + this.pageHeader.bodySize);
        }
        return this.pageHeader.granulePosition;
    }

    final class OggSeekMap implements SeekMap {
        public final boolean isSeekable() {
            return true;
        }

        private OggSeekMap() {
        }

        public final SeekMap.SeekPoints getSeekPoints(long j) {
            return new SeekMap.SeekPoints(new SeekPoint(j, Util.constrainValue((DefaultOggSeeker.this.payloadStartPosition + ((DefaultOggSeeker.this.streamReader.convertTimeToGranule(j) * (DefaultOggSeeker.this.payloadEndPosition - DefaultOggSeeker.this.payloadStartPosition)) / DefaultOggSeeker.this.totalGranules)) - DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS, DefaultOggSeeker.this.payloadStartPosition, DefaultOggSeeker.this.payloadEndPosition - 1)));
        }

        public final long getDurationUs() {
            return DefaultOggSeeker.this.streamReader.convertGranuleToTime(DefaultOggSeeker.this.totalGranules);
        }
    }
}
