package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import _m_j.jkx;
import _m_j.jla;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@Descriptor(objectTypeIndication = 64, tags = {5})
public class AudioSpecificConfig extends BaseDescriptor {
    public static Map<Integer, String> audioObjectTypeMap = new HashMap();
    public static Map<Integer, Integer> samplingFrequencyIndexMap = new HashMap();
    public boolean aacScalefactorDataResilienceFlag;
    public boolean aacSectionDataResilienceFlag;
    public boolean aacSpectralDataResilienceFlag;
    public int audioObjectType;
    public int channelConfiguration;
    byte[] configBytes;
    public int coreCoderDelay;
    public int dependsOnCoreCoder;
    public int directMapping;
    public ELDSpecificConfig eldSpecificConfig;
    public int epConfig;
    public int erHvxcExtensionFlag;
    public int extensionAudioObjectType;
    public int extensionChannelConfiguration;
    public int extensionFlag;
    public int extensionFlag3;
    public int extensionSamplingFrequency;
    public int extensionSamplingFrequencyIndex = -1;
    public int fillBits;
    public int frameLengthFlag;
    public boolean gaSpecificConfig;
    public int hilnContMode;
    public int hilnEnhaLayer;
    public int hilnEnhaQuantMode;
    public int hilnFrameLength;
    public int hilnMaxNumLine;
    public int hilnQuantMode;
    public int hilnSampleRateCode;
    public int hvxcRateMode;
    public int hvxcVarMode;
    public int innerSyncExtensionType = -1;
    public int isBaseLayer;
    public int layerNr;
    public int layer_length;
    public int numOfSubFrame;
    public int origExtensionAudioObjectType;
    public int originalAudioObjectType;
    public int outerSyncExtensionType = -1;
    public int paraExtensionFlag;
    public int paraMode;
    public boolean parametricSpecificConfig;
    boolean parsed = false;
    public boolean psPresentFlag;
    public int sacPayloadEmbedding;
    public int samplingFrequency;
    public int samplingFrequencyIndex;
    public boolean sbrPresentFlag;
    public int syncExtensionType = -1;
    public int var_ScalableFlag;

    static {
        samplingFrequencyIndexMap.put(0, 96000);
        samplingFrequencyIndexMap.put(1, 88200);
        samplingFrequencyIndexMap.put(2, 64000);
        samplingFrequencyIndexMap.put(3, 48000);
        samplingFrequencyIndexMap.put(4, 44100);
        samplingFrequencyIndexMap.put(5, 32000);
        samplingFrequencyIndexMap.put(6, 24000);
        samplingFrequencyIndexMap.put(7, 22050);
        samplingFrequencyIndexMap.put(8, 16000);
        samplingFrequencyIndexMap.put(9, 12000);
        samplingFrequencyIndexMap.put(10, 11025);
        samplingFrequencyIndexMap.put(11, 8000);
        audioObjectTypeMap.put(1, "AAC main");
        audioObjectTypeMap.put(2, "AAC LC");
        audioObjectTypeMap.put(3, "AAC SSR");
        audioObjectTypeMap.put(4, "AAC LTP");
        audioObjectTypeMap.put(5, "SBR");
        audioObjectTypeMap.put(6, "AAC Scalable");
        audioObjectTypeMap.put(7, "TwinVQ");
        audioObjectTypeMap.put(8, "CELP");
        audioObjectTypeMap.put(9, "HVXC");
        audioObjectTypeMap.put(10, "(reserved)");
        audioObjectTypeMap.put(11, "(reserved)");
        audioObjectTypeMap.put(12, "TTSI");
        audioObjectTypeMap.put(13, "Main synthetic");
        audioObjectTypeMap.put(14, "Wavetable synthesis");
        audioObjectTypeMap.put(15, "General MIDI");
        audioObjectTypeMap.put(16, "Algorithmic Synthesis and Audio FX");
        audioObjectTypeMap.put(17, "ER AAC LC");
        audioObjectTypeMap.put(18, "(reserved)");
        audioObjectTypeMap.put(19, "ER AAC LTP");
        audioObjectTypeMap.put(20, "ER AAC Scalable");
        audioObjectTypeMap.put(21, "ER TwinVQ");
        audioObjectTypeMap.put(22, "ER BSAC");
        audioObjectTypeMap.put(23, "ER AAC LD");
        audioObjectTypeMap.put(24, "ER CELP");
        audioObjectTypeMap.put(25, "ER HVXC");
        audioObjectTypeMap.put(26, "ER HILN");
        audioObjectTypeMap.put(27, "ER Parametric");
        audioObjectTypeMap.put(28, "SSC");
        audioObjectTypeMap.put(29, "PS");
        audioObjectTypeMap.put(30, "MPEG Surround");
        audioObjectTypeMap.put(31, "(escape)");
        audioObjectTypeMap.put(32, "Layer-1");
        audioObjectTypeMap.put(33, "Layer-2");
        audioObjectTypeMap.put(34, "Layer-3");
        audioObjectTypeMap.put(35, "DST");
        audioObjectTypeMap.put(36, "ALS");
        audioObjectTypeMap.put(37, "SLS");
        audioObjectTypeMap.put(38, "SLS non-core");
        audioObjectTypeMap.put(39, "ER AAC ELD");
        audioObjectTypeMap.put(40, "SMR Simple");
        audioObjectTypeMap.put(41, "SMR Main");
    }

    public AudioSpecificConfig() {
        this.tag = 5;
    }

    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        this.parsed = true;
        ByteBuffer slice = byteBuffer.slice();
        slice.limit(this.sizeOfInstance);
        byteBuffer.position(byteBuffer.position() + this.sizeOfInstance);
        this.configBytes = new byte[this.sizeOfInstance];
        slice.get(this.configBytes);
        slice.rewind();
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(slice);
        int audioObjectType2 = getAudioObjectType(bitReaderBuffer);
        this.audioObjectType = audioObjectType2;
        this.originalAudioObjectType = audioObjectType2;
        this.samplingFrequencyIndex = bitReaderBuffer.readBits(4);
        if (this.samplingFrequencyIndex == 15) {
            this.samplingFrequency = bitReaderBuffer.readBits(24);
        }
        this.channelConfiguration = bitReaderBuffer.readBits(4);
        int i = this.audioObjectType;
        if (i == 5 || i == 29) {
            this.extensionAudioObjectType = 5;
            this.sbrPresentFlag = true;
            if (this.audioObjectType == 29) {
                this.psPresentFlag = true;
            }
            this.extensionSamplingFrequencyIndex = bitReaderBuffer.readBits(4);
            if (this.extensionSamplingFrequencyIndex == 15) {
                this.extensionSamplingFrequency = bitReaderBuffer.readBits(24);
            }
            this.audioObjectType = getAudioObjectType(bitReaderBuffer);
            if (this.audioObjectType == 22) {
                this.extensionChannelConfiguration = bitReaderBuffer.readBits(4);
            }
        } else {
            this.extensionAudioObjectType = 0;
        }
        int i2 = this.audioObjectType;
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                parseGaSpecificConfig(this.samplingFrequencyIndex, this.channelConfiguration, i2, bitReaderBuffer);
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                throw new UnsupportedOperationException("can't parse CelpSpecificConfig yet");
            case 9:
                throw new UnsupportedOperationException("can't parse HvxcSpecificConfig yet");
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                throw new UnsupportedOperationException("can't parse TTSSpecificConfig yet");
            case 13:
            case 14:
            case GmsLogger.MAX_PII_TAG_LENGTH:
            case 16:
                throw new UnsupportedOperationException("can't parse StructuredAudioSpecificConfig yet");
            case 24:
                throw new UnsupportedOperationException("can't parse ErrorResilientCelpSpecificConfig yet");
            case 25:
                throw new UnsupportedOperationException("can't parse ErrorResilientHvxcSpecificConfig yet");
            case 26:
            case 27:
                parseParametricSpecificConfig(this.samplingFrequencyIndex, this.channelConfiguration, i2, bitReaderBuffer);
                break;
            case 28:
                throw new UnsupportedOperationException("can't parse SSCSpecificConfig yet");
            case 30:
                this.sacPayloadEmbedding = bitReaderBuffer.readBits(1);
                throw new UnsupportedOperationException("can't parse SpatialSpecificConfig yet");
            case 32:
            case 33:
            case 34:
                throw new UnsupportedOperationException("can't parse MPEG_1_2_SpecificConfig yet");
            case 35:
                throw new UnsupportedOperationException("can't parse DSTSpecificConfig yet");
            case 36:
                this.fillBits = bitReaderBuffer.readBits(5);
                throw new UnsupportedOperationException("can't parse ALSSpecificConfig yet");
            case 37:
            case 38:
                throw new UnsupportedOperationException("can't parse SLSSpecificConfig yet");
            case 39:
                this.eldSpecificConfig = new ELDSpecificConfig(this.channelConfiguration, bitReaderBuffer);
                break;
            case 40:
            case 41:
                throw new UnsupportedOperationException("can't parse SymbolicMusicSpecificConfig yet");
        }
        int i3 = this.audioObjectType;
        if (!(i3 == 17 || i3 == 39)) {
            switch (i3) {
            }
            if (this.extensionAudioObjectType != 5 && bitReaderBuffer.remainingBits() >= 16) {
                int readBits = bitReaderBuffer.readBits(11);
                this.syncExtensionType = readBits;
                this.outerSyncExtensionType = readBits;
                if (this.syncExtensionType == 695) {
                    this.extensionAudioObjectType = getAudioObjectType(bitReaderBuffer);
                    if (this.extensionAudioObjectType == 5) {
                        this.sbrPresentFlag = bitReaderBuffer.readBool();
                        if (this.sbrPresentFlag) {
                            this.extensionSamplingFrequencyIndex = bitReaderBuffer.readBits(4);
                            if (this.extensionSamplingFrequencyIndex == 15) {
                                this.extensionSamplingFrequency = bitReaderBuffer.readBits(24);
                            }
                            if (bitReaderBuffer.remainingBits() >= 12) {
                                int readBits2 = bitReaderBuffer.readBits(11);
                                this.syncExtensionType = readBits2;
                                this.innerSyncExtensionType = readBits2;
                                if (this.syncExtensionType == 1352) {
                                    this.psPresentFlag = bitReaderBuffer.readBool();
                                }
                            }
                        }
                    }
                    if (this.extensionAudioObjectType == 22) {
                        this.sbrPresentFlag = bitReaderBuffer.readBool();
                        if (this.sbrPresentFlag) {
                            this.extensionSamplingFrequencyIndex = bitReaderBuffer.readBits(4);
                            if (this.extensionSamplingFrequencyIndex == 15) {
                                this.extensionSamplingFrequency = bitReaderBuffer.readBits(24);
                            }
                        }
                        this.extensionChannelConfiguration = bitReaderBuffer.readBits(4);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        this.epConfig = bitReaderBuffer.readBits(2);
        int i4 = this.epConfig;
        if (i4 == 2 || i4 == 3) {
            throw new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
        }
        if (i4 == 3) {
            this.directMapping = bitReaderBuffer.readBits(1);
            if (this.directMapping == 0) {
                throw new RuntimeException("not implemented");
            }
        }
        if (this.extensionAudioObjectType != 5) {
        }
    }

    private int gaSpecificConfigSize() {
        int i = (this.dependsOnCoreCoder == 1 ? 16 : 2) + 1;
        if (this.channelConfiguration != 0) {
            int i2 = this.audioObjectType;
            if (i2 == 6 || i2 == 20) {
                i += 3;
            }
            if (this.extensionFlag == 1) {
                if (this.audioObjectType == 22) {
                    i = i + 5 + 11;
                }
                int i3 = this.audioObjectType;
                if (i3 == 17 || i3 == 19 || i3 == 20 || i3 == 23) {
                    i = i + 1 + 1 + 1;
                }
                i++;
                if (this.extensionFlag3 == 1) {
                    throw new RuntimeException("Not implemented");
                }
            }
            return i;
        }
        throw new UnsupportedOperationException("can't parse program_config_element yet");
    }

    /* access modifiers changed from: protected */
    public int getContentSize() {
        int i;
        int i2 = (this.originalAudioObjectType > 30 ? 11 : 5) + 4;
        if (this.samplingFrequencyIndex == 15) {
            i2 += 24;
        }
        int i3 = i2 + 4;
        int i4 = this.audioObjectType;
        if (i4 == 5 || i4 == 29) {
            i3 += 4;
            if (this.extensionSamplingFrequencyIndex == 15) {
                i3 += 24;
            }
        }
        if (this.audioObjectType == 22) {
            i3 += 4;
        }
        if (this.gaSpecificConfig) {
            i3 += gaSpecificConfigSize();
        }
        int i5 = this.outerSyncExtensionType;
        if (i5 >= 0) {
            i += 11;
            if (i5 == 695) {
                int i6 = i + 5;
                if (this.extensionAudioObjectType > 30) {
                    i6 += 6;
                }
                if (this.extensionAudioObjectType == 5) {
                    i++;
                    if (this.sbrPresentFlag) {
                        i += 4;
                        if (this.extensionSamplingFrequencyIndex == 15) {
                            i += 24;
                        }
                        int i7 = this.innerSyncExtensionType;
                        if (i7 >= 0) {
                            i += 11;
                            if (i7 == 1352) {
                                i++;
                            }
                        }
                    }
                }
                if (this.extensionAudioObjectType == 22) {
                    int i8 = i + 1;
                    if (this.sbrPresentFlag) {
                        i8 += 4;
                        if (this.extensionSamplingFrequencyIndex == 15) {
                            i8 += 24;
                        }
                    }
                    i = i8 + 4;
                }
            }
        }
        double d = (double) i;
        Double.isNaN(d);
        return (int) Math.ceil(d / 8.0d);
    }

    public ByteBuffer serialize() {
        ByteBuffer allocate = ByteBuffer.allocate(getSize());
        jla.O00000o(allocate, this.tag);
        writeSize(allocate, getContentSize());
        allocate.put(serializeConfigBytes());
        return (ByteBuffer) allocate.rewind();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011d  */
    public ByteBuffer serializeConfigBytes() {
        int i;
        ByteBuffer wrap = ByteBuffer.wrap(new byte[getContentSize()]);
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(wrap);
        writeAudioObjectType(this.originalAudioObjectType, bitWriterBuffer);
        bitWriterBuffer.writeBits(this.samplingFrequencyIndex, 4);
        if (this.samplingFrequencyIndex == 15) {
            bitWriterBuffer.writeBits(this.samplingFrequency, 24);
        }
        bitWriterBuffer.writeBits(this.channelConfiguration, 4);
        int i2 = this.audioObjectType;
        if (i2 == 5 || i2 == 29) {
            this.extensionAudioObjectType = 5;
            this.sbrPresentFlag = true;
            if (this.audioObjectType == 29) {
                this.psPresentFlag = true;
            }
            bitWriterBuffer.writeBits(this.extensionSamplingFrequencyIndex, 4);
            if (this.extensionSamplingFrequencyIndex == 15) {
                bitWriterBuffer.writeBits(this.extensionSamplingFrequency, 24);
            }
            writeAudioObjectType(this.audioObjectType, bitWriterBuffer);
            if (this.audioObjectType == 22) {
                bitWriterBuffer.writeBits(this.extensionChannelConfiguration, 4);
            }
        }
        switch (this.audioObjectType) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                writeGaSpecificConfig(bitWriterBuffer);
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                throw new UnsupportedOperationException("can't write CelpSpecificConfig yet");
            case 9:
                throw new UnsupportedOperationException("can't write HvxcSpecificConfig yet");
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                throw new UnsupportedOperationException("can't write TTSSpecificConfig yet");
            case 13:
            case 14:
            case GmsLogger.MAX_PII_TAG_LENGTH:
            case 16:
                throw new UnsupportedOperationException("can't write StructuredAudioSpecificConfig yet");
            case 24:
                throw new UnsupportedOperationException("can't write ErrorResilientCelpSpecificConfig yet");
            case 25:
                throw new UnsupportedOperationException("can't write ErrorResilientHvxcSpecificConfig yet");
            case 26:
            case 27:
                throw new UnsupportedOperationException("can't write parseParametricSpecificConfig yet");
            case 28:
                throw new UnsupportedOperationException("can't write SSCSpecificConfig yet");
            case 30:
                bitWriterBuffer.writeBits(this.sacPayloadEmbedding, 1);
                throw new UnsupportedOperationException("can't write SpatialSpecificConfig yet");
            case 32:
            case 33:
            case 34:
                throw new UnsupportedOperationException("can't write MPEG_1_2_SpecificConfig yet");
            case 35:
                throw new UnsupportedOperationException("can't write DSTSpecificConfig yet");
            case 36:
                bitWriterBuffer.writeBits(this.fillBits, 5);
                throw new UnsupportedOperationException("can't write ALSSpecificConfig yet");
            case 37:
            case 38:
                throw new UnsupportedOperationException("can't write SLSSpecificConfig yet");
            case 39:
                throw new UnsupportedOperationException("can't write ELDSpecificConfig yet");
            case 40:
            case 41:
                throw new UnsupportedOperationException("can't parse SymbolicMusicSpecificConfig yet");
        }
        int i3 = this.audioObjectType;
        if (!(i3 == 17 || i3 == 39)) {
            switch (i3) {
            }
            i = this.outerSyncExtensionType;
            if (i >= 0) {
                bitWriterBuffer.writeBits(i, 11);
                if (this.outerSyncExtensionType == 695) {
                    writeAudioObjectType(this.extensionAudioObjectType, bitWriterBuffer);
                    if (this.extensionAudioObjectType == 5) {
                        bitWriterBuffer.writeBool(this.sbrPresentFlag);
                        if (this.sbrPresentFlag) {
                            bitWriterBuffer.writeBits(this.extensionSamplingFrequencyIndex, 4);
                            if (this.extensionSamplingFrequencyIndex == 15) {
                                bitWriterBuffer.writeBits(this.extensionSamplingFrequency, 24);
                            }
                            int i4 = this.innerSyncExtensionType;
                            if (i4 >= 0) {
                                bitWriterBuffer.writeBits(i4, 11);
                                if (this.syncExtensionType == 1352) {
                                    bitWriterBuffer.writeBool(this.psPresentFlag);
                                }
                            }
                        }
                    }
                    if (this.extensionAudioObjectType == 22) {
                        bitWriterBuffer.writeBool(this.sbrPresentFlag);
                        if (this.sbrPresentFlag) {
                            bitWriterBuffer.writeBits(this.extensionSamplingFrequencyIndex, 4);
                            if (this.extensionSamplingFrequencyIndex == 15) {
                                bitWriterBuffer.writeBits(this.extensionSamplingFrequency, 24);
                            }
                        }
                        bitWriterBuffer.writeBits(this.extensionChannelConfiguration, 4);
                    }
                }
            }
            return (ByteBuffer) wrap.rewind();
        }
        bitWriterBuffer.writeBits(this.epConfig, 2);
        int i5 = this.epConfig;
        if (i5 == 2 || i5 == 3) {
            throw new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
        }
        if (i5 == 3) {
            bitWriterBuffer.writeBits(this.directMapping, 1);
            if (this.directMapping == 0) {
                throw new RuntimeException("not implemented");
            }
        }
        i = this.outerSyncExtensionType;
        if (i >= 0) {
        }
        return (ByteBuffer) wrap.rewind();
    }

    private void writeAudioObjectType(int i, BitWriterBuffer bitWriterBuffer) {
        if (i >= 32) {
            bitWriterBuffer.writeBits(31, 5);
            bitWriterBuffer.writeBits(i - 32, 6);
            return;
        }
        bitWriterBuffer.writeBits(i, 5);
    }

    private int getAudioObjectType(BitReaderBuffer bitReaderBuffer) throws IOException {
        int readBits = bitReaderBuffer.readBits(5);
        return readBits == 31 ? bitReaderBuffer.readBits(6) + 32 : readBits;
    }

    private void parseGaSpecificConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        this.frameLengthFlag = bitReaderBuffer.readBits(1);
        this.dependsOnCoreCoder = bitReaderBuffer.readBits(1);
        if (this.dependsOnCoreCoder == 1) {
            this.coreCoderDelay = bitReaderBuffer.readBits(14);
        }
        this.extensionFlag = bitReaderBuffer.readBits(1);
        if (i2 != 0) {
            if (i3 == 6 || i3 == 20) {
                this.layerNr = bitReaderBuffer.readBits(3);
            }
            if (this.extensionFlag == 1) {
                if (i3 == 22) {
                    this.numOfSubFrame = bitReaderBuffer.readBits(5);
                    this.layer_length = bitReaderBuffer.readBits(11);
                }
                if (i3 == 17 || i3 == 19 || i3 == 20 || i3 == 23) {
                    this.aacSectionDataResilienceFlag = bitReaderBuffer.readBool();
                    this.aacScalefactorDataResilienceFlag = bitReaderBuffer.readBool();
                    this.aacSpectralDataResilienceFlag = bitReaderBuffer.readBool();
                }
                this.extensionFlag3 = bitReaderBuffer.readBits(1);
                if (this.extensionFlag3 == 1) {
                    throw new RuntimeException("not yet implemented");
                }
            }
            this.gaSpecificConfig = true;
            return;
        }
        throw new UnsupportedOperationException("can't parse program_config_element yet");
    }

    private void writeGaSpecificConfig(BitWriterBuffer bitWriterBuffer) {
        bitWriterBuffer.writeBits(this.frameLengthFlag, 1);
        bitWriterBuffer.writeBits(this.dependsOnCoreCoder, 1);
        if (this.dependsOnCoreCoder == 1) {
            bitWriterBuffer.writeBits(this.coreCoderDelay, 14);
        }
        bitWriterBuffer.writeBits(this.extensionFlag, 1);
        if (this.channelConfiguration != 0) {
            int i = this.audioObjectType;
            if (i == 6 || i == 20) {
                bitWriterBuffer.writeBits(this.layerNr, 3);
            }
            if (this.extensionFlag == 1) {
                if (this.audioObjectType == 22) {
                    bitWriterBuffer.writeBits(this.numOfSubFrame, 5);
                    bitWriterBuffer.writeBits(this.layer_length, 11);
                }
                int i2 = this.audioObjectType;
                if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                    bitWriterBuffer.writeBool(this.aacSectionDataResilienceFlag);
                    bitWriterBuffer.writeBool(this.aacScalefactorDataResilienceFlag);
                    bitWriterBuffer.writeBool(this.aacSpectralDataResilienceFlag);
                }
                bitWriterBuffer.writeBits(this.extensionFlag3, 1);
                if (this.extensionFlag3 == 1) {
                    throw new RuntimeException("not yet implemented");
                }
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("can't parse program_config_element yet");
    }

    private void parseParametricSpecificConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        this.isBaseLayer = bitReaderBuffer.readBits(1);
        if (this.isBaseLayer == 1) {
            parseParaConfig(i, i2, i3, bitReaderBuffer);
        } else {
            parseHilnEnexConfig(i, i2, i3, bitReaderBuffer);
        }
    }

    private void parseParaConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        this.paraMode = bitReaderBuffer.readBits(2);
        if (this.paraMode != 1) {
            parseErHvxcConfig(i, i2, i3, bitReaderBuffer);
        }
        if (this.paraMode != 0) {
            parseHilnConfig(i, i2, i3, bitReaderBuffer);
        }
        this.paraExtensionFlag = bitReaderBuffer.readBits(1);
        this.parametricSpecificConfig = true;
    }

    private void parseErHvxcConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        this.hvxcVarMode = bitReaderBuffer.readBits(1);
        this.hvxcRateMode = bitReaderBuffer.readBits(2);
        this.erHvxcExtensionFlag = bitReaderBuffer.readBits(1);
        if (this.erHvxcExtensionFlag == 1) {
            this.var_ScalableFlag = bitReaderBuffer.readBits(1);
        }
    }

    private void parseHilnConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        this.hilnQuantMode = bitReaderBuffer.readBits(1);
        this.hilnMaxNumLine = bitReaderBuffer.readBits(8);
        this.hilnSampleRateCode = bitReaderBuffer.readBits(4);
        this.hilnFrameLength = bitReaderBuffer.readBits(12);
        this.hilnContMode = bitReaderBuffer.readBits(2);
    }

    private void parseHilnEnexConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        this.hilnEnhaLayer = bitReaderBuffer.readBits(1);
        if (this.hilnEnhaLayer == 1) {
            this.hilnEnhaQuantMode = bitReaderBuffer.readBits(2);
        }
    }

    public byte[] getConfigBytes() {
        return serializeConfigBytes().array();
    }

    public int getAudioObjectType() {
        return this.audioObjectType;
    }

    public void setAudioObjectType(int i) {
        this.audioObjectType = i;
    }

    public void setOriginalAudioObjectType(int i) {
        this.originalAudioObjectType = i;
    }

    public int getExtensionAudioObjectType() {
        return this.extensionAudioObjectType;
    }

    public void setSamplingFrequencyIndex(int i) {
        this.samplingFrequencyIndex = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AudioSpecificConfig");
        sb.append("{configBytes=");
        sb.append(jkx.O000000o(this.configBytes));
        sb.append(", audioObjectType=");
        sb.append(this.audioObjectType);
        sb.append(" (");
        sb.append(audioObjectTypeMap.get(Integer.valueOf(this.audioObjectType)));
        sb.append(")");
        sb.append(", samplingFrequencyIndex=");
        sb.append(this.samplingFrequencyIndex);
        sb.append(" (");
        sb.append(samplingFrequencyIndexMap.get(Integer.valueOf(this.samplingFrequencyIndex)));
        sb.append(")");
        sb.append(", samplingFrequency=");
        sb.append(this.samplingFrequency);
        sb.append(", channelConfiguration=");
        sb.append(this.channelConfiguration);
        if (this.extensionAudioObjectType > 0) {
            sb.append(", extensionAudioObjectType=");
            sb.append(this.extensionAudioObjectType);
            sb.append(" (");
            sb.append(audioObjectTypeMap.get(Integer.valueOf(this.extensionAudioObjectType)));
            sb.append(")");
            sb.append(", sbrPresentFlag=");
            sb.append(this.sbrPresentFlag);
            sb.append(", psPresentFlag=");
            sb.append(this.psPresentFlag);
            sb.append(", extensionSamplingFrequencyIndex=");
            sb.append(this.extensionSamplingFrequencyIndex);
            sb.append(" (");
            sb.append(samplingFrequencyIndexMap.get(Integer.valueOf(this.extensionSamplingFrequencyIndex)));
            sb.append(")");
            sb.append(", extensionSamplingFrequency=");
            sb.append(this.extensionSamplingFrequency);
            sb.append(", extensionChannelConfiguration=");
            sb.append(this.extensionChannelConfiguration);
        }
        sb.append(", syncExtensionType=");
        sb.append(this.syncExtensionType);
        if (this.gaSpecificConfig) {
            sb.append(", frameLengthFlag=");
            sb.append(this.frameLengthFlag);
            sb.append(", dependsOnCoreCoder=");
            sb.append(this.dependsOnCoreCoder);
            sb.append(", coreCoderDelay=");
            sb.append(this.coreCoderDelay);
            sb.append(", extensionFlag=");
            sb.append(this.extensionFlag);
            sb.append(", layerNr=");
            sb.append(this.layerNr);
            sb.append(", numOfSubFrame=");
            sb.append(this.numOfSubFrame);
            sb.append(", layer_length=");
            sb.append(this.layer_length);
            sb.append(", aacSectionDataResilienceFlag=");
            sb.append(this.aacSectionDataResilienceFlag);
            sb.append(", aacScalefactorDataResilienceFlag=");
            sb.append(this.aacScalefactorDataResilienceFlag);
            sb.append(", aacSpectralDataResilienceFlag=");
            sb.append(this.aacSpectralDataResilienceFlag);
            sb.append(", extensionFlag3=");
            sb.append(this.extensionFlag3);
        }
        if (this.parametricSpecificConfig) {
            sb.append(", isBaseLayer=");
            sb.append(this.isBaseLayer);
            sb.append(", paraMode=");
            sb.append(this.paraMode);
            sb.append(", paraExtensionFlag=");
            sb.append(this.paraExtensionFlag);
            sb.append(", hvxcVarMode=");
            sb.append(this.hvxcVarMode);
            sb.append(", hvxcRateMode=");
            sb.append(this.hvxcRateMode);
            sb.append(", erHvxcExtensionFlag=");
            sb.append(this.erHvxcExtensionFlag);
            sb.append(", var_ScalableFlag=");
            sb.append(this.var_ScalableFlag);
            sb.append(", hilnQuantMode=");
            sb.append(this.hilnQuantMode);
            sb.append(", hilnMaxNumLine=");
            sb.append(this.hilnMaxNumLine);
            sb.append(", hilnSampleRateCode=");
            sb.append(this.hilnSampleRateCode);
            sb.append(", hilnFrameLength=");
            sb.append(this.hilnFrameLength);
            sb.append(", hilnContMode=");
            sb.append(this.hilnContMode);
            sb.append(", hilnEnhaLayer=");
            sb.append(this.hilnEnhaLayer);
            sb.append(", hilnEnhaQuantMode=");
            sb.append(this.hilnEnhaQuantMode);
        }
        sb.append('}');
        return sb.toString();
    }

    public int getSamplingFrequency() {
        int i = this.samplingFrequencyIndex;
        return i == 15 ? this.samplingFrequency : samplingFrequencyIndexMap.get(Integer.valueOf(i)).intValue();
    }

    public void setSamplingFrequency(int i) {
        this.samplingFrequency = i;
    }

    public int getExtensionSamplingFrequency() {
        int i = this.extensionSamplingFrequencyIndex;
        return i == 15 ? this.extensionSamplingFrequency : samplingFrequencyIndexMap.get(Integer.valueOf(i)).intValue();
    }

    public int getChannelConfiguration() {
        return this.channelConfiguration;
    }

    public void setChannelConfiguration(int i) {
        this.channelConfiguration = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AudioSpecificConfig audioSpecificConfig = (AudioSpecificConfig) obj;
        return this.aacScalefactorDataResilienceFlag == audioSpecificConfig.aacScalefactorDataResilienceFlag && this.aacSectionDataResilienceFlag == audioSpecificConfig.aacSectionDataResilienceFlag && this.aacSpectralDataResilienceFlag == audioSpecificConfig.aacSpectralDataResilienceFlag && this.audioObjectType == audioSpecificConfig.audioObjectType && this.channelConfiguration == audioSpecificConfig.channelConfiguration && this.coreCoderDelay == audioSpecificConfig.coreCoderDelay && this.dependsOnCoreCoder == audioSpecificConfig.dependsOnCoreCoder && this.directMapping == audioSpecificConfig.directMapping && this.epConfig == audioSpecificConfig.epConfig && this.erHvxcExtensionFlag == audioSpecificConfig.erHvxcExtensionFlag && this.extensionAudioObjectType == audioSpecificConfig.extensionAudioObjectType && this.extensionChannelConfiguration == audioSpecificConfig.extensionChannelConfiguration && this.extensionFlag == audioSpecificConfig.extensionFlag && this.extensionFlag3 == audioSpecificConfig.extensionFlag3 && this.extensionSamplingFrequency == audioSpecificConfig.extensionSamplingFrequency && this.extensionSamplingFrequencyIndex == audioSpecificConfig.extensionSamplingFrequencyIndex && this.fillBits == audioSpecificConfig.fillBits && this.frameLengthFlag == audioSpecificConfig.frameLengthFlag && this.gaSpecificConfig == audioSpecificConfig.gaSpecificConfig && this.hilnContMode == audioSpecificConfig.hilnContMode && this.hilnEnhaLayer == audioSpecificConfig.hilnEnhaLayer && this.hilnEnhaQuantMode == audioSpecificConfig.hilnEnhaQuantMode && this.hilnFrameLength == audioSpecificConfig.hilnFrameLength && this.hilnMaxNumLine == audioSpecificConfig.hilnMaxNumLine && this.hilnQuantMode == audioSpecificConfig.hilnQuantMode && this.hilnSampleRateCode == audioSpecificConfig.hilnSampleRateCode && this.hvxcRateMode == audioSpecificConfig.hvxcRateMode && this.hvxcVarMode == audioSpecificConfig.hvxcVarMode && this.isBaseLayer == audioSpecificConfig.isBaseLayer && this.layerNr == audioSpecificConfig.layerNr && this.layer_length == audioSpecificConfig.layer_length && this.numOfSubFrame == audioSpecificConfig.numOfSubFrame && this.paraExtensionFlag == audioSpecificConfig.paraExtensionFlag && this.paraMode == audioSpecificConfig.paraMode && this.parametricSpecificConfig == audioSpecificConfig.parametricSpecificConfig && this.psPresentFlag == audioSpecificConfig.psPresentFlag && this.sacPayloadEmbedding == audioSpecificConfig.sacPayloadEmbedding && this.samplingFrequency == audioSpecificConfig.samplingFrequency && this.samplingFrequencyIndex == audioSpecificConfig.samplingFrequencyIndex && this.sbrPresentFlag == audioSpecificConfig.sbrPresentFlag && this.syncExtensionType == audioSpecificConfig.syncExtensionType && this.var_ScalableFlag == audioSpecificConfig.var_ScalableFlag && Arrays.equals(this.configBytes, audioSpecificConfig.configBytes);
    }

    public int hashCode() {
        byte[] bArr = this.configBytes;
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((bArr != null ? Arrays.hashCode(bArr) : 0) * 31) + this.audioObjectType) * 31) + this.samplingFrequencyIndex) * 31) + this.samplingFrequency) * 31) + this.channelConfiguration) * 31) + this.extensionAudioObjectType) * 31) + (this.sbrPresentFlag ? 1 : 0)) * 31) + (this.psPresentFlag ? 1 : 0)) * 31) + this.extensionSamplingFrequencyIndex) * 31) + this.extensionSamplingFrequency) * 31) + this.extensionChannelConfiguration) * 31) + this.sacPayloadEmbedding) * 31) + this.fillBits) * 31) + this.epConfig) * 31) + this.directMapping) * 31) + this.syncExtensionType) * 31) + this.frameLengthFlag) * 31) + this.dependsOnCoreCoder) * 31) + this.coreCoderDelay) * 31) + this.extensionFlag) * 31) + this.layerNr) * 31) + this.numOfSubFrame) * 31) + this.layer_length) * 31) + (this.aacSectionDataResilienceFlag ? 1 : 0)) * 31) + (this.aacScalefactorDataResilienceFlag ? 1 : 0)) * 31) + (this.aacSpectralDataResilienceFlag ? 1 : 0)) * 31) + this.extensionFlag3) * 31) + (this.gaSpecificConfig ? 1 : 0)) * 31) + this.isBaseLayer) * 31) + this.paraMode) * 31) + this.paraExtensionFlag) * 31) + this.hvxcVarMode) * 31) + this.hvxcRateMode) * 31) + this.erHvxcExtensionFlag) * 31) + this.var_ScalableFlag) * 31) + this.hilnQuantMode) * 31) + this.hilnMaxNumLine) * 31) + this.hilnSampleRateCode) * 31) + this.hilnFrameLength) * 31) + this.hilnContMode) * 31) + this.hilnEnhaLayer) * 31) + this.hilnEnhaQuantMode) * 31) + (this.parametricSpecificConfig ? 1 : 0);
    }

    public class ELDSpecificConfig {
        public boolean aacScalefactorDataResilienceFlag;
        public boolean aacSectionDataResilienceFlag;
        public boolean aacSpectralDataResilienceFlag;
        public boolean frameLengthFlag;
        public boolean ldSbrCrcFlag;
        public boolean ldSbrPresentFlag;
        public boolean ldSbrSamplingRate;

        public ELDSpecificConfig(int i, BitReaderBuffer bitReaderBuffer) {
            int i2;
            this.frameLengthFlag = bitReaderBuffer.readBool();
            this.aacSectionDataResilienceFlag = bitReaderBuffer.readBool();
            this.aacScalefactorDataResilienceFlag = bitReaderBuffer.readBool();
            this.aacSpectralDataResilienceFlag = bitReaderBuffer.readBool();
            this.ldSbrPresentFlag = bitReaderBuffer.readBool();
            if (this.ldSbrPresentFlag) {
                this.ldSbrSamplingRate = bitReaderBuffer.readBool();
                this.ldSbrCrcFlag = bitReaderBuffer.readBool();
                ld_sbr_header(i, bitReaderBuffer);
            }
            while (bitReaderBuffer.readBits(4) != 0) {
                int readBits = bitReaderBuffer.readBits(4);
                if (readBits == 15) {
                    i2 = bitReaderBuffer.readBits(8);
                    readBits += i2;
                } else {
                    i2 = 0;
                }
                if (i2 == 255) {
                    readBits += bitReaderBuffer.readBits(16);
                }
                for (int i3 = 0; i3 < readBits; i3++) {
                    bitReaderBuffer.readBits(8);
                }
            }
        }

        public void ld_sbr_header(int i, BitReaderBuffer bitReaderBuffer) {
            int i2;
            switch (i) {
                case 1:
                case 2:
                    i2 = 1;
                    break;
                case 3:
                    i2 = 2;
                    break;
                case 4:
                case 5:
                case 6:
                    i2 = 3;
                    break;
                case 7:
                    i2 = 4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                new sbr_header(bitReaderBuffer);
            }
        }
    }

    public class sbr_header {
        public boolean bs_alter_scale;
        public boolean bs_amp_res;
        public int bs_freq_scale;
        public boolean bs_header_extra_1;
        public boolean bs_header_extra_2;
        public boolean bs_interpol_freq;
        public int bs_limiter_bands;
        public int bs_limiter_gains;
        public int bs_noise_bands;
        public int bs_reserved;
        public boolean bs_smoothing_mode;
        public int bs_start_freq;
        public int bs_stop_freq;
        public int bs_xover_band;

        public sbr_header(BitReaderBuffer bitReaderBuffer) {
            this.bs_amp_res = bitReaderBuffer.readBool();
            this.bs_start_freq = bitReaderBuffer.readBits(4);
            this.bs_stop_freq = bitReaderBuffer.readBits(4);
            this.bs_xover_band = bitReaderBuffer.readBits(3);
            this.bs_reserved = bitReaderBuffer.readBits(2);
            this.bs_header_extra_1 = bitReaderBuffer.readBool();
            this.bs_header_extra_2 = bitReaderBuffer.readBool();
            if (this.bs_header_extra_1) {
                this.bs_freq_scale = bitReaderBuffer.readBits(2);
                this.bs_alter_scale = bitReaderBuffer.readBool();
                this.bs_noise_bands = bitReaderBuffer.readBits(2);
            }
            if (this.bs_header_extra_2) {
                this.bs_limiter_bands = bitReaderBuffer.readBits(2);
                this.bs_limiter_gains = bitReaderBuffer.readBits(2);
                this.bs_interpol_freq = bitReaderBuffer.readBool();
            }
            this.bs_smoothing_mode = bitReaderBuffer.readBool();
        }
    }
}
