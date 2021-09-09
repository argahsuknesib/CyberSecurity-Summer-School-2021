package com.google.android.exoplayer2.ext.ffmpeg;

import com.google.android.exoplayer2.decoder.DecoderException;

public final class FfmpegDecoderException extends DecoderException {
    FfmpegDecoderException(String str) {
        super(str);
    }

    FfmpegDecoderException(String str, Throwable th) {
        super(str, th);
    }
}
