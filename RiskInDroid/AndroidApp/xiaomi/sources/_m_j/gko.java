package _m_j;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;

public final class gko extends gkp {
    private AnimationDrawable O0000o0;
    private int O0000o0O = 0;

    public gko(AnimationDrawable animationDrawable) {
        this.O0000o0 = animationDrawable;
        this.f17945O000000o = ((BitmapDrawable) this.O0000o0.getFrame(0)).getBitmap();
        for (int i = 0; i < this.O0000o0.getNumberOfFrames(); i++) {
            this.O0000o0O += this.O0000o0.getDuration(i);
        }
    }

    public final boolean O000000o(long j) {
        boolean O000000o2 = super.O000000o(j);
        if (O000000o2) {
            long j2 = 0;
            long j3 = j - this.O0000Ooo;
            int i = 0;
            if (j3 > ((long) this.O0000o0O)) {
                if (this.O0000o0.isOneShot()) {
                    return false;
                }
                j3 %= (long) this.O0000o0O;
            }
            while (true) {
                if (i >= this.O0000o0.getNumberOfFrames()) {
                    break;
                }
                j2 += (long) this.O0000o0.getDuration(i);
                if (j2 > j3) {
                    this.f17945O000000o = ((BitmapDrawable) this.O0000o0.getFrame(i)).getBitmap();
                    break;
                }
                i++;
            }
        }
        return O000000o2;
    }
}
