package com.google.android.material.textfield;

import _m_j.OO0000o;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.textfield.TextInputLayout;
import com.xiaomi.smarthome.R;

class ClearTextEndIconDelegate extends EndIconDelegate {
    public final TextWatcher clearTextEndIconTextWatcher = new TextWatcher() {
        /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass1 */

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (ClearTextEndIconDelegate.this.textInputLayout.getSuffixText() == null) {
                ClearTextEndIconDelegate.this.animateIcon(ClearTextEndIconDelegate.hasText(editable));
            }
        }
    };
    private final TextInputLayout.OnEditTextAttachedListener clearTextOnEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener() {
        /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass3 */

        public void onEditTextAttached(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(editText.hasFocus() && ClearTextEndIconDelegate.hasText(editText.getText()));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(ClearTextEndIconDelegate.this.onFocusChangeListener);
            editText.removeTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
            editText.addTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
        }
    };
    private final TextInputLayout.OnEndIconChangedListener endIconChangedListener = new TextInputLayout.OnEndIconChangedListener() {
        /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass4 */

        public void onEndIconChanged(TextInputLayout textInputLayout, int i) {
            final EditText editText = textInputLayout.getEditText();
            if (editText != null && i == 2) {
                editText.post(new Runnable() {
                    /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass4.AnonymousClass1 */

                    public void run() {
                        editText.removeTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
                    }
                });
                if (editText.getOnFocusChangeListener() == ClearTextEndIconDelegate.this.onFocusChangeListener) {
                    editText.setOnFocusChangeListener(null);
                }
            }
        }
    };
    private AnimatorSet iconInAnim;
    private ValueAnimator iconOutAnim;
    public final View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
        /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass2 */

        public void onFocusChange(View view, boolean z) {
            boolean z2 = true;
            boolean z3 = !TextUtils.isEmpty(((EditText) view).getText());
            ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
            if (!z3 || !z) {
                z2 = false;
            }
            clearTextEndIconDelegate.animateIcon(z2);
        }
    };

    ClearTextEndIconDelegate(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    /* access modifiers changed from: package-private */
    public void initialize() {
        this.textInputLayout.setEndIconDrawable(OO0000o.O00000Oo(this.context, R.drawable.mtrl_ic_cancel));
        this.textInputLayout.setEndIconContentDescription(this.textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.textInputLayout.setEndIconOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass5 */

            public void onClick(View view) {
                Editable text = ClearTextEndIconDelegate.this.textInputLayout.getEditText().getText();
                if (text != null) {
                    text.clear();
                }
                ClearTextEndIconDelegate.this.textInputLayout.refreshEndIconDrawableState();
            }
        });
        this.textInputLayout.addOnEditTextAttachedListener(this.clearTextOnEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
        initAnimators();
    }

    /* access modifiers changed from: package-private */
    public void onSuffixVisibilityChanged(boolean z) {
        if (this.textInputLayout.getSuffixText() != null) {
            animateIcon(z);
        }
    }

    public void animateIcon(boolean z) {
        boolean z2 = this.textInputLayout.isEndIconVisible() == z;
        if (z && !this.iconInAnim.isRunning()) {
            this.iconOutAnim.cancel();
            this.iconInAnim.start();
            if (z2) {
                this.iconInAnim.end();
            }
        } else if (!z) {
            this.iconInAnim.cancel();
            this.iconOutAnim.start();
            if (z2) {
                this.iconOutAnim.end();
            }
        }
    }

    private void initAnimators() {
        ValueAnimator scaleAnimator = getScaleAnimator();
        ValueAnimator alphaAnimator = getAlphaAnimator(0.0f, 1.0f);
        this.iconInAnim = new AnimatorSet();
        this.iconInAnim.playTogether(scaleAnimator, alphaAnimator);
        this.iconInAnim.addListener(new AnimatorListenerAdapter() {
            /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass6 */

            public void onAnimationStart(Animator animator) {
                ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(true);
            }
        });
        this.iconOutAnim = getAlphaAnimator(1.0f, 0.0f);
        this.iconOutAnim.addListener(new AnimatorListenerAdapter() {
            /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass7 */

            public void onAnimationEnd(Animator animator) {
                ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(false);
            }
        });
    }

    private ValueAnimator getAlphaAnimator(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass8 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClearTextEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    private ValueAnimator getScaleAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.textfield.ClearTextEndIconDelegate.AnonymousClass9 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ClearTextEndIconDelegate.this.endIconView.setScaleX(floatValue);
                ClearTextEndIconDelegate.this.endIconView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }

    public static boolean hasText(Editable editable) {
        return editable.length() > 0;
    }
}
