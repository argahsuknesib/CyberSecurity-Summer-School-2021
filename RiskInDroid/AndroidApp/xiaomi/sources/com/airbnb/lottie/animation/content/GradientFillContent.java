package com.airbnb.lottie.animation.content;

import _m_j.o0O0o000;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class GradientFillContent implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener {
    private final RectF boundsRect = new RectF();
    private final int cacheSteps;
    private final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
    private final BaseLayer layer;
    private final o0O0o000<LinearGradient> linearGradientCache = new o0O0o000<>();
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
    private final Paint paint = new Paint(1);
    private final Path path = new Path();
    private final List<PathContent> paths = new ArrayList();
    private final o0O0o000<RadialGradient> radialGradientCache = new o0O0o000<>();
    private final Matrix shaderMatrix = new Matrix();
    private final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
    private final GradientType type;

    public GradientFillContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, GradientFill gradientFill) {
        this.layer = baseLayer;
        this.name = gradientFill.getName();
        this.lottieDrawable = lottieDrawable2;
        this.type = gradientFill.getGradientType();
        this.path.setFillType(gradientFill.getFillType());
        this.cacheSteps = (int) (lottieDrawable2.getComposition().getDuration() / 32.0f);
        this.colorAnimation = gradientFill.getGradientColor().createAnimation();
        this.colorAnimation.addUpdateListener(this);
        baseLayer.addAnimation(this.colorAnimation);
        this.opacityAnimation = gradientFill.getOpacity().createAnimation();
        this.opacityAnimation.addUpdateListener(this);
        baseLayer.addAnimation(this.opacityAnimation);
        this.startPointAnimation = gradientFill.getStartPoint().createAnimation();
        this.startPointAnimation.addUpdateListener(this);
        baseLayer.addAnimation(this.startPointAnimation);
        this.endPointAnimation = gradientFill.getEndPoint().createAnimation();
        this.endPointAnimation.addUpdateListener(this);
        baseLayer.addAnimation(this.endPointAnimation);
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content content = list2.get(i);
            if (content instanceof PathContent) {
                this.paths.add((PathContent) content);
            }
        }
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        Shader shader;
        L.beginSection("GradientFillContent#draw");
        this.path.reset();
        for (int i2 = 0; i2 < this.paths.size(); i2++) {
            this.path.addPath(this.paths.get(i2).getPath(), matrix);
        }
        this.path.computeBounds(this.boundsRect, false);
        if (this.type == GradientType.Linear) {
            shader = getLinearGradient();
        } else {
            shader = getRadialGradient();
        }
        this.shaderMatrix.set(matrix);
        shader.setLocalMatrix(this.shaderMatrix);
        this.paint.setShader(shader);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        this.paint.setAlpha(MiscUtils.clamp((int) ((((((float) i) / 255.0f) * ((float) this.opacityAnimation.getValue().intValue())) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.path, this.paint);
        L.endSection("GradientFillContent#draw");
    }

    public void getBounds(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.paths.size(); i++) {
            this.path.addPath(this.paths.get(i).getPath(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
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
        LinearGradient linearGradient = new LinearGradient(value.x, value.y, value2.x, value2.y, value3.getColors(), value3.getPositions(), Shader.TileMode.CLAMP);
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
        float f = value.x;
        float f2 = value.y;
        RadialGradient radialGradient = new RadialGradient(f, f2, (float) Math.hypot((double) (value2.x - f), (double) (value2.y - f2)), colors, positions, Shader.TileMode.CLAMP);
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

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t != LottieProperty.COLOR_FILTER) {
            return;
        }
        if (lottieValueCallback == null) {
            this.colorFilterAnimation = null;
            return;
        }
        this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
        this.colorFilterAnimation.addUpdateListener(this);
        this.layer.addAnimation(this.colorFilterAnimation);
    }
}
