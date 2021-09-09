package _m_j;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;

public final class hfh extends hfi {
    private AnimationDrawable O0000oOo;
    private int O0000oo0 = 0;

    public hfh(AnimationDrawable animationDrawable) {
        this.O0000oOo = animationDrawable;
        this.f18859O000000o = ((BitmapDrawable) this.O0000oOo.getFrame(0)).getBitmap();
        for (int i = 0; i < this.O0000oOo.getNumberOfFrames(); i++) {
            this.O0000oo0 += this.O0000oOo.getDuration(i);
        }
    }

    public final boolean O000000o(long j) {
        boolean O000000o2 = super.O000000o(j);
        if (O000000o2) {
            long j2 = 0;
            long j3 = j - this.O0000oO;
            int i = 0;
            if (j3 > ((long) this.O0000oo0)) {
                if (this.O0000oOo.isOneShot()) {
                    return false;
                }
                j3 %= (long) this.O0000oo0;
            }
            while (true) {
                if (i >= this.O0000oOo.getNumberOfFrames()) {
                    break;
                }
                j2 += (long) this.O0000oOo.getDuration(i);
                if (j2 > j3) {
                    this.f18859O000000o = ((BitmapDrawable) this.O0000oOo.getFrame(i)).getBitmap();
                    break;
                }
                i++;
            }
        }
        return O000000o2;
    }
}
