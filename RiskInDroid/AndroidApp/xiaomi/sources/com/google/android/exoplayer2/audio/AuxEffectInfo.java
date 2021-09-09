package com.google.android.exoplayer2.audio;

public final class AuxEffectInfo {
    public final int effectId;
    public final float sendLevel;

    public AuxEffectInfo(int i, float f) {
        this.effectId = i;
        this.sendLevel = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AuxEffectInfo auxEffectInfo = (AuxEffectInfo) obj;
            return this.effectId == auxEffectInfo.effectId && Float.compare(auxEffectInfo.sendLevel, this.sendLevel) == 0;
        }
    }

    public final int hashCode() {
        return ((this.effectId + 527) * 31) + Float.floatToIntBits(this.sendLevel);
    }
}
