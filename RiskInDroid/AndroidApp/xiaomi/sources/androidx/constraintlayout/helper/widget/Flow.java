package androidx.constraintlayout.helper.widget;

import _m_j.oO0O00o0;
import _m_j.oOO0OOo0;
import _m_j.oOo000o0;
import _m_j.oOo0oooO;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.VirtualLayout;
import com.xiaomi.smarthome.R;

public class Flow extends VirtualLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private oOo000o0 f2775O000000o;

    public Flow(Context context) {
        super(context);
    }

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Flow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void O000000o(ConstraintWidget constraintWidget, boolean z) {
        oOo000o0 ooo000o0 = this.f2775O000000o;
        if (ooo000o0.O00O0Ooo <= 0 && ooo000o0.O00O0o00 <= 0) {
            return;
        }
        if (z) {
            ooo000o0.O00O0o0 = ooo000o0.O00O0o00;
            ooo000o0.O00O0o0O = ooo000o0.O00O0Ooo;
            return;
        }
        ooo000o0.O00O0o0 = ooo000o0.O00O0Ooo;
        ooo000o0.O00O0o0O = ooo000o0.O00O0o00;
    }

    @SuppressLint({"WrongCall"})
    public void onMeasure(int i, int i2) {
        O000000o(this.f2775O000000o, i, i2);
    }

    public final void O000000o(oOo0oooO ooo0oooo, int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (ooo0oooo != null) {
            ooo0oooo.O000000o(mode, size, mode2, size2);
            setMeasuredDimension(ooo0oooo.O00O0o, ooo0oooo.O00O0oO0);
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public final void O000000o(oOO0OOo0.O000000o o000000o, oO0O00o0 oo0o00o0, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.O000000o(o000000o, oo0o00o0, layoutParams, sparseArray);
        if (oo0o00o0 instanceof oOo000o0) {
            oOo000o0 ooo000o0 = (oOo000o0) oo0o00o0;
            if (layoutParams.O000Oo0 != -1) {
                ooo000o0.O00O00oO = layoutParams.O000Oo0;
            }
        }
    }

    public final void O000000o(AttributeSet attributeSet) {
        super.O000000o(attributeSet);
        this.f2775O000000o = new oOo000o0();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{16842948, 16842965, 16842966, 16842967, 16842968, 16842969, 16842972, 16843039, 16843040, 16843071, 16843072, 16843699, 16843700, 16843840, R.attr.barrierAllowsGoneWidgets, R.attr.barrierDirection, R.attr.barrierMargin, R.attr.chainUseRtl, R.attr.constraintSet, R.attr.constraint_referenced_ids, R.attr.flow_firstHorizontalBias, R.attr.flow_firstHorizontalStyle, R.attr.flow_firstVerticalBias, R.attr.flow_firstVerticalStyle, R.attr.flow_horizontalAlign, R.attr.flow_horizontalBias, R.attr.flow_horizontalGap, R.attr.flow_horizontalStyle, R.attr.flow_lastHorizontalBias, R.attr.flow_lastHorizontalStyle, R.attr.flow_lastVerticalBias, R.attr.flow_lastVerticalStyle, R.attr.flow_maxElementsWrap, R.attr.flow_verticalAlign, R.attr.flow_verticalBias, R.attr.flow_verticalGap, R.attr.flow_verticalStyle, R.attr.flow_wrapMode, R.attr.layoutDescription, R.attr.layout_constrainedHeight, R.attr.layout_constrainedWidth, R.attr.layout_constraintBaseline_creator, R.attr.layout_constraintBaseline_toBaselineOf, R.attr.layout_constraintBottom_creator, R.attr.layout_constraintBottom_toBottomOf, R.attr.layout_constraintBottom_toTopOf, R.attr.layout_constraintCircle, R.attr.layout_constraintCircleAngle, R.attr.layout_constraintCircleRadius, R.attr.layout_constraintDimensionRatio, R.attr.layout_constraintEnd_toEndOf, R.attr.layout_constraintEnd_toStartOf, R.attr.layout_constraintGuide_begin, R.attr.layout_constraintGuide_end, R.attr.layout_constraintGuide_percent, R.attr.layout_constraintHeight_default, R.attr.layout_constraintHeight_max, R.attr.layout_constraintHeight_min, R.attr.layout_constraintHeight_percent, R.attr.layout_constraintHorizontal_bias, R.attr.layout_constraintHorizontal_chainStyle, R.attr.layout_constraintHorizontal_weight, R.attr.layout_constraintLeft_creator, R.attr.layout_constraintLeft_toLeftOf, R.attr.layout_constraintLeft_toRightOf, R.attr.layout_constraintRight_creator, R.attr.layout_constraintRight_toLeftOf, R.attr.layout_constraintRight_toRightOf, R.attr.layout_constraintStart_toEndOf, R.attr.layout_constraintStart_toStartOf, R.attr.layout_constraintTag, R.attr.layout_constraintTop_creator, R.attr.layout_constraintTop_toBottomOf, R.attr.layout_constraintTop_toTopOf, R.attr.layout_constraintVertical_bias, R.attr.layout_constraintVertical_chainStyle, R.attr.layout_constraintVertical_weight, R.attr.layout_constraintWidth_default, R.attr.layout_constraintWidth_max, R.attr.layout_constraintWidth_min, R.attr.layout_constraintWidth_percent, R.attr.layout_editor_absoluteX, R.attr.layout_editor_absoluteY, R.attr.layout_goneMarginBottom, R.attr.layout_goneMarginEnd, R.attr.layout_goneMarginLeft, R.attr.layout_goneMarginRight, R.attr.layout_goneMarginStart, R.attr.layout_goneMarginTop, R.attr.layout_optimizationLevel});
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.f2775O000000o.O00O00oO = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    this.f2775O000000o.O0000o00(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == 11) {
                    oOo000o0 ooo000o0 = this.f2775O000000o;
                    int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    ooo000o0.O00O0Ooo = dimensionPixelSize;
                    ooo000o0.O00O0o0 = dimensionPixelSize;
                    ooo000o0.O00O0o0O = dimensionPixelSize;
                } else if (index == 12) {
                    this.f2775O000000o.O00O0o00 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.f2775O000000o.O0000o0(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == 3) {
                    this.f2775O000000o.O00O0Oo0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.f2775O000000o.O0000o0O(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == 5) {
                    this.f2775O000000o.O00O0OoO = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 37) {
                    this.f2775O000000o.O00O00o0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 27) {
                    this.f2775O000000o.f2327O000000o = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 36) {
                    this.f2775O000000o.O00000Oo = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 21) {
                    this.f2775O000000o.O00000o0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 29) {
                    this.f2775O000000o.O000ooO0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 23) {
                    this.f2775O000000o.O000oo = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 31) {
                    this.f2775O000000o.O000ooO = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 25) {
                    this.f2775O000000o.O000ooOO = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 20) {
                    this.f2775O000000o.O000ooo0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 28) {
                    this.f2775O000000o.O000oooO = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 22) {
                    this.f2775O000000o.O000ooo = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 30) {
                    this.f2775O000000o.O000oooo = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 34) {
                    this.f2775O000000o.O000ooOo = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 24) {
                    this.f2775O000000o.O00O000o = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 33) {
                    this.f2775O000000o.O00O00Oo = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 26) {
                    this.f2775O000000o.oooOoO = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 35) {
                    this.f2775O000000o.O00oOOoo = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 32) {
                    this.f2775O000000o.O00O00o = obtainStyledAttributes.getInt(index, -1);
                }
            }
        }
        this.O0000o00 = this.f2775O000000o;
        O00000Oo();
    }

    public void setOrientation(int i) {
        this.f2775O000000o.O00O00oO = i;
        requestLayout();
    }

    public void setPadding(int i) {
        this.f2775O000000o.O0000o00(i);
        requestLayout();
    }

    public void setPaddingLeft(int i) {
        this.f2775O000000o.O0000o0(i);
        requestLayout();
    }

    public void setPaddingTop(int i) {
        this.f2775O000000o.O00O0Oo0 = i;
        requestLayout();
    }

    public void setPaddingRight(int i) {
        this.f2775O000000o.O0000o0O(i);
        requestLayout();
    }

    public void setPaddingBottom(int i) {
        this.f2775O000000o.O00O0OoO = i;
        requestLayout();
    }

    public void setWrapMode(int i) {
        this.f2775O000000o.O00O00o0 = i;
        requestLayout();
    }

    public void setHorizontalStyle(int i) {
        this.f2775O000000o.f2327O000000o = i;
        requestLayout();
    }

    public void setVerticalStyle(int i) {
        this.f2775O000000o.O00000Oo = i;
        requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.f2775O000000o.O000ooOO = f;
        requestLayout();
    }

    public void setVerticalBias(float f) {
        this.f2775O000000o.O000ooOo = f;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i) {
        this.f2775O000000o.O00000o0 = i;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i) {
        this.f2775O000000o.O000oo = i;
        requestLayout();
    }

    public void setFirstHorizontalBias(float f) {
        this.f2775O000000o.O000ooo0 = f;
        requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.f2775O000000o.O000ooo = f;
        requestLayout();
    }

    public void setHorizontalAlign(int i) {
        this.f2775O000000o.O00O000o = i;
        requestLayout();
    }

    public void setVerticalAlign(int i) {
        this.f2775O000000o.O00O00Oo = i;
        requestLayout();
    }

    public void setHorizontalGap(int i) {
        this.f2775O000000o.oooOoO = i;
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.f2775O000000o.O00oOOoo = i;
        requestLayout();
    }

    public void setMaxElementsWrap(int i) {
        this.f2775O000000o.O00O00o = i;
        requestLayout();
    }
}
