package com.airbnb.lottie.value;

public class ScaleXY {
    private final float scaleX;
    private final float scaleY;

    public ScaleXY(float f, float f2) {
        this.scaleX = f;
        this.scaleY = f2;
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public String toString() {
        return getScaleX() + "x" + getScaleY();
    }
}
