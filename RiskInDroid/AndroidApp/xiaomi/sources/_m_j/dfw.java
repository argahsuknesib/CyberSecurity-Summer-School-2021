package _m_j;

import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.transition.Visibility;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

final class dfw {
    static Transition O000000o(ReadableMap readableMap) {
        String string = readableMap.getString("type");
        if ("group".equals(string)) {
            return O00000Oo(readableMap);
        }
        if ("in".equals(string)) {
            return O00000o0(readableMap);
        }
        if ("out".equals(string)) {
            return O00000o(readableMap);
        }
        if ("change".equals(string)) {
            return O00000oO(readableMap);
        }
        throw new JSApplicationIllegalArgumentException("Unrecognized transition type ".concat(String.valueOf(string)));
    }

    private static Transition O00000Oo(ReadableMap readableMap) {
        TransitionSet transitionSet = new TransitionSet();
        if (!readableMap.hasKey("sequence") || !readableMap.getBoolean("sequence")) {
            transitionSet.setOrdering(0);
        } else {
            transitionSet.setOrdering(1);
        }
        ReadableArray array = readableMap.getArray("transitions");
        int size = array.size();
        for (int i = 0; i < size; i++) {
            Transition O000000o2 = O000000o(array.getMap(i));
            if (O000000o2 != null) {
                transitionSet.addTransition(O000000o2);
            }
        }
        return transitionSet;
    }

    private static Transition O00000o0(ReadableMap readableMap) {
        Visibility O000000o2 = O000000o(readableMap.getString("animation"));
        if (O000000o2 == null) {
            return null;
        }
        O000000o2.setMode(1);
        O000000o(O000000o2, readableMap);
        return O000000o2;
    }

    private static Transition O00000o(ReadableMap readableMap) {
        Visibility O000000o2 = O000000o(readableMap.getString("animation"));
        if (O000000o2 == null) {
            return null;
        }
        O000000o2.setMode(2);
        O000000o(O000000o2, readableMap);
        return O000000o2;
    }

    private static Transition O00000oO(ReadableMap readableMap) {
        ChangeBounds changeBounds = new ChangeBounds();
        ChangeTransform changeTransform = new ChangeTransform();
        O000000o(changeBounds, readableMap);
        O000000o(changeTransform, readableMap);
        return new TransitionSet().addTransition(changeBounds).addTransition(changeTransform);
    }

    private static Visibility O000000o(String str) {
        if (str == null || "none".equals(str)) {
            return null;
        }
        if ("fade".equals(str)) {
            return new Fade(3);
        }
        if ("scale".equals(str)) {
            return new dfu();
        }
        if ("slide-top".equals(str)) {
            return new Slide(48);
        }
        if ("slide-bottom".equals(str)) {
            return new Slide(80);
        }
        if ("slide-right".equals(str)) {
            return new Slide(5);
        }
        if ("slide-left".equals(str)) {
            return new Slide(3);
        }
        throw new JSApplicationIllegalArgumentException("Invalid transition type ".concat(String.valueOf(str)));
    }

    private static void O000000o(Transition transition, ReadableMap readableMap) {
        if (readableMap.hasKey("durationMs")) {
            transition.setDuration((long) readableMap.getInt("durationMs"));
        }
        if (readableMap.hasKey("interpolation")) {
            String string = readableMap.getString("interpolation");
            if (string.equals("easeIn")) {
                transition.setInterpolator(new AccelerateInterpolator());
            } else if (string.equals("easeOut")) {
                transition.setInterpolator(new DecelerateInterpolator());
            } else if (string.equals("easeInOut")) {
                transition.setInterpolator(new AccelerateDecelerateInterpolator());
            } else if (string.equals("linear")) {
                transition.setInterpolator(new LinearInterpolator());
            } else {
                throw new JSApplicationIllegalArgumentException("Invalid interpolation type ".concat(String.valueOf(string)));
            }
        }
        if (readableMap.hasKey("propagation")) {
            String string2 = readableMap.getString("propagation");
            dft dft = new dft();
            if ("top".equals(string2)) {
                dft.setSide(80);
            } else if ("bottom".equals(string2)) {
                dft.setSide(48);
            } else if ("left".equals(string2)) {
                dft.setSide(5);
            } else if ("right".equals(string2)) {
                dft.setSide(3);
            }
            transition.setPropagation(dft);
        } else {
            transition.setPropagation(null);
        }
        if (readableMap.hasKey("delayMs")) {
            transition.setStartDelay((long) readableMap.getInt("delayMs"));
        }
    }
}
