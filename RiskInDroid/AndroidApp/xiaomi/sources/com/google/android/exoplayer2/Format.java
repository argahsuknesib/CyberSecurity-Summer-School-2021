package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new Parcelable.Creator<Format>() {
        /* class com.google.android.exoplayer2.Format.AnonymousClass1 */

        public final Format createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }

        public final Format[] newArray(int i) {
            return new Format[i];
        }
    };
    public final int accessibilityChannel;
    public final int averageBitrate;
    public final int bitrate;
    public final int channelCount;
    public final String codecs;
    public final ColorInfo colorInfo;
    public final String containerMimeType;
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final Class<? extends ExoMediaCrypto> exoMediaCryptoType;
    public final float frameRate;
    private int hashCode;
    public final int height;
    public final String id;
    public final List<byte[]> initializationData;
    public final String label;
    public final String language;
    public final int maxInputSize;
    public final Metadata metadata;
    public final int pcmEncoding;
    public final int peakBitrate;
    public final float pixelWidthHeightRatio;
    public final byte[] projectionData;
    public final int roleFlags;
    public final int rotationDegrees;
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    public final int describeContents() {
        return 0;
    }

    public static final class Builder {
        private int accessibilityChannel;
        private int averageBitrate;
        private int channelCount;
        private String codecs;
        private ColorInfo colorInfo;
        private String containerMimeType;
        private DrmInitData drmInitData;
        private int encoderDelay;
        private int encoderPadding;
        private Class<? extends ExoMediaCrypto> exoMediaCryptoType;
        private float frameRate;
        private int height;
        private String id;
        private List<byte[]> initializationData;
        private String label;
        private String language;
        private int maxInputSize;
        private Metadata metadata;
        private int pcmEncoding;
        private int peakBitrate;
        private float pixelWidthHeightRatio;
        private byte[] projectionData;
        private int roleFlags;
        private int rotationDegrees;
        private String sampleMimeType;
        private int sampleRate;
        private int selectionFlags;
        private int stereoMode;
        private long subsampleOffsetUs;
        private int width;

        public Builder() {
            this.averageBitrate = -1;
            this.peakBitrate = -1;
            this.maxInputSize = -1;
            this.subsampleOffsetUs = Long.MAX_VALUE;
            this.width = -1;
            this.height = -1;
            this.frameRate = -1.0f;
            this.pixelWidthHeightRatio = 1.0f;
            this.stereoMode = -1;
            this.channelCount = -1;
            this.sampleRate = -1;
            this.pcmEncoding = -1;
            this.accessibilityChannel = -1;
        }

        private Builder(Format format) {
            this.id = format.id;
            this.label = format.label;
            this.language = format.language;
            this.selectionFlags = format.selectionFlags;
            this.roleFlags = format.roleFlags;
            this.averageBitrate = format.averageBitrate;
            this.peakBitrate = format.peakBitrate;
            this.codecs = format.codecs;
            this.metadata = format.metadata;
            this.containerMimeType = format.containerMimeType;
            this.sampleMimeType = format.sampleMimeType;
            this.maxInputSize = format.maxInputSize;
            this.initializationData = format.initializationData;
            this.drmInitData = format.drmInitData;
            this.subsampleOffsetUs = format.subsampleOffsetUs;
            this.width = format.width;
            this.height = format.height;
            this.frameRate = format.frameRate;
            this.rotationDegrees = format.rotationDegrees;
            this.pixelWidthHeightRatio = format.pixelWidthHeightRatio;
            this.projectionData = format.projectionData;
            this.stereoMode = format.stereoMode;
            this.colorInfo = format.colorInfo;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.pcmEncoding = format.pcmEncoding;
            this.encoderDelay = format.encoderDelay;
            this.encoderPadding = format.encoderPadding;
            this.accessibilityChannel = format.accessibilityChannel;
            this.exoMediaCryptoType = format.exoMediaCryptoType;
        }

        public final Builder setId(String str) {
            this.id = str;
            return this;
        }

        public final Builder setId(int i) {
            this.id = Integer.toString(i);
            return this;
        }

        public final Builder setLabel(String str) {
            this.label = str;
            return this;
        }

        public final Builder setLanguage(String str) {
            this.language = str;
            return this;
        }

        public final Builder setSelectionFlags(int i) {
            this.selectionFlags = i;
            return this;
        }

        public final Builder setRoleFlags(int i) {
            this.roleFlags = i;
            return this;
        }

        public final Builder setAverageBitrate(int i) {
            this.averageBitrate = i;
            return this;
        }

        public final Builder setPeakBitrate(int i) {
            this.peakBitrate = i;
            return this;
        }

        public final Builder setCodecs(String str) {
            this.codecs = str;
            return this;
        }

        public final Builder setMetadata(Metadata metadata2) {
            this.metadata = metadata2;
            return this;
        }

        public final Builder setContainerMimeType(String str) {
            this.containerMimeType = str;
            return this;
        }

        public final Builder setSampleMimeType(String str) {
            this.sampleMimeType = str;
            return this;
        }

        public final Builder setMaxInputSize(int i) {
            this.maxInputSize = i;
            return this;
        }

        public final Builder setInitializationData(List<byte[]> list) {
            this.initializationData = list;
            return this;
        }

        public final Builder setDrmInitData(DrmInitData drmInitData2) {
            this.drmInitData = drmInitData2;
            return this;
        }

        public final Builder setSubsampleOffsetUs(long j) {
            this.subsampleOffsetUs = j;
            return this;
        }

        public final Builder setWidth(int i) {
            this.width = i;
            return this;
        }

        public final Builder setHeight(int i) {
            this.height = i;
            return this;
        }

        public final Builder setFrameRate(float f) {
            this.frameRate = f;
            return this;
        }

        public final Builder setRotationDegrees(int i) {
            this.rotationDegrees = i;
            return this;
        }

        public final Builder setPixelWidthHeightRatio(float f) {
            this.pixelWidthHeightRatio = f;
            return this;
        }

        public final Builder setProjectionData(byte[] bArr) {
            this.projectionData = bArr;
            return this;
        }

        public final Builder setStereoMode(int i) {
            this.stereoMode = i;
            return this;
        }

        public final Builder setColorInfo(ColorInfo colorInfo2) {
            this.colorInfo = colorInfo2;
            return this;
        }

        public final Builder setChannelCount(int i) {
            this.channelCount = i;
            return this;
        }

        public final Builder setSampleRate(int i) {
            this.sampleRate = i;
            return this;
        }

        public final Builder setPcmEncoding(int i) {
            this.pcmEncoding = i;
            return this;
        }

        public final Builder setEncoderDelay(int i) {
            this.encoderDelay = i;
            return this;
        }

        public final Builder setEncoderPadding(int i) {
            this.encoderPadding = i;
            return this;
        }

        public final Builder setAccessibilityChannel(int i) {
            this.accessibilityChannel = i;
            return this;
        }

        public final Builder setExoMediaCryptoType(Class<? extends ExoMediaCrypto> cls) {
            this.exoMediaCryptoType = cls;
            return this;
        }

        public final Format build() {
            return new Format(this.id, this.label, this.language, this.selectionFlags, this.roleFlags, this.averageBitrate, this.peakBitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.accessibilityChannel, this.exoMediaCryptoType);
        }
    }

    @Deprecated
    public static Format createVideoContainerFormat(String str, String str2, String str3, String str4, String str5, Metadata metadata2, int i, int i2, int i3, float f, List<byte[]> list, int i4, int i5) {
        return new Builder().setId(str).setLabel(str2).setSelectionFlags(i4).setRoleFlags(i5).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setMetadata(metadata2).setContainerMimeType(str3).setSampleMimeType(str4).setInitializationData(list).setWidth(i2).setHeight(i3).setFrameRate(f).build();
    }

    @Deprecated
    public static Format createVideoSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, DrmInitData drmInitData2) {
        return new Builder().setId(str).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData2).setWidth(i3).setHeight(i4).setFrameRate(f).build();
    }

    @Deprecated
    public static Format createVideoSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, DrmInitData drmInitData2) {
        return new Builder().setId(str).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData2).setWidth(i3).setHeight(i4).setFrameRate(f).setRotationDegrees(i5).setPixelWidthHeightRatio(f2).build();
    }

    @Deprecated
    public static Format createVideoSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, ColorInfo colorInfo2, DrmInitData drmInitData2) {
        return new Builder().setId(str).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData2).setWidth(i3).setHeight(i4).setFrameRate(f).setRotationDegrees(i5).setPixelWidthHeightRatio(f2).setProjectionData(bArr).setStereoMode(i6).setColorInfo(colorInfo2).build();
    }

    @Deprecated
    public static Format createAudioContainerFormat(String str, String str2, String str3, String str4, String str5, Metadata metadata2, int i, int i2, int i3, List<byte[]> list, int i4, int i5, String str6) {
        return new Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i4).setRoleFlags(i5).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setMetadata(metadata2).setContainerMimeType(str3).setSampleMimeType(str4).setInitializationData(list).setChannelCount(i2).setSampleRate(i3).build();
    }

    @Deprecated
    public static Format createAudioSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, DrmInitData drmInitData2, int i5, String str4) {
        return new Builder().setId(str).setLanguage(str4).setSelectionFlags(i5).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData2).setChannelCount(i3).setSampleRate(i4).build();
    }

    @Deprecated
    public static Format createAudioSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData2, int i6, String str4) {
        return new Builder().setId(str).setLanguage(str4).setSelectionFlags(i6).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData2).setChannelCount(i3).setSampleRate(i4).setPcmEncoding(i5).build();
    }

    @Deprecated
    public static Format createAudioSampleFormat(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, int i6, int i7, List<byte[]> list, DrmInitData drmInitData2, int i8, String str4, Metadata metadata2) {
        return new Builder().setId(str).setLanguage(str4).setSelectionFlags(i8).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setMetadata(metadata2).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData2).setChannelCount(i3).setSampleRate(i4).setPcmEncoding(i5).setEncoderDelay(i6).setEncoderPadding(i7).build();
    }

    @Deprecated
    public static Format createTextContainerFormat(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, String str6) {
        return new Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i2).setRoleFlags(i3).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setContainerMimeType(str3).setSampleMimeType(str4).build();
    }

    @Deprecated
    public static Format createTextContainerFormat(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, String str6, int i4) {
        return new Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i2).setRoleFlags(i3).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setContainerMimeType(str3).setSampleMimeType(str4).setAccessibilityChannel(i4).build();
    }

    @Deprecated
    public static Format createTextSampleFormat(String str, String str2, int i, String str3) {
        return new Builder().setId(str).setLanguage(str3).setSelectionFlags(i).setSampleMimeType(str2).build();
    }

    @Deprecated
    public static Format createTextSampleFormat(String str, String str2, int i, String str3, int i2, long j, List<byte[]> list) {
        return new Builder().setId(str).setLanguage(str3).setSelectionFlags(i).setSampleMimeType(str2).setInitializationData(list).setSubsampleOffsetUs(j).setAccessibilityChannel(i2).build();
    }

    @Deprecated
    public static Format createImageSampleFormat(String str, String str2, int i, List<byte[]> list, String str3) {
        return new Builder().setId(str).setLanguage(str3).setSelectionFlags(i).setSampleMimeType(str2).setInitializationData(list).build();
    }

    @Deprecated
    public static Format createContainerFormat(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, String str6) {
        return new Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i2).setRoleFlags(i3).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setContainerMimeType(str3).setSampleMimeType(str4).build();
    }

    @Deprecated
    public static Format createSampleFormat(String str, String str2) {
        return new Builder().setId(str).setSampleMimeType(str2).build();
    }

    Format(String str, String str2, String str3, int i, int i2, int i3, int i4, String str4, Metadata metadata2, String str5, String str6, int i5, List<byte[]> list, DrmInitData drmInitData2, long j, int i6, int i7, float f, int i8, float f2, byte[] bArr, int i9, ColorInfo colorInfo2, int i10, int i11, int i12, int i13, int i14, int i15, Class<? extends ExoMediaCrypto> cls) {
        int i16 = i4;
        this.id = str;
        this.label = str2;
        this.language = Util.normalizeLanguageCode(str3);
        this.selectionFlags = i;
        this.roleFlags = i2;
        int i17 = i3;
        this.averageBitrate = i17;
        this.peakBitrate = i16;
        this.bitrate = i16 == -1 ? i17 : i16;
        this.codecs = str4;
        this.metadata = metadata2;
        this.containerMimeType = str5;
        this.sampleMimeType = str6;
        this.maxInputSize = i5;
        this.initializationData = list == null ? Collections.emptyList() : list;
        this.drmInitData = drmInitData2;
        this.subsampleOffsetUs = j;
        this.width = i6;
        this.height = i7;
        this.frameRate = f;
        int i18 = 0;
        int i19 = i8;
        this.rotationDegrees = i19 == -1 ? 0 : i19;
        this.pixelWidthHeightRatio = f2 == -1.0f ? 1.0f : f2;
        this.projectionData = bArr;
        this.stereoMode = i9;
        this.colorInfo = colorInfo2;
        this.channelCount = i10;
        this.sampleRate = i11;
        this.pcmEncoding = i12;
        int i20 = i13;
        this.encoderDelay = i20 == -1 ? 0 : i20;
        int i21 = i14;
        this.encoderPadding = i21 != -1 ? i21 : i18;
        this.accessibilityChannel = i15;
        this.exoMediaCryptoType = cls;
    }

    Format(Parcel parcel) {
        this.id = parcel.readString();
        this.label = parcel.readString();
        this.language = parcel.readString();
        this.selectionFlags = parcel.readInt();
        this.roleFlags = parcel.readInt();
        this.averageBitrate = parcel.readInt();
        this.peakBitrate = parcel.readInt();
        int i = this.peakBitrate;
        this.bitrate = i == -1 ? this.averageBitrate : i;
        this.codecs = parcel.readString();
        this.metadata = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
        this.containerMimeType = parcel.readString();
        this.sampleMimeType = parcel.readString();
        this.maxInputSize = parcel.readInt();
        int readInt = parcel.readInt();
        this.initializationData = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.initializationData.add(parcel.createByteArray());
        }
        this.drmInitData = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.subsampleOffsetUs = parcel.readLong();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.frameRate = parcel.readFloat();
        this.rotationDegrees = parcel.readInt();
        this.pixelWidthHeightRatio = parcel.readFloat();
        this.projectionData = Util.readBoolean(parcel) ? parcel.createByteArray() : null;
        this.stereoMode = parcel.readInt();
        this.colorInfo = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.channelCount = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.pcmEncoding = parcel.readInt();
        this.encoderDelay = parcel.readInt();
        this.encoderPadding = parcel.readInt();
        this.accessibilityChannel = parcel.readInt();
        this.exoMediaCryptoType = null;
    }

    public final Builder buildUpon() {
        return new Builder();
    }

    @Deprecated
    public final Format copyWithMaxInputSize(int i) {
        return buildUpon().setMaxInputSize(i).build();
    }

    @Deprecated
    public final Format copyWithSubsampleOffsetUs(long j) {
        return buildUpon().setSubsampleOffsetUs(j).build();
    }

    @Deprecated
    public final Format copyWithLabel(String str) {
        return buildUpon().setLabel(str).build();
    }

    @Deprecated
    public final Format copyWithManifestFormatInfo(Format format) {
        return withManifestFormatInfo(format);
    }

    public final Format withManifestFormatInfo(Format format) {
        Metadata metadata2;
        String str;
        if (this == format) {
            return this;
        }
        int trackType = MimeTypes.getTrackType(this.sampleMimeType);
        String str2 = format.id;
        String str3 = format.label;
        if (str3 == null) {
            str3 = this.label;
        }
        String str4 = this.language;
        if ((trackType == 3 || trackType == 1) && (str = format.language) != null) {
            str4 = str;
        }
        int i = this.averageBitrate;
        if (i == -1) {
            i = format.averageBitrate;
        }
        int i2 = this.peakBitrate;
        if (i2 == -1) {
            i2 = format.peakBitrate;
        }
        String str5 = this.codecs;
        if (str5 == null) {
            String codecsOfType = Util.getCodecsOfType(format.codecs, trackType);
            if (Util.splitCodecs(codecsOfType).length == 1) {
                str5 = codecsOfType;
            }
        }
        Metadata metadata3 = this.metadata;
        if (metadata3 == null) {
            metadata2 = format.metadata;
        } else {
            metadata2 = metadata3.copyWithAppendedEntriesFrom(format.metadata);
        }
        float f = this.frameRate;
        if (f == -1.0f && trackType == 2) {
            f = format.frameRate;
        }
        int i3 = this.selectionFlags | format.selectionFlags;
        return buildUpon().setId(str2).setLabel(str3).setLanguage(str4).setSelectionFlags(i3).setRoleFlags(this.roleFlags | format.roleFlags).setAverageBitrate(i).setPeakBitrate(i2).setCodecs(str5).setMetadata(metadata2).setDrmInitData(DrmInitData.createSessionCreationData(format.drmInitData, this.drmInitData)).setFrameRate(f).build();
    }

    @Deprecated
    public final Format copyWithGaplessInfo(int i, int i2) {
        return buildUpon().setEncoderDelay(i).setEncoderPadding(i2).build();
    }

    @Deprecated
    public final Format copyWithFrameRate(float f) {
        return buildUpon().setFrameRate(f).build();
    }

    @Deprecated
    public final Format copyWithDrmInitData(DrmInitData drmInitData2) {
        return buildUpon().setDrmInitData(drmInitData2).build();
    }

    @Deprecated
    public final Format copyWithMetadata(Metadata metadata2) {
        return buildUpon().setMetadata(metadata2).build();
    }

    @Deprecated
    public final Format copyWithBitrate(int i) {
        return buildUpon().setAverageBitrate(i).setPeakBitrate(i).build();
    }

    @Deprecated
    public final Format copyWithVideoSize(int i, int i2) {
        return buildUpon().setWidth(i).setHeight(i2).build();
    }

    public final Format copyWithExoMediaCryptoType(Class<? extends ExoMediaCrypto> cls) {
        return buildUpon().setExoMediaCryptoType(cls).build();
    }

    public final int getPixelCount() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public final String toString() {
        return "Format(" + this.id + ", " + this.label + ", " + this.containerMimeType + ", " + this.sampleMimeType + ", " + this.codecs + ", " + this.bitrate + ", " + this.language + ", [" + this.width + ", " + this.height + ", " + this.frameRate + "], [" + this.channelCount + ", " + this.sampleRate + "])";
    }

    public final int hashCode() {
        if (this.hashCode == 0) {
            String str = this.id;
            int i = 0;
            int hashCode2 = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.label;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.language;
            int hashCode4 = (((((((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31) + this.averageBitrate) * 31) + this.peakBitrate) * 31;
            String str4 = this.codecs;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata2 = this.metadata;
            int hashCode6 = (hashCode5 + (metadata2 == null ? 0 : metadata2.hashCode())) * 31;
            String str5 = this.containerMimeType;
            int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.sampleMimeType;
            int hashCode8 = (((((((((((((((((((((((((((((hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.maxInputSize) * 31) + ((int) this.subsampleOffsetUs)) * 31) + this.width) * 31) + this.height) * 31) + Float.floatToIntBits(this.frameRate)) * 31) + this.rotationDegrees) * 31) + Float.floatToIntBits(this.pixelWidthHeightRatio)) * 31) + this.stereoMode) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.pcmEncoding) * 31) + this.encoderDelay) * 31) + this.encoderPadding) * 31) + this.accessibilityChannel) * 31;
            Class<? extends ExoMediaCrypto> cls = this.exoMediaCryptoType;
            if (cls != null) {
                i = cls.hashCode();
            }
            this.hashCode = hashCode8 + i;
        }
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Format format = (Format) obj;
            int i2 = this.hashCode;
            if ((i2 == 0 || (i = format.hashCode) == 0 || i2 == i) && this.selectionFlags == format.selectionFlags && this.roleFlags == format.roleFlags && this.averageBitrate == format.averageBitrate && this.peakBitrate == format.peakBitrate && this.maxInputSize == format.maxInputSize && this.subsampleOffsetUs == format.subsampleOffsetUs && this.width == format.width && this.height == format.height && this.rotationDegrees == format.rotationDegrees && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.accessibilityChannel == format.accessibilityChannel && Float.compare(this.frameRate, format.frameRate) == 0 && Float.compare(this.pixelWidthHeightRatio, format.pixelWidthHeightRatio) == 0 && Util.areEqual(this.exoMediaCryptoType, format.exoMediaCryptoType) && Util.areEqual(this.id, format.id) && Util.areEqual(this.label, format.label) && Util.areEqual(this.codecs, format.codecs) && Util.areEqual(this.containerMimeType, format.containerMimeType) && Util.areEqual(this.sampleMimeType, format.sampleMimeType) && Util.areEqual(this.language, format.language) && Arrays.equals(this.projectionData, format.projectionData) && Util.areEqual(this.metadata, format.metadata) && Util.areEqual(this.colorInfo, format.colorInfo) && Util.areEqual(this.drmInitData, format.drmInitData) && initializationDataEquals(format)) {
                return true;
            }
        }
        return false;
    }

    public final boolean initializationDataEquals(Format format) {
        if (this.initializationData.size() != format.initializationData.size()) {
            return false;
        }
        for (int i = 0; i < this.initializationData.size(); i++) {
            if (!Arrays.equals(this.initializationData.get(i), format.initializationData.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static String toLogString(Format format) {
        if (format == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(format.id);
        sb.append(", mimeType=");
        sb.append(format.sampleMimeType);
        if (format.bitrate != -1) {
            sb.append(", bitrate=");
            sb.append(format.bitrate);
        }
        if (format.codecs != null) {
            sb.append(", codecs=");
            sb.append(format.codecs);
        }
        if (!(format.width == -1 || format.height == -1)) {
            sb.append(", res=");
            sb.append(format.width);
            sb.append("x");
            sb.append(format.height);
        }
        if (format.frameRate != -1.0f) {
            sb.append(", fps=");
            sb.append(format.frameRate);
        }
        if (format.channelCount != -1) {
            sb.append(", channels=");
            sb.append(format.channelCount);
        }
        if (format.sampleRate != -1) {
            sb.append(", sample_rate=");
            sb.append(format.sampleRate);
        }
        if (format.language != null) {
            sb.append(", language=");
            sb.append(format.language);
        }
        if (format.label != null) {
            sb.append(", label=");
            sb.append(format.label);
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.label);
        parcel.writeString(this.language);
        parcel.writeInt(this.selectionFlags);
        parcel.writeInt(this.roleFlags);
        parcel.writeInt(this.averageBitrate);
        parcel.writeInt(this.peakBitrate);
        parcel.writeString(this.codecs);
        boolean z = false;
        parcel.writeParcelable(this.metadata, 0);
        parcel.writeString(this.containerMimeType);
        parcel.writeString(this.sampleMimeType);
        parcel.writeInt(this.maxInputSize);
        int size = this.initializationData.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.initializationData.get(i2));
        }
        parcel.writeParcelable(this.drmInitData, 0);
        parcel.writeLong(this.subsampleOffsetUs);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.frameRate);
        parcel.writeInt(this.rotationDegrees);
        parcel.writeFloat(this.pixelWidthHeightRatio);
        if (this.projectionData != null) {
            z = true;
        }
        Util.writeBoolean(parcel, z);
        byte[] bArr = this.projectionData;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.stereoMode);
        parcel.writeParcelable(this.colorInfo, i);
        parcel.writeInt(this.channelCount);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.pcmEncoding);
        parcel.writeInt(this.encoderDelay);
        parcel.writeInt(this.encoderPadding);
        parcel.writeInt(this.accessibilityChannel);
    }
}
