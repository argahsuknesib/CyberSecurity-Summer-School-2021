package _m_j;

import android.graphics.Matrix;
import android.graphics.RectF;

public final class bar {
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00fc  */
    public static Matrix O000000o(RectF rectF, RectF rectF2, String str, int i) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        RectF rectF3 = rectF;
        RectF rectF4 = rectF2;
        double d6 = (double) rectF3.left;
        double d7 = (double) rectF3.top;
        double width = (double) rectF.width();
        double height = (double) rectF.height();
        double d8 = (double) rectF4.left;
        double d9 = (double) rectF4.top;
        double width2 = (double) rectF2.width();
        double height2 = (double) rectF2.height();
        Double.isNaN(width2);
        Double.isNaN(width);
        double d10 = d9;
        double d11 = width2 / width;
        Double.isNaN(height2);
        Double.isNaN(height);
        double d12 = width;
        double d13 = height2 / height;
        Double.isNaN(d6);
        Double.isNaN(d8);
        double d14 = d8 - (d6 * d11);
        Double.isNaN(d7);
        Double.isNaN(d10);
        double d15 = d10 - (d7 * d13);
        double d16 = height2;
        int i2 = i;
        if (i2 == 2) {
            d3 = Math.min(d11, d13);
            if (d3 > 1.0d) {
                Double.isNaN(width2);
                Double.isNaN(d12);
                d4 = 2.0d;
                d2 = d14 - (((width2 / d3) - d12) / 2.0d);
                Double.isNaN(d16);
                Double.isNaN(height);
                d5 = (d16 / d3) - height;
            } else {
                d4 = 2.0d;
                Double.isNaN(d12);
                Double.isNaN(width2);
                d2 = d14 - ((width2 - (d12 * d3)) / 2.0d);
                Double.isNaN(height);
                Double.isNaN(d16);
                d5 = d16 - (height * d3);
            }
            d15 -= d5 / d4;
            d = d3;
        } else {
            String str2 = str;
            if (!str2.equals("none") && i2 == 0) {
                d = Math.min(d11, d13);
            } else if (str2.equals("none") || i2 != 1) {
                d3 = d11;
                d = d13;
                if (str2.contains("xMid")) {
                    Double.isNaN(d12);
                    Double.isNaN(width2);
                    d14 += (width2 - (d12 * d3)) / 2.0d;
                }
                if (str2.contains("xMax")) {
                    Double.isNaN(d12);
                    Double.isNaN(width2);
                    d14 += width2 - (d12 * d3);
                }
                if (str2.contains("YMid")) {
                    Double.isNaN(height);
                    Double.isNaN(d16);
                    d15 += (d16 - (height * d)) / 2.0d;
                }
                if (str2.contains("YMax")) {
                    Double.isNaN(height);
                    Double.isNaN(d16);
                    d15 += d16 - (height * d);
                }
            } else {
                d = Math.max(d11, d13);
            }
            d3 = d;
            if (str2.contains("xMid")) {
            }
            if (str2.contains("xMax")) {
            }
            if (str2.contains("YMid")) {
            }
            if (str2.contains("YMax")) {
            }
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((float) d2, (float) d15);
        matrix.preScale((float) d3, (float) d);
        return matrix;
    }
}
