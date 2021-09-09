package com.mi.global.shop.widget.gallery;

import _m_j.cca;
import _m_j.ccb;
import _m_j.ccc;
import _m_j.ccr;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.mi.global.shop.widget.gallery.ImageViewTouchBase;

public class ZoomImageView extends ImageViewTouchBase {
    private cca mGestureDetector = new cca(getContext(), new O000000o(this, (byte) 0));
    public O00000o0 mImageTapListener;
    public boolean mOnScale;
    private ccc mScaleGestureDetector = new ccc(getContext(), new O00000Oo(this, (byte) 0));

    public interface O00000o0 {
    }

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public /* bridge */ /* synthetic */ void setImageBitmapResetBase(Bitmap bitmap, boolean z) {
        super.setImageBitmapResetBase(bitmap, z);
    }

    public /* bridge */ /* synthetic */ void setImageRotateBitmapResetBase(ccb ccb, boolean z) {
        super.setImageRotateBitmapResetBase(ccb, z);
    }

    public /* bridge */ /* synthetic */ void setRecycler(ImageViewTouchBase.O000000o o000000o) {
        super.setRecycler(o000000o);
    }

    public void setOnTapListener(O00000o0 o00000o0) {
        this.mImageTapListener = o00000o0;
    }

    public ZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean isZoomedOut() {
        return ((double) (getScale() - 1.0f)) > 0.1d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0262 A[Catch:{ Exception -> 0x032f }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0266 A[Catch:{ Exception -> 0x032f }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02b4 A[Catch:{ Exception -> 0x032f }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02b5 A[Catch:{ Exception -> 0x032f }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0188  */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ccr.O00000Oo("ZoomImageView", "The action is:" + motionEvent.getAction());
        boolean z5 = false;
        if (!this.mOnScale) {
            cca cca = this.mGestureDetector;
            int action = motionEvent.getAction();
            float y = motionEvent.getY();
            float x = motionEvent.getX();
            if (cca.O0000oo == null) {
                cca.O0000oo = VelocityTracker.obtain();
            }
            cca.O0000oo.addMovement(motionEvent);
            int i = action & 255;
            if (i == 0) {
                if (cca.O0000Ooo != null) {
                    boolean hasMessages = cca.O0000Oo.hasMessages(3);
                    if (hasMessages) {
                        cca.O0000Oo.removeMessages(3);
                    }
                    if (!(cca.O0000o == null || cca.O0000oO0 == null || !hasMessages)) {
                        MotionEvent motionEvent2 = cca.O0000o;
                        MotionEvent motionEvent3 = cca.O0000oO0;
                        if (cca.O0000o0o && motionEvent.getEventTime() - motionEvent3.getEventTime() <= ((long) cca.O0000Oo0)) {
                            int x2 = ((int) motionEvent2.getX()) - ((int) motionEvent.getX());
                            int y2 = ((int) motionEvent2.getY()) - ((int) motionEvent.getY());
                            if ((x2 * x2) + (y2 * y2) < cca.O00000o) {
                                z4 = true;
                                if (z4) {
                                    cca.O0000oO = true;
                                    cca.O0000Ooo.O000000o(cca.O0000o);
                                }
                            }
                        }
                        z4 = false;
                        if (z4) {
                        }
                    }
                    cca.O0000Oo.sendEmptyMessageDelayed(3, (long) cca.O0000Oo0);
                }
                cca.O0000oOo = x;
                cca.O0000oOO = y;
                if (cca.O0000o != null) {
                    cca.O0000o.recycle();
                }
                cca.O0000o = MotionEvent.obtain(motionEvent);
                cca.O0000o0O = true;
                cca.O0000o0o = true;
                cca.O0000o00 = true;
                cca.O0000o0 = false;
                if (cca.O0000oo0) {
                    cca.O0000Oo.removeMessages(2);
                    cca.O0000Oo.sendEmptyMessageAtTime(2, cca.O0000o.getDownTime() + ((long) cca.O0000OOo) + ((long) cca.O0000O0o));
                }
                cca.O0000Oo.sendEmptyMessageAtTime(1, cca.O0000o.getDownTime() + ((long) cca.O0000OOo));
            } else if (i == 1) {
                cca.O0000o00 = false;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                if (!cca.O0000oO) {
                    if (cca.O0000o0) {
                        cca.O0000Oo.removeMessages(3);
                        cca.O0000o0 = false;
                    } else if (!cca.O0000o0O) {
                        VelocityTracker velocityTracker = cca.O0000oo;
                        velocityTracker.computeCurrentVelocity(1000, (float) cca.O00000oo);
                        float yVelocity = velocityTracker.getYVelocity();
                        float xVelocity = velocityTracker.getXVelocity();
                        if (Math.abs(yVelocity) <= ((float) cca.O00000oO)) {
                            Math.abs(xVelocity);
                        }
                    }
                }
                if (cca.O0000oO0 != null) {
                    cca.O0000oO0.recycle();
                }
                cca.O0000oO0 = obtain;
                cca.O0000oo.recycle();
                cca.O0000oo = null;
                cca.O0000oO = false;
                cca.O0000Oo.removeMessages(1);
                cca.O0000Oo.removeMessages(2);
            } else if (i != 2) {
                if (i == 3) {
                    cca.O0000Oo.removeMessages(1);
                    cca.O0000Oo.removeMessages(2);
                    cca.O0000Oo.removeMessages(3);
                    cca.O0000oo.recycle();
                    cca.O0000oo = null;
                    cca.O0000oO = false;
                    cca.O0000o00 = false;
                    if (cca.O0000o0) {
                        cca.O0000o0 = false;
                    }
                }
            } else if (!cca.O0000o0) {
                float f = cca.O0000oOo - x;
                float f2 = cca.O0000oOO - y;
                if (!cca.O0000oO) {
                    if (cca.O0000o0O) {
                        int x3 = (int) (x - cca.O0000o.getX());
                        int y3 = (int) (y - cca.O0000o.getY());
                        int i2 = (x3 * x3) + (y3 * y3);
                        if (i2 > cca.O00000Oo) {
                            cca.O0000OoO.O000000o(f, f2);
                            cca.O0000oOo = x;
                            cca.O0000oOO = y;
                            cca.O0000o0O = false;
                            cca.O0000Oo.removeMessages(3);
                            cca.O0000Oo.removeMessages(1);
                            cca.O0000Oo.removeMessages(2);
                        }
                        if (i2 > cca.O00000o0) {
                            cca.O0000o0o = false;
                        }
                    } else if (Math.abs(f) >= 1.0f || Math.abs(f2) >= 1.0f) {
                        cca.O0000OoO.O000000o(f, f2);
                        cca.O0000oOo = x;
                        cca.O0000oOO = y;
                    }
                }
            }
        }
        try {
            ccc ccc = this.mScaleGestureDetector;
            int action2 = motionEvent.getAction();
            if (!ccc.O00000o) {
                int i3 = action2 & 255;
                if (i3 != 2) {
                    if (i3 == 5) {
                        DisplayMetrics displayMetrics = ccc.O00000Oo.getResources().getDisplayMetrics();
                        ccc.O0000oO = ((float) displayMetrics.widthPixels) - ccc.O0000oO0;
                        ccc.O0000oOO = ((float) displayMetrics.heightPixels) - ccc.O0000oO0;
                        ccc.O000000o();
                        ccc.O00000oO = MotionEvent.obtain(motionEvent);
                        ccc.O0000o = 0;
                        ccc.O00000o0(motionEvent);
                        float f3 = ccc.O0000oO0;
                        float f4 = ccc.O0000oO;
                        float f5 = ccc.O0000oOO;
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float O000000o2 = ccc.O000000o(motionEvent);
                        float O00000Oo2 = ccc.O00000Oo(motionEvent);
                        if (rawX >= f3 && rawY >= f3 && rawX <= f4) {
                            if (rawY <= f5) {
                                z3 = false;
                                if (O000000o2 < f3 || O00000Oo2 < f3 || O000000o2 > f4 || O00000Oo2 > f5) {
                                    z5 = true;
                                }
                                if (!z3 && z5) {
                                    ccc.O0000oOo = true;
                                } else if (!z3) {
                                    ccc.O0000oOo = true;
                                } else if (z5) {
                                    ccc.O0000oOo = true;
                                } else {
                                    ccc.O00000o = ccc.O00000o0.O000000o();
                                }
                            }
                        }
                        z3 = true;
                        z5 = true;
                        if (!z3) {
                        }
                        if (!z3) {
                        }
                    }
                } else if (ccc.O0000oOo) {
                    float f6 = ccc.O0000oO0;
                    float f7 = ccc.O0000oO;
                    float f8 = ccc.O0000oOO;
                    float rawX2 = motionEvent.getRawX();
                    float rawY2 = motionEvent.getRawY();
                    float O000000o3 = ccc.O000000o(motionEvent);
                    float O00000Oo3 = ccc.O00000Oo(motionEvent);
                    if (rawX2 >= f6 && rawY2 >= f6 && rawX2 <= f7) {
                        if (rawY2 <= f8) {
                            z = false;
                            if (O000000o3 >= f6 && O00000Oo3 >= f6 && O000000o3 <= f7) {
                                if (O00000Oo3 > f8) {
                                    z2 = false;
                                    if ((!z || !z2) && !z && !z2) {
                                        ccc.O0000oOo = false;
                                        ccc.O00000o = ccc.O00000o0.O000000o();
                                    }
                                }
                            }
                            z2 = true;
                            ccc.O0000oOo = false;
                            ccc.O00000o = ccc.O00000o0.O000000o();
                        }
                    }
                    z = true;
                    if (O00000Oo3 > f8) {
                    }
                }
            } else {
                int i4 = action2 & 255;
                if (i4 == 2) {
                    ccc.O00000o0(motionEvent);
                    ccc.O00000oo = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                    ccc.O0000O0o = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                    if (ccc.O0000o0O / ccc.O0000o0o > 0.67f) {
                        ccc.O00000o0.O000000o(ccc, ccc.O00000oo, ccc.O0000O0o);
                        ccc.O00000oO.recycle();
                        ccc.O00000oO = MotionEvent.obtain(motionEvent);
                    }
                } else if (i4 == 3) {
                    if (!ccc.O0000oOo) {
                        ccc.O00000o0.O00000Oo();
                    }
                    ccc.O000000o();
                } else if (i4 == 6) {
                    ccc.O00000o0(motionEvent);
                    if (!ccc.O0000oOo) {
                        ccc.O00000o0.O00000Oo();
                    }
                    ccc.O000000o();
                }
            }
        } catch (Exception unused) {
        }
        return true;
    }

    class O00000Oo implements ccc.O000000o {
        private float O00000Oo;
        private float O00000o;
        private float O00000o0;

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(ZoomImageView zoomImageView, byte b) {
            this();
        }

        public final boolean O000000o(ccc ccc, float f, float f2) {
            ccr.O00000Oo("ZoomImageView", "gesture onScale");
            float scale = ZoomImageView.this.getScale();
            if (ccc.O0000o0 == -1.0f) {
                if (ccc.O0000Ooo == -1.0f) {
                    float f3 = ccc.O0000Oo;
                    float f4 = ccc.O0000OoO;
                    ccc.O0000Ooo = (float) Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
                }
                float f5 = ccc.O0000Ooo;
                if (ccc.O0000o00 == -1.0f) {
                    float f6 = ccc.O0000OOo;
                    float f7 = ccc.O0000Oo0;
                    ccc.O0000o00 = (float) Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
                }
                ccc.O0000o0 = f5 / ccc.O0000o00;
            }
            float f8 = scale * ccc.O0000o0;
            this.O00000Oo = f8;
            this.O00000o0 = f;
            this.O00000o = f2;
            if (!ccc.O00000o) {
                return true;
            }
            ZoomImageView.this.zoomToNoCenter(f8, f, f2);
            return true;
        }

        public final boolean O000000o() {
            ccr.O00000Oo("ZoomImageView", "gesture onScaleStart");
            ZoomImageView.this.mOnScale = true;
            return true;
        }

        public final void O00000Oo() {
            if (this.O00000Oo > ZoomImageView.this.mMaxZoom) {
                ZoomImageView zoomImageView = ZoomImageView.this;
                zoomImageView.zoomToNoCenterWithAni(this.O00000Oo / zoomImageView.mMaxZoom, 1.0f, this.O00000o0, this.O00000Oo);
                this.O00000Oo = ZoomImageView.this.mMaxZoom;
                ZoomImageView.this.zoomToNoCenterValue(this.O00000Oo, this.O00000o0, this.O00000o);
            } else if (this.O00000Oo < ZoomImageView.this.mMinZoom) {
                ZoomImageView zoomImageView2 = ZoomImageView.this;
                zoomImageView2.zoomToNoCenterWithAni(this.O00000Oo, zoomImageView2.mMinZoom, this.O00000o0, this.O00000o);
                this.O00000Oo = ZoomImageView.this.mMinZoom;
                ZoomImageView.this.zoomToNoCenterValue(this.O00000Oo, this.O00000o0, this.O00000o);
            } else {
                ZoomImageView.this.zoomToNoCenter(this.O00000Oo, this.O00000o0, this.O00000o);
            }
            ZoomImageView.this.mOnScale = false;
        }
    }

    class O000000o extends cca.O00000o {
        private O000000o() {
        }

        /* synthetic */ O000000o(ZoomImageView zoomImageView, byte b) {
            this();
        }

        public final boolean O000000o(float f, float f2) {
            ccr.O00000Oo("ZoomImageView", "gesture onScroll");
            if (ZoomImageView.this.mOnScale) {
                return true;
            }
            ZoomImageView.this.panBy(-f, -f2);
            ZoomImageView.this.center(true, true);
            return true;
        }

        public final boolean O000000o(MotionEvent motionEvent) {
            if (ZoomImageView.this.mBaseZoom < 1.0f) {
                if (ZoomImageView.this.getScale() > 2.0f) {
                    ZoomImageView.this.zoomTo(1.0f);
                    return true;
                }
                ZoomImageView.this.zoomToPoint(3.0f, motionEvent.getX(), motionEvent.getY());
                return true;
            } else if (ZoomImageView.this.getScale() > (ZoomImageView.this.mMinZoom + ZoomImageView.this.mMaxZoom) / 2.0f) {
                ZoomImageView zoomImageView = ZoomImageView.this;
                zoomImageView.zoomTo(zoomImageView.mMinZoom);
                return true;
            } else {
                ZoomImageView zoomImageView2 = ZoomImageView.this;
                zoomImageView2.zoomToPoint(zoomImageView2.mMaxZoom, motionEvent.getX(), motionEvent.getY());
                return true;
            }
        }
    }
}
