package com.google.android.exoplayer2.extractor.ts;

import android.support.v4.app.NotificationCompat;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {
    private final List<Format> closedCaptionFormats;
    private final int flags;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    public DefaultTsPayloadReaderFactory(int i) {
        this(i, Collections.singletonList(new Format.Builder().setSampleMimeType("application/cea-608").build()));
    }

    public DefaultTsPayloadReaderFactory(int i, List<Format> list) {
        this.flags = i;
        this.closedCaptionFormats = list;
    }

    public final SparseArray<TsPayloadReader> createInitialPayloadReaders() {
        return new SparseArray<>();
    }

    public final TsPayloadReader createPayloadReader(int i, TsPayloadReader.EsInfo esInfo) {
        if (i == 2) {
            return new PesReader(new H262Reader(buildUserDataReader(esInfo)));
        }
        if (i == 3 || i == 4) {
            return new PesReader(new MpegAudioReader(esInfo.language));
        }
        if (i != 15) {
            if (i != 17) {
                if (i == 21) {
                    return new PesReader(new Id3Reader());
                }
                if (i != 27) {
                    if (i == 36) {
                        return new PesReader(new H265Reader(buildSeiReader(esInfo)));
                    }
                    if (i == 89) {
                        return new PesReader(new DvbSubtitleReader(esInfo.dvbSubtitleInfos));
                    }
                    if (i != 138) {
                        if (i == 172) {
                            return new PesReader(new Ac4Reader(esInfo.language));
                        }
                        if (i == 257) {
                            return new SectionReader(new PassthroughSectionPayloadReader("application/vnd.dvb.ait"));
                        }
                        if (i != 129) {
                            if (i != 130) {
                                if (i != 134) {
                                    if (i != 135) {
                                        return null;
                                    }
                                } else if (isSet(16)) {
                                    return null;
                                } else {
                                    return new SectionReader(new PassthroughSectionPayloadReader("application/x-scte35"));
                                }
                            } else if (!isSet(64)) {
                                return null;
                            }
                        }
                        return new PesReader(new Ac3Reader(esInfo.language));
                    }
                    return new PesReader(new DtsReader(esInfo.language));
                } else if (isSet(4)) {
                    return null;
                } else {
                    return new PesReader(new H264Reader(buildSeiReader(esInfo), isSet(1), isSet(8)));
                }
            } else if (isSet(2)) {
                return null;
            } else {
                return new PesReader(new LatmReader(esInfo.language));
            }
        } else if (isSet(2)) {
            return null;
        } else {
            return new PesReader(new AdtsReader(false, esInfo.language));
        }
    }

    private SeiReader buildSeiReader(TsPayloadReader.EsInfo esInfo) {
        return new SeiReader(getClosedCaptionFormats(esInfo));
    }

    private UserDataReader buildUserDataReader(TsPayloadReader.EsInfo esInfo) {
        return new UserDataReader(getClosedCaptionFormats(esInfo));
    }

    private List<Format> getClosedCaptionFormats(TsPayloadReader.EsInfo esInfo) {
        String str;
        int i;
        if (isSet(32)) {
            return this.closedCaptionFormats;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.descriptorBytes);
        List<Format> list = this.closedCaptionFormats;
        while (parsableByteArray.bytesLeft() > 0) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
            if (readUnsignedByte == 134) {
                list = new ArrayList<>();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i2 = 0; i2 < readUnsignedByte2; i2++) {
                    String readString = parsableByteArray.readString(3);
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    boolean z = true;
                    boolean z2 = (readUnsignedByte3 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0;
                    if (z2) {
                        i = readUnsignedByte3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte readUnsignedByte4 = (byte) parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(1);
                    List<byte[]> list2 = null;
                    if (z2) {
                        if ((readUnsignedByte4 & 64) == 0) {
                            z = false;
                        }
                        list2 = CodecSpecificDataUtil.buildCea708InitializationData(z);
                    }
                    list.add(new Format.Builder().setSampleMimeType(str).setLanguage(readString).setAccessibilityChannel(i).setInitializationData(list2).build());
                }
            }
            parsableByteArray.setPosition(position);
        }
        return list;
    }

    private boolean isSet(int i) {
        return (i & this.flags) != 0;
    }
}
