package _m_j;

import android.transition.SidePropagation;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.ViewGroup;

public final class dft extends SidePropagation {
    public final long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        long startDelay = super.getStartDelay(viewGroup, transition, transitionValues, transitionValues2);
        if (startDelay != 0) {
            return (transitionValues2 == null || getViewVisibility(transitionValues) == 0) ? -startDelay : startDelay;
        }
        return startDelay;
    }
}
