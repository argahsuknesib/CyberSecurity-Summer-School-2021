package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.TypedValue;
import android.view.DisplayCutout;
import com.gyf.immersionbar.BarHide;

final class awd implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    awb f12659O000000o;
    private avx O00000Oo;
    private int O00000o;
    private awh O00000o0;

    awd(Object obj) {
        if ((obj instanceof Activity) && this.f12659O000000o == null) {
            this.f12659O000000o = new awb((Activity) obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        awb awb = this.f12659O000000o;
        if (awb != null && !awb.O00000oo && awb.O0000o00 && awb.O0000Oo0 != null) {
            if (awg.O00000o() && awb.O0000Oo0.O000OO00) {
                awb.O000000o();
            } else if (awb.O0000Oo0.O0000Oo != BarHide.FLAG_SHOW_BAR) {
                awb.O00000Oo();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        this.O00000Oo = null;
        awb awb = this.f12659O000000o;
        if (awb != null) {
            if (awb.f12656O000000o != null) {
                if (awb.O0000Ooo != null) {
                    awa awa = awb.O0000Ooo;
                    if (Build.VERSION.SDK_INT >= 19 && awa.O00000Oo) {
                        awa.f12655O000000o.getViewTreeObserver().removeOnGlobalLayoutListener(awa);
                        awa.O00000Oo = false;
                    }
                    awb.O0000Ooo = null;
                }
                avz.O000000o().O00000Oo(awb);
                awe O000000o2 = awe.O000000o();
                awi awi = awb.O0000Oo0.O000OO;
                if (!(awi == null || O000000o2.f12660O000000o == null)) {
                    O000000o2.f12660O000000o.remove(awi);
                }
            }
            if (awb.O0000OOo && awb.O00000oO != null) {
                awb.O00000oO.O0000Oo0.O000O0o0 = awb.O00000oO.O0000o0;
                if (awb.O00000oO.O0000Oo0.O0000Oo != BarHide.FLAG_SHOW_BAR) {
                    awb.O00000oO.O00000Oo();
                }
            }
            awb.O0000o00 = false;
            this.f12659O000000o = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Configuration configuration) {
        awb awb = this.f12659O000000o;
        if (awb != null) {
            if (!awg.O00000o() && Build.VERSION.SDK_INT != 19) {
                awb.O00000o0();
            } else if (!awb.O0000o00 || awb.O00000oo || !awb.O0000Oo0.O000O0oo) {
                awb.O00000o0();
            } else {
                awb.O000000o();
            }
            O00000Oo(configuration);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(Configuration configuration) {
        awb awb = this.f12659O000000o;
        if (awb != null && awb.O0000o00 && Build.VERSION.SDK_INT >= 19) {
            this.O00000o0 = this.f12659O000000o.O0000Oo0.O000OOOo;
            if (this.O00000o0 != null) {
                Activity activity = this.f12659O000000o.f12656O000000o;
                if (this.O00000Oo == null) {
                    this.O00000Oo = new avx();
                }
                this.O00000Oo.f12650O000000o = configuration.orientation == 1;
                int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
                if (rotation == 1) {
                    avx avx = this.O00000Oo;
                    avx.O00000Oo = true;
                    avx.O00000o0 = false;
                } else if (rotation == 3) {
                    avx avx2 = this.O00000Oo;
                    avx2.O00000Oo = false;
                    avx2.O00000o0 = true;
                } else {
                    avx avx3 = this.O00000Oo;
                    avx3.O00000Oo = false;
                    avx3.O00000o0 = false;
                }
                activity.getWindow().getDecorView().post(this);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        if ((_m_j.awf.O000000o(r0) != null) != false) goto L_0x0056;
     */
    public final void run() {
        boolean z;
        int identifier;
        awb awb = this.f12659O000000o;
        if (awb != null && awb.f12656O000000o != null) {
            Activity activity = this.f12659O000000o.f12656O000000o;
            avv avv = new avv(activity);
            this.O00000Oo.O00000oo = avv.f12648O000000o;
            this.O00000Oo.O00000oO = avv.O00000o0;
            this.O00000Oo.O0000O0o = avv.O00000o;
            this.O00000Oo.O0000OOo = avv.O00000oO;
            this.O00000Oo.O0000Oo = avv.O00000Oo;
            int i = 0;
            if (activity != null) {
                if (!awf.O000000o((Context) activity) && !awf.O00000Oo(activity) && !awf.O00000o(activity) && !awf.O00000o0(activity)) {
                }
                z = true;
                this.O00000Oo.O00000o = z;
                if (z && this.O00000o == 0) {
                    int O00000Oo2 = awb.O00000Oo(activity);
                    DisplayCutout O000000o2 = awf.O000000o(activity);
                    if (Build.VERSION.SDK_INT < 28 || O000000o2 == null) {
                        if (awf.O000000o((Context) activity) && (identifier = activity.getResources().getIdentifier("notch_height", "dimen", "android")) > 0) {
                            i = activity.getResources().getDimensionPixelSize(identifier);
                        }
                        if (awf.O00000Oo(activity)) {
                            i = awf.O00000oO(activity)[1];
                        }
                        if (awf.O00000o0(activity) && (i = (int) TypedValue.applyDimension(1, 32.0f, activity.getResources().getDisplayMetrics())) < O00000Oo2) {
                            i = O00000Oo2;
                        }
                        if (!awf.O00000o(activity)) {
                            O00000Oo2 = i;
                        } else if (80 >= O00000Oo2) {
                            O00000Oo2 = 80;
                        }
                    } else {
                        O00000Oo2 = activity.getResources().getConfiguration().orientation == 1 ? O000000o2.getSafeInsetTop() : O000000o2.getSafeInsetLeft() == 0 ? O000000o2.getSafeInsetRight() : O000000o2.getSafeInsetLeft();
                    }
                    this.O00000o = O00000Oo2;
                    this.O00000Oo.O0000Oo0 = this.O00000o;
                    return;
                }
            }
            z = false;
            this.O00000Oo.O00000o = z;
            if (z) {
            }
        }
    }
}
