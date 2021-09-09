package com.google.android.material.shape;

public final class OffsetEdgeTreatment extends EdgeTreatment {
    private final float offset;
    private final EdgeTreatment other;

    public OffsetEdgeTreatment(EdgeTreatment edgeTreatment, float f) {
        this.other = edgeTreatment;
        this.offset = f;
    }

    public final void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        this.other.getEdgePath(f, f2 - this.offset, f3, shapePath);
    }

    /* access modifiers changed from: package-private */
    public final boolean forceIntersection() {
        return this.other.forceIntersection();
    }
}
