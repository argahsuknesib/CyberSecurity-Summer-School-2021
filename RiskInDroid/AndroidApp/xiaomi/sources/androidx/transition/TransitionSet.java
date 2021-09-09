package androidx.transition;

import _m_j.in;
import _m_j.io;
import _m_j.iq;
import _m_j.is;
import _m_j.it;
import _m_j.n;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class TransitionSet extends Transition {

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<Transition> f3019O000000o = new ArrayList<>();
    int O00000Oo;
    private boolean O00000o = true;
    boolean O00000o0 = false;
    private int O00000oO = 0;

    public TransitionSet() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int):int
     arg types: [android.content.res.TypedArray, android.content.res.XmlResourceParser, java.lang.String, int, int]
     candidates:
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, float):float
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme, java.lang.String, int):_m_j.i
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, boolean):boolean
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int):int */
    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, in.O0000Oo0);
        O000000o(n.O000000o(obtainStyledAttributes, (XmlPullParser) ((XmlResourceParser) attributeSet), "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    public final TransitionSet O000000o(int i) {
        if (i == 0) {
            this.O00000o = true;
        } else if (i == 1) {
            this.O00000o = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: ".concat(String.valueOf(i)));
        }
        return this;
    }

    public final TransitionSet O000000o(Transition transition) {
        O00000Oo(transition);
        if (this.mDuration >= 0) {
            transition.setDuration(this.mDuration);
        }
        if ((this.O00000oO & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.O00000oO & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.O00000oO & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.O00000oO & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    private void O00000Oo(Transition transition) {
        this.f3019O000000o.add(transition);
        transition.mParent = this;
    }

    public final Transition O00000Oo(int i) {
        if (i < 0 || i >= this.f3019O000000o.size()) {
            return null;
        }
        return this.f3019O000000o.get(i);
    }

    /* renamed from: O000000o */
    public final TransitionSet setDuration(long j) {
        ArrayList<Transition> arrayList;
        super.setDuration(j);
        if (this.mDuration >= 0 && (arrayList = this.f3019O000000o) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f3019O000000o.get(i).setDuration(j);
            }
        }
        return this;
    }

    /* renamed from: O000000o */
    public final TransitionSet setInterpolator(TimeInterpolator timeInterpolator) {
        this.O00000oO |= 1;
        ArrayList<Transition> arrayList = this.f3019O000000o;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f3019O000000o.get(i).setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    public Transition excludeTarget(View view, boolean z) {
        for (int i = 0; i < this.f3019O000000o.size(); i++) {
            this.f3019O000000o.get(i).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    public Transition excludeTarget(String str, boolean z) {
        for (int i = 0; i < this.f3019O000000o.size(); i++) {
            this.f3019O000000o.get(i).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    public Transition excludeTarget(int i, boolean z) {
        for (int i2 = 0; i2 < this.f3019O000000o.size(); i2++) {
            this.f3019O000000o.get(i2).excludeTarget(i, z);
        }
        return super.excludeTarget(i, z);
    }

    public Transition excludeTarget(Class<?> cls, boolean z) {
        for (int i = 0; i < this.f3019O000000o.size(); i++) {
            this.f3019O000000o.get(i).excludeTarget(cls, z);
        }
        return super.excludeTarget(cls, z);
    }

    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.O00000oO |= 4;
        if (this.f3019O000000o != null) {
            for (int i = 0; i < this.f3019O000000o.size(); i++) {
                this.f3019O000000o.get(i).setPathMotion(pathMotion);
            }
        }
    }

    static class O000000o extends io {

        /* renamed from: O000000o  reason: collision with root package name */
        TransitionSet f3021O000000o;

        O000000o(TransitionSet transitionSet) {
            this.f3021O000000o = transitionSet;
        }

        public final void onTransitionStart(Transition transition) {
            if (!this.f3021O000000o.O00000o0) {
                this.f3021O000000o.start();
                this.f3021O000000o.O00000o0 = true;
            }
        }

        public final void onTransitionEnd(Transition transition) {
            TransitionSet transitionSet = this.f3021O000000o;
            transitionSet.O00000Oo--;
            if (this.f3021O000000o.O00000Oo == 0) {
                TransitionSet transitionSet2 = this.f3021O000000o;
                transitionSet2.O00000o0 = false;
                transitionSet2.end();
            }
            transition.removeListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public void createAnimators(ViewGroup viewGroup, it itVar, it itVar2, ArrayList<is> arrayList, ArrayList<is> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.f3019O000000o.size();
        for (int i = 0; i < size; i++) {
            Transition transition = this.f3019O000000o.get(i);
            if (startDelay > 0 && (this.O00000o || i == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, itVar, itVar2, arrayList, arrayList2);
        }
    }

    /* access modifiers changed from: protected */
    public void runAnimators() {
        if (this.f3019O000000o.isEmpty()) {
            start();
            end();
            return;
        }
        O000000o o000000o = new O000000o(this);
        Iterator<Transition> it = this.f3019O000000o.iterator();
        while (it.hasNext()) {
            it.next().addListener(o000000o);
        }
        this.O00000Oo = this.f3019O000000o.size();
        if (!this.O00000o) {
            for (int i = 1; i < this.f3019O000000o.size(); i++) {
                final Transition transition = this.f3019O000000o.get(i);
                this.f3019O000000o.get(i - 1).addListener(new io() {
                    /* class androidx.transition.TransitionSet.AnonymousClass1 */

                    public final void onTransitionEnd(Transition transition) {
                        transition.runAnimators();
                        transition.removeListener(this);
                    }
                });
            }
            Transition transition2 = this.f3019O000000o.get(0);
            if (transition2 != null) {
                transition2.runAnimators();
                return;
            }
            return;
        }
        Iterator<Transition> it2 = this.f3019O000000o.iterator();
        while (it2.hasNext()) {
            it2.next().runAnimators();
        }
    }

    public void captureStartValues(is isVar) {
        if (isValidTarget(isVar.O00000Oo)) {
            Iterator<Transition> it = this.f3019O000000o.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(isVar.O00000Oo)) {
                    next.captureStartValues(isVar);
                    isVar.O00000o0.add(next);
                }
            }
        }
    }

    public void captureEndValues(is isVar) {
        if (isValidTarget(isVar.O00000Oo)) {
            Iterator<Transition> it = this.f3019O000000o.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(isVar.O00000Oo)) {
                    next.captureEndValues(isVar);
                    isVar.O00000o0.add(next);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void capturePropagationValues(is isVar) {
        super.capturePropagationValues(isVar);
        int size = this.f3019O000000o.size();
        for (int i = 0; i < size; i++) {
            this.f3019O000000o.get(i).capturePropagationValues(isVar);
        }
    }

    public void pause(View view) {
        super.pause(view);
        int size = this.f3019O000000o.size();
        for (int i = 0; i < size; i++) {
            this.f3019O000000o.get(i).pause(view);
        }
    }

    public void resume(View view) {
        super.resume(view);
        int size = this.f3019O000000o.size();
        for (int i = 0; i < size; i++) {
            this.f3019O000000o.get(i).resume(view);
        }
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        super.cancel();
        int size = this.f3019O000000o.size();
        for (int i = 0; i < size; i++) {
            this.f3019O000000o.get(i).cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.f3019O000000o.size();
        for (int i = 0; i < size; i++) {
            this.f3019O000000o.get(i).forceToEnd(viewGroup);
        }
    }

    /* access modifiers changed from: package-private */
    public void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.f3019O000000o.size();
        for (int i = 0; i < size; i++) {
            this.f3019O000000o.get(i).setCanRemoveViews(z);
        }
    }

    public void setPropagation(iq iqVar) {
        super.setPropagation(iqVar);
        this.O00000oO |= 2;
        int size = this.f3019O000000o.size();
        for (int i = 0; i < size; i++) {
            this.f3019O000000o.get(i).setPropagation(iqVar);
        }
    }

    public void setEpicenterCallback(Transition.O00000o0 o00000o0) {
        super.setEpicenterCallback(o00000o0);
        this.O00000oO |= 8;
        int size = this.f3019O000000o.size();
        for (int i = 0; i < size; i++) {
            this.f3019O000000o.get(i).setEpicenterCallback(o00000o0);
        }
    }

    /* access modifiers changed from: package-private */
    public String toString(String str) {
        String transition = super.toString(str);
        for (int i = 0; i < this.f3019O000000o.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(transition);
            sb.append("\n");
            sb.append(this.f3019O000000o.get(i).toString(str + "  "));
            transition = sb.toString();
        }
        return transition;
    }

    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.f3019O000000o = new ArrayList<>();
        int size = this.f3019O000000o.size();
        for (int i = 0; i < size; i++) {
            transitionSet.O00000Oo(this.f3019O000000o.get(i).clone());
        }
        return transitionSet;
    }

    /* access modifiers changed from: package-private */
    public /* synthetic */ Transition setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.f3019O000000o.size();
        for (int i = 0; i < size; i++) {
            this.f3019O000000o.get(i).setSceneRoot(viewGroup);
        }
        return this;
    }

    public /* bridge */ /* synthetic */ Transition removeListener(Transition.O00000o o00000o) {
        return (TransitionSet) super.removeListener(o00000o);
    }

    public /* bridge */ /* synthetic */ Transition addListener(Transition.O00000o o00000o) {
        return (TransitionSet) super.addListener(o00000o);
    }

    public /* synthetic */ Transition removeTarget(Class cls) {
        for (int i = 0; i < this.f3019O000000o.size(); i++) {
            this.f3019O000000o.get(i).removeTarget(cls);
        }
        return (TransitionSet) super.removeTarget(cls);
    }

    public /* synthetic */ Transition removeTarget(String str) {
        for (int i = 0; i < this.f3019O000000o.size(); i++) {
            this.f3019O000000o.get(i).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }

    public /* synthetic */ Transition removeTarget(int i) {
        for (int i2 = 0; i2 < this.f3019O000000o.size(); i2++) {
            this.f3019O000000o.get(i2).removeTarget(i);
        }
        return (TransitionSet) super.removeTarget(i);
    }

    public /* synthetic */ Transition removeTarget(View view) {
        for (int i = 0; i < this.f3019O000000o.size(); i++) {
            this.f3019O000000o.get(i).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    public /* synthetic */ Transition addTarget(Class cls) {
        for (int i = 0; i < this.f3019O000000o.size(); i++) {
            this.f3019O000000o.get(i).addTarget(cls);
        }
        return (TransitionSet) super.addTarget(cls);
    }

    public /* synthetic */ Transition addTarget(String str) {
        for (int i = 0; i < this.f3019O000000o.size(); i++) {
            this.f3019O000000o.get(i).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    public /* synthetic */ Transition addTarget(int i) {
        for (int i2 = 0; i2 < this.f3019O000000o.size(); i2++) {
            this.f3019O000000o.get(i2).addTarget(i);
        }
        return (TransitionSet) super.addTarget(i);
    }

    public /* synthetic */ Transition addTarget(View view) {
        for (int i = 0; i < this.f3019O000000o.size(); i++) {
            this.f3019O000000o.get(i).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    public /* bridge */ /* synthetic */ Transition setStartDelay(long j) {
        return (TransitionSet) super.setStartDelay(j);
    }
}
