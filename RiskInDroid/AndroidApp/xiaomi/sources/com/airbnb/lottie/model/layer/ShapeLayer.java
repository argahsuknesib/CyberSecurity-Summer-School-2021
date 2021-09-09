package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.Collections;
import java.util.List;

public class ShapeLayer extends BaseLayer {
    private final ContentGroup contentGroup;

    ShapeLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.contentGroup = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer.getShapes()));
        this.contentGroup.setContents(Collections.emptyList(), Collections.emptyList());
    }

    /* access modifiers changed from: package-private */
    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
        this.contentGroup.draw(canvas, matrix, i);
    }

    public void getBounds(RectF rectF, Matrix matrix) {
        super.getBounds(rectF, matrix);
        this.contentGroup.getBounds(rectF, this.boundsMatrix);
    }

    /* access modifiers changed from: protected */
    public void resolveChildKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        this.contentGroup.resolveKeyPath(keyPath, i, list, keyPath2);
    }
}
