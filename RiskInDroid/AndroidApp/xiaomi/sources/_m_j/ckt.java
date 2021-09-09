package _m_j;

import android.view.MotionEvent;
import android.view.View;

public final class ckt implements View.OnTouchListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f13972O000000o;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO;
    private int O00000oo;
    private float O0000O0o;
    private boolean O0000OOo;
    private int O0000Oo;
    private float O0000Oo0 = 1.0f;
    private int O0000OoO;
    private int O0000Ooo;
    private boolean O0000o0;
    private boolean O0000o00;

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c9  */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        float f;
        float f2;
        float f3;
        int left;
        int top;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f4;
        int action = motionEvent.getAction() & 255;
        int i6 = 0;
        if (action == 0) {
            this.f13972O000000o = (int) motionEvent.getRawX();
            this.O00000Oo = (int) motionEvent.getRawY();
            this.O00000o0 = view.getLeft();
            this.O00000o = view.getRight();
            this.O00000oO = view.getTop();
            this.O00000oo = view.getBottom();
            this.O0000O0o = 0.0f;
            this.O0000Oo0 = 1.0f;
            if (this.O0000Oo == 0) {
                this.O0000Oo = this.O00000o - this.O00000o0;
                this.O0000OoO = this.O00000oO;
                this.O0000Ooo = this.O00000oo;
            }
            if (this.O00000o - this.O00000o0 > this.O0000Oo) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
            }
            this.O0000o00 = false;
            this.O0000o0 = false;
            return false;
        } else if (action == 1) {
            return this.O0000o00;
        } else {
            if (action == 2) {
                this.O0000OOo = !this.O0000OOo;
                if (motionEvent.getPointerCount() == 2) {
                    this.O0000o0 = true;
                    try {
                        f2 = motionEvent.getX(0) - motionEvent.getX(1);
                        try {
                            f = motionEvent.getY(0) - motionEvent.getY(1);
                        } catch (IllegalArgumentException e) {
                            e = e;
                            e.printStackTrace();
                            f = 0.0f;
                            float sqrt = (float) Math.sqrt((double) ((f2 * f2) + (f * f)));
                            f3 = this.O0000O0o;
                            if (f3 == 0.0f) {
                            }
                            return true;
                        }
                    } catch (IllegalArgumentException e2) {
                        e = e2;
                        f2 = 0.0f;
                        e.printStackTrace();
                        f = 0.0f;
                        float sqrt2 = (float) Math.sqrt((double) ((f2 * f2) + (f * f)));
                        f3 = this.O0000O0o;
                        if (f3 == 0.0f) {
                        }
                        return true;
                    }
                    float sqrt22 = (float) Math.sqrt((double) ((f2 * f2) + (f * f)));
                    f3 = this.O0000O0o;
                    if (f3 == 0.0f) {
                        this.O0000O0o = sqrt22;
                    } else if (sqrt22 - f3 >= 10.0f || sqrt22 - f3 <= -10.0f) {
                        float f5 = sqrt22 / this.O0000O0o;
                        int abs = Math.abs(this.O00000o - this.O00000o0);
                        int abs2 = Math.abs(this.O00000oo - this.O00000oO);
                        float f6 = (float) abs;
                        float f7 = f6 * f5;
                        int i7 = this.O0000Oo;
                        if (f7 < ((float) i7)) {
                            f4 = (float) i7;
                        } else {
                            if (f7 > ((float) i7) * 2.5f) {
                                f4 = ((float) i7) * 2.5f;
                            }
                            float f8 = this.O0000Oo0 - f5;
                            float f9 = (float) abs2;
                            left = ((int) ((f6 * f8) / 2.0f)) + view.getLeft();
                            top = view.getTop() + ((int) ((f8 * f9) / 2.0f));
                            i = (int) (((float) left) + (f6 * f5));
                            i2 = (int) (((float) top) + (f9 * f5));
                            if (left <= 0) {
                                i -= left;
                            } else {
                                i6 = left;
                            }
                            i3 = this.O0000Oo;
                            if (i < i3) {
                                i6 -= i - i3;
                                i = i3;
                            }
                            i4 = this.O0000OoO;
                            if (top <= i4) {
                                i2 -= top - i4;
                            } else {
                                i4 = top;
                            }
                            i5 = this.O0000Ooo;
                            if (i2 < i5) {
                                i4 -= i2 - i5;
                                i2 = i5;
                            }
                            view.layout(i6, i4, i, i2);
                            this.O0000Oo0 = f5;
                            this.O0000o00 = true;
                        }
                        f5 = f4 / f6;
                        float f82 = this.O0000Oo0 - f5;
                        float f92 = (float) abs2;
                        left = ((int) ((f6 * f82) / 2.0f)) + view.getLeft();
                        top = view.getTop() + ((int) ((f82 * f92) / 2.0f));
                        i = (int) (((float) left) + (f6 * f5));
                        i2 = (int) (((float) top) + (f92 * f5));
                        if (left <= 0) {
                        }
                        i3 = this.O0000Oo;
                        if (i < i3) {
                        }
                        i4 = this.O0000OoO;
                        if (top <= i4) {
                        }
                        i5 = this.O0000Ooo;
                        if (i2 < i5) {
                        }
                        view.layout(i6, i4, i, i2);
                        this.O0000Oo0 = f5;
                        this.O0000o00 = true;
                    }
                } else if (!this.O0000o0) {
                    int rawX = ((int) motionEvent.getRawX()) - this.f13972O000000o;
                    int rawY = ((int) motionEvent.getRawY()) - this.O00000Oo;
                    if ((rawX >= 0 || view.getRight() > this.O0000Oo) && (rawX <= 0 || view.getLeft() < 0)) {
                        double d = (double) this.O0000Oo;
                        Double.isNaN(d);
                        if (((double) (view.getRight() - view.getLeft())) > d + 0.01d) {
                            view.getParent().requestDisallowInterceptTouchEvent(true);
                        }
                    } else {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    if (Math.abs(rawX) > 3 || Math.abs(rawY) > 3) {
                        if (view.getWidth() > this.O0000Oo) {
                            int left2 = view.getLeft() + rawX;
                            int top2 = view.getTop() + rawY;
                            int right = view.getRight() + rawX;
                            int bottom = view.getBottom() + rawY;
                            if (left2 > 0) {
                                right = view.getWidth() + 0;
                            } else {
                                i6 = left2;
                            }
                            int i8 = this.O0000Oo;
                            if (right < i8) {
                                i6 = i8 - view.getWidth();
                            } else {
                                i8 = right;
                            }
                            int i9 = this.O0000OoO;
                            if (top2 > i9) {
                                bottom -= top2 - i9;
                            } else {
                                i9 = top2;
                            }
                            int i10 = this.O0000Ooo;
                            if (bottom < i10) {
                                i9 -= bottom - i10;
                                bottom = i10;
                            }
                            if (!(i6 == view.getLeft() && i9 == view.getTop())) {
                                view.layout(i6, i9, i8, bottom);
                            }
                        }
                        this.f13972O000000o = (int) motionEvent.getRawX();
                        this.O00000Oo = (int) motionEvent.getRawY();
                        this.O0000o00 = true;
                    }
                }
            }
            return true;
        }
    }
}
