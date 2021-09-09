package com.google.android.exoplayer2.ext.ffmpeg;

import _m_j.iht;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderInputBuffer;
import com.google.android.exoplayer2.video.VideoDecoderOutputBuffer;
import java.nio.ByteBuffer;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

final class FfmpegVideoDecoder extends SimpleDecoder<VideoDecoderInputBuffer, VideoDecoderOutputBuffer, FfmpegDecoderException> {
    private final String codecName;
    private final byte[] extraData;
    private Format format;
    private boolean isHSVideo;
    private long nativeContext;
    private volatile int outputMode;
    private long sampleTimestamp;

    private native long ffmpegInitialize(String str, byte[] bArr, int i);

    private native int ffmpegReceiveFrame(long j, int i, VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z);

    private native void ffmpegRelease(long j);

    private native int ffmpegRenderFrame(long j, Surface surface, VideoDecoderOutputBuffer videoDecoderOutputBuffer, int i, int i2);

    private native long ffmpegReset(long j);

    private native int ffmpegSendPacket(long j, ByteBuffer byteBuffer, int i, long j2);

    public FfmpegVideoDecoder(int i, int i2, int i3, int i4, Format format2) throws FfmpegDecoderException {
        super(new VideoDecoderInputBuffer[i], new VideoDecoderOutputBuffer[i2]);
        if (FfmpegLibrary.isAvailable()) {
            this.codecName = (String) Assertions.checkNotNull(FfmpegLibrary.getCodecName(format2.sampleMimeType));
            this.extraData = getExtraData(format2.sampleMimeType, format2.initializationData);
            this.format = format2;
            this.nativeContext = ffmpegInitialize(this.codecName, this.extraData, i4);
            if (this.nativeContext != 0) {
                setInitialInputBufferSize(i3);
                return;
            }
            throw new FfmpegDecoderException("Failed to initialize decoder.");
        }
        throw new FfmpegDecoderException("Failed to load decoder native library.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    private static byte[] getExtraData(String str, List<byte[]> list) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -1662541442) {
            if (hashCode == 1331836730 && str.equals("video/avc")) {
                c = 0;
                if (c == 0) {
                    byte[] bArr = list.get(0);
                    byte[] bArr2 = list.get(1);
                    byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
                    System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
                    System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
                    return bArr3;
                } else if (c != 1) {
                    return null;
                } else {
                    return list.get(0);
                }
            }
        } else if (str.equals("video/hevc")) {
            c = 1;
            if (c == 0) {
            }
        }
        c = 65535;
        if (c == 0) {
        }
    }

    public final String getName() {
        return "ffmpeg" + FfmpegLibrary.getVersion() + "-" + this.codecName;
    }

    public final void setOutputMode(int i) {
        this.outputMode = i;
    }

    /* access modifiers changed from: protected */
    public final VideoDecoderInputBuffer createInputBuffer() {
        return new VideoDecoderInputBuffer();
    }

    /* access modifiers changed from: protected */
    public final VideoDecoderOutputBuffer createOutputBuffer() {
        return new VideoDecoderOutputBuffer(new OutputBuffer.Owner() {
            /* class com.google.android.exoplayer2.ext.ffmpeg.$$Lambda$FfmpegVideoDecoder$aKIa3iYcJgAPIYJl9C43FSmyFU */

            public final void releaseOutputBuffer(OutputBuffer outputBuffer) {
                FfmpegVideoDecoder.this.releaseOutputBuffer((VideoDecoderOutputBuffer) outputBuffer);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final FfmpegDecoderException decode(VideoDecoderInputBuffer videoDecoderInputBuffer, VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z) {
        VideoDecoderInputBuffer videoDecoderInputBuffer2 = videoDecoderInputBuffer;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = videoDecoderOutputBuffer;
        if (z) {
            this.nativeContext = ffmpegReset(this.nativeContext);
            if (this.nativeContext == 0) {
                return new FfmpegDecoderException("Error resetting (see logcat).");
            }
        }
        if (this.isHSVideo && videoDecoderInputBuffer2.data != null && videoDecoderInputBuffer2.timeUs == 0) {
            byte[] bArr = new byte[videoDecoderInputBuffer2.data.remaining()];
            videoDecoderInputBuffer2.data.get(bArr, 0, bArr.length);
            String O000000o2 = iht.O000000o(bArr);
            if (O000000o2 != null) {
                videoDecoderOutputBuffer2.videoParams = O000000o2;
                try {
                    this.sampleTimestamp = (new JSONObject(O000000o2).optLong("timestamp") / 1000) * 1000;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        ByteBuffer byteBuffer = (ByteBuffer) Util.castNonNull(videoDecoderInputBuffer2.data);
        int ffmpegSendPacket = ffmpegSendPacket(this.nativeContext, byteBuffer, byteBuffer.limit(), videoDecoderInputBuffer2.timeUs);
        if (ffmpegSendPacket == -1) {
            videoDecoderOutputBuffer2.setFlags(Integer.MIN_VALUE);
            return null;
        }
        if (ffmpegSendPacket == -3) {
            Log.d("FfmpegVideoDecoder", "VIDEO_DECODER_ERROR_READ_FRAME: timeUs=" + videoDecoderInputBuffer2.timeUs);
        } else if (ffmpegSendPacket == -2) {
            return new FfmpegDecoderException("ffmpegDecode error: (see logcat)");
        }
        boolean isDecodeOnly = videoDecoderInputBuffer.isDecodeOnly();
        int ffmpegReceiveFrame = ffmpegReceiveFrame(this.nativeContext, this.outputMode, videoDecoderOutputBuffer, isDecodeOnly);
        if (ffmpegReceiveFrame == -2) {
            return new FfmpegDecoderException("ffmpegDecode error: (see logcat)");
        }
        if (ffmpegReceiveFrame == -1) {
            videoDecoderOutputBuffer2.addFlag(Integer.MIN_VALUE);
        }
        if (!isDecodeOnly) {
            videoDecoderOutputBuffer2.colorInfo = videoDecoderInputBuffer2.colorInfo;
        }
        if (!this.isHSVideo || ffmpegReceiveFrame != 0) {
            return null;
        }
        videoDecoderOutputBuffer2.timestamp = this.sampleTimestamp + (videoDecoderInputBuffer2.timeUs / 1000);
        return null;
    }

    /* access modifiers changed from: protected */
    public final FfmpegDecoderException createUnexpectedDecodeException(Throwable th) {
        return new FfmpegDecoderException("Unexpected decode error", th);
    }

    public final void release() {
        super.release();
        ffmpegRelease(this.nativeContext);
        this.nativeContext = 0;
    }

    public final void renderToSurface(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) throws FfmpegDecoderException {
        if (videoDecoderOutputBuffer.mode == 1) {
            if (ffmpegRenderFrame(this.nativeContext, surface, videoDecoderOutputBuffer, videoDecoderOutputBuffer.width, videoDecoderOutputBuffer.height) == -2) {
                throw new FfmpegDecoderException("Buffer render error: ");
            }
            return;
        }
        throw new FfmpegDecoderException("Invalid output mode.");
    }

    public final void setHSVideo(boolean z) {
        this.isHSVideo = z;
    }
}
