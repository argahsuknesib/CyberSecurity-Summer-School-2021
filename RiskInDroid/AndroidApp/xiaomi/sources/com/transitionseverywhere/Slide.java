package com.transitionseverywhere;

import _m_j.dre;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.xiaomi.smarthome.R;

@TargetApi(14)
public class Slide extends Visibility {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final TimeInterpolator f5909O000000o = new DecelerateInterpolator();
    protected static final TimeInterpolator O00000Oo = new AccelerateInterpolator();
    private static final O000000o O000O0o = new O00000Oo() {
        /* class com.transitionseverywhere.Slide.AnonymousClass1 */
    };
    private static final O000000o O000O0oO = new O00000Oo() {
        /* class com.transitionseverywhere.Slide.AnonymousClass2 */
    };
    private static final O000000o O000O0oo = new O00000o0() {
        /* class com.transitionseverywhere.Slide.AnonymousClass3 */
    };
    private static final O000000o O000OO = new O00000o0() {
        /* class com.transitionseverywhere.Slide.AnonymousClass6 */
    };
    private static final O000000o O000OO00 = new O00000Oo() {
        /* class com.transitionseverywhere.Slide.AnonymousClass4 */
    };
    private static final O000000o O000OO0o = new O00000Oo() {
        /* class com.transitionseverywhere.Slide.AnonymousClass5 */
    };
    protected O000000o O00000o0 = O000OO;
    private int O000O0o0 = 80;

    public interface O000000o {
    }

    public static abstract class O00000Oo implements O000000o {
        protected O00000Oo() {
        }
    }

    public static abstract class O00000o0 implements O000000o {
        protected O00000o0() {
        }
    }

    public Slide() {
        O00000Oo(80);
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.slideEdge});
        int i = obtainStyledAttributes.getInt(0, 80);
        obtainStyledAttributes.recycle();
        O00000Oo(i);
    }

    @SuppressLint({"RtlHardcoded"})
    private void O00000Oo(int i) {
        if (i == 3) {
            this.O00000o0 = O000O0o;
        } else if (i == 5) {
            this.O00000o0 = O000OO00;
        } else if (i == 48) {
            this.O00000o0 = O000O0oo;
        } else if (i == 80) {
            this.O00000o0 = O000OO;
        } else if (i == 8388611) {
            this.O00000o0 = O000O0oO;
        } else if (i == 8388613) {
            this.O00000o0 = O000OO0o;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.O000O0o0 = i;
        dre dre = new dre();
        dre.f14868O000000o = i;
        O000000o(dre);
    }
}
