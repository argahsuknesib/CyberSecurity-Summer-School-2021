package _m_j;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.ArrayList;
import java.util.Iterator;

public final class uk extends DefaultRenderersFactory {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f2533O000000o;

    public uk(Context context, boolean z) {
        super(context);
        this.f2533O000000o = z;
    }

    public final void buildVideoRenderers(Context context, int i, MediaCodecSelector mediaCodecSelector, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, long j, ArrayList<Renderer> arrayList) {
        super.buildVideoRenderers(context, this.f2533O000000o ? 1 : 0, mediaCodecSelector, z, handler, videoRendererEventListener, j, arrayList);
        if (this.f2533O000000o) {
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
