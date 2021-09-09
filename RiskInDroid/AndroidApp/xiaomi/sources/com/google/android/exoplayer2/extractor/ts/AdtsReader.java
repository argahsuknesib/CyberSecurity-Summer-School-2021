package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collections;

public final class AdtsReader implements ElementaryStreamReader {
    private static final byte[] ID3_IDENTIFIER = {73, 68, 51};
    private final ParsableBitArray adtsScratch;
    private int bytesRead;
    private int currentFrameVersion;
    private TrackOutput currentOutput;
    private long currentSampleDuration;
    private final boolean exposeId3;
    private int firstFrameSampleRateIndex;
    private int firstFrameVersion;
    private String formatId;
    private boolean foundFirstFrame;
    private boolean hasCrc;
    private boolean hasOutputFormat;
    private final ParsableByteArray id3HeaderBuffer;
    private TrackOutput id3Output;
    private final String language;
    private int matchState;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;

    public static boolean isAdtsSyncWord(int i) {
        return (i & 65526) == 65520;
    }

    public final void packetFinished() {
    }

    public AdtsReader(boolean z) {
        this(z, null);
    }

    public AdtsReader(boolean z, String str) {
        this.adtsScratch = new ParsableBitArray(new byte[7]);
        this.id3HeaderBuffer = new ParsableByteArray(Arrays.copyOf(ID3_IDENTIFIER, 10));
        setFindingSampleState();
        this.firstFrameVersion = -1;
        this.firstFrameSampleRateIndex = -1;
        this.sampleDurationUs = -9223372036854775807L;
        this.exposeId3 = z;
        this.language = str;
    }

    public final void seek() {
        resetSync();
    }

    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
        this.currentOutput = this.output;
        if (this.exposeId3) {
            trackIdGenerator.generateNewId();
            this.id3Output = extractorOutput.track(trackIdGenerator.getTrackId(), 4);
            this.id3Output.format(new Format.Builder().setId(trackIdGenerator.getFormatId()).setSampleMimeType("application/id3").build());
            return;
        }
        this.id3Output = new DummyTrackOutput();
    }

    public final void packetStarted(long j, int i) {
        this.timeUs = j;
    }

    public final void consume(ParsableByteArray parsableByteArray) throws ParserException {
        assertTracksCreated();
        while (parsableByteArray.bytesLeft() > 0) {
            int i = this.state;
            if (i == 0) {
                findNextSample(parsableByteArray);
            } else if (i == 1) {
                checkAdtsHeader(parsableByteArray);
            } else if (i != 2) {
                if (i == 3) {
                    if (continueRead(parsableByteArray, this.adtsScratch.data, this.hasCrc ? 7 : 5)) {
                        parseAdtsHeader();
                    }
                } else if (i == 4) {
                    readSample(parsableByteArray);
                } else {
                    throw new IllegalStateException();
                }
            } else if (continueRead(parsableByteArray, this.id3HeaderBuffer.data, 10)) {
                parseId3Header();
            }
        }
    }

    public final long getSampleDurationUs() {
        return this.sampleDurationUs;
    }

    private void resetSync() {
        this.foundFirstFrame = false;
        setFindingSampleState();
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int min = Math.min(parsableByteArray.bytesLeft(), i - this.bytesRead);
        parsableByteArray.readBytes(bArr, this.bytesRead, min);
        this.bytesRead += min;
        return this.bytesRead == i;
    }

    private void setFindingSampleState() {
        this.state = 0;
        this.bytesRead = 0;
        this.matchState = 256;
    }

    private void setReadingId3HeaderState() {
        this.state = 2;
        this.bytesRead = ID3_IDENTIFIER.length;
        this.sampleSize = 0;
        this.id3HeaderBuffer.setPosition(0);
    }

    private void setReadingSampleState(TrackOutput trackOutput, long j, int i, int i2) {
        this.state = 4;
        this.bytesRead = i;
        this.currentOutput = trackOutput;
        this.currentSampleDuration = j;
        this.sampleSize = i2;
    }

    private void setReadingAdtsHeaderState() {
        this.state = 3;
        this.bytesRead = 0;
    }

    private void setCheckingAdtsHeaderState() {
        this.state = 1;
        this.bytesRead = 0;
    }

    private void findNextSample(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.data;
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (position < limit) {
            int i = position + 1;
            byte b = bArr[position] & 255;
            if (this.matchState != 512 || !isAdtsSyncBytes((byte) -1, (byte) b) || (!this.foundFirstFrame && !checkSyncPositionValid(parsableByteArray, i - 2))) {
                int i2 = this.matchState;
                byte b2 = b | i2;
                if (b2 == 329) {
                    this.matchState = 768;
                } else if (b2 == 511) {
                    this.matchState = 512;
                } else if (b2 == 836) {
                    this.matchState = 1024;
                } else if (b2 == 1075) {
                    setReadingId3HeaderState();
                    parsableByteArray.setPosition(i);
                    return;
                } else if (i2 != 256) {
                    this.matchState = 256;
                    i--;
                }
                position = i;
            } else {
                this.currentFrameVersion = (b & 8) >> 3;
                boolean z = true;
                if ((b & 1) != 0) {
                    z = false;
                }
                this.hasCrc = z;
                if (!this.foundFirstFrame) {
                    setCheckingAdtsHeaderState();
                } else {
                    setReadingAdtsHeaderState();
                }
                parsableByteArray.setPosition(i);
                return;
            }
        }
        parsableByteArray.setPosition(position);
    }

    private void checkAdtsHeader(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() != 0) {
            this.adtsScratch.data[0] = parsableByteArray.data[parsableByteArray.getPosition()];
            this.adtsScratch.setPosition(2);
            int readBits = this.adtsScratch.readBits(4);
            int i = this.firstFrameSampleRateIndex;
            if (i == -1 || readBits == i) {
                if (!this.foundFirstFrame) {
                    this.foundFirstFrame = true;
                    this.firstFrameVersion = this.currentFrameVersion;
                    this.firstFrameSampleRateIndex = readBits;
                }
                setReadingAdtsHeaderState();
                return;
            }
            resetSync();
        }
    }

    private boolean checkSyncPositionValid(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 1);
        if (!tryRead(parsableByteArray, this.adtsScratch.data, 1)) {
            return false;
        }
        this.adtsScratch.setPosition(4);
        int readBits = this.adtsScratch.readBits(1);
        int i2 = this.firstFrameVersion;
        if (i2 != -1 && readBits != i2) {
            return false;
        }
        if (this.firstFrameSampleRateIndex != -1) {
            if (!tryRead(parsableByteArray, this.adtsScratch.data, 1)) {
                return true;
            }
            this.adtsScratch.setPosition(2);
            if (this.adtsScratch.readBits(4) != this.firstFrameSampleRateIndex) {
                return false;
            }
            parsableByteArray.setPosition(i + 2);
        }
        if (!tryRead(parsableByteArray, this.adtsScratch.data, 4)) {
            return true;
        }
        this.adtsScratch.setPosition(14);
        int readBits2 = this.adtsScratch.readBits(13);
        if (readBits2 < 7) {
            return false;
        }
        byte[] bArr = parsableByteArray.data;
        int limit = parsableByteArray.limit();
        int i3 = i + readBits2;
        if (i3 >= limit) {
            return true;
        }
        if (bArr[i3] == -1) {
            int i4 = i3 + 1;
            if (i4 == limit) {
                return true;
            }
            return isAdtsSyncBytes((byte) -1, bArr[i4]) && ((bArr[i4] & 8) >> 3) == readBits;
        } else if (bArr[i3] != 73) {
            return false;
        } else {
            int i5 = i3 + 1;
            if (i5 == limit) {
                return true;
            }
            if (bArr[i5] != 68) {
                return false;
            }
            int i6 = i3 + 2;
            return i6 == limit || bArr[i6] == 51;
        }
    }

    private boolean isAdtsSyncBytes(byte b, byte b2) {
        return isAdtsSyncWord(((b & 255) << 8) | (b2 & 255));
    }

    private boolean tryRead(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        if (parsableByteArray.bytesLeft() < i) {
            return false;
        }
        parsableByteArray.readBytes(bArr, 0, i);
        return true;
    }

    private void parseId3Header() {
        this.id3Output.sampleData(this.id3HeaderBuffer, 10);
        this.id3HeaderBuffer.setPosition(6);
        setReadingSampleState(this.id3Output, 0, 10, this.id3HeaderBuffer.readSynchSafeInt() + 10);
    }

    private void parseAdtsHeader() throws ParserException {
        this.adtsScratch.setPosition(0);
        if (!this.hasOutputFormat) {
            int readBits = this.adtsScratch.readBits(2) + 1;
            if (readBits != 2) {
                Log.w("AdtsReader", "Detected audio object type: " + readBits + ", but assuming AAC LC.");
                readBits = 2;
            }
            this.adtsScratch.skipBits(5);
            byte[] buildAudioSpecificConfig = AacUtil.buildAudioSpecificConfig(readBits, this.firstFrameSampleRateIndex, this.adtsScratch.readBits(3));
            AacUtil.Config parseAudioSpecificConfig = AacUtil.parseAudioSpecificConfig(buildAudioSpecificConfig);
            Format build = new Format.Builder().setId(this.formatId).setSampleMimeType("audio/mp4a-latm").setCodecs(parseAudioSpecificConfig.codecs).setChannelCount(parseAudioSpecificConfig.channelCount).setSampleRate(parseAudioSpecificConfig.sampleRateHz).setInitializationData(Collections.singletonList(buildAudioSpecificConfig)).setLanguage(this.language).build();
            this.sampleDurationUs = 1024000000 / ((long) build.sampleRate);
            this.output.format(build);
            this.hasOutputFormat = true;
        } else {
            this.adtsScratch.skipBits(10);
        }
        this.adtsScratch.skipBits(4);
        int readBits2 = (this.adtsScratch.readBits(13) - 2) - 5;
        if (this.hasCrc) {
            readBits2 -= 2;
        }
        setReadingSampleState(this.output, this.sampleDurationUs, 0, readBits2);
    }

    private void readSample(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
        this.currentOutput.sampleData(parsableByteArray, min);
        this.bytesRead += min;
        int i = this.bytesRead;
        int i2 = this.sampleSize;
        if (i == i2) {
            this.currentOutput.sampleMetadata(this.timeUs, 1, i2, 0, null);
            this.timeUs += this.currentSampleDuration;
            setFindingSampleState();
        }
    }

    private void assertTracksCreated() {
        Assertions.checkNotNull(this.output);
        Util.castNonNull(this.currentOutput);
        Util.castNonNull(this.id3Output);
    }
}
