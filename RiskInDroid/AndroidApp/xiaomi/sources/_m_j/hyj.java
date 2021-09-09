package _m_j;

import android.graphics.Color;
import com.xiaomi.smarthome.application.CommonApplication;

public abstract class hyj {
    public static final hyj O00000Oo = new hyj() {
        /* class _m_j.hyj.AnonymousClass1 */

        public final int O000000o(int i) {
            return O00000o0.O000000o((((int) (((float) Color.alpha(i)) * 0.8f)) << 24) | (16777215 & i));
        }
    };
    public static final hyj O00000o = new hyj() {
        /* class _m_j.hyj.AnonymousClass3 */

        public final int O000000o(int i) {
            return i;
        }
    };
    public static final hyj O00000o0 = new hyj() {
        /* class _m_j.hyj.AnonymousClass2 */

        public final int O000000o(int i) {
            if ((CommonApplication.getAppContext().getResources().getConfiguration().uiMode & 48) == 32) {
                return O00000oo.O000000o(i);
            }
            return O00000o.O000000o(i);
        }
    };
    public static final hyj O00000oO = new hyj() {
        /* class _m_j.hyj.AnonymousClass4 */

        public final int O000000o(int i) {
            int i2 = i & 16777215;
            int i3 = 14388749;
            if (3324608 == i2) {
                i3 = 2468271;
            } else if (2468271 == i2) {
                i3 = 1411984;
            } else if (16006961 == i2) {
                i3 = 14231321;
            } else if (13974578 == i2) {
                i3 = 11938080;
            } else if (16098851 != i2) {
                if (14388749 == i2) {
                    i3 = 12744960;
                } else if (886015 == i2) {
                    i3 = 29158;
                } else if (8752369 == i2) {
                    i3 = 6712793;
                } else {
                    if (16777215 != i2) {
                        int red = Color.red(i);
                        if (Math.abs(red - Color.green(i)) < 3 && Math.abs(red - Color.blue(i)) < 3) {
                            if (51 > red) {
                                i3 = 15132390;
                            } else if (76 > red) {
                                i3 = 13421772;
                            } else if (102 >= red) {
                                i3 = 11776947;
                            } else if (127 > red) {
                                i3 = 10066329;
                            } else if (153 > red) {
                                i3 = 8421504;
                            } else if (230 > red) {
                                i3 = 6710886;
                            } else if (255 > red) {
                                i3 = 3355443;
                            }
                        }
                    }
                    i3 = 0;
                }
            }
            return (Color.alpha(i) << 24) | i3;
        }
    };
    public static final hyj O00000oo = new hyj() {
        /* class _m_j.hyj.AnonymousClass5 */

        public final int O000000o(int i) {
            int red = Color.red(i);
            if (Math.abs(red - Color.green(i)) >= 3 || Math.abs(red - Color.blue(i)) >= 3) {
                int[] iArr = {Color.red(i), Color.green(i), Color.blue(i)};
                int i2 = iArr[0];
                float f = (float) i2;
                float f2 = (float) iArr[1];
                float f3 = (float) iArr[2];
                iArr[0] = Math.max(Math.min((int) ((0.299f * f) + (0.587f * f2) + (0.114f * f3)), 255), 0);
                iArr[1] = Math.max(Math.min((int) (((-0.1687f * f) - (0.3313f * f2)) + (f3 * 0.5f) + 128.0f), 255), 0);
                iArr[2] = Math.max(Math.min((int) ((((f * 0.5f) - (f2 * 0.4187f)) - (f3 * 0.0813f)) + 128.0f), 255), 0);
                iArr[0] = (int) (((float) iArr[0]) * 0.8f);
                int i3 = iArr[0];
                int i4 = iArr[1];
                float f4 = (float) i3;
                float f5 = (float) (iArr[2] - 128);
                float f6 = (float) (i4 - 128);
                iArr[0] = Math.max(Math.min((int) ((1.402f * f5) + f4), 255), 0);
                iArr[1] = Math.max(Math.min((int) ((f4 - (0.34414f * f6)) - (f5 * 0.71414f)), 255), 0);
                iArr[2] = Math.max(Math.min((int) (f4 + (f6 * 1.772f)), 255), 0);
                return Color.argb(Color.alpha(i), iArr[0], iArr[1], iArr[2]);
            }
            int i5 = (int) (255.0f - (((float) red) * 0.7f));
            return Color.argb(Color.alpha(i), i5, i5, i5);
        }
    };
    public static final hyj O0000O0o = new hyj() {
        /* class _m_j.hyj.AnonymousClass6 */

        public final int O000000o(int i) {
            int[] iArr = {Color.red(i), Color.green(i), Color.blue(i)};
            float[] fArr = new float[3];
            Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
            fArr[1] = fArr[1] + 0.08f;
            fArr[2] = fArr[2] - 0.1f;
            return Color.HSVToColor(fArr);
        }
    };

    public abstract int O000000o(int i);
}
