package com.hs.cloudvideo;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.ArrayList;
import java.util.Iterator;

public class HSExoRenderersFactory extends DefaultRenderersFactory {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f4403O000000o;

    public HSExoRenderersFactory(Context context) {
        this(context, null);
    }

    public HSExoRenderersFactory(Context context, VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer) {
        super(context, videoDecoderOutputBufferRenderer);
        this.f4403O000000o = true;
        setExtensionRendererMode(1);
    }

    public void buildVideoRenderers(Context context, int i, MediaCodecSelector mediaCodecSelector, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, long j, ArrayList<Renderer> arrayList) {
        super.buildVideoRenderers(context, i, mediaCodecSelector, z, handler, videoRendererEventListener, j, arrayList);
        if (this.f4403O000000o) {
            Iterator<Renderer> it = arrayList.iterator();
            while (it.hasNext()) {
                Renderer next = it.next();
                if (next instanceof MediaCodecVideoRenderer) {
                    arrayList.remove(next);
                    return;
                }
            }
        }
    }
}
