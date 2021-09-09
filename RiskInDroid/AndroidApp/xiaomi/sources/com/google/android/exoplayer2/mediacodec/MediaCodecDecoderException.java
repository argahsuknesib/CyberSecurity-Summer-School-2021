package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.util.Util;

public class MediaCodecDecoderException extends DecoderException {
    public final MediaCodecInfo codecInfo;
    public final String diagnosticInfo;

    /* JADX WARNING: Illegal instructions before constructor call */
    public MediaCodecDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo) {
        super(r0.toString(), th);
        StringBuilder sb = new StringBuilder("Decoder failed: ");
        String str = null;
        sb.append(mediaCodecInfo == null ? null : mediaCodecInfo.name);
        this.codecInfo = mediaCodecInfo;
        this.diagnosticInfo = Util.SDK_INT >= 21 ? getDiagnosticInfoV21(th) : str;
    }

    private static String getDiagnosticInfoV21(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        return null;
    }
}
