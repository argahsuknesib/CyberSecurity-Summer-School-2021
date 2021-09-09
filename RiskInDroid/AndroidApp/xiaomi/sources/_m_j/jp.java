package _m_j;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

public interface jp extends Animatable {

    public static abstract class O000000o {
        Animatable2.AnimationCallback mPlatformCallback;

        public void onAnimationEnd(Drawable drawable) {
        }

        public void onAnimationStart(Drawable drawable) {
        }

        /* access modifiers changed from: package-private */
        public Animatable2.AnimationCallback getPlatformCallback() {
            if (this.mPlatformCallback == null) {
                this.mPlatformCallback = new Animatable2.AnimationCallback() {
                    /* class _m_j.jp.O000000o.AnonymousClass1 */

                    public final void onAnimationStart(Drawable drawable) {
                        O000000o.this.onAnimationStart(drawable);
                    }

                    public final void onAnimationEnd(Drawable drawable) {
                        O000000o.this.onAnimationEnd(drawable);
                    }
                };
            }
            return this.mPlatformCallback;
        }
    }
}
