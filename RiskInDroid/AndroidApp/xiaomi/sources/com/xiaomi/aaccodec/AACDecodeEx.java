package com.xiaomi.aaccodec;

import _m_j.cki;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;

public class AACDecodeEx {
    private MediaCodec.BufferInfo bufferInfo;
    private ByteBuffer[] inputBuffers = null;
    MediaCodec mAudioDecoder;
    private ByteBuffer[] outputBuffers = null;

    @TargetApi(16)
    public void initial() {
        try {
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 8000, 1);
            createAudioFormat.setString("mime", "audio/mp4a-latm");
            createAudioFormat.setInteger("bitrate", 16000);
            createAudioFormat.setInteger("is-adts", 1);
            createAudioFormat.setInteger("aac-profile", 2);
            this.mAudioDecoder = MediaCodec.createDecoderByType("audio/mp4a-latm");
            this.mAudioDecoder.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MediaCodec mediaCodec = this.mAudioDecoder;
        if (mediaCodec == null) {
            cki.O00000oO("AACDecodeEx", "mAudioDecoder is null");
        } else {
            mediaCodec.start();
        }
    }

    @TargetApi(16)
    public void initial(int i, int i2, int i3) {
        try {
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i, i2);
            createAudioFormat.setString("mime", "audio/mp4a-latm");
            createAudioFormat.setInteger("bitrate", i3);
            createAudioFormat.setInteger("is-adts", 1);
            createAudioFormat.setInteger("aac-profile", 2);
            this.mAudioDecoder = MediaCodec.createDecoderByType("audio/mp4a-latm");
            this.mAudioDecoder.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MediaCodec mediaCodec = this.mAudioDecoder;
        if (mediaCodec == null) {
            cki.O00000oO("AACDecodeEx", "mAudioDecoder is null");
            return;
        }
        mediaCodec.start();
        this.inputBuffers = this.mAudioDecoder.getInputBuffers();
        this.outputBuffers = this.mAudioDecoder.getOutputBuffers();
        this.bufferInfo = new MediaCodec.BufferInfo();
    }

    @TargetApi(16)
    public void release() {
        MediaCodec mediaCodec = this.mAudioDecoder;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.mAudioDecoder.release();
            this.mAudioDecoder = null;
        }
        this.inputBuffers = null;
        this.outputBuffers = null;
        this.bufferInfo = null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, long):void}
      ClspMth{android.media.MediaCodec.releaseOutputBuffer(int, boolean):void} */
    @TargetApi(16)
    public int decode(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (bArr != null && bArr.length > 0) {
            try {
                int dequeueInputBuffer = this.mAudioDecoder.dequeueInputBuffer(-1);
                if (dequeueInputBuffer > 0) {
                    ByteBuffer byteBuffer = this.inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.limit(bArr.length);
                    this.mAudioDecoder.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, 0, 0);
                }
                while (true) {
                    int dequeueOutputBuffer = this.mAudioDecoder.dequeueOutputBuffer(this.bufferInfo, -1);
                    if (dequeueOutputBuffer <= 0) {
                        break;
                    }
                    ByteBuffer byteBuffer2 = this.outputBuffers[dequeueOutputBuffer];
                    int i4 = this.bufferInfo.size;
                    byteBuffer2.get(new byte[this.bufferInfo.size]);
                    byteBuffer2.clear();
                    this.mAudioDecoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                }
            } catch (Exception e) {
                cki.O00000oO("AACDecodeEx", "decode Exception:" + e.getLocalizedMessage());
            }
        }
        return 0;
    }
}
