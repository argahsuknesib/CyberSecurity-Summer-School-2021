package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

public class PathKeyframe extends Keyframe<PointF> {
    private Path path;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.startValue, keyframe.endValue, keyframe.interpolator, keyframe.startFrame, keyframe.endFrame);
        boolean z = (this.endValue == null || this.startValue == null || !((PointF) this.startValue).equals(((PointF) this.endValue).x, ((PointF) this.endValue).y)) ? false : true;
        if (this.endValue != null && !z) {
            this.path = Utils.createPath((PointF) this.startValue, (PointF) this.endValue, keyframe.pathCp1, keyframe.pathCp2);
        }
    }

    /* access modifiers changed from: package-private */
    public Path getPath() {
        return this.path;
    }
}
