package com.facebook.react.uimanager;

import android.support.v4.app.NotificationCompat;
import com.facebook.yoga.YogaConstants;
import java.util.Arrays;

public class Spacing {
    private static final int[] sFlagsMap = {1, 2, 4, 8, 16, 32, 64, NotificationCompat.FLAG_HIGH_PRIORITY, 256};
    private final float mDefaultValue;
    private boolean mHasAliasesSet;
    private final float[] mSpacing;
    private int mValueFlags;

    public Spacing() {
        this(0.0f);
    }

    public Spacing(float f) {
        this.mValueFlags = 0;
        this.mDefaultValue = f;
        this.mSpacing = newFullSpacingArray();
    }

    public Spacing(Spacing spacing) {
        this.mValueFlags = 0;
        this.mDefaultValue = spacing.mDefaultValue;
        float[] fArr = spacing.mSpacing;
        this.mSpacing = Arrays.copyOf(fArr, fArr.length);
        this.mValueFlags = spacing.mValueFlags;
        this.mHasAliasesSet = spacing.mHasAliasesSet;
    }

    public boolean set(int i, float f) {
        boolean z = false;
        if (FloatUtil.floatsEqual(this.mSpacing[i], f)) {
            return false;
        }
        this.mSpacing[i] = f;
        if (YogaConstants.isUndefined(f)) {
            this.mValueFlags = (sFlagsMap[i] ^ -1) & this.mValueFlags;
        } else {
            this.mValueFlags = sFlagsMap[i] | this.mValueFlags;
        }
        int i2 = this.mValueFlags;
        int[] iArr = sFlagsMap;
        if (!((iArr[8] & i2) == 0 && (iArr[7] & i2) == 0 && (i2 & iArr[6]) == 0)) {
            z = true;
        }
        this.mHasAliasesSet = z;
        return true;
    }

    public float get(int i) {
        float f = (i == 4 || i == 5) ? Float.NaN : this.mDefaultValue;
        int i2 = this.mValueFlags;
        if (i2 == 0) {
            return f;
        }
        if ((i2 & sFlagsMap[i]) != 0) {
            return this.mSpacing[i];
        }
        if (this.mHasAliasesSet) {
            char c = (i == 1 || i == 3) ? (char) 7 : 6;
            int i3 = this.mValueFlags;
            int[] iArr = sFlagsMap;
            if ((iArr[c] & i3) != 0) {
                return this.mSpacing[c];
            }
            if ((i3 & iArr[8]) != 0) {
                return this.mSpacing[8];
            }
        }
        return f;
    }

    public float getRaw(int i) {
        return this.mSpacing[i];
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(float[], float):void}
     arg types: [float[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void} */
    public void reset() {
        Arrays.fill(this.mSpacing, Float.NaN);
        this.mHasAliasesSet = false;
        this.mValueFlags = 0;
    }

    /* access modifiers changed from: package-private */
    public float getWithFallback(int i, int i2) {
        return (this.mValueFlags & sFlagsMap[i]) != 0 ? this.mSpacing[i] : get(i2);
    }

    private static float[] newFullSpacingArray() {
        return new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
    }
}
