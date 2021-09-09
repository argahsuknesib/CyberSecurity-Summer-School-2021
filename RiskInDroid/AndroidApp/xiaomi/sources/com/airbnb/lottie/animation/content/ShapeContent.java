package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import java.util.List;

public class ShapeContent implements PathContent, BaseKeyframeAnimation.AnimationListener {
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path = new Path();
    private final BaseKeyframeAnimation<?, Path> shapeAnimation;
    private TrimPathContent trimPath;

    public ShapeContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, ShapePath shapePath) {
        this.name = shapePath.getName();
        this.lottieDrawable = lottieDrawable2;
        this.shapeAnimation = shapePath.getShapePath().createAnimation();
        baseLayer.addAnimation(this.shapeAnimation);
        this.shapeAnimation.addUpdateListener(this);
    }

    public void onValueChanged() {
        invalidate();
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.getType() == ShapeTrimPath.Type.Simultaneously) {
                    this.trimPath = trimPathContent;
                    this.trimPath.addListener(this);
                }
            }
        }
    }

    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.shapeAnimation.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        Utils.applyTrimPathIfNeeded(this.path, this.trimPath);
        this.isPathValid = true;
        return this.path;
    }

    public String getName() {
        return this.name;
    }
}
