package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaomi.smarthome.R;

public class Layer extends ConstraintHelper {

    /* renamed from: O000000o  reason: collision with root package name */
    ConstraintLayout f2776O000000o;
    protected float O00000Oo = Float.NaN;
    protected float O00000o = Float.NaN;
    protected float O00000o0 = Float.NaN;
    protected float O00000oO = Float.NaN;
    protected float O00000oo = Float.NaN;
    protected float O0000O0o = Float.NaN;
    boolean O0000OOo = true;
    View[] O0000Oo0 = null;
    private float O0000o = Float.NaN;
    private float O0000o0o = Float.NaN;
    private float O0000oO = 1.0f;
    private float O0000oO0 = Float.NaN;
    private float O0000oOO = 1.0f;
    private float O0000oOo = 0.0f;
    private boolean O0000oo;
    private float O0000oo0 = 0.0f;
    private boolean O0000ooO;

    public Layer(Context context) {
        super(context);
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Layer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void O000000o(AttributeSet attributeSet) {
        super.O000000o(attributeSet);
        this.O0000o0 = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{16842948, 16842965, 16842966, 16842967, 16842968, 16842969, 16842972, 16843039, 16843040, 16843071, 16843072, 16843699, 16843700, 16843840, R.attr.barrierAllowsGoneWidgets, R.attr.barrierDirection, R.attr.barrierMargin, R.attr.chainUseRtl, R.attr.constraintSet, R.attr.constraint_referenced_ids, R.attr.flow_firstHorizontalBias, R.attr.flow_firstHorizontalStyle, R.attr.flow_firstVerticalBias, R.attr.flow_firstVerticalStyle, R.attr.flow_horizontalAlign, R.attr.flow_horizontalBias, R.attr.flow_horizontalGap, R.attr.flow_horizontalStyle, R.attr.flow_lastHorizontalBias, R.attr.flow_lastHorizontalStyle, R.attr.flow_lastVerticalBias, R.attr.flow_lastVerticalStyle, R.attr.flow_maxElementsWrap, R.attr.flow_verticalAlign, R.attr.flow_verticalBias, R.attr.flow_verticalGap, R.attr.flow_verticalStyle, R.attr.flow_wrapMode, R.attr.layoutDescription, R.attr.layout_constrainedHeight, R.attr.layout_constrainedWidth, R.attr.layout_constraintBaseline_creator, R.attr.layout_constraintBaseline_toBaselineOf, R.attr.layout_constraintBottom_creator, R.attr.layout_constraintBottom_toBottomOf, R.attr.layout_constraintBottom_toTopOf, R.attr.layout_constraintCircle, R.attr.layout_constraintCircleAngle, R.attr.layout_constraintCircleRadius, R.attr.layout_constraintDimensionRatio, R.attr.layout_constraintEnd_toEndOf, R.attr.layout_constraintEnd_toStartOf, R.attr.layout_constraintGuide_begin, R.attr.layout_constraintGuide_end, R.attr.layout_constraintGuide_percent, R.attr.layout_constraintHeight_default, R.attr.layout_constraintHeight_max, R.attr.layout_constraintHeight_min, R.attr.layout_constraintHeight_percent, R.attr.layout_constraintHorizontal_bias, R.attr.layout_constraintHorizontal_chainStyle, R.attr.layout_constraintHorizontal_weight, R.attr.layout_constraintLeft_creator, R.attr.layout_constraintLeft_toLeftOf, R.attr.layout_constraintLeft_toRightOf, R.attr.layout_constraintRight_creator, R.attr.layout_constraintRight_toLeftOf, R.attr.layout_constraintRight_toRightOf, R.attr.layout_constraintStart_toEndOf, R.attr.layout_constraintStart_toStartOf, R.attr.layout_constraintTag, R.attr.layout_constraintTop_creator, R.attr.layout_constraintTop_toBottomOf, R.attr.layout_constraintTop_toTopOf, R.attr.layout_constraintVertical_bias, R.attr.layout_constraintVertical_chainStyle, R.attr.layout_constraintVertical_weight, R.attr.layout_constraintWidth_default, R.attr.layout_constraintWidth_max, R.attr.layout_constraintWidth_min, R.attr.layout_constraintWidth_percent, R.attr.layout_editor_absoluteX, R.attr.layout_editor_absoluteY, R.attr.layout_goneMarginBottom, R.attr.layout_goneMarginEnd, R.attr.layout_goneMarginLeft, R.attr.layout_goneMarginRight, R.attr.layout_goneMarginStart, R.attr.layout_goneMarginTop, R.attr.layout_optimizationLevel});
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 6) {
                    this.O0000oo = true;
                } else if (index == 13) {
                    this.O0000ooO = true;
                }
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2776O000000o = (ConstraintLayout) getParent();
        if (this.O0000oo || this.O0000ooO) {
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i = 0; i < this.O0000OoO; i++) {
                View viewById = this.f2776O000000o.getViewById(this.O0000Oo[i]);
                if (viewById != null) {
                    if (this.O0000oo) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.O0000ooO && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public final void O000000o(ConstraintLayout constraintLayout) {
        this.f2776O000000o = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f || !Float.isNaN(this.O0000oO0)) {
            this.O0000oO0 = rotation;
        }
    }

    public void setRotation(float f) {
        this.O0000oO0 = f;
        O00000oo();
    }

    public void setScaleX(float f) {
        this.O0000oO = f;
        O00000oo();
    }

    public void setScaleY(float f) {
        this.O0000oOO = f;
        O00000oo();
    }

    public void setPivotX(float f) {
        this.O0000o0o = f;
        O00000oo();
    }

    public void setPivotY(float f) {
        this.O0000o = f;
        O00000oo();
    }

    public void setTranslationX(float f) {
        this.O0000oOo = f;
        O00000oo();
    }

    public void setTranslationY(float f) {
        this.O0000oo0 = f;
        O00000oo();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        O00000o0();
    }

    public void setElevation(float f) {
        super.setElevation(f);
        O00000o0();
    }

    public final void O000000o() {
        O00000o();
        this.O00000Oo = Float.NaN;
        this.O00000o0 = Float.NaN;
        ConstraintWidget constraintWidget = ((ConstraintLayout.LayoutParams) getLayoutParams()).O000o0o0;
        constraintWidget.O00000oO(0);
        constraintWidget.O00000oo(0);
        O00000oO();
        layout(((int) this.O00000oo) - getPaddingLeft(), ((int) this.O0000O0o) - getPaddingTop(), ((int) this.O00000o) + getPaddingRight(), ((int) this.O00000oO) + getPaddingBottom());
        if (!Float.isNaN(this.O0000oO0)) {
            O00000oo();
        }
    }

    private void O00000o() {
        if (this.f2776O000000o != null && this.O0000OoO != 0) {
            View[] viewArr = this.O0000Oo0;
            if (viewArr == null || viewArr.length != this.O0000OoO) {
                this.O0000Oo0 = new View[this.O0000OoO];
            }
            for (int i = 0; i < this.O0000OoO; i++) {
                this.O0000Oo0[i] = this.f2776O000000o.getViewById(this.O0000Oo[i]);
            }
        }
    }

    private void O00000oO() {
        if (this.f2776O000000o != null) {
            if (!this.O0000OOo && !Float.isNaN(this.O00000Oo) && !Float.isNaN(this.O00000o0)) {
                return;
            }
            if (Float.isNaN(this.O0000o0o) || Float.isNaN(this.O0000o)) {
                View[] O00000o02 = O00000o0(this.f2776O000000o);
                int left = O00000o02[0].getLeft();
                int top = O00000o02[0].getTop();
                int right = O00000o02[0].getRight();
                int bottom = O00000o02[0].getBottom();
                for (int i = 0; i < this.O0000OoO; i++) {
                    View view = O00000o02[i];
                    left = Math.min(left, view.getLeft());
                    top = Math.min(top, view.getTop());
                    right = Math.max(right, view.getRight());
                    bottom = Math.max(bottom, view.getBottom());
                }
                this.O00000o = (float) right;
                this.O00000oO = (float) bottom;
                this.O00000oo = (float) left;
                this.O0000O0o = (float) top;
                if (Float.isNaN(this.O0000o0o)) {
                    this.O00000Oo = (float) ((left + right) / 2);
                } else {
                    this.O00000Oo = this.O0000o0o;
                }
                if (Float.isNaN(this.O0000o)) {
                    this.O00000o0 = (float) ((top + bottom) / 2);
                } else {
                    this.O00000o0 = this.O0000o;
                }
            } else {
                this.O00000o0 = this.O0000o;
                this.O00000Oo = this.O0000o0o;
            }
        }
    }

    private void O00000oo() {
        if (this.f2776O000000o != null) {
            if (this.O0000Oo0 == null) {
                O00000o();
            }
            O00000oO();
            double radians = Math.toRadians((double) this.O0000oO0);
            float sin = (float) Math.sin(radians);
            float cos = (float) Math.cos(radians);
            float f = this.O0000oO;
            float f2 = f * cos;
            float f3 = this.O0000oOO;
            float f4 = (-f3) * sin;
            float f5 = f * sin;
            float f6 = f3 * cos;
            for (int i = 0; i < this.O0000OoO; i++) {
                View view = this.O0000Oo0[i];
                float left = ((float) ((view.getLeft() + view.getRight()) / 2)) - this.O00000Oo;
                float top = ((float) ((view.getTop() + view.getBottom()) / 2)) - this.O00000o0;
                view.setTranslationX((((f2 * left) + (f4 * top)) - left) + this.O0000oOo);
                view.setTranslationY((((left * f5) + (f6 * top)) - top) + this.O0000oo0);
                view.setScaleY(this.O0000oOO);
                view.setScaleX(this.O0000oO);
                view.setRotation(this.O0000oO0);
            }
        }
    }
}
