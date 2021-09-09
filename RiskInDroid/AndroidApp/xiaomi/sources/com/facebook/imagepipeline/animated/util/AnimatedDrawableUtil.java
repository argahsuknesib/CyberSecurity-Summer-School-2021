package com.facebook.imagepipeline.animated.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import java.util.Arrays;

public class AnimatedDrawableUtil {
    public static boolean isOutsideRange(int i, int i2, int i3) {
        if (i == -1 || i2 == -1) {
            return true;
        }
        if (i <= i2) {
            return i3 < i || i3 > i2;
        }
        if (i3 >= i || i3 <= i2) {
            return false;
        }
    }

    public void fixFrameDurations(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] < 11) {
                iArr[i] = 100;
            }
        }
    }

    public int getTotalDurationFromFrameDurations(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    public int[] getFrameTimeStampsFromDurations(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = i;
            i += iArr[i2];
        }
        return iArr2;
    }

    public int getFrameForTimestampMs(int[] iArr, int i) {
        int binarySearch = Arrays.binarySearch(iArr, i);
        return binarySearch < 0 ? ((-binarySearch) - 1) - 1 : binarySearch;
    }

    @SuppressLint({"NewApi"})
    public int getSizeOfBitmap(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            return bitmap.getAllocationByteCount();
        }
        if (Build.VERSION.SDK_INT >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getWidth() * bitmap.getHeight() * 4;
    }
}
