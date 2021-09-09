package _m_j;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.legacy.widget.Space;
import androidx.viewpager.widget.ViewPager;
import java.util.Collections;
import java.util.LinkedList;

public final class czz implements czs, dah, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: O000000o  reason: collision with root package name */
    protected View f14412O000000o;
    protected View O00000Oo;
    protected View O00000o;
    protected View O00000o0;
    protected View O00000oO;
    protected int O00000oo = 0;
    protected boolean O0000O0o = true;
    protected boolean O0000OOo = true;
    protected dac O0000Oo0 = new dac();

    public czz(View view) {
        this.O00000o0 = view;
        this.O00000Oo = view;
        this.f14412O000000o = view;
    }

    public final void O000000o(boolean z, boolean z2) {
        this.O0000O0o = z;
        this.O0000OOo = z2;
    }

    private View O000000o(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF2 = new PointF();
            while (childCount > 0) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (!daq.O000000o(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    childCount--;
                } else if (!(childAt instanceof ViewPager) && dar.O00000o0(childAt)) {
                    return childAt;
                } else {
                    pointF.offset(pointF2.x, pointF2.y);
                    View O000000o2 = O000000o(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return O000000o2;
                }
            }
        }
        return view2;
    }

    public final View O000000o() {
        return this.f14412O000000o;
    }

    public final View O00000Oo() {
        return this.O00000o0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    public final void O000000o(int i, int i2, int i3) {
        boolean z;
        View view;
        View view2;
        View findViewById;
        View findViewById2;
        if (!(i2 == -1 || (findViewById2 = this.O00000Oo.findViewById(i2)) == null)) {
            if (i > 0) {
                findViewById2.setTranslationY((float) i);
                z = true;
                if (!(i3 == -1 || (findViewById = this.O00000Oo.findViewById(i3)) == null)) {
                    if (i >= 0) {
                        findViewById.setTranslationY((float) i);
                        z = true;
                    } else if (findViewById.getTranslationY() < 0.0f) {
                        findViewById.setTranslationY(0.0f);
                    }
                }
                if (z) {
                    this.O00000Oo.setTranslationY((float) i);
                } else {
                    this.O00000Oo.setTranslationY(0.0f);
                }
                view = this.O00000o;
                if (view != null) {
                    view.setTranslationY((float) Math.max(0, i));
                }
                view2 = this.O00000oO;
                if (view2 == null) {
                    view2.setTranslationY((float) Math.min(0, i));
                    return;
                }
                return;
            } else if (findViewById2.getTranslationY() > 0.0f) {
                findViewById2.setTranslationY(0.0f);
            }
        }
        z = false;
        if (i >= 0) {
        }
        if (z) {
        }
        view = this.O00000o;
        if (view != null) {
        }
        view2 = this.O00000oO;
        if (view2 == null) {
        }
    }

    public final boolean O00000o0() {
        return this.O0000O0o && this.O0000Oo0.O000000o(this.f14412O000000o);
    }

    public final boolean O00000o() {
        return this.O0000OOo && this.O0000Oo0.O00000Oo(this.f14412O000000o);
    }

    public final void O000000o(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset((float) (-this.f14412O000000o.getLeft()), (float) (-this.f14412O000000o.getTop()));
        View view = this.O00000o0;
        View view2 = this.f14412O000000o;
        if (view != view2) {
            this.O00000o0 = O000000o(view2, pointF, view);
        }
        if (this.O00000o0 == this.f14412O000000o) {
            this.O0000Oo0.f14414O000000o = null;
        } else {
            this.O0000Oo0.f14414O000000o = pointF;
        }
    }

    public final void O000000o(czw czw, View view, View view2) {
        View view3 = this.f14412O000000o;
        boolean isInEditMode = view3.isInEditMode();
        View view4 = view3;
        View view5 = null;
        while (true) {
            if (view5 != null && (!(view5 instanceof bs) || (view5 instanceof bo))) {
                break;
            }
            boolean z = view5 == null;
            LinkedList linkedList = new LinkedList(Collections.singletonList(view4));
            View view6 = null;
            while (!linkedList.isEmpty() && view6 == null) {
                View view7 = (View) linkedList.poll();
                if (view7 != null) {
                    if ((z || view7 != view4) && dar.O00000o0(view7)) {
                        view6 = view7;
                    } else if (view7 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view7;
                        for (int i = 0; i < viewGroup.getChildCount(); i++) {
                            linkedList.add(viewGroup.getChildAt(i));
                        }
                    }
                }
            }
            if (view6 != null) {
                view4 = view6;
            }
            if (view4 == view5) {
                break;
            }
            if (!isInEditMode) {
                try {
                    if (view4 instanceof CoordinatorLayout) {
                        czw.O000000o().O00000oO();
                        dap.O000000o((ViewGroup) view4, this);
                    }
                } catch (Throwable unused) {
                }
            }
            view5 = view4;
        }
        if (view5 != null) {
            this.O00000o0 = view5;
        }
        if (view != null || view2 != null) {
            this.O00000o = view;
            this.O00000oO = view2;
            FrameLayout frameLayout = new FrameLayout(this.f14412O000000o.getContext());
            czw.O000000o().getLayout().removeView(this.f14412O000000o);
            ViewGroup.LayoutParams layoutParams = this.f14412O000000o.getLayoutParams();
            frameLayout.addView(this.f14412O000000o, -1, -1);
            czw.O000000o().getLayout().addView(frameLayout, layoutParams);
            this.f14412O000000o = frameLayout;
            if (view != null) {
                view.setClickable(true);
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                int indexOfChild = viewGroup2.indexOfChild(view);
                viewGroup2.removeView(view);
                layoutParams2.height = dar.O000000o(view);
                viewGroup2.addView(new Space(this.f14412O000000o.getContext()), indexOfChild, layoutParams2);
                frameLayout.addView(view);
            }
            if (view2 != null) {
                view2.setClickable(true);
                ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
                ViewGroup viewGroup3 = (ViewGroup) view2.getParent();
                int indexOfChild2 = viewGroup3.indexOfChild(view2);
                viewGroup3.removeView(view2);
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(layoutParams3);
                layoutParams3.height = dar.O000000o(view2);
                viewGroup3.addView(new Space(this.f14412O000000o.getContext()), indexOfChild2, layoutParams3);
                layoutParams4.gravity = 80;
                frameLayout.addView(view2, layoutParams4);
            }
        }
    }

    public final void O000000o(czy czy) {
        if (czy instanceof dac) {
            this.O0000Oo0 = (dac) czy;
        } else {
            this.O0000Oo0.O00000Oo = czy;
        }
    }

    public final void O000000o(boolean z) {
        this.O0000Oo0.O00000o0 = z;
    }

    public final ValueAnimator.AnimatorUpdateListener O000000o(int i) {
        View view = this.O00000o0;
        if (view == null || i == 0) {
            return null;
        }
        if ((i >= 0 || !daq.O00000Oo(view)) && (i <= 0 || !daq.O000000o(this.O00000o0))) {
            return null;
        }
        this.O00000oo = i;
        return this;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View childAt;
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            if (this.O00000o0 instanceof AbsListView) {
                AbsListView absListView = (AbsListView) this.O00000o0;
                int i = intValue - this.O00000oo;
                if (Build.VERSION.SDK_INT >= 19) {
                    absListView.scrollListBy(i);
                } else if (absListView instanceof ListView) {
                    int firstVisiblePosition = absListView.getFirstVisiblePosition();
                    if (!(firstVisiblePosition == -1 || (childAt = absListView.getChildAt(0)) == null)) {
                        ((ListView) absListView).setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
                    }
                } else {
                    absListView.smoothScrollBy(i, 0);
                }
            } else {
                this.O00000o0.scrollBy(0, intValue - this.O00000oo);
            }
        } catch (Throwable unused) {
        }
        this.O00000oo = intValue;
    }
}
