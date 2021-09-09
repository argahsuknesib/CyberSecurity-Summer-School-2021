package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.scrollview;

import _m_j.gdm;
import _m_j.gdn;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.facebook.react.views.view.ReactViewGroup;

public class MIOTScrollLayout extends ReactViewGroup implements gdn, View.OnTouchListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f8621O000000o;
    private View O00000Oo;
    private gdm O00000o;
    private int O00000o0;
    private int O00000oO;
    private int O00000oo;
    private boolean O0000O0o;
    private int[] O0000OOo;
    private double[] O0000Oo;
    private double[] O0000Oo0;
    private int O0000OoO = -1;

    public MIOTScrollLayout(Context context) {
        super(context);
        this.f8621O000000o = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void addView(View view, int i) {
        if (i == 0 && this.O00000o0 != 0) {
            this.O00000Oo = view;
            this.O00000Oo.setOnTouchListener(this);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            while (true) {
                if (i2 >= viewGroup.getChildCount()) {
                    break;
                } else if (view instanceof gdm) {
                    this.O00000o = (gdm) view;
                    this.O00000o.setScrollListener(this);
                    break;
                } else {
                    i2++;
                }
            }
        }
        super.addView(view, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
        if (r2 > 0) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r10 != 3) goto L_0x00be;
     */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.O00000o == null) {
            return false;
        }
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i = this.O00000oo;
                    int i2 = y - i;
                    int abs = Math.abs(y - i);
                    gdm gdm = this.O00000o;
                    if (gdm != null) {
                        if (!this.O0000O0o && abs > this.f8621O000000o) {
                            if ((gdm.getSnapHeight() <= gdm.getScrollY()) || i2 >= 0) {
                                gdm gdm2 = this.O00000o;
                                if (gdm2.getSnapHeight() == gdm2.getScrollY()) {
                                }
                            }
                            this.O0000O0o = true;
                        }
                        if (this.O0000O0o) {
                            this.O00000o.smoothScrollBy(0, this.O00000oO - y);
                        }
                    }
                }
            }
            gdm gdm3 = this.O00000o;
            if (gdm3 != null) {
                boolean z = y <= this.O00000oo;
                int snapHeight = gdm3.getSnapHeight();
                float f = (float) snapHeight;
                int i3 = (int) (gdm3.O0000Oo0 * f);
                int i4 = (int) ((1.0f - gdm3.O0000Oo0) * f);
                int min = Math.min(Math.max(0, gdm3.getScrollY()), gdm3.getMaxScrollY());
                if (gdm3.getScrollY() >= snapHeight ? min < snapHeight : min > snapHeight) {
                    min = snapHeight;
                }
                if ((min >= i4 && min < snapHeight) || (min > i3 && min < i4 && z)) {
                    gdm3.O000000o(snapHeight);
                } else if ((min > 0 && min <= i3) || (min > i3 && min < i4 && !z)) {
                    gdm3.O000000o(0);
                }
            }
            this.O0000O0o = false;
        } else {
            this.O00000oo = y;
        }
        this.O00000oO = y;
        return true;
    }

    public void setHeaderHeight(int i) {
        this.O00000o0 = i;
    }

    public void setScaleIndices(int[] iArr) {
        this.O0000OOo = iArr;
    }

    public void setStartScales(double[] dArr) {
        this.O0000Oo0 = dArr;
    }

    public void setEndScales(double[] dArr) {
        this.O0000Oo = dArr;
    }

    public final void O000000o(int i) {
        View view = this.O00000Oo;
        if (view != null && this.O0000OoO != i) {
            int i2 = this.O00000o0 - i;
            int width = view.getWidth();
            float f = (((float) i2) * 1.0f) / ((float) this.O00000o0);
            View view2 = this.O00000Oo;
            boolean z = true;
            int i3 = 0;
            if (view2 == null || !(view2 instanceof ViewGroup) || ((ViewGroup) view2).getChildCount() != 1) {
                z = false;
            }
            if (z) {
                this.O00000Oo.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
                int left = this.O00000Oo.getLeft();
                int top = this.O00000Oo.getTop();
                this.O00000Oo.layout(left, top, width + left, i2 + top);
                View childAt = ((ViewGroup) this.O00000Oo).getChildAt(0);
                childAt.setPivotY(0.0f);
                childAt.setScaleX(f);
                childAt.setScaleY(f);
                if (this.O0000OOo != null && this.O0000Oo0 != null && this.O0000Oo != null && (childAt instanceof ViewGroup)) {
                    while (true) {
                        int[] iArr = this.O0000OOo;
                        if (i3 >= iArr.length) {
                            break;
                        }
                        View childAt2 = ((ViewGroup) childAt).getChildAt(iArr[i3]);
                        if (childAt2 != null) {
                            double d = (1.0d - this.O0000Oo[i3]) / this.O0000Oo0[i3];
                            double d2 = (double) f;
                            Double.isNaN(d2);
                            float f2 = (1.0f / f) * ((float) (((d2 * d) + 1.0d) - d));
                            childAt2.setScaleX(f2);
                            childAt2.setScaleY(f2);
                        }
                        i3++;
                    }
                }
            }
        }
        this.O0000OoO = i;
    }
}
