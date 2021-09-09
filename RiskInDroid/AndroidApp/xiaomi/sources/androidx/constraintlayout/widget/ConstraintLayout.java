package androidx.constraintlayout.widget;

import _m_j.oO00Oo00;
import _m_j.oO0O000o;
import _m_j.oOO0OO0O;
import _m_j.oOO0OOo0;
import _m_j.oOO0Oo00;
import _m_j.oOOoOOO0;
import _m_j.oOo0000O;
import _m_j.oOo0oooO;
import _m_j.ooOOO0Oo;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.HashMap;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class ConstraintLayout extends ViewGroup {
    SparseArray<View> mChildrenByIds = new SparseArray<>();
    public ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList<>(4);
    protected oOO0OO0O mConstraintLayoutSpec = null;
    private oOO0OOo0 mConstraintSet = null;
    private int mConstraintSetId = -1;
    private oOO0Oo00 mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds = new HashMap<>();
    protected boolean mDirtyHierarchy = true;
    private int mLastMeasureHeight = -1;
    int mLastMeasureHeightMode = 0;
    int mLastMeasureHeightSize = -1;
    private int mLastMeasureWidth = -1;
    int mLastMeasureWidthMode = 0;
    int mLastMeasureWidthSize = -1;
    public oOo0000O mLayoutWidget = new oOo0000O();
    private int mMaxHeight = Integer.MAX_VALUE;
    private int mMaxWidth = Integer.MAX_VALUE;
    O000000o mMeasurer = new O000000o(this);
    private oOOoOOO0 mMetrics;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private int mOnMeasureHeightMeasureSpec = 0;
    private int mOnMeasureWidthMeasureSpec = 0;
    private int mOptimizationLevel = 263;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget = new SparseArray<>();

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.mDesignIds;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public ConstraintLayout(Context context) {
        super(context);
        init(null, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet, i, i2);
    }

    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    class O000000o implements ooOOO0Oo.O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        ConstraintLayout f2806O000000o;
        int O00000Oo;
        int O00000o;
        int O00000o0;
        int O00000oO;
        int O00000oo;
        int O0000O0o;

        public O000000o(ConstraintLayout constraintLayout) {
            this.f2806O000000o = constraintLayout;
        }

        public final void O000000o() {
            int childCount = this.f2806O000000o.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f2806O000000o.getChildAt(i);
                if (childAt instanceof Placeholder) {
                    Placeholder placeholder = (Placeholder) childAt;
                    if (placeholder.O00000Oo != null) {
                        LayoutParams layoutParams = (LayoutParams) placeholder.getLayoutParams();
                        LayoutParams layoutParams2 = (LayoutParams) placeholder.O00000Oo.getLayoutParams();
                        layoutParams2.O000o0o0.O000o0O = 0;
                        if (layoutParams.O000o0o0.O000Oo00[0] != ConstraintWidget.DimensionBehaviour.FIXED) {
                            layoutParams.O000o0o0.O00000oO(layoutParams2.O000o0o0.O00000oO());
                        }
                        if (layoutParams.O000o0o0.O000Oo00[1] != ConstraintWidget.DimensionBehaviour.FIXED) {
                            layoutParams.O000o0o0.O00000oo(layoutParams2.O000o0o0.O00000oo());
                        }
                        layoutParams2.O000o0o0.O000o0O = 8;
                    }
                }
            }
            int size = this.f2806O000000o.mConstraintHelpers.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    this.f2806O000000o.mConstraintHelpers.get(i2);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:104:0x0176  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x0181  */
        /* JADX WARNING: Removed duplicated region for block: B:115:0x0194 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x01ad  */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x01cc  */
        /* JADX WARNING: Removed duplicated region for block: B:131:0x01d9  */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x01e7  */
        /* JADX WARNING: Removed duplicated region for block: B:134:0x01f3  */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x0202  */
        /* JADX WARNING: Removed duplicated region for block: B:138:0x0209  */
        /* JADX WARNING: Removed duplicated region for block: B:141:0x020e  */
        /* JADX WARNING: Removed duplicated region for block: B:144:0x0218  */
        /* JADX WARNING: Removed duplicated region for block: B:145:0x021f  */
        /* JADX WARNING: Removed duplicated region for block: B:148:0x0224  */
        /* JADX WARNING: Removed duplicated region for block: B:151:0x022e A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:158:0x0247 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:162:0x024f  */
        /* JADX WARNING: Removed duplicated region for block: B:163:0x0256  */
        /* JADX WARNING: Removed duplicated region for block: B:165:0x025a  */
        /* JADX WARNING: Removed duplicated region for block: B:168:0x0271  */
        /* JADX WARNING: Removed duplicated region for block: B:169:0x0273  */
        /* JADX WARNING: Removed duplicated region for block: B:172:0x0278  */
        /* JADX WARNING: Removed duplicated region for block: B:178:0x0286  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00ca  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x0141  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0151  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0153  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x0158  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x015a  */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x015f  */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x016b  */
        @SuppressLint({"WrongCall"})
        public final void O000000o(ConstraintWidget constraintWidget, ooOOO0Oo.O000000o o000000o) {
            boolean z;
            int i;
            int i2;
            boolean z2;
            int i3;
            boolean z3;
            LayoutParams layoutParams;
            int i4;
            int i5;
            int i6;
            int i7;
            int measuredWidth;
            int measuredHeight;
            int i8;
            int max;
            int max2;
            int i9;
            int i10;
            int i11;
            ConstraintWidget constraintWidget2 = constraintWidget;
            ooOOO0Oo.O000000o o000000o2 = o000000o;
            if (constraintWidget2 != null) {
                if (constraintWidget2.O000o0O != 8 || constraintWidget2.O00oOoOo) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = o000000o2.f2363O000000o;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = o000000o2.O00000Oo;
                    int i12 = o000000o2.O00000o0;
                    int i13 = o000000o2.O00000o;
                    int i14 = this.O00000Oo + this.O00000o0;
                    int i15 = this.O00000o;
                    View view = (View) constraintWidget2.O000o0O0;
                    int i16 = AnonymousClass1.f2803O000000o[dimensionBehaviour.ordinal()];
                    if (i16 != 1) {
                        if (i16 == 2) {
                            i = ViewGroup.getChildMeasureSpec(this.O00000oo, i15, -2);
                            constraintWidget2.O0000OoO[2] = -2;
                        } else if (i16 == 3) {
                            int i17 = this.O00000oo;
                            int i18 = constraintWidget2.O000O0o != null ? constraintWidget2.O000O0o.O00000o + 0 : 0;
                            if (constraintWidget2.O000O0oo != null) {
                                i18 += constraintWidget2.O000O0oo.O00000o;
                            }
                            i11 = ViewGroup.getChildMeasureSpec(i17, i15 + i18, -1);
                            constraintWidget2.O0000OoO[2] = -1;
                        } else if (i16 != 4) {
                            i11 = 0;
                        } else {
                            i = ViewGroup.getChildMeasureSpec(this.O00000oo, i15, -2);
                            boolean z4 = constraintWidget2.O0000o0O == 1;
                            constraintWidget2.O0000OoO[2] = 0;
                            if (o000000o2.O0000Oo) {
                                boolean z5 = !(!z4 || constraintWidget2.O0000OoO[3] == 0 || constraintWidget2.O0000OoO[0] == constraintWidget.O00000oO()) || (view instanceof Placeholder);
                                if (!z4 || z5) {
                                    i11 = View.MeasureSpec.makeMeasureSpec(constraintWidget.O00000oO(), 1073741824);
                                }
                            }
                        }
                        z = true;
                        i2 = AnonymousClass1.f2803O000000o[dimensionBehaviour2.ordinal()];
                        if (i2 == 1) {
                            if (i2 == 2) {
                                i3 = ViewGroup.getChildMeasureSpec(this.O0000O0o, i14, -2);
                                constraintWidget2.O0000OoO[3] = -2;
                            } else if (i2 == 3) {
                                int i19 = this.O0000O0o;
                                int i20 = constraintWidget2.O000O0o != null ? constraintWidget2.O000O0oO.O00000o + 0 : 0;
                                if (constraintWidget2.O000O0oo != null) {
                                    i20 += constraintWidget2.O000OO00.O00000o;
                                }
                                i10 = ViewGroup.getChildMeasureSpec(i19, i14 + i20, -1);
                                constraintWidget2.O0000OoO[3] = -1;
                            } else if (i2 != 4) {
                                i10 = 0;
                            } else {
                                i3 = ViewGroup.getChildMeasureSpec(this.O0000O0o, i14, -2);
                                boolean z6 = constraintWidget2.O0000o0o == 1;
                                constraintWidget2.O0000OoO[3] = 0;
                                if (o000000o2.O0000Oo) {
                                    boolean z7 = !(!z6 || constraintWidget2.O0000OoO[2] == 0 || constraintWidget2.O0000OoO[1] == constraintWidget.O00000oo()) || (view instanceof Placeholder);
                                    if (!z6 || z7) {
                                        i10 = View.MeasureSpec.makeMeasureSpec(constraintWidget.O00000oo(), 1073741824);
                                    }
                                }
                            }
                            z2 = true;
                            boolean z8 = dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                            boolean z9 = dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                            boolean z10 = dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED;
                            boolean z11 = dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED;
                            z3 = !z8 && constraintWidget2.O000OoO0 > 0.0f;
                            boolean z12 = !z9 && constraintWidget2.O000OoO0 > 0.0f;
                            layoutParams = (LayoutParams) view.getLayoutParams();
                            if (!o000000o2.O0000Oo || !z8 || constraintWidget2.O0000o0O != 0 || !z9 || constraintWidget2.O0000o0o != 0) {
                                if ((view instanceof VirtualLayout) || !(constraintWidget2 instanceof oOo0oooO)) {
                                    view.measure(i, i3);
                                } else {
                                    ((VirtualLayout) view).O000000o((oOo0oooO) constraintWidget2, i, i3);
                                }
                                measuredWidth = view.getMeasuredWidth();
                                measuredHeight = view.getMeasuredHeight();
                                i4 = view.getBaseline();
                                if (z) {
                                    i8 = 0;
                                    constraintWidget2.O0000OoO[0] = measuredWidth;
                                    constraintWidget2.O0000OoO[2] = measuredHeight;
                                } else {
                                    i8 = 0;
                                    constraintWidget2.O0000OoO[0] = 0;
                                    constraintWidget2.O0000OoO[2] = 0;
                                }
                                if (z2) {
                                    constraintWidget2.O0000OoO[1] = measuredHeight;
                                    constraintWidget2.O0000OoO[3] = measuredWidth;
                                } else {
                                    constraintWidget2.O0000OoO[1] = i8;
                                    constraintWidget2.O0000OoO[3] = i8;
                                }
                                max = constraintWidget2.O0000oO0 > 0 ? Math.max(constraintWidget2.O0000oO0, measuredWidth) : measuredWidth;
                                if (constraintWidget2.O0000oO > 0) {
                                    max = Math.min(constraintWidget2.O0000oO, max);
                                }
                                max2 = constraintWidget2.O0000oOo > 0 ? Math.max(constraintWidget2.O0000oOo, measuredHeight) : measuredHeight;
                                if (constraintWidget2.O0000oo0 > 0) {
                                    max2 = Math.min(constraintWidget2.O0000oo0, max2);
                                }
                                if (z3 || !z10) {
                                    if (z12 && z11) {
                                        max2 = (int) ((((float) max) / constraintWidget2.O000OoO0) + 0.5f);
                                    }
                                    i5 = max;
                                } else {
                                    i5 = (int) ((((float) max2) * constraintWidget2.O000OoO0) + 0.5f);
                                }
                                if (measuredWidth == i5 || measuredHeight != max2) {
                                    if (measuredWidth != i5) {
                                        i9 = 1073741824;
                                        i = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                                    } else {
                                        i9 = 1073741824;
                                    }
                                    if (measuredHeight != max2) {
                                        i3 = View.MeasureSpec.makeMeasureSpec(max2, i9);
                                    }
                                    view.measure(i, i3);
                                    i5 = view.getMeasuredWidth();
                                    i7 = view.getMeasuredHeight();
                                    i4 = view.getBaseline();
                                } else {
                                    i7 = max2;
                                }
                                i6 = -1;
                            } else {
                                i7 = 0;
                                i6 = -1;
                                i5 = 0;
                                i4 = 0;
                            }
                            boolean z13 = i4 != i6;
                            o000000o2.O0000Oo0 = i5 == o000000o2.O00000o0 || i7 != o000000o2.O00000o;
                            if (layoutParams.O000OoOO) {
                                z13 = true;
                            }
                            if (!(!z13 || i4 == -1 || constraintWidget2.O000Oooo == i4)) {
                                o000000o2.O0000Oo0 = true;
                            }
                            o000000o2.O00000oO = i5;
                            o000000o2.O00000oo = i7;
                            o000000o2.O0000OOo = z13;
                            o000000o2.O0000O0o = i4;
                            return;
                        }
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                        constraintWidget2.O0000OoO[3] = i13;
                        i10 = makeMeasureSpec;
                        z2 = false;
                        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        }
                        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        }
                        if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        }
                        if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        }
                        if (!z8) {
                        }
                        if (!z9) {
                        }
                        layoutParams = (LayoutParams) view.getLayoutParams();
                        if (!o000000o2.O0000Oo) {
                        }
                        if (view instanceof VirtualLayout) {
                        }
                        view.measure(i, i3);
                        measuredWidth = view.getMeasuredWidth();
                        measuredHeight = view.getMeasuredHeight();
                        i4 = view.getBaseline();
                        if (z) {
                        }
                        if (z2) {
                        }
                        if (constraintWidget2.O0000oO0 > 0) {
                        }
                        if (constraintWidget2.O0000oO > 0) {
                        }
                        if (constraintWidget2.O0000oOo > 0) {
                        }
                        if (constraintWidget2.O0000oo0 > 0) {
                        }
                        if (z3) {
                        }
                        max2 = (int) ((((float) max) / constraintWidget2.O000OoO0) + 0.5f);
                        i5 = max;
                        if (measuredWidth == i5) {
                        }
                        if (measuredWidth != i5) {
                        }
                        if (measuredHeight != max2) {
                        }
                        view.measure(i, i3);
                        i5 = view.getMeasuredWidth();
                        i7 = view.getMeasuredHeight();
                        i4 = view.getBaseline();
                        i6 = -1;
                        if (i4 != i6) {
                        }
                        o000000o2.O0000Oo0 = i5 == o000000o2.O00000o0 || i7 != o000000o2.O00000o;
                        if (layoutParams.O000OoOO) {
                        }
                        o000000o2.O0000Oo0 = true;
                        o000000o2.O00000oO = i5;
                        o000000o2.O00000oo = i7;
                        o000000o2.O0000OOo = z13;
                        o000000o2.O0000O0o = i4;
                        return;
                    }
                    int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                    constraintWidget2.O0000OoO[2] = i12;
                    i11 = makeMeasureSpec2;
                    z = false;
                    i2 = AnonymousClass1.f2803O000000o[dimensionBehaviour2.ordinal()];
                    if (i2 == 1) {
                    }
                    z2 = false;
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    }
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    }
                    if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                    }
                    if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                    }
                    if (!z8) {
                    }
                    if (!z9) {
                    }
                    layoutParams = (LayoutParams) view.getLayoutParams();
                    if (!o000000o2.O0000Oo) {
                    }
                    if (view instanceof VirtualLayout) {
                    }
                    view.measure(i, i3);
                    measuredWidth = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    i4 = view.getBaseline();
                    if (z) {
                    }
                    if (z2) {
                    }
                    if (constraintWidget2.O0000oO0 > 0) {
                    }
                    if (constraintWidget2.O0000oO > 0) {
                    }
                    if (constraintWidget2.O0000oOo > 0) {
                    }
                    if (constraintWidget2.O0000oo0 > 0) {
                    }
                    if (z3) {
                    }
                    max2 = (int) ((((float) max) / constraintWidget2.O000OoO0) + 0.5f);
                    i5 = max;
                    if (measuredWidth == i5) {
                    }
                    if (measuredWidth != i5) {
                    }
                    if (measuredHeight != max2) {
                    }
                    view.measure(i, i3);
                    i5 = view.getMeasuredWidth();
                    i7 = view.getMeasuredHeight();
                    i4 = view.getBaseline();
                    i6 = -1;
                    if (i4 != i6) {
                    }
                    o000000o2.O0000Oo0 = i5 == o000000o2.O00000o0 || i7 != o000000o2.O00000o;
                    if (layoutParams.O000OoOO) {
                    }
                    o000000o2.O0000Oo0 = true;
                    o000000o2.O00000oO = i5;
                    o000000o2.O00000oo = i7;
                    o000000o2.O0000OOo = z13;
                    o000000o2.O0000O0o = i4;
                    return;
                }
                o000000o2.O00000oO = 0;
                o000000o2.O00000oo = 0;
                o000000o2.O0000O0o = 0;
            }
        }
    }

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f2803O000000o = new int[ConstraintWidget.DimensionBehaviour.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f2803O000000o[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            f2803O000000o[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            f2803O000000o[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            try {
                f2803O000000o[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void init(AttributeSet attributeSet, int i, int i2) {
        oOo0000O ooo0000o = this.mLayoutWidget;
        ooo0000o.O000o0O0 = this;
        ooo0000o.O000000o(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{16842948, 16842965, 16842966, 16842967, 16842968, 16842969, 16842972, 16843039, 16843040, 16843071, 16843072, 16843699, 16843700, 16843840, R.attr.barrierAllowsGoneWidgets, R.attr.barrierDirection, R.attr.barrierMargin, R.attr.chainUseRtl, R.attr.constraintSet, R.attr.constraint_referenced_ids, R.attr.flow_firstHorizontalBias, R.attr.flow_firstHorizontalStyle, R.attr.flow_firstVerticalBias, R.attr.flow_firstVerticalStyle, R.attr.flow_horizontalAlign, R.attr.flow_horizontalBias, R.attr.flow_horizontalGap, R.attr.flow_horizontalStyle, R.attr.flow_lastHorizontalBias, R.attr.flow_lastHorizontalStyle, R.attr.flow_lastVerticalBias, R.attr.flow_lastVerticalStyle, R.attr.flow_maxElementsWrap, R.attr.flow_verticalAlign, R.attr.flow_verticalBias, R.attr.flow_verticalGap, R.attr.flow_verticalStyle, R.attr.flow_wrapMode, R.attr.layoutDescription, R.attr.layout_constrainedHeight, R.attr.layout_constrainedWidth, R.attr.layout_constraintBaseline_creator, R.attr.layout_constraintBaseline_toBaselineOf, R.attr.layout_constraintBottom_creator, R.attr.layout_constraintBottom_toBottomOf, R.attr.layout_constraintBottom_toTopOf, R.attr.layout_constraintCircle, R.attr.layout_constraintCircleAngle, R.attr.layout_constraintCircleRadius, R.attr.layout_constraintDimensionRatio, R.attr.layout_constraintEnd_toEndOf, R.attr.layout_constraintEnd_toStartOf, R.attr.layout_constraintGuide_begin, R.attr.layout_constraintGuide_end, R.attr.layout_constraintGuide_percent, R.attr.layout_constraintHeight_default, R.attr.layout_constraintHeight_max, R.attr.layout_constraintHeight_min, R.attr.layout_constraintHeight_percent, R.attr.layout_constraintHorizontal_bias, R.attr.layout_constraintHorizontal_chainStyle, R.attr.layout_constraintHorizontal_weight, R.attr.layout_constraintLeft_creator, R.attr.layout_constraintLeft_toLeftOf, R.attr.layout_constraintLeft_toRightOf, R.attr.layout_constraintRight_creator, R.attr.layout_constraintRight_toLeftOf, R.attr.layout_constraintRight_toRightOf, R.attr.layout_constraintStart_toEndOf, R.attr.layout_constraintStart_toStartOf, R.attr.layout_constraintTag, R.attr.layout_constraintTop_creator, R.attr.layout_constraintTop_toBottomOf, R.attr.layout_constraintTop_toTopOf, R.attr.layout_constraintVertical_bias, R.attr.layout_constraintVertical_chainStyle, R.attr.layout_constraintVertical_weight, R.attr.layout_constraintWidth_default, R.attr.layout_constraintWidth_max, R.attr.layout_constraintWidth_min, R.attr.layout_constraintWidth_percent, R.attr.layout_editor_absoluteX, R.attr.layout_editor_absoluteY, R.attr.layout_goneMarginBottom, R.attr.layout_goneMarginEnd, R.attr.layout_goneMarginLeft, R.attr.layout_goneMarginRight, R.attr.layout_goneMarginStart, R.attr.layout_goneMarginTop, R.attr.layout_optimizationLevel}, i, i2);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == 9) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == 10) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == 7) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == 8) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == 89) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == 38) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == 18) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.mConstraintSet = new oOO0OOo0();
                        this.mConstraintSet.O00000Oo(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.O0000o00(this.mOptimizationLevel);
    }

    /* access modifiers changed from: protected */
    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = new oOO0OO0O(getContext(), this, i);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof oO0O000o)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.O000o0o0 = new oO0O000o();
            layoutParams.O000OoOo = true;
            ((oO0O000o) layoutParams.O000o0o0).O0000o00(layoutParams.O000Oo0);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.O00000Oo();
            ((LayoutParams) view.getLayoutParams()).O000Ooo0 = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.O00000Oo(getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    public void setMinWidth(int i) {
        if (i != this.mMinWidth) {
            this.mMinWidth = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.mMinHeight) {
            this.mMinHeight = i;
            requestLayout();
        }
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public void setMaxWidth(int i) {
        if (i != this.mMaxWidth) {
            this.mMaxWidth = i;
            requestLayout();
        }
    }

    public void setMaxHeight(int i) {
        if (i != this.mMaxHeight) {
            this.mMaxHeight = i;
            requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    private boolean updateHierarchy() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            setChildrenConstraints();
        }
        return z;
    }

    private void setChildrenConstraints() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ConstraintWidget viewWidget = getViewWidget(getChildAt(i));
            if (viewWidget != null) {
                viewWidget.O00000Oo();
            }
        }
        if (isInEditMode) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).O000o0OO = resourceName;
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        oOO0OOo0 ooo0ooo0 = this.mConstraintSet;
        if (ooo0ooo0 != null) {
            ooo0ooo0.O00000oO(this);
        }
        this.mLayoutWidget.O00O0OoO.clear();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i4 = 0; i4 < size; i4++) {
                this.mConstraintHelpers.get(i4).O00000Oo(this);
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt3 = getChildAt(i5);
            if (childAt3 instanceof Placeholder) {
                Placeholder placeholder = (Placeholder) childAt3;
                if (placeholder.f2808O000000o == -1 && !placeholder.isInEditMode()) {
                    placeholder.setVisibility(placeholder.O00000o0);
                }
                placeholder.O00000Oo = findViewById(placeholder.f2808O000000o);
                if (placeholder.O00000Oo != null) {
                    ((LayoutParams) placeholder.O00000Oo.getLayoutParams()).O000Ooo = true;
                    placeholder.O00000Oo.setVisibility(0);
                    placeholder.setVisibility(0);
                }
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt4 = getChildAt(i6);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt5 = getChildAt(i7);
            ConstraintWidget viewWidget2 = getViewWidget(childAt5);
            if (viewWidget2 != null) {
                this.mLayoutWidget.O000000o(viewWidget2);
                applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, (LayoutParams) childAt5.getLayoutParams(), this.mTempMapIdToWidget);
            }
        }
    }

    public void applyConstraintsFromLayoutParams(boolean z, View view, ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        int i;
        int i2;
        int i3;
        float f;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        View view2 = view;
        ConstraintWidget constraintWidget6 = constraintWidget;
        LayoutParams layoutParams2 = layoutParams;
        SparseArray<ConstraintWidget> sparseArray2 = sparseArray;
        layoutParams.O000000o();
        int i4 = 0;
        layoutParams2.O000o0o = false;
        constraintWidget6.O000o0O = view.getVisibility();
        if (layoutParams2.O000Ooo) {
            constraintWidget6.O00oOoOo = true;
            constraintWidget6.O000o0O = 8;
        }
        constraintWidget6.O000o0O0 = view2;
        if (view2 instanceof ConstraintHelper) {
            ((ConstraintHelper) view2).O000000o(constraintWidget6, this.mLayoutWidget.O000oo);
        }
        if (layoutParams2.O000OoOo) {
            oO0O000o oo0o000o = (oO0O000o) constraintWidget6;
            int i5 = layoutParams2.O000o0O;
            int i6 = layoutParams2.O000o0OO;
            float f2 = layoutParams2.O000o0Oo;
            if (Build.VERSION.SDK_INT < 17) {
                i5 = layoutParams2.f2804O000000o;
                i6 = layoutParams2.O00000Oo;
                f2 = layoutParams2.O00000o0;
            }
            if (f2 != -1.0f) {
                oo0o000o.O000000o(f2);
            } else if (i5 != -1) {
                oo0o000o.O0000o0(i5);
            } else if (i6 != -1) {
                oo0o000o.O0000o0O(i6);
            }
        } else {
            int i7 = layoutParams2.O000Oooo;
            int i8 = layoutParams2.O000o000;
            int i9 = layoutParams2.O000o00;
            int i10 = layoutParams2.O000o00O;
            int i11 = layoutParams2.O000o00o;
            int i12 = layoutParams2.O000o0;
            float f3 = layoutParams2.O000o0O0;
            if (Build.VERSION.SDK_INT < 17) {
                i7 = layoutParams2.O00000o;
                i3 = layoutParams2.O00000oO;
                int i13 = layoutParams2.O00000oo;
                i10 = layoutParams2.O0000O0o;
                int i14 = layoutParams2.O0000oOO;
                int i15 = layoutParams2.O0000oo0;
                f3 = layoutParams2.O00oOooO;
                if (i7 == -1 && i3 == -1) {
                    if (layoutParams2.O0000o != -1) {
                        i7 = layoutParams2.O0000o;
                    } else if (layoutParams2.O0000o0o != -1) {
                        i3 = layoutParams2.O0000o0o;
                    }
                }
                if (i13 == -1 && i10 == -1) {
                    if (layoutParams2.O0000oO0 != -1) {
                        i13 = layoutParams2.O0000oO0;
                    } else if (layoutParams2.O0000oO != -1) {
                        i10 = layoutParams2.O0000oO;
                    }
                }
                i2 = i13;
                i = i15;
                i11 = i14;
            } else {
                i3 = i8;
                i = i12;
                i2 = i9;
            }
            float f4 = f3;
            int i16 = i10;
            float f5 = f4;
            if (layoutParams2.O0000o00 != -1) {
                ConstraintWidget constraintWidget7 = sparseArray2.get(layoutParams2.O0000o00);
                if (constraintWidget7 != null) {
                    float f6 = layoutParams2.O0000o0O;
                    constraintWidget.O000000o(ConstraintAnchor.Type.CENTER, constraintWidget7, ConstraintAnchor.Type.CENTER, layoutParams2.O0000o0, 0);
                    constraintWidget6.O000O0OO = f6;
                }
            } else {
                if (i7 != -1) {
                    ConstraintWidget constraintWidget8 = sparseArray2.get(i7);
                    if (constraintWidget8 != null) {
                        f = f5;
                        constraintWidget.O000000o(ConstraintAnchor.Type.LEFT, constraintWidget8, ConstraintAnchor.Type.LEFT, layoutParams2.leftMargin, i11);
                    } else {
                        f = f5;
                    }
                } else {
                    f = f5;
                    if (!(i3 == -1 || (constraintWidget5 = sparseArray2.get(i3)) == null)) {
                        constraintWidget.O000000o(ConstraintAnchor.Type.LEFT, constraintWidget5, ConstraintAnchor.Type.RIGHT, layoutParams2.leftMargin, i11);
                    }
                }
                if (i2 != -1) {
                    ConstraintWidget constraintWidget9 = sparseArray2.get(i2);
                    if (constraintWidget9 != null) {
                        constraintWidget.O000000o(ConstraintAnchor.Type.RIGHT, constraintWidget9, ConstraintAnchor.Type.LEFT, layoutParams2.rightMargin, i);
                    }
                } else if (!(i16 == -1 || (constraintWidget4 = sparseArray2.get(i16)) == null)) {
                    constraintWidget.O000000o(ConstraintAnchor.Type.RIGHT, constraintWidget4, ConstraintAnchor.Type.RIGHT, layoutParams2.rightMargin, i);
                }
                if (layoutParams2.O0000OOo != -1) {
                    ConstraintWidget constraintWidget10 = sparseArray2.get(layoutParams2.O0000OOo);
                    if (constraintWidget10 != null) {
                        constraintWidget.O000000o(ConstraintAnchor.Type.TOP, constraintWidget10, ConstraintAnchor.Type.TOP, layoutParams2.topMargin, layoutParams2.O0000oOo);
                    }
                } else if (!(layoutParams2.O0000Oo0 == -1 || (constraintWidget3 = sparseArray2.get(layoutParams2.O0000Oo0)) == null)) {
                    constraintWidget.O000000o(ConstraintAnchor.Type.TOP, constraintWidget3, ConstraintAnchor.Type.BOTTOM, layoutParams2.topMargin, layoutParams2.O0000oOo);
                }
                if (layoutParams2.O0000Oo != -1) {
                    ConstraintWidget constraintWidget11 = sparseArray2.get(layoutParams2.O0000Oo);
                    if (constraintWidget11 != null) {
                        constraintWidget.O000000o(ConstraintAnchor.Type.BOTTOM, constraintWidget11, ConstraintAnchor.Type.TOP, layoutParams2.bottomMargin, layoutParams2.O0000oo);
                    }
                } else if (!(layoutParams2.O0000OoO == -1 || (constraintWidget2 = sparseArray2.get(layoutParams2.O0000OoO)) == null)) {
                    constraintWidget.O000000o(ConstraintAnchor.Type.BOTTOM, constraintWidget2, ConstraintAnchor.Type.BOTTOM, layoutParams2.bottomMargin, layoutParams2.O0000oo);
                }
                if (layoutParams2.O0000Ooo != -1) {
                    View view3 = this.mChildrenByIds.get(layoutParams2.O0000Ooo);
                    ConstraintWidget constraintWidget12 = sparseArray2.get(layoutParams2.O0000Ooo);
                    if (!(constraintWidget12 == null || view3 == null || !(view3.getLayoutParams() instanceof LayoutParams))) {
                        LayoutParams layoutParams3 = (LayoutParams) view3.getLayoutParams();
                        layoutParams2.O000OoOO = true;
                        layoutParams3.O000OoOO = true;
                        constraintWidget6.O000000o(ConstraintAnchor.Type.BASELINE).O000000o(constraintWidget12.O000000o(ConstraintAnchor.Type.BASELINE), 0, -1, true);
                        constraintWidget6.O000O0Oo = true;
                        layoutParams3.O000o0o0.O000O0Oo = true;
                        constraintWidget6.O000000o(ConstraintAnchor.Type.TOP).O00000o();
                        constraintWidget6.O000000o(ConstraintAnchor.Type.BOTTOM).O00000o();
                    }
                }
                float f7 = f;
                if (f7 >= 0.0f) {
                    constraintWidget6.O000o00o = f7;
                }
                if (layoutParams2.O00oOooo >= 0.0f) {
                    constraintWidget6.O000o0 = layoutParams2.O00oOooo;
                }
            }
            if (z && !(layoutParams2.O000OOoo == -1 && layoutParams2.O000Oo00 == -1)) {
                constraintWidget6.O000000o(layoutParams2.O000OOoo, layoutParams2.O000Oo00);
            }
            if (layoutParams2.O00O0Oo) {
                constraintWidget6.O000Oo00[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                constraintWidget6.O00000oO(layoutParams2.width);
                if (layoutParams2.width == -2) {
                    constraintWidget6.O000Oo00[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
            } else if (layoutParams2.width == -1) {
                if (layoutParams2.O000Oo0O) {
                    constraintWidget6.O000Oo00[0] = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                } else {
                    constraintWidget6.O000Oo00[0] = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                }
                constraintWidget6.O000000o(ConstraintAnchor.Type.LEFT).O00000o = layoutParams2.leftMargin;
                constraintWidget6.O000000o(ConstraintAnchor.Type.RIGHT).O00000o = layoutParams2.rightMargin;
            } else {
                constraintWidget6.O000Oo00[0] = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                constraintWidget6.O00000oO(0);
            }
            if (layoutParams2.O000OoO) {
                constraintWidget6.O000Oo00[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                constraintWidget6.O00000oo(layoutParams2.height);
                if (layoutParams2.height == -2) {
                    constraintWidget6.O000Oo00[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
            } else if (layoutParams2.height == -1) {
                if (layoutParams2.O000Oo0o) {
                    constraintWidget6.O000Oo00[1] = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                } else {
                    constraintWidget6.O000Oo00[1] = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                }
                constraintWidget6.O000000o(ConstraintAnchor.Type.TOP).O00000o = layoutParams2.topMargin;
                constraintWidget6.O000000o(ConstraintAnchor.Type.BOTTOM).O00000o = layoutParams2.bottomMargin;
            } else {
                constraintWidget6.O000Oo00[1] = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                constraintWidget6.O00000oo(0);
            }
            constraintWidget6.O000000o(layoutParams2.O000O00o);
            constraintWidget6.O000oOoO[0] = layoutParams2.O00oOoOo;
            constraintWidget6.O000oOoO[1] = layoutParams2.O000O0o0;
            constraintWidget6.O000oOOO = layoutParams2.O000O0o;
            constraintWidget6.O000oOOo = layoutParams2.O000O0oO;
            int i17 = layoutParams2.O000O0oo;
            int i18 = layoutParams2.O000OO0o;
            int i19 = layoutParams2.O000OOOo;
            float f8 = layoutParams2.O000OOo;
            constraintWidget6.O0000o0O = i17;
            constraintWidget6.O0000oO0 = i18;
            if (i19 == Integer.MAX_VALUE) {
                i19 = 0;
            }
            constraintWidget6.O0000oO = i19;
            constraintWidget6.O0000oOO = f8;
            if (f8 > 0.0f && f8 < 1.0f && constraintWidget6.O0000o0O == 0) {
                constraintWidget6.O0000o0O = 2;
            }
            int i20 = layoutParams2.O000OO00;
            int i21 = layoutParams2.O000OO;
            int i22 = layoutParams2.O000OOo0;
            float f9 = layoutParams2.O000OOoO;
            constraintWidget6.O0000o0o = i20;
            constraintWidget6.O0000oOo = i21;
            if (i22 != Integer.MAX_VALUE) {
                i4 = i22;
            }
            constraintWidget6.O0000oo0 = i4;
            constraintWidget6.O0000oo = f9;
            if (f9 > 0.0f && f9 < 1.0f && constraintWidget6.O0000o0o == 0) {
                constraintWidget6.O0000o0o = 2;
            }
        }
    }

    private final ConstraintWidget getTargetWidget(int i) {
        if (i == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i);
        if (view == null && (view = findViewById(i)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).O000o0o0;
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).O000o0o0;
    }

    public void fillMetrics(oOOoOOO0 ooooooo0) {
        this.mMetrics = ooooooo0;
        this.mLayoutWidget.O000ooO0 = ooooooo0;
        oO00Oo00.O000000o(ooooooo0);
    }

    public void resolveSystem(oOo0000O ooo0000o, int i, int i2, int i3) {
        int i4;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i5 = max + max2;
        int paddingWidth = getPaddingWidth();
        O000000o o000000o = this.mMeasurer;
        o000000o.O00000Oo = max;
        o000000o.O00000o0 = max2;
        o000000o.O00000o = paddingWidth;
        o000000o.O00000oO = i5;
        o000000o.O00000oo = i2;
        o000000o.O0000O0o = i3;
        if (Build.VERSION.SDK_INT >= 17) {
            i4 = Math.max(0, getPaddingStart());
            int max3 = Math.max(0, getPaddingEnd());
            if (i4 <= 0 && max3 <= 0) {
                i4 = Math.max(0, getPaddingLeft());
            } else if (isRtl()) {
                i4 = max3;
            }
        } else {
            i4 = Math.max(0, getPaddingLeft());
        }
        int i6 = size2 - i5;
        int i7 = mode;
        int i8 = size - paddingWidth;
        int i9 = mode2;
        int i10 = i6;
        setSelfDimensionBehaviour(ooo0000o, i7, i8, i9, i10);
        ooo0000o.O000000o(i, i7, i8, i9, i10, i4, max);
    }

    public void resolveMeasuredDimension(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int i5 = this.mMeasurer.O00000oO;
        int i6 = i3 + this.mMeasurer.O00000o;
        int i7 = i4 + i5;
        if (Build.VERSION.SDK_INT >= 11) {
            int resolveSizeAndState = resolveSizeAndState(i6, i, 0);
            int min = Math.min(this.mMaxWidth, resolveSizeAndState & 16777215);
            int min2 = Math.min(this.mMaxHeight, resolveSizeAndState(i7, i2, 0) & 16777215);
            if (z) {
                min |= 16777216;
            }
            if (z2) {
                min2 |= 16777216;
            }
            setMeasuredDimension(min, min2);
            this.mLastMeasureWidth = min;
            this.mLastMeasureHeight = min2;
            return;
        }
        setMeasuredDimension(i6, i7);
        this.mLastMeasureWidth = i6;
        this.mLastMeasureHeight = i7;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.mOnMeasureWidthMeasureSpec = i;
        this.mOnMeasureHeightMeasureSpec = i2;
        this.mLayoutWidget.O000oo = isRtl();
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                this.mLayoutWidget.O0000oO0();
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i, i2);
        resolveMeasuredDimension(i, i2, this.mLayoutWidget.O00000oO(), this.mLayoutWidget.O00000oo(), this.mLayoutWidget.O00O0OO, this.mLayoutWidget.O00O0OOo);
    }

    public boolean isRtl() {
        if (Build.VERSION.SDK_INT >= 17) {
            if (!((getContext().getApplicationInfo().flags & 4194304) != 0) || 1 != getLayoutDirection()) {
                return false;
            }
            return true;
        }
        return false;
    }

    private int getPaddingWidth() {
        int i = 0;
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        if (Build.VERSION.SDK_INT >= 17) {
            i = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        }
        return i > 0 ? i : max;
    }

    /* access modifiers changed from: protected */
    public void setSelfDimensionBehaviour(oOo0000O ooo0000o, int i, int i2, int i3, int i4) {
        int i5 = this.mMeasurer.O00000oO;
        int i6 = this.mMeasurer.O00000o;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        int childCount = getChildCount();
        if (i != Integer.MIN_VALUE) {
            if (i == 0) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i2 = Math.max(0, this.mMinWidth);
                }
            } else if (i == 1073741824) {
                i2 = Math.min(this.mMaxWidth - i6, i2);
            }
            i2 = 0;
        } else {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i2 = Math.max(0, this.mMinWidth);
            }
        }
        if (i3 != Integer.MIN_VALUE) {
            if (i3 == 0) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i4 = Math.max(0, this.mMinHeight);
                }
            } else if (i3 == 1073741824) {
                i4 = Math.min(this.mMaxHeight - i5, i4);
            }
            i4 = 0;
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i4 = Math.max(0, this.mMinHeight);
            }
        }
        if (!(i2 == ooo0000o.O00000oO() && i4 == ooo0000o.O00000oo())) {
            ooo0000o.O00000Oo.O00000o0 = true;
        }
        ooo0000o.O00000o0(0);
        ooo0000o.O00000o(0);
        ooo0000o.O000O00o[0] = this.mMaxWidth - i6;
        ooo0000o.O000O00o[1] = this.mMaxHeight - i5;
        ooo0000o.O0000O0o(0);
        ooo0000o.O0000OOo(0);
        ooo0000o.O000Oo00[0] = dimensionBehaviour;
        ooo0000o.O00000oO(i2);
        ooo0000o.O000Oo00[1] = dimensionBehaviour2;
        ooo0000o.O00000oo(i4);
        ooo0000o.O0000O0o(this.mMinWidth - i6);
        ooo0000o.O0000OOo(this.mMinHeight - i5);
    }

    public void setState(int i, int i2, int i3) {
        oOO0OO0O ooo0oo0o = this.mConstraintLayoutSpec;
        if (ooo0oo0o != null) {
            ooo0oo0o.O000000o(i, (float) i2, (float) i3);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.O000o0o0;
            if ((childAt.getVisibility() != 8 || layoutParams.O000OoOo || layoutParams.O000Ooo0 || layoutParams.O000OooO || isInEditMode) && !layoutParams.O000Ooo) {
                int O00000o0 = constraintWidget.O00000o0();
                int O00000o = constraintWidget.O00000o();
                int O00000oO = constraintWidget.O00000oO() + O00000o0;
                int O00000oo = constraintWidget.O00000oo() + O00000o;
                childAt.layout(O00000o0, O00000o, O00000oO, O00000oo);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(O00000o0, O00000o, O00000oO, O00000oo);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.mConstraintHelpers.get(i6).O000000o();
            }
        }
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
        this.mLayoutWidget.O0000o00(i);
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.O00O00oo;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void setConstraintSet(oOO0OOo0 ooo0ooo0) {
        this.mConstraintSet = ooo0ooo0;
    }

    public View getViewById(int i) {
        return this.mChildrenByIds.get(i);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                this.mConstraintHelpers.get(i).O000000o(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i3 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i4 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = (float) i3;
                        float f2 = (float) i4;
                        float f3 = (float) (i3 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f4 = f2;
                        float f5 = f2;
                        float f6 = f3;
                        float f7 = f;
                        canvas2.drawLine(f, f4, f6, f5, paint);
                        float parseInt4 = (float) (i4 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f8 = f3;
                        float f9 = parseInt4;
                        canvas2.drawLine(f8, f5, f6, f9, paint);
                        float f10 = parseInt4;
                        float f11 = f7;
                        canvas2.drawLine(f8, f10, f11, f9, paint);
                        float f12 = f7;
                        canvas2.drawLine(f12, f10, f11, f5, paint);
                        paint.setColor(-16711936);
                        float f13 = f3;
                        canvas2.drawLine(f12, f5, f13, parseInt4, paint);
                        canvas2.drawLine(f12, parseInt4, f13, f5, paint);
                    }
                }
            }
        }
    }

    public void setOnConstraintsChanged(oOO0Oo00 ooo0oo00) {
        this.mConstraintsChangedListener = ooo0oo00;
        oOO0OO0O ooo0oo0o = this.mConstraintLayoutSpec;
        if (ooo0oo0o != null) {
            ooo0oo0o.O00000o = ooo0oo00;
        }
    }

    public void loadLayoutDescription(int i) {
        if (i != 0) {
            try {
                this.mConstraintLayoutSpec = new oOO0OO0O(getContext(), this, i);
                return;
            } catch (Resources.NotFoundException unused) {
            }
        }
        this.mConstraintLayoutSpec = null;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f2804O000000o = -1;
        public int O00000Oo = -1;
        public int O00000o = -1;
        public float O00000o0 = -1.0f;
        public int O00000oO = -1;
        public int O00000oo = -1;
        public int O0000O0o = -1;
        public int O0000OOo = -1;
        public int O0000Oo = -1;
        public int O0000Oo0 = -1;
        public int O0000OoO = -1;
        public int O0000Ooo = -1;
        public int O0000o = -1;
        public int O0000o0 = 0;
        public int O0000o00 = -1;
        public float O0000o0O = 0.0f;
        public int O0000o0o = -1;
        public int O0000oO = -1;
        public int O0000oO0 = -1;
        public int O0000oOO = -1;
        public int O0000oOo = -1;
        public int O0000oo = -1;
        public int O0000oo0 = -1;
        public int O0000ooO = -1;
        public int O0000ooo = -1;
        public String O000O00o = null;
        float O000O0OO = 0.0f;
        int O000O0Oo = 1;
        public int O000O0o = 0;
        public float O000O0o0 = -1.0f;
        public int O000O0oO = 0;
        public int O000O0oo = 0;
        public int O000OO = 0;
        public int O000OO00 = 0;
        public int O000OO0o = 0;
        public int O000OOOo = 0;
        public float O000OOo = 1.0f;
        public int O000OOo0 = 0;
        public float O000OOoO = 1.0f;
        public int O000OOoo = -1;
        public int O000Oo0 = -1;
        public int O000Oo00 = -1;
        public boolean O000Oo0O = false;
        public boolean O000Oo0o = false;
        boolean O000OoO = true;
        public String O000OoO0 = null;
        boolean O000OoOO = false;
        boolean O000OoOo = false;
        boolean O000Ooo = false;
        boolean O000Ooo0 = false;
        boolean O000OooO = false;
        int O000Oooo = -1;
        int O000o0 = -1;
        int O000o00 = -1;
        int O000o000 = -1;
        int O000o00O = -1;
        int O000o00o = -1;
        int O000o0O;
        float O000o0O0 = 0.5f;
        int O000o0OO;
        float O000o0Oo;
        public boolean O000o0o = false;
        public ConstraintWidget O000o0o0 = new ConstraintWidget();
        boolean O00O0Oo = true;
        public float O00oOoOo = -1.0f;
        public float O00oOooO = 0.5f;
        public float O00oOooo = 0.5f;

        static class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final SparseIntArray f2805O000000o;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f2805O000000o = sparseIntArray;
                sparseIntArray.append(63, 8);
                f2805O000000o.append(64, 9);
                f2805O000000o.append(66, 10);
                f2805O000000o.append(67, 11);
                f2805O000000o.append(73, 12);
                f2805O000000o.append(72, 13);
                f2805O000000o.append(45, 14);
                f2805O000000o.append(44, 15);
                f2805O000000o.append(42, 16);
                f2805O000000o.append(46, 2);
                f2805O000000o.append(48, 3);
                f2805O000000o.append(47, 4);
                f2805O000000o.append(81, 49);
                f2805O000000o.append(82, 50);
                f2805O000000o.append(52, 5);
                f2805O000000o.append(53, 6);
                f2805O000000o.append(54, 7);
                f2805O000000o.append(0, 1);
                f2805O000000o.append(68, 17);
                f2805O000000o.append(69, 18);
                f2805O000000o.append(51, 19);
                f2805O000000o.append(50, 20);
                f2805O000000o.append(85, 21);
                f2805O000000o.append(88, 22);
                f2805O000000o.append(86, 23);
                f2805O000000o.append(83, 24);
                f2805O000000o.append(87, 25);
                f2805O000000o.append(84, 26);
                f2805O000000o.append(59, 29);
                f2805O000000o.append(74, 30);
                f2805O000000o.append(49, 44);
                f2805O000000o.append(61, 45);
                f2805O000000o.append(76, 46);
                f2805O000000o.append(60, 47);
                f2805O000000o.append(75, 48);
                f2805O000000o.append(40, 27);
                f2805O000000o.append(39, 28);
                f2805O000000o.append(77, 31);
                f2805O000000o.append(55, 32);
                f2805O000000o.append(79, 33);
                f2805O000000o.append(78, 34);
                f2805O000000o.append(80, 35);
                f2805O000000o.append(57, 36);
                f2805O000000o.append(56, 37);
                f2805O000000o.append(58, 38);
                f2805O000000o.append(62, 39);
                f2805O000000o.append(71, 40);
                f2805O000000o.append(65, 41);
                f2805O000000o.append(43, 42);
                f2805O000000o.append(41, 43);
                f2805O000000o.append(70, 51);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.max(float, float):float}
         arg types: [int, float]
         candidates:
          ClspMth{java.lang.Math.max(double, double):double}
          ClspMth{java.lang.Math.max(int, int):int}
          ClspMth{java.lang.Math.max(long, long):long}
          ClspMth{java.lang.Math.max(float, float):float} */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842948, 16842965, 16842966, 16842967, 16842968, 16842969, 16842972, 16843039, 16843040, 16843071, 16843072, 16843699, 16843700, 16843840, R.attr.barrierAllowsGoneWidgets, R.attr.barrierDirection, R.attr.barrierMargin, R.attr.chainUseRtl, R.attr.constraintSet, R.attr.constraint_referenced_ids, R.attr.flow_firstHorizontalBias, R.attr.flow_firstHorizontalStyle, R.attr.flow_firstVerticalBias, R.attr.flow_firstVerticalStyle, R.attr.flow_horizontalAlign, R.attr.flow_horizontalBias, R.attr.flow_horizontalGap, R.attr.flow_horizontalStyle, R.attr.flow_lastHorizontalBias, R.attr.flow_lastHorizontalStyle, R.attr.flow_lastVerticalBias, R.attr.flow_lastVerticalStyle, R.attr.flow_maxElementsWrap, R.attr.flow_verticalAlign, R.attr.flow_verticalBias, R.attr.flow_verticalGap, R.attr.flow_verticalStyle, R.attr.flow_wrapMode, R.attr.layoutDescription, R.attr.layout_constrainedHeight, R.attr.layout_constrainedWidth, R.attr.layout_constraintBaseline_creator, R.attr.layout_constraintBaseline_toBaselineOf, R.attr.layout_constraintBottom_creator, R.attr.layout_constraintBottom_toBottomOf, R.attr.layout_constraintBottom_toTopOf, R.attr.layout_constraintCircle, R.attr.layout_constraintCircleAngle, R.attr.layout_constraintCircleRadius, R.attr.layout_constraintDimensionRatio, R.attr.layout_constraintEnd_toEndOf, R.attr.layout_constraintEnd_toStartOf, R.attr.layout_constraintGuide_begin, R.attr.layout_constraintGuide_end, R.attr.layout_constraintGuide_percent, R.attr.layout_constraintHeight_default, R.attr.layout_constraintHeight_max, R.attr.layout_constraintHeight_min, R.attr.layout_constraintHeight_percent, R.attr.layout_constraintHorizontal_bias, R.attr.layout_constraintHorizontal_chainStyle, R.attr.layout_constraintHorizontal_weight, R.attr.layout_constraintLeft_creator, R.attr.layout_constraintLeft_toLeftOf, R.attr.layout_constraintLeft_toRightOf, R.attr.layout_constraintRight_creator, R.attr.layout_constraintRight_toLeftOf, R.attr.layout_constraintRight_toRightOf, R.attr.layout_constraintStart_toEndOf, R.attr.layout_constraintStart_toStartOf, R.attr.layout_constraintTag, R.attr.layout_constraintTop_creator, R.attr.layout_constraintTop_toBottomOf, R.attr.layout_constraintTop_toTopOf, R.attr.layout_constraintVertical_bias, R.attr.layout_constraintVertical_chainStyle, R.attr.layout_constraintVertical_weight, R.attr.layout_constraintWidth_default, R.attr.layout_constraintWidth_max, R.attr.layout_constraintWidth_min, R.attr.layout_constraintWidth_percent, R.attr.layout_editor_absoluteX, R.attr.layout_editor_absoluteY, R.attr.layout_goneMarginBottom, R.attr.layout_goneMarginEnd, R.attr.layout_goneMarginLeft, R.attr.layout_goneMarginRight, R.attr.layout_goneMarginStart, R.attr.layout_goneMarginTop, R.attr.layout_optimizationLevel});
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = O000000o.f2805O000000o.get(index);
                switch (i3) {
                    case 0:
                        break;
                    case 1:
                        this.O000Oo0 = obtainStyledAttributes.getInt(index, this.O000Oo0);
                        break;
                    case 2:
                        this.O0000o00 = obtainStyledAttributes.getResourceId(index, this.O0000o00);
                        if (this.O0000o00 != -1) {
                            break;
                        } else {
                            this.O0000o00 = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        this.O0000o0 = obtainStyledAttributes.getDimensionPixelSize(index, this.O0000o0);
                        break;
                    case 4:
                        this.O0000o0O = obtainStyledAttributes.getFloat(index, this.O0000o0O) % 360.0f;
                        float f = this.O0000o0O;
                        if (f >= 0.0f) {
                            break;
                        } else {
                            this.O0000o0O = (360.0f - f) % 360.0f;
                            break;
                        }
                    case 5:
                        this.f2804O000000o = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2804O000000o);
                        break;
                    case 6:
                        this.O00000Oo = obtainStyledAttributes.getDimensionPixelOffset(index, this.O00000Oo);
                        break;
                    case 7:
                        this.O00000o0 = obtainStyledAttributes.getFloat(index, this.O00000o0);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                        this.O00000o = obtainStyledAttributes.getResourceId(index, this.O00000o);
                        if (this.O00000o != -1) {
                            break;
                        } else {
                            this.O00000o = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 9:
                        this.O00000oO = obtainStyledAttributes.getResourceId(index, this.O00000oO);
                        if (this.O00000oO != -1) {
                            break;
                        } else {
                            this.O00000oO = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 10:
                        this.O00000oo = obtainStyledAttributes.getResourceId(index, this.O00000oo);
                        if (this.O00000oo != -1) {
                            break;
                        } else {
                            this.O00000oo = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 11:
                        this.O0000O0o = obtainStyledAttributes.getResourceId(index, this.O0000O0o);
                        if (this.O0000O0o != -1) {
                            break;
                        } else {
                            this.O0000O0o = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        this.O0000OOo = obtainStyledAttributes.getResourceId(index, this.O0000OOo);
                        if (this.O0000OOo != -1) {
                            break;
                        } else {
                            this.O0000OOo = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 13:
                        this.O0000Oo0 = obtainStyledAttributes.getResourceId(index, this.O0000Oo0);
                        if (this.O0000Oo0 != -1) {
                            break;
                        } else {
                            this.O0000Oo0 = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 14:
                        this.O0000Oo = obtainStyledAttributes.getResourceId(index, this.O0000Oo);
                        if (this.O0000Oo != -1) {
                            break;
                        } else {
                            this.O0000Oo = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                        this.O0000OoO = obtainStyledAttributes.getResourceId(index, this.O0000OoO);
                        if (this.O0000OoO != -1) {
                            break;
                        } else {
                            this.O0000OoO = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 16:
                        this.O0000Ooo = obtainStyledAttributes.getResourceId(index, this.O0000Ooo);
                        if (this.O0000Ooo != -1) {
                            break;
                        } else {
                            this.O0000Ooo = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 17:
                        this.O0000o0o = obtainStyledAttributes.getResourceId(index, this.O0000o0o);
                        if (this.O0000o0o != -1) {
                            break;
                        } else {
                            this.O0000o0o = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 18:
                        this.O0000o = obtainStyledAttributes.getResourceId(index, this.O0000o);
                        if (this.O0000o != -1) {
                            break;
                        } else {
                            this.O0000o = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 19:
                        this.O0000oO0 = obtainStyledAttributes.getResourceId(index, this.O0000oO0);
                        if (this.O0000oO0 != -1) {
                            break;
                        } else {
                            this.O0000oO0 = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 20:
                        this.O0000oO = obtainStyledAttributes.getResourceId(index, this.O0000oO);
                        if (this.O0000oO != -1) {
                            break;
                        } else {
                            this.O0000oO = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        this.O0000oOO = obtainStyledAttributes.getDimensionPixelSize(index, this.O0000oOO);
                        break;
                    case 22:
                        this.O0000oOo = obtainStyledAttributes.getDimensionPixelSize(index, this.O0000oOo);
                        break;
                    case 23:
                        this.O0000oo0 = obtainStyledAttributes.getDimensionPixelSize(index, this.O0000oo0);
                        break;
                    case 24:
                        this.O0000oo = obtainStyledAttributes.getDimensionPixelSize(index, this.O0000oo);
                        break;
                    case 25:
                        this.O0000ooO = obtainStyledAttributes.getDimensionPixelSize(index, this.O0000ooO);
                        break;
                    case 26:
                        this.O0000ooo = obtainStyledAttributes.getDimensionPixelSize(index, this.O0000ooo);
                        break;
                    case 27:
                        this.O000Oo0O = obtainStyledAttributes.getBoolean(index, this.O000Oo0O);
                        break;
                    case 28:
                        this.O000Oo0o = obtainStyledAttributes.getBoolean(index, this.O000Oo0o);
                        break;
                    case 29:
                        this.O00oOooO = obtainStyledAttributes.getFloat(index, this.O00oOooO);
                        break;
                    case 30:
                        this.O00oOooo = obtainStyledAttributes.getFloat(index, this.O00oOooo);
                        break;
                    case 31:
                        this.O000O0oo = obtainStyledAttributes.getInt(index, 0);
                        if (this.O000O0oo != 1) {
                            break;
                        } else {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        }
                    case 32:
                        this.O000OO00 = obtainStyledAttributes.getInt(index, 0);
                        if (this.O000OO00 != 1) {
                            break;
                        } else {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        }
                    case 33:
                        try {
                            this.O000OO0o = obtainStyledAttributes.getDimensionPixelSize(index, this.O000OO0o);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.O000OO0o) != -2) {
                                break;
                            } else {
                                this.O000OO0o = -2;
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.O000OOOo = obtainStyledAttributes.getDimensionPixelSize(index, this.O000OOOo);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.O000OOOo) != -2) {
                                break;
                            } else {
                                this.O000OOOo = -2;
                                break;
                            }
                        }
                    case 35:
                        this.O000OOo = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O000OOo));
                        this.O000O0oo = 2;
                        break;
                    case 36:
                        try {
                            this.O000OO = obtainStyledAttributes.getDimensionPixelSize(index, this.O000OO);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.O000OO) != -2) {
                                break;
                            } else {
                                this.O000OO = -2;
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.O000OOo0 = obtainStyledAttributes.getDimensionPixelSize(index, this.O000OOo0);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.O000OOo0) != -2) {
                                break;
                            } else {
                                this.O000OOo0 = -2;
                                break;
                            }
                        }
                    case 38:
                        this.O000OOoO = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O000OOoO));
                        this.O000OO00 = 2;
                        break;
                    default:
                        switch (i3) {
                            case 44:
                                this.O000O00o = obtainStyledAttributes.getString(index);
                                this.O000O0OO = Float.NaN;
                                this.O000O0Oo = -1;
                                String str = this.O000O00o;
                                if (str != null) {
                                    int length = str.length();
                                    int indexOf = this.O000O00o.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i = 0;
                                    } else {
                                        String substring = this.O000O00o.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.O000O0Oo = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.O000O0Oo = 1;
                                        }
                                        i = indexOf + 1;
                                    }
                                    int indexOf2 = this.O000O00o.indexOf(58);
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.O000O00o.substring(i, indexOf2);
                                        String substring3 = this.O000O00o.substring(indexOf2 + 1);
                                        if (substring2.length() > 0 && substring3.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring2);
                                                float parseFloat2 = Float.parseFloat(substring3);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.O000O0Oo != 1) {
                                                        this.O000O0OO = Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    } else {
                                                        this.O000O0OO = Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    } else {
                                        String substring4 = this.O000O00o.substring(i);
                                        if (substring4.length() <= 0) {
                                            break;
                                        } else {
                                            this.O000O0OO = Float.parseFloat(substring4);
                                            break;
                                        }
                                    }
                                } else {
                                    continue;
                                }
                                break;
                            case 45:
                                this.O00oOoOo = obtainStyledAttributes.getFloat(index, this.O00oOoOo);
                                continue;
                            case 46:
                                this.O000O0o0 = obtainStyledAttributes.getFloat(index, this.O000O0o0);
                                continue;
                            case 47:
                                this.O000O0o = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.O000O0oO = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.O000OOoo = obtainStyledAttributes.getDimensionPixelOffset(index, this.O000OOoo);
                                continue;
                            case 50:
                                this.O000Oo00 = obtainStyledAttributes.getDimensionPixelOffset(index, this.O000Oo00);
                                continue;
                            case 51:
                                this.O000OoO0 = obtainStyledAttributes.getString(index);
                                continue;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            O000000o();
        }

        public final void O000000o() {
            this.O000OoOo = false;
            this.O00O0Oo = true;
            this.O000OoO = true;
            if (this.width == -2 && this.O000Oo0O) {
                this.O00O0Oo = false;
                if (this.O000O0oo == 0) {
                    this.O000O0oo = 1;
                }
            }
            if (this.height == -2 && this.O000Oo0o) {
                this.O000OoO = false;
                if (this.O000OO00 == 0) {
                    this.O000OO00 = 1;
                }
            }
            if (this.width == 0 || this.width == -1) {
                this.O00O0Oo = false;
                if (this.width == 0 && this.O000O0oo == 1) {
                    this.width = -2;
                    this.O000Oo0O = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.O000OoO = false;
                if (this.height == 0 && this.O000OO00 == 1) {
                    this.height = -2;
                    this.O000Oo0o = true;
                }
            }
            if (this.O00000o0 != -1.0f || this.f2804O000000o != -1 || this.O00000Oo != -1) {
                this.O000OoOo = true;
                this.O00O0Oo = true;
                this.O000OoO = true;
                if (!(this.O000o0o0 instanceof oO0O000o)) {
                    this.O000o0o0 = new oO0O000o();
                }
                ((oO0O000o) this.O000o0o0).O0000o00(this.O000Oo0);
            }
        }

        public LayoutParams(int i, int i2) {
            super(-2, -2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0082  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x008a  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00a0  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x003f  */
        @TargetApi(17)
        public void resolveLayoutDirection(int i) {
            boolean z;
            int i2;
            int i3;
            int i4;
            int i5;
            float f;
            int i6 = this.leftMargin;
            int i7 = this.rightMargin;
            boolean z2 = false;
            if (Build.VERSION.SDK_INT >= 17) {
                super.resolveLayoutDirection(i);
                if (1 == getLayoutDirection()) {
                    z = true;
                    this.O000o00 = -1;
                    this.O000o00O = -1;
                    this.O000Oooo = -1;
                    this.O000o000 = -1;
                    this.O000o00o = -1;
                    this.O000o0 = -1;
                    this.O000o00o = this.O0000oOO;
                    this.O000o0 = this.O0000oo0;
                    this.O000o0O0 = this.O00oOooO;
                    this.O000o0O = this.f2804O000000o;
                    this.O000o0OO = this.O00000Oo;
                    this.O000o0Oo = this.O00000o0;
                    if (!z) {
                        int i8 = this.O0000o0o;
                        if (i8 != -1) {
                            this.O000o00 = i8;
                        } else {
                            int i9 = this.O0000o;
                            if (i9 != -1) {
                                this.O000o00O = i9;
                            }
                            i2 = this.O0000oO0;
                            if (i2 != -1) {
                                this.O000o000 = i2;
                                z2 = true;
                            }
                            i3 = this.O0000oO;
                            if (i3 != -1) {
                                this.O000Oooo = i3;
                                z2 = true;
                            }
                            i4 = this.O0000ooO;
                            if (i4 != -1) {
                                this.O000o0 = i4;
                            }
                            i5 = this.O0000ooo;
                            if (i5 != -1) {
                                this.O000o00o = i5;
                            }
                            if (z2) {
                                this.O000o0O0 = 1.0f - this.O00oOooO;
                            }
                            if (this.O000OoOo && this.O000Oo0 == 1) {
                                f = this.O00000o0;
                                if (f == -1.0f) {
                                    this.O000o0Oo = 1.0f - f;
                                    this.O000o0O = -1;
                                    this.O000o0OO = -1;
                                } else {
                                    int i10 = this.f2804O000000o;
                                    if (i10 != -1) {
                                        this.O000o0OO = i10;
                                        this.O000o0O = -1;
                                        this.O000o0Oo = -1.0f;
                                    } else {
                                        int i11 = this.O00000Oo;
                                        if (i11 != -1) {
                                            this.O000o0O = i11;
                                            this.O000o0OO = -1;
                                            this.O000o0Oo = -1.0f;
                                        }
                                    }
                                }
                            }
                        }
                        z2 = true;
                        i2 = this.O0000oO0;
                        if (i2 != -1) {
                        }
                        i3 = this.O0000oO;
                        if (i3 != -1) {
                        }
                        i4 = this.O0000ooO;
                        if (i4 != -1) {
                        }
                        i5 = this.O0000ooo;
                        if (i5 != -1) {
                        }
                        if (z2) {
                        }
                        f = this.O00000o0;
                        if (f == -1.0f) {
                        }
                    } else {
                        int i12 = this.O0000o0o;
                        if (i12 != -1) {
                            this.O000o000 = i12;
                        }
                        int i13 = this.O0000o;
                        if (i13 != -1) {
                            this.O000Oooo = i13;
                        }
                        int i14 = this.O0000oO0;
                        if (i14 != -1) {
                            this.O000o00 = i14;
                        }
                        int i15 = this.O0000oO;
                        if (i15 != -1) {
                            this.O000o00O = i15;
                        }
                        int i16 = this.O0000ooO;
                        if (i16 != -1) {
                            this.O000o00o = i16;
                        }
                        int i17 = this.O0000ooo;
                        if (i17 != -1) {
                            this.O000o0 = i17;
                        }
                    }
                    if (this.O0000oO0 == -1 && this.O0000oO == -1 && this.O0000o == -1 && this.O0000o0o == -1) {
                        int i18 = this.O00000oo;
                        if (i18 != -1) {
                            this.O000o00 = i18;
                            if (this.rightMargin <= 0 && i7 > 0) {
                                this.rightMargin = i7;
                            }
                        } else {
                            int i19 = this.O0000O0o;
                            if (i19 != -1) {
                                this.O000o00O = i19;
                                if (this.rightMargin <= 0 && i7 > 0) {
                                    this.rightMargin = i7;
                                }
                            }
                        }
                        int i20 = this.O00000o;
                        if (i20 != -1) {
                            this.O000Oooo = i20;
                            if (this.leftMargin <= 0 && i6 > 0) {
                                this.leftMargin = i6;
                                return;
                            }
                            return;
                        }
                        int i21 = this.O00000oO;
                        if (i21 != -1) {
                            this.O000o000 = i21;
                            if (this.leftMargin <= 0 && i6 > 0) {
                                this.leftMargin = i6;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            z = false;
            this.O000o00 = -1;
            this.O000o00O = -1;
            this.O000Oooo = -1;
            this.O000o000 = -1;
            this.O000o00o = -1;
            this.O000o0 = -1;
            this.O000o00o = this.O0000oOO;
            this.O000o0 = this.O0000oo0;
            this.O000o0O0 = this.O00oOooO;
            this.O000o0O = this.f2804O000000o;
            this.O000o0OO = this.O00000Oo;
            this.O000o0Oo = this.O00000o0;
            if (!z) {
            }
            if (this.O0000oO0 == -1) {
            }
        }
    }

    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }
}
