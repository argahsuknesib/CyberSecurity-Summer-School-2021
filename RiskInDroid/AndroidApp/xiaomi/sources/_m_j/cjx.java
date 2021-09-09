package _m_j;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.mijia.generalplayer.gl.PhotoView;
import com.xiaomi.smarthome.camera.XmVideoViewGl;

public abstract class cjx implements XmVideoViewGl {

    /* renamed from: O000000o  reason: collision with root package name */
    public PhotoView f13958O000000o;
    private View O00000Oo;
    private cjv O00000o;
    private Context O00000o0;

    public void setHeight(int i) {
    }

    public void setWidth(int i) {
    }

    /* access modifiers changed from: protected */
    public final void O000000o(PhotoView photoView) {
        Window window;
        this.O00000o0 = photoView.getContext();
        this.f13958O000000o = photoView;
        this.O00000Oo = (View) this.f13958O000000o.getParent();
        Context context = getContext();
        if (!(context == null || !(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null)) {
            window.addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        }
        this.O00000o = new cjv(this.f13958O000000o);
    }

    public void snap(XmVideoViewGl.PhotoSnapCallback photoSnapCallback) {
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            photoView.O000000o(photoSnapCallback);
        }
    }

    public void setDirectionCtrlListener(XmVideoViewGl.OnDirectionCtrlListener onDirectionCtrlListener) {
        cjv cjv = this.O00000o;
        if (cjv != null) {
            cjv.O0000OoO = onDirectionCtrlListener;
        }
    }

    public void onPause() {
        cki.O00000o("VideoViewGlBase", "onpause");
        this.f13958O000000o.onPause();
    }

    public void setVisible(boolean z) {
        cki.O00000o("VideoViewGlBase", "setVisible:".concat(String.valueOf(z)));
        this.f13958O000000o.setVisibility(z ? 0 : 8);
    }

    public void onResume() {
        cki.O00000o("VideoViewGlBase", "onresume");
        this.f13958O000000o.onResume();
    }

    public void initial() {
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            photoView.onResume();
        }
    }

    public void setVideoViewListener(XmVideoViewGl.IVideoViewListener iVideoViewListener) {
        cjv cjv = this.O00000o;
        if (cjv != null) {
            cjv.O0000Oo0 = iVideoViewListener;
        }
    }

    public void setBg(float f, float f2, float f3) {
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            photoView.O000000o(f, f2, f3);
        }
    }

    public void setAlpha(float f) {
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            photoView.setAlpha(f);
        }
    }

    public void setFirstBitmap(Bitmap bitmap) {
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            photoView.setFirstBitmap(bitmap);
        }
    }

    public void clearQueue() {
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            photoView.O00000oO();
        }
    }

    public void release() {
        this.O00000o0 = null;
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            photoView.onPause();
        }
        cjv cjv = this.O00000o;
        if (cjv != null) {
            cjv.O0000O0o = null;
            cjv.O0000OOo = null;
        }
    }

    public void releaseOnlySelf() {
        release();
    }

    public void setAutoRelease(boolean z) {
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            photoView.setAutoRelease(z);
        }
    }

    public void setMiniScale(boolean z) {
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            photoView.setMinScale(z);
        }
    }

    public void setRotation(int i) {
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            photoView.setRotation(i);
        }
    }

    public void setIsFull(boolean z) {
        O000000o(z);
        cjv cjv = this.O00000o;
        if (cjv != null) {
            cjv.O00000Oo(3);
        }
    }

    public void setIsFullForRN(boolean z) {
        O000000o(z);
    }

    public int drawBitmap(XmVideoViewGl.IDrawBitmapCallback iDrawBitmapCallback, Bitmap bitmap, RectF rectF) {
        return this.f13958O000000o.O000000o(iDrawBitmapCallback, bitmap, rectF);
    }

    public void updateBitmap(int i, Bitmap bitmap, RectF rectF) {
        this.f13958O000000o.O000000o(i, bitmap, rectF);
    }

    public void removeBitmap(int i) {
        this.f13958O000000o.O000000o(i);
    }

    public void setVideoFrameSize(int i, int i2, boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.O00000Oo.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 17;
        this.O00000Oo.setLayoutParams(layoutParams);
        O000000o(z);
    }

    private void O000000o(boolean z) {
        cjv cjv = this.O00000o;
        if (cjv != null) {
            cjv.O00000oO = z;
        }
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            photoView.setIsFullForRN(z);
        }
    }

    public void setTouch(boolean z) {
        cjv cjv = this.O00000o;
        if (cjv != null) {
            cjv.O00000o = z;
        }
    }

    public Context getContext() {
        return this.O00000o0;
    }

    public void setScale(float f, boolean z) {
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            photoView.O000000o(f, z);
        }
    }

    public void setRNScale(float f, boolean z) {
        cki.O00000o0("VideoViewGlBase", "setRNScale %f", Float.valueOf(f));
        if (this.f13958O000000o != null && f > 0.0f) {
            float miniScale = getMiniScale();
            if (miniScale > 0.0f) {
                this.f13958O000000o.O000000o(f * miniScale, z);
            } else {
                this.f13958O000000o.setInitRelativeScale(f);
            }
        }
    }

    public float getMiniScale() {
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            return photoView.getMinScale();
        }
        return 0.0f;
    }

    public float getScale() {
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            return photoView.O00000o;
        }
        return 0.0f;
    }

    public View getSurfaceView() {
        return this.f13958O000000o;
    }

    public void setOnScaleListener(XmVideoViewGl.OnScaleListener onScaleListener) {
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            photoView.setOnScaleListener(onScaleListener);
        }
    }

    public void setOnRNScaleListener(final XmVideoViewGl.OnScaleListener onScaleListener) {
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            photoView.setOnScaleListener(new XmVideoViewGl.OnScaleListener() {
                /* class _m_j.cjx.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final XmVideoViewGl.OnScaleListener f13959O000000o = onScaleListener;

                public final void onScaleChage(float f) {
                    if (this.f13959O000000o != null && cjx.this.f13958O000000o != null && f > 0.0f) {
                        float minScale = cjx.this.f13958O000000o.getMinScale();
                        if (f > 0.0f && minScale > 0.0f) {
                            this.f13959O000000o.onScaleChage(f / minScale);
                        }
                    }
                }

                public final void onFirstVideoShow() {
                    XmVideoViewGl.OnScaleListener onScaleListener = this.f13959O000000o;
                    if (onScaleListener != null) {
                        onScaleListener.onFirstVideoShow();
                    }
                }
            });
        }
    }

    public void setMaxScale(float f, float f2) {
        PhotoView photoView = this.f13958O000000o;
        if (photoView != null) {
            photoView.O000000o(f, f2);
        }
    }

    public void setVideoViewScaleListener(XmVideoViewGl.IVideoViewScaleListener iVideoViewScaleListener) {
        cjv cjv = this.O00000o;
        if (cjv != null) {
            cjv.O0000Oo = iVideoViewScaleListener;
        }
    }
}
