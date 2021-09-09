package com.tmall.wireless.vaf.virtualview.view.page;

import _m_j.doy;
import _m_j.dpb;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

public class PageView extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    private ObjectAnimator f5895O000000o;
    protected SparseArray<List<doy.O000000o>> O00000Oo = new SparseArray<>();
    protected int O00000o = 0;
    protected doy O00000o0;
    protected int O00000oO;
    protected boolean O00000oo;
    protected int O0000O0o = 2500;
    protected int O0000OOo = 100;
    protected boolean O0000Oo = false;
    protected int O0000Oo0 = 500;
    protected boolean O0000OoO = true;
    protected boolean O0000Ooo = true;
    protected boolean O0000o = true;
    protected boolean O0000o0 = true;
    protected int O0000o00 = 0;
    protected long O0000o0O = 0;
    protected Handler O0000o0o = new Handler() {
        /* class com.tmall.wireless.vaf.virtualview.view.page.PageView.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (1 == message.what) {
                PageView.this.O00000Oo();
            }
        }
    };
    protected O00000Oo O0000oO;
    protected O00000o0 O0000oO0 = new O00000o0();
    protected boolean O0000oOO = true;
    private int O0000oOo;
    private VelocityTracker O0000oo;
    private int O0000oo0;
    private int O0000ooO;
    private int O0000ooo = ViewConfiguration.getMaximumFlingVelocity();

    public interface O00000Oo {
        void O0000OOo(int i, int i2);
    }

    public PageView(Context context) {
        super(context);
    }

    public void setAdapter(doy doy) {
        this.O00000o0 = doy;
    }

    public void setListener(O00000Oo o00000Oo) {
        this.O0000oO = o00000Oo;
    }

    public void setSlide(boolean z) {
        this.O0000o0 = z;
    }

    public void setAutoSwitchTimeInterval(int i) {
        this.O0000Oo0 = i;
    }

    public void setAnimatorTimeInterval(int i) {
        this.O0000OOo = i;
    }

    public void setAnimationStyle(int i) {
        this.O0000o00 = i;
    }

    public void setLayoutOrientation(boolean z) {
        this.O0000Ooo = z;
    }

    public void setStayTime(int i) {
        this.O0000O0o = i;
    }

    public void setOrientation(boolean z) {
        this.O0000OoO = z;
    }

    public void setAutoSwitch(boolean z) {
        this.O0000Oo = z;
    }

    public void setAutoSwitchDelay(long j) {
        this.O0000o0O = j;
    }

    public final void O00000Oo() {
        this.O00000oo = true;
        if (this.O0000OoO) {
            if (this.O0000Ooo) {
                this.f5895O000000o = ObjectAnimator.ofInt(this, "scrollX", 0, getMeasuredWidth());
            } else {
                this.f5895O000000o = ObjectAnimator.ofInt(this, "scrollX", 0, -getMeasuredWidth());
            }
        } else if (this.O0000Ooo) {
            this.f5895O000000o = ObjectAnimator.ofInt(this, "scrollY", 0, getMeasuredHeight());
        } else {
            this.f5895O000000o = ObjectAnimator.ofInt(this, "scrollY", 0, -getMeasuredHeight());
        }
        this.f5895O000000o.setDuration((long) this.O0000Oo0).addListener(this.O0000oO0);
        this.f5895O000000o.setInterpolator(getTimeInterpolater());
        this.f5895O000000o.setStartDelay(this.O0000o0O);
        this.f5895O000000o.start();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            this.O0000oOO = false;
            this.O0000o0o.removeMessages(1);
            return;
        }
        this.O0000oOO = true;
        if (this.O0000Oo && this.O00000o0.O000000o() > 1) {
            this.O0000o0o.removeMessages(1);
            this.O0000o0o.sendEmptyMessageDelayed(1, (long) this.O0000O0o);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O0000oOO = false;
        this.O0000o0o.removeMessages(1);
    }

    public final void O00000o0() {
        O00000Oo o00000Oo;
        this.O0000oOO = true;
        if (this.O0000o) {
            ObjectAnimator objectAnimator = this.f5895O000000o;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            O00000o();
            int i = 0;
            this.O0000o = false;
            this.O00000o = 0;
            int O000000o2 = this.O00000o0.O000000o();
            if (1 == O000000o2) {
                if (getChildCount() == 0) {
                    O000000o(this.O00000o, -1);
                } else {
                    O00000Oo(this.O00000o, -1);
                }
            } else if (O000000o2 > 1) {
                int i2 = this.O00000o - 1;
                if (i2 < 0) {
                    i2 += O000000o2;
                }
                int i3 = (this.O00000o + 1) % O000000o2;
                if (this.O0000Ooo) {
                    if (getChildCount() == 0) {
                        if (this.O0000o0) {
                            O000000o(i2, -1);
                        }
                        O000000o(this.O00000o, -1);
                        O000000o(i3, -1);
                    } else {
                        if (this.O0000o0) {
                            O00000Oo(i2, 0);
                            i = 1;
                        }
                        O00000Oo(this.O00000o, i);
                        O00000Oo(i3, i + 1);
                    }
                } else if (getChildCount() == 0) {
                    O000000o(i3, -1);
                    O000000o(this.O00000o, -1);
                    if (this.O0000o0) {
                        O000000o(i2, -1);
                    }
                } else {
                    O00000Oo(i3, 0);
                    O00000Oo(this.O00000o, 1);
                    if (this.O0000o0) {
                        O00000Oo(i2, 2);
                    }
                }
            }
            if (O000000o2 > 0 && (o00000Oo = this.O0000oO) != null) {
                o00000Oo.O0000OOo(1, O000000o2);
            }
        }
        if (this.O0000Oo && this.O00000o0.O000000o() > 1) {
            this.O0000o0o.removeMessages(1);
            this.O0000o0o.sendEmptyMessageDelayed(1, (long) this.O0000O0o);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        O00000o0();
    }

    private void O000000o(int i, int i2) {
        doy.O000000o o000000o;
        int O00000Oo2 = this.O00000o0.O00000Oo(i);
        List list = this.O00000Oo.get(O00000Oo2);
        if (list == null || list.size() <= 0) {
            doy.O000000o O00000o02 = this.O00000o0.O00000o0(O00000Oo2);
            O00000o02.O00000Oo = O00000Oo2;
            O00000o02.O00000o0 = i;
            o000000o = O00000o02;
        } else {
            o000000o = (doy.O000000o) list.remove(0);
            o000000o.O00000o0 = i;
        }
        this.O00000o0.O000000o(o000000o, i);
        if (i2 < 0) {
            addView(o000000o.f14823O000000o);
        } else {
            addView(o000000o.f14823O000000o, i2);
        }
    }

    private void O00000Oo(int i, int i2) {
        View view;
        int childCount = getChildCount();
        if (childCount == 0 || i2 >= childCount) {
            Log.d("PageView_TMTEST", "childCount == 0 or index >= childCount should not happen here");
            return;
        }
        if (i2 == -1) {
            view = getChildAt(childCount - 1);
        } else {
            view = getChildAt(i2);
        }
        doy.O000000o o000000o = (doy.O000000o) view.getTag();
        if (o000000o == null) {
            Log.d("PageView_TMTEST", "view holder == null, should not happen ");
        } else {
            this.O00000o0.O000000o(o000000o, i);
        }
    }

    private void O000000o() {
        VelocityTracker velocityTracker = this.O0000oo;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.O0000oo.recycle();
            this.O0000oo = null;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.O0000o0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                if (this.O0000OoO) {
                    this.O00000oO = x;
                } else {
                    this.O00000oO = y;
                }
                this.O0000oOo = x;
                this.O0000oo0 = y;
                this.O0000ooO = motionEvent.getPointerId(0);
            } else if (action == 2) {
                int i = x - this.O0000oOo;
                int i2 = y - this.O0000oo0;
                if (this.O0000OoO) {
                    if (Math.abs(i) > Math.abs(i2)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        return true;
                    }
                } else if (Math.abs(i2) > Math.abs(i)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r10 != 3) goto L_0x0165;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d6, code lost:
        if (r10 != 3) goto L_0x0165;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.O0000o0) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.O0000oo == null) {
            this.O0000oo = VelocityTracker.obtain();
        }
        this.O0000oo.addMovement(motionEvent);
        if (this.O0000OoO) {
            int x = (int) motionEvent.getX();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        setScrollX(-(x - this.O00000oO));
                    }
                }
                this.O0000oo.computeCurrentVelocity(1000, (float) this.O0000ooo);
                float xVelocity = this.O0000oo.getXVelocity(this.O0000ooO);
                this.O0000oo.getYVelocity(this.O0000ooO);
                int scrollX = getScrollX();
                int measuredWidth = getMeasuredWidth();
                if (Math.abs(scrollX) > measuredWidth / 2 || Math.abs(xVelocity) > 2000.0f) {
                    if (scrollX < 0) {
                        this.O00000oo = false;
                        this.f5895O000000o = ObjectAnimator.ofInt(this, "scrollX", scrollX, -measuredWidth);
                    } else {
                        this.O00000oo = true;
                        this.f5895O000000o = ObjectAnimator.ofInt(this, "scrollX", scrollX, measuredWidth);
                    }
                    this.f5895O000000o.setDuration((long) this.O0000OOo).addListener(this.O0000oO0);
                    this.f5895O000000o.setInterpolator(getTimeInterpolater());
                    this.f5895O000000o.start();
                } else {
                    ObjectAnimator.ofInt(this, "scrollX", scrollX, 0).setDuration((long) this.O0000OOo).start();
                }
                O000000o();
            } else {
                this.O00000oO = x;
            }
        } else {
            int y = (int) motionEvent.getY();
            int action2 = motionEvent.getAction();
            if (action2 != 0) {
                if (action2 != 1) {
                    if (action2 == 2) {
                        setScrollY(-(y - this.O00000oO));
                    }
                }
                this.O0000oo.computeCurrentVelocity(1000, (float) this.O0000ooo);
                float yVelocity = this.O0000oo.getYVelocity(this.O0000ooO);
                int scrollY = getScrollY();
                int measuredHeight = getMeasuredHeight();
                if (Math.abs(scrollY) > measuredHeight / 2 || Math.abs(yVelocity) > 2000.0f) {
                    if (scrollY < 0) {
                        this.O00000oo = false;
                        this.f5895O000000o = ObjectAnimator.ofInt(this, "scrollY", scrollY, -measuredHeight);
                    } else {
                        this.O00000oo = true;
                        this.f5895O000000o = ObjectAnimator.ofInt(this, "scrollY", scrollY, measuredHeight);
                    }
                    this.f5895O000000o.setDuration((long) this.O0000OOo).addListener(this.O0000oO0);
                    this.f5895O000000o.setInterpolator(getTimeInterpolater());
                    this.f5895O000000o.start();
                } else {
                    ObjectAnimator.ofInt(this, "scrollY", scrollY, 0).setDuration((long) this.O0000OOo).start();
                }
                O000000o();
            } else {
                this.O00000oO = y;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void O00000o() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            O000000o(i);
        }
        removeAllViews();
    }

    private void O000000o(int i) {
        doy.O000000o o000000o = (doy.O000000o) getChildAt(i).getTag();
        ((dpb) o000000o.f14823O000000o).getVirtualView().O00000o();
        List list = this.O00000Oo.get(o000000o.O00000Oo);
        if (list == null) {
            list = new ArrayList();
            this.O00000Oo.put(o000000o.O00000Oo, list);
        }
        if (list.size() >= 5) {
            list.remove(0);
        }
        list.add(o000000o);
    }

    private void O00000Oo(int i) {
        O000000o(i);
        removeViewAt(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    public final void O00000oO() {
        int O000000o2;
        int i;
        doy doy = this.O00000o0;
        if (doy != null && (O000000o2 = doy.O000000o()) > 0 && getChildCount() > 0) {
            if (this.O00000oo) {
                if (this.O0000Ooo) {
                    O00000Oo(0);
                } else {
                    O00000Oo(getChildCount() - 1);
                }
                this.O00000o = (this.O00000o + 1) % O000000o2;
                i = (this.O00000o + 1) % O000000o2;
                if (!this.O0000Ooo) {
                    O000000o(i, 0);
                    requestLayout();
                    if (this.O0000OoO) {
                        setScrollX(0);
                    } else {
                        setScrollY(0);
                    }
                    if (this.O0000Oo) {
                        this.O0000o0o.removeMessages(1);
                        if (this.O0000oOO) {
                            this.O0000o0o.sendEmptyMessageDelayed(1, (long) this.O0000O0o);
                            return;
                        }
                        return;
                    }
                    return;
                }
            } else {
                if (this.O0000Ooo) {
                    O00000Oo(getChildCount() - 1);
                } else {
                    O00000Oo(0);
                }
                this.O00000o--;
                int i2 = this.O00000o;
                if (i2 < 0) {
                    this.O00000o = i2 + O000000o2;
                }
                i = this.O00000o - 1;
                if (i < 0) {
                    i += O000000o2;
                }
                if (this.O0000Ooo) {
                    O000000o(i, 0);
                    requestLayout();
                    if (this.O0000OoO) {
                    }
                    if (this.O0000Oo) {
                    }
                }
            }
            O000000o(i, -1);
            requestLayout();
            if (this.O0000OoO) {
            }
            if (this.O0000Oo) {
            }
        }
    }

    public final void O00000oo() {
        if (this.O0000OoO) {
            setScrollX(0);
        } else {
            setScrollY(0);
        }
    }

    class O00000o0 implements Animator.AnimatorListener {
        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }

        O00000o0() {
        }

        public final void onAnimationEnd(Animator animator) {
            PageView.this.O00000oO();
            if (PageView.this.O0000oO != null) {
                PageView.this.O0000oO.O0000OOo(PageView.this.O00000o + 1, PageView.this.O00000o0.O000000o());
            }
        }

        public final void onAnimationCancel(Animator animator) {
            PageView.this.O00000oo();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        measureChildren(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (this.O0000OoO) {
            int i7 = ((!this.O0000Ooo || !this.O0000o0) && this.O0000Ooo) ? 0 : -i5;
            int i8 = 0;
            while (i8 < childCount) {
                int i9 = i7 + i5;
                getChildAt(i8).layout(i7, 0, i9, i6);
                i8++;
                i7 = i9;
            }
            return;
        }
        int i10 = (childCount <= 1 || ((!this.O0000Ooo || !this.O0000o0) && this.O0000Ooo)) ? 0 : -i6;
        int i11 = 0;
        while (i11 < childCount) {
            int i12 = i10 + i6;
            getChildAt(i11).layout(0, i10, i5, i12);
            i11++;
            i10 = i12;
        }
    }

    private TimeInterpolator getTimeInterpolater() {
        int i = this.O0000o00;
        if (i == 0) {
            return new LinearInterpolator();
        }
        if (i == 1) {
            return new O000000o();
        }
        if (i == 2) {
            return new AccelerateInterpolator();
        }
        if (i == 3) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i != 4) {
            return new LinearInterpolator();
        }
        return new O00000o();
    }

    public static class O00000o implements TimeInterpolator {
        public final float getInterpolation(float f) {
            double pow = Math.pow(2.0d, (double) (-10.0f * f));
            double d = (double) (f - 1.0f);
            Double.isNaN(d);
            return (float) ((pow * Math.sin((d * 6.283185307179586d) / 4.0d)) + 1.0d);
        }
    }

    public static class O000000o implements TimeInterpolator {
        public final float getInterpolation(float f) {
            return (float) (1.0d - Math.pow((double) (1.0f - f), 10.0d));
        }
    }
}
