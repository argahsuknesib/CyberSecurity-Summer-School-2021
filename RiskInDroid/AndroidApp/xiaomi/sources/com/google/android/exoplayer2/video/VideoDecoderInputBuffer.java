package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

public class VideoDecoderInputBuffer extends DecoderInputBuffer {
    public ColorInfo colorInfo;

    public VideoDecoderInputBuffer() {
        super(2);
    }
}
