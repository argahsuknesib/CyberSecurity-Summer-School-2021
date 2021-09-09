package com.mijia.generalplayer.exo;

import _m_j.cki;
import _m_j.frx;
import _m_j.fvo;
import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.xiaomi.smarthome.fastvideo.decoder.MediaCodecUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class MJExoRenderersFactory extends DefaultRenderersFactory {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f5194O000000o;

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0031, code lost:
        if (_m_j.fvo.O0000o() != false) goto L_0x0033;
     */
    public MJExoRenderersFactory(Context context) {
        super(context);
        boolean z;
        boolean z2 = false;
        if (frx.O000000o(new MediaCodecUtil.CodecKey(2, 2304, 1080)) == null) {
            cki.O00000oO("MJExoRenderersFactory", "not support 2K hard decoder");
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            fvo.O000000o();
            if (fvo.O0000oo0()) {
                fvo.O000000o();
            }
            this.f5194O000000o = z2;
            setExtensionRendererMode(1);
        }
        z2 = true;
        this.f5194O000000o = z2;
        setExtensionRendererMode(1);
    }

    public void buildVideoRenderers(Context context, int i, MediaCodecSelector mediaCodecSelector, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, long j, ArrayList<Renderer> arrayList) {
        super.buildVideoRenderers(context, i, mediaCodecSelector, z, handler, videoRendererEventListener, j, arrayList);
        cki.O00000Oo("MJExoRenderersFactory", "buildVideoRenderers mForceSoftDecoder:%b", Boolean.valueOf(this.f5194O000000o));
        if (this.f5194O000000o) {
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
