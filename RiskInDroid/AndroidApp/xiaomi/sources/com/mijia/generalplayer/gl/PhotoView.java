package com.mijia.generalplayer.gl;

import _m_j.cjp;
import _m_j.cjq;
import _m_j.cjr;
import _m_j.cju;
import _m_j.cjw;
import _m_j.cki;
import _m_j.ckj;
import _m_j.ckk;
import _m_j.ckp;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.renderscript.Matrix4f;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.mijia.generalplayer.gl.PhotoView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class PhotoView extends GLSurfaceView {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f5197O000000o;
    public int O00000Oo;
    public float O00000o = 1.0f;
    public int O00000o0;
    public float O00000oO = 0.0f;
    public float O00000oo = 0.0f;
    protected boolean O0000O0o = false;
    protected cjq O0000OOo;
    protected boolean O0000Oo;
    protected cju O0000Oo0;
    protected Context O0000OoO;
    boolean O0000Ooo = false;
    float O0000o = 0.0f;
    float O0000o0 = 0.0f;
    float O0000o00 = 0.0f;
    float O0000o0O;
    float O0000o0o = 0.0f;
    int O0000oO;
    public int O0000oO0;
    float O0000oOO;
    float O0000oOo = 3.0f;
    boolean O0000oo = false;
    float O0000oo0 = 3.0f;
    long O0000ooO;
    long O0000ooo = 300;
    float O000O00o = 0.0f;
    float O000O0OO = 0.0f;
    boolean O000O0Oo = false;
    int O000O0o = 0;
    cju O000O0o0;
    volatile int O000O0oO = 0;
    boolean O000O0oo = false;
    public float O000OO = 1.0f;
    boolean O000OO00 = false;
    Interpolator O000OO0o = new AccelerateDecelerateInterpolator();
    public O000000o O000OOOo = null;
    public Bitmap O000OOo;
    public XmVideoViewGl.OnScaleListener O000OOo0;
    public boolean O000OOoO;
    protected boolean O000OOoo;
    public boolean O000Oo0;
    public int O000Oo00;
    public float O000Oo0O;
    public boolean O000Oo0o;
    public float O000OoO;
    public float O000OoO0;
    private final O00000Oo O000OoOO = new O00000Oo();
    private boolean O000OoOo = false;
    private float O000Ooo;
    private float O000Ooo0;
    public boolean O00O0Oo;
    boolean O00oOoOo = false;
    float O00oOooO = 1.0f;
    float O00oOooo = 0.0f;

    public interface O000000o {
    }

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        cju f5199O000000o;
        RectF O00000Oo;
    }

    public void O00000o() {
    }

    public void O00000oO() {
    }

    public PhotoView(Context context) {
        super(context);
        O0000O0o();
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O0000O0o();
    }

    public PhotoView(Context context, boolean z, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O000OOoO = z;
        this.O000OOoo = true;
        O0000O0o();
    }

    public final void O000000o(XmVideoViewGl.PhotoSnapCallback photoSnapCallback) {
        this.O000OoOO.O000000o(photoSnapCallback);
    }

    private void O0000O0o() {
        if (O000000o(getContext())) {
            this.O0000OoO = getContext();
            setEGLContextClientVersion(2);
            setEGLConfigChooser(new cjp.O00000Oo());
            getHolder().setFormat(-3);
            setRenderer(this.O000OoOO);
            setRenderMode(0);
            if (this.O000OOoO) {
                this.O000OOo = BitmapFactory.decodeResource(this.O0000OoO.getResources(), R.drawable.floating_window_mask);
                Bitmap createBitmap = Bitmap.createBitmap(256, 192, Bitmap.Config.RGB_565);
                createBitmap.eraseColor(Color.parseColor("#141414"));
                setFirstBitmap(createBitmap);
                return;
            }
            return;
        }
        throw new RuntimeException("not support gles 2.0");
    }

    private static boolean O000000o(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }

    public void setOnScreenWindowChangedListener(O000000o o000000o) {
        this.O000OOOo = o000000o;
    }

    public int getmOffsetX() {
        return (int) this.O0000o0o;
    }

    public int getmOffsetY() {
        return (int) this.O0000o;
    }

    public int getmMaxOffsetX() {
        return this.O0000oO0;
    }

    public int getmMaxOffsetY() {
        return this.O0000oO;
    }

    public float getRatioOffsetX() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5 = this.O0000o0o / ((float) this.O0000oO0);
        float f6 = this.O00000o;
        float f7 = this.O000OoO0;
        if (f7 < 1.0f) {
            if (f5 >= 0.0f) {
                f4 = f6 - f7;
            } else {
                f3 = f6 - f7;
                f2 = (f3 / f6) / 2.0f;
                f = 1.0f + f5;
                float f8 = f2 * f;
                cki.O00000o0("PhotoView", "ratioOffsetX %f:%f:%f", Float.valueOf(f6), Float.valueOf(f8), Float.valueOf(f5));
                return f8;
            }
        } else if (f5 >= 0.0f) {
            f4 = f6 - 1.0f;
        } else {
            f3 = f6 - 1.0f;
            f2 = (f3 / f6) / 2.0f;
            f = 1.0f + f5;
            float f82 = f2 * f;
            cki.O00000o0("PhotoView", "ratioOffsetX %f:%f:%f", Float.valueOf(f6), Float.valueOf(f82), Float.valueOf(f5));
            return f82;
        }
        f2 = (f4 / f6) / 2.0f;
        f = 1.0f - f5;
        float f822 = f2 * f;
        cki.O00000o0("PhotoView", "ratioOffsetX %f:%f:%f", Float.valueOf(f6), Float.valueOf(f822), Float.valueOf(f5));
        return f822;
    }

    public float getRatioOffsetY() {
        float f;
        float f2;
        float f3;
        float f4;
        float fixOffsetY = getFixOffsetY() / ((float) this.O0000oO);
        float f5 = this.O00000o;
        float f6 = this.O000OoO0;
        if (f6 < 1.0f) {
            if (fixOffsetY >= 0.0f) {
                f4 = f5 - 1.0f;
            } else {
                f3 = f5 - 1.0f;
                f2 = (f3 / f5) / 2.0f;
                f = 1.0f + fixOffsetY;
                float f7 = f2 * f;
                cki.O00000o0("PhotoView", "ratioOffsetY %f:%f", Float.valueOf(fixOffsetY), Float.valueOf(f7));
                return f7;
            }
        } else if (fixOffsetY >= 0.0f) {
            f4 = f5 - (1.0f / f6);
        } else {
            f3 = f5 - (1.0f / f6);
            f2 = (f3 / f5) / 2.0f;
            f = 1.0f + fixOffsetY;
            float f72 = f2 * f;
            cki.O00000o0("PhotoView", "ratioOffsetY %f:%f", Float.valueOf(fixOffsetY), Float.valueOf(f72));
            return f72;
        }
        f2 = (f4 / f5) / 2.0f;
        f = 1.0f - fixOffsetY;
        float f722 = f2 * f;
        cki.O00000o0("PhotoView", "ratioOffsetY %f:%f", Float.valueOf(fixOffsetY), Float.valueOf(f722));
        return f722;
    }

    public float getFixOffsetY() {
        float f = this.O0000o + (this.O00oOoOo ? this.O000Oo0O : 0.0f);
        int i = this.O0000oO;
        return ckp.O000000o(f, (float) (-i), (float) i);
    }

    public final void O000000o() {
        this.O0000Ooo = false;
        if (!this.O0000oo || this.O00oOoOo) {
            this.O00000o = 1.0f;
        } else {
            this.O00000o = 0.0f;
            Log.i("why!", "mScale set to 0 in reset");
        }
        this.O0000o0O = this.O00000o;
        this.O0000o0o = 0.0f;
        this.O0000o = 0.0f;
        this.O0000o00 = 0.0f;
        this.O0000o0 = 0.0f;
    }

    public float getScale() {
        return Math.min(getMaxScale(), Math.max(this.O00000o, this.O0000oOO));
    }

    public float getFullScale() {
        return this.O000OO;
    }

    public final void O000000o(float f, float f2) {
        if (((double) f) >= 1.0d) {
            this.O0000oOo = f;
        }
        if (((double) f2) >= 1.0d) {
            this.O0000oo0 = f2;
        }
    }

    public float getMaxScale() {
        return (this.O00oOoOo ? this.O0000oo0 : this.O0000oOo) * this.O0000oOO;
    }

    public void setInSuperResolution(boolean z) {
        this.O000Oo0o = z;
    }

    public final void O000000o(float f, float f2, float f3, boolean z) {
        cki.O00000o0("PhotoView", "setFocusScale:%f,focusX:%f,focusY:%f,%d:%d", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(getWidth() / 2), Integer.valueOf(getHeight() / 2));
        if (f == 0.0f) {
            cki.O00000o("PhotoView", "setFocusScale can not be set 0 ");
            return;
        }
        this.O000Ooo0 = f2;
        this.O000Ooo = f3;
        float f4 = this.O0000oOO;
        if (f4 != 0.0f) {
            f = ckp.O000000o(f, f4, getMaxScale());
        }
        if (!z) {
            O000000o(f);
        }
        O000000o(f, z);
    }

    public final void O000000o(float f) {
        float f2;
        float f3;
        if (this.O00000o != 0.0f) {
            float f4 = this.O000OoO0;
            if (f4 < 1.0f) {
                f3 = 1.0f / f4;
                f2 = 1.0f;
            } else {
                f2 = f4;
                f3 = 1.0f;
            }
            float width = this.O000Ooo0 - ((float) (getWidth() / 2));
            float height = this.O000Ooo - ((float) (getHeight() / 2));
            cki.O00000o0("PhotoView", "calculateOffsetWithScale:%f:%f,center %f:%f,ratio %f:%f", Float.valueOf(this.O0000o0o), Float.valueOf(this.O0000o), Float.valueOf(width), Float.valueOf(height), Float.valueOf(f3), Float.valueOf(f2));
            float f5 = width * -2.0f * f3;
            float f6 = this.O0000o0o;
            float f7 = (f / this.O00000o) - 1.0f;
            float f8 = this.O0000o;
            this.O0000o0o = f6 + ((f5 + f6) * f7);
            this.O0000o = f8 + (((height * 2.0f * f2) + f8) * f7);
        }
    }

    public final void O000000o(float f, boolean z) {
        Log.d("PhotoView", "setScale, scale:" + f + ", animal:" + z + ":" + getMaxScale());
        float f2 = this.O0000oOO;
        if (f2 != 0.0f) {
            f = ckp.O000000o(f, f2, getMaxScale());
        }
        if (z) {
            float f3 = this.O00000o;
            this.O0000o00 = f - f3;
            this.O0000o0O = f3;
            this.O0000o0 = f;
            this.O0000ooO = System.currentTimeMillis();
        } else {
            this.O00000o = f;
            this.O0000o0O = this.O00000o;
            this.O0000o00 = 0.0f;
            this.O0000o0 = 0.0f;
        }
        if (((double) f) > 1.0d) {
            this.O0000Ooo = true;
        } else {
            this.O0000Ooo = false;
        }
        XmVideoViewGl.OnScaleListener onScaleListener = this.O000OOo0;
        if (onScaleListener != null) {
            onScaleListener.onScaleChage(f);
        }
        requestRender();
    }

    public void setOnScaleListener(XmVideoViewGl.OnScaleListener onScaleListener) {
        this.O000OOo0 = onScaleListener;
    }

    public float getMinScale() {
        return this.O0000oOO;
    }

    public void setMinScale(boolean z) {
        Log.i("why!", "setMiniScale: ".concat(String.valueOf(z)));
        this.O0000oo = z;
        if (z) {
            this.O00000o = 0.0f;
            Log.i("why!", "mScale set to 0 in setMiniScale");
            return;
        }
        this.O00000o = 1.0f;
    }

    public float getOffsetX() {
        return this.O0000o0o;
    }

    public void setOffsetX(float f) {
        this.O0000o0o = f;
    }

    public float getOffsetY() {
        return this.O0000o;
    }

    public void setOffsetY(float f) {
        this.O0000o = f;
    }

    public final void O00000Oo(float f, float f2) {
        this.O0000o0o += f;
        this.O0000o += f2;
        cki.O00000o0("PhotoView", "move, x:%f,y:%f, isFinger:%b,mOffsetX:%f,mOffsetY:%f", Float.valueOf(f), Float.valueOf(f2), Boolean.FALSE, Float.valueOf(this.O0000o0o), Float.valueOf(this.O0000o));
        this.O0000Ooo = false;
    }

    public final void O000000o(Runnable runnable) {
        this.O000OoOO.f5198O000000o.add(runnable);
        requestRender();
    }

    public void setPhoto(cju cju) {
        if (cju != null) {
            O00000Oo o00000Oo = this.O000OoOO;
            o00000Oo.O0000Ooo = cju;
            PhotoView.this.requestRender();
            this.O00000Oo = cju.O00000Oo;
            this.O00000o0 = cju.O00000o0;
        }
    }

    public void setRenderMatrix(float[] fArr) {
        cjw.O000000o(this.O000OoOO.O00000Oo, fArr);
    }

    public void onResume() {
        super.onResume();
        Log.d("PhotoView", "onResume");
        this.O000O0Oo = true;
        O000000o(new Runnable() {
            /* class com.mijia.generalplayer.gl.$$Lambda$PhotoView$E2lVhT05nL0w1eD3JyAjrNAP_Wk */

            public final void run() {
                PhotoView.this.O0000Oo0();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000Oo0() {
        if (!this.O0000O0o) {
            this.O0000O0o = true;
            O00000Oo();
        }
    }

    public void onPause() {
        Log.d("PhotoView", "onPause");
        this.O000O0Oo = false;
        queueEvent(new Runnable() {
            /* class com.mijia.generalplayer.gl.$$Lambda$PhotoView$DAE9LnpNx9WjLHCp5EVle4wC4A */

            public final void run() {
                PhotoView.this.O0000OOo();
            }
        });
        super.onPause();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        Log.d("PhotoView", "surfaceChanged");
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
        Log.d("PhotoView", "surfaceCreated");
        onResume();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
        Log.d("PhotoView", "surfaceDestroyed");
        if (this.O000OoOo) {
            onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void O00000Oo() {
        cki.O00000o("PhotoView", "initial");
    }

    /* access modifiers changed from: protected */
    public void O00000o0() {
        cki.O00000o("PhotoView", "release");
        O00000oO();
        O00000Oo o00000Oo = this.O000OoOO;
        cjw.O000000o(o00000Oo.O00000Oo);
        for (O00000o0 o00000o0 : o00000Oo.O00000o0) {
            o00000o0.f5199O000000o.O000000o();
        }
        if (o00000Oo.O0000Ooo != null) {
            o00000Oo.O0000Ooo.O000000o();
            o00000Oo.O0000Ooo = null;
        }
        o00000Oo.O00000o0.clear();
        cju cju = this.O000O0o0;
        if (cju != null) {
            cju.O000000o();
            this.O000O0o0 = null;
        }
        cju cju2 = this.O0000Oo0;
        if (cju2 != null) {
            cju2.O000000o();
            this.O0000Oo0 = null;
        }
        Log.d("PhotoView", "after release");
    }

    public void setRotation(int i) {
        this.O000O0oO = i;
        requestRender();
    }

    public void setFirstBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            O000000o(new Runnable(bitmap) {
                /* class com.mijia.generalplayer.gl.$$Lambda$PhotoView$SaWlBUToeXSsaTKbfQ6vQkBD8SM */
                private final /* synthetic */ Bitmap f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    PhotoView.this.O000000o(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Bitmap bitmap) {
        this.O000O0o0 = cju.O000000o(bitmap);
        Log.d("PhotoView", "setFirstBitmap mScale:" + this.O00000o);
        setPhoto(this.O000O0o0);
        bitmap.recycle();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    public void setIsFull(boolean z) {
        this.O00oOoOo = z;
        if (this.O00oOoOo) {
            this.O00000oO = this.O00000o;
            O000000o();
            float f = this.O00000oo;
            if (f != 0.0f) {
                this.O00000o = f;
            }
        } else {
            this.O00000oo = Math.max(1.0f, this.O00000o);
            O000000o();
            float f2 = this.O00000oO;
            if (f2 != 0.0f) {
                this.O00000o = f2;
            }
        }
        requestRender();
    }

    public void setIsFullForRN(boolean z) {
        Log.i("why!", "setIsFullForRN: ".concat(String.valueOf(z)));
        this.O000Oo0 = true;
        this.O00oOoOo = z;
        if (this.O00oOoOo) {
            float f = this.O00000o;
            if (f != 0.0f) {
                this.O00000oO = f;
            } else {
                Log.i("why!", "mScale is 0 in setIsFullForRN: " + this.O00000o);
            }
            Log.i("why!", "isfull mStoredScalePortrait: " + this.O00000oO);
            Log.i("why!", "isfull mStoredScaleLandscape: " + this.O00000oo);
            Log.i("why!", "isfull mScale: " + this.O00000o);
            Log.i("why!", "isfull mMinScale: " + this.O0000oOO);
            O000000o();
            float f2 = this.O00000oo;
            if (f2 != 0.0f) {
                this.O00000o = f2;
            }
        } else {
            this.O00000oo = 1.0f;
            Log.i("why!", "notfull mStoredScalePortrait: " + this.O00000oO);
            Log.i("why!", "notfull mStoredScaleLandscape: " + this.O00000oo);
            Log.i("why!", "notfull mScale: " + this.O00000o);
            Log.i("why!", "notfull mMinScale: " + this.O0000oOO);
            O000000o();
            float f3 = this.O00000oO;
            if (f3 != 0.0f) {
                this.O00000o = f3;
            }
        }
        requestRender();
    }

    public final int O000000o(XmVideoViewGl.IDrawBitmapCallback iDrawBitmapCallback, Bitmap bitmap, RectF rectF) {
        O000000o(new Runnable(rectF, bitmap, iDrawBitmapCallback) {
            /* class com.mijia.generalplayer.gl.$$Lambda$PhotoView$9pjG4_YMZJE2LaFEJ2D4ld2AY */
            private final /* synthetic */ RectF f$1;
            private final /* synthetic */ Bitmap f$2;
            private final /* synthetic */ XmVideoViewGl.IDrawBitmapCallback f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                PhotoView.this.O000000o(this.f$1, this.f$2, this.f$3);
            }
        });
        return 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(RectF rectF, Bitmap bitmap, XmVideoViewGl.IDrawBitmapCallback iDrawBitmapCallback) {
        O00000o0 o00000o0 = new O00000o0();
        o00000o0.O00000Oo = rectF;
        o00000o0.f5199O000000o = cju.O000000o(bitmap);
        this.O000OoOO.O00000o0.add(o00000o0);
        iDrawBitmapCallback.onBitmapCreated(this.O000OoOO.O00000o0.size() - 1);
    }

    public final void O000000o(int i, Bitmap bitmap, RectF rectF) {
        O000000o(new Runnable(i, rectF, bitmap) {
            /* class com.mijia.generalplayer.gl.$$Lambda$PhotoView$eje100f6wsQLLA9_32IcLzblQhg */
            private final /* synthetic */ int f$1;
            private final /* synthetic */ RectF f$2;
            private final /* synthetic */ Bitmap f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                PhotoView.this.O000000o(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(int i, RectF rectF, Bitmap bitmap) {
        if (this.O000OoOO.O00000o0.size() > i) {
            O00000o0 o00000o0 = this.O000OoOO.O00000o0.get(i);
            o00000o0.O00000Oo = rectF;
            cju cju = o00000o0.f5199O000000o;
            cju.f13951O000000o = cjw.O000000o(cju.f13951O000000o, bitmap);
            cju.O00000Oo = bitmap.getWidth();
            cju.O00000o0 = bitmap.getHeight();
        }
    }

    public final void O000000o(int i) {
        O000000o(new Runnable(i) {
            /* class com.mijia.generalplayer.gl.$$Lambda$PhotoView$4WrKawbGxKNlScL64XvdvfnQaEc */
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                PhotoView.this.O00000Oo(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(int i) {
        if (this.O000OoOO.O00000o0.size() > i) {
            this.O000OoOO.O00000o0.remove(i).f5199O000000o.O000000o();
        }
    }

    public void setAlpha(float f) {
        this.O00oOooO = f;
        if (this.O000OoOO.O00000Oo != null) {
            cjw.O000000o(this.O000OoOO.O00000Oo, (int) (f * 255.0f));
        }
    }

    public final void O000000o(float f, float f2, float f3) {
        this.O00oOooo = f;
        this.O000O00o = f2;
        this.O000O0OO = f3;
    }

    public void setAutoRelease(boolean z) {
        this.O000OoOo = z;
    }

    public void setPartSuperResolutionEnable(boolean z) {
        this.O00O0Oo = z;
    }

    class O00000Oo implements GLSurfaceView.Renderer {

        /* renamed from: O000000o  reason: collision with root package name */
        final Vector<Runnable> f5198O000000o = new Vector<>();
        cjw.O000000o O00000Oo;
        int O00000o;
        List<O00000o0> O00000o0 = new ArrayList();
        int O00000oO;
        int O00000oo;
        int O0000O0o;
        int O0000OOo;
        int O0000Oo;
        int O0000Oo0;
        int O0000OoO;
        cju O0000Ooo;
        private int O0000o = -1;
        int O0000o0;
        int O0000o00;
        private boolean O0000o0o = false;
        private cjr O0000oO0;

        O00000Oo() {
        }

        public final void onDrawFrame(GL10 gl10) {
            Runnable remove;
            long j;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            synchronized (this.f5198O000000o) {
                remove = !this.f5198O000000o.isEmpty() ? this.f5198O000000o.remove(0) : null;
            }
            if (remove != null) {
                remove.run();
            }
            gl10.glClear(16640);
            if (!this.f5198O000000o.isEmpty()) {
                PhotoView.this.requestRender();
            }
            if (PhotoView.this.O000O0Oo) {
                float f17 = 1.0f;
                float f18 = 0.0f;
                if (PhotoView.this.O00oOoOo) {
                    cjw.O000000o(1.0f);
                } else if (PhotoView.this.O000OOoO) {
                    cjw.O000000o(0.0f);
                } else {
                    cjw.O000000o(this.O00000Oo, PhotoView.this.O00oOooo, PhotoView.this.O000O00o, PhotoView.this.O000O0OO);
                }
                PhotoView.this.O00000o();
                if (this.O0000Ooo != null) {
                    if (PhotoView.this.O0000ooO != 0) {
                        Log.i("why!", "buildAnimal");
                        long currentTimeMillis = System.currentTimeMillis() - PhotoView.this.O0000ooO;
                        if (currentTimeMillis > PhotoView.this.O0000ooo) {
                            if (PhotoView.this.O0000o0 > 0.0f) {
                                PhotoView photoView = PhotoView.this;
                                photoView.O00000o = photoView.O0000o0;
                            } else {
                                PhotoView photoView2 = PhotoView.this;
                                photoView2.O00000o = photoView2.O0000o0O + PhotoView.this.O0000o00;
                            }
                            PhotoView photoView3 = PhotoView.this;
                            photoView3.O0000ooO = 0;
                            photoView3.O0000o0 = 0.0f;
                        } else {
                            Interpolator interpolator = PhotoView.this.O000OO0o;
                            double d = (double) currentTimeMillis;
                            Double.isNaN(d);
                            double d2 = (double) PhotoView.this.O0000ooo;
                            Double.isNaN(d2);
                            float interpolation = PhotoView.this.O0000o0O + (interpolator.getInterpolation((float) ((d * 1.0d) / d2)) * PhotoView.this.O0000o00);
                            PhotoView.this.O000000o(interpolation);
                            PhotoView photoView4 = PhotoView.this;
                            photoView4.O00000o = interpolation;
                            photoView4.requestRender();
                        }
                    }
                    int i = this.O0000Ooo.O00000Oo;
                    int i2 = this.O0000Ooo.O00000o0;
                    if (PhotoView.this.O000O0o != PhotoView.this.O000O0oO) {
                        PhotoView photoView5 = PhotoView.this;
                        photoView5.O000O0o = photoView5.O000O0oO;
                        PhotoView photoView6 = PhotoView.this;
                        photoView6.O0000ooO = 0;
                        photoView6.O00000o = 0.0f;
                        Log.i("why!", "mScale set to 0 in setRenderMatrix");
                    }
                    O00000o0();
                    if (PhotoView.this.O00000oo()) {
                        if (i2 == 640 && i == 368) {
                            i = 360;
                        }
                        if (i2 == 1920 && i == 1088) {
                            i = 1080;
                        }
                        int i3 = i2 == 1280 ? 720 : i;
                        Matrix4f matrix4f = new Matrix4f();
                        float f19 = ((float) i2) / ((float) i3);
                        float f20 = ((float) this.O00000o) / ((float) this.O00000oO);
                        float f21 = f20 / f19;
                        if (f21 < 1.0f) {
                            float f22 = f19 / f20;
                            if (PhotoView.this.O00oOoOo) {
                                PhotoView photoView7 = PhotoView.this;
                                photoView7.O000OO = 1.0f;
                                photoView7.O0000oOO = 1.0f;
                            } else {
                                PhotoView photoView8 = PhotoView.this;
                                photoView8.O0000oOO = f21;
                                photoView8.O000OO = 1.0f;
                            }
                            O000000o();
                            float min = Math.min(PhotoView.this.getMaxScale(), Math.max(PhotoView.this.O00000o, PhotoView.this.O0000oOO));
                            PhotoView photoView9 = PhotoView.this;
                            int i4 = this.O00000o;
                            photoView9.O0000oO0 = (int) (((((float) i4) * f22) * min) - ((float) i4));
                            int i5 = this.O00000oO;
                            photoView9.O0000oO = (int) ((((float) i5) * min) - ((float) i5));
                            O00000Oo();
                            f16 = f22 * min;
                            matrix4f.scale(f16, min, 0.0f);
                            float f23 = PhotoView.this.O0000o0o / (((float) this.O00000o) * f16);
                            f14 = PhotoView.this.O0000o / (((float) this.O00000oO) * min);
                            if (((double) min) < 1.0d) {
                                f14 = 0.0f;
                            }
                            matrix4f.translate(f23, f14, 0.0f);
                            f13 = min;
                            f15 = f23;
                        } else {
                            PhotoView.this.O0000oOO = f19 / f20;
                            O000000o();
                            if (PhotoView.this.O00oOoOo) {
                                PhotoView.this.O000OO = f21;
                            } else {
                                PhotoView.this.O000OO = 1.0f;
                            }
                            f16 = Math.min(PhotoView.this.getMaxScale(), Math.max(PhotoView.this.O00000o, PhotoView.this.O0000oOO));
                            PhotoView photoView10 = PhotoView.this;
                            int i6 = this.O00000oO;
                            photoView10.O0000oO = (int) (((((float) i6) * f21) * f16) - ((float) i6));
                            int i7 = this.O00000o;
                            photoView10.O0000oO0 = (int) ((((float) i7) * f16) - ((float) i7));
                            O00000Oo();
                            float f24 = f21 * f16;
                            matrix4f.scale(f16, f24, 0.0f);
                            f15 = PhotoView.this.O0000o0o / (((float) this.O00000o) * f16);
                            f14 = PhotoView.this.O0000o / (((float) this.O00000oO) * f24);
                            if (((double) f16) < 1.0d) {
                                f15 = 0.0f;
                            }
                            matrix4f.translate(f15, f14, 0.0f);
                            f13 = f24;
                        }
                        O000000o(matrix4f);
                        O000000o(i2, i3, f15, f14, f16, f13);
                    } else {
                        if (i == 640 && i2 == 368) {
                            i2 = 360;
                        }
                        if (i == 1920 && i2 == 1088) {
                            i2 = 1080;
                        }
                        int i8 = i == 1280 ? 720 : i2;
                        Matrix4f matrix4f2 = new Matrix4f();
                        float f25 = ((float) i) / ((float) i8);
                        float f26 = ((float) this.O00000o) / ((float) this.O00000oO);
                        float f27 = f26 / f25;
                        PhotoView photoView11 = PhotoView.this;
                        photoView11.O000OoO0 = f27;
                        if (f27 < 1.0f) {
                            float f28 = f25 / f26;
                            photoView11.O0000oOO = f27;
                            O000000o();
                            PhotoView photoView12 = PhotoView.this;
                            photoView12.O000OO = 1.0f;
                            float min2 = Math.min(photoView12.getMaxScale(), Math.max(PhotoView.this.O00000o, PhotoView.this.O0000oOO));
                            PhotoView photoView13 = PhotoView.this;
                            int i9 = this.O00000o;
                            photoView13.O0000oO0 = (int) (((((float) i9) * f28) * min2) - ((float) i9));
                            int i10 = this.O00000oO;
                            photoView13.O0000oO = (int) ((((float) i10) * min2) - ((float) i10));
                            O00000Oo();
                            if (PhotoView.this.O000Oo0o) {
                                float max = Math.max(min2 / 3.0f, PhotoView.this.O0000oOO);
                                float f29 = f28 * max;
                                matrix4f2.scale(f29, max, 0.0f);
                                float f30 = (f29 - 1.0f) / f29;
                                if (PhotoView.this.O0000o0o < 0.0f) {
                                    f30 = -f30;
                                }
                                float f31 = (-(max - 1.0f)) / max;
                                if (PhotoView.this.getFixOffsetY() >= 0.0f) {
                                    f31 = -f31;
                                }
                                matrix4f2.translate(f30, f31, 0.0f);
                                f8 = f29;
                                f7 = max;
                            } else {
                                f11 = f28 * min2;
                                matrix4f2.scale(f11, min2, 0.0f);
                                float f32 = PhotoView.this.O0000o0o / (((float) this.O00000o) * f11);
                                float f33 = PhotoView.this.O0000o / (((float) this.O00000oO) * min2);
                                if (((double) min2) < 1.0d) {
                                    f33 = 0.0f;
                                }
                                matrix4f2.translate(f32, f33, 0.0f);
                                f12 = min2;
                                f10 = f32;
                                f9 = f33;
                                f8 = f11;
                                O000000o(matrix4f2);
                                O000000o(i, i8, f10, f9, f8, f7);
                            }
                        } else {
                            photoView11.O0000oOO = 1.0f / f27;
                            O000000o();
                            PhotoView photoView14 = PhotoView.this;
                            photoView14.O000OO = 1.0f;
                            f11 = Math.min(photoView14.getMaxScale(), Math.max(PhotoView.this.O00000o, PhotoView.this.O0000oOO));
                            PhotoView photoView15 = PhotoView.this;
                            int i11 = this.O00000o;
                            photoView15.O0000oO0 = (int) ((((float) i11) * f11) - ((float) i11));
                            int i12 = this.O00000oO;
                            photoView15.O0000oO = (int) (((((float) i12) * f27) * f11) - ((float) i12));
                            O00000Oo();
                            if (PhotoView.this.O000Oo0o) {
                                float max2 = Math.max(f11 / 3.0f, PhotoView.this.O0000oOO);
                                float f34 = f27 * max2;
                                matrix4f2.scale(max2, f34, 0.0f);
                                float f35 = (-(max2 - 1.0f)) / max2;
                                if (PhotoView.this.O0000o0o < 0.0f) {
                                    f35 = -f35;
                                }
                                float f36 = (-(f34 - 1.0f)) / f34;
                                if (PhotoView.this.getFixOffsetY() >= 0.0f) {
                                    f36 = -f36;
                                }
                                matrix4f2.translate(f35, f36, 0.0f);
                                f8 = max2;
                                f7 = f34;
                            } else {
                                float f37 = f27 * f11;
                                matrix4f2.scale(f11, f37, 0.0f);
                                if (PhotoView.this.O00oOoOo) {
                                    PhotoView photoView16 = PhotoView.this;
                                    int i13 = this.O00000oO;
                                    photoView16.O000Oo0O = -((((float) i13) * f27) - ((float) i13));
                                }
                                float fixOffsetY = PhotoView.this.getFixOffsetY();
                                float f38 = PhotoView.this.O0000o0o / (((float) this.O00000o) * f11);
                                f9 = fixOffsetY / (((float) this.O00000oO) * f37);
                                matrix4f2.translate(f38, f9, 0.0f);
                                f12 = f37;
                                f10 = f38;
                                f8 = f11;
                                O000000o(matrix4f2);
                                O000000o(i, i8, f10, f9, f8, f7);
                            }
                        }
                        f10 = 0.0f;
                        f9 = 0.0f;
                        O000000o(matrix4f2);
                        O000000o(i, i8, f10, f9, f8, f7);
                    }
                    if (PhotoView.this.O000OOoO) {
                        GLES20.glViewport(0, 0, this.O00000o, this.O00000oO);
                        GLES20.glEnable(3042);
                        GLES20.glBlendFuncSeparate(1, 771, 1, 771);
                        this.O0000oO0.O000000o(this.O0000o);
                        GLES20.glBlendFunc(772, 0);
                        cjw.O000000o(this.O00000Oo, true, this.O0000Ooo.f13951O000000o, this.O00000o, this.O00000oO);
                        GLES20.glDisable(3042);
                    } else {
                        cjw.O000000o(this.O00000Oo, false, this.O0000Ooo.f13951O000000o, this.O00000o, this.O00000oO);
                    }
                    for (O00000o0 next : this.O00000o0) {
                        RectF rectF = next.O00000Oo;
                        int i14 = next.f5199O000000o.O00000Oo;
                        int i15 = next.f5199O000000o.O00000o0;
                        if (PhotoView.this.O000O0o != PhotoView.this.O000O0oO) {
                            PhotoView photoView17 = PhotoView.this;
                            photoView17.O000O0o = photoView17.O000O0oO;
                            PhotoView photoView18 = PhotoView.this;
                            j = 0;
                            photoView18.O0000ooO = 0;
                            photoView18.O00000o = f18;
                            Log.i("why!", "mScale set to 0 in setRendererPhotoMatrix");
                        } else {
                            j = 0;
                        }
                        if (PhotoView.this.O00000oo()) {
                            Matrix4f matrix4f3 = new Matrix4f();
                            float f39 = ((float) i15) / ((float) i14);
                            float f40 = ((float) this.O00000o) / ((float) this.O00000oO);
                            float f41 = f40 / f39;
                            if (f41 < f17) {
                                float f42 = f39 / f40;
                                if (PhotoView.this.O00oOoOo) {
                                    PhotoView.this.O0000oOO = f17;
                                } else {
                                    PhotoView.this.O0000oOO = f41;
                                }
                                O000000o();
                                float min3 = Math.min(PhotoView.this.getMaxScale(), Math.max(PhotoView.this.O00000o, PhotoView.this.O0000oOO));
                                PhotoView photoView19 = PhotoView.this;
                                photoView19.O0000oO0 = (int) (((((float) this.O00000o) * f42) * photoView19.O00000o) - ((float) this.O00000o));
                                PhotoView photoView20 = PhotoView.this;
                                photoView20.O0000oO = (int) ((((float) this.O00000oO) * photoView20.O00000o) - ((float) this.O00000oO));
                                O00000Oo();
                                float f43 = f42 * min3;
                                matrix4f3.scale(f43, min3, f18);
                                float f44 = PhotoView.this.O0000o0o / (((float) this.O00000o) * f43);
                                float f45 = PhotoView.this.O0000o / (((float) this.O00000oO) * min3);
                                if (((double) min3) < 1.0d) {
                                    f45 = 0.0f;
                                }
                                matrix4f3.translate(f44, f45, f18);
                                float f46 = f44;
                                f4 = f43;
                                f6 = f46;
                                float f47 = f45;
                                f3 = min3;
                                f5 = f47;
                            } else {
                                if (PhotoView.this.O00oOoOo) {
                                    PhotoView.this.O0000oOO = f17;
                                } else {
                                    PhotoView.this.O0000oOO = f41;
                                }
                                O000000o();
                                float min4 = Math.min(PhotoView.this.getMaxScale(), Math.max(PhotoView.this.O00000o, PhotoView.this.O0000oOO));
                                PhotoView photoView21 = PhotoView.this;
                                int i16 = this.O00000oO;
                                photoView21.O0000oO = (int) (((((float) i16) * f41) * min4) - ((float) i16));
                                int i17 = this.O00000o;
                                photoView21.O0000oO0 = (int) ((((float) i17) * min4) - ((float) i17));
                                O00000Oo();
                                float f48 = f41 * min4;
                                matrix4f3.scale(min4, f48, f18);
                                float f49 = PhotoView.this.O0000o0o / (((float) this.O00000o) * min4);
                                float f50 = PhotoView.this.O0000o / (((float) this.O00000oO) * f48);
                                if (((double) min4) < 1.0d) {
                                    f49 = 0.0f;
                                }
                                matrix4f3.translate(f49, f50, 0.0f);
                                f3 = f48;
                                float f51 = f50;
                                f4 = min4;
                                f6 = f49;
                                f5 = f51;
                            }
                            O000000o(matrix4f3);
                            O000000o(i15, i14, f6, f5, f4, f3);
                        } else {
                            Matrix4f matrix4f4 = new Matrix4f();
                            float f52 = (((float) this.O00000o) / ((float) this.O00000oO)) / (((float) this.O0000Ooo.O00000Oo) / ((float) this.O0000Ooo.O00000o0));
                            float width = rectF.width() * ((float) this.O0000Ooo.O00000Oo);
                            float height = rectF.height() * ((float) this.O0000Ooo.O00000o0);
                            if (f52 < 1.0f) {
                                float f53 = (PhotoView.this.O00000o * (((float) this.O00000oO) * width)) / ((float) (this.O00000o * this.O0000Ooo.O00000o0));
                                float f54 = (PhotoView.this.O00000o * height) / ((float) this.O0000Ooo.O00000o0);
                                matrix4f4.scale(f53, f54, 0.0f);
                                matrix4f4.translate((((rectF.centerX() * ((float) this.O0000Ooo.O00000Oo)) - ((float) (this.O0000Ooo.O00000Oo / 2))) * 2.0f) / width, ((((float) (this.O0000Ooo.O00000o0 / 2)) - (rectF.centerY() * ((float) this.O0000Ooo.O00000o0))) * 2.0f) / height, 0.0f);
                                float f55 = PhotoView.this.O00000o;
                                O00000Oo();
                                float f56 = (PhotoView.this.O0000o0o * PhotoView.this.O00000o) / ((((float) this.O00000o) * (PhotoView.this.O00000o * 1.0f)) * f53);
                                float f57 = (PhotoView.this.O0000o * PhotoView.this.O00000o) / ((((float) this.O00000oO) * f55) * f54);
                                if (((double) PhotoView.this.O00000o) < 1.0d) {
                                    f2 = 0.0f;
                                    f57 = 0.0f;
                                } else {
                                    f2 = 0.0f;
                                }
                                matrix4f4.translate(f56, f57, f2);
                            } else {
                                float f58 = (PhotoView.this.O00000o * (((float) this.O00000o) * height)) / ((float) (this.O00000oO * this.O0000Ooo.O00000Oo));
                                float f59 = (PhotoView.this.O00000o * width) / ((float) this.O0000Ooo.O00000Oo);
                                matrix4f4.scale(f59, f58, 0.0f);
                                matrix4f4.translate((((rectF.centerX() * ((float) this.O0000Ooo.O00000Oo)) - ((float) (this.O0000Ooo.O00000Oo / 2))) * 2.0f) / width, ((((float) (this.O0000Ooo.O00000o0 / 2)) - (rectF.centerY() * ((float) this.O0000Ooo.O00000o0))) * 2.0f) / ((height * f52) * f52), 0.0f);
                                float f60 = PhotoView.this.O00000o;
                                O00000Oo();
                                float f61 = (PhotoView.this.O0000o0o * PhotoView.this.O00000o) / ((((float) this.O00000o) * f60) * f59);
                                float f62 = (PhotoView.this.O0000o * PhotoView.this.O00000o) / ((((float) this.O00000oO) * (PhotoView.this.O00000o * 1.0f)) * f58);
                                if (((double) PhotoView.this.O00000o) < 1.0d) {
                                    f = 0.0f;
                                    f62 = 0.0f;
                                } else {
                                    f = 0.0f;
                                }
                                matrix4f4.translate(f61, f62, f);
                            }
                            O000000o(matrix4f4);
                        }
                        cjw.O000000o(this.O00000Oo, PhotoView.this.O000OOoO, next.f5199O000000o.f13951O000000o, this.O00000o, this.O00000oO);
                        f17 = 1.0f;
                        f18 = 0.0f;
                    }
                    if (!this.O0000o0o && PhotoView.this.O000OOo0 != null) {
                        PhotoView.this.O000OOo0.onFirstVideoShow();
                    }
                    this.O0000o0o = true;
                    ckj.O000000o().O000000o(this, "FIRST_RENDER:onFirstVideoShow");
                    ckk.O000000o().O00000Oo("PhotoView", "FIRST_RENDER_TIME", "onFirstVideoShow");
                }
            }
        }

        private void O000000o() {
            if (PhotoView.this.O000OoO != 0.0f) {
                PhotoView photoView = PhotoView.this;
                photoView.O00000o = photoView.O000OoO * PhotoView.this.O0000oOO;
                PhotoView.this.O000OoO = 0.0f;
            }
        }

        private void O000000o(Matrix4f matrix4f) {
            matrix4f.rotate((float) PhotoView.this.O000O0o, 0.0f, 0.0f, 1.0f);
            if (PhotoView.this.O000O0oo) {
                matrix4f.scale(-1.0f, 1.0f, 1.0f);
            }
            if (PhotoView.this.O000OO00) {
                matrix4f.scale(1.0f, -1.0f, 1.0f);
            }
            this.O00000Oo.O0000Oo = matrix4f.getArray();
        }

        private void O00000Oo() {
            PhotoView photoView = PhotoView.this;
            photoView.O0000oO0 = Math.max(0, photoView.O0000oO0);
            PhotoView photoView2 = PhotoView.this;
            photoView2.O0000oO = Math.max(0, photoView2.O0000oO);
            PhotoView photoView3 = PhotoView.this;
            photoView3.O0000o0o = ckp.O000000o(photoView3.O0000o0o, (float) (-PhotoView.this.O0000oO0), (float) PhotoView.this.O0000oO0);
            PhotoView photoView4 = PhotoView.this;
            photoView4.O0000o = ckp.O000000o(photoView4.O0000o, (float) (-PhotoView.this.O0000oO), (float) PhotoView.this.O0000oO);
        }

        private void O000000o(int i, int i2, float f, float f2, float f3, float f4) {
            float f5 = 1.0f / f3;
            float f6 = (1.0f - f5) - f;
            float f7 = (float) i;
            int i3 = (int) ((f6 * f7) / 2.0f);
            int i4 = (int) (((float) i3) + (f5 * f7));
            float f8 = 1.0f / f4;
            float f9 = (f8 - 1.0f) - f2;
            float f10 = (float) i2;
            int i5 = (int) ((f9 * f10) / 2.0f);
            int i6 = (int) (((float) i5) - (f8 * f10));
            if (i3 < 0) {
                i3 = 0;
            }
            if (i4 > i) {
                i4 = i;
            }
            if (i5 > 0) {
                i5 = 0;
            }
            int i7 = 0 - i2;
            if (i6 < i7) {
                i6 = i7;
            }
            if (this.O00000oo != i || this.O0000O0o != i2 || this.O0000OOo != i3 || this.O0000Oo0 != i5 || this.O0000Oo != i4 || this.O0000OoO != i6) {
                this.O00000oo = i;
                this.O0000O0o = i2;
                this.O0000OOo = i3;
                this.O0000Oo0 = i5;
                this.O0000Oo = i4;
                this.O0000OoO = i6;
            }
        }

        private void O00000o0() {
            PhotoView photoView = PhotoView.this;
            photoView.O000Oo00 = photoView.O0000OoO.getResources().getDisplayMetrics().widthPixels;
            if (PhotoView.this.O000Oo0 && !PhotoView.this.O00oOoOo && this.O00000o > PhotoView.this.O000Oo00 && this.O0000o00 != 0) {
                cki.O00000o0("PhotoView", "fixRNConfigureChangeSize %d,%d:%d,%d", Integer.valueOf(this.O00000o), Integer.valueOf(this.O00000oO), Integer.valueOf(this.O0000o00), Integer.valueOf(this.O0000o0));
                this.O00000o = this.O0000o00;
                this.O00000oO = this.O0000o0;
            }
        }

        public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.O00000o = i;
            this.O00000oO = i2;
            if (!PhotoView.this.O00oOoOo) {
                O00000o0();
                if (this.O00000o <= PhotoView.this.O000Oo00) {
                    this.O0000o00 = i;
                    this.O0000o0 = i2;
                }
            }
        }

        public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Log.d("PhotoView", "onSurfaceCreated" + PhotoView.this.toString());
            GLES20.glEnable(3553);
            IntBuffer allocate = IntBuffer.allocate(1);
            GLES20.glGetIntegerv(3379, allocate);
            PhotoView.this.f5197O000000o = allocate.get(0);
            GLES20.glGetError();
            this.O00000Oo = cjw.O00000Oo();
            int i = -1;
            if (this.O0000o == -1 && PhotoView.this.O000OOoO) {
                Bitmap bitmap = PhotoView.this.O000OOo;
                if (bitmap != null) {
                    int[] iArr = new int[1];
                    GLES20.glGenTextures(1, iArr, 0);
                    GLES20.glBindTexture(3553, iArr[0]);
                    GLES20.glTexParameterf(3553, 10240, 9729.0f);
                    GLES20.glTexParameterf(3553, 10241, 9729.0f);
                    GLES20.glTexParameterf(3553, 10242, 33071.0f);
                    GLES20.glTexParameterf(3553, 10243, 33071.0f);
                    GLUtils.texImage2D(3553, 0, bitmap, 0);
                    bitmap.recycle();
                    i = iArr[0];
                }
                this.O0000o = i;
                this.O0000oO0 = new cjr();
            }
        }

        public final void O000000o(XmVideoViewGl.PhotoSnapCallback photoSnapCallback) {
            if (photoSnapCallback != null) {
                if (this.O0000Ooo != null) {
                    PhotoView.this.O000000o(new Runnable(photoSnapCallback) {
                        /* class com.mijia.generalplayer.gl.$$Lambda$PhotoView$O00000Oo$dupJP3s63H5Mcj91Mmnc3VrPuKI */
                        private final /* synthetic */ XmVideoViewGl.PhotoSnapCallback f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            PhotoView.O00000Oo.this.O00000Oo(this.f$1);
                        }
                    });
                    PhotoView.this.requestRender();
                } else if (photoSnapCallback != null) {
                    cki.O00000oO("PhotoView", "snap return null");
                    photoSnapCallback.onSnap(null);
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O00000Oo(XmVideoViewGl.PhotoSnapCallback photoSnapCallback) {
            cki.O00000o("PhotoView", "RendererUtils.saveTexture");
            Bitmap O000000o2 = cjw.O000000o(this.O0000Ooo.f13951O000000o, this.O0000Ooo.O00000Oo, this.O0000Ooo.O00000o0);
            if (photoSnapCallback != null) {
                boolean z = true;
                Object[] objArr = new Object[1];
                if (O000000o2 != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                cki.O00000o0("PhotoView", "snap return bitmap is null %b", objArr);
                photoSnapCallback.onSnap(O000000o2);
            }
        }
    }

    public final boolean O00000oo() {
        int i = this.O000O0o;
        return i == 90 || i == 270;
    }

    public void setInitRelativeScale(float f) {
        this.O000OoO = f;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000OOo() {
        this.O000OoOO.f5198O000000o.clear();
        if (this.O0000O0o) {
            O00000o0();
            this.O0000O0o = false;
        }
    }
}
