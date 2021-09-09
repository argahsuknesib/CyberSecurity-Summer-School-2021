package com.transitionseverywhere;

import _m_j.drf;
import _m_j.drg;
import _m_j.o0O0OOO0;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.StringTokenizer;

@TargetApi(14)
public abstract class Transition implements Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final int[] f5910O000000o = {2, 1, 3, 4};
    private static final ThreadLocal<o0O0OOO0<Animator, Object>> O000O0o0 = new ThreadLocal<>();
    private String O00000Oo = getClass().getName();
    long O00000o = -1;
    private drg O00000o0 = new drg();
    long O00000oO = -1;
    TimeInterpolator O00000oo = null;
    ArrayList<Integer> O0000O0o = new ArrayList<>();
    ArrayList<View> O0000OOo = new ArrayList<>();
    ArrayList<Class> O0000Oo = null;
    ArrayList<String> O0000Oo0 = null;
    ArrayList<Integer> O0000OoO = null;
    ArrayList<View> O0000Ooo = null;
    ArrayList<Class> O0000o = null;
    ArrayList<String> O0000o0 = null;
    ArrayList<Class> O0000o00 = null;
    ArrayList<Integer> O0000o0O = null;
    ArrayList<View> O0000o0o = null;
    int[] O0000oO = f5910O000000o;
    TransitionSet O0000oO0 = null;
    ArrayList<Object> O0000oOO;
    ArrayList<Object> O0000oOo;
    boolean O0000oo = false;
    ViewGroup O0000oo0 = null;
    public ArrayList<Animator> O0000ooO = new ArrayList<>();
    int O0000ooo = 0;
    ArrayList<Animator> O000O00o = new ArrayList<>();
    drf O000O0OO;
    PathMotion O000O0Oo = PathMotion.f5907O000000o;
    private boolean O000O0o = false;
    private drg O00oOoOo = new drg();
    boolean O00oOooO = false;
    ArrayList<Object> O00oOooo = null;

    public Transition() {
    }

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842960, 16843073, 16843160, R.attr.autoTransition, R.attr.constraintSetEnd, R.attr.constraintSetStart, R.attr.duration, R.attr.interpolator, R.attr.layoutDuringTransition, R.attr.matchOrder, R.attr.motionInterpolator, R.attr.pathMotionArc, R.attr.staggered, R.attr.startDelay, R.attr.transitionDisable, R.attr.transitionFlags});
        long j = (long) obtainStyledAttributes.getInt(6, -1);
        if (j >= 0) {
            O000000o(j);
        } else {
            long j2 = (long) obtainStyledAttributes.getInt(2, -1);
            if (j2 >= 0) {
                O000000o(j2);
            }
        }
        long j3 = (long) obtainStyledAttributes.getInt(13, -1);
        if (j3 > 0) {
            O00000Oo(j3);
        }
        int resourceId = obtainStyledAttributes.getResourceId(7, 0);
        if (resourceId > 0) {
            O000000o(AnimationUtils.loadInterpolator(context, resourceId));
        } else {
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            if (resourceId2 > 0) {
                O000000o(AnimationUtils.loadInterpolator(context, resourceId2));
            }
        }
        String string = obtainStyledAttributes.getString(9);
        if (string != null) {
            O000000o(O00000Oo(string));
        }
        obtainStyledAttributes.recycle();
    }

    private static int[] O00000Oo(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i] = 3;
            } else if ("instance".equalsIgnoreCase(trim)) {
                iArr[i] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i] = 2;
            } else if ("viewName".equalsIgnoreCase(trim)) {
                iArr[i] = 2;
            } else if ("itemId".equalsIgnoreCase(trim)) {
                iArr[i] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                i--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i++;
        }
        return iArr;
    }

    public Transition O000000o(long j) {
        this.O00000oO = j;
        return this;
    }

    public Transition O00000Oo(long j) {
        this.O00000o = j;
        return this;
    }

    public Transition O000000o(TimeInterpolator timeInterpolator) {
        this.O00000oo = timeInterpolator;
        return this;
    }

    private Transition O000000o(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.O0000oO = f5910O000000o;
        } else {
            int i = 0;
            while (i < iArr.length) {
                int i2 = iArr[i];
                if (!(i2 > 0 && i2 <= 4)) {
                    throw new IllegalArgumentException("matches contains invalid value");
                } else if (!O000000o(iArr, i)) {
                    i++;
                } else {
                    throw new IllegalArgumentException("matches contains a duplicate value");
                }
            }
            this.O0000oO = (int[]) iArr.clone();
        }
        return this;
    }

    private static boolean O000000o(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    public Transition O000000o(drf drf) {
        this.O000O0OO = drf;
        return this;
    }

    public String toString() {
        return O000000o("");
    }

    /* renamed from: O000000o */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            try {
                transition.O000O00o = new ArrayList<>();
                transition.O00000o0 = new drg();
                transition.O00oOoOo = new drg();
                transition.O0000oOO = null;
                transition.O0000oOo = null;
                return transition;
            } catch (CloneNotSupportedException unused) {
                return transition;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String O000000o(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.O00000oO != -1) {
            str2 = str2 + "dur(" + this.O00000oO + ") ";
        }
        if (this.O00000o != -1) {
            str2 = str2 + "dly(" + this.O00000o + ") ";
        }
        if (this.O00000oo != null) {
            str2 = str2 + "interp(" + this.O00000oo + ") ";
        }
        if (this.O0000O0o.size() <= 0 && this.O0000OOo.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.O0000O0o.size() > 0) {
            String str4 = str3;
            for (int i = 0; i < this.O0000O0o.size(); i++) {
                if (i > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.O0000O0o.get(i);
            }
            str3 = str4;
        }
        if (this.O0000OOo.size() > 0) {
            for (int i2 = 0; i2 < this.O0000OOo.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.O0000OOo.get(i2);
            }
        }
        return str3 + ")";
    }
}
