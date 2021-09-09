package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.art.ARTVirtualNode;

public class gdo extends LayoutShadowNode implements TextureView.SurfaceTextureListener, LifecycleEventListener {

    /* renamed from: O000000o  reason: collision with root package name */
    static final /* synthetic */ boolean f17565O000000o = (!gdo.class.desiredAssertionStatus());
    private Surface O00000Oo;
    private Integer O00000o;
    private SurfaceTexture O00000o0;
    private Handler O00000oO;

    public boolean isVirtual() {
        return false;
    }

    public boolean isVirtualAnchor() {
        return true;
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @ReactProp(customType = "Color", name = "backgroundColor")
    public void setBackgroundColor(Integer num) {
        this.O00000o = num;
        markUpdated();
    }

    public boolean dispatchUpdates(float f, float f2, UIViewOperationQueue uIViewOperationQueue, NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        boolean dispatchUpdates = super.dispatchUpdates(f, f2, uIViewOperationQueue, nativeViewHierarchyOptimizer);
        if (this.O00000oO == null) {
            this.O00000oO = new Handler(Looper.myLooper());
        }
        if (hasUnseenUpdates() || dispatchUpdates) {
            SurfaceTexture surfaceTexture = this.O00000o0;
            if (surfaceTexture != null) {
                surfaceTexture.setDefaultBufferSize(getScreenWidth(), getScreenHeight());
            }
            O000000o();
            uIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), this);
        }
        return dispatchUpdates;
    }

    /* access modifiers changed from: private */
    public void O000000o() {
        Surface surface = this.O00000Oo;
        if (surface == null || !surface.isValid()) {
            O000000o(this);
            return;
        }
        try {
            Canvas lockCanvas = this.O00000Oo.lockCanvas(null);
            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            if (this.O00000o != null) {
                lockCanvas.drawColor(this.O00000o.intValue());
            }
            Paint paint = new Paint();
            for (int i = 0; i < getChildCount(); i++) {
                ARTVirtualNode aRTVirtualNode = (ARTVirtualNode) getChildAt(i);
                aRTVirtualNode.draw(lockCanvas, paint, 1.0f);
                aRTVirtualNode.markUpdateSeen();
            }
            if (this.O00000Oo != null) {
                this.O00000Oo.unlockCanvasAndPost(lockCanvas);
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            FLog.e("ReactNative", e.getClass().getSimpleName() + " in Surface.unlockCanvasAndPost");
        }
    }

    private void O000000o(ReactShadowNode reactShadowNode) {
        for (int i = 0; i < reactShadowNode.getChildCount(); i++) {
            ReactShadowNode childAt = reactShadowNode.getChildAt(i);
            childAt.markUpdateSeen();
            O000000o(childAt);
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.O00000o0 = surfaceTexture;
        this.O00000Oo = new Surface(surfaceTexture);
        if (!(i == getScreenWidth() && i2 == getScreenHeight())) {
            if (f17565O000000o || this.O00000o0 != null) {
                this.O00000o0.setDefaultBufferSize(getScreenWidth(), getScreenHeight());
            } else {
                throw new AssertionError();
            }
        }
        Handler handler = this.O00000oO;
        if (handler != null) {
            handler.post(new Runnable() {
                /* class _m_j.$$Lambda$gdo$nm0yrzcFUUyYERyv90hfm7Oini4 */

                public final void run() {
                    gdo.this.O000000o();
                }
            });
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        surfaceTexture.release();
        this.O00000o0 = null;
        this.O00000Oo = null;
        return true;
    }

    public void setThemedContext(ThemedReactContext themedReactContext) {
        super.setThemedContext(themedReactContext);
        if (themedReactContext != null) {
            themedReactContext.addLifecycleEventListener(this);
        }
    }

    public void dispose() {
        if (getThemedContext() != null) {
            getThemedContext().removeLifecycleEventListener(this);
        }
        super.dispose();
    }

    public void onHostResume() {
        O000000o();
    }
}
