package _m_j;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.mijia.generalplayer.gl.PhotoView;
import com.xiaomi.smarthome.camera.XmVideoViewGl;

public final class cjv {

    /* renamed from: O000000o  reason: collision with root package name */
    public PhotoView f13952O000000o;
    public float O00000Oo = 0.0f;
    public boolean O00000o = true;
    public float O00000o0 = 0.0f;
    public boolean O00000oO = false;
    public boolean O00000oo = false;
    public GestureDetector O0000O0o;
    public ScaleGestureDetector O0000OOo;
    public XmVideoViewGl.IVideoViewScaleListener O0000Oo;
    public XmVideoViewGl.IVideoViewListener O0000Oo0;
    public XmVideoViewGl.OnDirectionCtrlListener O0000OoO;
    public boolean O0000Ooo;
    public float O0000o = 0.0f;
    public boolean O0000o0;
    public boolean O0000o00;
    public boolean O0000o0O;
    public float O0000o0o = 0.0f;
    public float O0000oO;
    public float O0000oO0;
    private Context O0000oOO;
    private View.OnTouchListener O0000oOo = new View.OnTouchListener() {
        /* class _m_j.cjv.AnonymousClass3 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (cjv.this.O0000O0o == null || cjv.this.O0000OOo == null || !cjv.this.O00000o) {
                return true;
            }
            cjv.this.O0000O0o.onTouchEvent(motionEvent);
            cjv.this.O0000OOo.onTouchEvent(motionEvent);
            if (motionEvent.getAction() == 0) {
                cjv.this.O00000Oo = motionEvent.getX();
                cjv.this.O00000o0 = motionEvent.getY();
                cjv cjv = cjv.this;
                cjv.O0000oO0 = cjv.O00000Oo;
                cjv cjv2 = cjv.this;
                cjv2.O0000oO = cjv2.O00000o0;
                cjv cjv3 = cjv.this;
                cjv3.O0000o0o = 0.0f;
                cjv3.O0000o = 0.0f;
                if (cjv3.f13952O000000o.getmMaxOffsetY() <= (-cjv.this.f13952O000000o.getmOffsetY())) {
                    cjv.this.O0000o0 = true;
                } else {
                    cjv.this.O0000o0 = false;
                }
                if (cjv.this.f13952O000000o.getmMaxOffsetY() <= cjv.this.f13952O000000o.getmOffsetY()) {
                    cjv.this.O0000o0O = true;
                } else {
                    cjv.this.O0000o0O = false;
                }
                if (cjv.this.f13952O000000o.getmMaxOffsetX() == cjv.this.f13952O000000o.getmOffsetX()) {
                    cjv.this.O0000Ooo = true;
                } else {
                    cjv.this.O0000Ooo = false;
                }
                if (cjv.this.f13952O000000o.getmMaxOffsetX() == (-cjv.this.f13952O000000o.getmOffsetX())) {
                    cjv.this.O0000o00 = true;
                } else {
                    cjv.this.O0000o00 = false;
                }
                return true;
            } else if (motionEvent.getAction() == 2) {
                if (!cjv.this.O00000oo) {
                    cjv.this.f13952O000000o.O00000Oo((float) ((int) (motionEvent.getX() - cjv.this.O00000Oo)), (float) ((int) (-(motionEvent.getY() - cjv.this.O00000o0))));
                    cjv.this.f13952O000000o.requestRender();
                    if (motionEvent.getPointerCount() > 1) {
                        cjv.this.O0000oO0 = motionEvent.getX();
                        cjv.this.O0000oO = motionEvent.getY();
                        cjv cjv4 = cjv.this;
                        cjv4.O0000o0o = 0.0f;
                        cjv4.O0000o = 0.0f;
                    } else {
                        cjv cjv5 = cjv.this;
                        cjv5.O0000o0o = cjv5.O0000oO0 - motionEvent.getX();
                        cjv cjv6 = cjv.this;
                        cjv6.O0000o = cjv6.O0000oO - motionEvent.getY();
                    }
                    cjv.this.O00000Oo = motionEvent.getX();
                    cjv.this.O00000o0 = motionEvent.getY();
                }
                return true;
            } else if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return true;
            } else {
                cjv cjv7 = cjv.this;
                cjv7.O00000oo = false;
                if (cjv7.O0000o == 0.0f && cjv.this.O0000o0o == 0.0f) {
                    return true;
                }
                if (Math.abs(cjv.this.O0000o0o) > Math.abs(cjv.this.O0000o)) {
                    if (cjv.this.O0000Ooo || cjv.this.O0000o00) {
                        if (cjv.this.O0000o0o > 10.0f && cjv.this.O0000o00) {
                            cki.O00000o("PhotoViewGestureHelper", "toRight2");
                            cjv.this.O000000o(2);
                        } else if (cjv.this.O0000o0o < -10.0f && cjv.this.O0000Ooo) {
                            cki.O00000o("PhotoViewGestureHelper", "toLeft1");
                            cjv.this.O000000o(1);
                        }
                    }
                } else if (cjv.this.O0000o0 || cjv.this.O0000o0O) {
                    if (cjv.this.O0000o < -10.0f && cjv.this.O0000o0) {
                        cjv.this.O000000o(3);
                        cki.O00000o("PhotoViewGestureHelper", "toTop3");
                    } else if (cjv.this.O0000o > 10.0f && cjv.this.O0000o0O) {
                        cjv.this.O000000o(4);
                        cki.O00000o("PhotoViewGestureHelper", "toBottom4");
                    }
                }
                cjv cjv8 = cjv.this;
                cjv8.O0000o0o = 0.0f;
                cjv8.O0000o = 0.0f;
                return true;
            }
        }
    };

    public cjv(PhotoView photoView) {
        this.f13952O000000o = photoView;
        this.O0000oOO = photoView.getContext();
        this.O0000OOo = new ScaleGestureDetector(this.O0000oOO, new ScaleGestureDetector.OnScaleGestureListener() {
            /* class _m_j.cjv.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            float f13953O000000o = 0.0f;

            public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                float scale = cjv.this.f13952O000000o.getScale();
                float f = this.f13953O000000o;
                if (scale > f) {
                    cjv.this.O00000Oo(1);
                } else if (scale < f) {
                    cjv.this.O00000Oo(2);
                }
            }

            public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                cjv cjv = cjv.this;
                cjv.O00000oo = true;
                this.f13953O000000o = cjv.f13952O000000o.getScale();
                return true;
            }

            public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                cjv.this.f13952O000000o.O000000o(cjv.this.f13952O000000o.getScale() * scaleGestureDetector.getScaleFactor(), cjv.this.O0000OOo.getFocusX(), cjv.this.O0000OOo.getFocusY(), false);
                cjv.this.f13952O000000o.requestRender();
                return true;
            }
        });
        this.O0000O0o = new GestureDetector(this.O0000oOO, new GestureDetector.SimpleOnGestureListener() {
            /* class _m_j.cjv.AnonymousClass2 */

            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || (Math.abs(f) <= 500.0f && Math.abs(f2) <= 500.0f))) {
                    return super.onFling(motionEvent, motionEvent2, f, f2);
                }
                return true;
            }

            public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (cjv.this.O0000Oo0 == null) {
                    return true;
                }
                cjv.this.O0000Oo0.onVideoViewClick();
                return true;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.mijia.generalplayer.gl.PhotoView.O000000o(float, boolean):void
             arg types: [int, int]
             candidates:
              com.mijia.generalplayer.gl.PhotoView.O000000o(float, float):void
              com.mijia.generalplayer.gl.PhotoView.O000000o(float, boolean):void */
            public final boolean onDoubleTap(MotionEvent motionEvent) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (!cjv.this.O00000oO) {
                    float minScale = cjv.this.f13952O000000o.getMinScale();
                    float scale = cjv.this.f13952O000000o.getScale();
                    float fullScale = cjv.this.f13952O000000o.getFullScale();
                    if (minScale >= 0.9f) {
                        double scale2 = (double) cjv.this.f13952O000000o.getScale();
                        Double.isNaN(scale2);
                        if (Math.abs(scale2 - 1.0d) > 0.1d) {
                            cjv.this.f13952O000000o.O000000o(1.0f, true);
                        } else {
                            cjv.this.f13952O000000o.O000000o(cjv.this.f13952O000000o.getMaxScale(), x, y, true);
                        }
                    } else if (scale == minScale || scale > fullScale) {
                        cjv.this.f13952O000000o.O000000o(fullScale, x, y, true);
                    } else {
                        cjv.this.f13952O000000o.O000000o(minScale, x, y, true);
                    }
                } else {
                    double scale3 = (double) cjv.this.f13952O000000o.getScale();
                    Double.isNaN(scale3);
                    if (Math.abs(scale3 - 1.0d) > 0.1d) {
                        cjv.this.f13952O000000o.O000000o(1.0f, true);
                    } else {
                        cjv.this.f13952O000000o.O000000o(cjv.this.f13952O000000o.getMaxScale(), x, y, true);
                    }
                }
                return true;
            }
        });
        ((View) this.f13952O000000o.getParent()).setOnTouchListener(this.O0000oOo);
    }

    public final void O000000o(int i) {
        XmVideoViewGl.OnDirectionCtrlListener onDirectionCtrlListener = this.O0000OoO;
        if (onDirectionCtrlListener != null) {
            onDirectionCtrlListener.onClickPTZDirection(i);
        }
    }

    public final void O00000Oo(int i) {
        XmVideoViewGl.IVideoViewScaleListener iVideoViewScaleListener = this.O0000Oo;
        if (iVideoViewScaleListener != null) {
            iVideoViewScaleListener.reportVideoViewScaleEvent(i);
        }
    }
}
