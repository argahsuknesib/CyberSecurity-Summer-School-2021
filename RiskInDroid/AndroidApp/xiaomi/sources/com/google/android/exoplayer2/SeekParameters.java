package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class SeekParameters {
    public static final SeekParameters CLOSEST_SYNC = new SeekParameters(Long.MAX_VALUE, Long.MAX_VALUE);
    public static final SeekParameters DEFAULT = EXACT;
    public static final SeekParameters EXACT = new SeekParameters(0, 0);
    public static final SeekParameters NEXT_SYNC = new SeekParameters(0, Long.MAX_VALUE);
    public static final SeekParameters PREVIOUS_SYNC = new SeekParameters(Long.MAX_VALUE, 0);
    public final long toleranceAfterUs;
    public final long toleranceBeforeUs;

    public SeekParameters(long j, long j2) {
        boolean z = true;
        Assertions.checkArgument(j >= 0);
        Assertions.checkArgument(j2 < 0 ? false : z);
        this.toleranceBeforeUs = j;
        this.toleranceAfterUs = j2;
    }

    public final long resolveSeekPositionUs(long j, long j2, long j3) {
        if (this.toleranceBeforeUs == 0 && this.toleranceAfterUs == 0) {
            return j;
        }
        long j4 = j;
        long subtractWithOverflowDefault = Util.subtractWithOverflowDefault(j4, this.toleranceBeforeUs, Long.MIN_VALUE);
        long addWithOverflowDefault = Util.addWithOverflowDefault(j4, this.toleranceAfterUs, Long.MAX_VALUE);
        boolean z = true;
        boolean z2 = subtractWithOverflowDefault <= j2 && j2 <= addWithOverflowDefault;
        if (subtractWithOverflowDefault > j3 || j3 > addWithOverflowDefault) {
            z = false;
        }
        if (z2 && z) {
            return Math.abs(j2 - j) <= Math.abs(j3 - j) ? j2 : j3;
        }
        if (z2) {
            return j2;
        }
        return z ? j3 : subtractWithOverflowDefault;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SeekParameters seekParameters = (SeekParameters) obj;
            return this.toleranceBeforeUs == seekParameters.toleranceBeforeUs && this.toleranceAfterUs == seekParameters.toleranceAfterUs;
        }
    }

    public final int hashCode() {
        return (((int) this.toleranceBeforeUs) * 31) + ((int) this.toleranceAfterUs);
    }
}
