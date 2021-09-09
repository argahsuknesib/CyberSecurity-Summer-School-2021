package com.facebook.drawee.drawable;

public interface Rounded {
    int getBorderColor();

    float getBorderWidth();

    float getPadding();

    float[] getRadii();

    boolean getScaleDownInsideBorders();

    boolean isCircle();

    void setBorder(int i, float f);

    void setCircle(boolean z);

    void setPadding(float f);

    void setRadii(float[] fArr);

    void setRadius(float f);

    void setScaleDownInsideBorders(boolean z);
}
