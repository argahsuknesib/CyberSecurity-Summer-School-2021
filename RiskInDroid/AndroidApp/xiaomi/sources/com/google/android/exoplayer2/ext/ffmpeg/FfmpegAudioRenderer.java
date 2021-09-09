package com.google.android.exoplayer2.ext.ffmpeg;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DecoderAudioRenderer;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;

public final class FfmpegAudioRenderer extends DecoderAudioRenderer {
    private FfmpegAudioDecoder decoder;
    private final boolean enableFloatOutput;

    public final String getName() {
        return "FfmpegAudioRenderer";
    }

    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public FfmpegAudioRenderer() {
        this(null, null, new AudioProcessor[0]);
    }

    public FfmpegAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, new DefaultAudioSink(null, audioProcessorArr), false);
    }

    public FfmpegAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink, boolean z) {
        super(handler, audioRendererEventListener, audioSink);
        this.enableFloatOutput = z;
    }

    public final int supportsFormatInternal(Format format) {
        String str = (String) Assertions.checkNotNull(format.sampleMimeType);
        if (!FfmpegLibrary.isAvailable() || !MimeTypes.isAudio(str)) {
            return 0;
        }
        if (!FfmpegLibrary.supportsFormat(str) || !isOutputSupported(format)) {
            return 1;
        }
        return (format.drmInitData == null || format.exoMediaCryptoType != null) ? 4 : 2;
    }

    /* access modifiers changed from: protected */
    public final FfmpegAudioDecoder createDecoder(Format format, ExoMediaCrypto exoMediaCrypto) throws FfmpegDecoderException {
        TraceUtil.beginSection("createFfmpegAudioDecoder");
        this.decoder = new FfmpegAudioDecoder(16, 16, format.maxInputSize != -1 ? format.maxInputSize : 5760, format, shouldUseFloatOutput(format));
        TraceUtil.endSection();
        return this.decoder;
    }

    public final Format getOutputFormat() {
        Assertions.checkNotNull(this.decoder);
        return new Format.Builder().setSampleMimeType("audio/raw").setChannelCount(this.decoder.getChannelCount()).setSampleRate(this.decoder.getSampleRate()).setPcmEncoding(this.decoder.getEncoding()).build();
    }

    private boolean isOutputSupported(Format format) {
        return shouldUseFloatOutput(format) || supportsOutput(format.channelCount, 2);
    }

    private boolean shouldUseFloatOutput(Format format) {
        Assertions.checkNotNull(format.sampleMimeType);
        if (!this.enableFloatOutput || !supportsOutput(format.channelCount, 4)) {
            return false;
        }
        String str = format.sampleMimeType;
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 187078296) {
            if (hashCode == 187094639 && str.equals("audio/raw")) {
                c = 0;
            }
        } else if (str.equals("audio/ac3")) {
            c = 1;
        }
        if (c != 0) {
            if (c != 1) {
                return true;
            }
            return false;
        } else if (format.pcmEncoding == 536870912 || format.pcmEncoding == 805306368 || format.pcmEncoding == 4) {
            return true;
        } else {
            return false;
        }
    }
}
