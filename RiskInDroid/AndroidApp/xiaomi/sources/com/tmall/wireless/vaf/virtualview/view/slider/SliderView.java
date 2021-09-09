package com.tmall.wireless.vaf.virtualview.view.slider;

import _m_j.doy;
import _m_j.dpb;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import java.util.List;

public class SliderView extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f5898O000000o;
    protected SparseArray<List<doy.O000000o>> O00000Oo = new SparseArray<>();
    protected doy O00000o;
    protected boolean O00000o0 = true;
    protected int O00000oO;
    protected O000000o O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private int O0000Oo = 1;
    private int O0000Oo0;
    private VelocityTracker O0000OoO;
    private int O0000Ooo = ViewConfiguration.getMaximumFlingVelocity();
    private int O0000o;
    private int O0000o0;
    private int O0000o00;
    private int O0000o0O;
    private int O0000o0o;
    private int O0000oO;
    private int O0000oO0;
    private int O0000oOO;
    private int O0000oOo;
    private int O0000oo;
    private int O0000oo0;
    private ObjectAnimator O0000ooO;
    private int O0000ooo;
    private int O00oOooO;
    private int O00oOooo;

    public interface O000000o {
        void O0000OOo(int i, int i2);
    }

    public void setSpan(int i) {
        this.O00oOooo = i;
    }

    public SliderView(Context context) {
        super(context);
    }

    public void setListener(O000000o o000000o) {
        this.O00000oo = o000000o;
    }

    public void setOrientation(int i) {
        this.O0000Oo = i;
    }

    public void setItemWidth(int i) {
        this.O0000Oo0 = i;
        int i2 = this.O0000Oo0;
        this.f5898O000000o = i2 >> 1;
        this.O0000O0o = i2 << 1;
    }

    private void O000000o(int i, int i2) {
        doy.O000000o o000000o;
        int O00000Oo2 = this.O00000o.O00000Oo(i);
        List list = this.O00000Oo.get(O00000Oo2);
        if (list == null || list.size() <= 0) {
            doy.O000000o O00000o02 = this.O00000o.O00000o0(O00000Oo2);
            O00000o02.O00000Oo = O00000Oo2;
            O00000o02.O00000o0 = i;
            o000000o = O00000o02;
        } else {
            o000000o = (doy.O000000o) list.remove(0);
            o000000o.O00000o0 = i;
        }
        this.O00000o.O000000o(o000000o, i);
        if (i2 < 0) {
            addView(o000000o.f14823O000000o);
        } else {
            addView(o000000o.f14823O000000o, i2);
        }
    }

    private void O000000o(int i) {
        O00000Oo(i);
        removeViewAt(i);
    }

    private void O00000Oo(int i) {
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

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            if (1 == this.O0000Oo) {
                this.O00000oO = x;
            } else {
                this.O00000oO = y;
            }
            this.O0000oOo = x;
            this.O0000oo0 = y;
            this.O0000oo = motionEvent.getPointerId(0);
            this.O0000o00 = x;
            ObjectAnimator objectAnimator = this.O0000ooO;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
        } else if (action == 2) {
            int i = x - this.O0000oOo;
            int i2 = y - this.O0000oo0;
            if (1 == this.O0000Oo) {
                if (Math.abs(i) > Math.abs(i2)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                }
            } else if (Math.abs(i2) > Math.abs(i)) {
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
        }
        return false;
    }

    private void O00000o0(int i) {
        int i2;
        int i3;
        if (i < 0) {
            int i4 = this.O0000o0O;
            if (i4 + i < 0) {
                i = -i4;
            }
        } else if (i > 0) {
            int i5 = this.O0000o0;
            if (i5 - i < 0) {
                i = i5;
            }
        } else {
            return;
        }
        if (i != 0) {
            int i6 = -i;
            this.O0000o0o += i6;
            this.O0000o00 += i;
            scrollBy(i6, 0);
            this.O0000o0 -= i;
            this.O0000o0O += i;
            O000000o o000000o = this.O00000oo;
            if (o000000o != null) {
                o000000o.O0000OOo(this.O0000o0o, this.O0000oOO);
            }
        }
        int i7 = this.O0000o0;
        if (i7 >= this.O0000O0o) {
            if (this.O0000o < getChildCount() - 1) {
                O000000o(0);
                this.O0000o++;
                int i8 = this.O0000o0;
                int i9 = this.O0000Oo0;
                int i10 = this.O00oOooo;
                this.O0000o0 = i8 - (i9 + i10);
                scrollBy((-i9) - i10, 0);
            }
        } else if (i7 <= this.f5898O000000o && (i3 = this.O0000o) > 0) {
            int i11 = i3 - 1;
            this.O0000o = i11;
            O000000o(i11, 0);
            scrollBy(this.O0000Oo0 + this.O00oOooo, 0);
            this.O0000o0 += this.O0000Oo0 + this.O00oOooo;
        }
        int i12 = this.O0000o0O;
        if (i12 >= this.O0000O0o) {
            if (this.O0000oO0 > 0) {
                O000000o(getChildCount() - 1);
                this.O0000oO0--;
                this.O0000o0O -= this.O0000Oo0 + this.O00oOooo;
            }
        } else if (i12 <= this.f5898O000000o && (i2 = this.O0000oO0) < this.O0000oO - 1) {
            int i13 = i2 + 1;
            this.O0000oO0 = i13;
            O000000o(i13, -1);
            this.O0000o0O += this.O0000Oo0 + this.O00oOooo;
        }
    }

    public void setAutoScrollX(int i) {
        O00000o0(i - this.O00oOooO);
        if (this.O0000ooo < 0) {
            if (this.O0000o0O == 0) {
                this.O0000ooO.cancel();
            }
        } else if (this.O0000o0 == 0) {
            this.O0000ooO.cancel();
        }
        this.O00oOooO = i;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int O000000o2;
        this.O0000OOo = View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        if (this.O00000o0) {
            int childCount = getChildCount();
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                O00000Oo(i4);
            }
            removeAllViews();
            this.O00000o0 = false;
            this.O0000oO = this.O00000o.O000000o();
            int i5 = this.O0000oO;
            this.O0000oOO = ((this.O0000Oo0 * i5) + ((i5 - 1) * this.O00oOooo)) - this.O0000OOo;
            doy doy = this.O00000o;
            if (doy != null && (O000000o2 = doy.O000000o()) > 0) {
                this.O0000o0 = 0;
                this.O0000o = 0;
                this.O0000o0o = 0;
                int i6 = this.O0000OOo + this.O0000Oo0 + this.O00oOooo;
                int i7 = O000000o2 - 1;
                this.O0000oO0 = i7;
                int i8 = 0;
                while (true) {
                    if (i3 >= O000000o2) {
                        break;
                    }
                    O000000o(i3, -1);
                    i8 += this.O0000Oo0;
                    if (i3 < i7) {
                        i8 += this.O00oOooo;
                    }
                    if (i8 >= i6) {
                        this.O0000oO0 = i3;
                        break;
                    }
                    i3++;
                }
                this.O0000o0O = i8 - this.O0000OOo;
            }
        }
        measureChildren(View.MeasureSpec.makeMeasureSpec(this.O0000Oo0, 1073741824), View.MeasureSpec.makeMeasureSpec(size, 1073741824));
        setMeasuredDimension(this.O0000OOo, size);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingTop = getPaddingTop();
        int paddingBottom = ((i4 - i2) - paddingTop) - getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).layout(paddingLeft, paddingTop, this.O0000Oo0 + paddingLeft, paddingBottom);
            paddingLeft += this.O0000Oo0 + this.O00oOooo;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r5 != 3) goto L_0x008d;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.O0000OoO == null) {
            this.O0000OoO = VelocityTracker.obtain();
        }
        this.O0000OoO.addMovement(motionEvent);
        int x = (int) motionEvent.getX();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.O0000ooo = x - this.O0000o00;
                    O00000o0(this.O0000ooo);
                }
            }
            this.O0000OoO.computeCurrentVelocity(1, (float) this.O0000Ooo);
            float xVelocity = this.O0000OoO.getXVelocity(this.O0000oo);
            this.O0000OoO.getYVelocity(this.O0000oo);
            int i = this.O0000ooo;
            int i2 = ((int) xVelocity) * i;
            if (i > 0) {
                i2 = -i2;
            }
            this.O00oOooO = i2;
            this.O0000ooO = ObjectAnimator.ofInt(this, "autoScrollX", i2, 0);
            this.O0000ooO.setInterpolator(new DecelerateInterpolator());
            this.O0000ooO.setDuration(300L).start();
            VelocityTracker velocityTracker = this.O0000OoO;
            if (velocityTracker != null) {
                velocityTracker.clear();
                this.O0000OoO.recycle();
                this.O0000OoO = null;
            }
        } else {
            this.O0000o00 = x;
            ObjectAnimator objectAnimator = this.O0000ooO;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
        }
        return true;
    }
}
