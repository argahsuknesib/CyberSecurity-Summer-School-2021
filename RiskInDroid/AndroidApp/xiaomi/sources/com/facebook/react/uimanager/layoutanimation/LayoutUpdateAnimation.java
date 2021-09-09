package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;

class LayoutUpdateAnimation extends AbstractLayoutAnimation {
    LayoutUpdateAnimation() {
    }

    /* access modifiers changed from: package-private */
    public boolean isValid() {
        return this.mDurationMs > 0;
    }

    /* access modifiers changed from: package-private */
    public Animation createAnimationImpl(View view, int i, int i2, int i3, int i4) {
        boolean z = false;
        boolean z2 = (view.getX() == ((float) i) && view.getY() == ((float) i2)) ? false : true;
        if (!(view.getWidth() == i3 && view.getHeight() == i4)) {
            z = true;
        }
        if (z2 || z) {
            return new PositionAndSizeAnimation(view, i, i2, i3, i4);
        }
        return null;
    }
}
