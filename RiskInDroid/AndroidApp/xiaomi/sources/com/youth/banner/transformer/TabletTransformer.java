package com.youth.banner.transformer;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;

public class TabletTransformer extends ABaseTransformer {
    private static final Camera OFFSET_CAMERA = new Camera();
    private static final Matrix OFFSET_MATRIX = new Matrix();
    private static final float[] OFFSET_TEMP_FLOAT = new float[2];

    /* access modifiers changed from: protected */
    public void onTransform(View view, float f) {
        float abs = (f < 0.0f ? 30.0f : -30.0f) * Math.abs(f);
        view.setTranslationX(getOffsetXForRotation(abs, view.getWidth(), view.getHeight()));
        view.setPivotX(((float) view.getWidth()) * 0.5f);
        view.setPivotY(0.0f);
        view.setRotationY(abs);
    }

    protected static final float getOffsetXForRotation(float f, int i, int i2) {
        OFFSET_MATRIX.reset();
        OFFSET_CAMERA.save();
        OFFSET_CAMERA.rotateY(Math.abs(f));
        OFFSET_CAMERA.getMatrix(OFFSET_MATRIX);
        OFFSET_CAMERA.restore();
        OFFSET_MATRIX.preTranslate(((float) (-i)) * 0.5f, ((float) (-i2)) * 0.5f);
        float f2 = (float) i;
        float f3 = (float) i2;
        OFFSET_MATRIX.postTranslate(f2 * 0.5f, 0.5f * f3);
        float[] fArr = OFFSET_TEMP_FLOAT;
        fArr[0] = f2;
        fArr[1] = f3;
        OFFSET_MATRIX.mapPoints(fArr);
        return (f2 - OFFSET_TEMP_FLOAT[0]) * (f > 0.0f ? 1.0f : -1.0f);
    }
}
