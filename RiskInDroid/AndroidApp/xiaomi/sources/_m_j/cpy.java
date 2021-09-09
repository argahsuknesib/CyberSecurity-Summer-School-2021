package _m_j;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

public final class cpy {

    /* renamed from: O000000o  reason: collision with root package name */
    public final OrientationEventListener f14220O000000o;
    public final O000000o O00000Oo;
    public int O00000o = -1;
    public int O00000o0 = -1;

    public interface O000000o {
        void O000000o(int i);
    }

    public cpy(Context context, O000000o o000000o) {
        this.O00000Oo = o000000o;
        this.f14220O000000o = new OrientationEventListener(context.getApplicationContext()) {
            /* class _m_j.cpy.AnonymousClass1 */

            public final void onOrientationChanged(int i) {
                int i2 = 0;
                if (i != -1 && i < 315 && i >= 45) {
                    if (i >= 45 && i < 135) {
                        i2 = 90;
                    } else if (i >= 135 && i < 225) {
                        i2 = 180;
                    } else if (i >= 225 && i < 315) {
                        i2 = 270;
                    }
                }
                if (i2 != cpy.this.O00000o0) {
                    cpy cpy = cpy.this;
                    cpy.O00000o0 = i2;
                    cpy.O00000Oo.O000000o(cpy.this.O00000o0);
                }
            }
        };
    }

    public final void O000000o(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 0) {
            this.O00000o = 0;
        } else if (rotation == 1) {
            this.O00000o = 90;
        } else if (rotation == 2) {
            this.O00000o = 180;
        } else if (rotation != 3) {
            this.O00000o = 0;
        } else {
            this.O00000o = 270;
        }
        this.f14220O000000o.enable();
    }
}
