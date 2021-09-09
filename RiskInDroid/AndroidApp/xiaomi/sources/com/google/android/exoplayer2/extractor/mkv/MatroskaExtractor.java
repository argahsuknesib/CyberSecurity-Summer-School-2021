package com.google.android.exoplayer2.extractor.mkv;

import android.support.v4.app.NotificationCompat;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.video.HevcConfig;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class MatroskaExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = $$Lambda$MatroskaExtractor$jNXW0tyYIOPE6N2jicocV6rRvBs.INSTANCE;
    public static final byte[] SSA_DIALOGUE_FORMAT = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] SSA_PREFIX = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] SUBRIP_PREFIX = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final UUID WAVE_SUBFORMAT_PCM = new UUID(72057594037932032L, -9223371306706625679L);
    private final ParsableByteArray blockAdditionalData;
    private int blockAdditionalId;
    private long blockDurationUs;
    private int blockFlags;
    private boolean blockHasReferenceBlock;
    private int blockSampleCount;
    private int blockSampleIndex;
    private int[] blockSampleSizes;
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;
    private LongArray cueClusterPositions;
    private LongArray cueTimesUs;
    private long cuesContentPosition;
    private Track currentTrack;
    private long durationTimecode;
    private long durationUs;
    private final ParsableByteArray encryptionInitializationVector;
    private final ParsableByteArray encryptionSubsampleData;
    private ByteBuffer encryptionSubsampleDataBuffer;
    private ExtractorOutput extractorOutput;
    private boolean haveOutputSample;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private final EbmlReader reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleInitializationVectorRead;
    private int samplePartitionCount;
    private boolean samplePartitionCountRead;
    private byte sampleSignalByte;
    private boolean sampleSignalByteRead;
    private final ParsableByteArray sampleStrippedBytes;
    private final ParsableByteArray scratch;
    private int seekEntryId;
    private final ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private final boolean seekForCuesEnabled;
    private long seekPositionAfterBuildingCues;
    private boolean seenClusterPositionForCurrentCuePoint;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentSeekMap;
    private final ParsableByteArray subtitleSample;
    private long timecodeScale;
    private final SparseArray<Track> tracks;
    private final VarintReader varintReader;
    private final ParsableByteArray vorbisNumPageSamples;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* access modifiers changed from: protected */
    public int getElementType(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isLevel1Element(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    public final void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new MatroskaExtractor()};
    }

    public MatroskaExtractor() {
        this(0);
    }

    public MatroskaExtractor(int i) {
        this(new DefaultEbmlReader(), i);
    }

    MatroskaExtractor(EbmlReader ebmlReader, int i) {
        this.segmentContentPosition = -1;
        this.timecodeScale = -9223372036854775807L;
        this.durationTimecode = -9223372036854775807L;
        this.durationUs = -9223372036854775807L;
        this.cuesContentPosition = -1;
        this.seekPositionAfterBuildingCues = -1;
        this.clusterTimecodeUs = -9223372036854775807L;
        this.reader = ebmlReader;
        this.reader.init(new InnerEbmlProcessor());
        this.seekForCuesEnabled = (i & 1) == 0;
        this.varintReader = new VarintReader();
        this.tracks = new SparseArray<>();
        this.scratch = new ParsableByteArray(4);
        this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.seekEntryIdBytes = new ParsableByteArray(4);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleStrippedBytes = new ParsableByteArray();
        this.subtitleSample = new ParsableByteArray();
        this.encryptionInitializationVector = new ParsableByteArray(8);
        this.encryptionSubsampleData = new ParsableByteArray();
        this.blockAdditionalData = new ParsableByteArray();
        this.blockSampleSizes = new int[1];
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException {
        return new Sniffer().sniff(extractorInput);
    }

    public final void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
    }

    public void seek(long j, long j2) {
        this.clusterTimecodeUs = -9223372036854775807L;
        this.blockState = 0;
        this.reader.reset();
        this.varintReader.reset();
        resetWriteSampleData();
        for (int i = 0; i < this.tracks.size(); i++) {
            this.tracks.valueAt(i).reset();
        }
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        this.haveOutputSample = false;
        boolean z = true;
        while (z && !this.haveOutputSample) {
            z = this.reader.read(extractorInput);
            if (z && maybeSeekForCues(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (z) {
            return 0;
        }
        for (int i = 0; i < this.tracks.size(); i++) {
            this.tracks.valueAt(i).outputPendingSampleMetadata();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void startMasterElement(int i, long j, long j2) throws ParserException {
        if (i == 160) {
            this.blockHasReferenceBlock = false;
        } else if (i == 174) {
            this.currentTrack = new Track();
        } else if (i == 187) {
            this.seenClusterPositionForCurrentCuePoint = false;
        } else if (i == 19899) {
            this.seekEntryId = -1;
            this.seekEntryPosition = -1;
        } else if (i == 20533) {
            this.currentTrack.hasContentEncryption = true;
        } else if (i == 21968) {
            this.currentTrack.hasColorInfo = true;
        } else if (i == 25152) {
        } else {
            if (i == 408125543) {
                long j3 = this.segmentContentPosition;
                if (j3 == -1 || j3 == j) {
                    this.segmentContentPosition = j;
                    this.segmentContentSize = j2;
                    return;
                }
                throw new ParserException("Multiple Segment elements not supported");
            } else if (i == 475249515) {
                this.cueTimesUs = new LongArray();
                this.cueClusterPositions = new LongArray();
            } else if (i != 524531317 || this.sentSeekMap) {
            } else {
                if (!this.seekForCuesEnabled || this.cuesContentPosition == -1) {
                    this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                    this.sentSeekMap = true;
                    return;
                }
                this.seekForCues = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void endMasterElement(int i) throws ParserException {
        if (i != 160) {
            if (i == 174) {
                if (isCodecSupported(this.currentTrack.codecId)) {
                    Track track = this.currentTrack;
                    track.initializeOutput(this.extractorOutput, track.number);
                    this.tracks.put(this.currentTrack.number, this.currentTrack);
                }
                this.currentTrack = null;
            } else if (i == 19899) {
                int i2 = this.seekEntryId;
                if (i2 != -1) {
                    long j = this.seekEntryPosition;
                    if (j != -1) {
                        if (i2 == 475249515) {
                            this.cuesContentPosition = j;
                            return;
                        }
                        return;
                    }
                }
                throw new ParserException("Mandatory element SeekID or SeekPosition not found");
            } else if (i != 25152) {
                if (i != 28032) {
                    if (i == 357149030) {
                        if (this.timecodeScale == -9223372036854775807L) {
                            this.timecodeScale = 1000000;
                        }
                        long j2 = this.durationTimecode;
                        if (j2 != -9223372036854775807L) {
                            this.durationUs = scaleTimecodeToUs(j2);
                        }
                    } else if (i != 374648427) {
                        if (i == 475249515 && !this.sentSeekMap) {
                            this.extractorOutput.seekMap(buildSeekMap());
                            this.sentSeekMap = true;
                        }
                    } else if (this.tracks.size() != 0) {
                        this.extractorOutput.endTracks();
                    } else {
                        throw new ParserException("No valid tracks were found");
                    }
                } else if (this.currentTrack.hasContentEncryption && this.currentTrack.sampleStrippedBytes != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
            } else if (!this.currentTrack.hasContentEncryption) {
            } else {
                if (this.currentTrack.cryptoData != null) {
                    this.currentTrack.drmInitData = new DrmInitData(new DrmInitData.SchemeData(C.UUID_NIL, "video/webm", this.currentTrack.cryptoData.encryptionKey));
                    return;
                }
                throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
            }
        } else if (this.blockState == 2) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.blockSampleCount; i4++) {
                i3 += this.blockSampleSizes[i4];
            }
            Track track2 = this.tracks.get(this.blockTrackNumber);
            int i5 = i3;
            int i6 = 0;
            while (i6 < this.blockSampleCount) {
                long j3 = ((long) ((track2.defaultSampleDurationNs * i6) / 1000)) + this.blockTimeUs;
                int i7 = this.blockFlags;
                if (i6 == 0 && !this.blockHasReferenceBlock) {
                    i7 |= 1;
                }
                int i8 = this.blockSampleSizes[i6];
                int i9 = i5 - i8;
                commitSampleToOutput(track2, j3, i7, i8, i9);
                i6++;
                i5 = i9;
            }
            this.blockState = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void integerElement(int i, long j) throws ParserException {
        if (i != 20529) {
            if (i != 20530) {
                boolean z = false;
                switch (i) {
                    case 131:
                        this.currentTrack.type = (int) j;
                        return;
                    case 136:
                        Track track = this.currentTrack;
                        if (j == 1) {
                            z = true;
                        }
                        track.flagDefault = z;
                        return;
                    case 155:
                        this.blockDurationUs = scaleTimecodeToUs(j);
                        return;
                    case 159:
                        this.currentTrack.channelCount = (int) j;
                        return;
                    case 176:
                        this.currentTrack.width = (int) j;
                        return;
                    case 179:
                        this.cueTimesUs.add(scaleTimecodeToUs(j));
                        return;
                    case 186:
                        this.currentTrack.height = (int) j;
                        return;
                    case 215:
                        this.currentTrack.number = (int) j;
                        return;
                    case 231:
                        this.clusterTimecodeUs = scaleTimecodeToUs(j);
                        return;
                    case 238:
                        this.blockAdditionalId = (int) j;
                        return;
                    case 241:
                        if (!this.seenClusterPositionForCurrentCuePoint) {
                            this.cueClusterPositions.add(j);
                            this.seenClusterPositionForCurrentCuePoint = true;
                            return;
                        }
                        return;
                    case 251:
                        this.blockHasReferenceBlock = true;
                        return;
                    case 16980:
                        if (j != 3) {
                            throw new ParserException("ContentCompAlgo " + j + " not supported");
                        }
                        return;
                    case 17029:
                        if (j < 1 || j > 2) {
                            throw new ParserException("DocTypeReadVersion " + j + " not supported");
                        }
                        return;
                    case 17143:
                        if (j != 1) {
                            throw new ParserException("EBMLReadVersion " + j + " not supported");
                        }
                        return;
                    case 18401:
                        if (j != 5) {
                            throw new ParserException("ContentEncAlgo " + j + " not supported");
                        }
                        return;
                    case 18408:
                        if (j != 1) {
                            throw new ParserException("AESSettingsCipherMode " + j + " not supported");
                        }
                        return;
                    case 21420:
                        this.seekEntryPosition = j + this.segmentContentPosition;
                        return;
                    case 21432:
                        int i2 = (int) j;
                        if (i2 == 0) {
                            this.currentTrack.stereoMode = 0;
                            return;
                        } else if (i2 == 1) {
                            this.currentTrack.stereoMode = 2;
                            return;
                        } else if (i2 == 3) {
                            this.currentTrack.stereoMode = 1;
                            return;
                        } else if (i2 == 15) {
                            this.currentTrack.stereoMode = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.currentTrack.displayWidth = (int) j;
                        return;
                    case 21682:
                        this.currentTrack.displayUnit = (int) j;
                        return;
                    case 21690:
                        this.currentTrack.displayHeight = (int) j;
                        return;
                    case 21930:
                        Track track2 = this.currentTrack;
                        if (j == 1) {
                            z = true;
                        }
                        track2.flagForced = z;
                        return;
                    case 21998:
                        this.currentTrack.maxBlockAdditionId = (int) j;
                        return;
                    case 22186:
                        this.currentTrack.codecDelayNs = j;
                        return;
                    case 22203:
                        this.currentTrack.seekPreRollNs = j;
                        return;
                    case 25188:
                        this.currentTrack.audioBitDepth = (int) j;
                        return;
                    case 30321:
                        int i3 = (int) j;
                        if (i3 == 0) {
                            this.currentTrack.projectionType = 0;
                            return;
                        } else if (i3 == 1) {
                            this.currentTrack.projectionType = 1;
                            return;
                        } else if (i3 == 2) {
                            this.currentTrack.projectionType = 2;
                            return;
                        } else if (i3 == 3) {
                            this.currentTrack.projectionType = 3;
                            return;
                        } else {
                            return;
                        }
                    case 2352003:
                        this.currentTrack.defaultSampleDurationNs = (int) j;
                        return;
                    case 2807729:
                        this.timecodeScale = j;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                int i4 = (int) j;
                                if (i4 == 1) {
                                    this.currentTrack.colorRange = 2;
                                    return;
                                } else if (i4 == 2) {
                                    this.currentTrack.colorRange = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i5 = (int) j;
                                if (i5 != 1) {
                                    if (i5 == 16) {
                                        this.currentTrack.colorTransfer = 6;
                                        return;
                                    } else if (i5 == 18) {
                                        this.currentTrack.colorTransfer = 7;
                                        return;
                                    } else if (!(i5 == 6 || i5 == 7)) {
                                        return;
                                    }
                                }
                                this.currentTrack.colorTransfer = 3;
                                return;
                            case 21947:
                                Track track3 = this.currentTrack;
                                track3.hasColorInfo = true;
                                int i6 = (int) j;
                                if (i6 == 1) {
                                    track3.colorSpace = 1;
                                    return;
                                } else if (i6 == 9) {
                                    track3.colorSpace = 6;
                                    return;
                                } else if (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) {
                                    this.currentTrack.colorSpace = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.currentTrack.maxContentLuminance = (int) j;
                                return;
                            case 21949:
                                this.currentTrack.maxFrameAverageLuminance = (int) j;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j != 1) {
                throw new ParserException("ContentEncodingScope " + j + " not supported");
            }
        } else if (j != 0) {
            throw new ParserException("ContentEncodingOrder " + j + " not supported");
        }
    }

    /* access modifiers changed from: protected */
    public void floatElement(int i, double d) throws ParserException {
        if (i == 181) {
            this.currentTrack.sampleRate = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    this.currentTrack.primaryRChromaticityX = (float) d;
                    return;
                case 21970:
                    this.currentTrack.primaryRChromaticityY = (float) d;
                    return;
                case 21971:
                    this.currentTrack.primaryGChromaticityX = (float) d;
                    return;
                case 21972:
                    this.currentTrack.primaryGChromaticityY = (float) d;
                    return;
                case 21973:
                    this.currentTrack.primaryBChromaticityX = (float) d;
                    return;
                case 21974:
                    this.currentTrack.primaryBChromaticityY = (float) d;
                    return;
                case 21975:
                    this.currentTrack.whitePointChromaticityX = (float) d;
                    return;
                case 21976:
                    this.currentTrack.whitePointChromaticityY = (float) d;
                    return;
                case 21977:
                    this.currentTrack.maxMasteringLuminance = (float) d;
                    return;
                case 21978:
                    this.currentTrack.minMasteringLuminance = (float) d;
                    return;
                default:
                    switch (i) {
                        case 30323:
                            this.currentTrack.projectionPoseYaw = (float) d;
                            return;
                        case 30324:
                            this.currentTrack.projectionPosePitch = (float) d;
                            return;
                        case 30325:
                            this.currentTrack.projectionPoseRoll = (float) d;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.durationTimecode = (long) d;
        }
    }

    /* access modifiers changed from: protected */
    public void stringElement(int i, String str) throws ParserException {
        if (i == 134) {
            this.currentTrack.codecId = str;
        } else if (i != 17026) {
            if (i == 21358) {
                this.currentTrack.name = str;
            } else if (i == 2274716) {
                this.currentTrack.language = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            throw new ParserException("DocType " + str + " not supported");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x020f, code lost:
        throw new com.google.android.exoplayer2.ParserException("EBML lacing sample size out of range.");
     */
    public void binaryElement(int i, int i2, ExtractorInput extractorInput) throws IOException {
        int i3;
        byte b;
        int[] iArr;
        int i4 = i;
        int i5 = i2;
        ExtractorInput extractorInput2 = extractorInput;
        int i6 = 4;
        int i7 = 0;
        int i8 = 1;
        if (i4 == 161 || i4 == 163) {
            int i9 = 8;
            if (this.blockState == 0) {
                this.blockTrackNumber = (int) this.varintReader.readUnsignedVarint(extractorInput2, false, true, 8);
                this.blockTrackNumberLength = this.varintReader.getLastLength();
                this.blockDurationUs = -9223372036854775807L;
                this.blockState = 1;
                this.scratch.reset();
            }
            Track track = this.tracks.get(this.blockTrackNumber);
            if (track == null) {
                extractorInput2.skipFully(i5 - this.blockTrackNumberLength);
                this.blockState = 0;
                return;
            }
            if (this.blockState == 1) {
                readScratch(extractorInput2, 3);
                int i10 = (this.scratch.data[2] & 6) >> 1;
                if (i10 == 0) {
                    this.blockSampleCount = 1;
                    this.blockSampleSizes = ensureArrayCapacity(this.blockSampleSizes, 1);
                    this.blockSampleSizes[0] = (i5 - this.blockTrackNumberLength) - 3;
                } else {
                    readScratch(extractorInput2, 4);
                    this.blockSampleCount = (this.scratch.data[3] & 255) + 1;
                    this.blockSampleSizes = ensureArrayCapacity(this.blockSampleSizes, this.blockSampleCount);
                    if (i10 == 2) {
                        int i11 = this.blockSampleCount;
                        Arrays.fill(this.blockSampleSizes, 0, i11, ((i5 - this.blockTrackNumberLength) - 4) / i11);
                    } else if (i10 == 1) {
                        int i12 = 0;
                        int i13 = 0;
                        while (true) {
                            i3 = this.blockSampleCount;
                            if (i12 >= i3 - 1) {
                                break;
                            }
                            this.blockSampleSizes[i12] = 0;
                            do {
                                i6++;
                                readScratch(extractorInput2, i6);
                                b = this.scratch.data[i6 - 1] & 255;
                                iArr = this.blockSampleSizes;
                                iArr[i12] = iArr[i12] + b;
                            } while (b == 255);
                            i13 += iArr[i12];
                            i12++;
                        }
                        this.blockSampleSizes[i3 - 1] = ((i5 - this.blockTrackNumberLength) - i6) - i13;
                    } else if (i10 == 3) {
                        int i14 = 0;
                        int i15 = 0;
                        while (true) {
                            int i16 = this.blockSampleCount;
                            if (i14 >= i16 - 1) {
                                this.blockSampleSizes[i16 - 1] = ((i5 - this.blockTrackNumberLength) - i6) - i15;
                                break;
                            }
                            this.blockSampleSizes[i14] = i7;
                            int i17 = i6 + 1;
                            readScratch(extractorInput2, i17);
                            int i18 = i17 - 1;
                            if (this.scratch.data[i18] != 0) {
                                long j = 0;
                                int i19 = 0;
                                while (true) {
                                    if (i19 >= i9) {
                                        break;
                                    }
                                    int i20 = i8 << (7 - i19);
                                    if ((this.scratch.data[i18] & i20) != 0) {
                                        i17 += i19;
                                        readScratch(extractorInput2, i17);
                                        int i21 = i18 + 1;
                                        j = (long) (this.scratch.data[i18] & 255 & (i20 ^ -1));
                                        while (i21 < i17) {
                                            i21++;
                                            j = ((long) (this.scratch.data[i21] & 255)) | (j << i9);
                                            i9 = 8;
                                        }
                                        if (i14 > 0) {
                                            j -= (1 << ((i19 * 7) + 6)) - 1;
                                        }
                                    } else {
                                        i19++;
                                        i9 = 8;
                                        i8 = 1;
                                    }
                                }
                                int i22 = i17;
                                long j2 = j;
                                if (j2 >= -2147483648L && j2 <= 2147483647L) {
                                    int i23 = (int) j2;
                                    int[] iArr2 = this.blockSampleSizes;
                                    if (i14 != 0) {
                                        i23 += iArr2[i14 - 1];
                                    }
                                    iArr2[i14] = i23;
                                    i15 += this.blockSampleSizes[i14];
                                    i14++;
                                    i6 = i22;
                                    i9 = 8;
                                    i7 = 0;
                                    i8 = 1;
                                }
                            } else {
                                throw new ParserException("No valid varint length mask found");
                            }
                        }
                    } else {
                        throw new ParserException("Unexpected lacing value: ".concat(String.valueOf(i10)));
                    }
                }
                this.blockTimeUs = this.clusterTimecodeUs + scaleTimecodeToUs((long) ((this.scratch.data[0] << 8) | (this.scratch.data[1] & 255)));
                this.blockFlags = ((track.type == 2 || (i4 == 163 && (this.scratch.data[2] & 128) == 128)) ? 1 : 0) | ((this.scratch.data[2] & 8) == 8 ? Integer.MIN_VALUE : 0);
                this.blockState = 2;
                this.blockSampleIndex = 0;
            }
            if (i4 == 163) {
                while (true) {
                    int i24 = this.blockSampleIndex;
                    if (i24 < this.blockSampleCount) {
                        commitSampleToOutput(track, ((long) ((this.blockSampleIndex * track.defaultSampleDurationNs) / 1000)) + this.blockTimeUs, this.blockFlags, writeSampleData(extractorInput2, track, this.blockSampleSizes[i24]), 0);
                        this.blockSampleIndex++;
                    } else {
                        this.blockState = 0;
                        return;
                    }
                }
            } else {
                while (true) {
                    int i25 = this.blockSampleIndex;
                    if (i25 < this.blockSampleCount) {
                        int[] iArr3 = this.blockSampleSizes;
                        iArr3[i25] = writeSampleData(extractorInput2, track, iArr3[i25]);
                        this.blockSampleIndex++;
                    } else {
                        return;
                    }
                }
            }
        } else if (i4 != 165) {
            if (i4 == 16981) {
                Track track2 = this.currentTrack;
                track2.sampleStrippedBytes = new byte[i5];
                extractorInput2.readFully(track2.sampleStrippedBytes, 0, i5);
            } else if (i4 == 18402) {
                byte[] bArr = new byte[i5];
                extractorInput2.readFully(bArr, 0, i5);
                this.currentTrack.cryptoData = new TrackOutput.CryptoData(1, bArr, 0, 0);
            } else if (i4 == 21419) {
                Arrays.fill(this.seekEntryIdBytes.data, (byte) 0);
                extractorInput2.readFully(this.seekEntryIdBytes.data, 4 - i5, i5);
                this.seekEntryIdBytes.setPosition(0);
                this.seekEntryId = (int) this.seekEntryIdBytes.readUnsignedInt();
            } else if (i4 == 25506) {
                Track track3 = this.currentTrack;
                track3.codecPrivate = new byte[i5];
                extractorInput2.readFully(track3.codecPrivate, 0, i5);
            } else if (i4 == 30322) {
                Track track4 = this.currentTrack;
                track4.projectionData = new byte[i5];
                extractorInput2.readFully(track4.projectionData, 0, i5);
            } else {
                throw new ParserException("Unexpected id: ".concat(String.valueOf(i)));
            }
        } else if (this.blockState == 2) {
            handleBlockAdditionalData(this.tracks.get(this.blockTrackNumber), this.blockAdditionalId, extractorInput2, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void handleBlockAdditionalData(Track track, int i, ExtractorInput extractorInput, int i2) throws IOException {
        if (i != 4 || !"V_VP9".equals(track.codecId)) {
            extractorInput.skipFully(i2);
            return;
        }
        this.blockAdditionalData.reset(i2);
        extractorInput.readFully(this.blockAdditionalData.data, 0, i2);
    }

    private void commitSampleToOutput(Track track, long j, int i, int i2, int i3) {
        if (track.trueHdSampleRechunker != null) {
            track.trueHdSampleRechunker.sampleMetadata(track, j, i, i2, i3);
        } else {
            if ("S_TEXT/UTF8".equals(track.codecId) || "S_TEXT/ASS".equals(track.codecId)) {
                if (this.blockSampleCount > 1) {
                    Log.w("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else if (this.blockDurationUs == -9223372036854775807L) {
                    Log.w("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                } else {
                    setSubtitleEndTime(track.codecId, this.blockDurationUs, this.subtitleSample.data);
                    TrackOutput trackOutput = track.output;
                    ParsableByteArray parsableByteArray = this.subtitleSample;
                    trackOutput.sampleData(parsableByteArray, parsableByteArray.limit());
                    i2 += this.subtitleSample.limit();
                }
            }
            if ((268435456 & i) != 0) {
                if (this.blockSampleCount > 1) {
                    i &= -268435457;
                } else {
                    int limit = this.blockAdditionalData.limit();
                    track.output.sampleData(this.blockAdditionalData, limit);
                    i2 += limit;
                }
            }
            track.output.sampleMetadata(j, i, i2, i3, track.cryptoData);
        }
        this.haveOutputSample = true;
    }

    private void readScratch(ExtractorInput extractorInput, int i) throws IOException {
        if (this.scratch.limit() < i) {
            if (this.scratch.capacity() < i) {
                ParsableByteArray parsableByteArray = this.scratch;
                parsableByteArray.reset(Arrays.copyOf(parsableByteArray.data, Math.max(this.scratch.data.length * 2, i)), this.scratch.limit());
            }
            extractorInput.readFully(this.scratch.data, this.scratch.limit(), i - this.scratch.limit());
            this.scratch.setLimit(i);
        }
    }

    private int writeSampleData(ExtractorInput extractorInput, Track track, int i) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SUBRIP_PREFIX, i);
            return finishWriteSampleData();
        } else if ("S_TEXT/ASS".equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SSA_PREFIX, i);
            return finishWriteSampleData();
        } else {
            TrackOutput trackOutput = track.output;
            boolean z = true;
            if (!this.sampleEncodingHandled) {
                if (track.hasContentEncryption) {
                    this.blockFlags &= -1073741825;
                    boolean z2 = this.sampleSignalByteRead;
                    int i3 = NotificationCompat.FLAG_HIGH_PRIORITY;
                    if (!z2) {
                        extractorInput.readFully(this.scratch.data, 0, 1);
                        this.sampleBytesRead++;
                        if ((this.scratch.data[0] & 128) != 128) {
                            this.sampleSignalByte = this.scratch.data[0];
                            this.sampleSignalByteRead = true;
                        } else {
                            throw new ParserException("Extension bit is set in signal byte");
                        }
                    }
                    if ((this.sampleSignalByte & 1) == 1) {
                        boolean z3 = (this.sampleSignalByte & 2) == 2;
                        this.blockFlags |= 1073741824;
                        if (!this.sampleInitializationVectorRead) {
                            extractorInput.readFully(this.encryptionInitializationVector.data, 0, 8);
                            this.sampleBytesRead += 8;
                            this.sampleInitializationVectorRead = true;
                            byte[] bArr = this.scratch.data;
                            if (!z3) {
                                i3 = 0;
                            }
                            bArr[0] = (byte) (i3 | 8);
                            this.scratch.setPosition(0);
                            trackOutput.sampleData(this.scratch, 1);
                            this.sampleBytesWritten++;
                            this.encryptionInitializationVector.setPosition(0);
                            trackOutput.sampleData(this.encryptionInitializationVector, 8);
                            this.sampleBytesWritten += 8;
                        }
                        if (z3) {
                            if (!this.samplePartitionCountRead) {
                                extractorInput.readFully(this.scratch.data, 0, 1);
                                this.sampleBytesRead++;
                                this.scratch.setPosition(0);
                                this.samplePartitionCount = this.scratch.readUnsignedByte();
                                this.samplePartitionCountRead = true;
                            }
                            int i4 = this.samplePartitionCount * 4;
                            this.scratch.reset(i4);
                            extractorInput.readFully(this.scratch.data, 0, i4);
                            this.sampleBytesRead += i4;
                            short s = (short) ((this.samplePartitionCount / 2) + 1);
                            int i5 = (s * 6) + 2;
                            ByteBuffer byteBuffer = this.encryptionSubsampleDataBuffer;
                            if (byteBuffer == null || byteBuffer.capacity() < i5) {
                                this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(i5);
                            }
                            this.encryptionSubsampleDataBuffer.position(0);
                            this.encryptionSubsampleDataBuffer.putShort(s);
                            int i6 = 0;
                            int i7 = 0;
                            while (true) {
                                i2 = this.samplePartitionCount;
                                if (i6 >= i2) {
                                    break;
                                }
                                int readUnsignedIntToInt = this.scratch.readUnsignedIntToInt();
                                if (i6 % 2 == 0) {
                                    this.encryptionSubsampleDataBuffer.putShort((short) (readUnsignedIntToInt - i7));
                                } else {
                                    this.encryptionSubsampleDataBuffer.putInt(readUnsignedIntToInt - i7);
                                }
                                i6++;
                                i7 = readUnsignedIntToInt;
                            }
                            int i8 = (i - this.sampleBytesRead) - i7;
                            if (i2 % 2 == 1) {
                                this.encryptionSubsampleDataBuffer.putInt(i8);
                            } else {
                                this.encryptionSubsampleDataBuffer.putShort((short) i8);
                                this.encryptionSubsampleDataBuffer.putInt(0);
                            }
                            this.encryptionSubsampleData.reset(this.encryptionSubsampleDataBuffer.array(), i5);
                            trackOutput.sampleData(this.encryptionSubsampleData, i5);
                            this.sampleBytesWritten += i5;
                        }
                    }
                } else if (track.sampleStrippedBytes != null) {
                    this.sampleStrippedBytes.reset(track.sampleStrippedBytes, track.sampleStrippedBytes.length);
                }
                if (track.maxBlockAdditionId > 0) {
                    this.blockFlags |= 268435456;
                    this.blockAdditionalData.reset();
                    this.scratch.reset(4);
                    this.scratch.data[0] = (byte) ((i >> 24) & 255);
                    this.scratch.data[1] = (byte) ((i >> 16) & 255);
                    this.scratch.data[2] = (byte) ((i >> 8) & 255);
                    this.scratch.data[3] = (byte) (i & 255);
                    trackOutput.sampleData(this.scratch, 4);
                    this.sampleBytesWritten += 4;
                }
                this.sampleEncodingHandled = true;
            }
            int limit = i + this.sampleStrippedBytes.limit();
            if (!"V_MPEG4/ISO/AVC".equals(track.codecId) && !"V_MPEGH/ISO/HEVC".equals(track.codecId)) {
                if (track.trueHdSampleRechunker != null) {
                    if (this.sampleStrippedBytes.limit() != 0) {
                        z = false;
                    }
                    Assertions.checkState(z);
                    track.trueHdSampleRechunker.startSample(extractorInput);
                }
                while (true) {
                    int i9 = this.sampleBytesRead;
                    if (i9 >= limit) {
                        break;
                    }
                    int writeToOutput = writeToOutput(extractorInput, trackOutput, limit - i9);
                    this.sampleBytesRead += writeToOutput;
                    this.sampleBytesWritten += writeToOutput;
                }
            } else {
                byte[] bArr2 = this.nalLength.data;
                bArr2[0] = 0;
                bArr2[1] = 0;
                bArr2[2] = 0;
                int i10 = track.nalUnitLengthFieldLength;
                int i11 = 4 - track.nalUnitLengthFieldLength;
                while (this.sampleBytesRead < limit) {
                    int i12 = this.sampleCurrentNalBytesRemaining;
                    if (i12 == 0) {
                        writeToTarget(extractorInput, bArr2, i11, i10);
                        this.sampleBytesRead += i10;
                        this.nalLength.setPosition(0);
                        this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                        this.nalStartCode.setPosition(0);
                        trackOutput.sampleData(this.nalStartCode, 4);
                        this.sampleBytesWritten += 4;
                    } else {
                        int writeToOutput2 = writeToOutput(extractorInput, trackOutput, i12);
                        this.sampleBytesRead += writeToOutput2;
                        this.sampleBytesWritten += writeToOutput2;
                        this.sampleCurrentNalBytesRemaining -= writeToOutput2;
                    }
                }
            }
            if ("A_VORBIS".equals(track.codecId)) {
                this.vorbisNumPageSamples.setPosition(0);
                trackOutput.sampleData(this.vorbisNumPageSamples, 4);
                this.sampleBytesWritten += 4;
            }
            return finishWriteSampleData();
        }
    }

    private int finishWriteSampleData() {
        int i = this.sampleBytesWritten;
        resetWriteSampleData();
        return i;
    }

    private void resetWriteSampleData() {
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.sampleEncodingHandled = false;
        this.sampleSignalByteRead = false;
        this.samplePartitionCountRead = false;
        this.samplePartitionCount = 0;
        this.sampleSignalByte = 0;
        this.sampleInitializationVectorRead = false;
        this.sampleStrippedBytes.reset();
    }

    private void writeSubtitleSampleData(ExtractorInput extractorInput, byte[] bArr, int i) throws IOException {
        int length = bArr.length + i;
        if (this.subtitleSample.capacity() < length) {
            this.subtitleSample.data = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.subtitleSample.data, 0, bArr.length);
        }
        extractorInput.readFully(this.subtitleSample.data, bArr.length, i);
        this.subtitleSample.reset(length);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b  */
    private static void setSubtitleEndTime(String str, long j, byte[] bArr) {
        char c;
        int i;
        byte[] bArr2;
        int hashCode = str.hashCode();
        if (hashCode != 738597099) {
            if (hashCode == 1422270023 && str.equals("S_TEXT/UTF8")) {
                c = 0;
                if (c == 0) {
                    bArr2 = formatSubtitleTimecode(j, "%02d:%02d:%02d,%03d", 1000);
                    i = 19;
                } else if (c == 1) {
                    bArr2 = formatSubtitleTimecode(j, "%01d:%02d:%02d:%02d", 10000);
                    i = 21;
                } else {
                    throw new IllegalArgumentException();
                }
                System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
            }
        } else if (str.equals("S_TEXT/ASS")) {
            c = 1;
            if (c == 0) {
            }
            System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
        }
        c = 65535;
        if (c == 0) {
        }
        System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
    }

    private static byte[] formatSubtitleTimecode(long j, String str, long j2) {
        Assertions.checkArgument(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - (((long) (i * 3600)) * 1000000);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (((long) (i2 * 60)) * 1000000);
        int i3 = (int) (j4 / 1000000);
        return Util.getUtf8Bytes(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2))));
    }

    private void writeToTarget(ExtractorInput extractorInput, byte[] bArr, int i, int i2) throws IOException {
        int min = Math.min(i2, this.sampleStrippedBytes.bytesLeft());
        extractorInput.readFully(bArr, i + min, i2 - min);
        if (min > 0) {
            this.sampleStrippedBytes.readBytes(bArr, i, min);
        }
    }

    private int writeToOutput(ExtractorInput extractorInput, TrackOutput trackOutput, int i) throws IOException {
        int bytesLeft = this.sampleStrippedBytes.bytesLeft();
        if (bytesLeft <= 0) {
            return trackOutput.sampleData(extractorInput, i, false);
        }
        int min = Math.min(i, bytesLeft);
        trackOutput.sampleData(this.sampleStrippedBytes, min);
        return min;
    }

    private SeekMap buildSeekMap() {
        LongArray longArray;
        LongArray longArray2;
        int i;
        if (this.segmentContentPosition == -1 || this.durationUs == -9223372036854775807L || (longArray = this.cueTimesUs) == null || longArray.size() == 0 || (longArray2 = this.cueClusterPositions) == null || longArray2.size() != this.cueTimesUs.size()) {
            this.cueTimesUs = null;
            this.cueClusterPositions = null;
            return new SeekMap.Unseekable(this.durationUs);
        }
        int size = this.cueTimesUs.size();
        int[] iArr = new int[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        long[] jArr3 = new long[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            jArr3[i3] = this.cueTimesUs.get(i3);
            jArr[i3] = this.segmentContentPosition + this.cueClusterPositions.get(i3);
        }
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            int i4 = i2 + 1;
            iArr[i2] = (int) (jArr[i4] - jArr[i2]);
            jArr2[i2] = jArr3[i4] - jArr3[i2];
            i2 = i4;
        }
        iArr[i] = (int) ((this.segmentContentPosition + this.segmentContentSize) - jArr[i]);
        jArr2[i] = this.durationUs - jArr3[i];
        long j = jArr2[i];
        if (j <= 0) {
            Log.w("MatroskaExtractor", "Discarding last cue point with unexpected duration: ".concat(String.valueOf(j)));
            iArr = Arrays.copyOf(iArr, i);
            jArr = Arrays.copyOf(jArr, i);
            jArr2 = Arrays.copyOf(jArr2, i);
            jArr3 = Arrays.copyOf(jArr3, i);
        }
        this.cueTimesUs = null;
        this.cueClusterPositions = null;
        return new ChunkIndex(iArr, jArr, jArr2, jArr3);
    }

    private boolean maybeSeekForCues(PositionHolder positionHolder, long j) {
        if (this.seekForCues) {
            this.seekPositionAfterBuildingCues = j;
            positionHolder.position = this.cuesContentPosition;
            this.seekForCues = false;
            return true;
        }
        if (this.sentSeekMap) {
            long j2 = this.seekPositionAfterBuildingCues;
            if (j2 != -1) {
                positionHolder.position = j2;
                this.seekPositionAfterBuildingCues = -1;
                return true;
            }
        }
        return false;
    }

    private long scaleTimecodeToUs(long j) throws ParserException {
        long j2 = this.timecodeScale;
        if (j2 != -9223372036854775807L) {
            return Util.scaleLargeTimestamp(j, j2, 1000);
        }
        throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
    }

    private static boolean isCodecSupported(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_AV1".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str);
    }

    private static int[] ensureArrayCapacity(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        if (iArr.length >= i) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i)];
    }

    final class InnerEbmlProcessor implements EbmlProcessor {
        private InnerEbmlProcessor() {
        }

        public final int getElementType(int i) {
            return MatroskaExtractor.this.getElementType(i);
        }

        public final boolean isLevel1Element(int i) {
            return MatroskaExtractor.this.isLevel1Element(i);
        }

        public final void startMasterElement(int i, long j, long j2) throws ParserException {
            MatroskaExtractor.this.startMasterElement(i, j, j2);
        }

        public final void endMasterElement(int i) throws ParserException {
            MatroskaExtractor.this.endMasterElement(i);
        }

        public final void integerElement(int i, long j) throws ParserException {
            MatroskaExtractor.this.integerElement(i, j);
        }

        public final void floatElement(int i, double d) throws ParserException {
            MatroskaExtractor.this.floatElement(i, d);
        }

        public final void stringElement(int i, String str) throws ParserException {
            MatroskaExtractor.this.stringElement(i, str);
        }

        public final void binaryElement(int i, int i2, ExtractorInput extractorInput) throws IOException {
            MatroskaExtractor.this.binaryElement(i, i2, extractorInput);
        }
    }

    static final class TrueHdSampleRechunker {
        private int chunkFlags;
        private int chunkOffset;
        private int chunkSampleCount;
        private int chunkSize;
        private long chunkTimeUs;
        private boolean foundSyncframe;
        private final byte[] syncframePrefix = new byte[10];

        public final void reset() {
            this.foundSyncframe = false;
            this.chunkSampleCount = 0;
        }

        public final void startSample(ExtractorInput extractorInput) throws IOException {
            if (!this.foundSyncframe) {
                extractorInput.peekFully(this.syncframePrefix, 0, 10);
                extractorInput.resetPeekPosition();
                if (Ac3Util.parseTrueHdSyncframeAudioSampleCount(this.syncframePrefix) != 0) {
                    this.foundSyncframe = true;
                }
            }
        }

        public final void sampleMetadata(Track track, long j, int i, int i2, int i3) {
            if (this.foundSyncframe) {
                int i4 = this.chunkSampleCount;
                this.chunkSampleCount = i4 + 1;
                if (i4 == 0) {
                    this.chunkTimeUs = j;
                    this.chunkFlags = i;
                    this.chunkSize = 0;
                }
                this.chunkSize += i2;
                this.chunkOffset = i3;
                if (this.chunkSampleCount >= 16) {
                    outputPendingSampleMetadata(track);
                }
            }
        }

        public final void outputPendingSampleMetadata(Track track) {
            if (this.chunkSampleCount > 0) {
                track.output.sampleMetadata(this.chunkTimeUs, this.chunkFlags, this.chunkSize, this.chunkOffset, track.cryptoData);
                this.chunkSampleCount = 0;
            }
        }
    }

    static final class Track {
        public int audioBitDepth;
        public int channelCount;
        public long codecDelayNs;
        public String codecId;
        public byte[] codecPrivate;
        public int colorRange;
        public int colorSpace;
        public int colorTransfer;
        public TrackOutput.CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public int displayHeight;
        public int displayUnit;
        public int displayWidth;
        public DrmInitData drmInitData;
        public boolean flagDefault;
        public boolean flagForced;
        public boolean hasColorInfo;
        public boolean hasContentEncryption;
        public int height;
        public String language;
        public int maxBlockAdditionId;
        public int maxContentLuminance;
        public int maxFrameAverageLuminance;
        public float maxMasteringLuminance;
        public float minMasteringLuminance;
        public int nalUnitLengthFieldLength;
        public String name;
        public int number;
        public TrackOutput output;
        public float primaryBChromaticityX;
        public float primaryBChromaticityY;
        public float primaryGChromaticityX;
        public float primaryGChromaticityY;
        public float primaryRChromaticityX;
        public float primaryRChromaticityY;
        public byte[] projectionData;
        public float projectionPosePitch;
        public float projectionPoseRoll;
        public float projectionPoseYaw;
        public int projectionType;
        public int sampleRate;
        public byte[] sampleStrippedBytes;
        public long seekPreRollNs;
        public int stereoMode;
        public TrueHdSampleRechunker trueHdSampleRechunker;
        public int type;
        public float whitePointChromaticityX;
        public float whitePointChromaticityY;
        public int width;

        private Track() {
            this.width = -1;
            this.height = -1;
            this.displayWidth = -1;
            this.displayHeight = -1;
            this.displayUnit = 0;
            this.projectionType = -1;
            this.projectionPoseYaw = 0.0f;
            this.projectionPosePitch = 0.0f;
            this.projectionPoseRoll = 0.0f;
            this.projectionData = null;
            this.stereoMode = -1;
            this.hasColorInfo = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.maxContentLuminance = 1000;
            this.maxFrameAverageLuminance = 200;
            this.primaryRChromaticityX = -1.0f;
            this.primaryRChromaticityY = -1.0f;
            this.primaryGChromaticityX = -1.0f;
            this.primaryGChromaticityY = -1.0f;
            this.primaryBChromaticityX = -1.0f;
            this.primaryBChromaticityY = -1.0f;
            this.whitePointChromaticityX = -1.0f;
            this.whitePointChromaticityY = -1.0f;
            this.maxMasteringLuminance = -1.0f;
            this.minMasteringLuminance = -1.0f;
            this.channelCount = 1;
            this.audioBitDepth = -1;
            this.sampleRate = 8000;
            this.codecDelayNs = 0;
            this.seekPreRollNs = 0;
            this.flagDefault = true;
            this.language = "eng";
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void initializeOutput(ExtractorOutput extractorOutput, int i) throws ParserException {
            char c;
            List list;
            int i2;
            String str;
            int i3;
            int i4;
            int i5;
            List list2;
            String str2;
            String str3;
            List list3;
            String str4;
            List list4;
            int pcmEncoding;
            String str5 = this.codecId;
            int i6 = 0;
            int i7 = 3;
            switch (str5.hashCode()) {
                case -2095576542:
                    if (str5.equals("V_MPEG4/ISO/AP")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -2095575984:
                    if (str5.equals("V_MPEG4/ISO/SP")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1985379776:
                    if (str5.equals("A_MS/ACM")) {
                        c = 23;
                        break;
                    }
                    c = 65535;
                    break;
                case -1784763192:
                    if (str5.equals("A_TRUEHD")) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case -1730367663:
                    if (str5.equals("A_VORBIS")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -1482641358:
                    if (str5.equals("A_MPEG/L2")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case -1482641357:
                    if (str5.equals("A_MPEG/L3")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case -1373388978:
                    if (str5.equals("V_MS/VFW/FOURCC")) {
                        c = 9;
                        break;
                    }
                    c = 65535;
                    break;
                case -933872740:
                    if (str5.equals("S_DVBSUB")) {
                        c = 29;
                        break;
                    }
                    c = 65535;
                    break;
                case -538363189:
                    if (str5.equals("V_MPEG4/ISO/ASP")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -538363109:
                    if (str5.equals("V_MPEG4/ISO/AVC")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -425012669:
                    if (str5.equals("S_VOBSUB")) {
                        c = 27;
                        break;
                    }
                    c = 65535;
                    break;
                case -356037306:
                    if (str5.equals("A_DTS/LOSSLESS")) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case 62923557:
                    if (str5.equals("A_AAC")) {
                        c = 13;
                        break;
                    }
                    c = 65535;
                    break;
                case 62923603:
                    if (str5.equals("A_AC3")) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 62927045:
                    if (str5.equals("A_DTS")) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case 82318131:
                    if (str5.equals("V_AV1")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 82338133:
                    if (str5.equals("V_VP8")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 82338134:
                    if (str5.equals("V_VP9")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 99146302:
                    if (str5.equals("S_HDMV/PGS")) {
                        c = 28;
                        break;
                    }
                    c = 65535;
                    break;
                case 444813526:
                    if (str5.equals("V_THEORA")) {
                        c = 10;
                        break;
                    }
                    c = 65535;
                    break;
                case 542569478:
                    if (str5.equals("A_DTS/EXPRESS")) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case 725957860:
                    if (str5.equals("A_PCM/INT/LIT")) {
                        c = 24;
                        break;
                    }
                    c = 65535;
                    break;
                case 738597099:
                    if (str5.equals("S_TEXT/ASS")) {
                        c = 26;
                        break;
                    }
                    c = 65535;
                    break;
                case 855502857:
                    if (str5.equals("V_MPEGH/ISO/HEVC")) {
                        c = 8;
                        break;
                    }
                    c = 65535;
                    break;
                case 1422270023:
                    if (str5.equals("S_TEXT/UTF8")) {
                        c = 25;
                        break;
                    }
                    c = 65535;
                    break;
                case 1809237540:
                    if (str5.equals("V_MPEG2")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1950749482:
                    if (str5.equals("A_EAC3")) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case 1950789798:
                    if (str5.equals("A_FLAC")) {
                        c = 22;
                        break;
                    }
                    c = 65535;
                    break;
                case 1951062397:
                    if (str5.equals("A_OPUS")) {
                        c = 12;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            int i8 = 4096;
            ColorInfo colorInfo = null;
            switch (c) {
                case 0:
                    str3 = "video/x-vnd.on2.vp8";
                    list2 = null;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 1:
                    str3 = "video/x-vnd.on2.vp9";
                    list2 = null;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 2:
                    str3 = "video/av01";
                    list2 = null;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 3:
                    str3 = "video/mpeg2";
                    list2 = null;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 4:
                case 5:
                case 6:
                    byte[] bArr = this.codecPrivate;
                    if (bArr == null) {
                        list3 = null;
                    } else {
                        list3 = Collections.singletonList(bArr);
                    }
                    str4 = "video/mp4v-es";
                    list2 = list3;
                    str2 = str4;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 7:
                    AvcConfig parse = AvcConfig.parse(new ParsableByteArray(this.codecPrivate));
                    list4 = parse.initializationData;
                    this.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                    str2 = "video/avc";
                    list2 = list4;
                    i2 = -1;
                    i8 = -1;
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    HevcConfig parse2 = HevcConfig.parse(new ParsableByteArray(this.codecPrivate));
                    list4 = parse2.initializationData;
                    this.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                    str2 = "video/hevc";
                    list2 = list4;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 9:
                    Pair<String, List<byte[]>> parseFourCcPrivate = parseFourCcPrivate(new ParsableByteArray(this.codecPrivate));
                    str4 = (String) parseFourCcPrivate.first;
                    list3 = (List) parseFourCcPrivate.second;
                    list2 = list3;
                    str2 = str4;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 10:
                    str3 = "video/x-unknown";
                    list2 = null;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 11:
                    str = "audio/vorbis";
                    i8 = 8192;
                    list = parseVorbisCodecPrivate(this.codecPrivate);
                    i2 = -1;
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    list = new ArrayList(3);
                    list.add(this.codecPrivate);
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.codecDelayNs).array());
                    list.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.seekPreRollNs).array());
                    str = "audio/opus";
                    i2 = -1;
                    i8 = 5760;
                    break;
                case 13:
                    list3 = Collections.singletonList(this.codecPrivate);
                    str4 = "audio/mp4a-latm";
                    list2 = list3;
                    str2 = str4;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 14:
                    str = "audio/mpeg-L2";
                    list = null;
                    i2 = -1;
                    break;
                case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                    str = "audio/mpeg";
                    list = null;
                    i2 = -1;
                    break;
                case 16:
                    str3 = "audio/ac3";
                    list2 = null;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 17:
                    str3 = "audio/eac3";
                    list2 = null;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 18:
                    this.trueHdSampleRechunker = new TrueHdSampleRechunker();
                    str3 = "audio/true-hd";
                    list2 = null;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 19:
                case 20:
                    str3 = "audio/vnd.dts";
                    list2 = null;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 21:
                    str3 = "audio/vnd.dts.hd";
                    list2 = null;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 22:
                    list3 = Collections.singletonList(this.codecPrivate);
                    str4 = "audio/flac";
                    list2 = list3;
                    str2 = str4;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 23:
                    if (parseMsAcmCodecPrivate(new ParsableByteArray(this.codecPrivate))) {
                        pcmEncoding = Util.getPcmEncoding(this.audioBitDepth);
                        if (pcmEncoding == 0) {
                            Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to " + "audio/x-unknown");
                        }
                        i2 = pcmEncoding;
                        str2 = "audio/raw";
                        list2 = null;
                        i8 = -1;
                        break;
                    } else {
                        Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat("audio/x-unknown"));
                    }
                    str3 = "audio/x-unknown";
                    list2 = null;
                    i2 = -1;
                    i8 = -1;
                case 24:
                    pcmEncoding = Util.getPcmEncoding(this.audioBitDepth);
                    if (pcmEncoding == 0) {
                        Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to " + "audio/x-unknown");
                        str3 = "audio/x-unknown";
                        list2 = null;
                        i2 = -1;
                        i8 = -1;
                        break;
                    }
                    i2 = pcmEncoding;
                    str2 = "audio/raw";
                    list2 = null;
                    i8 = -1;
                case 25:
                    str3 = "application/x-subrip";
                    list2 = null;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 26:
                    str3 = "text/x-ssa";
                    list2 = null;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 27:
                    list2 = Collections.singletonList(this.codecPrivate);
                    str2 = "application/vobsub";
                    i2 = -1;
                    i8 = -1;
                    break;
                case 28:
                    str3 = "application/pgs";
                    list2 = null;
                    i2 = -1;
                    i8 = -1;
                    break;
                case 29:
                    byte[] bArr2 = this.codecPrivate;
                    list3 = Collections.singletonList(new byte[]{bArr2[0], bArr2[1], bArr2[2], bArr2[3]});
                    str4 = "application/dvbsubs";
                    list2 = list3;
                    str2 = str4;
                    i2 = -1;
                    i8 = -1;
                    break;
                default:
                    throw new ParserException("Unrecognized codec identifier.");
            }
            boolean z = this.flagDefault | false | (this.flagForced ? (char) 2 : 0);
            Format.Builder builder = new Format.Builder();
            if (MimeTypes.isAudio(str)) {
                builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i2);
                i3 = i;
                i7 = 1;
            } else if (MimeTypes.isVideo(str)) {
                if (this.displayUnit == 0) {
                    int i9 = this.displayWidth;
                    if (i9 == -1) {
                        i9 = this.width;
                    }
                    this.displayWidth = i9;
                    int i10 = this.displayHeight;
                    if (i10 == -1) {
                        i10 = this.height;
                    }
                    this.displayHeight = i10;
                }
                float f = -1.0f;
                int i11 = this.displayWidth;
                if (!(i11 == -1 || (i5 = this.displayHeight) == -1)) {
                    f = ((float) (this.height * i11)) / ((float) (this.width * i5));
                }
                if (this.hasColorInfo) {
                    colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                }
                if ("htc_video_rotA-000".equals(this.name)) {
                    i4 = 0;
                } else if ("htc_video_rotA-090".equals(this.name)) {
                    i4 = 90;
                } else if ("htc_video_rotA-180".equals(this.name)) {
                    i4 = 180;
                } else {
                    i4 = "htc_video_rotA-270".equals(this.name) ? 270 : -1;
                }
                if (this.projectionType == 0 && Float.compare(this.projectionPoseYaw, 0.0f) == 0 && Float.compare(this.projectionPosePitch, 0.0f) == 0) {
                    if (Float.compare(this.projectionPoseRoll, 0.0f) != 0) {
                        if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                            i6 = 90;
                        } else if (Float.compare(this.projectionPosePitch, -180.0f) == 0 || Float.compare(this.projectionPosePitch, 180.0f) == 0) {
                            i6 = 180;
                        } else if (Float.compare(this.projectionPosePitch, -90.0f) == 0) {
                            i6 = 270;
                        }
                    }
                    builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i6).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                    i3 = i;
                    i7 = 2;
                }
                i6 = i4;
                builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i6).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                i3 = i;
                i7 = 2;
            } else {
                if (!"application/x-subrip".equals(str)) {
                    if ("text/x-ssa".equals(str)) {
                        list = new ArrayList(2);
                        list.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                        list.add(this.codecPrivate);
                    } else if (!"application/vobsub".equals(str) && !"application/pgs".equals(str) && !"application/dvbsubs".equals(str)) {
                        throw new ParserException("Unexpected MIME type.");
                    }
                }
                i3 = i;
            }
            Format build = builder.setId(i3).setSampleMimeType(str).setMaxInputSize(i8).setLanguage(this.language).setSelectionFlags(z ? 1 : 0).setInitializationData(list).setDrmInitData(this.drmInitData).build();
            this.output = extractorOutput.track(this.number, i7);
            this.output.format(build);
        }

        public final void outputPendingSampleMetadata() {
            TrueHdSampleRechunker trueHdSampleRechunker2 = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker2 != null) {
                trueHdSampleRechunker2.outputPendingSampleMetadata(this);
            }
        }

        public final void reset() {
            TrueHdSampleRechunker trueHdSampleRechunker2 = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker2 != null) {
                trueHdSampleRechunker2.reset();
            }
        }

        private byte[] getHdrStaticInfo() {
            if (this.primaryRChromaticityX == -1.0f || this.primaryRChromaticityY == -1.0f || this.primaryGChromaticityX == -1.0f || this.primaryGChromaticityY == -1.0f || this.primaryBChromaticityX == -1.0f || this.primaryBChromaticityY == -1.0f || this.whitePointChromaticityX == -1.0f || this.whitePointChromaticityY == -1.0f || this.maxMasteringLuminance == -1.0f || this.minMasteringLuminance == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((int) ((this.primaryRChromaticityX * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.primaryRChromaticityY * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.primaryGChromaticityX * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.primaryGChromaticityY * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.primaryBChromaticityX * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.primaryBChromaticityY * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.whitePointChromaticityX * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.whitePointChromaticityY * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) (this.maxMasteringLuminance + 0.5f)));
            order.putShort((short) ((int) (this.minMasteringLuminance + 0.5f)));
            order.putShort((short) this.maxContentLuminance);
            order.putShort((short) this.maxFrameAverageLuminance);
            return bArr;
        }

        private static Pair<String, List<byte[]>> parseFourCcPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                parsableByteArray.skipBytes(16);
                long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
                if (readLittleEndianUnsignedInt == 1482049860) {
                    return new Pair<>("video/divx", null);
                }
                if (readLittleEndianUnsignedInt == 859189832) {
                    return new Pair<>("video/3gpp", null);
                }
                if (readLittleEndianUnsignedInt == 826496599) {
                    byte[] bArr = parsableByteArray.data;
                    for (int position = parsableByteArray.getPosition() + 20; position < bArr.length - 4; position++) {
                        if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                            return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length)));
                        }
                    }
                    throw new ParserException("Failed to find FourCC VC1 initialization data");
                }
                Log.w("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>("video/x-unknown", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing FourCC private data");
            }
        }

        private static List<byte[]> parseVorbisCodecPrivate(byte[] bArr) throws ParserException {
            try {
                if (bArr[0] == 2) {
                    int i = 1;
                    int i2 = 0;
                    while (bArr[i] == -1) {
                        i2 += 255;
                        i++;
                    }
                    int i3 = i + 1;
                    int i4 = i2 + bArr[i];
                    int i5 = 0;
                    while (bArr[i3] == -1) {
                        i5 += 255;
                        i3++;
                    }
                    int i6 = i3 + 1;
                    int i7 = i5 + bArr[i3];
                    if (bArr[i6] == 1) {
                        byte[] bArr2 = new byte[i4];
                        System.arraycopy(bArr, i6, bArr2, 0, i4);
                        int i8 = i6 + i4;
                        if (bArr[i8] == 3) {
                            int i9 = i8 + i7;
                            if (bArr[i9] == 5) {
                                byte[] bArr3 = new byte[(bArr.length - i9)];
                                System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw new ParserException("Error parsing vorbis codec private");
                        }
                        throw new ParserException("Error parsing vorbis codec private");
                    }
                    throw new ParserException("Error parsing vorbis codec private");
                }
                throw new ParserException("Error parsing vorbis codec private");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing vorbis codec private");
            }
        }

        private static boolean parseMsAcmCodecPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                if (readLittleEndianUnsignedShort == 1) {
                    return true;
                }
                if (readLittleEndianUnsignedShort == 65534) {
                    parsableByteArray.setPosition(24);
                    return parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getMostSignificantBits() && parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getLeastSignificantBits();
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing MS/ACM codec private");
            }
        }
    }
}
