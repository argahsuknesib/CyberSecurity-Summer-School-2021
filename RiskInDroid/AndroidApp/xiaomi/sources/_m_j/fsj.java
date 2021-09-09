package _m_j;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.xiaomi.smarthome.R;

public final class fsj {

    /* renamed from: O000000o  reason: collision with root package name */
    public ViewGroup f17055O000000o;
    public ViewGroup O00000Oo;
    public View O00000o;
    public View O00000o0;
    public O00000Oo O00000oO;
    public O000000o O00000oo;
    public Animation O0000O0o;
    public Animation O0000OOo;
    private Animation O0000Oo;
    public boolean O0000Oo0 = true;
    private Animation O0000OoO;

    public interface O000000o {
        void O000000o();
    }

    public interface O00000Oo {
        void O000000o();
    }

    public fsj(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.f17055O000000o = viewGroup;
        this.O00000Oo = viewGroup2;
        this.O0000O0o = AnimationUtils.loadAnimation(context, R.anim.actionbar_top_show);
        this.O0000Oo = AnimationUtils.loadAnimation(context, R.anim.actionbar_top_hide);
        this.O0000OOo = AnimationUtils.loadAnimation(context, R.anim.actionbar_bottom_show);
        this.O0000OoO = AnimationUtils.loadAnimation(context, R.anim.actionbar_bottom_hide);
        this.O0000O0o.setAnimationListener(new Animation.AnimationListener() {
            /* class _m_j.fsj.AnonymousClass1 */

            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                if (fsj.this.O0000Oo0 && fsj.this.O00000oO != null) {
                    fsj.this.O00000oO.O000000o();
                }
            }
        });
        this.O0000Oo.setAnimationListener(new Animation.AnimationListener() {
            /* class _m_j.fsj.AnonymousClass2 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (fsj.this.O0000Oo0 && fsj.this.O00000oO != null) {
                    fsj.this.O00000oo.O000000o();
                }
            }
        });
        this.O0000OOo.setAnimationListener(new Animation.AnimationListener() {
            /* class _m_j.fsj.AnonymousClass3 */

            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                if (!fsj.this.O0000Oo0 && fsj.this.O00000oO != null) {
                    fsj.this.O00000oO.O000000o();
                }
            }
        });
        this.O0000OoO.setAnimationListener(new Animation.AnimationListener() {
            /* class _m_j.fsj.AnonymousClass4 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (!fsj.this.O0000Oo0 && fsj.this.O00000oo != null) {
                    fsj.this.O00000oo.O000000o();
                }
            }
        });
    }

    public final void O000000o() {
        View view;
        View view2;
        ViewGroup viewGroup = this.f17055O000000o;
        if (!(viewGroup == null || (view2 = this.O00000o0) == null)) {
            viewGroup.removeView(view2);
            this.O00000o0.setVisibility(8);
        }
        if (!(this.O00000Oo == null || (view = this.O00000o) == null)) {
            view.setVisibility(8);
            this.O00000Oo.removeView(this.O00000o);
        }
        this.O00000oO = null;
        this.O00000oo = null;
    }

    public final void O00000Oo() {
        View view = this.O00000o0;
        if (view != null) {
            this.O0000Oo0 = true;
            view.startAnimation(this.O0000Oo);
        }
        View view2 = this.O00000o;
        if (view2 != null) {
            view2.startAnimation(this.O0000OoO);
            this.O00000o.setVisibility(0);
        }
    }
}
