package com.xiaomi.smarthome.fastvideo;

import _m_j.fsa;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.camera.XmVideoViewGl;

public class VideoView extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f7365O000000o = false;
    public VideoGlSurfaceView O00000Oo;
    float O00000o = 0.0f;
    float O00000o0 = 0.0f;
    public boolean O00000oO = false;
    public boolean O00000oo = false;
    boolean O0000O0o = false;
    public boolean O0000OOo = false;
    private float O0000Oo = 4.0f;
    O000000o O0000Oo0;
    private GestureDetector O0000OoO;
    private ScaleGestureDetector O0000Ooo;

    public interface O000000o {
        void onVideoViewClick();
    }

    public void setVideoViewListener(O000000o o000000o) {
        this.O0000Oo0 = o000000o;
    }

    public VideoView(Context context) {
        super(context);
        O000000o();
    }

    public VideoView(Context context, boolean z) {
        super(context);
        O000000o(null, true, 1, z);
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.h265Decoder, R.attr.hardDecoder});
            boolean z = obtainStyledAttributes.getBoolean(1, true);
            int i = obtainStyledAttributes.getInt(0, 1);
            obtainStyledAttributes.recycle();
            O000000o(null, z, i, false);
            return;
        }
        O000000o();
    }

    public void setAlpha(float f) {
        this.O00000Oo.setAlpha(f);
    }

    private void O000000o() {
        O000000o(null, true, 1, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mijia.generalplayer.gl.PhotoView.O000000o(float, float, float):void
     arg types: [int, int, int]
     candidates:
      com.mijia.generalplayer.gl.VideoGlSurfaceViewBase.O000000o(int, int, int):void
      com.mijia.generalplayer.gl.PhotoView.O000000o(int, android.graphics.RectF, android.graphics.Bitmap):void
      com.mijia.generalplayer.gl.PhotoView.O000000o(android.graphics.RectF, android.graphics.Bitmap, com.xiaomi.smarthome.camera.XmVideoViewGl$IDrawBitmapCallback):void
      com.mijia.generalplayer.gl.PhotoView.O000000o(com.xiaomi.smarthome.camera.XmVideoViewGl$IDrawBitmapCallback, android.graphics.Bitmap, android.graphics.RectF):int
      com.mijia.generalplayer.gl.PhotoView.O000000o(int, android.graphics.Bitmap, android.graphics.RectF):void
      com.mijia.generalplayer.gl.PhotoView.O000000o(float, float, float):void */
    private void O000000o(fsa fsa, boolean z, int i, boolean z2) {
        this.O00000Oo = new VideoGlSurfaceView(getContext(), z, i, z2);
        this.O00000Oo.O000000o(0.102f, 0.102f, 0.102f);
        this.O00000Oo.setAutoRelease(true);
        this.O00000Oo.setKeepScreenOn(true);
        Log.e("VideoView", "Start init GlSurfaceView hard: " + z + "type:  " + i);
        addView(this.O00000Oo, -1, -1);
        this.O0000Ooo = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.OnScaleGestureListener() {
            /* class com.xiaomi.smarthome.fastvideo.VideoView.AnonymousClass1 */

            public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }

            public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                VideoView.this.O00000oo = true;
                return true;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{java.lang.Math.min(float, float):float}
             arg types: [float, int]
             candidates:
              ClspMth{java.lang.Math.min(double, double):double}
              ClspMth{java.lang.Math.min(long, long):long}
              ClspMth{java.lang.Math.min(int, int):int}
              ClspMth{java.lang.Math.min(float, float):float} */
            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.mijia.generalplayer.gl.PhotoView.O000000o(float, boolean):void
             arg types: [float, int]
             candidates:
              com.mijia.generalplayer.gl.VideoGlSurfaceViewBase.O000000o(int, int):void
              com.mijia.generalplayer.gl.PhotoView.O000000o(float, float):void
              com.mijia.generalplayer.gl.PhotoView.O000000o(float, boolean):void */
            public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float f;
                float scale = VideoView.this.O00000Oo.getScale() * scaleGestureDetector.getScaleFactor();
                if (VideoView.this.O00000oO) {
                    f = Math.max(VideoView.this.O00000Oo.getMinScale(), Math.min(scale, 2.0f));
                } else {
                    f = Math.max(VideoView.this.O00000Oo.getMinScale(), Math.min(scale, 1.5f));
                }
                VideoView.this.O00000Oo.O000000o(f, false);
                VideoView.this.O00000Oo.requestRender();
                return true;
            }
        });
        this.O0000OoO = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            /* class com.xiaomi.smarthome.fastvideo.VideoView.AnonymousClass2 */

            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || (Math.abs(f) <= 500.0f && Math.abs(f2) <= 500.0f))) {
                    return super.onFling(motionEvent, motionEvent2, f, f2);
                }
                return true;
            }

            public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (VideoView.this.O0000Oo0 == null) {
                    return true;
                }
                VideoView.this.O0000Oo0.onVideoViewClick();
                return true;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.mijia.generalplayer.gl.PhotoView.O000000o(float, boolean):void
             arg types: [float, int]
             candidates:
              com.mijia.generalplayer.gl.VideoGlSurfaceViewBase.O000000o(int, int):void
              com.mijia.generalplayer.gl.PhotoView.O000000o(float, float):void
              com.mijia.generalplayer.gl.PhotoView.O000000o(float, boolean):void */
            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.mijia.generalplayer.gl.PhotoView.O000000o(float, boolean):void
             arg types: [int, int]
             candidates:
              com.mijia.generalplayer.gl.VideoGlSurfaceViewBase.O000000o(int, int):void
              com.mijia.generalplayer.gl.PhotoView.O000000o(float, float):void
              com.mijia.generalplayer.gl.PhotoView.O000000o(float, boolean):void */
            public final boolean onDoubleTap(MotionEvent motionEvent) {
                if (!VideoView.this.O00000oO) {
                    float minScale = VideoView.this.O00000Oo.getMinScale();
                    float scale = VideoView.this.O00000Oo.getScale();
                    float fullScale = VideoView.this.O00000Oo.getFullScale();
                    if (((double) minScale) >= 0.9d) {
                        double scale2 = (double) VideoView.this.O00000Oo.getScale();
                        Double.isNaN(scale2);
                        if (Math.abs(scale2 - 1.0d) > 0.1d) {
                            VideoView.this.O00000Oo.O000000o(1.0f, true);
                        } else {
                            VideoView.this.O00000Oo.O000000o(2.0f, true);
                        }
                    } else if (scale == minScale || scale > fullScale) {
                        VideoView.this.O00000Oo.O000000o(fullScale, true);
                    } else {
                        VideoView.this.O00000Oo.O000000o(minScale, true);
                    }
                } else {
                    double scale3 = (double) VideoView.this.O00000Oo.getScale();
                    Double.isNaN(scale3);
                    if (Math.abs(scale3 - 1.0d) > 0.1d) {
                        VideoView.this.O00000Oo.O000000o(1.0f, true);
                    } else {
                        VideoView.this.O00000Oo.O000000o(2.0f, true);
                    }
                }
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setIsFull(configuration.orientation == 2);
    }

    public final void O000000o(int i, int i2, boolean z) {
        setIsFull(z);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(i, i2);
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        setLayoutParams(layoutParams);
    }

    public void setIsFull(boolean z) {
        this.O00000oO = z;
        VideoGlSurfaceView videoGlSurfaceView = this.O00000Oo;
        if (videoGlSurfaceView != null) {
            videoGlSurfaceView.setIsFull(z);
        }
    }

    public VideoGlSurfaceView getSurfaceView() {
        return this.O00000Oo;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.O0000OoO;
        if (!(gestureDetector == null || this.O0000Ooo == null)) {
            if (this.O0000OOo) {
                return false;
            }
            gestureDetector.onTouchEvent(motionEvent);
            this.O0000Ooo.onTouchEvent(motionEvent);
            if (motionEvent.getAction() == 0) {
                this.O00000o0 = motionEvent.getX();
                this.O00000o = motionEvent.getY();
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (!this.O00000oo) {
                    this.O00000Oo.O00000Oo((float) ((int) (motionEvent.getX() - this.O00000o0)), (float) ((int) (-(motionEvent.getY() - this.O00000o))));
                    this.O00000Oo.requestRender();
                    this.O00000o0 = motionEvent.getX();
                    this.O00000o = motionEvent.getY();
                }
                return true;
            } else if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return true;
            } else {
                this.O00000oo = false;
            }
        }
        return true;
    }

    public final void O000000o(VideoFrame videoFrame) {
        this.O00000Oo.O000000o(videoFrame);
    }

    public float getScaleRadio() {
        VideoGlSurfaceView videoGlSurfaceView = this.O00000Oo;
        if (videoGlSurfaceView != null) {
            return videoGlSurfaceView.O00000o;
        }
        return 0.0f;
    }

    public void setScaleRadio(float f) {
        this.O0000Oo = f;
    }

    public void setFirstBitmap(Bitmap bitmap) {
        VideoGlSurfaceView videoGlSurfaceView = this.O00000Oo;
        if (videoGlSurfaceView != null) {
            videoGlSurfaceView.setFirstBitmap(bitmap);
        }
    }

    public void setDid(String str) {
        VideoGlSurfaceView videoGlSurfaceView = this.O00000Oo;
        if (videoGlSurfaceView != null) {
            videoGlSurfaceView.setDid(str);
        }
    }

    public void setOnScaleListener(XmVideoViewGl.OnScaleListener onScaleListener) {
        VideoGlSurfaceView videoGlSurfaceView = this.O00000Oo;
        if (videoGlSurfaceView != null) {
            videoGlSurfaceView.setOnScaleListener(onScaleListener);
        }
    }
}
