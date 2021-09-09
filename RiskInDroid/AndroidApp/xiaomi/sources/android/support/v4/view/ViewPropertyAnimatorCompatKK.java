package android.support.v4.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(19)
@RequiresApi(19)
class ViewPropertyAnimatorCompatKK {
    ViewPropertyAnimatorCompatKK() {
    }

    public static void setUpdateListener(final View view, final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        view.animate().setUpdateListener(viewPropertyAnimatorUpdateListener != null ? new ValueAnimator.AnimatorUpdateListener() {
            /* class android.support.v4.view.ViewPropertyAnimatorCompatKK.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                viewPropertyAnimatorUpdateListener.onAnimationUpdate(view);
            }
        } : null);
    }
}
