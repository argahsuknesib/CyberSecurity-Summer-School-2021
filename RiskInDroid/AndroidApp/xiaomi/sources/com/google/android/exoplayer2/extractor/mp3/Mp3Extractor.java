package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.Id3Peeker;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp3.Seeker;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Mp3Extractor implements Extractor {
    public static final ExtractorsFactory FACTORY = $$Lambda$Mp3Extractor$6eyGfoogMVGFHZKg1gVp93FAKZA.INSTANCE;
    private static final Id3Decoder.FramePredicate REQUIRED_ID3_FRAME_PREDICATE = $$Lambda$Mp3Extractor$bb754AZIAMUosKBF4SefP1vYq88.INSTANCE;
    private long basisTimeUs;
    private TrackOutput currentTrackOutput;
    private boolean disableSeeking;
    private ExtractorOutput extractorOutput;
    private long firstSamplePosition;
    private final int flags;
    private final long forcedFirstSampleTimestampUs;
    private final GaplessInfoHolder gaplessInfoHolder;
    private final Id3Peeker id3Peeker;
    private boolean isSeekInProgress;
    private Metadata metadata;
    private TrackOutput realTrackOutput;
    private int sampleBytesRemaining;
    private long samplesRead;
    private final ParsableByteArray scratch;
    private long seekTimeUs;
    private Seeker seeker;
    private final TrackOutput skippingTrackOutput;
    private final MpegAudioUtil.Header synchronizedHeader;
    private int synchronizedHeaderData;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static boolean headersMatch(int i, long j) {
        return ((long) (i & -128000)) == (j & -128000);
    }

    static /* synthetic */ boolean lambda$static$1(int i, int i2, int i3, int i4, int i5) {
        if (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2)) {
            return true;
        }
        if (i2 == 77 && i3 == 76 && i4 == 76) {
            return i5 == 84 || i == 2;
        }
        return false;
    }

    public final void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new Mp3Extractor()};
    }

    public Mp3Extractor() {
        this(0);
    }

    public Mp3Extractor(int i) {
        this(i, -9223372036854775807L);
    }

    public Mp3Extractor(int i, long j) {
        this.flags = i;
        this.forcedFirstSampleTimestampUs = j;
        this.scratch = new ParsableByteArray(10);
        this.synchronizedHeader = new MpegAudioUtil.Header();
        this.gaplessInfoHolder = new GaplessInfoHolder();
        this.basisTimeUs = -9223372036854775807L;
        this.id3Peeker = new Id3Peeker();
        this.skippingTrackOutput = new DummyTrackOutput();
        this.currentTrackOutput = this.skippingTrackOutput;
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException {
        return synchronize(extractorInput, true);
    }

    public final void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
        this.realTrackOutput = this.extractorOutput.track(0, 1);
        this.currentTrackOutput = this.realTrackOutput;
        this.extractorOutput.endTracks();
    }

    public final void seek(long j, long j2) {
        this.synchronizedHeaderData = 0;
        this.basisTimeUs = -9223372036854775807L;
        this.samplesRead = 0;
        this.sampleBytesRemaining = 0;
        this.seekTimeUs = j2;
        Seeker seeker2 = this.seeker;
        if ((seeker2 instanceof IndexSeeker) && !((IndexSeeker) seeker2).isTimeUsInIndex(j2)) {
            this.isSeekInProgress = true;
            this.currentTrackOutput = this.skippingTrackOutput;
        }
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        assertInitialized();
        int readInternal = readInternal(extractorInput);
        if (readInternal == -1 && (this.seeker instanceof IndexSeeker)) {
            long computeTimeUs = computeTimeUs(this.samplesRead);
            if (this.seeker.getDurationUs() != computeTimeUs) {
                ((IndexSeeker) this.seeker).setDurationUs(computeTimeUs);
                this.extractorOutput.seekMap(this.seeker);
            }
        }
        return readInternal;
    }

    public final void disableSeeking() {
        this.disableSeeking = true;
    }

    private int readInternal(ExtractorInput extractorInput) throws IOException {
        if (this.synchronizedHeaderData == 0) {
            try {
                synchronize(extractorInput, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.seeker == null) {
            this.seeker = computeSeeker(extractorInput);
            this.extractorOutput.seekMap(this.seeker);
            this.currentTrackOutput.format(new Format.Builder().setSampleMimeType(this.synchronizedHeader.mimeType).setMaxInputSize(4096).setChannelCount(this.synchronizedHeader.channels).setSampleRate(this.synchronizedHeader.sampleRate).setEncoderDelay(this.gaplessInfoHolder.encoderDelay).setEncoderPadding(this.gaplessInfoHolder.encoderPadding).setMetadata((this.flags & 4) != 0 ? null : this.metadata).build());
            this.firstSamplePosition = extractorInput.getPosition();
        } else if (this.firstSamplePosition != 0) {
            long position = extractorInput.getPosition();
            long j = this.firstSamplePosition;
            if (position < j) {
                extractorInput.skipFully((int) (j - position));
            }
        }
        return readSample(extractorInput);
    }

    private int readSample(ExtractorInput extractorInput) throws IOException {
        if (this.sampleBytesRemaining == 0) {
            extractorInput.resetPeekPosition();
            if (peekEndOfStreamOrHeader(extractorInput)) {
                return -1;
            }
            this.scratch.setPosition(0);
            int readInt = this.scratch.readInt();
            if (!headersMatch(readInt, (long) this.synchronizedHeaderData) || MpegAudioUtil.getFrameSize(readInt) == -1) {
                extractorInput.skipFully(1);
                this.synchronizedHeaderData = 0;
                return 0;
            }
            this.synchronizedHeader.setForHeaderData(readInt);
            if (this.basisTimeUs == -9223372036854775807L) {
                this.basisTimeUs = this.seeker.getTimeUs(extractorInput.getPosition());
                if (this.forcedFirstSampleTimestampUs != -9223372036854775807L) {
                    this.basisTimeUs += this.forcedFirstSampleTimestampUs - this.seeker.getTimeUs(0);
                }
            }
            this.sampleBytesRemaining = this.synchronizedHeader.frameSize;
            Seeker seeker2 = this.seeker;
            if (seeker2 instanceof IndexSeeker) {
                IndexSeeker indexSeeker = (IndexSeeker) seeker2;
                indexSeeker.maybeAddSeekPoint(computeTimeUs(this.samplesRead + ((long) this.synchronizedHeader.samplesPerFrame)), extractorInput.getPosition() + ((long) this.synchronizedHeader.frameSize));
                if (this.isSeekInProgress && indexSeeker.isTimeUsInIndex(this.seekTimeUs)) {
                    this.isSeekInProgress = false;
                    this.currentTrackOutput = this.realTrackOutput;
                }
            }
        }
        int sampleData = this.currentTrackOutput.sampleData(extractorInput, this.sampleBytesRemaining, true);
        if (sampleData == -1) {
            return -1;
        }
        this.sampleBytesRemaining -= sampleData;
        if (this.sampleBytesRemaining > 0) {
            return 0;
        }
        this.currentTrackOutput.sampleMetadata(computeTimeUs(this.samplesRead), 1, this.synchronizedHeader.frameSize, 0, null);
        this.samplesRead += (long) this.synchronizedHeader.samplesPerFrame;
        this.sampleBytesRemaining = 0;
        return 0;
    }

    private long computeTimeUs(long j) {
        return this.basisTimeUs + ((j * 1000000) / ((long) this.synchronizedHeader.sampleRate));
    }

    private boolean synchronize(ExtractorInput extractorInput, boolean z) throws IOException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int frameSize;
        Id3Decoder.FramePredicate framePredicate;
        int i6 = z ? 16384 : 131072;
        extractorInput.resetPeekPosition();
        if (extractorInput.getPosition() == 0) {
            if ((this.flags & 4) == 0) {
                framePredicate = null;
            } else {
                framePredicate = REQUIRED_ID3_FRAME_PREDICATE;
            }
            this.metadata = this.id3Peeker.peekId3Data(extractorInput, framePredicate);
            Metadata metadata2 = this.metadata;
            if (metadata2 != null) {
                this.gaplessInfoHolder.setFromMetadata(metadata2);
            }
            int peekPosition = (int) extractorInput.getPeekPosition();
            if (!z) {
                extractorInput.skipFully(peekPosition);
            }
            i = peekPosition;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        } else {
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        while (true) {
            if (!peekEndOfStreamOrHeader(extractorInput)) {
                this.scratch.setPosition(0);
                int readInt = this.scratch.readInt();
                if ((i4 == 0 || headersMatch(readInt, (long) i4)) && (frameSize = MpegAudioUtil.getFrameSize(readInt)) != -1) {
                    i5 = i3 + 1;
                    if (i5 != 1) {
                        if (i5 == 4) {
                            break;
                        }
                    } else {
                        this.synchronizedHeader.setForHeaderData(readInt);
                        i4 = readInt;
                    }
                    extractorInput.advancePeekPosition(frameSize - 4);
                } else {
                    int i7 = i2 + 1;
                    if (i2 != i6) {
                        if (z) {
                            extractorInput.resetPeekPosition();
                            extractorInput.advancePeekPosition(i + i7);
                        } else {
                            extractorInput.skipFully(1);
                        }
                        i2 = i7;
                        i4 = 0;
                        i5 = 0;
                    } else if (z) {
                        return false;
                    } else {
                        throw new ParserException("Searched too many bytes.");
                    }
                }
            } else if (i3 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            extractorInput.skipFully(i + i2);
        } else {
            extractorInput.resetPeekPosition();
        }
        this.synchronizedHeaderData = i4;
        return true;
    }

    private boolean peekEndOfStreamOrHeader(ExtractorInput extractorInput) throws IOException {
        Seeker seeker2 = this.seeker;
        if (seeker2 != null) {
            long dataEndPosition = seeker2.getDataEndPosition();
            if (dataEndPosition != -1 && extractorInput.getPeekPosition() > dataEndPosition - 4) {
                return true;
            }
        }
        try {
            if (!extractorInput.peekFully(this.scratch.data, 0, 4, true)) {
                return true;
            }
            return false;
        } catch (EOFException unused) {
            return true;
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.google.android.exoplayer2.extractor.mp3.Seeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.exoplayer2.extractor.mp3.MlltSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.exoplayer2.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.google.android.exoplayer2.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.google.android.exoplayer2.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.exoplayer2.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.google.android.exoplayer2.extractor.mp3.IndexSeeker} */
    /* JADX WARNING: Multi-variable type inference failed */
    private Seeker computeSeeker(ExtractorInput extractorInput) throws IOException {
        Seeker maybeReadSeekFrame = maybeReadSeekFrame(extractorInput);
        MlltSeeker maybeHandleSeekMetadata = maybeHandleSeekMetadata(this.metadata, extractorInput.getPosition());
        if (this.disableSeeking) {
            return new Seeker.UnseekableSeeker();
        }
        IndexSeeker indexSeeker = maybeReadSeekFrame;
        if ((this.flags & 2) != 0) {
            long j = -9223372036854775807L;
            long j2 = -1;
            if (maybeHandleSeekMetadata != null) {
                j = maybeHandleSeekMetadata.getDurationUs();
                j2 = maybeHandleSeekMetadata.getDataEndPosition();
            } else if (maybeReadSeekFrame != null) {
                j = maybeReadSeekFrame.getDurationUs();
                j2 = maybeReadSeekFrame.getDataEndPosition();
            }
            indexSeeker = new IndexSeeker(j, extractorInput.getPosition(), j2);
        } else if (maybeHandleSeekMetadata != null) {
            indexSeeker = maybeHandleSeekMetadata;
        } else if (maybeReadSeekFrame == null) {
            indexSeeker = null;
        }
        return (indexSeeker == null || (!indexSeeker.isSeekable() && (this.flags & 1) != 0)) ? getConstantBitrateSeeker(extractorInput) : indexSeeker;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0041 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    private Seeker maybeReadSeekFrame(ExtractorInput extractorInput) throws IOException {
        int i;
        int seekFrameHeader;
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.synchronizedHeader.frameSize);
        extractorInput.peekFully(parsableByteArray.data, 0, this.synchronizedHeader.frameSize);
        if ((this.synchronizedHeader.version & 1) != 0) {
            if (this.synchronizedHeader.channels != 1) {
                i = 36;
                seekFrameHeader = getSeekFrameHeader(parsableByteArray, i);
                if (seekFrameHeader != 1483304551 || seekFrameHeader == 1231971951) {
                    XingSeeker create = XingSeeker.create(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader, parsableByteArray);
                    if (create != null && !this.gaplessInfoHolder.hasGaplessInfo()) {
                        extractorInput.resetPeekPosition();
                        extractorInput.advancePeekPosition(i + 141);
                        extractorInput.peekFully(this.scratch.data, 0, 3);
                        this.scratch.setPosition(0);
                        this.gaplessInfoHolder.setFromXingHeaderValue(this.scratch.readUnsignedInt24());
                    }
                    extractorInput.skipFully(this.synchronizedHeader.frameSize);
                    return create == null ? create : create;
                } else if (seekFrameHeader == 1447187017) {
                    VbriSeeker create2 = VbriSeeker.create(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader, parsableByteArray);
                    extractorInput.skipFully(this.synchronizedHeader.frameSize);
                    return create2;
                } else {
                    extractorInput.resetPeekPosition();
                    return null;
                }
            }
        } else if (this.synchronizedHeader.channels == 1) {
            i = 13;
            seekFrameHeader = getSeekFrameHeader(parsableByteArray, i);
            if (seekFrameHeader != 1483304551) {
            }
            XingSeeker create3 = XingSeeker.create(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader, parsableByteArray);
            extractorInput.resetPeekPosition();
            extractorInput.advancePeekPosition(i + 141);
            extractorInput.peekFully(this.scratch.data, 0, 3);
            this.scratch.setPosition(0);
            this.gaplessInfoHolder.setFromXingHeaderValue(this.scratch.readUnsignedInt24());
            extractorInput.skipFully(this.synchronizedHeader.frameSize);
            return create3 == null ? create3 : create3;
        }
        i = 21;
        seekFrameHeader = getSeekFrameHeader(parsableByteArray, i);
        if (seekFrameHeader != 1483304551) {
        }
        XingSeeker create32 = XingSeeker.create(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader, parsableByteArray);
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i + 141);
        extractorInput.peekFully(this.scratch.data, 0, 3);
        this.scratch.setPosition(0);
        this.gaplessInfoHolder.setFromXingHeaderValue(this.scratch.readUnsignedInt24());
        extractorInput.skipFully(this.synchronizedHeader.frameSize);
        if (create32 == null) {
        }
    }

    private Seeker getConstantBitrateSeeker(ExtractorInput extractorInput) throws IOException {
        extractorInput.peekFully(this.scratch.data, 0, 4);
        this.scratch.setPosition(0);
        this.synchronizedHeader.setForHeaderData(this.scratch.readInt());
        return new ConstantBitrateSeeker(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader);
    }

    private void assertInitialized() {
        Assertions.checkStateNotNull(this.realTrackOutput);
        Util.castNonNull(this.extractorOutput);
    }

    private static int getSeekFrameHeader(ParsableByteArray parsableByteArray, int i) {
        if (parsableByteArray.limit() >= i + 4) {
            parsableByteArray.setPosition(i);
            int readInt = parsableByteArray.readInt();
            if (readInt == 1483304551 || readInt == 1231971951) {
                return readInt;
            }
        }
        if (parsableByteArray.limit() < 40) {
            return 0;
        }
        parsableByteArray.setPosition(36);
        return parsableByteArray.readInt() == 1447187017 ? 1447187017 : 0;
    }

    private static MlltSeeker maybeHandleSeekMetadata(Metadata metadata2, long j) {
        if (metadata2 == null) {
            return null;
        }
        int length = metadata2.length();
        for (int i = 0; i < length; i++) {
            Metadata.Entry entry = metadata2.get(i);
            if (entry instanceof MlltFrame) {
                return MlltSeeker.create(j, (MlltFrame) entry);
            }
        }
        return null;
    }
}
