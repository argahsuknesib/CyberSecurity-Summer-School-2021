package com.google.android.material.transition.platform;

class FadeModeEvaluators {
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() {
        /* class com.google.android.material.transition.platform.FadeModeEvaluators.AnonymousClass3 */

        public final FadeModeResult evaluate(float f, float f2, float f3) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f2, f3, f), TransitionUtils.lerp(0, 255, f2, f3, f));
        }
    };
    private static final FadeModeEvaluator IN = new FadeModeEvaluator() {
        /* class com.google.android.material.transition.platform.FadeModeEvaluators.AnonymousClass1 */

        public final FadeModeResult evaluate(float f, float f2, float f3) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f2, f3, f));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() {
        /* class com.google.android.material.transition.platform.FadeModeEvaluators.AnonymousClass2 */

        public final FadeModeResult evaluate(float f, float f2, float f3) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f2, f3, f), 255);
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() {
        /* class com.google.android.material.transition.platform.FadeModeEvaluators.AnonymousClass4 */

        public final FadeModeResult evaluate(float f, float f2, float f3) {
            float f4 = ((f3 - f2) * 0.35f) + f2;
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f2, f4, f), TransitionUtils.lerp(0, 255, f4, f3, f));
        }
    };

    static FadeModeEvaluator get(int i, boolean z) {
        if (i == 0) {
            return z ? IN : OUT;
        }
        if (i == 1) {
            return z ? OUT : IN;
        }
        if (i == 2) {
            return CROSS;
        }
        if (i == 3) {
            return THROUGH;
        }
        throw new IllegalArgumentException("Invalid fade mode: ".concat(String.valueOf(i)));
    }

    private FadeModeEvaluators() {
    }
}
