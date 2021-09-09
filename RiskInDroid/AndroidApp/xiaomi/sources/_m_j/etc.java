package _m_j;

import _m_j.etg;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Message;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.Objects;
import java.util.concurrent.Semaphore;

public abstract class etc implements etg, Handler.Callback {

    /* renamed from: O000000o  reason: collision with root package name */
    protected etg.O000000o f15789O000000o;
    protected Semaphore O00000Oo;
    protected SurfaceTexture O00000o;
    protected eth O00000o0;
    protected int O00000oO;
    protected O000000o O00000oo;
    protected O000000o O0000O0o;
    protected RectF O0000OOo;
    protected boolean O0000Oo;
    protected Handler O0000Oo0;

    public boolean O000000o() {
        return false;
    }

    public final void O000000o(int i, int i2) {
        this.O0000O0o = new O000000o(i, i2);
        gsy.O000000o(3, "BaseCameraScanner", getClass().getName() + ".setPreviewSize() mPreviewSize = " + this.O0000O0o.toString());
    }

    public final void O000000o(SurfaceTexture surfaceTexture) {
        this.O00000o = surfaceTexture;
    }

    public final void O000000o(eth eth) {
        this.O00000o0 = eth;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public final void O000000o(Rect rect) {
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        gsy.O000000o(3, "BaseCameraScanner", getClass().getName() + ".setFrameRect() mOrientation = " + this.O00000oO + " frameRect = " + i + "-" + i2 + "-" + i3 + "-" + i4);
        if (this.O0000O0o != null) {
            if (this.O0000OOo == null) {
                this.O0000OOo = new RectF();
            }
            if (i >= i3 || i2 >= i4) {
                this.O0000OOo.setEmpty();
                return;
            }
            int i5 = this.O0000O0o.f15790O000000o;
            int i6 = this.O0000O0o.O00000Oo;
            int i7 = this.O00000oo.f15790O000000o;
            int i8 = this.O00000oo.O00000Oo;
            if (this.O00000oO % 2 != 0) {
                int i9 = i8;
                i8 = i7;
                i7 = i9;
            }
            float f = i5 * i7 < i8 * i6 ? (((float) i7) * 1.0f) / ((float) i6) : (((float) i8) * 1.0f) / ((float) i5);
            float f2 = (float) i8;
            float max = Math.max(0.0f, Math.min(1.0f, (((float) i) * f) / f2));
            float max2 = Math.max(0.0f, Math.min(1.0f, (((float) i3) * f) / f2));
            float f3 = (float) i7;
            float max3 = Math.max(0.0f, Math.min(1.0f, (((float) i2) * f) / f3));
            float max4 = Math.max(0.0f, Math.min(1.0f, (f * ((float) i4)) / f3));
            int i10 = this.O00000oO;
            if (i10 == 0) {
                this.O0000OOo.set(max3, 1.0f - max2, max4, 1.0f - max);
            } else if (i10 == 1) {
                this.O0000OOo.set(max, max3, max2, max4);
            } else if (i10 == 2) {
                this.O0000OOo.set(1.0f - max4, max, 1.0f - max3, max2);
            } else if (i10 == 3) {
                this.O0000OOo.set(1.0f - max2, 1.0f - max4, 1.0f - max, 1.0f - max3);
            }
            gsy.O000000o(3, "BaseCameraScanner", getClass().getName() + ".setFrameRect() mClipRectRatio = " + this.O0000OOo);
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(byte[] bArr, int i, int i2) {
        gsy.O000000o(LogType.CAMERA, "BaseCameraScanner", String.format("decodePreviewFrame %d:%d", Integer.valueOf(i), Integer.valueOf(i2)));
        eth eth = this.O00000o0;
        if (eth != null) {
            eth.O000000o(bArr, i, i2, this.O0000OOo);
        }
        if (this.O0000Oo && this.f15789O000000o != null) {
            int i3 = i * i2;
            int max = Math.max(1, i3 / 100);
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6 += max) {
                i4 += bArr[i6] & 239;
                i5++;
            }
            Handler handler = this.O0000Oo0;
            if (handler != null) {
                handler.sendMessage(handler.obtainMessage(90001, i4, i5));
            }
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f15790O000000o;
        final int O00000Oo;

        public O000000o(int i, int i2) {
            this.f15790O000000o = i;
            this.O00000Oo = i2;
        }

        public final boolean equals(Object obj) {
            if (obj != null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof O000000o) {
                    O000000o o000000o = (O000000o) obj;
                    return this.f15790O000000o == o000000o.f15790O000000o && this.O00000Oo == o000000o.O00000Oo;
                }
            }
        }

        public final int hashCode() {
            return Objects.hash(Integer.valueOf(this.f15790O000000o), Integer.valueOf(this.O00000Oo));
        }

        public final String toString() {
            return this.f15790O000000o + "x" + this.O00000Oo;
        }
    }

    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i != 70001) {
            if (i != 90001) {
                switch (i) {
                    case 80001:
                    case 80003:
                    case 80004:
                        O00000Oo();
                        etg.O000000o o000000o = this.f15789O000000o;
                        if (o000000o == null) {
                            return true;
                        }
                        o000000o.O000000o();
                        return true;
                    case 80002:
                        O00000Oo();
                        return true;
                    case 80005:
                        O00000Oo();
                        etg.O000000o o000000o2 = this.f15789O000000o;
                        return true;
                    case 80006:
                        O00000Oo();
                        return true;
                    default:
                        return true;
                }
            } else if (this.f15789O000000o == null || message.arg2 == 0) {
                return true;
            } else {
                int i2 = message.arg1;
                int i3 = message.arg2;
                return true;
            }
        } else if (this.f15789O000000o == null) {
            return true;
        } else {
            if (O000000o()) {
                this.f15789O000000o.O000000o(this.O00000oo.O00000Oo, this.O00000oo.f15790O000000o, ((4 - this.O00000oO) % 4) * 90);
                return true;
            }
            this.f15789O000000o.O000000o(this.O00000oo.f15790O000000o, this.O00000oo.O00000Oo, ((5 - this.O00000oO) % 4) * 90);
            return true;
        }
    }
}
