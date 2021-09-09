package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class RepeaterContent implements DrawingContent, GreedyContent, KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {
    private ContentGroup contentGroup;
    private final BaseKeyframeAnimation<Float, Float> copies;
    private final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix = new Matrix();
    private final String name;
    private final BaseKeyframeAnimation<Float, Float> offset;
    private final Path path = new Path();
    private final TransformKeyframeAnimation transform;

    public RepeaterContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, Repeater repeater) {
        this.lottieDrawable = lottieDrawable2;
        this.layer = baseLayer;
        this.name = repeater.getName();
        this.copies = repeater.getCopies().createAnimation();
        baseLayer.addAnimation(this.copies);
        this.copies.addUpdateListener(this);
        this.offset = repeater.getOffset().createAnimation();
        baseLayer.addAnimation(this.offset);
        this.offset.addUpdateListener(this);
        this.transform = repeater.getTransform().createAnimation();
        this.transform.addAnimationsToLayer(baseLayer);
        this.transform.addListener(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0005 A[LOOP:0: B:3:0x0005->B:6:0x000f, LOOP_START] */
    public void absorbContent(ListIterator<Content> listIterator) {
        if (this.contentGroup == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.contentGroup = new ContentGroup(this.lottieDrawable, this.layer, "Repeater", arrayList, null);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setContents(List<Content> list, List<Content> list2) {
        this.contentGroup.setContents(list, list2);
    }

    public Path getPath() {
        Path path2 = this.contentGroup.getPath();
        this.path.reset();
        float floatValue = this.copies.getValue().floatValue();
        float floatValue2 = this.offset.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.transform.getMatrixForRepeater(((float) i) + floatValue2));
            this.path.addPath(path2, this.matrix);
        }
        return this.path;
    }

    public void draw(Canvas canvas, Matrix matrix2, int i) {
        float floatValue = this.copies.getValue().floatValue();
        float floatValue2 = this.offset.getValue().floatValue();
        float floatValue3 = this.transform.getStartOpacity().getValue().floatValue() / 100.0f;
        float floatValue4 = this.transform.getEndOpacity().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix2);
            float f = (float) i2;
            this.matrix.preConcat(this.transform.getMatrixForRepeater(f + floatValue2));
            this.contentGroup.draw(canvas, this.matrix, (int) (((float) i) * MiscUtils.lerp(floatValue3, floatValue4, f / floatValue)));
        }
    }

    public void getBounds(RectF rectF, Matrix matrix2) {
        this.contentGroup.getBounds(rectF, matrix2);
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (!this.transform.applyValueCallback(t, lottieValueCallback)) {
            if (t == LottieProperty.REPEATER_COPIES) {
                this.copies.setValueCallback(lottieValueCallback);
            } else if (t == LottieProperty.REPEATER_OFFSET) {
                this.offset.setValueCallback(lottieValueCallback);
            }
        }
    }
}
