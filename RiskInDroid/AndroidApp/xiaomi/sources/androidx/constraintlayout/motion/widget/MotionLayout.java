package androidx.constraintlayout.motion.widget;

import _m_j.bu;
import _m_j.o0Oo0000;
import _m_j.oO00000o;
import _m_j.oO0000Oo;
import _m_j.oO000o00;
import _m_j.oO00O00o;
import _m_j.oO00O0Oo;
import _m_j.oO0O000o;
import _m_j.oO0O00Oo;
import _m_j.oO0O00o0;
import _m_j.oO0O0o0o;
import _m_j.oO0Oo0O0;
import _m_j.oO0Ooo00;
import _m_j.oOO0OOo0;
import _m_j.oOo0000O;
import _m_j.oOo000o0;
import _m_j.oOo00OO0;
import _m_j.oOo00ooO;
import _m_j.oOo0oooO;
import _m_j.ooooO0O0;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MotionLayout extends ConstraintLayout implements bu {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f2778O000000o;
    oO00O0Oo O00000Oo;
    public float O00000o = 0.0f;
    public Interpolator O00000o0;
    public int O00000oO = -1;
    public int O00000oo = -1;
    public int O0000O0o = -1;
    public int O0000OOo = 0;
    public boolean O0000Oo = true;
    public int O0000Oo0 = 0;
    public HashMap<View, oO0Oo0O0> O0000OoO = new HashMap<>();
    public float O0000Ooo = 1.0f;
    boolean O0000o = false;
    public float O0000o0 = 0.0f;
    float O0000o00 = 0.0f;
    public float O0000o0O = 0.0f;
    boolean O0000o0o = false;
    O00000Oo O0000oO;
    public int O0000oO0 = 0;
    boolean O0000oOO = true;
    int O0000oOo;
    int O0000oo;
    int O0000oo0;
    int O0000ooO;
    boolean O0000ooo = false;
    long O000O00o;
    float O000O0OO;
    public ArrayList<O0000Oo0> O000O0Oo = null;
    int O000O0o;
    protected boolean O000O0o0 = false;
    int O000O0oO;
    int O000O0oo;
    int O000OO;
    int O000OO00;
    int O000OO0o;
    float O000OOOo;
    O00000o0 O000OOo = new O00000o0();
    TransitionState O000OOo0 = TransitionState.UNDEFINED;
    ArrayList<Integer> O000OOoO = new ArrayList<>();
    private long O000OOoo = 0;
    private boolean O000Oo0;
    private long O000Oo00;
    private O0000Oo0 O000Oo0O;
    private float O000Oo0o;
    private o0Oo0000 O000OoO = new o0Oo0000();
    private float O000OoO0;
    private O000000o O000OoOO = new O000000o();
    private oO0000Oo O000OoOo;
    private ArrayList<MotionHelper> O000Ooo = null;
    private boolean O000Ooo0 = false;
    private ArrayList<MotionHelper> O000OooO = null;
    private int O000Oooo = 0;
    private oO0Ooo00 O000o0 = new oO0Ooo00();
    private float O000o00 = 0.0f;
    private long O000o000 = -1;
    private int O000o00O = 0;
    private float O000o00o = 0.0f;
    private O0000OOo O000o0O;
    private boolean O000o0O0 = false;
    private boolean O000o0OO = false;
    private RectF O000o0Oo = new RectF();
    private View O000o0o0 = null;
    private boolean O00O0Oo = false;
    boolean O00oOoOo = false;
    float O00oOooO;
    float O00oOooo;

    public interface O00000o {
        void O000000o();

        void O000000o(MotionEvent motionEvent);

        void O00000Oo();

        float O00000o();

        float O00000o0();
    }

    public interface O0000Oo0 {
    }

    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
    }

    public MotionLayout(Context context) {
        super(context);
        O000000o((AttributeSet) null);
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(attributeSet);
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet);
    }

    /* access modifiers changed from: protected */
    public long getNanoTime() {
        return System.nanoTime();
    }

    public static O00000o O000000o() {
        return O0000O0o.O00000oO();
    }

    public void setState(TransitionState transitionState) {
        if (transitionState != TransitionState.FINISHED || this.O00000oo != -1) {
            TransitionState transitionState2 = this.O000OOo0;
            this.O000OOo0 = transitionState;
            if (transitionState2 == TransitionState.MOVING && transitionState == TransitionState.MOVING) {
                O00000oo();
            }
            int i = AnonymousClass2.f2780O000000o[transitionState2.ordinal()];
            if (i == 1 || i == 2) {
                if (transitionState == TransitionState.MOVING) {
                    O00000oo();
                }
                if (transitionState == TransitionState.FINISHED) {
                    O0000O0o();
                }
            } else if (i == 3 && transitionState == TransitionState.FINISHED) {
                O0000O0o();
            }
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f2780O000000o = new int[TransitionState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f2780O000000o[TransitionState.UNDEFINED.ordinal()] = 1;
            f2780O000000o[TransitionState.SETUP.ordinal()] = 2;
            f2780O000000o[TransitionState.MOVING.ordinal()] = 3;
            try {
                f2780O000000o[TransitionState.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static class O0000O0o implements O00000o {
        private static O0000O0o O00000Oo = new O0000O0o();

        /* renamed from: O000000o  reason: collision with root package name */
        VelocityTracker f2784O000000o;

        private O0000O0o() {
        }

        public static O0000O0o O00000oO() {
            O00000Oo.f2784O000000o = VelocityTracker.obtain();
            return O00000Oo;
        }

        public final void O000000o() {
            this.f2784O000000o.recycle();
            this.f2784O000000o = null;
        }

        public final void O000000o(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f2784O000000o;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        public final void O00000Oo() {
            this.f2784O000000o.computeCurrentVelocity(1000);
        }

        public final float O00000o0() {
            return this.f2784O000000o.getXVelocity();
        }

        public final float O00000o() {
            return this.f2784O000000o.getYVelocity();
        }
    }

    public final void O000000o(int i, int i2) {
        if (!isAttachedToWindow()) {
            if (this.O000o0O == null) {
                this.O000o0O = new O0000OOo();
            }
            O0000OOo o0000OOo = this.O000o0O;
            o0000OOo.O00000o0 = i;
            o0000OOo.O00000o = i2;
            return;
        }
        oO00O0Oo oo00o0oo = this.O00000Oo;
        if (oo00o0oo != null) {
            this.O00000oO = i;
            this.O0000O0o = i2;
            oo00o0oo.O000000o(i, i2);
            this.O000OOo.O000000o(this.O00000Oo.O000000o(i), this.O00000Oo.O000000o(i2));
            O0000Oo0();
            this.O0000o0 = 0.0f;
            O000000o(0.0f);
        }
    }

    public void setTransition(int i) {
        oO00O0Oo.O000000o o000000o;
        oO00O0Oo oo00o0oo = this.O00000Oo;
        if (oo00o0oo != null) {
            Iterator<oO00O0Oo.O000000o> it = oo00o0oo.O00000o.iterator();
            while (true) {
                if (!it.hasNext()) {
                    o000000o = null;
                    break;
                }
                o000000o = it.next();
                if (o000000o.f2272O000000o == i) {
                    break;
                }
            }
            this.O00000oO = o000000o.O00000o;
            this.O0000O0o = o000000o.O00000o0;
            if (!isAttachedToWindow()) {
                if (this.O000o0O == null) {
                    this.O000o0O = new O0000OOo();
                }
                O0000OOo o0000OOo = this.O000o0O;
                o0000OOo.O00000o0 = this.O00000oO;
                o0000OOo.O00000o = this.O0000O0o;
                return;
            }
            float f = Float.NaN;
            int i2 = this.O00000oo;
            if (i2 == this.O00000oO) {
                f = 0.0f;
            } else if (i2 == this.O0000O0o) {
                f = 1.0f;
            }
            this.O00000Oo.O000000o(o000000o);
            this.O000OOo.O000000o(this.O00000Oo.O000000o(this.O00000oO), this.O00000Oo.O000000o(this.O0000O0o));
            O0000Oo0();
            this.O0000o0 = Float.isNaN(f) ? 0.0f : f;
            if (Float.isNaN(f)) {
                Log.v("MotionLayout", oO00000o.O000000o() + " transitionToStart ");
                O000000o(0.0f);
                return;
            }
            setProgress(f);
        }
    }

    public void setTransition(oO00O0Oo.O000000o o000000o) {
        this.O00000Oo.O000000o(o000000o);
        setState(TransitionState.SETUP);
        if (this.O00000oo == this.O00000Oo.O00000o0()) {
            this.O0000o0 = 1.0f;
            this.O0000o00 = 1.0f;
            this.O0000o0O = 1.0f;
        } else {
            this.O0000o0 = 0.0f;
            this.O0000o00 = 0.0f;
            this.O0000o0O = 0.0f;
        }
        boolean z = true;
        if ((o000000o.O0000oO0 & 1) == 0) {
            z = false;
        }
        this.O000Oo00 = z ? -1 : getNanoTime();
        int O00000Oo2 = this.O00000Oo.O00000Oo();
        int O00000o02 = this.O00000Oo.O00000o0();
        if (O00000Oo2 != this.O00000oO || O00000o02 != this.O0000O0o) {
            this.O00000oO = O00000Oo2;
            this.O0000O0o = O00000o02;
            this.O00000Oo.O000000o(this.O00000oO, this.O0000O0o);
            this.O000OOo.O000000o(this.O00000Oo.O000000o(this.O00000oO), this.O00000Oo.O000000o(this.O0000O0o));
            this.O000OOo.O000000o(this.O00000oO, this.O0000O0o);
            this.O000OOo.O000000o();
            O0000Oo0();
        }
    }

    public void loadLayoutDescription(int i) {
        if (i != 0) {
            try {
                this.O00000Oo = new oO00O0Oo(getContext(), this, i);
                if (Build.VERSION.SDK_INT < 19 || isAttachedToWindow()) {
                    this.O00000Oo.O000000o(this);
                    this.O000OOo.O000000o(this.O00000Oo.O000000o(this.O00000oO), this.O00000Oo.O000000o(this.O0000O0o));
                    O0000Oo0();
                    this.O00000Oo.O000000o(isRtl());
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e);
            }
        } else {
            this.O00000Oo = null;
        }
    }

    public boolean isAttachedToWindow() {
        if (Build.VERSION.SDK_INT >= 19) {
            return super.isAttachedToWindow();
        }
        return getWindowToken() != null;
    }

    public void setState(int i, int i2, int i3) {
        setState(TransitionState.SETUP);
        this.O00000oo = i;
        this.O00000oO = -1;
        this.O0000O0o = -1;
        if (this.mConstraintLayoutSpec != null) {
            this.mConstraintLayoutSpec.O000000o(i, (float) i2, (float) i3);
            return;
        }
        oO00O0Oo oo00o0oo = this.O00000Oo;
        if (oo00o0oo != null) {
            oo00o0oo.O000000o(i).O00000o0(this);
        }
    }

    public void setInterpolatedProgress(float f) {
        if (this.O00000Oo != null) {
            setState(TransitionState.MOVING);
            Interpolator O00000o2 = this.O00000Oo.O00000o();
            if (O00000o2 != null) {
                setProgress(O00000o2.getInterpolation(f));
                return;
            }
        }
        setProgress(f);
    }

    public final void O000000o(float f, float f2) {
        if (!isAttachedToWindow()) {
            if (this.O000o0O == null) {
                this.O000o0O = new O0000OOo();
            }
            O0000OOo o0000OOo = this.O000o0O;
            o0000OOo.f2785O000000o = f;
            o0000OOo.O00000Oo = f2;
            return;
        }
        setProgress(f);
        setState(TransitionState.MOVING);
        this.O00000o = f2;
        O000000o(1.0f);
    }

    class O0000OOo {

        /* renamed from: O000000o  reason: collision with root package name */
        float f2785O000000o = Float.NaN;
        float O00000Oo = Float.NaN;
        int O00000o = -1;
        int O00000o0 = -1;
        final String O00000oO = "motion.progress";
        final String O00000oo = "motion.velocity";
        final String O0000O0o = "motion.StartState";
        final String O0000OOo = "motion.EndState";

        O0000OOo() {
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            if (!(this.O00000o0 == -1 && this.O00000o == -1)) {
                int i = this.O00000o0;
                if (i == -1) {
                    MotionLayout.this.O000000o(this.O00000o);
                } else {
                    int i2 = this.O00000o;
                    if (i2 == -1) {
                        MotionLayout.this.setState(i, -1, -1);
                    } else {
                        MotionLayout.this.O000000o(i, i2);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (!Float.isNaN(this.O00000Oo)) {
                MotionLayout.this.O000000o(this.f2785O000000o, this.O00000Oo);
                this.f2785O000000o = Float.NaN;
                this.O00000Oo = Float.NaN;
                this.O00000o0 = -1;
                this.O00000o = -1;
            } else if (!Float.isNaN(this.f2785O000000o)) {
                MotionLayout.this.setProgress(this.f2785O000000o);
            }
        }
    }

    public void setTransitionState(Bundle bundle) {
        if (this.O000o0O == null) {
            this.O000o0O = new O0000OOo();
        }
        O0000OOo o0000OOo = this.O000o0O;
        o0000OOo.f2785O000000o = bundle.getFloat("motion.progress");
        o0000OOo.O00000Oo = bundle.getFloat("motion.velocity");
        o0000OOo.O00000o0 = bundle.getInt("motion.StartState");
        o0000OOo.O00000o = bundle.getInt("motion.EndState");
        if (isAttachedToWindow()) {
            this.O000o0O.O000000o();
        }
    }

    public Bundle getTransitionState() {
        if (this.O000o0O == null) {
            this.O000o0O = new O0000OOo();
        }
        O0000OOo o0000OOo = this.O000o0O;
        o0000OOo.O00000o = MotionLayout.this.O0000O0o;
        o0000OOo.O00000o0 = MotionLayout.this.O00000oO;
        o0000OOo.O00000Oo = MotionLayout.this.getVelocity();
        o0000OOo.f2785O000000o = MotionLayout.this.getProgress();
        O0000OOo o0000OOo2 = this.O000o0O;
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", o0000OOo2.f2785O000000o);
        bundle.putFloat("motion.velocity", o0000OOo2.O00000Oo);
        bundle.putInt("motion.StartState", o0000OOo2.O00000o0);
        bundle.putInt("motion.EndState", o0000OOo2.O00000o);
        return bundle;
    }

    public void setProgress(float f) {
        if (!isAttachedToWindow()) {
            if (this.O000o0O == null) {
                this.O000o0O = new O0000OOo();
            }
            this.O000o0O.f2785O000000o = f;
            return;
        }
        if (f <= 0.0f) {
            this.O00000oo = this.O00000oO;
            if (this.O0000o0 == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f >= 1.0f) {
            this.O00000oo = this.O0000O0o;
            if (this.O0000o0 == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.O00000oo = -1;
            setState(TransitionState.MOVING);
        }
        if (this.O00000Oo != null) {
            this.O000Oo0 = true;
            this.O0000o0O = f;
            this.O0000o00 = f;
            this.O000Oo00 = -1;
            this.O000OOoo = -1;
            this.O00000o0 = null;
            this.O0000o0o = true;
            invalidate();
        }
    }

    public final void O00000Oo() {
        int childCount = getChildCount();
        this.O000OOo.O00000Oo();
        boolean z = true;
        this.O0000o0o = true;
        int width = getWidth();
        int height = getHeight();
        oO00O0Oo oo00o0oo = this.O00000Oo;
        int i = oo00o0oo.O00000o0 != null ? oo00o0oo.O00000o0.O0000o0o : -1;
        int i2 = 0;
        if (i != -1) {
            for (int i3 = 0; i3 < childCount; i3++) {
                oO0Oo0O0 oo0oo0o0 = this.O0000OoO.get(getChildAt(i3));
                if (oo0oo0o0 != null) {
                    oo0oo0o0.O0000oO = i;
                }
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            oO0Oo0O0 oo0oo0o02 = this.O0000OoO.get(getChildAt(i4));
            if (oo0oo0o02 != null) {
                this.O00000Oo.O000000o(oo0oo0o02);
                oo0oo0o02.O000000o(width, height, getNanoTime());
            }
        }
        float O00000oo2 = this.O00000Oo.O00000oo();
        if (O00000oo2 != 0.0f) {
            boolean z2 = ((double) O00000oo2) < 0.0d;
            float abs = Math.abs(O00000oo2);
            float f = -3.4028235E38f;
            float f2 = Float.MAX_VALUE;
            int i5 = 0;
            float f3 = Float.MAX_VALUE;
            float f4 = -3.4028235E38f;
            while (true) {
                if (i5 >= childCount) {
                    z = false;
                    break;
                }
                oO0Oo0O0 oo0oo0o03 = this.O0000OoO.get(getChildAt(i5));
                if (!Float.isNaN(oo0oo0o03.O0000Oo0)) {
                    break;
                }
                float f5 = oo0oo0o03.O00000oO.O00000oo;
                float f6 = oo0oo0o03.O00000oO.O0000O0o;
                float f7 = z2 ? f6 - f5 : f6 + f5;
                f3 = Math.min(f3, f7);
                f4 = Math.max(f4, f7);
                i5++;
            }
            if (z) {
                for (int i6 = 0; i6 < childCount; i6++) {
                    oO0Oo0O0 oo0oo0o04 = this.O0000OoO.get(getChildAt(i6));
                    if (!Float.isNaN(oo0oo0o04.O0000Oo0)) {
                        f2 = Math.min(f2, oo0oo0o04.O0000Oo0);
                        f = Math.max(f, oo0oo0o04.O0000Oo0);
                    }
                }
                while (i2 < childCount) {
                    oO0Oo0O0 oo0oo0o05 = this.O0000OoO.get(getChildAt(i2));
                    if (!Float.isNaN(oo0oo0o05.O0000Oo0)) {
                        oo0oo0o05.O0000OoO = 1.0f / (1.0f - abs);
                        if (z2) {
                            oo0oo0o05.O0000Oo = abs - (((f - oo0oo0o05.O0000Oo0) / (f - f2)) * abs);
                        } else {
                            oo0oo0o05.O0000Oo = abs - (((oo0oo0o05.O0000Oo0 - f2) * abs) / (f - f2));
                        }
                    }
                    i2++;
                }
                return;
            }
            while (i2 < childCount) {
                oO0Oo0O0 oo0oo0o06 = this.O0000OoO.get(getChildAt(i2));
                float f8 = oo0oo0o06.O00000oO.O00000oo;
                float f9 = oo0oo0o06.O00000oO.O0000O0o;
                float f10 = z2 ? f9 - f8 : f9 + f8;
                oo0oo0o06.O0000OoO = 1.0f / (1.0f - abs);
                oo0oo0o06.O0000Oo = abs - (((f10 - f3) * abs) / (f4 - f3));
                i2++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        if ((r13 + ((r15 * r6) - (((r2 * r6) * r6) / 2.0f))) > 1.0f) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        if ((r13 + ((r15 * r1) + (((r2 * r1) * r1) / 2.0f))) < 0.0f) goto L_0x006a;
     */
    public final void O000000o(int i, float f, float f2) {
        if (this.O00000Oo != null && this.O0000o0 != f) {
            boolean z = true;
            this.O00O0Oo = true;
            this.O000OOoo = getNanoTime();
            this.O0000Ooo = ((float) this.O00000Oo.O00000oO()) / 1000.0f;
            this.O0000o0O = f;
            this.O0000o0o = true;
            if (i == 0 || i == 1 || i == 2) {
                if (i == 1) {
                    f = 0.0f;
                } else if (i == 2) {
                    f = 1.0f;
                }
                this.O000OoO.O000000o(this.O0000o0, f, f2, this.O0000Ooo, this.O00000Oo.O0000O0o(), this.O00000Oo.O0000OOo());
                int i2 = this.O00000oo;
                this.O0000o0O = f;
                this.O00000oo = i2;
                this.O00000o0 = this.O000OoO;
            } else if (i != 3) {
                if (i == 4) {
                    this.O000OoOO.O000000o(f2, this.O0000o0, this.O00000Oo.O0000O0o());
                    this.O00000o0 = this.O000OoOO;
                } else if (i == 5) {
                    float f3 = this.O0000o0;
                    float O0000O0o2 = this.O00000Oo.O0000O0o();
                    if (f2 > 0.0f) {
                        float f4 = f2 / O0000O0o2;
                    } else {
                        float f5 = (-f2) / O0000O0o2;
                    }
                    z = false;
                    if (z) {
                        this.O000OoOO.O000000o(f2, this.O0000o0, this.O00000Oo.O0000O0o());
                        this.O00000o0 = this.O000OoOO;
                    } else {
                        this.O000OoO.O000000o(this.O0000o0, f, f2, this.O0000Ooo, this.O00000Oo.O0000O0o(), this.O00000Oo.O0000OOo());
                        this.O00000o = 0.0f;
                        int i3 = this.O00000oo;
                        this.O0000o0O = f;
                        this.O00000oo = i3;
                        this.O00000o0 = this.O000OoO;
                    }
                }
            }
            this.O000Oo0 = false;
            this.O000OOoo = getNanoTime();
            invalidate();
        }
    }

    class O000000o extends oO0O0o0o {

        /* renamed from: O000000o  reason: collision with root package name */
        float f2781O000000o = 0.0f;
        float O00000Oo = 0.0f;
        float O00000o0;

        O000000o() {
        }

        public final void O000000o(float f, float f2, float f3) {
            this.f2781O000000o = f;
            this.O00000Oo = f2;
            this.O00000o0 = f3;
        }

        public final float getInterpolation(float f) {
            float f2;
            float f3;
            float f4 = this.f2781O000000o;
            if (f4 > 0.0f) {
                float f5 = this.O00000o0;
                if (f4 / f5 < f) {
                    f = f4 / f5;
                }
                MotionLayout motionLayout = MotionLayout.this;
                float f6 = this.f2781O000000o;
                float f7 = this.O00000o0;
                motionLayout.O00000o = f6 - (f7 * f);
                f2 = (f6 * f) - (((f7 * f) * f) / 2.0f);
                f3 = this.O00000Oo;
            } else {
                float f8 = this.O00000o0;
                if ((-f4) / f8 < f) {
                    f = (-f4) / f8;
                }
                MotionLayout motionLayout2 = MotionLayout.this;
                float f9 = this.f2781O000000o;
                float f10 = this.O00000o0;
                motionLayout2.O00000o = (f10 * f) + f9;
                f2 = (f9 * f) + (((f10 * f) * f) / 2.0f);
                f3 = this.O00000Oo;
            }
            return f2 + f3;
        }

        public final float O000000o() {
            return MotionLayout.this.O00000o;
        }
    }

    private void O000000o(float f) {
        if (this.O00000Oo != null) {
            float f2 = this.O0000o0;
            float f3 = this.O0000o00;
            if (f2 != f3 && this.O000Oo0) {
                this.O0000o0 = f3;
            }
            float f4 = this.O0000o0;
            if (f4 != f) {
                this.O00O0Oo = false;
                this.O0000o0O = f;
                this.O0000Ooo = ((float) this.O00000Oo.O00000oO()) / 1000.0f;
                setProgress(this.O0000o0O);
                this.O00000o0 = this.O00000Oo.O00000o();
                this.O000Oo0 = false;
                this.O000OOoo = getNanoTime();
                this.O0000o0o = true;
                this.O0000o00 = f4;
                this.O0000o0 = f4;
                invalidate();
            }
        }
    }

    public final void O00000o0() {
        O000000o(0.0f);
    }

    public final void O00000o() {
        O000000o(1.0f);
    }

    public final void O000000o(int i) {
        int i2;
        if (!isAttachedToWindow()) {
            if (this.O000o0O == null) {
                this.O000o0O = new O0000OOo();
            }
            this.O000o0O.O00000o = i;
            return;
        }
        oO00O0Oo oo00o0oo = this.O00000Oo;
        if (!(oo00o0oo == null || oo00o0oo.O00000Oo == null)) {
            ooooO0O0 ooooo0o0 = this.O00000Oo.O00000Oo;
            int i3 = this.O00000oo;
            ooooO0O0.O000000o o000000o = ooooo0o0.O00000o.get(i);
            if (o000000o == null) {
                i2 = i;
            } else if (o000000o.O00000o0 == i3) {
                i2 = i3;
            } else {
                Iterator<ooooO0O0.O00000Oo> it = o000000o.O00000Oo.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (i3 == it.next().O00000oO) {
                            break;
                        }
                    } else {
                        i2 = o000000o.O00000o0;
                        break;
                    }
                }
                i2 = i3;
            }
            if (i2 != -1) {
                i = i2;
            }
        }
        int i4 = this.O00000oo;
        if (i4 == i) {
            return;
        }
        if (this.O00000oO == i) {
            O000000o(0.0f);
        } else if (this.O0000O0o == i) {
            O000000o(1.0f);
        } else {
            this.O0000O0o = i;
            if (i4 != -1) {
                O000000o(i4, i);
                O000000o(1.0f);
                this.O0000o0 = 0.0f;
                O000000o(1.0f);
                return;
            }
            this.O00O0Oo = false;
            this.O0000o0O = 1.0f;
            this.O0000o00 = 0.0f;
            this.O0000o0 = 0.0f;
            this.O000Oo00 = getNanoTime();
            this.O000OOoo = getNanoTime();
            this.O000Oo0 = false;
            this.O00000o0 = null;
            this.O0000Ooo = ((float) this.O00000Oo.O00000oO()) / 1000.0f;
            this.O00000oO = -1;
            this.O00000Oo.O000000o(this.O00000oO, this.O0000O0o);
            int childCount = getChildCount();
            this.O0000OoO.clear();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                this.O0000OoO.put(childAt, new oO0Oo0O0(childAt));
            }
            this.O0000o0o = true;
            this.O000OOo.O000000o((oOO0OOo0) null, this.O00000Oo.O000000o(i));
            O0000Oo0();
            this.O000OOo.O00000Oo();
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                View childAt2 = getChildAt(i6);
                oO0Oo0O0 oo0oo0o0 = this.O0000OoO.get(childAt2);
                if (oo0oo0o0 != null) {
                    oo0oo0o0.O00000o.O00000o = 0.0f;
                    oo0oo0o0.O00000o.O00000oO = 0.0f;
                    oo0oo0o0.O00000o.O000000o(childAt2.getX(), childAt2.getY(), (float) childAt2.getWidth(), (float) childAt2.getHeight());
                    oO000o00 oo000o00 = oo0oo0o0.O00000oo;
                    oo000o00.O000000o(childAt2.getX(), childAt2.getY(), (float) childAt2.getWidth(), (float) childAt2.getHeight());
                    oo000o00.O00000o0 = childAt2.getVisibility();
                    oo000o00.f2268O000000o = childAt2.getVisibility() != 0 ? 0.0f : childAt2.getAlpha();
                    oo000o00.O00000o = false;
                    if (Build.VERSION.SDK_INT >= 21) {
                        oo000o00.O00000oO = childAt2.getElevation();
                    }
                    oo000o00.O00000oo = childAt2.getRotation();
                    oo000o00.O0000O0o = childAt2.getRotationX();
                    oo000o00.O0000OOo = childAt2.getRotationY();
                    oo000o00.O0000Oo0 = childAt2.getScaleX();
                    oo000o00.O0000Oo = childAt2.getScaleY();
                    oo000o00.O0000OoO = childAt2.getPivotX();
                    oo000o00.O0000Ooo = childAt2.getPivotY();
                    oo000o00.O0000o00 = childAt2.getTranslationX();
                    oo000o00.O0000o0 = childAt2.getTranslationY();
                    if (Build.VERSION.SDK_INT >= 21) {
                        oo000o00.O0000o0O = childAt2.getTranslationZ();
                    }
                }
            }
            int width = getWidth();
            int height = getHeight();
            for (int i7 = 0; i7 < childCount; i7++) {
                oO0Oo0O0 oo0oo0o02 = this.O0000OoO.get(getChildAt(i7));
                this.O00000Oo.O000000o(oo0oo0o02);
                oo0oo0o02.O000000o(width, height, getNanoTime());
            }
            float O00000oo2 = this.O00000Oo.O00000oo();
            if (O00000oo2 != 0.0f) {
                float f = Float.MAX_VALUE;
                float f2 = -3.4028235E38f;
                for (int i8 = 0; i8 < childCount; i8++) {
                    oO0Oo0O0 oo0oo0o03 = this.O0000OoO.get(getChildAt(i8));
                    float f3 = oo0oo0o03.O00000oO.O0000O0o + oo0oo0o03.O00000oO.O00000oo;
                    f = Math.min(f, f3);
                    f2 = Math.max(f2, f3);
                }
                for (int i9 = 0; i9 < childCount; i9++) {
                    oO0Oo0O0 oo0oo0o04 = this.O0000OoO.get(getChildAt(i9));
                    float f4 = oo0oo0o04.O00000oO.O00000oo;
                    float f5 = oo0oo0o04.O00000oO.O0000O0o;
                    oo0oo0o04.O0000OoO = 1.0f / (1.0f - O00000oo2);
                    oo0oo0o04.O0000Oo = O00000oo2 - ((((f4 + f5) - f) * O00000oo2) / (f2 - f));
                }
            }
            this.O0000o00 = 0.0f;
            this.O0000o0 = 0.0f;
            this.O0000o0o = true;
            invalidate();
        }
    }

    public float getVelocity() {
        return this.O00000o;
    }

    class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        oOo0000O f2783O000000o = new oOo0000O();
        oOo0000O O00000Oo = new oOo0000O();
        oOO0OOo0 O00000o = null;
        oOO0OOo0 O00000o0 = null;
        int O00000oO;
        int O00000oo;

        O00000o0() {
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(oOO0OOo0 ooo0ooo0, oOO0OOo0 ooo0ooo02) {
            this.O00000o0 = ooo0ooo0;
            this.O00000o = ooo0ooo02;
            this.f2783O000000o = new oOo0000O();
            this.O00000Oo = new oOo0000O();
            this.f2783O000000o.O000000o(MotionLayout.this.mLayoutWidget.O0000oO());
            this.O00000Oo.O000000o(MotionLayout.this.mLayoutWidget.O0000oO());
            this.f2783O000000o.O00O0OoO.clear();
            this.O00000Oo.O00O0OoO.clear();
            O000000o(MotionLayout.this.mLayoutWidget, this.f2783O000000o);
            O000000o(MotionLayout.this.mLayoutWidget, this.O00000Oo);
            if (((double) MotionLayout.this.O0000o0) > 0.5d) {
                if (ooo0ooo0 != null) {
                    O000000o(this.f2783O000000o, ooo0ooo0);
                }
                O000000o(this.O00000Oo, ooo0ooo02);
            } else {
                O000000o(this.O00000Oo, ooo0ooo02);
                if (ooo0ooo0 != null) {
                    O000000o(this.f2783O000000o, ooo0ooo0);
                }
            }
            this.f2783O000000o.O000oo = MotionLayout.this.isRtl();
            this.f2783O000000o.O0000oO0();
            this.O00000Oo.O000oo = MotionLayout.this.isRtl();
            this.O00000Oo.O0000oO0();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    oOo0000O ooo0000o = this.f2783O000000o;
                    ooo0000o.O000Oo00[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    oOo0000O ooo0000o2 = this.O00000Oo;
                    ooo0000o2.O000Oo00[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                if (layoutParams.height == -2) {
                    oOo0000O ooo0000o3 = this.f2783O000000o;
                    ooo0000o3.O000Oo00[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    oOo0000O ooo0000o4 = this.O00000Oo;
                    ooo0000o4.O000Oo00[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
            }
        }

        private void O000000o(oOo0000O ooo0000o, oOO0OOo0 ooo0ooo0) {
            SparseArray sparseArray = new SparseArray();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams();
            sparseArray.clear();
            sparseArray.put(0, ooo0000o);
            sparseArray.put(MotionLayout.this.getId(), ooo0000o);
            Iterator<ConstraintWidget> it = ooo0000o.O00O0OoO.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                sparseArray.put(((View) next.O000o0O0).getId(), next);
            }
            Iterator<ConstraintWidget> it2 = ooo0000o.O00O0OoO.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                View view = (View) next2.O000o0O0;
                ooo0ooo0.O000000o(view.getId(), layoutParams);
                next2.O00000oO(ooo0ooo0.O00000oO(view.getId()));
                next2.O00000oo(ooo0ooo0.O00000o(view.getId()));
                if (view instanceof ConstraintHelper) {
                    ooo0ooo0.O000000o((ConstraintHelper) view, next2, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).O00000Oo();
                    }
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                } else {
                    layoutParams.resolveLayoutDirection(0);
                }
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                if (ooo0ooo0.O00000Oo(view.getId()) == 1) {
                    next2.O000o0O = view.getVisibility();
                } else {
                    next2.O000o0O = ooo0ooo0.O00000o0(view.getId());
                }
            }
            Iterator<ConstraintWidget> it3 = ooo0000o.O00O0OoO.iterator();
            while (it3.hasNext()) {
                ConstraintWidget next3 = it3.next();
                if (next3 instanceof oOo0oooO) {
                    oO0O00Oo oo0o00oo = (oO0O00Oo) next3;
                    ((ConstraintHelper) next3.O000o0O0).O000000o(oo0o00oo, sparseArray);
                    ((oOo0oooO) oo0o00oo).O0000o();
                }
            }
        }

        public final void O000000o() {
            O00000Oo(MotionLayout.this.O0000OOo, MotionLayout.this.O0000Oo0);
            MotionLayout.this.O00000Oo();
        }

        private void O00000Oo(int i, int i2) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.O000OO0o = mode;
            motionLayout.O000OO = mode2;
            int optimizationLevel = motionLayout.getOptimizationLevel();
            if (MotionLayout.this.O00000oo == MotionLayout.this.getStartState()) {
                MotionLayout.this.resolveSystem(this.O00000Oo, optimizationLevel, i, i2);
                if (this.O00000o0 != null) {
                    MotionLayout.this.resolveSystem(this.f2783O000000o, optimizationLevel, i, i2);
                }
            } else {
                if (this.O00000o0 != null) {
                    MotionLayout.this.resolveSystem(this.f2783O000000o, optimizationLevel, i, i2);
                }
                MotionLayout.this.resolveSystem(this.O00000Oo, optimizationLevel, i, i2);
            }
            if (((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                MotionLayout motionLayout2 = MotionLayout.this;
                motionLayout2.O000OO0o = mode;
                motionLayout2.O000OO = mode2;
                if (motionLayout2.O00000oo == MotionLayout.this.getStartState()) {
                    MotionLayout.this.resolveSystem(this.O00000Oo, optimizationLevel, i, i2);
                    if (this.O00000o0 != null) {
                        MotionLayout.this.resolveSystem(this.f2783O000000o, optimizationLevel, i, i2);
                    }
                } else {
                    if (this.O00000o0 != null) {
                        MotionLayout.this.resolveSystem(this.f2783O000000o, optimizationLevel, i, i2);
                    }
                    MotionLayout.this.resolveSystem(this.O00000Oo, optimizationLevel, i, i2);
                }
                MotionLayout.this.O000O0o = this.f2783O000000o.O00000oO();
                MotionLayout.this.O000O0oO = this.f2783O000000o.O00000oo();
                MotionLayout.this.O000O0oo = this.O00000Oo.O00000oO();
                MotionLayout.this.O000OO00 = this.O00000Oo.O00000oo();
                MotionLayout motionLayout3 = MotionLayout.this;
                motionLayout3.O000O0o0 = (motionLayout3.O000O0o == MotionLayout.this.O000O0oo && MotionLayout.this.O000O0oO == MotionLayout.this.O000OO00) ? false : true;
            }
            int i3 = MotionLayout.this.O000O0o;
            int i4 = MotionLayout.this.O000O0oO;
            if (MotionLayout.this.O000OO0o == Integer.MIN_VALUE || MotionLayout.this.O000OO0o == 0) {
                i3 = (int) (((float) MotionLayout.this.O000O0o) + (MotionLayout.this.O000OOOo * ((float) (MotionLayout.this.O000O0oo - MotionLayout.this.O000O0o))));
            }
            int i5 = i3;
            if (MotionLayout.this.O000OO == Integer.MIN_VALUE || MotionLayout.this.O000OO == 0) {
                i4 = (int) (((float) MotionLayout.this.O000O0oO) + (MotionLayout.this.O000OOOo * ((float) (MotionLayout.this.O000OO00 - MotionLayout.this.O000O0oO))));
            }
            MotionLayout.this.resolveMeasuredDimension(i, i2, i5, i4, this.f2783O000000o.O00O0OO || this.O00000Oo.O00O0OO, this.f2783O000000o.O00O0OOo || this.O00000Oo.O00O0OOo);
        }

        public final void O00000Oo() {
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.O0000OoO.clear();
            for (int i = 0; i < childCount; i++) {
                View childAt = MotionLayout.this.getChildAt(i);
                MotionLayout.this.O0000OoO.put(childAt, new oO0Oo0O0(childAt));
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = MotionLayout.this.getChildAt(i2);
                oO0Oo0O0 oo0oo0o0 = MotionLayout.this.O0000OoO.get(childAt2);
                if (oo0oo0o0 != null) {
                    if (this.O00000o0 != null) {
                        ConstraintWidget O000000o2 = O000000o(this.f2783O000000o, childAt2);
                        if (O000000o2 != null) {
                            oo0oo0o0.O000000o(O000000o2, this.O00000o0);
                        } else if (MotionLayout.this.O0000oO0 != 0) {
                            Log.e("MotionLayout", oO00000o.O000000o() + "no widget for  " + oO00000o.O000000o(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                    if (this.O00000o != null) {
                        ConstraintWidget O000000o3 = O000000o(this.O00000Oo, childAt2);
                        if (O000000o3 != null) {
                            oo0oo0o0.O00000Oo(O000000o3, this.O00000o);
                        } else if (MotionLayout.this.O0000oO0 != 0) {
                            Log.e("MotionLayout", oO00000o.O000000o() + "no widget for  " + oO00000o.O000000o(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                }
            }
        }

        public final void O000000o(int i, int i2) {
            this.O00000oO = i;
            this.O00000oo = i2;
        }

        private static void O000000o(oOo0000O ooo0000o, oOo0000O ooo0000o2) {
            ConstraintWidget constraintWidget;
            ArrayList<ConstraintWidget> arrayList = ooo0000o.O00O0OoO;
            HashMap hashMap = new HashMap();
            hashMap.put(ooo0000o, ooo0000o2);
            ooo0000o2.O00O0OoO.clear();
            ooo0000o2.O000000o(ooo0000o, hashMap);
            Iterator<ConstraintWidget> it = arrayList.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                if (next instanceof oOo00ooO) {
                    constraintWidget = new oOo00ooO();
                } else if (next instanceof oO0O000o) {
                    constraintWidget = new oO0O000o();
                } else if (next instanceof oOo000o0) {
                    constraintWidget = new oOo000o0();
                } else if (next instanceof oO0O00Oo) {
                    constraintWidget = new oO0O00o0();
                } else {
                    constraintWidget = new ConstraintWidget();
                }
                ooo0000o2.O000000o(constraintWidget);
                hashMap.put(next, constraintWidget);
            }
            Iterator<ConstraintWidget> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                ((ConstraintWidget) hashMap.get(next2)).O000000o(next2, hashMap);
            }
        }

        private static ConstraintWidget O000000o(oOo0000O ooo0000o, View view) {
            if (ooo0000o.O000o0O0 == view) {
                return ooo0000o;
            }
            ArrayList<ConstraintWidget> arrayList = ooo0000o.O00O0OoO;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = arrayList.get(i);
                if (constraintWidget.O000o0O0 == view) {
                    return constraintWidget;
                }
            }
            return null;
        }
    }

    public void requestLayout() {
        oO00O0Oo oo00o0oo;
        if (this.O000O0o0 || this.O00000oo != -1 || (oo00o0oo = this.O00000Oo) == null || oo00o0oo.O00000o0 == null || this.O00000Oo.O00000o0.O0000o != 0) {
            super.requestLayout();
        }
    }

    public String toString() {
        Context context = getContext();
        return oO00000o.O000000o(context, this.O00000oO) + "->" + oO00000o.O000000o(context, this.O0000O0o) + " (pos:" + this.O0000o0 + " Dpos/Dt:" + this.O00000o;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (((r3 == r0.O00000oO && r4 == r0.O00000oo) ? false : true) != false) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    public void onMeasure(int i, int i2) {
        boolean z;
        float signum;
        float f;
        int childCount;
        if (this.O00000Oo == null) {
            super.onMeasure(i, i2);
            return;
        }
        boolean z2 = true;
        boolean z3 = (this.O0000OOo == i && this.O0000Oo0 == i2) ? false : true;
        if (this.O000o0OO) {
            this.O000o0OO = false;
            O00000oO();
            O0000OOo();
            z3 = true;
        }
        if (this.mDirtyHierarchy) {
            z3 = true;
        }
        this.O0000OOo = i;
        this.O0000Oo0 = i2;
        int O00000Oo2 = this.O00000Oo.O00000Oo();
        int O00000o02 = this.O00000Oo.O00000o0();
        if (!z3) {
            O00000o0 o00000o0 = this.O000OOo;
        }
        if (this.O00000oO != -1) {
            super.onMeasure(i, i2);
            this.O000OOo.O000000o(this.O00000Oo.O000000o(O00000Oo2), this.O00000Oo.O000000o(O00000o02));
            this.O000OOo.O000000o();
            this.O000OOo.O000000o(O00000Oo2, O00000o02);
            z = false;
            if (this.O000O0o0 || z) {
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int O00000oO2 = this.mLayoutWidget.O00000oO() + getPaddingLeft() + getPaddingRight();
                int O00000oo2 = this.mLayoutWidget.O00000oo() + paddingTop;
                int i3 = this.O000OO0o;
                if (i3 == Integer.MIN_VALUE || i3 == 0) {
                    int i4 = this.O000O0o;
                    O00000oO2 = (int) (((float) i4) + (this.O000OOOo * ((float) (this.O000O0oo - i4))));
                    requestLayout();
                }
                int i5 = this.O000OO;
                if (i5 == Integer.MIN_VALUE || i5 == 0) {
                    int i6 = this.O000O0oO;
                    O00000oo2 = (int) (((float) i6) + (this.O000OOOo * ((float) (this.O000OO00 - i6))));
                    requestLayout();
                }
                setMeasuredDimension(O00000oO2, O00000oo2);
            }
            signum = Math.signum(this.O0000o0O - this.O0000o0);
            long nanoTime = getNanoTime();
            f = this.O0000o0 + (this.O00000o0 instanceof o0Oo0000 ? ((((float) (nanoTime - this.O000Oo00)) * signum) * 1.0E-9f) / this.O0000Ooo : 0.0f);
            if (this.O000Oo0) {
                f = this.O0000o0O;
            }
            if ((signum > 0.0f || f < this.O0000o0O) && (signum > 0.0f || f > this.O0000o0O)) {
                z2 = false;
            } else {
                f = this.O0000o0O;
            }
            Interpolator interpolator = this.O00000o0;
            if (interpolator != null && !z2) {
                if (!this.O00O0Oo) {
                    f = interpolator.getInterpolation(((float) (nanoTime - this.O000OOoo)) * 1.0E-9f);
                } else {
                    f = interpolator.getInterpolation(f);
                }
            }
            if ((signum > 0.0f && f >= this.O0000o0O) || (signum <= 0.0f && f <= this.O0000o0O)) {
                f = this.O0000o0O;
            }
            this.O000OOOo = f;
            childCount = getChildCount();
            long nanoTime2 = getNanoTime();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                oO0Oo0O0 oo0oo0o0 = this.O0000OoO.get(childAt);
                if (oo0oo0o0 != null) {
                    oo0oo0o0.O000000o(childAt, f, nanoTime2, this.O000o0);
                }
            }
            if (!this.O000O0o0) {
                requestLayout();
                return;
            }
            return;
        }
        z = true;
        int paddingTop2 = getPaddingTop() + getPaddingBottom();
        int O00000oO22 = this.mLayoutWidget.O00000oO() + getPaddingLeft() + getPaddingRight();
        int O00000oo22 = this.mLayoutWidget.O00000oo() + paddingTop2;
        int i32 = this.O000OO0o;
        int i42 = this.O000O0o;
        O00000oO22 = (int) (((float) i42) + (this.O000OOOo * ((float) (this.O000O0oo - i42))));
        requestLayout();
        int i52 = this.O000OO;
        int i62 = this.O000O0oO;
        O00000oo22 = (int) (((float) i62) + (this.O000OOOo * ((float) (this.O000OO00 - i62))));
        requestLayout();
        setMeasuredDimension(O00000oO22, O00000oo22);
        signum = Math.signum(this.O0000o0O - this.O0000o0);
        long nanoTime3 = getNanoTime();
        f = this.O0000o0 + (this.O00000o0 instanceof o0Oo0000 ? ((((float) (nanoTime3 - this.O000Oo00)) * signum) * 1.0E-9f) / this.O0000Ooo : 0.0f);
        if (this.O000Oo0) {
        }
        if (signum > 0.0f) {
        }
        z2 = false;
        Interpolator interpolator2 = this.O00000o0;
        if (!this.O00O0Oo) {
        }
        f = this.O0000o0O;
        this.O000OOOo = f;
        childCount = getChildCount();
        long nanoTime22 = getNanoTime();
        while (i7 < childCount) {
        }
        if (!this.O000O0o0) {
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        oO00O0Oo oo00o0oo = this.O00000Oo;
        return (oo00o0oo == null || oo00o0oo.O00000o0 == null || this.O00000Oo.O00000o0.O0000Ooo == null || (this.O00000Oo.O00000o0.O0000Ooo.O0000oO0 & 2) != 0) ? false : true;
    }

    public void onStopNestedScroll(View view, int i) {
        float f;
        oO00O0Oo oo00o0oo = this.O00000Oo;
        if (oo00o0oo != null) {
            float f2 = this.O00oOooO;
            float f3 = this.O000O0OO;
            float f4 = f2 / f3;
            float f5 = this.O00oOooo / f3;
            if (oo00o0oo.O00000o0 != null && oo00o0oo.O00000o0.O0000Ooo != null) {
                oOo00OO0 ooo00oo0 = oo00o0oo.O00000o0.O0000Ooo;
                boolean z = false;
                ooo00oo0.O0000Oo0 = false;
                float progress = ooo00oo0.O0000o00.getProgress();
                ooo00oo0.O0000o00.O000000o(ooo00oo0.O00000Oo, progress, ooo00oo0.O00000oo, ooo00oo0.O00000oO, ooo00oo0.O0000Oo);
                if (ooo00oo0.O0000O0o != 0.0f) {
                    f = (f4 * ooo00oo0.O0000O0o) / ooo00oo0.O0000Oo[0];
                } else {
                    f = (f5 * ooo00oo0.O0000OOo) / ooo00oo0.O0000Oo[1];
                }
                if (!Float.isNaN(f)) {
                    progress += f / 3.0f;
                }
                if (progress != 0.0f) {
                    float f6 = 1.0f;
                    boolean z2 = progress != 1.0f;
                    if (ooo00oo0.f2329O000000o != 3) {
                        z = true;
                    }
                    if (z && z2) {
                        MotionLayout motionLayout = ooo00oo0.O0000o00;
                        int i2 = ooo00oo0.f2329O000000o;
                        if (((double) progress) < 0.5d) {
                            f6 = 0.0f;
                        }
                        motionLayout.O000000o(i2, f6, f);
                    }
                }
            }
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (!(!this.O0000ooo && i == 0 && i2 == 0)) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
        }
        this.O0000ooo = false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        float f;
        float f2;
        boolean z;
        oOo00OO0 ooo00oo0;
        int i4;
        final View view2 = view;
        int i5 = i;
        int i6 = i2;
        oO00O0Oo oo00o0oo = this.O00000Oo;
        if (oo00o0oo != null && oo00o0oo.O00000o0 != null && this.O00000Oo.O00000o0.O000000o()) {
            oO00O0Oo.O000000o o000000o = this.O00000Oo.O00000o0;
            if (o000000o == null || !o000000o.O000000o() || (ooo00oo0 = o000000o.O0000Ooo) == null || (i4 = ooo00oo0.O00000o0) == -1 || view.getId() == i4) {
                oO00O0Oo oo00o0oo2 = this.O00000Oo;
                if (oo00o0oo2 != null) {
                    if (oo00o0oo2.O00000o0 == null || oo00o0oo2.O00000o0.O0000Ooo == null) {
                        z = false;
                    } else {
                        z = oo00o0oo2.O00000o0.O0000Ooo.O0000o0o;
                    }
                    if (z) {
                        float f3 = this.O0000o00;
                        if ((f3 == 1.0f || f3 == 0.0f) && view2.canScrollVertically(-1)) {
                            return;
                        }
                    }
                }
                if (!(o000000o.O0000Ooo == null || (this.O00000Oo.O00000o0.O0000Ooo.O0000oO0 & 1) == 0)) {
                    oO00O0Oo oo00o0oo3 = this.O00000Oo;
                    float f4 = (float) i5;
                    float f5 = (float) i6;
                    if (oo00o0oo3.O00000o0 == null || oo00o0oo3.O00000o0.O0000Ooo == null) {
                        f2 = 0.0f;
                    } else {
                        oOo00OO0 ooo00oo02 = oo00o0oo3.O00000o0.O0000Ooo;
                        ooo00oo02.O0000o00.O000000o(ooo00oo02.O00000Oo, ooo00oo02.O0000o00.getProgress(), ooo00oo02.O00000oo, ooo00oo02.O00000oO, ooo00oo02.O0000Oo);
                        if (ooo00oo02.O0000O0o != 0.0f) {
                            if (ooo00oo02.O0000Oo[0] == 0.0f) {
                                ooo00oo02.O0000Oo[0] = 1.0E-7f;
                            }
                            f2 = (f4 * ooo00oo02.O0000O0o) / ooo00oo02.O0000Oo[0];
                        } else {
                            if (ooo00oo02.O0000Oo[1] == 0.0f) {
                                ooo00oo02.O0000Oo[1] = 1.0E-7f;
                            }
                            f2 = (f5 * ooo00oo02.O0000OOo) / ooo00oo02.O0000Oo[1];
                        }
                    }
                    if ((this.O0000o0 <= 0.0f && f2 < 0.0f) || (this.O0000o0 >= 1.0f && f2 > 0.0f)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            view2.setNestedScrollingEnabled(false);
                            view2.post(new Runnable() {
                                /* class androidx.constraintlayout.motion.widget.MotionLayout.AnonymousClass1 */

                                public final void run() {
                                    view2.setNestedScrollingEnabled(true);
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
                float f6 = this.O0000o00;
                long nanoTime = getNanoTime();
                float f7 = (float) i5;
                this.O00oOooO = f7;
                float f8 = (float) i6;
                this.O00oOooo = f8;
                double d = (double) (nanoTime - this.O000O00o);
                Double.isNaN(d);
                this.O000O0OO = (float) (d * 1.0E-9d);
                this.O000O00o = nanoTime;
                oO00O0Oo oo00o0oo4 = this.O00000Oo;
                if (!(oo00o0oo4.O00000o0 == null || oo00o0oo4.O00000o0.O0000Ooo == null)) {
                    oOo00OO0 ooo00oo03 = oo00o0oo4.O00000o0.O0000Ooo;
                    float progress = ooo00oo03.O0000o00.getProgress();
                    if (!ooo00oo03.O0000Oo0) {
                        ooo00oo03.O0000Oo0 = true;
                        ooo00oo03.O0000o00.setProgress(progress);
                    }
                    ooo00oo03.O0000o00.O000000o(ooo00oo03.O00000Oo, progress, ooo00oo03.O00000oo, ooo00oo03.O00000oO, ooo00oo03.O0000Oo);
                    if (((double) Math.abs((ooo00oo03.O0000O0o * ooo00oo03.O0000Oo[0]) + (ooo00oo03.O0000OOo * ooo00oo03.O0000Oo[1]))) < 0.01d) {
                        ooo00oo03.O0000Oo[0] = 0.01f;
                        ooo00oo03.O0000Oo[1] = 0.01f;
                    }
                    if (ooo00oo03.O0000O0o != 0.0f) {
                        f = (f7 * ooo00oo03.O0000O0o) / ooo00oo03.O0000Oo[0];
                    } else {
                        f = (f8 * ooo00oo03.O0000OOo) / ooo00oo03.O0000Oo[1];
                    }
                    float max = Math.max(Math.min(progress + f, 1.0f), 0.0f);
                    if (max != ooo00oo03.O0000o00.getProgress()) {
                        ooo00oo03.O0000o00.setProgress(max);
                    }
                }
                if (f6 != this.O0000o00) {
                    iArr[0] = i5;
                    iArr[1] = i6;
                }
                O000000o(false);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.O0000ooo = true;
                }
            }
        }
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        float[] f2782O000000o;
        int[] O00000Oo;
        Path O00000o;
        float[] O00000o0;
        Paint O00000oO = new Paint();
        Paint O00000oo;
        Paint O0000O0o;
        Paint O0000OOo;
        final int O0000Oo = -21965;
        Paint O0000Oo0;
        final int O0000OoO = -2067046;
        final int O0000Ooo = -13391360;
        Rect O0000o = new Rect();
        final int O0000o0 = 10;
        final int O0000o00 = 1996488704;
        DashPathEffect O0000o0O;
        int O0000o0o;
        int O0000oO = 1;
        boolean O0000oO0 = false;
        private float[] O0000oOo;

        public O00000Oo() {
            this.O00000oO.setAntiAlias(true);
            this.O00000oO.setColor(-21965);
            this.O00000oO.setStrokeWidth(2.0f);
            this.O00000oO.setStyle(Paint.Style.STROKE);
            this.O00000oo = new Paint();
            this.O00000oo.setAntiAlias(true);
            this.O00000oo.setColor(-2067046);
            this.O00000oo.setStrokeWidth(2.0f);
            this.O00000oo.setStyle(Paint.Style.STROKE);
            this.O0000O0o = new Paint();
            this.O0000O0o.setAntiAlias(true);
            this.O0000O0o.setColor(-13391360);
            this.O0000O0o.setStrokeWidth(2.0f);
            this.O0000O0o.setStyle(Paint.Style.STROKE);
            this.O0000OOo = new Paint();
            this.O0000OOo.setAntiAlias(true);
            this.O0000OOo.setColor(-13391360);
            this.O0000OOo.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.O0000oOo = new float[8];
            this.O0000Oo0 = new Paint();
            this.O0000Oo0.setAntiAlias(true);
            this.O0000o0O = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.O0000O0o.setPathEffect(this.O0000o0O);
            this.O00000o0 = new float[100];
            this.O00000Oo = new int[50];
            if (this.O0000oO0) {
                this.O00000oO.setStrokeWidth(8.0f);
                this.O0000Oo0.setStrokeWidth(8.0f);
                this.O00000oo.setStrokeWidth(8.0f);
                this.O0000oO = 4;
            }
        }

        public final void O000000o(Canvas canvas, HashMap<View, oO0Oo0O0> hashMap, int i, int i2) {
            if (hashMap != null && hashMap.size() != 0) {
                canvas.save();
                if (!MotionLayout.this.isInEditMode() && (i2 & 1) == 2) {
                    String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.O0000O0o) + ":" + MotionLayout.this.getProgress();
                    canvas.drawText(str, 10.0f, (float) (MotionLayout.this.getHeight() - 30), this.O0000OOo);
                    canvas.drawText(str, 11.0f, (float) (MotionLayout.this.getHeight() - 29), this.O00000oO);
                }
                for (oO0Oo0O0 next : hashMap.values()) {
                    int O000000o2 = next.O000000o();
                    if (i2 > 0 && O000000o2 == 0) {
                        O000000o2 = 1;
                    }
                    if (O000000o2 != 0) {
                        this.O0000o0o = next.O000000o(this.O00000o0, this.O00000Oo);
                        if (O000000o2 > 0) {
                            int i3 = i / 16;
                            float[] fArr = this.f2782O000000o;
                            if (fArr == null || fArr.length != i3 * 2) {
                                this.f2782O000000o = new float[(i3 * 2)];
                                this.O00000o = new Path();
                            }
                            int i4 = this.O0000oO;
                            canvas.translate((float) i4, (float) i4);
                            this.O00000oO.setColor(1996488704);
                            this.O0000Oo0.setColor(1996488704);
                            this.O00000oo.setColor(1996488704);
                            this.O0000O0o.setColor(1996488704);
                            next.O000000o(this.f2782O000000o, i3);
                            O000000o(canvas, O000000o2, this.O0000o0o, next);
                            this.O00000oO.setColor(-21965);
                            this.O00000oo.setColor(-2067046);
                            this.O0000Oo0.setColor(-2067046);
                            this.O0000O0o.setColor(-13391360);
                            int i5 = this.O0000oO;
                            canvas.translate((float) (-i5), (float) (-i5));
                            O000000o(canvas, O000000o2, this.O0000o0o, next);
                            if (O000000o2 == 5) {
                                O000000o(canvas, next);
                            }
                        }
                    }
                }
                canvas.restore();
            }
        }

        private void O000000o(Canvas canvas, int i, int i2, oO0Oo0O0 oo0oo0o0) {
            if (i == 4) {
                O00000o0(canvas);
            }
            if (i == 2) {
                O00000Oo(canvas);
            }
            if (i == 3) {
                O00000o(canvas);
            }
            O000000o(canvas);
            O00000Oo(canvas, i, i2, oo0oo0o0);
        }

        private void O000000o(Canvas canvas) {
            canvas.drawLines(this.f2782O000000o, this.O00000oO);
        }

        private void O00000Oo(Canvas canvas, int i, int i2, oO0Oo0O0 oo0oo0o0) {
            int i3;
            int i4;
            float f;
            float f2;
            int i5;
            Canvas canvas2 = canvas;
            int i6 = i;
            oO0Oo0O0 oo0oo0o02 = oo0oo0o0;
            if (oo0oo0o02.f2287O000000o != null) {
                i4 = oo0oo0o02.f2287O000000o.getWidth();
                i3 = oo0oo0o02.f2287O000000o.getHeight();
            } else {
                i4 = 0;
                i3 = 0;
            }
            for (int i7 = 1; i7 < i2 - 1; i7++) {
                if (i6 != 4 || this.O00000Oo[i7 - 1] != 0) {
                    float[] fArr = this.O00000o0;
                    int i8 = i7 * 2;
                    float f3 = fArr[i8];
                    float f4 = fArr[i8 + 1];
                    this.O00000o.reset();
                    this.O00000o.moveTo(f3, f4 + 10.0f);
                    this.O00000o.lineTo(f3 + 10.0f, f4);
                    this.O00000o.lineTo(f3, f4 - 10.0f);
                    this.O00000o.lineTo(f3 - 10.0f, f4);
                    this.O00000o.close();
                    int i9 = i7 - 1;
                    oo0oo0o02.O000000o(i9);
                    if (i6 == 4) {
                        int[] iArr = this.O00000Oo;
                        if (iArr[i9] == 1) {
                            O000000o(canvas2, f3 - 0.0f, f4 - 0.0f);
                        } else if (iArr[i9] == 2) {
                            O00000Oo(canvas2, f3 - 0.0f, f4 - 0.0f);
                        } else if (iArr[i9] == 3) {
                            i5 = 3;
                            f2 = f4;
                            f = f3;
                            O000000o(canvas, f3 - 0.0f, f4 - 0.0f, i4, i3);
                            canvas2.drawPath(this.O00000o, this.O0000Oo0);
                        }
                        f2 = f4;
                        f = f3;
                        i5 = 3;
                        canvas2.drawPath(this.O00000o, this.O0000Oo0);
                    } else {
                        f2 = f4;
                        f = f3;
                        i5 = 3;
                    }
                    if (i6 == 2) {
                        O000000o(canvas2, f - 0.0f, f2 - 0.0f);
                    }
                    if (i6 == i5) {
                        O00000Oo(canvas2, f - 0.0f, f2 - 0.0f);
                    }
                    if (i6 == 6) {
                        O000000o(canvas, f - 0.0f, f2 - 0.0f, i4, i3);
                    }
                    canvas2.drawPath(this.O00000o, this.O0000Oo0);
                }
            }
            float[] fArr2 = this.f2782O000000o;
            if (fArr2.length > 1) {
                canvas2.drawCircle(fArr2[0], fArr2[1], 8.0f, this.O00000oo);
                float[] fArr3 = this.f2782O000000o;
                canvas2.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.O00000oo);
            }
        }

        private void O00000Oo(Canvas canvas) {
            float[] fArr = this.f2782O000000o;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.O0000O0o);
        }

        private void O00000o0(Canvas canvas) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.O0000o0o; i++) {
                if (this.O00000Oo[i] == 1) {
                    z = true;
                }
                if (this.O00000Oo[i] == 2) {
                    z2 = true;
                }
            }
            if (z) {
                O00000Oo(canvas);
            }
            if (z2) {
                O00000o(canvas);
            }
        }

        private void O000000o(Canvas canvas, float f, float f2) {
            float[] fArr = this.f2782O000000o;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot((double) (f3 - f5), (double) (f4 - f6));
            float f7 = f5 - f3;
            float f8 = f6 - f4;
            float f9 = (((f - f3) * f7) + ((f2 - f4) * f8)) / (hypot * hypot);
            float f10 = f3 + (f7 * f9);
            float f11 = f4 + (f9 * f8);
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f10, f11);
            float hypot2 = (float) Math.hypot((double) (f10 - f), (double) (f11 - f2));
            StringBuilder sb = new StringBuilder();
            sb.append(((float) ((int) ((hypot2 * 100.0f) / hypot))) / 100.0f);
            String sb2 = sb.toString();
            O000000o(sb2, this.O0000OOo);
            canvas.drawTextOnPath(sb2, path, (hypot2 / 2.0f) - ((float) (this.O0000o.width() / 2)), -20.0f, this.O0000OOo);
            canvas.drawLine(f, f2, f10, f11, this.O0000O0o);
        }

        private void O000000o(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.O0000o);
        }

        private void O00000o(Canvas canvas) {
            float[] fArr = this.f2782O000000o;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.O0000O0o);
            canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.O0000O0o);
        }

        private void O00000Oo(Canvas canvas, float f, float f2) {
            Canvas canvas2 = canvas;
            float[] fArr = this.f2782O000000o;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float min = Math.min(f3, f5);
            float max = Math.max(f4, f6);
            float min2 = f - Math.min(f3, f5);
            float max2 = Math.max(f4, f6) - f2;
            StringBuilder sb = new StringBuilder();
            double abs = (double) ((min2 * 100.0f) / Math.abs(f5 - f3));
            Double.isNaN(abs);
            sb.append(((float) ((int) (abs + 0.5d))) / 100.0f);
            String sb2 = sb.toString();
            O000000o(sb2, this.O0000OOo);
            canvas2.drawText(sb2, ((min2 / 2.0f) - ((float) (this.O0000o.width() / 2))) + min, f2 - 20.0f, this.O0000OOo);
            canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.O0000O0o);
            StringBuilder sb3 = new StringBuilder();
            double abs2 = (double) ((max2 * 100.0f) / Math.abs(f6 - f4));
            Double.isNaN(abs2);
            sb3.append(((float) ((int) (abs2 + 0.5d))) / 100.0f);
            String sb4 = sb3.toString();
            O000000o(sb4, this.O0000OOo);
            canvas2.drawText(sb4, f + 5.0f, max - ((max2 / 2.0f) - ((float) (this.O0000o.height() / 2))), this.O0000OOo);
            canvas.drawLine(f, f2, f, Math.max(f4, f6), this.O0000O0o);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.min(float, float):float}
         arg types: [int, int]
         candidates:
          ClspMth{java.lang.Math.min(double, double):double}
          ClspMth{java.lang.Math.min(long, long):long}
          ClspMth{java.lang.Math.min(int, int):int}
          ClspMth{java.lang.Math.min(float, float):float} */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.max(float, float):float}
         arg types: [int, int]
         candidates:
          ClspMth{java.lang.Math.max(double, double):double}
          ClspMth{java.lang.Math.max(int, int):int}
          ClspMth{java.lang.Math.max(long, long):long}
          ClspMth{java.lang.Math.max(float, float):float} */
        private void O000000o(Canvas canvas, float f, float f2, int i, int i2) {
            StringBuilder sb = new StringBuilder();
            double width = (double) (((f - ((float) (i / 2))) * 100.0f) / ((float) (MotionLayout.this.getWidth() - i)));
            Double.isNaN(width);
            sb.append(((float) ((int) (width + 0.5d))) / 100.0f);
            String sb2 = sb.toString();
            O000000o(sb2, this.O0000OOo);
            canvas.drawText(sb2, ((f / 2.0f) - ((float) (this.O0000o.width() / 2))) + 0.0f, f2 - 20.0f, this.O0000OOo);
            canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.O0000O0o);
            StringBuilder sb3 = new StringBuilder();
            double height = (double) (((f2 - ((float) (i2 / 2))) * 100.0f) / ((float) (MotionLayout.this.getHeight() - i2)));
            Double.isNaN(height);
            sb3.append(((float) ((int) (height + 0.5d))) / 100.0f);
            String sb4 = sb3.toString();
            O000000o(sb4, this.O0000OOo);
            canvas.drawText(sb4, f + 5.0f, 0.0f - ((f2 / 2.0f) - ((float) (this.O0000o.height() / 2))), this.O0000OOo);
            canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.O0000O0o);
        }

        private void O000000o(Canvas canvas, oO0Oo0O0 oo0oo0o0) {
            Canvas canvas2 = canvas;
            oO0Oo0O0 oo0oo0o02 = oo0oo0o0;
            this.O00000o.reset();
            char c = 0;
            int i = 0;
            while (i <= 50) {
                float[] fArr = this.O0000oOo;
                oo0oo0o02.O0000O0o[c].O000000o((double) oo0oo0o02.O000000o(((float) i) / 50.0f, (float[]) null), oo0oo0o02.O0000o00);
                oO00O00o oo00o00o = oo0oo0o02.O00000o;
                int[] iArr = oo0oo0o02.O0000Ooo;
                double[] dArr = oo0oo0o02.O0000o00;
                float f = oo00o00o.O00000oo;
                float f2 = oo00o00o.O0000O0o;
                float f3 = oo00o00o.O0000OOo;
                float f4 = oo00o00o.O0000Oo0;
                int i2 = 0;
                while (i2 < iArr.length) {
                    int i3 = i;
                    float f5 = (float) dArr[i2];
                    int i4 = iArr[i2];
                    if (i4 != 0) {
                        if (i4 == 1) {
                            f = f5;
                        } else if (i4 == 2) {
                            f2 = f5;
                        } else if (i4 == 3) {
                            f3 = f5;
                        } else if (i4 == 4) {
                            f4 = f5;
                        }
                    }
                    i2++;
                    i = i3;
                }
                float f6 = f3 + f;
                float f7 = f4 + f2;
                Float.isNaN(Float.NaN);
                Float.isNaN(Float.NaN);
                float f8 = f + 0.0f;
                float f9 = f2 + 0.0f;
                float f10 = f6 + 0.0f;
                float f11 = f7 + 0.0f;
                fArr[0] = f8;
                fArr[1] = f9;
                fArr[2] = f10;
                fArr[3] = f9;
                fArr[4] = f10;
                fArr[5] = f11;
                fArr[6] = f8;
                fArr[7] = f11;
                Path path = this.O00000o;
                float[] fArr2 = this.O0000oOo;
                path.moveTo(fArr2[0], fArr2[1]);
                Path path2 = this.O00000o;
                float[] fArr3 = this.O0000oOo;
                path2.lineTo(fArr3[2], fArr3[3]);
                Path path3 = this.O00000o;
                float[] fArr4 = this.O0000oOo;
                path3.lineTo(fArr4[4], fArr4[5]);
                Path path4 = this.O00000o;
                float[] fArr5 = this.O0000oOo;
                path4.lineTo(fArr5[6], fArr5[7]);
                this.O00000o.close();
                i++;
                c = 0;
            }
            this.O00000oO.setColor(1140850688);
            canvas2.translate(2.0f, 2.0f);
            canvas2.drawPath(this.O00000o, this.O00000oO);
            canvas2.translate(-2.0f, -2.0f);
            this.O00000oO.setColor(-65536);
            canvas2.drawPath(this.O00000o, this.O00000oO);
        }
    }

    public void dispatchDraw(Canvas canvas) {
        String str;
        O000000o(false);
        super.dispatchDraw(canvas);
        if (this.O00000Oo != null) {
            if ((this.O0000oO0 & 1) == 1 && !isInEditMode()) {
                this.O000Oooo++;
                long nanoTime = getNanoTime();
                long j = this.O000o000;
                if (j != -1) {
                    long j2 = nanoTime - j;
                    if (j2 > 200000000) {
                        this.O000o00 = ((float) ((int) ((((float) this.O000Oooo) / (((float) j2) * 1.0E-9f)) * 100.0f))) / 100.0f;
                        this.O000Oooo = 0;
                        this.O000o000 = nanoTime;
                    }
                } else {
                    this.O000o000 = nanoTime;
                }
                Paint paint = new Paint();
                paint.setTextSize(42.0f);
                StringBuilder sb = new StringBuilder();
                sb.append(this.O000o00 + " fps " + oO00000o.O000000o(this, this.O00000oO) + " -> ");
                sb.append(oO00000o.O000000o(this, this.O0000O0o));
                sb.append(" (progress: ");
                sb.append(((float) ((int) (getProgress() * 1000.0f))) / 10.0f);
                sb.append(" ) state=");
                int i = this.O00000oo;
                if (i == -1) {
                    str = "undefined";
                } else {
                    str = oO00000o.O000000o(this, i);
                }
                sb.append(str);
                String sb2 = sb.toString();
                paint.setColor(-16777216);
                canvas.drawText(sb2, 11.0f, (float) (getHeight() - 29), paint);
                paint.setColor(-7864184);
                canvas.drawText(sb2, 10.0f, (float) (getHeight() - 30), paint);
            }
            if (this.O0000oO0 > 1) {
                if (this.O0000oO == null) {
                    this.O0000oO = new O00000Oo();
                }
                this.O0000oO.O000000o(canvas, this.O0000OoO, this.O00000Oo.O00000oO(), this.O0000oO0);
            }
        }
    }

    public final void O000000o(boolean z) {
        float f;
        boolean z2;
        int i;
        int i2;
        if (this.O000Oo00 == -1) {
            this.O000Oo00 = getNanoTime();
        }
        float f2 = this.O0000o0;
        if (f2 > 0.0f && f2 < 1.0f) {
            this.O00000oo = -1;
        }
        boolean z3 = false;
        if (this.O000Ooo0 || (this.O0000o0o && (z || this.O0000o0O != this.O0000o0))) {
            float signum = Math.signum(this.O0000o0O - this.O0000o0);
            long nanoTime = getNanoTime();
            if (!(this.O00000o0 instanceof oO0O0o0o)) {
                f = ((((float) (nanoTime - this.O000Oo00)) * signum) * 1.0E-9f) / this.O0000Ooo;
                this.O00000o = f;
            } else {
                f = 0.0f;
            }
            float f3 = this.O0000o0 + f;
            if (this.O000Oo0) {
                f3 = this.O0000o0O;
            }
            if ((signum <= 0.0f || f3 < this.O0000o0O) && (signum > 0.0f || f3 > this.O0000o0O)) {
                z2 = false;
            } else {
                f3 = this.O0000o0O;
                this.O0000o0o = false;
                z2 = true;
            }
            this.O0000o0 = f3;
            this.O0000o00 = f3;
            this.O000Oo00 = nanoTime;
            Interpolator interpolator = this.O00000o0;
            if (interpolator != null && !z2) {
                if (this.O00O0Oo) {
                    float interpolation = interpolator.getInterpolation(((float) (nanoTime - this.O000OOoo)) * 1.0E-9f);
                    this.O0000o0 = interpolation;
                    this.O000Oo00 = nanoTime;
                    Interpolator interpolator2 = this.O00000o0;
                    if (interpolator2 instanceof oO0O0o0o) {
                        float O000000o2 = ((oO0O0o0o) interpolator2).O000000o();
                        this.O00000o = O000000o2;
                        if (Math.abs(O000000o2) * this.O0000Ooo <= 1.0E-5f) {
                            this.O0000o0o = false;
                        }
                        if (O000000o2 > 0.0f && interpolation >= 1.0f) {
                            this.O0000o0 = 1.0f;
                            this.O0000o0o = false;
                            interpolation = 1.0f;
                        }
                        if (O000000o2 < 0.0f && interpolation <= 0.0f) {
                            this.O0000o0 = 0.0f;
                            this.O0000o0o = false;
                            f3 = 0.0f;
                        }
                    }
                    f3 = interpolation;
                } else {
                    float interpolation2 = interpolator.getInterpolation(f3);
                    Interpolator interpolator3 = this.O00000o0;
                    if (interpolator3 instanceof oO0O0o0o) {
                        this.O00000o = ((oO0O0o0o) interpolator3).O000000o();
                    } else {
                        this.O00000o = ((interpolator3.getInterpolation(f3 + f) - interpolation2) * signum) / f;
                    }
                    f3 = interpolation2;
                }
            }
            if (Math.abs(this.O00000o) > 1.0E-5f) {
                setState(TransitionState.MOVING);
            }
            if ((signum > 0.0f && f3 >= this.O0000o0O) || (signum <= 0.0f && f3 <= this.O0000o0O)) {
                f3 = this.O0000o0O;
                this.O0000o0o = false;
            }
            if (f3 >= 1.0f || f3 <= 0.0f) {
                this.O0000o0o = false;
                setState(TransitionState.FINISHED);
            }
            int childCount = getChildCount();
            this.O000Ooo0 = false;
            long nanoTime2 = getNanoTime();
            this.O000OOOo = f3;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                oO0Oo0O0 oo0oo0o0 = this.O0000OoO.get(childAt);
                if (oo0oo0o0 != null) {
                    this.O000Ooo0 |= oo0oo0o0.O000000o(childAt, f3, nanoTime2, this.O000o0);
                }
            }
            boolean z4 = (signum > 0.0f && f3 >= this.O0000o0O) || (signum <= 0.0f && f3 <= this.O0000o0O);
            if (!this.O000Ooo0 && !this.O0000o0o && z4) {
                setState(TransitionState.FINISHED);
            }
            if (this.O000O0o0) {
                requestLayout();
            }
            this.O000Ooo0 = (!z4) | this.O000Ooo0;
            if (!(f3 > 0.0f || (i2 = this.O00000oO) == -1 || this.O00000oo == i2)) {
                this.O00000oo = i2;
                this.O00000Oo.O000000o(i2).O00000o(this);
                setState(TransitionState.FINISHED);
                z3 = true;
            }
            if (((double) f3) >= 1.0d && this.O00000oo != (i = this.O0000O0o)) {
                this.O00000oo = i;
                this.O00000Oo.O000000o(i).O00000o(this);
                setState(TransitionState.FINISHED);
                z3 = true;
            }
            if (this.O000Ooo0 || this.O0000o0o) {
                invalidate();
            } else if ((signum > 0.0f && f3 == 1.0f) || (signum < 0.0f && f3 == 0.0f)) {
                setState(TransitionState.FINISHED);
            }
            if ((!this.O000Ooo0 && this.O0000o0o && signum > 0.0f && f3 == 1.0f) || (signum < 0.0f && f3 == 0.0f)) {
                O00000oO();
            }
        }
        float f4 = this.O0000o0;
        if (f4 >= 1.0f) {
            if (this.O00000oo != this.O0000O0o) {
                z3 = true;
            }
            this.O00000oo = this.O0000O0o;
        } else if (f4 <= 0.0f) {
            if (this.O00000oo != this.O00000oO) {
                z3 = true;
            }
            this.O00000oo = this.O00000oO;
        }
        this.O000o0OO |= z3;
        if (z3 && !this.O000o0O0) {
            requestLayout();
        }
        this.O0000o00 = this.O0000o0;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.O000o0O0 = true;
        try {
            if (this.O00000Oo == null) {
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (!(this.O0000oo == i5 && this.O0000ooO == i6)) {
                O0000Oo0();
                O000000o(true);
            }
            this.O0000oo = i5;
            this.O0000ooO = i6;
            this.O0000oOo = i5;
            this.O0000oo0 = i6;
            this.O000o0O0 = false;
        } finally {
            this.O000o0O0 = false;
        }
    }

    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = null;
    }

    private void O000000o(AttributeSet attributeSet) {
        oO00O0Oo oo00o0oo;
        String str;
        String str2;
        f2778O000000o = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.applyMotionScene, R.attr.currentState, R.attr.layoutDescription, R.attr.motionDebug, R.attr.motionProgress, R.attr.showPaths});
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z = true;
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i2 = 2;
                if (index == 2) {
                    this.O00000Oo = new oO00O0Oo(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == 1) {
                    this.O00000oo = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == 4) {
                    this.O0000o0O = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.O0000o0o = true;
                } else if (index == 0) {
                    z = obtainStyledAttributes.getBoolean(index, z);
                } else if (index == 5) {
                    if (this.O0000oO0 == 0) {
                        if (!obtainStyledAttributes.getBoolean(index, false)) {
                            i2 = 0;
                        }
                        this.O0000oO0 = i2;
                    }
                } else if (index == 3) {
                    this.O0000oO0 = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.O00000Oo == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z) {
                this.O00000Oo = null;
            }
        }
        if (this.O0000oO0 != 0) {
            oO00O0Oo oo00o0oo2 = this.O00000Oo;
            if (oo00o0oo2 == null) {
                Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            } else {
                int O00000Oo2 = oo00o0oo2.O00000Oo();
                oO00O0Oo oo00o0oo3 = this.O00000Oo;
                oOO0OOo0 O000000o2 = oo00o0oo3.O000000o(oo00o0oo3.O00000Oo());
                String O000000o3 = oO00000o.O000000o(getContext(), O00000Oo2);
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    int id = childAt.getId();
                    if (id == -1) {
                        Log.w("MotionLayout", "CHECK: " + O000000o3 + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
                    }
                    if ((O000000o2.O00000o.containsKey(Integer.valueOf(id)) ? O000000o2.O00000o.get(Integer.valueOf(id)) : null) == null) {
                        Log.w("MotionLayout", "CHECK: " + O000000o3 + " NO CONSTRAINTS for " + oO00000o.O000000o(childAt));
                    }
                }
                int[] O000000o4 = O000000o2.O000000o();
                for (int i4 = 0; i4 < O000000o4.length; i4++) {
                    int i5 = O000000o4[i4];
                    String O000000o5 = oO00000o.O000000o(getContext(), i5);
                    if (findViewById(O000000o4[i4]) == null) {
                        Log.w("MotionLayout", "CHECK: " + O000000o3 + " NO View matches id " + O000000o5);
                    }
                    if (O000000o2.O00000o(i5) == -1) {
                        Log.w("MotionLayout", "CHECK: " + O000000o3 + "(" + O000000o5 + ") no LAYOUT_HEIGHT");
                    }
                    if (O000000o2.O00000oO(i5) == -1) {
                        Log.w("MotionLayout", "CHECK: " + O000000o3 + "(" + O000000o5 + ") no LAYOUT_HEIGHT");
                    }
                }
                SparseIntArray sparseIntArray = new SparseIntArray();
                SparseIntArray sparseIntArray2 = new SparseIntArray();
                Iterator<oO00O0Oo.O000000o> it = this.O00000Oo.O00000o.iterator();
                while (it.hasNext()) {
                    oO00O0Oo.O000000o next = it.next();
                    if (next == this.O00000Oo.O00000o0) {
                        Log.v("MotionLayout", "CHECK: CURRENT");
                    }
                    StringBuilder sb = new StringBuilder("CHECK: transition = ");
                    Context context = getContext();
                    if (next.O00000o == -1) {
                        str = "null";
                    } else {
                        str = context.getResources().getResourceEntryName(next.O00000o);
                    }
                    if (next.O00000o0 == -1) {
                        str2 = str + " -> null";
                    } else {
                        str2 = str + " -> " + context.getResources().getResourceEntryName(next.O00000o0);
                    }
                    sb.append(str2);
                    Log.v("MotionLayout", sb.toString());
                    Log.v("MotionLayout", "CHECK: transition.setDuration = " + next.O0000OOo);
                    if (next.O00000o == next.O00000o0) {
                        Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
                    }
                    int i6 = next.O00000o;
                    int i7 = next.O00000o0;
                    String O000000o6 = oO00000o.O000000o(getContext(), i6);
                    String O000000o7 = oO00000o.O000000o(getContext(), i7);
                    if (sparseIntArray.get(i6) == i7) {
                        Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + O000000o6 + "->" + O000000o7);
                    }
                    if (sparseIntArray2.get(i7) == i6) {
                        Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + O000000o6 + "->" + O000000o7);
                    }
                    sparseIntArray.put(i6, i7);
                    sparseIntArray2.put(i7, i6);
                    if (this.O00000Oo.O000000o(i6) == null) {
                        Log.e("MotionLayout", " no such constraintSetStart ".concat(String.valueOf(O000000o6)));
                    }
                    if (this.O00000Oo.O000000o(i7) == null) {
                        Log.e("MotionLayout", " no such constraintSetEnd ".concat(String.valueOf(O000000o6)));
                    }
                }
            }
        }
        if (this.O00000oo == -1 && (oo00o0oo = this.O00000Oo) != null) {
            this.O00000oo = oo00o0oo.O00000Oo();
            this.O00000oO = this.O00000Oo.O00000Oo();
            this.O0000O0o = this.O00000Oo.O00000o0();
        }
    }

    public void setScene(oO00O0Oo oo00o0oo) {
        this.O00000Oo = oo00o0oo;
        this.O00000Oo.O000000o(isRtl());
        O0000Oo0();
    }

    public void setDebugMode(int i) {
        this.O0000oO0 = i;
        invalidate();
    }

    private boolean O000000o(float f, float f2, View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (O000000o(((float) view.getLeft()) + f, ((float) view.getTop()) + f2, viewGroup.getChildAt(i), motionEvent)) {
                    return true;
                }
            }
        }
        this.O000o0Oo.set(((float) view.getLeft()) + f, ((float) view.getTop()) + f2, f + ((float) view.getRight()), f2 + ((float) view.getBottom()));
        if (motionEvent.getAction() == 0) {
            return this.O000o0Oo.contains(motionEvent.getX(), motionEvent.getY()) && view.onTouchEvent(motionEvent);
        }
        if (view.onTouchEvent(motionEvent)) {
            return true;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        oO00O0Oo.O000000o o000000o;
        oOo00OO0 ooo00oo0;
        int i;
        RectF O000000o2;
        oO00O0Oo oo00o0oo = this.O00000Oo;
        if (oo00o0oo != null && this.O0000Oo && (o000000o = oo00o0oo.O00000o0) != null && o000000o.O000000o() && (ooo00oo0 = o000000o.O0000Ooo) != null && ((motionEvent.getAction() != 0 || (O000000o2 = ooo00oo0.O000000o(this, new RectF())) == null || O000000o2.contains(motionEvent.getX(), motionEvent.getY())) && (i = ooo00oo0.O00000o0) != -1)) {
            View view = this.O000o0o0;
            if (view == null || view.getId() != i) {
                this.O000o0o0 = findViewById(i);
            }
            View view2 = this.O000o0o0;
            if (view2 != null) {
                this.O000o0Oo.set((float) view2.getLeft(), (float) this.O000o0o0.getTop(), (float) this.O000o0o0.getRight(), (float) this.O000o0o0.getBottom());
                if (this.O000o0Oo.contains(motionEvent.getX(), motionEvent.getY()) && !O000000o(0.0f, 0.0f, this.O000o0o0, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        oO00O0Oo oo00o0oo = this.O00000Oo;
        if (oo00o0oo == null || !this.O0000Oo || !oo00o0oo.O000000o()) {
            return super.onTouchEvent(motionEvent);
        }
        oO00O0Oo.O000000o o000000o = this.O00000Oo.O00000o0;
        if (o000000o != null && !o000000o.O000000o()) {
            return super.onTouchEvent(motionEvent);
        }
        this.O00000Oo.O000000o(motionEvent, getCurrentState(), this);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        int i;
        super.onAttachedToWindow();
        oO00O0Oo oo00o0oo = this.O00000Oo;
        if (!(oo00o0oo == null || (i = this.O00000oo) == -1)) {
            oOO0OOo0 O000000o2 = oo00o0oo.O000000o(i);
            this.O00000Oo.O000000o(this);
            if (O000000o2 != null) {
                O000000o2.O00000o0(this);
            }
            this.O00000oO = this.O00000oo;
        }
        O00000oO();
        O0000OOo o0000OOo = this.O000o0O;
        if (o0000OOo != null) {
            o0000OOo.O000000o();
        }
    }

    public void onRtlPropertiesChanged(int i) {
        oO00O0Oo oo00o0oo = this.O00000Oo;
        if (oo00o0oo != null) {
            oo00o0oo.O000000o(isRtl());
        }
    }

    private void O00000oO() {
        oO00O0Oo oo00o0oo = this.O00000Oo;
        if (oo00o0oo != null) {
            if (oo00o0oo.O00000Oo(this, this.O00000oo)) {
                requestLayout();
                return;
            }
            int i = this.O00000oo;
            if (i != -1) {
                this.O00000Oo.O000000o(this, i);
            }
            if (this.O00000Oo.O000000o()) {
                this.O00000Oo.O0000Oo0();
            }
        }
    }

    public int getCurrentState() {
        return this.O00000oo;
    }

    public float getProgress() {
        return this.O0000o0;
    }

    public final void O000000o(int i, float f, float f2, float f3, float[] fArr) {
        String str;
        HashMap<View, oO0Oo0O0> hashMap = this.O0000OoO;
        View viewById = getViewById(i);
        oO0Oo0O0 oo0oo0o0 = hashMap.get(viewById);
        if (oo0oo0o0 != null) {
            oo0oo0o0.O000000o(f, f2, f3, fArr);
            float y = viewById.getY();
            this.O000Oo0o = f;
            this.O000OoO0 = y;
            return;
        }
        if (viewById == null) {
            str = String.valueOf(i);
        } else {
            str = viewById.getContext().getResources().getResourceName(i);
        }
        Log.w("MotionLayout", "WARNING could not find view id ".concat(String.valueOf(str)));
    }

    public long getTransitionTimeMs() {
        oO00O0Oo oo00o0oo = this.O00000Oo;
        if (oo00o0oo != null) {
            this.O0000Ooo = ((float) oo00o0oo.O00000oO()) / 1000.0f;
        }
        return (long) (this.O0000Ooo * 1000.0f);
    }

    public void setTransitionListener(O0000Oo0 o0000Oo0) {
        this.O000Oo0O = o0000Oo0;
    }

    private void O00000oo() {
        ArrayList<O0000Oo0> arrayList;
        if ((this.O000Oo0O != null || ((arrayList = this.O000O0Oo) != null && !arrayList.isEmpty())) && this.O000o00o != this.O0000o00) {
            if (this.O000o00O != -1) {
                ArrayList<O0000Oo0> arrayList2 = this.O000O0Oo;
                if (arrayList2 != null) {
                    Iterator<O0000Oo0> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                this.O00oOoOo = true;
            }
            this.O000o00O = -1;
            this.O000o00o = this.O0000o00;
            ArrayList<O0000Oo0> arrayList3 = this.O000O0Oo;
            if (arrayList3 != null) {
                Iterator<O0000Oo0> it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
            }
            this.O00oOoOo = true;
        }
    }

    private void O0000O0o() {
        int i;
        ArrayList<O0000Oo0> arrayList;
        if ((this.O000Oo0O != null || ((arrayList = this.O000O0Oo) != null && !arrayList.isEmpty())) && this.O000o00O == -1) {
            this.O000o00O = this.O00000oo;
            if (!this.O000OOoO.isEmpty()) {
                ArrayList<Integer> arrayList2 = this.O000OOoO;
                i = arrayList2.get(arrayList2.size() - 1).intValue();
            } else {
                i = -1;
            }
            int i2 = this.O00000oo;
            if (!(i == i2 || i2 == -1)) {
                this.O000OOoO.add(Integer.valueOf(i2));
            }
        }
        O0000OOo();
    }

    private void O0000OOo() {
        ArrayList<O0000Oo0> arrayList;
        if (this.O000Oo0O != null || ((arrayList = this.O000O0Oo) != null && !arrayList.isEmpty())) {
            this.O00oOoOo = false;
            Iterator<Integer> it = this.O000OOoO.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (this.O000Oo0O != null) {
                    next.intValue();
                }
                ArrayList<O0000Oo0> arrayList2 = this.O000O0Oo;
                if (arrayList2 != null) {
                    Iterator<O0000Oo0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next();
                        next.intValue();
                    }
                }
            }
            this.O000OOoO.clear();
        }
    }

    public oO0000Oo getDesignTool() {
        if (this.O000OoOo == null) {
            this.O000OoOo = new oO0000Oo(this);
        }
        return this.O000OoOo;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.O000O0Oo == null) {
                this.O000O0Oo = new ArrayList<>();
            }
            this.O000O0Oo.add(motionHelper);
            if (motionHelper.f2777O000000o) {
                if (this.O000Ooo == null) {
                    this.O000Ooo = new ArrayList<>();
                }
                this.O000Ooo.add(motionHelper);
            }
            if (motionHelper.O00000Oo) {
                if (this.O000OooO == null) {
                    this.O000OooO = new ArrayList<>();
                }
                this.O000OooO.add(motionHelper);
            }
        }
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.O000Ooo;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.O000OooO;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public void setOnShow(float f) {
        ArrayList<MotionHelper> arrayList = this.O000Ooo;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.O000Ooo.get(i).setProgress(f);
            }
        }
    }

    public void setOnHide(float f) {
        ArrayList<MotionHelper> arrayList = this.O000OooO;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.O000OooO.get(i).setProgress(f);
            }
        }
    }

    public int[] getConstraintSetIds() {
        oO00O0Oo oo00o0oo = this.O00000Oo;
        if (oo00o0oo == null) {
            return null;
        }
        int[] iArr = new int[oo00o0oo.O00000oO.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = oo00o0oo.O00000oO.keyAt(i);
        }
        return iArr;
    }

    private void O0000Oo0() {
        this.O000OOo.O000000o();
        invalidate();
    }

    public ArrayList<oO00O0Oo.O000000o> getDefinedTransitions() {
        oO00O0Oo oo00o0oo = this.O00000Oo;
        if (oo00o0oo == null) {
            return null;
        }
        return oo00o0oo.O00000o;
    }

    public int getStartState() {
        return this.O00000oO;
    }

    public int getEndState() {
        return this.O0000O0o;
    }

    public float getTargetPosition() {
        return this.O0000o0O;
    }

    public void setTransitionDuration(int i) {
        oO00O0Oo oo00o0oo = this.O00000Oo;
        if (oo00o0oo == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else if (oo00o0oo.O00000o0 != null) {
            oo00o0oo.O00000o0.O0000OOo = i;
        } else {
            oo00o0oo.O00000oo = i;
        }
    }

    public void setInteractionEnabled(boolean z) {
        this.O0000Oo = z;
    }
}
