package _m_j;

import android.graphics.Color;
import java.util.Arrays;

public class hdv {
    private static final String O0000O0o = "hdv";

    /* renamed from: O000000o  reason: collision with root package name */
    public int f18823O000000o;
    public int O00000Oo;
    public boolean O00000o;
    public int O00000o0;
    public boolean O00000oO;
    public hbx O00000oo;
    private String O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private boolean O0000OoO;
    private boolean O0000Ooo;
    private int O0000o;
    private String O0000o0;
    private String O0000o00;
    private int O0000o0O;
    private int[] O0000o0o;
    private int O0000oO;
    private int O0000oO0;
    private boolean O0000oOO;
    private int O0000oOo;
    private int O0000oo0;

    private hdv(String str, int i, int i2, int i3, int i4, boolean z) {
        this.O0000Ooo = false;
        if (!str.equals("off") && !str.equals("on")) {
            str = "off";
        }
        if (!(i == 2 || i == 1 || i == 3)) {
            i = 2;
        }
        i2 = (i2 < 0 || i2 > 100) ? 100 : i2;
        i3 = (i3 < 1700 || i3 > 6500) ? 4000 : i3;
        this.O0000OOo = str;
        this.O0000Oo0 = i;
        this.f18823O000000o = i2;
        this.O00000o0 = i3;
        this.O0000Oo = i4;
        this.O0000oO0 = 0;
        this.O0000oO = 0;
        this.O00000o = z;
    }

    public hdv(String str, int i, int i2, int i3, int i4, boolean z, byte b) {
        this(str, i, i2, i3, i4, z);
    }

    public final boolean O000000o() {
        return !"on".equalsIgnoreCase(this.O0000OOo);
    }

    public final int O00000Oo() {
        int i = this.O0000Oo0;
        if (i == 3) {
            return 1;
        }
        return i;
    }

    public final int O00000o0() {
        if (this.O0000Oo0 != 3) {
            float[] fArr = new float[3];
            Color.colorToHSV(this.O0000Oo, fArr);
            fArr[2] = hem.O000000o(this.f18823O000000o);
            return Color.HSVToColor(fArr);
        }
        return Color.HSVToColor(new float[]{(float) this.O0000oO0, ((float) this.O0000oO) / 100.0f, hem.O000000o(this.f18823O000000o)});
    }

    public boolean equals(Object obj) {
        hbx hbx;
        hdv hdv = (hdv) obj;
        if (O00000Oo() != hdv.O00000Oo() || Math.abs(this.f18823O000000o - hdv.f18823O000000o) > 3 || Math.abs(this.O00000o0 - hdv.O00000o0) > 3) {
            return false;
        }
        if ((O000000o() && !hdv.O000000o()) || (!O000000o() && hdv.O000000o())) {
            return false;
        }
        if ((this.O00000o && !hdv.O00000o) || (!this.O00000o && hdv.O00000o)) {
            return false;
        }
        if ((this.O00000o && (hbx = this.O00000oo) != null && !hbx.equals(hdv.O00000oo)) || this.O00000oO != hdv.O00000oO) {
            return false;
        }
        if (this.O0000Oo == 0 || O00000o0() == hdv.O00000o0()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "LightState{mPower='" + this.O0000OOo + '\'' + ", mMode=" + this.O0000Oo0 + ", mBright=" + this.f18823O000000o + ", mNLBright=" + this.O00000Oo + ", mCt=" + this.O00000o0 + ", mRgb=" + this.O0000Oo + ", mIsFlowing=" + this.O00000o + ", bNightMode=" + this.O00000oO + ", bEnableNightTime=" + this.O0000OoO + ", bMiBandSleepEnabled=" + this.O0000Ooo + ", mNightLightStart='" + this.O0000o00 + '\'' + ", mNightLightEnd='" + this.O0000o0 + '\'' + ", mNightLightDelay=" + this.O0000o0O + ", mColors=" + Arrays.toString(this.O0000o0o) + ", mFlow=" + this.O00000oo + ", mDelayTime=" + this.O0000o + ", mHue=" + this.O0000oO0 + ", mSat=" + this.O0000oO + ", isPdoEnable=" + this.O0000oOO + ", mWorkTime=" + this.O0000oOo + ", mRestTime=" + this.O0000oo0 + '}';
    }
}
