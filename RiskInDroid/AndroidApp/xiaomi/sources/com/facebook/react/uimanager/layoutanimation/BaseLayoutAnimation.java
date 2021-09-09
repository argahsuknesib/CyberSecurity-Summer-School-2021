package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.facebook.react.uimanager.IllegalViewOperationException;

abstract class BaseLayoutAnimation extends AbstractLayoutAnimation {
    /* access modifiers changed from: package-private */
    public abstract boolean isReverse();

    BaseLayoutAnimation() {
    }

    /* access modifiers changed from: package-private */
    public boolean isValid() {
        return this.mDurationMs > 0 && this.mAnimatedProperty != null;
    }

    /* renamed from: com.facebook.react.uimanager.layoutanimation.BaseLayoutAnimation$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType = new int[AnimatedPropertyType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType[AnimatedPropertyType.OPACITY.ordinal()] = 1;
            $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType[AnimatedPropertyType.SCALE_XY.ordinal()] = 2;
            $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType[AnimatedPropertyType.SCALE_X.ordinal()] = 3;
            try {
                $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType[AnimatedPropertyType.SCALE_Y.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Animation createAnimationImpl(View view, int i, int i2, int i3, int i4) {
        if (this.mAnimatedProperty != null) {
            int i5 = AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType[this.mAnimatedProperty.ordinal()];
            float f = 0.0f;
            if (i5 == 1) {
                float alpha = isReverse() ? view.getAlpha() : 0.0f;
                if (!isReverse()) {
                    f = view.getAlpha();
                }
                return new OpacityAnimation(view, alpha, f);
            } else if (i5 == 2) {
                float f2 = isReverse() ? 1.0f : 0.0f;
                float f3 = isReverse() ? 0.0f : 1.0f;
                return new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
            } else if (i5 == 3) {
                return new ScaleAnimation(isReverse() ? 1.0f : 0.0f, isReverse() ? 0.0f : 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.0f);
            } else if (i5 == 4) {
                return new ScaleAnimation(1.0f, 1.0f, isReverse() ? 1.0f : 0.0f, isReverse() ? 0.0f : 1.0f, 1, 0.0f, 1, 0.5f);
            } else {
                throw new IllegalViewOperationException("Missing animation for property : " + this.mAnimatedProperty);
            }
        } else {
            throw new IllegalViewOperationException("Missing animated property from animation config");
        }
    }
}
