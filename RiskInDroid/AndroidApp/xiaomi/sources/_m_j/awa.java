package _m_j;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.gyf.immersionbar.BarHide;

final class awa implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: O000000o  reason: collision with root package name */
    View f12655O000000o;
    boolean O00000Oo;
    private Window O00000o;
    private awb O00000o0;
    private View O00000oO;
    private View O00000oo;
    private int O0000O0o = 0;
    private int O0000OOo = 0;
    private int O0000Oo = 0;
    private int O0000Oo0 = 0;
    private int O0000OoO;

    awa(awb awb) {
        this.O00000o0 = awb;
        this.O00000o = awb.O00000o;
        this.f12655O000000o = this.O00000o.getDecorView();
        FrameLayout frameLayout = (FrameLayout) this.f12655O000000o.findViewById(16908290);
        if (awb.O0000O0o) {
            Fragment fragment = awb.O00000Oo;
            if (fragment != null) {
                this.O00000oo = fragment.getView();
            } else {
                android.app.Fragment fragment2 = awb.O00000o0;
                if (fragment2 != null) {
                    this.O00000oo = fragment2.getView();
                }
            }
        } else {
            this.O00000oo = frameLayout.getChildAt(0);
            View view = this.O00000oo;
            if (view != null && (view instanceof DrawerLayout)) {
                this.O00000oo = ((DrawerLayout) view).getChildAt(0);
            }
        }
        View view2 = this.O00000oo;
        if (view2 != null) {
            this.O0000O0o = view2.getPaddingLeft();
            this.O0000OOo = this.O00000oo.getPaddingTop();
            this.O0000Oo0 = this.O00000oo.getPaddingRight();
            this.O0000Oo = this.O00000oo.getPaddingBottom();
        }
        View view3 = this.O00000oo;
        this.O00000oO = view3 == null ? frameLayout : view3;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.O00000o.setSoftInputMode(i);
            if (!this.O00000Oo) {
                this.f12655O000000o.getViewTreeObserver().addOnGlobalLayoutListener(this);
                this.O00000Oo = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        if (Build.VERSION.SDK_INT >= 19 && this.O00000Oo) {
            if (this.O00000oo != null) {
                this.O00000oO.setPadding(this.O0000O0o, this.O0000OOo, this.O0000Oo0, this.O0000Oo);
            } else {
                this.O00000oO.setPadding(this.O00000o0.O0000o0O, this.O00000o0.O0000o0o, this.O00000o0.O0000o, this.O00000o0.O0000oO0);
            }
        }
    }

    public final void onGlobalLayout() {
        int i;
        awb awb = this.O00000o0;
        if (awb != null && awb.O0000Oo0 != null && this.O00000o0.O0000Oo0.O000O0o0) {
            awb awb2 = this.O00000o0;
            if (awb2.O0000Oo == null) {
                awb2.O0000Oo = new avv(awb2.f12656O000000o);
            }
            avv avv = awb2.O0000Oo;
            if (avv.O000000o()) {
                i = avv.O00000o;
            } else {
                i = avv.O00000oO;
            }
            Rect rect = new Rect();
            this.f12655O000000o.getWindowVisibleDisplayFrame(rect);
            int height = this.O00000oO.getHeight() - rect.bottom;
            if (height != this.O0000OoO) {
                this.O0000OoO = height;
                int i2 = 0;
                int i3 = 1;
                if (!awb.O000000o(this.O00000o.getDecorView().findViewById(16908290))) {
                    if (this.O00000oo != null) {
                        if (this.O00000o0.O0000Oo0.O00oOoOo) {
                            height += this.O00000o0.O0000OoO + avv.f12648O000000o;
                        }
                        if (this.O00000o0.O0000Oo0.O0000ooo) {
                            height += avv.f12648O000000o;
                        }
                        if (height > i) {
                            i2 = height + this.O0000Oo;
                        } else {
                            i3 = 0;
                        }
                        this.O00000oO.setPadding(this.O0000O0o, this.O0000OOo, this.O0000Oo0, i2);
                        i2 = i3;
                    } else {
                        int i4 = this.O00000o0.O0000oO0;
                        int i5 = height - i;
                        if (i5 > i) {
                            i4 = i5 + i;
                            i2 = 1;
                        }
                        this.O00000oO.setPadding(this.O00000o0.O0000o0O, this.O00000o0.O0000o0o, this.O00000o0.O0000o, i4);
                    }
                } else if (height - i > i) {
                    i2 = 1;
                }
                if (i2 == 0 && this.O00000o0.O0000Oo0.O0000Oo != BarHide.FLAG_SHOW_BAR) {
                    this.O00000o0.O00000Oo();
                }
            }
        }
    }
}
