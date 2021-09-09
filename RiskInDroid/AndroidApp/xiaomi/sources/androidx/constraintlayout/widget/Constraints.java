package androidx.constraintlayout.widget;

import _m_j.oOO0OOo0;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaomi.smarthome.R;

public class Constraints extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    oOO0OOo0 f2807O000000o;

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
        super.setVisibility(8);
    }

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public boolean O000o;
        public float O000o0oo;
        public float O000oO;
        public float O000oO0;
        public float O000oO00;
        public float O000oO0O;
        public float O000oO0o;
        public float O000oOO;
        public float O000oOO0;
        public float O000oOOO;
        public float O000oOOo;
        public float O000oOo;
        public float O000oOo0;

        public LayoutParams() {
            super(-2, -2);
            this.O000o0oo = 1.0f;
            this.O000o = false;
            this.O000oO00 = 0.0f;
            this.O000oO0 = 0.0f;
            this.O000oO0O = 0.0f;
            this.O000oO0o = 0.0f;
            this.O000oO = 1.0f;
            this.O000oOO0 = 1.0f;
            this.O000oOO = 0.0f;
            this.O000oOOO = 0.0f;
            this.O000oOOo = 0.0f;
            this.O000oOo0 = 0.0f;
            this.O000oOo = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.O000o0oo = 1.0f;
            this.O000o = false;
            this.O000oO00 = 0.0f;
            this.O000oO0 = 0.0f;
            this.O000oO0O = 0.0f;
            this.O000oO0o = 0.0f;
            this.O000oO = 1.0f;
            this.O000oOO0 = 1.0f;
            this.O000oOO = 0.0f;
            this.O000oOOO = 0.0f;
            this.O000oOOo = 0.0f;
            this.O000oOo0 = 0.0f;
            this.O000oOo = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842948, 16842960, 16842972, 16842996, 16842997, 16842999, 16843000, 16843001, 16843002, 16843039, 16843040, 16843071, 16843072, 16843189, 16843190, 16843551, 16843552, 16843553, 16843554, 16843555, 16843556, 16843557, 16843558, 16843559, 16843560, 16843701, 16843702, 16843770, 16843840, R.attr.animate_relativeTo, R.attr.barrierAllowsGoneWidgets, R.attr.barrierDirection, R.attr.barrierMargin, R.attr.chainUseRtl, R.attr.constraint_referenced_ids, R.attr.deriveConstraintsFrom, R.attr.drawPath, R.attr.flow_firstHorizontalBias, R.attr.flow_firstHorizontalStyle, R.attr.flow_firstVerticalBias, R.attr.flow_firstVerticalStyle, R.attr.flow_horizontalAlign, R.attr.flow_horizontalBias, R.attr.flow_horizontalGap, R.attr.flow_horizontalStyle, R.attr.flow_lastHorizontalBias, R.attr.flow_lastHorizontalStyle, R.attr.flow_lastVerticalBias, R.attr.flow_lastVerticalStyle, R.attr.flow_maxElementsWrap, R.attr.flow_verticalAlign, R.attr.flow_verticalBias, R.attr.flow_verticalGap, R.attr.flow_verticalStyle, R.attr.flow_wrapMode, R.attr.layout_constrainedHeight, R.attr.layout_constrainedWidth, R.attr.layout_constraintBaseline_creator, R.attr.layout_constraintBaseline_toBaselineOf, R.attr.layout_constraintBottom_creator, R.attr.layout_constraintBottom_toBottomOf, R.attr.layout_constraintBottom_toTopOf, R.attr.layout_constraintCircle, R.attr.layout_constraintCircleAngle, R.attr.layout_constraintCircleRadius, R.attr.layout_constraintDimensionRatio, R.attr.layout_constraintEnd_toEndOf, R.attr.layout_constraintEnd_toStartOf, R.attr.layout_constraintGuide_begin, R.attr.layout_constraintGuide_end, R.attr.layout_constraintGuide_percent, R.attr.layout_constraintHeight_default, R.attr.layout_constraintHeight_max, R.attr.layout_constraintHeight_min, R.attr.layout_constraintHeight_percent, R.attr.layout_constraintHorizontal_bias, R.attr.layout_constraintHorizontal_chainStyle, R.attr.layout_constraintHorizontal_weight, R.attr.layout_constraintLeft_creator, R.attr.layout_constraintLeft_toLeftOf, R.attr.layout_constraintLeft_toRightOf, R.attr.layout_constraintRight_creator, R.attr.layout_constraintRight_toLeftOf, R.attr.layout_constraintRight_toRightOf, R.attr.layout_constraintStart_toEndOf, R.attr.layout_constraintStart_toStartOf, R.attr.layout_constraintTag, R.attr.layout_constraintTop_creator, R.attr.layout_constraintTop_toBottomOf, R.attr.layout_constraintTop_toTopOf, R.attr.layout_constraintVertical_bias, R.attr.layout_constraintVertical_chainStyle, R.attr.layout_constraintVertical_weight, R.attr.layout_constraintWidth_default, R.attr.layout_constraintWidth_max, R.attr.layout_constraintWidth_min, R.attr.layout_constraintWidth_percent, R.attr.layout_editor_absoluteX, R.attr.layout_editor_absoluteY, R.attr.layout_goneMarginBottom, R.attr.layout_goneMarginEnd, R.attr.layout_goneMarginLeft, R.attr.layout_goneMarginRight, R.attr.layout_goneMarginStart, R.attr.layout_goneMarginTop, R.attr.motionProgress, R.attr.motionStagger, R.attr.pathMotionArc, R.attr.pivotAnchor, R.attr.transitionEasing, R.attr.transitionPathRotate});
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 15) {
                    this.O000o0oo = obtainStyledAttributes.getFloat(index, this.O000o0oo);
                } else if (index == 28) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.O000oO00 = obtainStyledAttributes.getFloat(index, this.O000oO00);
                        this.O000o = true;
                    }
                } else if (index == 23) {
                    this.O000oO0O = obtainStyledAttributes.getFloat(index, this.O000oO0O);
                } else if (index == 24) {
                    this.O000oO0o = obtainStyledAttributes.getFloat(index, this.O000oO0o);
                } else if (index == 22) {
                    this.O000oO0 = obtainStyledAttributes.getFloat(index, this.O000oO0);
                } else if (index == 20) {
                    this.O000oO = obtainStyledAttributes.getFloat(index, this.O000oO);
                } else if (index == 21) {
                    this.O000oOO0 = obtainStyledAttributes.getFloat(index, this.O000oOO0);
                } else if (index == 16) {
                    this.O000oOO = obtainStyledAttributes.getFloat(index, this.O000oOO);
                } else if (index == 17) {
                    this.O000oOOO = obtainStyledAttributes.getFloat(index, this.O000oOOO);
                } else if (index == 18) {
                    this.O000oOOo = obtainStyledAttributes.getFloat(index, this.O000oOOo);
                } else if (index == 19) {
                    this.O000oOo0 = obtainStyledAttributes.getFloat(index, this.O000oOo0);
                } else if (index == 27 && Build.VERSION.SDK_INT >= 21) {
                    this.O000oOo = obtainStyledAttributes.getFloat(index, this.O000oOo);
                }
            }
        }
    }

    private static void O000000o() {
        Log.v("Constraints", " ################# init");
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public oOO0OOo0 getConstraintSet() {
        if (this.f2807O000000o == null) {
            this.f2807O000000o = new oOO0OOo0();
        }
        oOO0OOo0 ooo0ooo0 = this.f2807O000000o;
        int childCount = getChildCount();
        ooo0ooo0.O00000o.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!ooo0ooo0.O00000Oo || id != -1) {
                if (!ooo0ooo0.O00000o.containsKey(Integer.valueOf(id))) {
                    ooo0ooo0.O00000o.put(Integer.valueOf(id), new oOO0OOo0.O000000o());
                }
                oOO0OOo0.O000000o o000000o = ooo0ooo0.O00000o.get(Integer.valueOf(id));
                if (childAt instanceof ConstraintHelper) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) childAt;
                    o000000o.O000000o(id, layoutParams);
                    if (constraintHelper instanceof Barrier) {
                        o000000o.O00000o.O000Oooo = 1;
                        Barrier barrier = (Barrier) constraintHelper;
                        o000000o.O00000o.O000Ooo = barrier.getType();
                        o000000o.O00000o.O000o000 = barrier.getReferencedIds();
                        o000000o.O00000o.O000OooO = barrier.getMargin();
                    }
                }
                o000000o.O000000o(id, layoutParams);
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
        return this.f2807O000000o;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
