package com.airbnb.lottie.animation.content;

import _m_j.o0O0o000;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;

public class GradientStrokeContent extends BaseStrokeContent {
    private final RectF boundsRect = new RectF();
    private final int cacheSteps;
    private final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
    private final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
    private final o0O0o000<LinearGradient> linearGradientCache = new o0O0o000<>();
    private final String name;
    private final o0O0o000<RadialGradient> radialGradientCache = new o0O0o000<>();
    private final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
    private final GradientType type;

    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientStroke gradientStroke) {
        super(lottieDrawable, baseLayer, gradientStroke.getCapType().toPaintCap(), gradientStroke.getJoinType().toPaintJoin(), gradientStroke.getMiterLimit(), gradientStroke.getOpacity(), gradientStroke.getWidth(), gradientStroke.getLineDashPattern(), gradientStroke.getDashOffset());
        this.name = gradientStroke.getName();
        this.type = gradientStroke.getGradientType();
        this.cacheSteps = (int) (lottieDrawable.getComposition().getDuration() / 32.0f);
        this.colorAnimation = gradientStroke.getGradientColor().createAnimation();
        this.colorAnimation.addUpdateListener(this);
        baseLayer.addAnimation(this.colorAnimation);
        this.startPointAnimation = gradientStroke.getStartPoint().createAnimation();
        this.startPointAnimation.addUpdateListener(this);
        baseLayer.addAnimation(this.startPointAnimation);
        this.endPointAnimation = gradientStroke.getEndPoint().createAnimation();
        this.endPointAnimation.addUpdateListener(this);
        baseLayer.addAnimation(this.endPointAnimation);
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        getBounds(this.boundsRect, matrix);
        if (this.type == GradientType.Linear) {
            this.paint.setShader(getLinearGradient());
        } else {
            this.paint.setShader(getRadialGradient());
        }
        super.draw(canvas, matrix, i);
    }

    public String getName() {
        return this.name;
    }

    private LinearGradient getLinearGradient() {
        long gradientHash = (long) getGradientHash();
        LinearGradient O000000o2 = this.linearGradientCache.O000000o(gradientHash, null);
        if (O000000o2 != null) {
            return O000000o2;
        }
        PointF value = this.startPointAnimation.getValue();
        PointF value2 = this.endPointAnimation.getValue();
        GradientColor value3 = this.colorAnimation.getValue();
        LinearGradient linearGradient = new LinearGradient((float) ((int) (this.boundsRect.left + (this.boundsRect.width() / 2.0f) + value.x)), (float) ((int) (this.boundsRect.top + (this.boundsRect.height() / 2.0f) + value.y)), (float) ((int) (this.boundsRect.left + (this.boundsRect.width() / 2.0f) + value2.x)), (float) ((int) (this.boundsRect.top + (this.boundsRect.height() / 2.0f) + value2.y)), value3.getColors(), value3.getPositions(), Shader.TileMode.CLAMP);
        this.linearGradientCache.O00000Oo(gradientHash, linearGradient);
        return linearGradient;
    }

    private RadialGradient getRadialGradient() {
        long gradientHash = (long) getGradientHash();
        RadialGradient O000000o2 = this.radialGradientCache.O000000o(gradientHash, null);
        if (O000000o2 != null) {
            return O000000o2;
        }
        PointF value = this.startPointAnimation.getValue();
        PointF value2 = this.endPointAnimation.getValue();
        GradientColor value3 = this.colorAnimation.getValue();
        int[] colors = value3.getColors();
        float[] positions = value3.getPositions();
        int width = (int) (this.boundsRect.left + (this.boundsRect.width() / 2.0f) + value.x);
        int height = (int) (this.boundsRect.top + (this.boundsRect.height() / 2.0f) + value.y);
        RadialGradient radialGradient = new RadialGradient((float) width, (float) height, (float) Math.hypot((double) (((int) ((this.boundsRect.left + (this.boundsRect.width() / 2.0f)) + value2.x)) - width), (double) (((int) ((this.boundsRect.top + (this.boundsRect.height() / 2.0f)) + value2.y)) - height)), colors, positions, Shader.TileMode.CLAMP);
        this.radialGradientCache.O00000Oo(gradientHash, radialGradient);
        return radialGradient;
    }

    private int getGradientHash() {
        int round = Math.round(this.startPointAnimation.getProgress() * ((float) this.cacheSteps));
        int round2 = Math.round(this.endPointAnimation.getProgress() * ((float) this.cacheSteps));
        int round3 = Math.round(this.colorAnimation.getProgress() * ((float) this.cacheSteps));
        int i = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }
}
