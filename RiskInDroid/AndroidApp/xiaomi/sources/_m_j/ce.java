package _m_j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class ce {

    /* renamed from: O000000o  reason: collision with root package name */
    Runnable f13674O000000o = null;
    Runnable O00000Oo = null;
    private WeakReference<View> O00000o;
    int O00000o0 = -1;

    ce(View view) {
        this.O00000o = new WeakReference<>(view);
    }

    static class O000000o implements cf {

        /* renamed from: O000000o  reason: collision with root package name */
        ce f13677O000000o;
        boolean O00000Oo;

        O000000o(ce ceVar) {
            this.f13677O000000o = ceVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: _m_j.cf} */
        /* JADX WARNING: Multi-variable type inference failed */
        public final void O000000o(View view) {
            this.O00000Oo = false;
            cf cfVar = null;
            if (this.f13677O000000o.O00000o0 >= 0) {
                view.setLayerType(2, null);
            }
            if (this.f13677O000000o.f13674O000000o != null) {
                Runnable runnable = this.f13677O000000o.f13674O000000o;
                this.f13677O000000o.f13674O000000o = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof cf) {
                cfVar = tag;
            }
            if (cfVar != null) {
                cfVar.O000000o(view);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: _m_j.cf} */
        /* JADX WARNING: Multi-variable type inference failed */
        @SuppressLint({"WrongConstant"})
        public final void O00000Oo(View view) {
            cf cfVar = null;
            if (this.f13677O000000o.O00000o0 >= 0) {
                view.setLayerType(this.f13677O000000o.O00000o0, null);
                this.f13677O000000o.O00000o0 = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.O00000Oo) {
                if (this.f13677O000000o.O00000Oo != null) {
                    Runnable runnable = this.f13677O000000o.O00000Oo;
                    this.f13677O000000o.O00000Oo = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof cf) {
                    cfVar = tag;
                }
                if (cfVar != null) {
                    cfVar.O00000Oo(view);
                }
                this.O00000Oo = true;
            }
        }

        public final void O00000o0(View view) {
            Object tag = view.getTag(2113929216);
            cf cfVar = tag instanceof cf ? (cf) tag : null;
            if (cfVar != null) {
                cfVar.O00000o0(view);
            }
        }
    }

    public final ce O000000o(long j) {
        View view = this.O00000o.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public final ce O000000o(float f) {
        View view = this.O00000o.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public final ce O00000Oo(float f) {
        View view = this.O00000o.get();
        if (view != null) {
            view.animate().translationX(f);
        }
        return this;
    }

    public final ce O00000o0(float f) {
        View view = this.O00000o.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public final long O000000o() {
        View view = this.O00000o.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public final ce O000000o(Interpolator interpolator) {
        View view = this.O00000o.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public final ce O00000Oo(long j) {
        View view = this.O00000o.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public final void O00000Oo() {
        View view = this.O00000o.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void O00000o0() {
        View view = this.O00000o.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public final ce O000000o(cf cfVar) {
        View view = this.O00000o.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                O000000o(view, cfVar);
            } else {
                view.setTag(2113929216, cfVar);
                O000000o(view, new O000000o(this));
            }
        }
        return this;
    }

    private void O000000o(final View view, final cf cfVar) {
        if (cfVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                /* class _m_j.ce.AnonymousClass1 */

                public final void onAnimationCancel(Animator animator) {
                    cfVar.O00000o0(view);
                }

                public final void onAnimationEnd(Animator animator) {
                    cfVar.O00000Oo(view);
                }

                public final void onAnimationStart(Animator animator) {
                    cfVar.O000000o(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public final ce O000000o(final ch chVar) {
        final View view = this.O00000o.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            AnonymousClass2 r1 = null;
            if (chVar != null) {
                r1 = new ValueAnimator.AnimatorUpdateListener() {
                    /* class _m_j.ce.AnonymousClass2 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        chVar.O000000o();
                    }
                };
            }
            view.animate().setUpdateListener(r1);
        }
        return this;
    }
}
