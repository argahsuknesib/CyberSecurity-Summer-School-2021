package _m_j;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.R;

public final class cqe extends cpq<TextureView, SurfaceTexture> {
    public cqe(Context context, ViewGroup viewGroup) {
        super(context, viewGroup, null);
    }

    /* access modifiers changed from: package-private */
    public final Class<SurfaceTexture> O000000o() {
        return SurfaceTexture.class;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(GmsLogger.MAX_PII_TAG_LENGTH)
    public final void O000000o(int i, int i2) {
        super.O000000o(i, i2);
        if (((TextureView) this.O00000o).getSurfaceTexture() != null) {
            ((TextureView) this.O00000o).getSurfaceTexture().setDefaultBufferSize(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object O00000Oo() {
        return ((TextureView) this.O00000o).getSurfaceTexture();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public final /* synthetic */ View O000000o(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.cameraview_texture_view, viewGroup, false);
        viewGroup.addView(inflate, 0);
        TextureView textureView = (TextureView) inflate.findViewById(R.id.texture_view);
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            /* class _m_j.cqe.AnonymousClass1 */

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                cqe.this.O00000Oo(i, i2);
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                cqe.this.O00000o0(i, i2);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                cqe.this.O00000o();
                return true;
            }
        });
        return textureView;
    }
}
