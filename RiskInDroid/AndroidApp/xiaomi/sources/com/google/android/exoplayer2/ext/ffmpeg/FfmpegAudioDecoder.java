package com.google.android.exoplayer2.ext.ffmpeg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.decoder.SimpleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.List;

final class FfmpegAudioDecoder extends SimpleDecoder<DecoderInputBuffer, SimpleOutputBuffer, FfmpegDecoderException> {
    private volatile int channelCount;
    private final String codecName;
    private final int encoding;
    private final byte[] extraData;
    private boolean hasOutputFormat;
    private long nativeContext;
    private final int outputBufferSize;
    private volatile int sampleRate;

    private native int ffmpegDecode(long j, ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2);

    private native int ffmpegGetChannelCount(long j);

    private native int ffmpegGetSampleRate(long j);

    private native long ffmpegInitialize(String str, byte[] bArr, boolean z, int i, int i2);

    private native void ffmpegRelease(long j);

    private native long ffmpegReset(long j, byte[] bArr);

    public FfmpegAudioDecoder(int i, int i2, int i3, Format format, boolean z) throws FfmpegDecoderException {
        super(new DecoderInputBuffer[i], new SimpleOutputBuffer[i2]);
        if (FfmpegLibrary.isAvailable()) {
            Assertions.checkNotNull(format.sampleMimeType);
            this.codecName = (String) Assertions.checkNotNull(FfmpegLibrary.getCodecName(format.sampleMimeType));
            this.extraData = getExtraData(format.sampleMimeType, format.initializationData);
            this.encoding = z ? 4 : 2;
            this.outputBufferSize = z ? 131072 : 65536;
            this.nativeContext = ffmpegInitialize(this.codecName, this.extraData, z, format.sampleRate, format.channelCount);
            if (this.nativeContext != 0) {
                setInitialInputBufferSize(i3);
                return;
            }
            throw new FfmpegDecoderException("Initialization failed.");
        }
        throw new FfmpegDecoderException("Failed to load decoder native libraries.");
    }

    public final String getName() {
        return "ffmpeg" + FfmpegLibrary.getVersion() + "-" + this.codecName;
    }

    public final DecoderInputBuffer createInputBuffer() {
        return new DecoderInputBuffer(2);
    }

    /* access modifiers changed from: protected */
    public final SimpleOutputBuffer createOutputBuffer() {
        return new SimpleOutputBuffer(new OutputBuffer.Owner() {
            /* class com.google.android.exoplayer2.ext.ffmpeg.$$Lambda$FfmpegAudioDecoder$ldIL7a7nV2il_wGKXHAXAsQmGg */

            public final void releaseOutputBuffer(OutputBuffer outputBuffer) {
                FfmpegAudioDecoder.this.releaseOutputBuffer((SimpleOutputBuffer) outputBuffer);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final FfmpegDecoderException createUnexpectedDecodeException(Throwable th) {
        return new FfmpegDecoderException("Unexpected decode error", th);
    }

    /* access modifiers changed from: protected */
    public final FfmpegDecoderException decode(DecoderInputBuffer decoderInputBuffer, SimpleOutputBuffer simpleOutputBuffer, boolean z) {
        if (z) {
            this.nativeContext = ffmpegReset(this.nativeContext, this.extraData);
            if (this.nativeContext == 0) {
                return new FfmpegDecoderException("Error resetting (see logcat).");
            }
        }
        ByteBuffer byteBuffer = (ByteBuffer) Util.castNonNull(decoderInputBuffer.data);
        int limit = byteBuffer.limit();
        ByteBuffer init = simpleOutputBuffer.init(decoderInputBuffer.timeUs, this.outputBufferSize);
        int ffmpegDecode = ffmpegDecode(this.nativeContext, byteBuffer, limit, init, this.outputBufferSize);
        if (ffmpegDecode == -1) {
            simpleOutputBuffer.setFlags(Integer.MIN_VALUE);
            return null;
        } else if (ffmpegDecode == -2) {
            return new FfmpegDecoderException("Error decoding (see logcat).");
        } else {
            if (!this.hasOutputFormat) {
                this.channelCount = ffmpegGetChannelCount(this.nativeContext);
                this.sampleRate = ffmpegGetSampleRate(this.nativeContext);
                if (this.sampleRate == 0 && "alac".equals(this.codecName)) {
                    Assertions.checkNotNull(this.extraData);
                    ParsableByteArray parsableByteArray = new ParsableByteArray(this.extraData);
                    parsableByteArray.setPosition(this.extraData.length - 4);
                    this.sampleRate = parsableByteArray.readUnsignedIntToInt();
                }
                this.hasOutputFormat = true;
            }
            init.position(0);
            init.limit(ffmpegDecode);
            return null;
        }
    }

    public final void release() {
        super.release();
        ffmpegRelease(this.nativeContext);
        this.nativeContext = 0;
    }

    public final int getChannelCount() {
        return this.channelCount;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public final int getEncoding() {
        return this.encoding;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static byte[] getExtraData(String str, List<byte[]> list) {
        char c;
        switch (str.hashCode()) {
            case -1003765268:
                if (str.equals("audio/vorbis")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1504470054:
                if (str.equals("audio/alac")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1504891608:
                if (str.equals("audio/opus")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0 || c == 1) {
            return list.get(0);
        }
        if (c == 2) {
            return getAlacExtraData(list);
        }
        if (c != 3) {
            return null;
        }
        return getVorbisExtraData(list);
    }

    private static byte[] getAlacExtraData(List<byte[]> list) {
        byte[] bArr = list.get(0);
        int length = bArr.length + 12;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1634492771);
        allocate.putInt(0);
        allocate.put(bArr, 0, bArr.length);
        return allocate.array();
    }

    private static byte[] getVorbisExtraData(List<byte[]> list) {
        byte[] bArr = list.get(0);
        byte[] bArr2 = list.get(1);
        byte[] bArr3 = new byte[(bArr.length + bArr2.length + 6)];
        bArr3[0] = (byte) (bArr.length >> 8);
        bArr3[1] = (byte) (bArr.length & 255);
        System.arraycopy(bArr, 0, bArr3, 2, bArr.length);
        bArr3[bArr.length + 2] = 0;
        bArr3[bArr.length + 3] = 0;
        bArr3[bArr.length + 4] = (byte) (bArr2.length >> 8);
        bArr3[bArr.length + 5] = (byte) (bArr2.length & 255);
        System.arraycopy(bArr2, 0, bArr3, bArr.length + 6, bArr2.length);
        return bArr3;
    }
}
