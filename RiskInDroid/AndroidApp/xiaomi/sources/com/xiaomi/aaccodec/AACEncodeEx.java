package com.xiaomi.aaccodec;

import _m_j.cki;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class AACEncodeEx {
    private MediaCodec.BufferInfo bufferInfo;
    private ByteBuffer[] inputBuffers = null;
    private MediaCodec mAudioEncoder;
    private boolean mFirstFrame = true;
    private int mSampleRateIndex = 11;
    private ByteBuffer[] outputBuffers = null;
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private long presentationTimeUs = 0;

    @TargetApi(16)
    public void initial(int i, int i2, int i3) {
        this.mFirstFrame = true;
        try {
            int[] iArr = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
            for (int i4 = 0; i4 < 13; i4++) {
                if (iArr[i4] == i) {
                    this.mSampleRateIndex = i4;
                }
            }
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i, i2);
            createAudioFormat.setString("mime", "audio/mp4a-latm");
            createAudioFormat.setInteger("aac-profile", 2);
            createAudioFormat.setInteger("bitrate", i3);
            createAudioFormat.setInteger("sample-rate", i);
            createAudioFormat.setInteger("max-input-size", ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
            this.mAudioEncoder = MediaCodec.createEncoderByType("audio/mp4a-latm");
            this.mAudioEncoder.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.mAudioEncoder.start();
            this.inputBuffers = this.mAudioEncoder.getInputBuffers();
            this.outputBuffers = this.mAudioEncoder.getOutputBuffers();
            this.bufferInfo = new MediaCodec.BufferInfo();
        } catch (Exception e) {
            this.mAudioEncoder = null;
            this.inputBuffers = null;
            this.outputBuffers = null;
            this.bufferInfo = null;
            cki.O00000oO("AACEncodeEx", "initial Exception:" + e.getLocalizedMessage());
        }
    }

    public void release() {
        try {
            if (this.mAudioEncoder != null) {
                this.mAudioEncoder.stop();
                this.mAudioEncoder.release();
                this.mAudioEncoder = null;
            }
            this.inputBuffers = null;
            this.outputBuffers = null;
            this.bufferInfo = null;
        } catch (Exception e) {
            cki.O00000oO("AACEncodeEx", "release Exception:" + e.getLocalizedMessage());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, long):void}
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void} */
    public byte[] encode(byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            int dequeueInputBuffer = this.mAudioEncoder.dequeueInputBuffer(-1);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = this.inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr);
                byteBuffer.limit(bArr.length);
                computePresentationTime(this.presentationTimeUs);
                this.mAudioEncoder.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, 0, 0);
                this.presentationTimeUs++;
            }
            int dequeueOutputBuffer = this.mAudioEncoder.dequeueOutputBuffer(this.bufferInfo, -1);
            while (dequeueOutputBuffer >= 0) {
                int i3 = this.bufferInfo.size;
                int i4 = i3 + 7;
                ByteBuffer byteBuffer2 = this.outputBuffers[dequeueOutputBuffer];
                byteBuffer2.position(this.bufferInfo.offset);
                byteBuffer2.limit(this.bufferInfo.offset + i3);
                byte[] bArr2 = new byte[i4];
                addADTStoPacket(bArr2, i4);
                byteBuffer2.get(bArr2, 7, i3);
                byteBuffer2.position(this.bufferInfo.offset);
                this.outputStream.write(bArr2);
                this.mAudioEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = this.mAudioEncoder.dequeueOutputBuffer(this.bufferInfo, 0);
            }
            byte[] byteArray = this.outputStream.toByteArray();
            this.outputStream.flush();
            this.outputStream.reset();
            return byteArray;
        } catch (Exception e) {
            cki.O00000oO("AACEncodeEx", "encode Exception:" + e.getLocalizedMessage());
            return null;
        }
    }

    private void addADTStoPacket(byte[] bArr, int i) {
        int i2 = this.mSampleRateIndex;
        bArr[0] = -1;
        bArr[1] = -15;
        bArr[2] = (byte) ((i2 << 2) + 64 + 0);
        bArr[3] = (byte) ((i >> 11) + 64);
        bArr[4] = (byte) ((i & 2047) >> 3);
        bArr[5] = (byte) (((i & 7) << 5) + 31);
        bArr[6] = -4;
    }

    private long computePresentationTime(long j) {
        return ((j * 90000) * 1024) / 44100;
    }
}
