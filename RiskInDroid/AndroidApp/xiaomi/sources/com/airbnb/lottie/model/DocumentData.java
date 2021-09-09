package com.airbnb.lottie.model;

public class DocumentData {
    public final double baselineShift;
    public final int color;
    public final String fontName;
    final int justification;
    final double lineHeight;
    public final double size;
    public final int strokeColor;
    public final boolean strokeOverFill;
    public final double strokeWidth;
    public final String text;
    public final int tracking;

    public DocumentData(String str, String str2, double d, int i, int i2, double d2, double d3, int i3, int i4, double d4, boolean z) {
        this.text = str;
        this.fontName = str2;
        this.size = d;
        this.justification = i;
        this.tracking = i2;
        this.lineHeight = d2;
        this.baselineShift = d3;
        this.color = i3;
        this.strokeColor = i4;
        this.strokeWidth = d4;
        this.strokeOverFill = z;
    }

    public int hashCode() {
        double hashCode = (double) (((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31);
        double d = this.size;
        Double.isNaN(hashCode);
        int i = (((((int) (hashCode + d)) * 31) + this.justification) * 31) + this.tracking;
        long doubleToLongBits = Double.doubleToLongBits(this.lineHeight);
        return (((i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
