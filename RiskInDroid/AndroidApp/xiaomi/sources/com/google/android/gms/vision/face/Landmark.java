package com.google.android.gms.vision.face;

import android.graphics.PointF;

public final class Landmark {
    private final PointF zzbd;
    private final int zzbu;

    public Landmark(PointF pointF, int i) {
        this.zzbd = pointF;
        this.zzbu = i;
    }

    public final PointF getPosition() {
        return this.zzbd;
    }

    public final int getType() {
        return this.zzbu;
    }
}
