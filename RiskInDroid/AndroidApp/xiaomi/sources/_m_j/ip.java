package _m_j;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class ip {

    /* renamed from: O000000o  reason: collision with root package name */
    static ArrayList<ViewGroup> f1530O000000o = new ArrayList<>();
    private static Transition O00000Oo = new AutoTransition();
    private static ThreadLocal<WeakReference<o0O0OOO0<ViewGroup, ArrayList<Transition>>>> O00000o0 = new ThreadLocal<>();

    static o0O0OOO0<ViewGroup, ArrayList<Transition>> O000000o() {
        o0O0OOO0<ViewGroup, ArrayList<Transition>> o0o0ooo0;
        WeakReference weakReference = O00000o0.get();
        if (weakReference != null && (o0o0ooo0 = (o0O0OOO0) weakReference.get()) != null) {
            return o0o0ooo0;
        }
        o0O0OOO0<ViewGroup, ArrayList<Transition>> o0o0ooo02 = new o0O0OOO0<>();
        O00000o0.set(new WeakReference(o0o0ooo02));
        return o0o0ooo02;
    }

    static class O000000o implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* renamed from: O000000o  reason: collision with root package name */
        Transition f1531O000000o;
        ViewGroup O00000Oo;

        public final void onViewAttachedToWindow(View view) {
        }

        O000000o(Transition transition, ViewGroup viewGroup) {
            this.f1531O000000o = transition;
            this.O00000Oo = viewGroup;
        }

        private void O000000o() {
            this.O00000Oo.getViewTreeObserver().removeOnPreDrawListener(this);
            this.O00000Oo.removeOnAttachStateChangeListener(this);
        }

        public final void onViewDetachedFromWindow(View view) {
            O000000o();
            ip.f1530O000000o.remove(this.O00000Oo);
            ArrayList arrayList = ip.O000000o().get(this.O00000Oo);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).resume(this.O00000Oo);
                }
            }
            this.f1531O000000o.clearValues(true);
        }

        public final boolean onPreDraw() {
            O000000o();
            if (!ip.f1530O000000o.remove(this.O00000Oo)) {
                return true;
            }
            final o0O0OOO0<ViewGroup, ArrayList<Transition>> O000000o2 = ip.O000000o();
            ArrayList arrayList = O000000o2.get(this.O00000Oo);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                O000000o2.put(this.O00000Oo, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f1531O000000o);
            this.f1531O000000o.addListener(new io() {
                /* class _m_j.ip.O000000o.AnonymousClass1 */

                public final void onTransitionEnd(Transition transition) {
                    ((ArrayList) O000000o2.get(O000000o.this.O00000Oo)).remove(transition);
                    transition.removeListener(this);
                }
            });
            this.f1531O000000o.captureValues(this.O00000Oo, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).resume(this.O00000Oo);
                }
            }
            this.f1531O000000o.playTransition(this.O00000Oo);
            return true;
        }
    }

    public static void O000000o(ViewGroup viewGroup, Transition transition) {
        if (!f1530O000000o.contains(viewGroup) && cb.O000O0oO(viewGroup)) {
            f1530O000000o.add(viewGroup);
            if (transition == null) {
                transition = O00000Oo;
            }
            Transition clone = transition.clone();
            ArrayList arrayList = O000000o().get(viewGroup);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).pause(viewGroup);
                }
            }
            if (clone != null) {
                clone.captureValues(viewGroup, true);
            }
            il O000000o2 = il.O000000o(viewGroup);
            if (!(O000000o2 == null || il.O000000o(O000000o2.f1429O000000o) != O000000o2 || O000000o2.O00000Oo == null)) {
                O000000o2.O00000Oo.run();
            }
            viewGroup.setTag(R.id.transition_current_scene, null);
            if (clone != null && viewGroup != null) {
                O000000o o000000o = new O000000o(clone, viewGroup);
                viewGroup.addOnAttachStateChangeListener(o000000o);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(o000000o);
            }
        }
    }
}
