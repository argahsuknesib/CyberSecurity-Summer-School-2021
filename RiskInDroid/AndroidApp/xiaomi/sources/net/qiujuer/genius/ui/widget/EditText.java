package net.qiujuer.genius.ui.widget;

import _m_j.izh;
import _m_j.izj;
import _m_j.jag;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Property;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.xiaomi.smarthome.R;

public class EditText extends android.widget.EditText {
    private static final Interpolator ANIMATION_INTERPOLATOR = new DecelerateInterpolator();
    private static final Property<EditText, O00000Oo> TITLE_PROPERTY = new Property<EditText, O00000Oo>(O00000Oo.class, "titleProperty") {
        /* class net.qiujuer.genius.ui.widget.EditText.AnonymousClass2 */

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return ((EditText) obj).mCurTitleProperty;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            ((EditText) obj).setTitleProperty((O00000Oo) obj2);
        }
    };
    private boolean isAttachWindow;
    private boolean isHaveText;
    private ObjectAnimator mAnimator;
    public O00000Oo mCurTitleProperty;
    private int mHintTitleModel;
    private Rect mHintTitlePadding = new Rect();
    private int mHintTitleTextSize;
    private ColorStateList mLineColor;
    private int mLineSize;
    private TextWatcher mTextWatcher;
    private TextPaint mTitlePaint;
    private int mTruePaddingTop;

    public EditText(Context context) {
        super(context);
    }

    public EditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, R.attr.gEditTextStyle, 2132738382);
    }

    public EditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i, 2132738382);
    }

    @TargetApi(21)
    public EditText(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet, i, i2);
    }

    private void init(AttributeSet attributeSet, int i, int i2) {
        int i3;
        Typeface O000000o2;
        ColorStateList colorStateList;
        AttributeSet attributeSet2 = attributeSet;
        if (attributeSet2 != null) {
            this.mTruePaddingTop = super.getPaddingTop();
            Context context = getContext();
            Resources resources = getResources();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet2, new int[]{R.attr.gFont, R.attr.gHintTitle, R.attr.gHintTitlePaddingBottom, R.attr.gHintTitlePaddingLeft, R.attr.gHintTitlePaddingRight, R.attr.gHintTitlePaddingTop, R.attr.gHintTitleTextSize, R.attr.gLineColor, R.attr.gLineSize}, i, i2);
            String string = obtainStyledAttributes.getString(0);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, resources.getDimensionPixelSize(R.dimen.g_editText_lineSize));
            ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(7);
            int i4 = obtainStyledAttributes.getInt(1, 1);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(6, resources.getDimensionPixelSize(R.dimen.g_editText_hintTitleTextSize));
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(5, 0);
            int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            int dimensionPixelSize6 = obtainStyledAttributes.getDimensionPixelSize(4, 0);
            obtainStyledAttributes.recycle();
            if (colorStateList2 == null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    colorStateList2 = resources.getColorStateList(R.color.g_default_edit_view_line, null);
                } else {
                    colorStateList2 = resources.getColorStateList(R.color.g_default_edit_view_line);
                }
            }
            if (!izh.O000000o(attributeSet2, "textColorHint") || getHintTextColors() == null) {
                i3 = dimensionPixelSize6;
                if (Build.VERSION.SDK_INT >= 23) {
                    colorStateList = resources.getColorStateList(R.color.g_default_edit_view_hint, null);
                } else {
                    colorStateList = resources.getColorStateList(R.color.g_default_edit_view_hint);
                }
                setHintTextColor(colorStateList);
            } else {
                i3 = dimensionPixelSize6;
            }
            setLineSize(dimensionPixelSize);
            setLineColor(colorStateList2);
            setHintTitleTextSize(dimensionPixelSize2);
            setHintTitleModel(i4);
            if (!isInEditMode() && string != null && string.length() > 0 && (O000000o2 = izh.O000000o(context, string)) != null) {
                setTypeface(O000000o2);
            }
            if (!izh.O000000o(attributeSet2, "background")) {
                initBackground();
            }
            initHintTitleText();
            setHintTitlePadding(dimensionPixelSize5, dimensionPixelSize3, i3, dimensionPixelSize4);
        }
    }

    private void initBackground() {
        StateListDrawable stateListDrawable;
        int lineSize = getLineSize();
        if (lineSize == 0) {
            stateListDrawable = null;
        } else {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.g_editText_lineSize_active_increment) + lineSize;
            int i = lineSize >> 1;
            float f = (float) lineSize;
            ShapeDrawable shapeDrawable = new ShapeDrawable(new jag(new RectF(0.0f, 0.0f, 0.0f, f)));
            shapeDrawable.getPaint().setColor(getLineColor(new int[]{16842910}));
            float f2 = (float) dimensionPixelSize;
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new jag(new RectF(0.0f, 0.0f, 0.0f, f2)));
            shapeDrawable2.getPaint().setColor(getLineColor(new int[]{16842919, 16842910}));
            ShapeDrawable shapeDrawable3 = new ShapeDrawable(new jag(new RectF(0.0f, 0.0f, 0.0f, f2)));
            shapeDrawable3.getPaint().setColor(getLineColor(new int[]{16842908, 16842910}));
            float f3 = (float) i;
            ShapeDrawable shapeDrawable4 = new ShapeDrawable(new jag(new RectF(0.0f, 0.0f, 0.0f, f3), f3, f));
            shapeDrawable4.getPaint().setColor(getLineColor(new int[]{-16842910}));
            stateListDrawable = createStateListDrawable(new Drawable[]{shapeDrawable2, shapeDrawable3, shapeDrawable, shapeDrawable4});
        }
        izj.O000000o(this, stateListDrawable);
    }

    private static StateListDrawable createStateListDrawable(Drawable[] drawableArr) {
        if (drawableArr == null || drawableArr.length < 4) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919, 16842910}, drawableArr[0]);
        stateListDrawable.addState(new int[]{16842908, 16842910}, drawableArr[1]);
        stateListDrawable.addState(new int[]{16842910}, drawableArr[2]);
        stateListDrawable.addState(new int[]{-16842910}, drawableArr[3]);
        return stateListDrawable;
    }

    private void initHintTitleText() {
        if (isShowTitle()) {
            if (this.mTitlePaint == null) {
                this.mTitlePaint = new TextPaint(1);
                this.mTitlePaint.density = getResources().getDisplayMetrics().density;
                this.mTitlePaint.setTextAlign(Paint.Align.LEFT);
                this.mTitlePaint.setTypeface(getTypeface());
            }
            if (this.mTextWatcher == null) {
                this.mTextWatcher = new TextWatcher() {
                    /* class net.qiujuer.genius.ui.widget.EditText.AnonymousClass1 */

                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void afterTextChanged(Editable editable) {
                        EditText.this.checkShowTitle(editable, false);
                    }
                };
                addTextChangedListener(this.mTextWatcher);
            }
            checkShowTitle(getEditableText(), false);
            return;
        }
        TextWatcher textWatcher = this.mTextWatcher;
        if (textWatcher != null) {
            removeTextChangedListener(textWatcher);
            this.mTextWatcher = null;
        }
        this.mTitlePaint = null;
        this.mCurTitleProperty = null;
        this.mAnimator = null;
    }

    public void checkShowTitle(Editable editable, boolean z) {
        if (isShowTitle() && getWidth() > 0) {
            boolean z2 = editable != null && editable.length() > 0;
            if (z2 != this.isHaveText || (z2 && z)) {
                this.isHaveText = z2;
                animateShowTitle(this.isHaveText);
            }
        }
    }

    private boolean isShowTitle() {
        return this.mHintTitleModel != 0;
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
        TextPaint textPaint = this.mTitlePaint;
        if (textPaint != null) {
            textPaint.setTypeface(typeface);
        }
    }

    public int getPaddingTop() {
        return this.mTruePaddingTop;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mTruePaddingTop = i2;
        if (isShowTitle()) {
            i2 += this.mHintTitleTextSize + this.mHintTitlePadding.top + this.mHintTitlePadding.bottom;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public Rect getHintTitlePadding() {
        return this.mHintTitlePadding;
    }

    public void setHintTitlePadding(int i, int i2, int i3, int i4) {
        this.mHintTitlePadding.set(i, i2, i3, i4);
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    public void setLineSize(int i) {
        if (this.mLineSize != i) {
            this.mLineSize = i;
            invalidate();
        }
    }

    public void setLineColor(ColorStateList colorStateList) {
        if (this.mLineColor != colorStateList) {
            this.mLineColor = colorStateList;
            invalidate();
        }
    }

    public void setHintTitleModel(int i) {
        if (this.mHintTitleModel != i) {
            this.mHintTitleModel = i;
            initHintTitleText();
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
            invalidate();
        }
    }

    public void setHintTitleTextSize(int i) {
        if (this.mHintTitleTextSize != i) {
            this.mHintTitleTextSize = i;
            invalidate();
        }
    }

    public int getLineSize() {
        return this.mLineSize;
    }

    public ColorStateList getLineColor() {
        return this.mLineColor;
    }

    private int getLineColor(int[] iArr) {
        ColorStateList lineColor = getLineColor();
        if (lineColor == null) {
            return 0;
        }
        return lineColor.getColorForState(iArr, lineColor.getDefaultColor());
    }

    public int getHintTitleModel() {
        return this.mHintTitleModel;
    }

    public int getTitleTextSize() {
        return this.mHintTitleTextSize;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        O00000Oo o00000Oo;
        CharSequence hint;
        super.onDraw(canvas);
        if (isShowTitle() && this.mTitlePaint != null && (o00000Oo = this.mCurTitleProperty) != null && o00000Oo.O00000Oo != 0 && (hint = getHint()) != null) {
            int currentHintTextColor = getCurrentHintTextColor();
            int O000000o2 = izh.O000000o(Color.alpha(currentHintTextColor), this.mCurTitleProperty.O00000Oo);
            if (currentHintTextColor != 0 && O000000o2 != 0 && this.mCurTitleProperty.f15405O000000o > 0) {
                this.mTitlePaint.setTextSize((float) this.mCurTitleProperty.f15405O000000o);
                this.mTitlePaint.setColor(currentHintTextColor);
                this.mTitlePaint.setAlpha(O000000o2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if ((scrollX | scrollY) == 0) {
                    canvas.drawText(hint, 0, hint.length(), (float) this.mCurTitleProperty.O00000o0, (float) (this.mCurTitleProperty.O00000o + this.mCurTitleProperty.f15405O000000o), this.mTitlePaint);
                    return;
                }
                canvas.translate((float) scrollX, (float) scrollY);
                canvas.drawText(hint, 0, hint.length(), (float) this.mCurTitleProperty.O00000o0, (float) (this.mCurTitleProperty.O00000o + this.mCurTitleProperty.f15405O000000o), this.mTitlePaint);
                canvas.translate((float) (-scrollX), (float) (-scrollY));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttachWindow = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttachWindow = false;
        TextWatcher textWatcher = this.mTextWatcher;
        if (textWatcher != null) {
            removeTextChangedListener(textWatcher);
            this.mTextWatcher = null;
        }
    }

    @TargetApi(19)
    private boolean isAttachWindow() {
        if (Build.VERSION.SDK_INT < 19) {
            return this.isAttachWindow;
        }
        return isAttachedToWindow();
    }

    public void invalidate() {
        if (isAttachWindow()) {
            super.invalidate();
        }
    }

    public void setGravity(int i) {
        int gravity = getGravity();
        super.setGravity(i);
        if (gravity != i) {
            checkShowTitle(getEditableText(), true);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        checkShowTitle(getEditableText(), true);
    }

    public void setTitleProperty(O00000Oo o00000Oo) {
        this.mCurTitleProperty = o00000Oo;
        invalidate();
    }

    private int getTextLen() {
        TextPaint paint = getPaint();
        if (this.mTitlePaint != null) {
            return (int) paint.measureText(getHint().toString());
        }
        return 0;
    }

    private int getHintTextLen(int i) {
        TextPaint textPaint = this.mTitlePaint;
        if (textPaint == null) {
            return 0;
        }
        textPaint.setTextSize((float) i);
        return (int) textPaint.measureText(getHint().toString());
    }

    private O00000Oo getStartProperty(boolean z) {
        O00000Oo o00000Oo = new O00000Oo();
        O00000Oo o00000Oo2 = this.mCurTitleProperty;
        if (o00000Oo2 != null) {
            o00000Oo.f15405O000000o = o00000Oo2.f15405O000000o;
            o00000Oo.O00000Oo = o00000Oo2.O00000Oo;
            o00000Oo.O00000o0 = o00000Oo2.O00000o0;
            o00000Oo.O00000o = o00000Oo2.O00000o;
        } else if (z) {
            copyTextProperty(o00000Oo);
        } else {
            copyHintProperty(o00000Oo);
        }
        return o00000Oo;
    }

    private O00000Oo getEndProperty(boolean z) {
        O00000Oo o00000Oo = new O00000Oo();
        if (z) {
            copyHintProperty(o00000Oo);
        } else {
            copyTextProperty(o00000Oo);
        }
        return o00000Oo;
    }

    @SuppressLint({"RtlHardcoded"})
    private O00000Oo copyTextProperty(O00000Oo o00000Oo) {
        int gravity = getGravity() & 7;
        if (gravity != 1) {
            if (gravity != 3) {
                if (gravity != 5) {
                    if (gravity != 8388611) {
                        if (gravity != 8388613) {
                            o00000Oo.O00000o0 = getPaddingLeft();
                        }
                    }
                }
                o00000Oo.O00000o0 = (getWidth() - getPaddingRight()) - getTextLen();
            }
            o00000Oo.O00000o0 = getPaddingLeft();
        } else {
            int paddingLeft = getPaddingLeft();
            o00000Oo.O00000o0 = (paddingLeft + (((getWidth() - paddingLeft) - getPaddingRight()) >> 1)) - (getTextLen() / 2);
        }
        o00000Oo.O00000Oo = 0;
        o00000Oo.f15405O000000o = (int) getTextSize();
        o00000Oo.O00000o = super.getPaddingTop();
        return o00000Oo;
    }

    @SuppressLint({"RtlHardcoded"})
    private O00000Oo copyHintProperty(O00000Oo o00000Oo) {
        o00000Oo.O00000o = getPaddingTop() + this.mHintTitlePadding.top;
        o00000Oo.O00000Oo = 255;
        o00000Oo.f15405O000000o = this.mHintTitleTextSize;
        int gravity = getGravity() & 7;
        if (gravity != 1) {
            if (gravity != 3) {
                if (gravity != 5) {
                    if (gravity != 8388611) {
                        if (gravity != 8388613) {
                            o00000Oo.O00000o0 = getPaddingLeft() + this.mHintTitlePadding.left;
                        }
                    }
                }
                o00000Oo.O00000o0 = ((getWidth() - getPaddingRight()) - this.mHintTitlePadding.right) - getHintTextLen(o00000Oo.f15405O000000o);
            }
            o00000Oo.O00000o0 = getPaddingLeft() + this.mHintTitlePadding.left;
        } else {
            int paddingLeft = getPaddingLeft() + this.mHintTitlePadding.left;
            o00000Oo.O00000o0 = (paddingLeft + (((getWidth() - paddingLeft) - (getPaddingRight() + this.mHintTitlePadding.right)) >> 1)) - (getHintTextLen(o00000Oo.f15405O000000o) / 2);
        }
        return o00000Oo;
    }

    private void animateShowTitle(boolean z) {
        O00000Oo startProperty = getStartProperty(z);
        O00000Oo endProperty = getEndProperty(z);
        ObjectAnimator titleAnimator = getTitleAnimator();
        titleAnimator.setObjectValues(startProperty, endProperty);
        if (isAttachWindow()) {
            titleAnimator.start();
        } else {
            setTitleProperty(endProperty);
        }
    }

    private ObjectAnimator getTitleAnimator() {
        ObjectAnimator objectAnimator = this.mAnimator;
        if (objectAnimator == null) {
            if (this.mCurTitleProperty == null) {
                this.mCurTitleProperty = new O00000Oo();
            }
            this.mAnimator = ObjectAnimator.ofObject(this, TITLE_PROPERTY, new O000000o(this.mCurTitleProperty), this.mCurTitleProperty);
            this.mAnimator.setDuration(250L);
            this.mAnimator.setInterpolator(ANIMATION_INTERPOLATOR);
        } else {
            objectAnimator.cancel();
        }
        return this.mAnimator;
    }

    static final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f15405O000000o;
        public int O00000Oo = 255;
        public int O00000o;
        public int O00000o0;

        O00000Oo() {
        }
    }

    static final class O000000o implements TypeEvaluator<O00000Oo> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final O00000Oo f15404O000000o;

        public final /* bridge */ /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            O00000Oo o00000Oo = (O00000Oo) obj;
            O00000Oo o00000Oo2 = (O00000Oo) obj2;
            this.f15404O000000o.O00000o0 = (int) (((float) o00000Oo.O00000o0) + (((float) (o00000Oo2.O00000o0 - o00000Oo.O00000o0)) * f));
            this.f15404O000000o.O00000o = (int) (((float) o00000Oo.O00000o) + (((float) (o00000Oo2.O00000o - o00000Oo.O00000o)) * f));
            this.f15404O000000o.f15405O000000o = (int) (((float) o00000Oo.f15405O000000o) + (((float) (o00000Oo2.f15405O000000o - o00000Oo.f15405O000000o)) * f));
            this.f15404O000000o.O00000Oo = (int) (((float) o00000Oo.O00000Oo) + (((float) (o00000Oo2.O00000Oo - o00000Oo.O00000Oo)) * f));
            return this.f15404O000000o;
        }

        O000000o(O00000Oo o00000Oo) {
            this.f15404O000000o = o00000Oo;
        }
    }
}
