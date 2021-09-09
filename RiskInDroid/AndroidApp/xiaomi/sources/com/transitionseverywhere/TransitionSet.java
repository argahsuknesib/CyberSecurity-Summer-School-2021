package com.transitionseverywhere;

import _m_j.drf;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class TransitionSet extends Transition {

    /* renamed from: O000000o  reason: collision with root package name */
    ArrayList<Transition> f5911O000000o = new ArrayList<>();
    boolean O00000Oo = false;
    private boolean O00000o0 = true;

    public TransitionSet() {
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.transitionOrdering});
        O000000o(obtainStyledAttributes.getInt(0, 0));
        obtainStyledAttributes.recycle();
    }

    public final TransitionSet O000000o(int i) {
        if (i == 0) {
            this.O00000o0 = true;
        } else if (i == 1) {
            this.O00000o0 = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: ".concat(String.valueOf(i)));
        }
        return this;
    }

    public final TransitionSet O000000o(Transition transition) {
        O00000Oo(transition);
        if (this.O00000oO >= 0) {
            transition.O000000o(this.O00000oO);
        }
        if (this.O00000oo != null) {
            transition.O000000o(this.O00000oo);
        }
        return this;
    }

    private void O00000Oo(Transition transition) {
        this.f5911O000000o.add(transition);
        transition.O0000oO0 = this;
    }

    /* access modifiers changed from: package-private */
    public final String O000000o(String str) {
        String O000000o2 = super.O000000o(str);
        for (int i = 0; i < this.f5911O000000o.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(O000000o2);
            sb.append("\n");
            sb.append(this.f5911O000000o.get(i).O000000o(str + "  "));
            O000000o2 = sb.toString();
        }
        return O000000o2;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000Oo */
    public TransitionSet clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.f5911O000000o = new ArrayList<>();
        int size = this.f5911O000000o.size();
        for (int i = 0; i < size; i++) {
            transitionSet.O00000Oo(this.f5911O000000o.get(i).clone());
        }
        return transitionSet;
    }

    public final /* synthetic */ Transition O000000o(drf drf) {
        super.O000000o(drf);
        int size = this.f5911O000000o.size();
        for (int i = 0; i < size; i++) {
            this.f5911O000000o.get(i).O000000o(drf);
        }
        return this;
    }

    public final /* synthetic */ Transition O000000o(TimeInterpolator timeInterpolator) {
        ArrayList<Transition> arrayList;
        super.O000000o(timeInterpolator);
        if (!(this.O00000oo == null || (arrayList = this.f5911O000000o) == null)) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f5911O000000o.get(i).O000000o(this.O00000oo);
            }
        }
        return this;
    }

    public final /* bridge */ /* synthetic */ Transition O00000Oo(long j) {
        return (TransitionSet) super.O00000Oo(j);
    }

    public final /* synthetic */ Transition O000000o(long j) {
        ArrayList<Transition> arrayList;
        super.O000000o(j);
        if (this.O00000oO >= 0 && (arrayList = this.f5911O000000o) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f5911O000000o.get(i).O000000o(j);
            }
        }
        return this;
    }
}
