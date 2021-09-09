package com.xiaomi.smarthome.fastvideo.decoder;

import com.xiaomi.smarthome.fastvideo.decoder.MediaCodecUtil;

public interface MediaCodecSelector {
    public static final MediaCodecSelector DEFAULT = new MediaCodecSelector() {
        /* class com.xiaomi.smarthome.fastvideo.decoder.MediaCodecSelector.AnonymousClass1 */

        public final MediaCodecInfo getDecoderInfo(MediaCodecUtil.CodecKey codecKey) throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.getDecoderInfo(codecKey);
        }

        public final MediaCodecInfo getPassthroughDecoderInfo() throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.getPassthroughDecoderInfo();
        }
    };

    MediaCodecInfo getDecoderInfo(MediaCodecUtil.CodecKey codecKey) throws MediaCodecUtil.DecoderQueryException;

    MediaCodecInfo getPassthroughDecoderInfo() throws MediaCodecUtil.DecoderQueryException;
}
