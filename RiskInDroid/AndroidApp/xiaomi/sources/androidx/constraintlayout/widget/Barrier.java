package androidx.constraintlayout.widget;

import _m_j.oO0O00o0;
import _m_j.oOO0OOo0;
import _m_j.oOo0000O;
import _m_j.oOo00ooO;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaomi.smarthome.R;

public class Barrier extends ConstraintHelper {

    /* renamed from: O000000o  reason: collision with root package name */
    public oOo00ooO f2799O000000o;
    private int O00000Oo;
    private int O00000o0;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }

    public int getType() {
        return this.O00000Oo;
    }

    public void setType(int i) {
        this.O00000Oo = i;
    }

    private void O000000o(ConstraintWidget constraintWidget, int i, boolean z) {
        this.O00000o0 = i;
        if (Build.VERSION.SDK_INT < 17) {
            int i2 = this.O00000Oo;
            if (i2 == 5) {
                this.O00000o0 = 0;
            } else if (i2 == 6) {
                this.O00000o0 = 1;
            }
        } else if (z) {
            int i3 = this.O00000Oo;
            if (i3 == 5) {
                this.O00000o0 = 1;
            } else if (i3 == 6) {
                this.O00000o0 = 0;
            }
        } else {
            int i4 = this.O00000Oo;
            if (i4 == 5) {
                this.O00000o0 = 0;
            } else if (i4 == 6) {
                this.O00000o0 = 1;
            }
        }
        if (constraintWidget instanceof oOo00ooO) {
            ((oOo00ooO) constraintWidget).f2334O000000o = this.O00000o0;
        }
    }

    public final void O000000o(ConstraintWidget constraintWidget, boolean z) {
        O000000o(constraintWidget, this.O00000Oo, z);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(AttributeSet attributeSet) {
        super.O000000o(attributeSet);
        this.f2799O000000o = new oOo00ooO();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{16842948, 16842965, 16842966, 16842967, 16842968, 16842969, 16842972, 16843039, 16843040, 16843071, 16843072, 16843699, 16843700, 16843840, R.attr.barrierAllowsGoneWidgets, R.attr.barrierDirection, R.attr.barrierMargin, R.attr.chainUseRtl, R.attr.constraintSet, R.attr.constraint_referenced_ids, R.attr.flow_firstHorizontalBias, R.attr.flow_firstHorizontalStyle, R.attr.flow_firstVerticalBias, R.attr.flow_firstVerticalStyle, R.attr.flow_horizontalAlign, R.attr.flow_horizontalBias, R.attr.flow_horizontalGap, R.attr.flow_horizontalStyle, R.attr.flow_lastHorizontalBias, R.attr.flow_lastHorizontalStyle, R.attr.flow_lastVerticalBias, R.attr.flow_lastVerticalStyle, R.attr.flow_maxElementsWrap, R.attr.flow_verticalAlign, R.attr.flow_verticalBias, R.attr.flow_verticalGap, R.attr.flow_verticalStyle, R.attr.flow_wrapMode, R.attr.layoutDescription, R.attr.layout_constrainedHeight, R.attr.layout_constrainedWidth, R.attr.layout_constraintBaseline_creator, R.attr.layout_constraintBaseline_toBaselineOf, R.attr.layout_constraintBottom_creator, R.attr.layout_constraintBottom_toBottomOf, R.attr.layout_constraintBottom_toTopOf, R.attr.layout_constraintCircle, R.attr.layout_constraintCircleAngle, R.attr.layout_constraintCircleRadius, R.attr.layout_constraintDimensionRatio, R.attr.layout_constraintEnd_toEndOf, R.attr.layout_constraintEnd_toStartOf, R.attr.layout_constraintGuide_begin, R.attr.layout_constraintGuide_end, R.attr.layout_constraintGuide_percent, R.attr.layout_constraintHeight_default, R.attr.layout_constraintHeight_max, R.attr.layout_constraintHeight_min, R.attr.layout_constraintHeight_percent, R.attr.layout_constraintHorizontal_bias, R.attr.layout_constraintHorizontal_chainStyle, R.attr.layout_constraintHorizontal_weight, R.attr.layout_constraintLeft_creator, R.attr.layout_constraintLeft_toLeftOf, R.attr.layout_constraintLeft_toRightOf, R.attr.layout_constraintRight_creator, R.attr.layout_constraintRight_toLeftOf, R.attr.layout_constraintRight_toRightOf, R.attr.layout_constraintStart_toEndOf, R.attr.layout_constraintStart_toStartOf, R.attr.layout_constraintTag, R.attr.layout_constraintTop_creator, R.attr.layout_constraintTop_toBottomOf, R.attr.layout_constraintTop_toTopOf, R.attr.layout_constraintVertical_bias, R.attr.layout_constraintVertical_chainStyle, R.attr.layout_constraintVertical_weight, R.attr.layout_constraintWidth_default, R.attr.layout_constraintWidth_max, R.attr.layout_constraintWidth_min, R.attr.layout_constraintWidth_percent, R.attr.layout_editor_absoluteX, R.attr.layout_editor_absoluteY, R.attr.layout_goneMarginBottom, R.attr.layout_goneMarginEnd, R.attr.layout_goneMarginLeft, R.attr.layout_goneMarginRight, R.attr.layout_goneMarginStart, R.attr.layout_goneMarginTop, R.attr.layout_optimizationLevel});
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 15) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == 14) {
                    this.f2799O000000o.O00000Oo = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 16) {
                    this.f2799O000000o.O00000o0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
        }
        this.O0000o00 = this.f2799O000000o;
        O00000Oo();
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f2799O000000o.O00000Oo = z;
    }

    public void setDpMargin(int i) {
        this.f2799O000000o.O00000o0 = (int) ((((float) i) * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getMargin() {
        return this.f2799O000000o.O00000o0;
    }

    public void setMargin(int i) {
        this.f2799O000000o.O00000o0 = i;
    }

    public final void O000000o(oOO0OOo0.O000000o o000000o, oO0O00o0 oo0o00o0, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.O000000o(o000000o, oo0o00o0, layoutParams, sparseArray);
        if (oo0o00o0 instanceof oOo00ooO) {
            oOo00ooO ooo00ooo = (oOo00ooO) oo0o00o0;
            O000000o(ooo00ooo, o000000o.O00000o.O000Ooo, ((oOo0000O) oo0o00o0.O000Oo0).O000oo);
            ooo00ooo.O00000Oo = o000000o.O00000o.O000o0O0;
            ooo00ooo.O00000o0 = o000000o.O00000o.O000OooO;
        }
    }
}
