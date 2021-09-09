package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;

final class PreHoneycombCompat {
    static Property<View, Float> ALPHA = new FloatProperty<View>("alpha") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.AnonymousClass1 */

        public final void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setAlpha(f);
        }

        public final Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getAlpha());
        }
    };
    static Property<View, Float> PIVOT_X = new FloatProperty<View>("pivotX") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.AnonymousClass2 */

        public final void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setPivotX(f);
        }

        public final Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getPivotX());
        }
    };
    static Property<View, Float> PIVOT_Y = new FloatProperty<View>("pivotY") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.AnonymousClass3 */

        public final void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setPivotY(f);
        }

        public final Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getPivotY());
        }
    };
    static Property<View, Float> ROTATION = new FloatProperty<View>("rotation") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.AnonymousClass6 */

        public final void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setRotation(f);
        }

        public final Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotation());
        }
    };
    static Property<View, Float> ROTATION_X = new FloatProperty<View>("rotationX") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.AnonymousClass7 */

        public final void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setRotationX(f);
        }

        public final Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotationX());
        }
    };
    static Property<View, Float> ROTATION_Y = new FloatProperty<View>("rotationY") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.AnonymousClass8 */

        public final void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setRotationY(f);
        }

        public final Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotationY());
        }
    };
    static Property<View, Float> SCALE_X = new FloatProperty<View>("scaleX") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.AnonymousClass9 */

        public final void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setScaleX(f);
        }

        public final Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getScaleX());
        }
    };
    static Property<View, Float> SCALE_Y = new FloatProperty<View>("scaleY") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.AnonymousClass10 */

        public final void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setScaleY(f);
        }

        public final Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getScaleY());
        }
    };
    static Property<View, Integer> SCROLL_X = new IntProperty<View>("scrollX") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.AnonymousClass11 */

        public final void setValue(View view, int i) {
            AnimatorProxy.wrap(view).setScrollX(i);
        }

        public final Integer get(View view) {
            return Integer.valueOf(AnimatorProxy.wrap(view).getScrollX());
        }
    };
    static Property<View, Integer> SCROLL_Y = new IntProperty<View>("scrollY") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.AnonymousClass12 */

        public final void setValue(View view, int i) {
            AnimatorProxy.wrap(view).setScrollY(i);
        }

        public final Integer get(View view) {
            return Integer.valueOf(AnimatorProxy.wrap(view).getScrollY());
        }
    };
    static Property<View, Float> TRANSLATION_X = new FloatProperty<View>("translationX") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.AnonymousClass4 */

        public final void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setTranslationX(f);
        }

        public final Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getTranslationX());
        }
    };
    static Property<View, Float> TRANSLATION_Y = new FloatProperty<View>("translationY") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.AnonymousClass5 */

        public final void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setTranslationY(f);
        }

        public final Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getTranslationY());
        }
    };
    static Property<View, Float> X = new FloatProperty<View>("x") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.AnonymousClass13 */

        public final void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setX(f);
        }

        public final Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getX());
        }
    };
    static Property<View, Float> Y = new FloatProperty<View>("y") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.AnonymousClass14 */

        public final void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setY(f);
        }

        public final Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getY());
        }
    };

    private PreHoneycombCompat() {
    }
}
