package _m_j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class hgp extends hd {
    private static TimeInterpolator O0000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.O000OOo0>> f18901O000000o = new ArrayList<>();
    ArrayList<ArrayList<O00000Oo>> O00000Oo = new ArrayList<>();
    ArrayList<RecyclerView.O000OOo0> O00000o = new ArrayList<>();
    ArrayList<ArrayList<O000000o>> O00000o0 = new ArrayList<>();
    ArrayList<RecyclerView.O000OOo0> O00000oO = new ArrayList<>();
    ArrayList<RecyclerView.O000OOo0> O00000oo = new ArrayList<>();
    ArrayList<RecyclerView.O000OOo0> O0000O0o = new ArrayList<>();
    private ArrayList<O00000Oo> O0000o = new ArrayList<>();
    private ArrayList<RecyclerView.O000OOo0> O0000o0O = new ArrayList<>();
    private ArrayList<RecyclerView.O000OOo0> O0000o0o = new ArrayList<>();
    private ArrayList<O000000o> O0000oO0 = new ArrayList<>();

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public RecyclerView.O000OOo0 f18911O000000o;
        public int O00000Oo;
        public int O00000o;
        public int O00000o0;
        public int O00000oO;

        O00000Oo(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3, int i4) {
            this.f18911O000000o = o000OOo0;
            this.O00000Oo = i;
            this.O00000o0 = i2;
            this.O00000o = i3;
            this.O00000oO = i4;
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public RecyclerView.O000OOo0 f18910O000000o;
        public RecyclerView.O000OOo0 O00000Oo;
        public int O00000o;
        public int O00000o0;
        public int O00000oO;
        public int O00000oo;

        private O000000o(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O000OOo0 o000OOo02) {
            this.f18910O000000o = o000OOo0;
            this.O00000Oo = o000OOo02;
        }

        O000000o(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O000OOo0 o000OOo02, int i, int i2, int i3, int i4) {
            this(o000OOo0, o000OOo02);
            this.O00000o0 = i;
            this.O00000o = i2;
            this.O00000oO = i3;
            this.O00000oo = i4;
        }

        public final String toString() {
            return "ChangeInfo{oldHolder=" + this.f18910O000000o + ", newHolder=" + this.O00000Oo + ", fromX=" + this.O00000o0 + ", fromY=" + this.O00000o + ", toX=" + this.O00000oO + ", toY=" + this.O00000oo + '}';
        }
    }

    public final void O000000o() {
        long j;
        long j2;
        gsy.O000000o(3, "EditMenuItemAnimator", "runPendingAnimations: ");
        boolean z = !this.O0000o0O.isEmpty();
        boolean z2 = !this.O0000o.isEmpty();
        boolean z3 = !this.O0000oO0.isEmpty();
        boolean z4 = !this.O0000o0o.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.O000OOo0> it = this.O0000o0O.iterator();
            while (it.hasNext()) {
                final RecyclerView.O000OOo0 next = it.next();
                gsy.O000000o(3, "EditMenuItemAnimator", "animateRemoveImpl: ");
                final View view = next.itemView;
                final ViewPropertyAnimator animate = view.animate();
                this.O00000oo.add(next);
                animate.setDuration(this.O0000Oo).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                    /* class _m_j.hgp.AnonymousClass4 */

                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        animate.setListener(null);
                        view.setAlpha(1.0f);
                        hgp.this.O00000oo(next);
                        hgp.this.O00000oo.remove(next);
                        hgp.this.O00000o0();
                    }
                }).start();
            }
            this.O0000o0O.clear();
            if (z2) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.O0000o);
                this.O00000Oo.add(arrayList);
                this.O0000o.clear();
                AnonymousClass1 r6 = new Runnable() {
                    /* class _m_j.hgp.AnonymousClass1 */

                    public final void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            O00000Oo o00000Oo = (O00000Oo) it.next();
                            hgp hgp = hgp.this;
                            RecyclerView.O000OOo0 o000OOo0 = o00000Oo.f18911O000000o;
                            int i = o00000Oo.O00000Oo;
                            int i2 = o00000Oo.O00000o0;
                            int i3 = o00000Oo.O00000o;
                            int i4 = o00000Oo.O00000oO;
                            gsy.O000000o(3, "EditMenuItemAnimator", "animateMoveImpl: ");
                            View view = o000OOo0.itemView;
                            int i5 = i3 - i;
                            int i6 = i4 - i2;
                            if (i5 != 0) {
                                view.animate().translationX(0.0f);
                            }
                            if (i6 != 0) {
                                view.animate().translationY(0.0f);
                            }
                            ViewPropertyAnimator animate = view.animate();
                            hgp.O00000oO.add(o000OOo0);
                            animate.setDuration(hgp.O0000OoO).setListener(new AnimatorListenerAdapter(o000OOo0, i5, view, i6, animate) {
                                /* class _m_j.hgp.AnonymousClass6 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ RecyclerView.O000OOo0 f18907O000000o;
                                final /* synthetic */ int O00000Oo;
                                final /* synthetic */ int O00000o;
                                final /* synthetic */ View O00000o0;
                                final /* synthetic */ ViewPropertyAnimator O00000oO;

                                public final void onAnimationStart(Animator animator) {
                                }

                                {
                                    this.f18907O000000o = r2;
                                    this.O00000Oo = r3;
                                    this.O00000o0 = r4;
                                    this.O00000o = r5;
                                    this.O00000oO = r6;
                                }

                                public final void onAnimationCancel(Animator animator) {
                                    if (this.O00000Oo != 0) {
                                        this.O00000o0.setTranslationX(0.0f);
                                    }
                                    if (this.O00000o != 0) {
                                        this.O00000o0.setTranslationY(0.0f);
                                    }
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    this.O00000oO.setListener(null);
                                    hgp.this.O00000oo(this.f18907O000000o);
                                    hgp.this.O00000oO.remove(this.f18907O000000o);
                                    hgp.this.O00000o0();
                                }
                            }).start();
                        }
                        arrayList.clear();
                        hgp.this.O00000Oo.remove(arrayList);
                    }
                };
                if (z) {
                    cb.O000000o(((O00000Oo) arrayList.get(0)).f18911O000000o.itemView, r6, this.O0000Oo);
                } else {
                    r6.run();
                }
            }
            if (z3) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.O0000oO0);
                this.O00000o0.add(arrayList2);
                this.O0000oO0.clear();
                AnonymousClass2 r62 = new Runnable() {
                    /* class _m_j.hgp.AnonymousClass2 */

                    public final void run() {
                        View view;
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            O000000o o000000o = (O000000o) it.next();
                            hgp hgp = hgp.this;
                            gsy.O000000o(3, "EditMenuItemAnimator", "animateChangeImpl: ");
                            RecyclerView.O000OOo0 o000OOo0 = o000000o.f18910O000000o;
                            View view2 = null;
                            if (o000OOo0 == null) {
                                view = null;
                            } else {
                                view = o000OOo0.itemView;
                            }
                            RecyclerView.O000OOo0 o000OOo02 = o000000o.O00000Oo;
                            if (o000OOo02 != null) {
                                view2 = o000OOo02.itemView;
                            }
                            if (view != null) {
                                ViewPropertyAnimator duration = view.animate().setDuration(hgp.O0000Ooo);
                                hgp.O0000O0o.add(o000000o.f18910O000000o);
                                duration.translationX((float) (o000000o.O00000oO - o000000o.O00000o0));
                                duration.translationY((float) (o000000o.O00000oo - o000000o.O00000o));
                                duration.alpha(0.0f).setListener(new AnimatorListenerAdapter(o000000o, duration, view) {
                                    /* class _m_j.hgp.AnonymousClass7 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ O000000o f18908O000000o;
                                    final /* synthetic */ ViewPropertyAnimator O00000Oo;
                                    final /* synthetic */ View O00000o0;

                                    public final void onAnimationStart(Animator animator) {
                                    }

                                    {
                                        this.f18908O000000o = r2;
                                        this.O00000Oo = r3;
                                        this.O00000o0 = r4;
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        this.O00000Oo.setListener(null);
                                        this.O00000o0.setAlpha(1.0f);
                                        this.O00000o0.setTranslationX(0.0f);
                                        this.O00000o0.setTranslationY(0.0f);
                                        hgp.this.O00000oo(this.f18908O000000o.f18910O000000o);
                                        hgp.this.O0000O0o.remove(this.f18908O000000o.f18910O000000o);
                                        hgp.this.O00000o0();
                                    }
                                }).start();
                            }
                            if (view2 != null) {
                                ViewPropertyAnimator animate = view2.animate();
                                hgp.O0000O0o.add(o000000o.O00000Oo);
                                animate.translationX(0.0f).translationY(0.0f).setDuration(hgp.O0000Ooo).alpha(1.0f).setListener(new AnimatorListenerAdapter(o000000o, animate, view2) {
                                    /* class _m_j.hgp.AnonymousClass8 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ O000000o f18909O000000o;
                                    final /* synthetic */ ViewPropertyAnimator O00000Oo;
                                    final /* synthetic */ View O00000o0;

                                    public final void onAnimationStart(Animator animator) {
                                    }

                                    {
                                        this.f18909O000000o = r2;
                                        this.O00000Oo = r3;
                                        this.O00000o0 = r4;
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        this.O00000Oo.setListener(null);
                                        this.O00000o0.setAlpha(1.0f);
                                        this.O00000o0.setTranslationX(0.0f);
                                        this.O00000o0.setTranslationY(0.0f);
                                        hgp.this.O00000oo(this.f18909O000000o.O00000Oo);
                                        hgp.this.O0000O0o.remove(this.f18909O000000o.O00000Oo);
                                        hgp.this.O00000o0();
                                    }
                                }).start();
                            }
                        }
                        arrayList2.clear();
                        hgp.this.O00000o0.remove(arrayList2);
                    }
                };
                if (z) {
                    cb.O000000o(((O000000o) arrayList2.get(0)).f18910O000000o.itemView, r62, this.O0000Oo);
                } else {
                    r62.run();
                }
            }
            if (z4) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.O0000o0o);
                this.f18901O000000o.add(arrayList3);
                this.O0000o0o.clear();
                AnonymousClass3 r5 = new Runnable() {
                    /* class _m_j.hgp.AnonymousClass3 */

                    public final void run() {
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            RecyclerView.O000OOo0 o000OOo0 = (RecyclerView.O000OOo0) it.next();
                            hgp hgp = hgp.this;
                            gsy.O000000o(3, "EditMenuItemAnimator", "animateAddImpl: ");
                            View view = o000OOo0.itemView;
                            ViewPropertyAnimator animate = view.animate();
                            hgp.O00000o.add(o000OOo0);
                            animate.alpha(1.0f).setDuration(hgp.O0000Oo0).setListener(new AnimatorListenerAdapter(o000OOo0, view, animate) {
                                /* class _m_j.hgp.AnonymousClass5 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ RecyclerView.O000OOo0 f18906O000000o;
                                final /* synthetic */ View O00000Oo;
                                final /* synthetic */ ViewPropertyAnimator O00000o0;

                                public final void onAnimationStart(Animator animator) {
                                }

                                {
                                    this.f18906O000000o = r2;
                                    this.O00000Oo = r3;
                                    this.O00000o0 = r4;
                                }

                                public final void onAnimationCancel(Animator animator) {
                                    this.O00000Oo.setAlpha(1.0f);
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    this.O00000o0.setListener(null);
                                    hgp.this.O00000oo(this.f18906O000000o);
                                    hgp.this.O00000o.remove(this.f18906O000000o);
                                    hgp.this.O00000o0();
                                }
                            }).start();
                        }
                        arrayList3.clear();
                        hgp.this.f18901O000000o.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    long j3 = 0;
                    if (z) {
                        j = this.O0000Oo;
                    } else {
                        j = 0;
                    }
                    if (z2) {
                        j2 = this.O0000OoO;
                    } else {
                        j2 = 0;
                    }
                    if (z3) {
                        j3 = this.O0000Ooo;
                    }
                    cb.O000000o(((RecyclerView.O000OOo0) arrayList3.get(0)).itemView, r5, j + Math.max(j2, j3));
                    return;
                }
                r5.run();
            }
        }
    }

    public final boolean O000000o(RecyclerView.O000OOo0 o000OOo0) {
        gsy.O000000o(3, "EditMenuItemAnimator", "animateRemove: ");
        O0000OOo(o000OOo0);
        this.O0000o0O.add(o000OOo0);
        return true;
    }

    public final boolean O00000Oo(RecyclerView.O000OOo0 o000OOo0) {
        gsy.O000000o(3, "EditMenuItemAnimator", "animateAdd: ");
        O0000OOo(o000OOo0);
        o000OOo0.itemView.setAlpha(0.0f);
        this.O0000o0o.add(o000OOo0);
        return true;
    }

    public final boolean O000000o(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3, int i4) {
        gsy.O000000o(3, "EditMenuItemAnimator", "animateMove: ");
        View view = o000OOo0.itemView;
        int translationX = i + ((int) o000OOo0.itemView.getTranslationX());
        int translationY = i2 + ((int) o000OOo0.itemView.getTranslationY());
        O0000OOo(o000OOo0);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            O00000oo(o000OOo0);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX((float) (-i5));
        }
        if (i6 != 0) {
            view.setTranslationY((float) (-i6));
        }
        this.O0000o.add(new O00000Oo(o000OOo0, translationX, translationY, i3, i4));
        return true;
    }

    public final boolean O000000o(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O000OOo0 o000OOo02, int i, int i2, int i3, int i4) {
        gsy.O000000o(3, "EditMenuItemAnimator", "animateChange: ");
        if (o000OOo0 == o000OOo02) {
            return O000000o(o000OOo0, i, i2, i3, i4);
        }
        float translationX = o000OOo0.itemView.getTranslationX();
        float translationY = o000OOo0.itemView.getTranslationY();
        float alpha = o000OOo0.itemView.getAlpha();
        O0000OOo(o000OOo0);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        o000OOo0.itemView.setTranslationX(translationX);
        o000OOo0.itemView.setTranslationY(translationY);
        o000OOo0.itemView.setAlpha(alpha);
        if (o000OOo02 != null) {
            O0000OOo(o000OOo02);
            o000OOo02.itemView.setTranslationX((float) (-i5));
            o000OOo02.itemView.setTranslationY((float) (-i6));
            o000OOo02.itemView.setAlpha(0.0f);
        }
        this.O0000oO0.add(new O000000o(o000OOo0, o000OOo02, i, i2, i3, i4));
        return true;
    }

    private void O000000o(List<O000000o> list, RecyclerView.O000OOo0 o000OOo0) {
        gsy.O000000o(3, "EditMenuItemAnimator", "endChangeAnimation: ");
        for (int size = list.size() - 1; size >= 0; size--) {
            O000000o o000000o = list.get(size);
            if (O000000o(o000000o, o000OOo0) && o000000o.f18910O000000o == null && o000000o.O00000Oo == null) {
                list.remove(o000000o);
            }
        }
    }

    private void O000000o(O000000o o000000o) {
        gsy.O000000o(3, "EditMenuItemAnimator", "endChangeAnimationIfNecessary: ");
        if (o000000o.f18910O000000o != null) {
            O000000o(o000000o, o000000o.f18910O000000o);
        }
        if (o000000o.O00000Oo != null) {
            O000000o(o000000o, o000000o.O00000Oo);
        }
    }

    private boolean O000000o(O000000o o000000o, RecyclerView.O000OOo0 o000OOo0) {
        gsy.O000000o(3, "EditMenuItemAnimator", "endChangeAnimationIfNecessary: ");
        if (o000000o.O00000Oo == o000OOo0) {
            o000000o.O00000Oo = null;
        } else if (o000000o.f18910O000000o != o000OOo0) {
            return false;
        } else {
            o000000o.f18910O000000o = null;
        }
        o000OOo0.itemView.setAlpha(1.0f);
        o000OOo0.itemView.setTranslationX(0.0f);
        o000OOo0.itemView.setTranslationY(0.0f);
        O00000oo(o000OOo0);
        return true;
    }

    public final void O00000o0(RecyclerView.O000OOo0 o000OOo0) {
        gsy.O000000o(3, "EditMenuItemAnimator", "endAnimation: ");
        View view = o000OOo0.itemView;
        view.animate().cancel();
        int size = this.O0000o.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.O0000o.get(size).f18911O000000o == o000OOo0) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                O00000oo(o000OOo0);
                this.O0000o.remove(size);
            }
        }
        O000000o(this.O0000oO0, o000OOo0);
        if (this.O0000o0O.remove(o000OOo0)) {
            view.setAlpha(1.0f);
            O00000oo(o000OOo0);
        }
        if (this.O0000o0o.remove(o000OOo0)) {
            view.setAlpha(1.0f);
            O00000oo(o000OOo0);
        }
        for (int size2 = this.O00000o0.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.O00000o0.get(size2);
            O000000o(arrayList, o000OOo0);
            if (arrayList.isEmpty()) {
                this.O00000o0.remove(size2);
            }
        }
        for (int size3 = this.O00000Oo.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.O00000Oo.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((O00000Oo) arrayList2.get(size4)).f18911O000000o == o000OOo0) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    O00000oo(o000OOo0);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.O00000Oo.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f18901O000000o.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f18901O000000o.get(size5);
            if (arrayList3.remove(o000OOo0)) {
                view.setAlpha(1.0f);
                O00000oo(o000OOo0);
                if (arrayList3.isEmpty()) {
                    this.f18901O000000o.remove(size5);
                }
            }
        }
        this.O00000oo.remove(o000OOo0);
        this.O00000o.remove(o000OOo0);
        this.O0000O0o.remove(o000OOo0);
        this.O00000oO.remove(o000OOo0);
        O00000o0();
    }

    private void O0000OOo(RecyclerView.O000OOo0 o000OOo0) {
        if (O0000o0 == null) {
            O0000o0 = new ValueAnimator().getInterpolator();
        }
        o000OOo0.itemView.animate().setInterpolator(O0000o0);
        O00000o0(o000OOo0);
    }

    public final boolean O00000Oo() {
        return !this.O0000o0o.isEmpty() || !this.O0000oO0.isEmpty() || !this.O0000o.isEmpty() || !this.O0000o0O.isEmpty() || !this.O00000oO.isEmpty() || !this.O00000oo.isEmpty() || !this.O00000o.isEmpty() || !this.O0000O0o.isEmpty() || !this.O00000Oo.isEmpty() || !this.f18901O000000o.isEmpty() || !this.O00000o0.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        gsy.O000000o(3, "EditMenuItemAnimator", "dispatchFinishedWhenDone: ");
        if (!O00000Oo()) {
            O00000oO();
        }
    }

    public final void O00000o() {
        int size = this.O0000o.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            O00000Oo o00000Oo = this.O0000o.get(size);
            View view = o00000Oo.f18911O000000o.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            O00000oo(o00000Oo.f18911O000000o);
            this.O0000o.remove(size);
        }
        for (int size2 = this.O0000o0O.size() - 1; size2 >= 0; size2--) {
            O00000oo(this.O0000o0O.get(size2));
            this.O0000o0O.remove(size2);
        }
        int size3 = this.O0000o0o.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.O000OOo0 o000OOo0 = this.O0000o0o.get(size3);
            o000OOo0.itemView.setAlpha(1.0f);
            O00000oo(o000OOo0);
            this.O0000o0o.remove(size3);
        }
        for (int size4 = this.O0000oO0.size() - 1; size4 >= 0; size4--) {
            O000000o(this.O0000oO0.get(size4));
        }
        this.O0000oO0.clear();
        if (O00000Oo()) {
            for (int size5 = this.O00000Oo.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.O00000Oo.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    O00000Oo o00000Oo2 = (O00000Oo) arrayList.get(size6);
                    View view2 = o00000Oo2.f18911O000000o.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    O00000oo(o00000Oo2.f18911O000000o);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.O00000Oo.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f18901O000000o.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f18901O000000o.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.O000OOo0 o000OOo02 = (RecyclerView.O000OOo0) arrayList2.get(size8);
                    o000OOo02.itemView.setAlpha(1.0f);
                    O00000oo(o000OOo02);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f18901O000000o.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.O00000o0.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.O00000o0.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    O000000o((O000000o) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.O00000o0.remove(arrayList3);
                    }
                }
            }
            O000000o(this.O00000oo);
            O000000o(this.O00000oO);
            O000000o(this.O00000o);
            O000000o(this.O0000O0o);
            O00000oO();
        }
    }

    private static void O000000o(List<RecyclerView.O000OOo0> list) {
        gsy.O000000o(3, "EditMenuItemAnimator", "cancelAll: ");
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    public final boolean O000000o(RecyclerView.O000OOo0 o000OOo0, List<Object> list) {
        return !list.isEmpty() || super.O000000o(o000OOo0, list);
    }
}
