package com.payu.magicretry.WaitingDots;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.Iterator;

public class DotsTextView extends TextView {
    private boolean autoPlay;
    private JumpingSpan dotOne;
    private JumpingSpan dotThree;
    private JumpingSpan dotTwo;
    private Handler handler;
    private boolean isHide;
    private boolean isPlaying;
    private int jumpHeight;
    private boolean lockDotOne;
    private boolean lockDotThree;
    private boolean lockDotTwo;
    private AnimatorSet mAnimatorSet = new AnimatorSet();
    private int period;
    private int showSpeed = 700;
    private long startTime;
    private float textWidth;

    public DotsTextView(Context context) {
        super(context);
        init(context, null);
    }

    public DotsTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public DotsTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.handler = new Handler(Looper.getMainLooper());
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.autoplay, R.attr.dotsColor, R.attr.jumpHeight, R.attr.period});
            this.period = obtainStyledAttributes.getInt(3, 6000);
            this.jumpHeight = obtainStyledAttributes.getInt(2, (int) (getTextSize() / 4.0f));
            this.autoPlay = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }
        this.dotOne = new JumpingSpan();
        this.dotTwo = new JumpingSpan();
        this.dotThree = new JumpingSpan();
        SpannableString spannableString = new SpannableString("...");
        spannableString.setSpan(this.dotOne, 0, 1, 33);
        spannableString.setSpan(this.dotTwo, 1, 2, 33);
        spannableString.setSpan(this.dotThree, 2, 3, 33);
        setText(spannableString, TextView.BufferType.SPANNABLE);
        this.textWidth = getPaint().measureText(".", 0, 1);
        ObjectAnimator createDotJumpAnimator = createDotJumpAnimator(this.dotOne, 0);
        createDotJumpAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.payu.magicretry.WaitingDots.DotsTextView.AnonymousClass1 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DotsTextView.this.invalidate();
            }
        });
        this.mAnimatorSet.playTogether(createDotJumpAnimator, createDotJumpAnimator(this.dotTwo, (long) (this.period / 6)), createDotJumpAnimator(this.dotThree, (long) ((this.period * 2) / 6)));
        boolean z = this.autoPlay;
        this.isPlaying = z;
        if (z) {
            start();
        }
    }

    public void start() {
        this.isPlaying = true;
        setAllAnimationsRepeatCount(-1);
        this.mAnimatorSet.start();
    }

    private ObjectAnimator createDotJumpAnimator(JumpingSpan jumpingSpan, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(jumpingSpan, "translationY", 0.0f, (float) (-this.jumpHeight));
        ofFloat.setEvaluator(new TypeEvaluator<Number>() {
            /* class com.payu.magicretry.WaitingDots.DotsTextView.AnonymousClass2 */

            public Number evaluate(float f, Number number, Number number2) {
                double d = (double) f;
                Double.isNaN(d);
                double max = Math.max(0.0d, Math.sin(d * 3.141592653589793d * 2.0d));
                double floatValue = (double) (number2.floatValue() - number.floatValue());
                Double.isNaN(floatValue);
                return Double.valueOf(max * floatValue);
            }
        });
        ofFloat.setDuration((long) this.period);
        ofFloat.setStartDelay(j);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        return ofFloat;
    }

    public void stop() {
        this.isPlaying = false;
        setAllAnimationsRepeatCount(0);
    }

    private void setAllAnimationsRepeatCount(int i) {
        Iterator<Animator> it = this.mAnimatorSet.getChildAnimations().iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (next instanceof ObjectAnimator) {
                ((ObjectAnimator) next).setRepeatCount(i);
            }
        }
    }

    public void hide() {
        createDotHideAnimator(this.dotThree, 2.0f).start();
        ObjectAnimator createDotHideAnimator = createDotHideAnimator(this.dotTwo, 1.0f);
        createDotHideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.payu.magicretry.WaitingDots.DotsTextView.AnonymousClass3 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DotsTextView.this.invalidate();
            }
        });
        createDotHideAnimator.start();
        this.isHide = true;
    }

    public void show() {
        createDotShowAnimator(this.dotThree, 2).start();
        ObjectAnimator createDotShowAnimator = createDotShowAnimator(this.dotTwo, 1);
        createDotShowAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.payu.magicretry.WaitingDots.DotsTextView.AnonymousClass4 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DotsTextView.this.invalidate();
            }
        });
        createDotShowAnimator.start();
        this.isHide = false;
    }

    private ObjectAnimator createDotHideAnimator(JumpingSpan jumpingSpan, float f) {
        return createDotHorizontalAnimator(jumpingSpan, 0.0f, (-this.textWidth) * f);
    }

    private ObjectAnimator createDotShowAnimator(JumpingSpan jumpingSpan, int i) {
        return createDotHorizontalAnimator(jumpingSpan, (-this.textWidth) * ((float) i), 0.0f);
    }

    private ObjectAnimator createDotHorizontalAnimator(JumpingSpan jumpingSpan, float f, float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(jumpingSpan, "translationX", f, f2);
        ofFloat.setDuration((long) this.showSpeed);
        return ofFloat;
    }

    public void showAndPlay() {
        show();
        start();
    }

    public void hideAndStop() {
        hide();
        stop();
    }

    public boolean isHide() {
        return this.isHide;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setJumpHeight(int i) {
        this.jumpHeight = i;
    }

    public void setPeriod(int i) {
        this.period = i;
    }
}
