package androidx.constraintlayout.widget;

import _m_j.jdn;
import _m_j.oO0O00Oo;
import _m_j.oO0O00o0;
import _m_j.oOO0OOo0;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaomi.smarthome.R;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ConstraintHelper extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private View[] f2802O000000o = null;
    private HashMap<Integer, String> O00000Oo = new HashMap<>();
    protected int[] O0000Oo = new int[32];
    protected int O0000OoO;
    protected Context O0000Ooo;
    protected boolean O0000o0 = false;
    protected oO0O00Oo O0000o00;
    protected String O0000o0O;

    public void O000000o() {
    }

    public void O000000o(ConstraintWidget constraintWidget, boolean z) {
    }

    public void O000000o(ConstraintLayout constraintLayout) {
    }

    public void onDraw(Canvas canvas) {
    }

    public ConstraintHelper(Context context) {
        super(context);
        this.O0000Ooo = context;
        O000000o((AttributeSet) null);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000Ooo = context;
        O000000o(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000Ooo = context;
        O000000o(attributeSet);
    }

    /* access modifiers changed from: protected */
    public void O000000o(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{16842948, 16842965, 16842966, 16842967, 16842968, 16842969, 16842972, 16843039, 16843040, 16843071, 16843072, 16843699, 16843700, 16843840, R.attr.barrierAllowsGoneWidgets, R.attr.barrierDirection, R.attr.barrierMargin, R.attr.chainUseRtl, R.attr.constraintSet, R.attr.constraint_referenced_ids, R.attr.flow_firstHorizontalBias, R.attr.flow_firstHorizontalStyle, R.attr.flow_firstVerticalBias, R.attr.flow_firstVerticalStyle, R.attr.flow_horizontalAlign, R.attr.flow_horizontalBias, R.attr.flow_horizontalGap, R.attr.flow_horizontalStyle, R.attr.flow_lastHorizontalBias, R.attr.flow_lastHorizontalStyle, R.attr.flow_lastVerticalBias, R.attr.flow_lastVerticalStyle, R.attr.flow_maxElementsWrap, R.attr.flow_verticalAlign, R.attr.flow_verticalBias, R.attr.flow_verticalGap, R.attr.flow_verticalStyle, R.attr.flow_wrapMode, R.attr.layoutDescription, R.attr.layout_constrainedHeight, R.attr.layout_constrainedWidth, R.attr.layout_constraintBaseline_creator, R.attr.layout_constraintBaseline_toBaselineOf, R.attr.layout_constraintBottom_creator, R.attr.layout_constraintBottom_toBottomOf, R.attr.layout_constraintBottom_toTopOf, R.attr.layout_constraintCircle, R.attr.layout_constraintCircleAngle, R.attr.layout_constraintCircleRadius, R.attr.layout_constraintDimensionRatio, R.attr.layout_constraintEnd_toEndOf, R.attr.layout_constraintEnd_toStartOf, R.attr.layout_constraintGuide_begin, R.attr.layout_constraintGuide_end, R.attr.layout_constraintGuide_percent, R.attr.layout_constraintHeight_default, R.attr.layout_constraintHeight_max, R.attr.layout_constraintHeight_min, R.attr.layout_constraintHeight_percent, R.attr.layout_constraintHorizontal_bias, R.attr.layout_constraintHorizontal_chainStyle, R.attr.layout_constraintHorizontal_weight, R.attr.layout_constraintLeft_creator, R.attr.layout_constraintLeft_toLeftOf, R.attr.layout_constraintLeft_toRightOf, R.attr.layout_constraintRight_creator, R.attr.layout_constraintRight_toLeftOf, R.attr.layout_constraintRight_toRightOf, R.attr.layout_constraintStart_toEndOf, R.attr.layout_constraintStart_toStartOf, R.attr.layout_constraintTag, R.attr.layout_constraintTop_creator, R.attr.layout_constraintTop_toBottomOf, R.attr.layout_constraintTop_toTopOf, R.attr.layout_constraintVertical_bias, R.attr.layout_constraintVertical_chainStyle, R.attr.layout_constraintVertical_weight, R.attr.layout_constraintWidth_default, R.attr.layout_constraintWidth_max, R.attr.layout_constraintWidth_min, R.attr.layout_constraintWidth_percent, R.attr.layout_editor_absoluteX, R.attr.layout_editor_absoluteY, R.attr.layout_goneMarginBottom, R.attr.layout_goneMarginEnd, R.attr.layout_goneMarginLeft, R.attr.layout_goneMarginRight, R.attr.layout_goneMarginStart, R.attr.layout_goneMarginTop, R.attr.layout_optimizationLevel});
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 19) {
                    this.O0000o0O = obtainStyledAttributes.getString(index);
                    setIds(this.O0000o0O);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.O0000o0O;
        if (str != null) {
            setIds(str);
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.O0000Oo, this.O0000OoO);
    }

    public void setReferencedIds(int[] iArr) {
        this.O0000o0O = null;
        this.O0000OoO = 0;
        for (int O000000o2 : iArr) {
            O000000o(O000000o2);
        }
    }

    private void O000000o(int i) {
        if (i != getId()) {
            int i2 = this.O0000OoO + 1;
            int[] iArr = this.O0000Oo;
            if (i2 > iArr.length) {
                this.O0000Oo = Arrays.copyOf(iArr, iArr.length * 2);
            }
            int[] iArr2 = this.O0000Oo;
            int i3 = this.O0000OoO;
            iArr2[i3] = i;
            this.O0000OoO = i3 + 1;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.O0000o0) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public final void O00000Oo() {
        if (this.O0000o00 != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) layoutParams).O000o0o0 = (ConstraintWidget) this.O0000o00;
            }
        }
    }

    private void O000000o(String str) {
        if (str != null && str.length() != 0 && this.O0000Ooo != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                getParent();
            }
            int O00000Oo2 = O00000Oo(trim);
            if (O00000Oo2 != 0) {
                this.O00000Oo.put(Integer.valueOf(O00000Oo2), trim);
                O000000o(O00000Oo2);
                return;
            }
            Log.w("ConstraintHelper", "Could not find id of \"" + trim + jdn.f1779O000000o);
        }
    }

    private int O00000Oo(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i = ((Integer) designInformation).intValue();
            }
        }
        if (i == 0 && constraintLayout != null) {
            i = O000000o(constraintLayout, str);
        }
        if (i == 0) {
            try {
                i = R$id.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return i == 0 ? this.O0000Ooo.getResources().getIdentifier(str, "id", this.O0000Ooo.getPackageName()) : i;
    }

    private int O000000o(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.O0000Ooo.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void setIds(String str) {
        this.O0000o0O = str;
        if (str != null) {
            int i = 0;
            this.O0000OoO = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    O000000o(str.substring(i));
                    return;
                } else {
                    O000000o(str.substring(i, indexOf));
                    i = indexOf + 1;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o0() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i = 0; i < this.O0000OoO; i++) {
                View viewById = constraintLayout.getViewById(this.O0000Oo[i]);
                if (viewById != null) {
                    viewById.setVisibility(visibility);
                    if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public final void O00000Oo(ConstraintLayout constraintLayout) {
        String str;
        int O000000o2;
        if (isInEditMode()) {
            setIds(this.O0000o0O);
        }
        oO0O00Oo oo0o00oo = this.O0000o00;
        if (oo0o00oo != null) {
            oo0o00oo.d_();
            for (int i = 0; i < this.O0000OoO; i++) {
                int i2 = this.O0000Oo[i];
                View viewById = constraintLayout.getViewById(i2);
                if (viewById == null && (O000000o2 = O000000o(constraintLayout, (str = this.O00000Oo.get(Integer.valueOf(i2))))) != 0) {
                    this.O0000Oo[i] = O000000o2;
                    this.O00000Oo.put(Integer.valueOf(O000000o2), str);
                    viewById = constraintLayout.getViewById(O000000o2);
                }
                if (viewById != null) {
                    this.O0000o00.O000000o(constraintLayout.getViewWidget(viewById));
                }
            }
            this.O0000o00.c_();
        }
    }

    public final void O000000o(oO0O00Oo oo0o00oo, SparseArray<ConstraintWidget> sparseArray) {
        oo0o00oo.d_();
        for (int i = 0; i < this.O0000OoO; i++) {
            oo0o00oo.O000000o(sparseArray.get(this.O0000Oo[i]));
        }
    }

    /* access modifiers changed from: protected */
    public final View[] O00000o0(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f2802O000000o;
        if (viewArr == null || viewArr.length != this.O0000OoO) {
            this.f2802O000000o = new View[this.O0000OoO];
        }
        for (int i = 0; i < this.O0000OoO; i++) {
            this.f2802O000000o[i] = constraintLayout.getViewById(this.O0000Oo[i]);
        }
        return this.f2802O000000o;
    }

    public void O000000o(oOO0OOo0.O000000o o000000o, oO0O00o0 oo0o00o0, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        if (o000000o.O00000o.O000o000 != null) {
            setReferencedIds(o000000o.O00000o.O000o000);
        } else if (o000000o.O00000o.O000o00 != null && o000000o.O00000o.O000o00.length() > 0) {
            oOO0OOo0.O00000Oo o00000Oo = o000000o.O00000o;
            String[] split = o000000o.O00000o.O000o00.split(",");
            getContext();
            int[] iArr = new int[split.length];
            int i = 0;
            for (String trim : split) {
                int O00000Oo2 = O00000Oo(trim.trim());
                if (O00000Oo2 != 0) {
                    iArr[i] = O00000Oo2;
                    i++;
                }
            }
            if (i != split.length) {
                iArr = Arrays.copyOf(iArr, i);
            }
            o00000Oo.O000o000 = iArr;
        }
        oo0o00o0.d_();
        if (o000000o.O00000o.O000o000 != null) {
            for (int i2 : o000000o.O00000o.O000o000) {
                ConstraintWidget constraintWidget = sparseArray.get(i2);
                if (constraintWidget != null) {
                    oo0o00o0.O000000o(constraintWidget);
                }
            }
        }
    }
}
