package _m_j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;

public final class hw {

    public interface O000000o {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    public static void O000000o(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter);
        }
    }
}
